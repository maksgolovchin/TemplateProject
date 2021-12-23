package com.template.testng;

import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AnnotationTransformer implements IAnnotationTransformer, ITestListener {
    @SuppressWarnings("rawtypes")
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

    @Override
    public void onTestStart(ITestResult result) {
        List<String> multipleIssuesId = new ArrayList<>();
        String issueId = "";
        boolean status = false;
        try {
            if (result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Issues.class).value().length > 0)
                Arrays.stream(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Issues.class).value()).forEach(i -> multipleIssuesId.add(i.value()));
            if (multipleIssuesId.stream().noneMatch(i -> i.contains("Do not skip")))
                status = getIssueStatus(multipleIssuesId);
        } catch (NullPointerException ignored) {
        }
        try {
            if (!result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Issue.class).value().isEmpty())
                issueId = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Issue.class).value();
            status = getIssueStatus(Collections.singletonList(issueId));
        } catch (NullPointerException ignored) {
        }


        if (status) {
            result.setStatus(3);
            throw new SkipException("Issue still open");
        }
    }


    public boolean getIssueStatus(List<String> issuesID) {
        boolean stillOpen = false;
        for (String issueID : issuesID) {
            boolean issueStatus;
            issueStatus = getResponseOfIssue("https://gitlab.com/api/v4/projects/24349635", issueID.replaceAll(".*\\/", ""));
            if (issueStatus) {
                stillOpen = true;
                break;
            }
        }
        return stillOpen;
    }

    private boolean getResponseOfIssue(String url, String issueId) {
        RestAssured.baseURI = url;
        JsonPath json = given()
                .header(new Header("PRIVATE-TOKEN", "token"))
                .get("/issues/" + issueId)
                .getBody()
                .jsonPath();
        return json.get("state").equals("opened");
    }
}