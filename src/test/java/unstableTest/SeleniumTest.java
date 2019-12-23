package unstableTest;

import org.junit.Assert;
import org.junit.Test;


public class SeleniumTest extends Rerun {


    private static int attempt = 1;


    @Test
    @UnstableTest(count = 2)
    public void randomlyFailingTest() {
        if (attempt == 2) {
            attempt = 1;

        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }
}
