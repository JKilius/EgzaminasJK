package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(xpath = "//span[@id='username.errors']")
    WebElement messageBadUserName;

    @FindBy(xpath = "//span[@id='password.errors']")
    WebElement messageBadPassword;

    @FindBy(xpath = "//span[@id='passwordConfirm.errors']")
    WebElement messageBadConfirmPassword;

    @FindBy(xpath = "//span[@id='username.errors']")
    WebElement messageUserAlreadyExists;

    @FindBy(xpath = "//div[@class='form-group has-error']/span[contains(text(), '')]")
    List<WebElement> errorMessages;

    public NewAccountCreationPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName(){
        return textPageName.getText();
    }

    public void inputNewUserName(String newUserName){
        inputNewUserName.sendKeys(newUserName);
    }

    public void inputNewPassword(String newPassword){
        inputNewPassword.sendKeys(newPassword);
    }

    public void inputPasswordConfirm(String newPassword){
        inputPasswordConfirm.sendKeys(newPassword);
    }

    public void clickButtonCreateAccount(){
        buttonCreateAccount.click();
    }

    public boolean isErrorMessageBadUserName(){
        return messageBadUserName.isDisplayed();
    }

    public boolean isErrorMessageBadPassword(){
        return messageBadPassword.isDisplayed();
    }

    public boolean isErrorMessageBadConfirmPassword(){
        return messageBadConfirmPassword.isDisplayed();
    }

    public boolean isErrorMessageUserAlreadyExists(){
        return messageUserAlreadyExists.isDisplayed();
    }

    public boolean isErrorMessageCorrect(String errorMessage){
        return errorMessages.stream().map(WebElement::getText).toList().contains(errorMessage);
    }

    public List<String> getError(){
        return errorMessages.stream().map(WebElement::getText).toList();
    }

}
