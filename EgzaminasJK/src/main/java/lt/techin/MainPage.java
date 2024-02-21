package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//h1[@class = 'text-center']")
    WebElement textPageName;

    @FindBy(xpath = "//input[name=  'username' ]")
    WebElement inputUserName;

    @FindBy(xpath = "//input[name=  'password' ]")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonLogIn;

    @FindBy(xpath = "//a[@href='/registruoti']")
    WebElement linkCreateNewAccount;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName(){
       return textPageName.getText();
    }

    public void setInputUserName(){
        inputUserName.sendKeys();
    }

    public void setInputPassword(){
        inputPassword.sendKeys();
    }

    public void clickButtonLogIn(){
        buttonLogIn.click();
    }

    public void clickLinkCreateNewAccount(){
        linkCreateNewAccount.click();
    }
}
