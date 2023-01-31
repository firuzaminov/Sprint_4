package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.prakrikum.MainPageScooter;
import ru.yandex.prakrikum.RentInformation;
import ru.yandex.prakrikum.UserInformationForOrder;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestingScooterOrder {
    private final String name;
    private final String surname;
    private final String address;
    private final int metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final int deliveryDay;
    private final String comment;
    private WebDriver driver;
    private final boolean upAndDownButton;

    public TestingScooterOrder(boolean upAndDownButton, String name, String surname, String address, int metroStation, String phoneNumber, String deliveryDate, int deliveryDay, String comment) {
        this.upAndDownButton = upAndDownButton;
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
                {true, "Фируз", "Аминов", "ул. Московская, д. 23, кв. 12", 1, "+75456783454", "25.01.2023", 2, "Люблю кататься на самокате"},
                {false, "Дмитрий", "Левый", "ул. Пушкина, д. 666, кв. 13", 2, "+76666666666", "12.02.2023", 3, "Я очень люблю кататься на самокате"},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver(); //Используйте new FirefoxDriver(); для запуска тестов в браузере Mozilla Firefox
        driver.manage().window().maximize(); //вызов метода для открытия окна браузера во весь экран
        driver.get("https://qa-scooter.praktikum-services.ru/"); //открываем сайт
    }
    //Реализован один тест для проверки заказа самоката, через параметризацию двох ноборов данных
    @Test
    public void makeScooterOrder() {
        MainPageScooter headerWithTwoButtons = new MainPageScooter(driver);
        headerWithTwoButtons.clickUpOrDownButton(upAndDownButton);
        UserInformationForOrder userInformationForOrder = new UserInformationForOrder(driver);
        userInformationForOrder.inputInformationAboutCustomer(name, surname, address, metroStation, phoneNumber);
        userInformationForOrder.clickNextButton();
        RentInformation rentInformation = new RentInformation(driver);
        rentInformation.inputInformationForRent(deliveryDate, deliveryDay, comment);
        rentInformation.clickOrderButton();
        rentInformation.clickApproveButtonYes();
        assertTrue(rentInformation.isDisplayedSuccessWindow());
    }

    @After
    public void closeWebSite() {
        driver.quit();
    }


}
