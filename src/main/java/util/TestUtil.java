package util;

import base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestUtil extends TestBase {
    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/src/test/java/testcases/" + System.currentTimeMillis() + ".jpg"));
    }

    public String convertStringToUTF(String stringToConvert) {
        byte[] stringToConvertByte = stringToConvert.getBytes();
        String convertedString = new String(stringToConvertByte, StandardCharsets.UTF_8);

        return convertedString;
    }
}
