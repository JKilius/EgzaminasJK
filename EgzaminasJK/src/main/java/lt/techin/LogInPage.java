package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    @FindBy(xpath = "//h3[@class='form-heading']")
    WebElement textPageName;

//    @FindBy(xpath = "//input[name= 'username']")
//    WebElement inputUserName;

    @FindBy(xpath = "/html//form[@action='/prisijungti']//input[@name='username']")
    WebElement inputUserName;

//    @FindBy(xpath = "//input[name= 'password']")
//    WebElement inputPassword;

    @FindBy(xpath = "/html//form[@action='/prisijungti']//input[@name='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonLogIn;

    @FindBy(xpath = "//a[@href='/registruoti']")
    WebElement linkCreateNewAccount;

    @FindBy(xpath = "//span[contains(text(), 'Sėkmingai atsijungėte')]")
    WebElement messageSuccessfulLogOut;

    @FindBy(xpath = "//form/div/span[2]")
    WebElement messageUnsuccessfulLogIn;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName(){
       return textPageName.getText();
    }

    public void inputUserName(String userName){
        inputUserName.sendKeys(userName);
    }

    public void inputPassword(String userPassword){
        inputPassword.sendKeys(userPassword);
    }

    public void clickButtonLogIn(){
        buttonLogIn.click();
    }

    public void clickLinkCreateNewAccount(){
        linkCreateNewAccount.click();
    }

    public String getMessageOfSuccessfulLogOut(){
        return messageSuccessfulLogOut.getText();
    }

    public boolean isLogOutMessageCorrect(){
        return getMessageOfSuccessfulLogOut().contains("Sėkmingai atsijungėte");
    }

    public String getMessageUnsuccessfulLogIn(){
        return messageUnsuccessfulLogIn.getText();
    }

    public boolean isThereUnsuccessfulLogInMessage(){
        return messageUnsuccessfulLogIn.isDisplayed();
    }
}
