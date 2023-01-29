package ru.yandex.prakrikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Блок локаторов, описывающие поля ввода на форме Для кого самокат
public class UserInformationForOrder {
    public static final By NAME = By.xpath(".//input[@placeholder = '* Имя']");
    public static final By SURNAME = By.xpath(".//input[@placeholder = '* Фамилия']");
    public static final By ADDRESS = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    public static final By METRO_STATION_CLICK = By.xpath(".//input[@placeholder = '* Станция метро']");
    public static final By METRO_STATION_1 = By.xpath(".//button[@value='6']");
    public static final By METRO_STATION_2 = By.xpath(".//button[@value='5']");
    public static final By PHONE_NUMBER = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    public static final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final WebDriver driver;

    public UserInformationForOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Метод заполнения формы Для кого самокат с первым набором данным
    public void inputInformationAboutCustomerFirstDataSet(String nameFieldFirstDataSet, String surnameFieldFirstDataSet, String addressFieldFirstDataSet, String phoneNumberFieldFirstDataSet) {
        driver.findElement(NAME).clear();
        driver.findElement(NAME).sendKeys(nameFieldFirstDataSet);
        driver.findElement(SURNAME).clear();
        driver.findElement(SURNAME).sendKeys(surnameFieldFirstDataSet);
        driver.findElement(ADDRESS).clear();
        driver.findElement(ADDRESS).sendKeys(addressFieldFirstDataSet);
        driver.findElement(METRO_STATION_CLICK).click();
        driver.findElement(METRO_STATION_1).click();
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumberFieldFirstDataSet);
    }

    public void clickNextButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        driver.findElement(NEXT_BUTTON).click();
    }

    //Метод заполнения формы Для кого самокат со вторым набором данным.
    public void inputInformationAboutCustomerSecondDataSet(String nameFieldSecondDataSet, String surnameFieldSecondDataSet, String addressFieldSecondDataSet, String phoneNumberFieldSecondDataSet) {
        driver.findElement(NAME).clear();
        driver.findElement(NAME).sendKeys(nameFieldSecondDataSet);
        driver.findElement(SURNAME).clear();
        driver.findElement(SURNAME).sendKeys(surnameFieldSecondDataSet);
        driver.findElement(ADDRESS).clear();
        driver.findElement(ADDRESS).sendKeys(addressFieldSecondDataSet);
        driver.findElement(METRO_STATION_CLICK).click();
        driver.findElement(METRO_STATION_2).click();
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumberFieldSecondDataSet);
    }

}
