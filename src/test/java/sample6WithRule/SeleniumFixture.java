package sample6WithRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFixture {

    protected static WebDriver driver;

    @ClassRule
    public static ExternalResource driverRule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("Starting a browser");
            System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        };

        @Override
        protected void after() {
            System.out.println("Stopping the browser");
            if (driver != null) {
                driver.quit();
            }
        };
    };

    @Rule
    public ExternalResource extractDriverRule = new ExternalResource(){
        @Override
        protected  void before() throws Throwable{
            System.out.println("Test");
        }
    };

}
