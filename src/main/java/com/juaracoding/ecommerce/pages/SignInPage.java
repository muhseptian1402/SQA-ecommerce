package com.juaracoding.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

  @FindBy(id = "user-name")
  private WebElement username;

  @FindBy(id = "password")
  private WebElement password;

  @FindBy(id="login-button")
  private WebElement buttonLogin;

  @FindBy(css = "[data-test='error']")
  private WebElement errorMessage;

  public SignInPage(WebDriver driver) {
    this.driver = driver;

    PageFactory.initElements(this.driver, this);
  }

  public void fillUsername(String username) {
    this.username.sendKeys(username);
  }

  public void fillPassword(String password) {
    this.password.sendKeys(password);
  }

  public void clickButtonLogin() {
    buttonLogin.click();
  }

  public String getErrorMessage() {
    return errorMessage.getText();
  }

}
