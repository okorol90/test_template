package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShoot {

    private static WebDriver driver;

    public ScreenShoot(WebDriver driver) {
        this.driver = driver;
    }

    public static void makeScreenShoot(ITestResult result) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        Path currentRelativePath = Paths.get("");
        try {
            FileUtils.copyFile(src, new File(currentRelativePath.toAbsolutePath() + "\\screenshots\\"
                    + result.getTestClass().getName().replace(".", "\\\\")
                    + "\\" + result.getMethod().getConstructorOrMethod().getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
