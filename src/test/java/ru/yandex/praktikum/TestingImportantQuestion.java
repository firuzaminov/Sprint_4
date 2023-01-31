package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.prakrikum.MainPageScooter;
import static org.junit.Assert.assertEquals;


public class TestingImportantQuestion {
    private WebDriver driver;

    // Анотация Before, всегда будет создавать драйвер и открывать сайт.
    @Before
    public void setUp() {
        driver = new ChromeDriver(); //Используйте new FirefoxDriver(); для запуска тестов в браузере Mozilla Firefox
        driver.manage().window().maximize(); //вызов метода для открытия окна браузера во весь экран
        driver.get("https://qa-scooter.praktikum-services.ru/"); //открываем сайт
    }
    //Блок тестов для проверки текста из выпадающего списка каждого вопроса
    @Test
    public void checkHowMuchInformation() {
        String howMuchScooter = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";//Эталонный текст
        MainPageScooter checkHowMuchInformation = new MainPageScooter(driver);
        String howMuchScooterIsTrue = checkHowMuchInformation.getAnswerForHowMuchAndPaymentType();//
        assertEquals(howMuchScooter, howMuchScooterIsTrue);//Сравнение фактического текста с ожидаемым
    }

    @Test
    public void clickAndCheckHowMoreScootersInformation() {
        String howMoreScooters = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        MainPageScooter clickAndCheckHowMoreScootersInformation = new MainPageScooter(driver);
        String howMoreScootersTrue = clickAndCheckHowMoreScootersInformation.getAnswerForIWantMoreScooters();
        assertEquals(howMoreScooters, howMoreScootersTrue);
    }

    @Test
    public void clickAndCheckRentalTimeInformation() {
        String rentalTime = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        MainPageScooter clickAndCheckRentalTimeInformation = new MainPageScooter(driver);
        String rentalTimeTrue = clickAndCheckRentalTimeInformation.getAnswerForRentalTimeInformation();
        assertEquals(rentalTime, rentalTimeTrue);
    }

    @Test
    public void clickAndCheckTodayOrderInformation() {
        String todayOrder = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        MainPageScooter clickAndCheckTodayOrderInformation = new MainPageScooter(driver);
        String todayOrderTrue = clickAndCheckTodayOrderInformation.getAnswerForTodayOrderScooter();
        assertEquals(todayOrder, todayOrderTrue);
    }

    @Test
    public void clickAndCheckOrderRenewalInformation() {
        String orderRenewal = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        MainPageScooter clickAndCheckOrderRenewalInformation = new MainPageScooter(driver);
        String orderRenewalIsTrue = clickAndCheckOrderRenewalInformation.getAnswerForOrderRenewal();
        assertEquals(orderRenewal, orderRenewalIsTrue);
    }

    @Test
    public void clickAndCheckBringChargerInformation() {
        String bringCharger = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        MainPageScooter clickAndCheckBringChargerInformation = new MainPageScooter(driver);
        String bringChargerIsTrue = clickAndCheckBringChargerInformation.getAnswerForBringCharger();
        assertEquals(bringCharger, bringChargerIsTrue);
    }

    @Test
    public void clickAndCheckDeclineOrderInformation() {
        String declineOrder = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        MainPageScooter clickAndCheckDeclineOrderInformation = new MainPageScooter(driver);
        String declineOrderIsTrue = clickAndCheckDeclineOrderInformation.getAnswerForDeclineOrder();
        assertEquals(declineOrder, declineOrderIsTrue);
    }

    @Test
    public void clickAndCheckOutsideTheMoscowInformation() {
        String outsideTheMoscow = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        MainPageScooter clickAndCheckOutsideTheMoscowInformation = new MainPageScooter(driver);
        String outsideTheMoscowIsTrue = clickAndCheckOutsideTheMoscowInformation.getAnswerForOutsideTheMoscow();
        assertEquals(outsideTheMoscow, outsideTheMoscowIsTrue);
    }

    //Аннотация для закрытие браузера, после прохождения теста
    @After
    public void closeWebSite() {
        driver.quit();
    }

}

