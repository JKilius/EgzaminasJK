package lt.techin.PageTests;

import lt.techin.AccountPage;
import lt.techin.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends BasePageTest{

    MainPage mainPage;

    AccountPage accountPage;



    @Test
    void successfullLoginToAccount(){
        mainPage = new MainPage(driver);
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
        
    }
}
