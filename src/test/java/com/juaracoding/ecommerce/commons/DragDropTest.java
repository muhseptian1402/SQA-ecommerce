package com.juaracoding.ecommerce.commons;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.ecommerce.BaseTest;
import com.juaracoding.ecommerce.pages.DragDropPage;

public class DragDropTest extends BaseTest {
 
   @Test
  @Parameters({"bgBefore", "bgAfter"})
  public void dragDropTest(String bgBefore, String bgAfter) {

    DragDropPage dragDropPage = new DragDropPage(getDriver());
    // dragDropPage.debugChange();
    System.out.println(dragDropPage.getBackgroundColor());
    Assert.assertEquals(dragDropPage.getBackgroundColor(), bgBefore);
    Assert.assertEquals(dragDropPage.getLabel(), "Drop Here");
    dragDropPage.dragAndDrop();
    Assert.assertEquals(dragDropPage.getBackgroundColor(), bgAfter);
    Assert.assertEquals(dragDropPage.getLabel(), "Dropped!");
  }

   @Test
  public void scrollTest() {
    DragDropPage dragDropPage = new DragDropPage(getDriver());
    dragDropPage.scrollDown(600);
    }
}
