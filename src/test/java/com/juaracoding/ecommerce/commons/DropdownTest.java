package com.juaracoding.ecommerce.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
private WebDriver driver;
private int limit = 20;

  @BeforeMethod
  public void beforeMethod() {
    driver = new ChromeDriver();
    driver.get("https://demo.guru99.com/test/newtours/register.php");
  }

  @Test
    public void selectByVisibleNameTest() {
    Select select = new Select(driver.findElement(By.name("country")));
    select.selectByVisibleText("INDONESIA");
    WebElement selectedOption = select.getFirstSelectedOption();
    Assert.assertEquals(selectedOption.getText(), selectedOption.getAttribute("value"));
    Assert.assertEquals(selectedOption.getText(), "INDONESIA");
    Assert.assertEquals(selectedOption.getAttribute("value"), "INDONESIA");
  }

  @Test
  public void selectAllCountryTest() {
    Select select = new Select(driver.findElement(By.name("country")));
    List<WebElement> options = select.getOptions();

    for (WebElement option: options) {
       int count = 1;

        if (count == limit) {
        break;
      } else {
          String expectedVisibleText = option.getText();
          select.selectByVisibleText(expectedVisibleText);
          WebElement selectedOption = select.getFirstSelectedOption();
          Assert.assertEquals(selectedOption.getText(), selectedOption.getAttribute("value"));
          Assert.assertEquals(selectedOption.getText(), expectedVisibleText);
          Assert.assertEquals(selectedOption.getAttribute("value"), expectedVisibleText);
          count++;
      }
    }
  }
  
   @Test
  public void selectAllCountryWithSampleTest() {
    List<String> dataSamples = new ArrayList<String>(Arrays.asList(
      "ALBANIA",
      "INDONESIA",
      "ANGOLA",
      "AUSTRALIA",
      "PARAGUAY",
      "AMERICAN SAMOA"
    ));

    Select select = new Select(driver.findElement(By.name("country")));

    for (String dataSample: dataSamples) {
      select.selectByVisibleText(dataSample);
      WebElement selectedOption = select.getFirstSelectedOption();
      Assert.assertEquals(selectedOption.getText(), selectedOption.getAttribute("value"));
      Assert.assertEquals(selectedOption.getText(), dataSample);
      Assert.assertEquals(selectedOption.getAttribute("value"), dataSample);
    }
  }

  @AfterMethod
  public void afterMethod() {   
    driver.quit();
  }
}
