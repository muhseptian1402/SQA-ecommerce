package com.juaracoding.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
private WebDriver driver;
  private By byUsername = By.id("user-name");
  private By byPassword = By.id("password");
  private By byButtonLogin = By.id("login-button");
  private By byErrorMessage = By.cssSelector("[data-test='error']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void fillUsername(String username) {
    driver.findElement(byUsername).sendKeys(username);
  }

  public void fillPassword(String password) {
    driver.findElement(byPassword).sendKeys(password);
  }

  public void clickButtonLogin() {
    driver.findElement(byButtonLogin).click();
  }

  public String getErrorMessage() {
    return driver.findElement(byErrorMessage).getText();
  }
}
