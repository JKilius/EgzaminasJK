package TestSuites;

import lt.techin.PageTests.AccountPageTest;
import lt.techin.PageTests.BasePageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

public class LogOutTest {

    @Suite
    @SelectClasses({BasePageTest.class, AccountPageTest.class})
    public static class logOutTest{

    }
}
