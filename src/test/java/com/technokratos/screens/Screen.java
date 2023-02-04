package com.technokratos.screens;

import com.technokratos.screens.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Screen extends BaseScreen {
  public Screen(AppiumDriver driver) {
    super(driver);
  }
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Войти через Госуслуги\"]")
  @AndroidFindBy(id = "signInEsiaButton")
  private WebElement signInEsiaButton;

  public void signInEsiaButtonClick(){
    signInEsiaButton.click();
  }
}
