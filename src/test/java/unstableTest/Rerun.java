package unstableTest;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


public class Rerun {

    @Rule
    public TestRule rerunRule = new TestRule() {
        public Statement apply(final Statement base,
                               final Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    int retryCount = 5;
                    for (int i = 1; i <= retryCount; i++) {
                        try {
                            base.evaluate();
                            System.out.println("Test was successful after " + i + " attempts");
                            break;
                        } catch (Throwable t) {
                            if (i == retryCount) {
                                System.out.println("Test was not successful for " + i + " attempts");
                                throw t;
                            }
                        }
                    }
                }
            };
        }
    };


}
