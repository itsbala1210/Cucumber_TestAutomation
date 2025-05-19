package Page;

import Helper.ConfigFileReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchUrl(String url) {
        driver.get(getProperty(url));
    }

    public static String getProperty(String key) {
        String value = ConfigFileReader.getInstance().getProperty(key);
        if (StringUtils.isEmpty(value)) {
            log.warn("Properties not found...", key);
            return key;
        }
        return value;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void getPageTitle() {
        String title = driver.getTitle();
        log.info("Page title is: {}", title);
    }

    public void sleep(long seconds) {
        Actions actions = new Actions(driver);
        actions.pause(seconds * 1000).build().perform();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void switchToFrame(String frameIdOrName) {
        try {
            driver.switchTo().frame(frameIdOrName);
        } catch (Exception e) {
            log.info("Frame not found", e);
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void isElementClickable(WebElement webElement, long timeDuration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void isElementVisible(WebElement webElement, long timeDuration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void isElementInVisible(WebElement webElement, long timeDuration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void executeJavascript(WebElement webElement) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", webElement);
        } catch (Exception e) {
            log.info("Element not found", e);
        }
    }

    public void javascriptExecutorClear(WebElement webElement) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].value='';", webElement);
        } catch (Exception e) {
            log.info("Element Not Found", e);
        }
    }

    public void javascriptExecutorSendKeys(WebElement webelement, String value) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].value='" + value + "';", webelement);
        } catch (Exception e) {
            log.info("Element Not Found", e);
        }
    }

    public void scrollToElement(WebElement webElement) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", webElement);
            sleep(2);
        } catch (Exception e) {
            log.info("Element not found", e);
        }
    }

    public void selectByText(WebElement webElement, String selectedOption) {
        Select select = new Select(webElement);
        select.selectByVisibleText(selectedOption);
    }

    public void deselectByText(WebElement webElement, String selectedOption) {
        Select select = new Select(webElement);
        select.deselectByVisibleText(selectedOption);
    }

    public void selectByValue(WebElement webElement, String selectedOption) {
        Select select = new Select(webElement);
        select.selectByValue(selectedOption);
    }

    public void deselectByValue(WebElement webElement, String selectedOption) {
        Select select = new Select(webElement);
        select.deselectByValue(selectedOption);
    }

    public void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void hoverOver(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public void hoverOverAndClick(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    public void takeScreenShot() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("src/test/resources/Screenshots/" + "UserAddedConfirmation" + ".png");
            FileUtils.copyFile(srcFile, destFile);
            log.info("Screenshot taken successfully...");

        } catch (Exception e) {
            log.error("Error taking screenshot", e);
        }
    }
}
