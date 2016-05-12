package ross.feehan.com.facebooklogin; /*
 * Created by Ross Feehan on 11/05/2016.
 */

/**
 * Runs all unit tests in the project
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ross.feehan.com.facebooklogin.Features.FacebookLoginLogicImplTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
        FacebookLoginLogicImplTest.class
})
public class AllUnitTests {
}
