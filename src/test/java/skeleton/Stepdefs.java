package skeleton;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.zh_cn.假设;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import cucumber.api.java8.Zh_cn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.WaitElement;

public class Stepdefs implements Zh_cn {
    private WebDriver driver;
    private WaitElement waitElement;

    @Before
    public void beforeScenario() {
        // 使用 Chrome 浏览器，制定 driver 的位置
        String currentPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        // 设置 Chrome 浏览的配置参数
        // 关闭 Chrome 正受自动测试软件的控制。infobars
        options.addArguments("disable-infobars", "--start-maximized");
        driver = new ChromeDriver(options);
        waitElement = new WaitElement(driver);
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

    @假设("^用浏览器打开网址\"([^\"]*)\"$")
    public void openBrowser(String arg1) {
        driver.get(arg1);
    }

    @当("^选择购车城市\"([^\"]*)\"$")
    public void chooseCity(String arg1) {
        //点击购车城市的下拉列表
        waitElement.waitForClick(10, By.id("cityText"));
        // 选择对应的城市
        waitElement.waitForClick(20, By.linkText(arg1));

        // 点击目标车型的下拉列表
        waitElement.waitForClick(10, By.id("cartypeText"));
    }

    @当("^选择车型\"([^\"]*)\"$")
    public void chooseCar(String arg1) {
        waitElement.waitForClick(10, By.xpath("//dd[contains(text(), '" + arg1 + "')]"));
    }

    @那么("^按钮是\"([^\"]*)\"$")
    public void buttonIsValid(String arg1) {
        if (arg1.equals("有效的")) {
            assert driver.findElement(By.id("suerBtnp_step_1")).isEnabled();
        } else if (arg1.equals("无效的")) {
            assert !driver.findElement(By.id("suerBtnp_step_1")).isEnabled();
        }
    }

//    public Stepdefs() {
//
//        // 初始化浏览器驱动
////        System.setProperty("webdriver.gecko.driver", "browserDriver/geckodriver.exe");
////        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        WaitElement waitElement = new WaitElement(driver);
//
//        假设("^我用浏览器打开网址\"([^\"]*)\"$", (String arg1) -> {
//            driver.get(arg1);
//            driver.manage().window().maximize();
//        });
//
//        当("^我选择购车城市\"([^\"]*)\"$", (String arg1) -> {
//            // 点击购车城市的下拉列表
//            waitElement.waitForClick(10, By.id("cityText"));
//            // 选择对应的城市
//            waitElement.waitForClick(10, By.linkText(arg1));
//
//            // 点击目标车型的下拉列表
//            waitElement.waitForClick(10, By.id("cartypeText"));
//        });
//
//        当("^我选择车型\"([^\"]*)\"$", (String arg1) -> {
//            waitElement.waitForClick(10, By.xpath("//dd[contains(text(), '" + arg1 + "')]"));
//        });
//
//        那么("^按钮是\"([^\"]*)\"$", (String arg1) -> {
//            if (arg1.equals("有效的")) {
//                assert driver.findElement(By.id("suerBtnp_step_1")).isEnabled();
//            } else if (arg1.equals("无效的")) {
//                assert !driver.findElement(By.id("suerBtnp_step_1")).isEnabled();
//            }
//        });
//    }
}
