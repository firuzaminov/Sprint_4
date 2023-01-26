package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.prakrikum.MainPageScooter;





public class TestingImportantQuestion {
    private WebDriver driver;
    public TestingImportantQuestion(){

    }
    // Анотация Before, всегда будет создавать драйвер и открывать сайт
    @Before
    public void setUp(){
        driver = new ChromeDriver(); //Используйте new FirefoxDriver(); для запуска тестов в браузере Mozilla Firefox
        driver.manage().window().maximize(); //вызов метода для открытия окна браузера во весь экран
        driver.get("https://qa-scooter.praktikum-services.ru/"); //открываем сайт
    }

    @Test
    public void findTextForImportantQuestion() {
        MainPageScooter mainPageScooter = new MainPageScooter(driver);
        // Вызов метода scrollInformation() для нажатия на галочку и проверки выпадающего текста
        mainPageScooter.scrollInformationAndShowText();

    }
//Аннотация для закрытие браузера, после прохождения теста
    @After
    public void closeWebSite(){
        driver.quit();
    }

}

