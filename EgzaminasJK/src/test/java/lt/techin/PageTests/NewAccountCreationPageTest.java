package lt.techin.PageTests;

import lt.techin.AccountPage;
import lt.techin.BasePage;
import lt.techin.LogInPage;
import lt.techin.NewAccountCreationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NewAccountCreationPageTest extends BasePageTest {

    LogInPage logInPage;
    AccountPage accountPage;

    NewAccountCreationPage newAccountCreationPage;

    @Test
    void successfulNewAccountCreation(){
        logInPage = new LogInPage(driver);
        newAccountCreationPage = new NewAccountCreationPage(driver);
        accountPage = new AccountPage(driver);

        String newUserName = "testuotojas1";
        String newUserPassword = "testuotojas1";
        String confirmPassword = newUserPassword;

        logInPage.clickLinkCreateNewAccount();

        assertEquals("Naujos paskyros sukūrimas", logInPage.getPageName());

        newAccountCreationPage.inputNewUserName(newUserName);
        newAccountCreationPage.inputNewPassword(newUserPassword);
        newAccountCreationPage.inputPasswordConfirm(confirmPassword);
        newAccountCreationPage.clickButtonCreateAccount();

        assertTrue(accountPage.isThereLogOutAction());
        assertEquals(newUserName, accountPage.getUserName(), "Incorrect account. User name should be: " + newUserName);

    }

    @Test
    void unsuccessfulAccountCreationBadUserNameAndPassword(){
        logInPage = new LogInPage(driver);
        newAccountCreationPage = new NewAccountCreationPage(driver);

        String newUserName = "1";
        String newUserPassword = "1";
        String confirmPassword = newUserPassword;

        logInPage.clickLinkCreateNewAccount();

        newAccountCreationPage.inputNewUserName(newUserName);
        newAccountCreationPage.inputNewPassword(newUserPassword);
        newAccountCreationPage.inputPasswordConfirm(confirmPassword);
        newAccountCreationPage.clickButtonCreateAccount();


        assertTrue(newAccountCreationPage.isErrorMessageBadUserName());
        assertTrue(newAccountCreationPage.isErrorMessageBadPassword());

    }

    @Test
    void unsuccessfullAccountCreationBadConfirmPassword(){
        logInPage = new LogInPage(driver);
        newAccountCreationPage = new NewAccountCreationPage(driver);

        String newUserName = "testas12";
        String newUserPassword = "testas12";
        String confirmPassword = "bad";

        logInPage.clickLinkCreateNewAccount();

        newAccountCreationPage.inputNewUserName(newUserName);
        newAccountCreationPage.inputNewPassword(newUserPassword);
        newAccountCreationPage.inputPasswordConfirm(confirmPassword);
        newAccountCreationPage.clickButtonCreateAccount();


        assertTrue(newAccountCreationPage.isErrorMessageBadConfirmPassword());
    }
}