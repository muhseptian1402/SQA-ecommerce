package com.juaracoding.ecommerce.authentications;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecommerce.BaseTest;
import com.juaracoding.ecommerce.pages.LoginPage;

public class SignInTest extends BaseTest{
  @Test
  public void withoutCredentialsTest() {
    LoginPage loginPage = new LoginPage(getDriver());
    loginPage.clickButtonLogin();

    String expected = "Epic sadface: Username is required";
    Assert.assertEquals(loginPage.getErrorMessage(), expected);
  }

  @Test
  public void withEmptyPasswordTest() {
    LoginPage loginPage = new LoginPage(getDriver());

    loginPage.fillUsername("standard_user");
    loginPage.clickButtonLogin();

    String expected = "Epic sadface: Password is required";

    Assert.assertEquals(loginPage.getErrorMessage(), expected);

  }

  @Test()
  public void signInTest() throws InterruptedException {
    LoginPage loginPage = new LoginPage(getDriver());

    loginPage.fillUsername("standard_user");
    loginPage.fillPassword("secret_sauce");
    loginPage.clickButtonLogin();

    String actual = getDriver().getCurrentUrl();
    String expected = "https://www.saucedemo.com/v1/inventory.html";

    Assert.assertEquals(actual, expected);
  }

  @Test(enabled = false)
  public void withEmptyUsernameTest() {

  }

}