package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountCreationPage extends BasePage{

    @FindBy(xpath = "//form/h2[contains(text(), 'Naujos paskyros sukūrimas')]")
    WebElement textPageName;

    @FindBy(xpath = "//input[@id='username']")
    WebElement inputNewUserName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputNewPassword;

    @FindBy(xpath = "//input[@id='passwordConfirm']")
    WebElement inputPasswordConfirm;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonCreateAccount;
    public NewAccountCreationPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName(){
        return textPageName.getText();
    }

    public void setInputNewUserName(String newUserName){
        inputNewUserName.sendKeys(newUserName);
    }

    public void setInputNewPassword(String newPassword){
        inputNewPassword.sendKeys(newPassword);
    }

    public void setInputPasswordConfirm(){
        inputPasswordConfirm.sendKeys();
    }

    public void clickButtonCreateAccount(){
        buttonCreateAccount.click();
    }
}
