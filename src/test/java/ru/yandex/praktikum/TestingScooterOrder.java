package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.prakrikum.HeaderWithTwoButtons;
import ru.yandex.prakrikum.MainPageScooter;
import ru.yandex.prakrikum.RentInformation;
import ru.yandex.prakrikum.UserInformationForOrder;
@RunWith(Parameterized.class)
public class TestingScooterOrder {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final int metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final int deliveryDay;
    private final String comment;

    public TestingScooterOrder(String name, String surname, String address,int metroStation, String phoneNumber, String deliveryDate, int deliveryDay, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.deliveryDay = deliveryDay;
        this.comment = comment;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] inputData() {
        return new Object[][]{
                {"Фируз", "Аминов", "ул. Московская, д. 23, кв. 12",1, "+75456783454", "25.01.2023",2,"Люблю кататься на самокате"},
                {"Дмитрий","Левый", "ул. Пушкина, д. 666, кв. 13", 2, "+76666666666","12.02.2023", 3,"Я очень люблю кататься на самокате"},
        };
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
        userInformationForOrder.inputCustomer(name, surname, address, metroStation, phoneNumber);
        userInformationForOrder.clickNextButton();

        RentInformation rentInformation = new RentInformation(driver);
        rentInformation.inputRental(deliveryDate, deliveryDay, comment);
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
