package sample7WithRule;

import org.junit.Test;
import org.openqa.selenium.By;

public class SeleniumTest extends SeleniumFixture {

    @Test
    public void test1() {
        System.out.println(driver.findElements(By.cssSelector("div.movie_box")).size());
    }
}
