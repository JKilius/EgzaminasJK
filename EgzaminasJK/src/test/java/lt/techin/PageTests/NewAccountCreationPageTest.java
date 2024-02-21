package lt.techin.PageTests;

import lt.techin.AccountPage;
import lt.techin.BasePage;
import lt.techin.LogInPage;
import lt.techin.NewAccountCreationPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

        String newUserName = "testuotojas1+++";
        String newUserPassword = "testuotojas1+++";
        String confirmPassword = newUserPassword;

        logInPage.clickLinkCreateNewAccount();

        assertEquals("Naujos paskyros sukūrimas", newAccountCreationPage.getPageName());

        newAccountCreationPage.inputNewUserName(newUserName);
        newAccountCreationPage.inputNewPassword(newUserPassword);
        newAccountCreationPage.inputPasswordConfirm(confirmPassword);
        newAccountCreationPage.clickButtonCreateAccount();

        assertTrue(accountPage.isThereLogOutAction());
        assertEquals(newUserName, accountPage.getUserName(), "Incorrect account. User name should be: " + newUserName);

    }


    @Test
    void unsuccessfulAccountCreationNoInput(){
        logInPage = new LogInPage(driver);
        newAccountCreationPage = new NewAccountCreationPage(driver);

        String newUserName = "";
        String newUserPassword = "";
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

    @Test
    void unsuccessfulAccountCreationSameCredentials(){
        logInPage = new LogInPage(driver);
        newAccountCreationPage = new NewAccountCreationPage(driver);

        String newUserName = "testas1";
        String newUserPassword = "testas1";
        String confirmPassword = newUserPassword;

        logInPage.clickLinkCreateNewAccount();

        newAccountCreationPage.inputNewUserName(newUserName);
        newAccountCreationPage.inputNewPassword(newUserPassword);
        newAccountCreationPage.inputPasswordConfirm(confirmPassword);
        newAccountCreationPage.clickButtonCreateAccount();


        assertTrue(newAccountCreationPage.isErrorMessageUserAlreadyExists());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/logins.csv", numLinesToSkip = 1)
    void unsuccessfulLoginUsingIncorrectLoginData(String name, String password, String confirmPass, String errorMessage){
        logInPage = new LogInPage(driver);
        newAccountCreationPage = new NewAccountCreationPage(driver);

        logInPage.clickLinkCreateNewAccount();
        newAccountCreationPage.inputNewUserName(name);
        newAccountCreationPage.inputNewPassword(password);
        newAccountCreationPage.inputPasswordConfirm(confirmPass);
        newAccountCreationPage.clickButtonCreateAccount();

     //   System.out.println(newAccountCreationPage.getError());

       assertTrue(newAccountCreationPage.isErrorMessageCorrect(errorMessage), "Expected error message was not found: " + errorMessage);
    }
}
