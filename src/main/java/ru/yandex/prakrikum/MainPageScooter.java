package ru.yandex.prakrikum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class MainPageScooter {
    // Локатор для первого вопроса "Сколько это стоит? И как оплатить?"
    private static final By HOW_MUCH_AND_PAY_LIST = By.className("accordion__item");

    // Локатор для второго вопроса "Хочу сразу несколько самокатов! Так можно?"
    private static final By I_WANT_MORE_SCOOTERS = By.className("accordion__item");

    // Локатор для третьего вопроса "Как рассчитывается время аренды?"
    private static final By RENTAL_TIME_CALCULATION = By.className("accordion__item");

    // Локатор для четвертого вопроса "Можно ли заказать самокат прямо на сегодня?"
    private static final By TODAY_ORDER_SCOOTER = By.className("accordion__item");

    // Локатор для пятого вопроса "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By ORDER_RENEWAL = By.className("accordion__item");

    // Локатор для шестого вопроса "Вы привозите зарядку вместе с самокатом?"
    private static final By BRING_CHARGER_FOR_SCOOTER = By.className("accordion__item");

    // Локатор для седьмого вопроса "Можно ли отменить заказ?"
    private static final By DECLINE_THE_ORDER = By.className("accordion__item");

    // Локатор для восьмого вопроса "Я жизу за МКАДом, привезёте?"
    private static final By I_LIVE_OUTSIDE_THE_MOSCOW = By.className("accordion__item");
    private static final By DOWN_ORDER_BUTTON = By.className("Home_FinishButton__1_cWm");



    //Блок локаторов выпадающих ответов
    private static final By HOW_MUCH_AND_PAY_INFORMATION = By.xpath("//p[contains(text(), \"Сутки — 400 рублей. Оплата курьеру — наличными или картой.\")]");
    private static final By I_WANT_MORE_SCOOTERS_INFORMATION = By.xpath("//p[contains(text(), \"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.\")]");
    private static final By RENTAL_TIME_CALCULATION_INFORMATION = By.xpath("//p[contains(text(), \"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.\")]");
    private static final By TODAY_ORDER_SCOOTER_INFORMATION = By.xpath("//p[contains(text(), \"Только начиная с завтрашнего дня. Но скоро станем расторопнее.\")]");
    private static final By ORDER_RENEWAL_INFORMATION = By.xpath("//p[contains(text(), \"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.\")]");
    private static final By BRING_CHARGER_FOR_SCOOTER_INFORMATION = By.xpath("//p[contains(text(), \"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.\")]");
    private static final By DECLINE_THE_ORDER_INFORMATION = By.xpath("//p[contains(text(), \"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.\")]");
    private static final By I_LIVE_OUTSIDE_THE_MOSCOW_INFORMATION = By.xpath("//p[contains(text(), \"Да, обязательно. Всем самокатов! И Москве, и Московской области.\")]");


    private WebDriver driver;
    private HeaderWithTwoButtons _header;
    // Конструктор класса
    public MainPageScooter(WebDriver driver){
        this.driver = driver;
        _header = new HeaderWithTwoButtons(driver);
    }
    // Метод для нажатия на галочку и проверки выпадающего текста
    public void scrollInformationAndShowText(){
        WebElement element = driver.findElement(HOW_MUCH_AND_PAY_LIST);//указываем локатор до которого нужно скрлить
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);//cкролл до этого элемента
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(HOW_MUCH_AND_PAY_LIST));

        driver.findElements(HOW_MUCH_AND_PAY_LIST).get(0).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(HOW_MUCH_AND_PAY_INFORMATION));
        boolean isDisplayedInformation = driver.findElement(HOW_MUCH_AND_PAY_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation);

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(I_WANT_MORE_SCOOTERS).get(1).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(I_WANT_MORE_SCOOTERS_INFORMATION));
        boolean isDisplayedInformation_2 = driver.findElement(I_WANT_MORE_SCOOTERS_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation_2);

        driver.findElements(RENTAL_TIME_CALCULATION).get(2).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(RENTAL_TIME_CALCULATION_INFORMATION));
        boolean isDisplayedInformation_3 = driver.findElement(RENTAL_TIME_CALCULATION_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation_3);


        driver.findElements(TODAY_ORDER_SCOOTER).get(3).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(TODAY_ORDER_SCOOTER_INFORMATION));
        boolean isDisplayedInformation_4 = driver.findElement(TODAY_ORDER_SCOOTER_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation_4);

        driver.findElements(ORDER_RENEWAL).get(4).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(ORDER_RENEWAL_INFORMATION));
        boolean isDisplayedInformation_5 = driver.findElement(ORDER_RENEWAL_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation_5);


        driver.findElements(BRING_CHARGER_FOR_SCOOTER).get(5).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(BRING_CHARGER_FOR_SCOOTER_INFORMATION));
        boolean isDisplayedInformation_6 = driver.findElement(BRING_CHARGER_FOR_SCOOTER_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation_6);


        driver.findElements(DECLINE_THE_ORDER).get(6).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(DECLINE_THE_ORDER_INFORMATION));
        boolean isDisplayedInformation_7 = driver.findElement(DECLINE_THE_ORDER_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation_7);

        driver.findElements(I_LIVE_OUTSIDE_THE_MOSCOW).get(7).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(I_LIVE_OUTSIDE_THE_MOSCOW_INFORMATION));
        boolean isDisplayedInformation_8 = driver.findElement(I_LIVE_OUTSIDE_THE_MOSCOW_INFORMATION).isDisplayed();
        Assert.assertTrue(isDisplayedInformation_8);
    }

    //Метод нажатия на кнопку Заказать снизу главной страницы
    public void clickToOrderDownButton(){
        WebElement element = driver.findElement(DOWN_ORDER_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(DOWN_ORDER_BUTTON));
        driver.findElement(DOWN_ORDER_BUTTON).click();//Клик на кнопку Заказать
    }
}
