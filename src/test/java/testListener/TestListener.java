package testListener;

import base.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test Started: " + result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Passed: " + result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        BaseClass base = (BaseClass) result.getInstance();
        base.takeScreenshot(result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }
    @Override
    public void onFinish(org.testng.ITestContext context) {
        System.out.println("All Tests Finished!");
    }
}
