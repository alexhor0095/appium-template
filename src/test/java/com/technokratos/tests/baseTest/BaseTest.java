package com.technokratos.tests.baseTest;

import com.technokratos.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
  protected static AppiumDriver driver;
  private static DriverManager driverManager = new DriverManager();

  @BeforeAll
  public static void setUp(){
    driverManager.startAppiumServer();
    driver = driverManager.getDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
  }

  @AfterAll
  public static void tearDown(){
    if (driver != null) {
      driver.quit();
    }
    driverManager.stopAppiumServer();
  }
}
