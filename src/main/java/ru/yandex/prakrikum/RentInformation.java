package ru.yandex.prakrikum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
//Блок локаторов, описывающие поля ввода на форме Про аренду
public class RentInformation {
    private WebDriver driver;
    public static final By WHEN_BRING_SCOOTER = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    public static final By RENTAL_PERIOD = By.className("Dropdown-arrow");
    public static final By HOW_DAYS = By.xpath("//div[2][contains(text(), \"двое суток\")]");
    public static final By HOW_DAYS_2 = By.xpath("//div[3][contains(text(), \"трое суток\")]");
    public static final By COLOUR_SCOOTER_BLACK = By.id("black");
    public static final By COLOUR_SCOOTER_GREY = By.id("grey");
    public static final By COMMENT = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    public static final By RENT_ORDER_BUTTON = By.cssSelector(".Order_Buttons__1xGrp .Button_Button__ra12g:last-child");
    public static final By INFORMATION_SURE = By.className("Order_ModalHeader__3FDaJ");
    public static final By APPROVE_BUTTON_YES = By.cssSelector(".Order_Modal__YZ-d3 .Order_Buttons__1xGrp .Button_Button__ra12g:last-child");
    public static final By SUCCESS_WINDOW = By.className("Order_Text__2broi");
    public RentInformation(WebDriver driver){
        this.driver = driver;

    }

    //Метод заполнения формы Про аренду с первым набором данным
    public void inputInformationForRentFirstDataSet(){
        driver.findElement(WHEN_BRING_SCOOTER).clear();
        driver.findElement(WHEN_BRING_SCOOTER).sendKeys("25.01.2023");
        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(HOW_DAYS).click();
        driver.findElement(COLOUR_SCOOTER_BLACK).click();
        driver.findElement(COMMENT).clear();
        driver.findElement(COMMENT).sendKeys("Люблю кататься на самокате");
        driver.findElement(RENT_ORDER_BUTTON).click();
        boolean isDisplayedInformationSure = driver.findElement(INFORMATION_SURE).isDisplayed();
        Assert.assertTrue(isDisplayedInformationSure);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(APPROVE_BUTTON_YES));
        driver.findElement(APPROVE_BUTTON_YES).click();
        boolean isDisplayedInformationSuccess = driver.findElement(SUCCESS_WINDOW).isDisplayed();
        Assert.assertTrue(isDisplayedInformationSuccess);
    }
    //Метод заполнения формы Про аренду со вторым набором данным
    public void inputInformationForRentSecondDataSet(){
        driver.findElement(WHEN_BRING_SCOOTER).clear();
        driver.findElement(WHEN_BRING_SCOOTER).sendKeys("01.01.2023");
        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(HOW_DAYS_2).click();
        driver.findElement(COLOUR_SCOOTER_GREY).click();
        driver.findElement(COMMENT).clear();
        driver.findElement(COMMENT).sendKeys("Я очень люблю кататься на самокате");
        driver.findElement(RENT_ORDER_BUTTON).click();
        boolean isDisplayedInformationSure = driver.findElement(INFORMATION_SURE).isDisplayed();
        Assert.assertTrue(isDisplayedInformationSure);
        driver.findElement(APPROVE_BUTTON_YES).click();
    }

}
