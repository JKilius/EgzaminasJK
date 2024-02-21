package TestSuites;

import lt.techin.NewAccountCreationPage;
import lt.techin.PageTests.BasePageTest;
import lt.techin.PageTests.NewAccountCreationPageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

public class AccountCreationTests {

    @Suite
    @SelectClasses({BasePageTest.class, NewAccountCreationPageTest.class})
    public static class accountCreationTests{

    }
}
