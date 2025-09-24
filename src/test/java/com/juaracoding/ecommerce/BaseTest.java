package com.juaracoding.ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTest {
private WebDriver driver;

  protected WebDriver getDriver() {
    return driver;
  }

  @BeforeMethod
  @Parameters ("baseURL")
  public void setup (String baseURL) {
    driver = new ChromeDriver();
    driver.get(baseURL);
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }
}
