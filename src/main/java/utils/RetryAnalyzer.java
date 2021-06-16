package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int stop = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter<stop){
            counter++;
            return true;
        }
        return false;
    }
}
