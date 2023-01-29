package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.prakrikum.HeaderWithTwoButtons;
import ru.yandex.prakrikum.MainPageScooter;
import ru.yandex.prakrikum.RentInformation;
import ru.yandex.prakrikum.UserInformationForOrder;

public class TestingScooterOrder {
    private WebDriver driver;

    public TestingScooterOrder() {

    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver(); //Используйте new FirefoxDriver(); для запуска тестов в браузере Mozilla Firefox
        driver.manage().window().maximize(); //вызов метода для открытия окна браузера во весь экран
        driver.get("https://qa-scooter.praktikum-services.ru/"); //открываем сайт
    }

    @Test
    public void makeScooterOrderWithUpperButton() {
        HeaderWithTwoButtons headerWithTwoButtons = new HeaderWithTwoButtons(driver);
        headerWithTwoButtons.clickToOrderButton();
        UserInformationForOrder userInformationForOrder = new UserInformationForOrder(driver);
        String nameFirstDataSet = "Фируз";
        String surnameFirstDataSet = "Аминов";
        String addressFirstDataSet = "ул. Московская, д. 23, кв. 12";
        String phoneFirstDataSet = "+75456783454";
        userInformationForOrder.inputInformationAboutCustomerFirstDataSet(nameFirstDataSet, surnameFirstDataSet, addressFirstDataSet, phoneFirstDataSet);
        userInformationForOrder.clickNextButton();
        RentInformation rentInformation = new RentInformation(driver);
        String dateFirstDataSet = "25.01.2023";
        String commentFirstDataSet = "Люблю кататься на самокате";
        rentInformation.inputInformationForRentFirstDataSet(dateFirstDataSet, commentFirstDataSet);
        rentInformation.clickOrderButton();
        Assert.assertTrue(rentInformation.isDisplayedInformationSure());
        rentInformation.clickApproveButtonYes();
        Assert.assertTrue(rentInformation.isDisplayedSuccessWindow());


    }

    @Test
    public void makeScooterOrderWithDownButton() {
        MainPageScooter headerWithTwoButtonsDown = new MainPageScooter(driver);
        headerWithTwoButtonsDown.clickToOrderDownButton();
        UserInformationForOrder userInFormationForOrderDown = new UserInformationForOrder(driver);
        String nameSecondDataSet = "Дмитрий";
        String surnameSecondDataSet = "Левый";
        String addressSecondDataSet = "ул. Пушкина, д. 666, кв. 13";
        String phoneSecondDataSet = "+76666666666";
        userInFormationForOrderDown.inputInformationAboutCustomerSecondDataSet(nameSecondDataSet, surnameSecondDataSet, addressSecondDataSet, phoneSecondDataSet);
        userInFormationForOrderDown.clickNextButton();
        RentInformation rentInformation = new RentInformation(driver);
        String dateSecondDataSet = "01.01.2023";
        String commentSecondDataSet = "Я очень люблю кататься на самокате";
        rentInformation.inputInformationForRentSecondDataSet(dateSecondDataSet, commentSecondDataSet);
        rentInformation.clickOrderButton();
        Assert.assertTrue(rentInformation.isDisplayedInformationSure());
        rentInformation.clickApproveButtonYes();
        Assert.assertTrue(rentInformation.isDisplayedSuccessWindow());
    }

    @After
    public void closeWebSite() {
        driver.quit();
    }


}
