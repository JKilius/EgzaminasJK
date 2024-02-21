package lt.techin.PageTests;

import lt.techin.AccountPage;
import lt.techin.LogInPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountPageTest extends BasePageTest{

    LogInPage logInPage;
    AccountPage accountPage;

    @Test
    void successfulLogOut(){
        logInPage = new LogInPage(driver);
        accountPage = new AccountPage(driver);

        String userName = "testas1";
        String userPassword = "testas1";

        logInPage.inputUserName(userName);
        logInPage.inputPassword(userPassword);
        logInPage.clickButtonLogIn();

        assertTrue(accountPage.isThereLogOutAction());

        accountPage.clickLinkLogOut();

        assertEquals("Prisijungimas",logInPage.getPageName());
        assertTrue(logInPage.isLogOutMessageCorrect());

    }
}
