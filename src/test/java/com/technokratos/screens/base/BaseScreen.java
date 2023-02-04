package com.technokratos.screens.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class BaseScreen {
  protected AppiumDriver driver;

  public BaseScreen (AppiumDriver driver){
    super();
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

}
