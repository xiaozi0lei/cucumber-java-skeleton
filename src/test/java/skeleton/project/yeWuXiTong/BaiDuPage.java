package skeleton.project.yeWuXiTong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitElement;

/**
 * @author GuoLei Sun
 * Date: 2019/1/17 11:46 AM
 */
public class BaiDuPage {
    private WebDriver driver;
    private WaitElement waitElement;

    public BaiDuPage(WebDriver webDriver) {
        this.driver = webDriver;
        waitElement = new WaitElement(driver);

    }

    public void searchKeyWord(String id, String keyword) {
        driver.findElement(By.id(id)).sendKeys(keyword);
        waitElement.waitForClick(10, By.id(id));
    }

}
