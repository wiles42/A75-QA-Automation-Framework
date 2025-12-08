package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author wiles42
 */
public class ProfilePreferencesPage extends BasePage{
    public ProfilePreferencesPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (xpath ="//a[@title='View/edit user profile']")
    WebElement profileName;
    @FindBy (xpath = "//input[@name='current_password']")
    WebElement currentPasswordField;
    @FindBy (xpath = "//input[@name='new_password']")
    WebElement newPassword;
    @FindBy (xpath = "//button[@class='btn-submit']")
    WebElement clickSavePassword;
    @FindBy (xpath = "//a[@title='Log student out']")
    WebElement logOutBtn;

    public void clickProfilePage(){
        wait.until(ExpectedConditions.visibilityOf(profileName));
        click(profileName);
    }
    public ProfilePreferencesPage inputCurrentPassword (String currentPassword){
        wait.until(ExpectedConditions.visibilityOf(currentPasswordField));
        click(currentPasswordField);
        currentPasswordField.sendKeys(currentPassword);
        return this;

    }
    public ProfilePreferencesPage inputNewPassword (String setNewPassword){
        click(newPassword);
        newPassword.sendKeys(setNewPassword);
        return this;
    }
    public void clickSaveBtn(){
        click(clickSavePassword);
    }
    public void clickLogOut(){
      wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
      click(logOutBtn);
    }
    public boolean atProfilePage(){
        String homeURL = "https://qa.koel.app/#!/profile";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(homeURL));
        return driver.getCurrentUrl().equals(homeURL);
    }


}
