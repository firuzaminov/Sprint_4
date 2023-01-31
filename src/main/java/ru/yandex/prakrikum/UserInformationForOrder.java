package ru.yandex.prakrikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Блок локаторов, описывающие поля ввода на форме Для кого самокат
public class UserInformationForOrder {
    private static final By NAME = By.xpath(".//input[@placeholder = '* Имя']");
    private static final By SURNAME = By.xpath(".//input[@placeholder = '* Фамилия']");
    private static final By ADDRESS = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private static final By METRO_STATION_CLICK = By.xpath(".//input[@placeholder = '* Станция метро']");
    private static final By PHONE_NUMBER = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private static final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By METRO_STATION = By.className("select-search__row");
    private final WebDriver driver;

    public UserInformationForOrder(WebDriver driver) {
        this.driver = driver;
    }


    private void inputName(String nameFieldDataSet) {
        driver.findElement(NAME).clear();
        driver.findElement(NAME).sendKeys(nameFieldDataSet);
    }

    private void inputSurname(String surnameFieldDataSet) {
        driver.findElement(SURNAME).clear();
        driver.findElement(SURNAME).sendKeys(surnameFieldDataSet);
    }

    private void inputAddress(String addressDataSet) {
        driver.findElement(ADDRESS).clear();
        driver.findElement(ADDRESS).sendKeys(addressDataSet);
    }

    private void chooseMetro(int metroIndex) {
        driver.findElement(METRO_STATION_CLICK).click();
        WebElement element = driver.findElements(METRO_STATION).get(metroIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    private void inputPhone(String phoneNumberField) {
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumberField);
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }

    //Реализован общий метода заполнения информации о заказчике
    public void inputInformationAboutCustomer(String nameField, String surnameField, String addressDataSet, int metroChooseIndex, String phoneNumber) {
        inputName(nameField);
        inputSurname(surnameField);
        inputAddress(addressDataSet);
        chooseMetro(metroChooseIndex);
        inputPhone(phoneNumber);
    }


}
