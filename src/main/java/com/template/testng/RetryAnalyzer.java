package com.template.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int counter = 0;

    @Override
    public boolean retry(ITestResult result) {

        int retryLimit = 1;
        if (counter < retryLimit) {
            result.getTestContext().getFailedTests().removeResult(result);
            counter++;
            return true;
        }
        return false;
    }
}