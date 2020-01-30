package com.example.myapplication3;


import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.FileInputStream;
import java.io.File;
import java.net.URL;
import java.util.*;
import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.junit.Assert.assertEquals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException{
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("BROWSER_NAME", "Android");
        caps.setCapability("deviceName", "Galaxy S9");
        caps.setCapability("VERSION","9.0");
        caps.setCapability("platformName","Android");
        caps.setCapability("appPackage", "com.android.settings");
        caps.setCapability("appActivity", "com.android.settings.Settings");
        caps.setCapability("noReset", "true");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        @Test
        public void Camping_PLMN_Selection()throws Exception {
            // Power on in In-Service area -> Move to No SVC area -> wait 2 min -> Move to In service
            //TC_name = "Camping_PLMN_Selection";


            WebElement conn = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'title') and @text='Connections' and @index='0']"));
            conn.click();

            Thread.sleep(2500);

            WebElement Mob = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='Mobile networks' and @index='0']"));
            Mob.click();
            Thread.sleep(2000);

            WebElement Mode = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'title') and @text='Network mode SIM 1' and @index='0']"));
            Mode.click();
            Thread.sleep(2000);


            WebElement GWL = driver.findElement(By.xpath(".//android.widget.CheckedTextView[@text='LTE/3G/2G (auto connect)' and @index='0']"));
            GWL.click();
            Thread.sleep(1500);

            //((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.HOME);

            // ((StartsActivity) driver).startActivity(pckg2, act2);

            // ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_MULTIPLY);
            WebElement hash =driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='#' and @index='0']"));
            hash.click();

            WebElement zero = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='0' and @index='0']"));
            zero.click();
            zero.click();
            WebElement one = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='1' and @index='1']"));
            one.click();
            one.click();
            hash.click();
            Thread.sleep(1000);

            WebElement stack = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='[1] STACK 1' and @index='0']"));
            stack.click();
            Thread.sleep(1000);
            WebElement LTE = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='LTE-BASIC Info' and @index='0']"));
            //WebElement WCDMA = driver.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='WCDMA (2100)' and @index='0']"));
            //try {
            //if(!driver.findElements(By.xpath(".//android.widget.TextView[contains(@resource-id,'id') and @text='WCDMA (2100)' and @index='0']")).isEmpty()) {

            //	System.out.println("3G Osama !!");
            //}


            driver.closeApp();




        }
}
