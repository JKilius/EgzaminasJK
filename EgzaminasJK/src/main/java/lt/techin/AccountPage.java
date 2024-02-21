package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), 'Logout,')]")
    WebElement linkLogOut;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isThereLogOutAction(){
        return linkLogOut.isDisplayed();
    }

    public String getUserName(){
        String fullText = linkLogOut.getText();
        String[] parts = fullText.split(", ");
        String userName = parts[1];

        return userName;
    }

    public boolean isUserNameCorrect(String userName){
        return linkLogOut.getText().contains(userName);
    }

    public void clickLinkLogOut(){
        linkLogOut.click();
    }
}
