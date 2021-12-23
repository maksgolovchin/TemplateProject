package com.template.testng;

import com.template.steps.vendorSteps.LoginSteps;
import com.template.webdriver.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.template.props.Properties.props;

public class BaseTest {

    private WebDriverManager driverManager;

    private LoginSteps steps;

    private void openUrlAndAddCookie(String url) {
        driverManager.getDriver().get("https://www.google.com/");
        Cookie cookie = new Cookie.Builder("analytics_opt_out", "true").domain(props.url()
                .replace("https://", "")).build();
        driverManager.getDriver().manage().addCookie(cookie);
        driverManager.getDriver().get(url);
    }

    @Step
    protected LoginSteps openLoginPage(String url) {
        openUrlAndAddCookie(url);
        return steps;
    }

    @Step
    protected LoginSteps relaunchBrowserAndOpenLoginPage(String url) {
        driverManager.stopWebDriver();
        driverManager.startWebDriver();
        steps = new LoginSteps(driverManager, driverManager.getDriver().getWindowHandle());
        openUrlAndAddCookie(url);
        return steps;
    }

    @AfterSuite(alwaysRun = true)
    public void getVersion() throws IOException {
        if (!props.environment().equals("local")) {
            driverManager = new WebDriverManager();
            driverManager.startWebDriver();
            steps = new LoginSteps(driverManager, driverManager.getDriver().getWindowHandle());
            String version = openLoginPage(props.url())
                    .getVersion();
            Capabilities caps = ((RemoteWebDriver) driverManager.getDriver()).getCapabilities();
            String browserVersion = caps.getVersion();
            String environment = "Browser=Chrome:" + browserVersion + "\n" +
                    "Application Version=" + version;
            FileOutputStream fos = new FileOutputStream("target/allure-results/environment.properties");
            fos.write(environment.getBytes());
            fos.flush();
            fos.close();
            driverManager.stopWebDriver();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void before(Method method) {
        driverManager = new WebDriverManager();
        driverManager.startWebDriver();
        steps = new LoginSteps(driverManager, driverManager.getDriver().getWindowHandle());
    }

    @AfterMethod(alwaysRun = true)
    public void after(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus() | ITestResult.SKIP == result.getStatus()) {
            System.out.println("Test " + result.getName() + " was failed");
            driverManager.makeScreenshot();
            if (props.browserName().equals("chrome")) {
                consoleLog();
            }
        }
        try {
            if (props.environment().equals("remote"))
                attachToMainLog(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverManager.stopWebDriver();
    }

    public void attachToMainLog(String testMethod) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd : hh:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        File logs = new File("target/logs.log");
        LogEntries logEntries = driverManager.getDriver().manage().logs().get(LogType.BROWSER);
        if (!logs.exists())
            logs.createNewFile();
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(logs, true));
        if (!logEntries.getAll().isEmpty()) {
            writer.append("TestID[").append(testMethod).append("] DateTime[").append(dateTime.format(formatter)).append("]:\n");
            writer.append(logEntries.getAll().stream().map(LogEntry::getMessage).collect(Collectors.toList()).toString().replace(",", "\n")).append("\n\n");
        }

        writer.close();
    }


    @Attachment
    public List<String> consoleLog() {
        LogEntries logEntries = driverManager.getDriver().manage().logs().get(LogType.BROWSER);
        return logEntries.getAll().stream().map(LogEntry::getMessage).collect(Collectors.toList());
    }
}
