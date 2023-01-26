package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.prakrikum.HeaderWithTwoButtons;
import ru.yandex.prakrikum.MainPageScooter;
import ru.yandex.prakrikum.RentInformation;
import ru.yandex.prakrikum.UserInformationForOrder;

public class TestingScooterOrder {
    private WebDriver driver;
    public TestingScooterOrder(){

    }
    @Before
    public void setUp(){
        driver = new ChromeDriver(); //Используйте new FirefoxDriver(); для запуска тестов в браузере Mozilla Firefox
        driver.manage().window().maximize(); //вызов метода для открытия окна браузера во весь экран
        driver.get("https://qa-scooter.praktikum-services.ru/"); //открываем сайт
    }
    @Test
    public void makeScooterOrderWithUpperButton(){
        HeaderWithTwoButtons headerWithTwoButtons = new HeaderWithTwoButtons(driver);
        headerWithTwoButtons.clickToOrderButton();
        UserInformationForOrder userInformationForOrder = new UserInformationForOrder(driver);
        userInformationForOrder.inputInformationAboutCustomerFirstDataSet();
        RentInformation rentInformation = new RentInformation(driver);
        rentInformation.inputInformationForRentFirstDataSet();
    }
    @Test
    public void makeScooterOrderWithDownButton() {
        MainPageScooter headerWithTwoButtonsDown = new MainPageScooter(driver);
        headerWithTwoButtonsDown.clickToOrderDownButton();
        UserInformationForOrder userInFormationForOrderDown = new UserInformationForOrder(driver);
        userInFormationForOrderDown.inputInformationAboutCustomerSecondDataSet();
        RentInformation rentInformation = new RentInformation(driver);
        rentInformation.inputInformationForRentSecondDataSet();
    }
    @After
    public void closeWebSite(){
        driver.quit();
    }



}
