package ru.yandex.prakrikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Блок локаторов, описывающие поля ввода на форме Про аренду
public class RentInformation {
    public static final By WHEN_BRING_SCOOTER = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    public static final By RENTAL_PERIOD = By.className("Dropdown-arrow");
    public static final By HOW_DAYS = By.className("Dropdown-option");
    public static final By COLOUR_SCOOTER_BLACK = By.id("black");
    public static final By COLOUR_SCOOTER_GREY = By.id("grey");
    public static final By COMMENT = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    public static final By RENT_ORDER_BUTTON = By.cssSelector(".Order_Buttons__1xGrp .Button_Button__ra12g:last-child");
    public static final By INFORMATION_SURE = By.className("Order_ModalHeader__3FDaJ");
    public static final By APPROVE_BUTTON_YES = By.cssSelector(".Order_Modal__YZ-d3 .Order_Buttons__1xGrp .Button_Button__ra12g:last-child");
    public static final By SUCCESS_WINDOW = By.className("Order_Text__2broi");
    private final WebDriver driver;

    public RentInformation(WebDriver driver) {
        this.driver = driver;

    }

    public void inputDateArrive(String dateArrive) {
        driver.findElement(WHEN_BRING_SCOOTER).clear();
        driver.findElement(WHEN_BRING_SCOOTER).sendKeys(dateArrive);
    }

    public void clickRental() {
        driver.findElement(RENTAL_PERIOD).click();
    }

    public void chooseDays(int days) {
        driver.findElements(HOW_DAYS).get(days).click();
    }

    public void chooseColour() {
        driver.findElement(COLOUR_SCOOTER_BLACK).click();
    }

    public void inputComment(String comment) {
        driver.findElement(COMMENT).clear();
        driver.findElement(COMMENT).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(RENT_ORDER_BUTTON).click();
    }

    public boolean isDisplayedInformationSure() {
        boolean isDisplayedInformationSure = driver.findElement(INFORMATION_SURE).isDisplayed();
        return isDisplayedInformationSure;
    }

    public void clickApproveButtonYes() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(APPROVE_BUTTON_YES));
        driver.findElement(APPROVE_BUTTON_YES).click();
    }

    public boolean isDisplayedSuccessWindow() {
        boolean isDisplayedInformationSuccess = driver.findElement(SUCCESS_WINDOW).isDisplayed();
        return isDisplayedInformationSuccess;
    }

    //Метод заполнения формы Про аренду со вторым набором данным.
    public void inputRental(String dateArriveField, int days, String commentField) {
        inputDateArrive(dateArriveField);
        clickRental();
        chooseDays(days);
        chooseColour();
        inputComment(commentField);
        clickOrderButton();
        isDisplayedInformationSure();
        clickApproveButtonYes();
        isDisplayedSuccessWindow();
    }



}
