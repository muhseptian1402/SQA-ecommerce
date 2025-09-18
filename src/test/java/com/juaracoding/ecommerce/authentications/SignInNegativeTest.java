package com.juaracoding.ecommerce.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInNegativeTest {
  public WebDriver getDriver(String url) {
    WebDriver driver = new ChromeDriver();
    driver.get(url);

    return driver;
  }

  @Test
  public void withoutCredentialsTest() {

    WebDriver driver = getDriver("https://www.saucedemo.com/v1");
    WebElement button = driver.findElement(By.id("login-button"));
    button.click();

    WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
    String actual = errorElement.getText();
    String expected = "Epic sadface: Username is required";

    Assert.assertEquals(actual, expected);

    driver.quit();

  }

  @Test
  public void withEmptyPasswordTest() {
    WebDriver driver = getDriver("https://www.saucedemo.com/v1");

    WebElement button = driver.findElement(By.id("login-button"));
    WebElement usernameField = driver.findElement(By.id("user-name"));

    usernameField.sendKeys("standard_user");
    button.click();

    WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
    String actual = errorElement.getText();
    String expected = "Epic sadface: Password is required";

    Assert.assertEquals(actual, expected);

    driver.quit();

  }

  @Test(enabled = false)
  public void withEmptyUsernameTest() {

  }
}
