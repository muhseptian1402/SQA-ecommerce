package com.juaracoding.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
  private WebDriver driver;
  private By byDraggable = By.id("draggable");
  private By byDroppable = By.id("droppable");
  private Actions builder;
  private JavascriptExecutor jse;

  public DragDropPage(WebDriver driver) {
    this.driver = driver;
    builder = new Actions(driver);
    jse = (JavascriptExecutor) driver;
  }

  public void debugChange() {
    jse.executeScript("document.querySelector('#droppable').style.backgroundColor='#ff9590'");
  }

  public void dragAndDrop() {
    WebElement draggable = driver.findElement(byDraggable);
    WebElement droppable = driver.findElement(byDroppable);

    builder.dragAndDrop(draggable, droppable).perform();
  }

  public String getBackgroundColor() {
    return driver.findElement(byDroppable).getCssValue("background");
  }

  public String getColor() {
    return "rgb(51, 51, 51) = #33 33 33";
  }

  public String getLabel() {
    return driver.findElement(byDroppable).getText();
  }

  public void scrollDown(int push) {
    jse.executeScript("scroll({top: "+ push +", behavior: 'smooth'})");
  }
}
