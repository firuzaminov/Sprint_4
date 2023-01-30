package ru.yandex.prakrikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Блок локаторов, описывающие поля ввода на форме Для кого самокат
public class UserInformationForOrder {
    public static final By NAME = By.xpath(".//input[@placeholder = '* Имя']");
    public static final By SURNAME = By.xpath(".//input[@placeholder = '* Фамилия']");
    public static final By ADDRESS = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    public static final By METRO_STATION_CLICK = By.xpath(".//input[@placeholder = '* Станция метро']");
    private final By METRO_STATION = By.className("select-search__row");
    public static final By PHONE_NUMBER = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    public static final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final WebDriver driver;

    public UserInformationForOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Метод заполнения формы Для кого самокат с первым набором данным

    public void inputName(String nameField){
        driver.findElement(NAME).clear();
        driver.findElement(NAME).sendKeys(nameField);
    }

    public void inputSurname(String surnameField){
        driver.findElement(SURNAME).clear();
        driver.findElement(SURNAME).sendKeys(surnameField);
    }
    public void inputAddress(String addressField){
        driver.findElement(ADDRESS).clear();
        driver.findElement(ADDRESS).sendKeys(addressField);
    }

    public void clickMetro(){
        driver.findElement(METRO_STATION_CLICK).click();
    }
    public void setMetro(int index){
        WebElement element = driver.findElements(METRO_STATION).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void setPhone(String phone){
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(phone);
    }

    public void clickNextButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        driver.findElement(NEXT_BUTTON).click();
    }

    public void inputCustomer(String nameField, String surnameField, String addressField,int metroStation, String phone){
        inputName(nameField);
        inputSurname(surnameField);
        inputAddress(addressField);
        clickMetro();
        setMetro(metroStation);
        setPhone(phone);

    }



}
