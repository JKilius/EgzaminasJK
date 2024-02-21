package lt.techin.PageTests;

import lt.techin.AccountPage;
import lt.techin.LogInPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogInPageTest extends BasePageTest{

    LogInPage logInPage;

    AccountPage accountPage;



    @Test
    void successfullLoginToAccount(){
        logInPage = new LogInPage(driver);
        accountPage = new AccountPage(driver);

        String userName = "testas1";
        String userPassword = "testas1";

        logInPage.inputUserName(userName);
        logInPage.inputPassword(userPassword);
        logInPage.clickButtonLogIn();

        assertTrue(accountPage.isThereLogOutAction());
        assertTrue(accountPage.isUserNameCorrect(userName));
        assertEquals(userName, accountPage.getUserName(), "Incorrect user name. Should be: " + userName);

    }

    @Test
    void unsuccessfulLoginToAccount(){
        logInPage = new LogInPage(driver);
        accountPage = new AccountPage(driver);

        String userName = "testas123";
        String userPassword = "testas123";
        String message = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

        logInPage.inputUserName(userName);
        logInPage.inputPassword(userPassword);
        logInPage.clickButtonLogIn();

        assertTrue(logInPage.isThereUnsuccessfulLogInMessage());
        assertEquals(message, logInPage.getMessageUnsuccessfulLogIn(), "Incorrect message. Should be: " + message);

    }
}
