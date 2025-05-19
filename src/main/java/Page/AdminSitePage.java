package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class AdminSitePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(AdminSitePage.class);
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminTab;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addAdminBtn;
    @FindBy(xpath = "//*[contains(text(),'-- Select --')][1]")
    private WebElement userRole;
    @FindBy(xpath = "//*[contains(text(),'ESS')]")
    private WebElement userOptions;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement userNameField;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement userPasswordField;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "(//*[@class='oxd-input oxd-input--active'])[2]")
    private WebElement userName;
    @FindBy(xpath = "//*[text()=' Save ']")
    private WebElement saveBtn;
    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchBtn;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    private WebElement deleteUser;
    @FindBy(xpath = "//*[text()=' Yes, Delete ']")
    private WebElement deleteUserBtn;

    public AdminSitePage(WebDriver driver) {
        super(driver);
    }

    public void adminMenu() {
        isElementClickable(adminTab, 5);
        adminTab.click();
        log.info("Admin tab clicked successfully...");
    }

    public void addAdminBtn() {
        isElementClickable(addAdminBtn, 5);
        addAdminBtn.click();
        sleep(5);
    }

    public void userRole(String userOptions) {
        isElementClickable(userRole, 3);
        userRole.click();
        WebElement userOption = driver.findElement(By.xpath("//*[contains(text(),'" + userOptions + "')]"));
        userOption.click();
    }

    public void userName(String username) {
        isElementClickable(userNameField, 5);
        userNameField.sendKeys(username);
        sleep(5);
        WebElement userNameOption = driver.findElement(By.xpath("//*[text()='" + username + "']"));
        isElementClickable(userNameOption, 5);
        userNameOption.click();
    }

    public void status(String StatusOption) {
        isElementClickable(userRole, 3);
        userRole.click();
        WebElement statusOptions = driver.findElement(By.xpath("//*[contains(text(),'" + StatusOption + "')]"));
        statusOptions.click();
    }

    public void addUsername(String addUsername) {
        sleep(2);
        userName.sendKeys(addUsername);
    }


    public void enterPasswordAndConfirm(String userPassword, String confirmPassword) {
        userPasswordField.sendKeys(userPassword);
        sleep(2);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void saveBtn() {
        scrollToElement(saveBtn);
        executeJavascript(saveBtn);
        sleep(5);
        log.info("Saved successfully...");
    }

    public void searchBtn() {
        isElementClickable(searchBtn, 5);
        executeJavascript(searchBtn);
        log.info("Search button clicked successfully...");
        sleep(5);
    }

    public void verifyUserData(String username) {
        SoftAssert sa = new SoftAssert();
        WebElement userData = driver.findElement(By.xpath("//*[text()='" + username + "']"));
        isElementDisplayed(userData);
        log.info("User data verified successfully...");
        sa.assertAll();
    }

    public void deleteUserData() {
        executeJavascript(deleteUser);
        isElementDisplayed(deleteUserBtn);
        deleteUserBtn.click();
        log.info("User deleted in admin page...");
    }

}
