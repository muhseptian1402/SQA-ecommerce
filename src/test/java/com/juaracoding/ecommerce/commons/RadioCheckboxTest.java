package com.juaracoding.ecommerce.commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioCheckboxTest {
private WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    driver = new ChromeDriver();
    driver.get("https://demo.guru99.com/test/radio.html");
  }

  @Test
  public void radioButtonTest() {
    WebElement option02 = driver.findElement(By.id("vfb-7-2"));
    option02.click();
    Assert.assertTrue(option02.isSelected());
  }

    @Test
    public void radioButtonsTest() {
    List<WebElement> options = driver.findElements(By.xpath("//input[@type='radio']"));
    Assert.assertEquals(options.size(), 3);

    for (WebElement option: options) {
      option.click();
      Assert.assertTrue(option.isSelected());
    }
  }

    @Test
    public void checkBoxTest(){
        WebElement checkBox = driver.findElement(By.id("vfb-6-2") );
            
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());

        checkBox.click();
        Assert.assertFalse(checkBox.isSelected());
    }

    @Test
    public void checkBoxsTest(){
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assert.assertEquals(checkBoxes.size(), 3);

    for (WebElement checkBox: checkBoxes) {
      checkBox.click();
      Assert.assertTrue(checkBox.isSelected());

      checkBox.click();
      Assert.assertFalse(checkBox.isSelected());
    }
}    

  @AfterMethod
  public void afterMethod() {
    driver.quit();
  }
}
