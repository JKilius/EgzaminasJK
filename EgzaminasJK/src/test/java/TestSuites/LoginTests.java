package TestSuites;

import lt.techin.PageTests.BasePageTest;
import lt.techin.PageTests.LogInPageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

public class LoginTests {

    @Suite
    @SelectClasses({LogInPageTest.class})
    public static class loginTests{

    }
}
