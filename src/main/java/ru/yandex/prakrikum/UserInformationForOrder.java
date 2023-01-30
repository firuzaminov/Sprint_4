package ru.yandex.prakrikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Блок локаторов, описывающие поля ввода на форме Для кого самокат
public class UserInformationForOrder {
    public static final By NAME = By.xpath(".//input[@placeholder = '* Имя']");
    public static final By SURNAME = By.xpath(".//input[@placeholder = '* Фамилия']");
    public static final By ADDRESS = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    public static final By METRO_STATION_CLICK = By.xpath(".//input[@placeholder = '* Станция метро']");
    public static final By PHONE_NUMBER = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    public static final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By METRO_STATION = By.className("select-search__row");
    private final WebDriver driver;

    public UserInformationForOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Реализован общий метод заполнения информации о заказчике
    public void inputInformationAboutCustomer(String nameFieldDataSet, String surnameFieldDataSet, String addressFirstDataSet, int metroIndex, String phoneNumberField) {
        driver.findElement(NAME).clear();
        driver.findElement(NAME).sendKeys(nameFieldDataSet);
        driver.findElement(SURNAME).clear();
        driver.findElement(SURNAME).sendKeys(surnameFieldDataSet);
        driver.findElement(ADDRESS).clear();
        driver.findElement(ADDRESS).sendKeys(addressFirstDataSet);
        driver.findElement(METRO_STATION_CLICK).click();
        WebElement element = driver.findElements(METRO_STATION).get(metroIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumberField);
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }


}
