package sample7WithRule;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

final class LoginRule extends ExternalResource {

    private WebDriver driver;

    public LoginRule(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void before() throws Throwable {
        System.out.println("Login");
        driver.get("http://localhost/someApplication");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("submit")).click();
    }

    @Override
    protected void after() {
        System.out.println("Logout");
        driver.findElement(By.name("logout")).click();
    }


}
