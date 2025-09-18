package com.juaracoding.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest 
{
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
    }

    @Test
    public void signInTest() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        Thread.sleep(2000);
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(2000);
        button.click();

        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/v1/inventory.html";

        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}

