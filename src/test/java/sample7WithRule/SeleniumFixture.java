package sample7WithRule;

import org.junit.ClassRule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumFixture {

    public static WebDriverRule driver = new WebDriverRule(DesiredCapabilities.chrome());

    @ClassRule
    public static TestRule rule = RuleChain
            .outerRule(driver)
            .around(new LoginRule(driver));

}
