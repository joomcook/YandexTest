package util;

import base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.TestBase;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestUtil extends TestBase {
    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/src/test/java/testcases/" + System.currentTimeMillis() + ".png"));
    }

    public String convertStringToUTF(String stringToConvert) {
        /*ByteBuffer stringToConvertByteBuffer = ByteBuffer.wrap(stringToConvert.getBytes());*/
        byte[] stringToConvertByte = stringToConvert.getBytes();
        String convertedString = new String(stringToConvertByte, StandardCharsets.UTF_8);

        /*try {
            stringToConvertByte = stringToConvert.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            stringToConvertByte = stringToConvert.getBytes();
        }*/
        System.out.println(convertedString);

        return convertedString;
    }
}
