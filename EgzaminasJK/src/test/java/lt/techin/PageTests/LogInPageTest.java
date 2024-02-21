package lt.techin.PageTests;

import lt.techin.AccountPage;
import lt.techin.LogInPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogInPageTest extends BasePageTest{

    LogInPage mainPage;

    AccountPage accountPage;



    @Test
    void successfullLoginToAccount(){
        mainPage = new LogInPage(driver);
        accountPage = new AccountPage(driver);

        String userName = "testas1";
        String userPassword = "testas1";

        mainPage.setInputUserName(userName);
        mainPage.setInputPassword(userPassword);
        mainPage.clickButtonLogIn();

        assertTrue(accountPage.isThereLogOutAction());
        assertTrue(accountPage.isUserNameCorrect(userName));
        assertEquals(userName, accountPage.getUserName(), "Incorrect user name. Should be: " + userName);

    }

    @Test
    void unsuccessfulLoginToAccount(){
        mainPage = new LogInPage(driver);
        accountPage = new AccountPage(driver);

        String userName = "testas123";
        String userPassword = "testas123";
        String message = mainPage.getMessageUnsuccessfulLogIn();

        mainPage.setInputUserName(userName);
        mainPage.setInputPassword(userPassword);
        mainPage.clickButtonLogIn();

        assertTrue(mainPage.isThereUnsuccessfulLogInMessage());
        assertEquals(message, mainPage.getMessageUnsuccessfulLogIn(), "Incorrect message. Should be: " + message);

    }
}
