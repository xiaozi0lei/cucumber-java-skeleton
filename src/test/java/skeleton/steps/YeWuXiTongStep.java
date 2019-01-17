package skeleton.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.zh_cn.假设;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import cucumber.api.java8.Zh_cn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import skeleton.project.yeWuXiTong.BaiDuPage;

public class YeWuXiTongStep implements Zh_cn {
    private WebDriver driver;
    private BaiDuPage baiDuPage;

    @Before
    public void beforeScenario() {
        // 使用 Chrome 浏览器，制定 driver 的位置
        String currentPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver");
        ChromeOptions options = new ChromeOptions();

        // 设置 Chrome 浏览的配置参数
        // 关闭 Chrome 正受自动测试软件的控制。infobars
        options.addArguments("disable-infobars", "--start-maximized");
        driver = new ChromeDriver(options);
        baiDuPage = new BaiDuPage(driver);
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

    @假设("^用浏览器打开网址\"([^\"]*)\"$")
    public void openBrowser(String arg1) {
        driver.get(arg1);
    }

    @当("^输入框id\"([^\"]*)\"中输入\"([^\"]*)\"查询$")
    public void 输入框id中输入查询(String id, String keyword) throws Throwable {
        baiDuPage.searchKeyWord(id, keyword);
    }

    @那么("^浏览器title显示\"([^\"]*)\"$")
    public void 浏览器title显示(String arg0) throws Throwable {
        Thread.sleep(1000);
        assert driver.getTitle().contains(arg0);
    }
}
