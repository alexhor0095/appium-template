package com.technokratos.driver;

import com.technokratos.configurations.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverManager {

  private static DriverManager instance;
  private AndroidDriver androidDriver;
  private IOSDriver iosDriver;



  private AppiumDriverLocalService service;

  private UiAutomator2Options virtualAndroidDeviseOptions = new UiAutomator2Options()
      .setDeviceName("Android Device")
      .setUdid("emulator-5554")
      .setPlatformName("android")
      .setAppPackage("ru.tstst.mysubsidie.debug")
      .setAppActivity("ru.tstst.app.launcher.presentation.LauncherActivity")
      .setAvd("Pixel_4_API_29")
      .setNoReset(false);

  private UiAutomator2Options realAndroidDeviseOptions = new UiAutomator2Options()
      .setDeviceName("Android Device")
      .setUdid("emulator-5554")
      .setPlatformName("android")
      .setAppPackage("ru.tstst.mysubsidie.debug")
      .setAppActivity("ru.tstst.app.launcher.presentation.LauncherActivity")
      .setNoReset(false);

  private XCUITestOptions xcuiTestOptions = new XCUITestOptions()
      .setPlatformName("iOs")
      .setDeviceName("iPhone 12")
      .setAutomationName("XCUITest")
      .setPlatformVersion("14.5")
      .setBundleId("ru.tstst.mysubsidie")
      .setNoReset(false);

  public void startAppiumServer() {
    service = new AppiumServiceBuilder()
        .withIPAddress("127.0.0.1")
        .usingPort(4723)
        .build();
    service.start();
  }

  private AndroidDriver getAndroidDriver(){
    if (Configuration.isVirtualDevice){
      return new AndroidDriver(service.getUrl(), virtualAndroidDeviseOptions);
    } else {
      return  new AndroidDriver(service.getUrl(), realAndroidDeviseOptions);
    }
  }

  public void stopAppiumServer(){
    service.stop();
  }

  public AppiumDriver getDriver() {
    switch (Configuration.PLATFORM){
      case IOS -> {
        return new IOSDriver(service.getUrl(), xcuiTestOptions);
      }
      case ANDROID ->{
        return getAndroidDriver();
      }
      default -> throw new RuntimeException("Incorrect platform");
    }
  }
}
