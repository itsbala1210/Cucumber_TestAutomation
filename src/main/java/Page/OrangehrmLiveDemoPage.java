package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.EncryptionUtil;

public class OrangehrmLiveDemoPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(OrangehrmLiveDemoPage.class);
    @FindBy(xpath = "//*[@name='username']")
    private WebElement txtUsername;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement txtPassword;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    public OrangehrmLiveDemoPage(WebDriver driver) {
        super(driver);
    }


    public void enterCredentials(String username, String password) {
        sleep(2);
        txtUsername.sendKeys(EncryptionUtil.decodeKey(getProperty(username)));
        sleep(1);
        txtPassword.sendKeys(EncryptionUtil.decodeKey(getProperty(password)));
        sleep(2);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
