package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sunguolei on 2017/6/8.
 * 判断元素加载成功
 * 等待元素加载成功再点击
 */
public class WaitElement {
    private WebDriver driver;

    public WaitElement(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void waitForClick(int time, By element) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
