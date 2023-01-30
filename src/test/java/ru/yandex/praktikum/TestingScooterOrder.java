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
    private final String phoneNumber;
    private final String date;
    private final String comment;
    public TestingScooterOrder(String name, String surname, String address, String phoneNumber, String date, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] inputData() {
        return new Object[][]{
                {"Фируз", "Аминов", "ул. Московская, д. 23, кв. 12","+75456783454","25.01.2023","Люблю кататься на самокате"},
                {"Дмитрий","Левый", "ул. Пушкина, д. 666, кв. 13","+76666666666", "12.02.2023", "Я очень люблю кататься на самокате"},
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
        userInformationForOrder.inputInformationAboutCustomerFirstDataSet(name, surname, address, phoneNumber);
        userInformationForOrder.clickNextButton();
        RentInformation rentInformation = new RentInformation(driver);
        rentInformation.inputInformationForRentFirstDataSet(date, comment);
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
