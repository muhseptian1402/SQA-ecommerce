package com.juaracoding.ecommerce.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecommerce.BaseTest;

public class SignInTest extends BaseTest{
  @Test
  public void withoutCredentialsTest() {
    WebElement button = getDriver().findElement(By.id("login-button"));
    button.click();

    WebElement errorElement = getDriver().findElement(By.cssSelector("[data-test='error']"));
    String actual = errorElement.getText();
    String expected = "Epic sadface: Username is required";

    Assert.assertEquals(actual, expected);
  }

  @Test
  public void withEmptyPasswordTest() {
    WebElement button = getDriver().findElement(By.id("login-button"));
    WebElement usernameField = getDriver().findElement(By.id("user-name"));

    usernameField.sendKeys("standard_user");
    button.click();

    WebElement errorElement = getDriver().findElement(By.cssSelector("[data-test='error']"));
    String actual = errorElement.getText();
    String expected = "Epic sadface: Password is required";

    Assert.assertEquals(actual, expected);

  }

  @Test()
  public void signInTest() throws InterruptedException {
    WebElement usernameField = getDriver().findElement(By.id("user-name"));
    WebElement passwordField = getDriver().findElement(By.id("password"));
    WebElement button = getDriver().findElement(By.id("login-button"));

    usernameField.sendKeys("standard_user");
    passwordField.sendKeys("secret_sauce");
    button.click();

    String actual = getDriver().getCurrentUrl();
    String expected = "https://www.saucedemo.com/v1/inventory.html";

    Assert.assertEquals(actual, expected);
  }

  @Test(enabled = false)
  public void withEmptyUsernameTest() {

  }

}