package ru.yandex.prakrikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    //Блок локаторов выпадающих ответов.
    private static final By HOW_MUCH_AND_PAY_INFORMATION = By.xpath("//p[contains(text(), \"Сутки — 400 рублей. Оплата курьеру — наличными или картой.\")]");
    private static final By I_WANT_MORE_SCOOTERS_INFORMATION = By.xpath("//p[contains(text(), \"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.\")]");
    private static final By RENTAL_TIME_CALCULATION_INFORMATION = By.xpath("//p[contains(text(), \"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.\")]");
    private static final By TODAY_ORDER_SCOOTER_INFORMATION = By.xpath("//p[contains(text(), \"Только начиная с завтрашнего дня. Но скоро станем расторопнее.\")]");
    private static final By ORDER_RENEWAL_INFORMATION = By.xpath("//p[contains(text(), \"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.\")]");
    private static final By BRING_CHARGER_FOR_SCOOTER_INFORMATION = By.xpath("//p[contains(text(), \"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.\")]");
    private static final By DECLINE_THE_ORDER_INFORMATION = By.xpath("//p[contains(text(), \"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.\")]");
    private static final By I_LIVE_OUTSIDE_THE_MOSCOW_INFORMATION = By.xpath("//p[contains(text(), \"Да, обязательно. Всем самокатов! И Москве, и Московской области.\")]");


    private final WebDriver driver;
    private final HeaderWithTwoButtons _header;

    // Конструктор класса
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
        _header = new HeaderWithTwoButtons(driver);
    }

    //Метод для выбора нажатия верхней или нижней кнопки Заказать
    public void clickUpOrDownButton(boolean upAndDownButton) {
        if (upAndDownButton) {
            _header.clickToOrderButton();
        } else {
            clickToOrderDownButton();
        }
    }

    //Общий метод получения текста ответа для всех вопросов
    private String getAnswerForQuestion(By questionLocator, By aLocator, int indexQuestion) {
        WebElement element = driver.findElement(questionLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(questionLocator).get(indexQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(aLocator));
        return driver.findElement(aLocator).getText();
    }

    //Блок методов, который получают текст ответов для определенного вопроса
    public String getAnswerForHowMuchAndPaymentType() {
        int howMuchAndPaymentIndex = 0;
        return getAnswerForQuestion(HOW_MUCH_AND_PAY_LIST, HOW_MUCH_AND_PAY_INFORMATION, howMuchAndPaymentIndex);
    }

    public String getAnswerForIWantMoreScooters() {
        int iWantMoreScootersIndex = 1;
        return getAnswerForQuestion(I_WANT_MORE_SCOOTERS, I_WANT_MORE_SCOOTERS_INFORMATION, iWantMoreScootersIndex);
    }

    public String getAnswerForRentalTimeInformation() {
        int rentalTimeIndex = 2;
        return getAnswerForQuestion(RENTAL_TIME_CALCULATION, RENTAL_TIME_CALCULATION_INFORMATION, rentalTimeIndex);
    }

    public String getAnswerForTodayOrderScooter() {
        int todayOrderIndex = 3;
        return getAnswerForQuestion(TODAY_ORDER_SCOOTER, TODAY_ORDER_SCOOTER_INFORMATION, todayOrderIndex);
    }

    public String getAnswerForOrderRenewal() {
        int orderRenewalIndex = 4;
        return getAnswerForQuestion(ORDER_RENEWAL, ORDER_RENEWAL_INFORMATION, orderRenewalIndex);
    }

    public String getAnswerForBringCharger() {
        int bringChargerIndex = 5;
        return getAnswerForQuestion(BRING_CHARGER_FOR_SCOOTER, BRING_CHARGER_FOR_SCOOTER_INFORMATION, bringChargerIndex);
    }

    public String getAnswerForDeclineOrder() {
        int declineOrderIndex = 6;
        return getAnswerForQuestion(DECLINE_THE_ORDER, DECLINE_THE_ORDER_INFORMATION, declineOrderIndex);
    }

    public String getAnswerForOutsideTheMoscow() {
        int outsideTheMoscowIndex = 7;
        return getAnswerForQuestion(I_LIVE_OUTSIDE_THE_MOSCOW, I_LIVE_OUTSIDE_THE_MOSCOW_INFORMATION, outsideTheMoscowIndex);
    }

    //Метод нажатия на кнопку Заказать снизу главной страницы.
    public void clickToOrderDownButton() {
        WebElement element = driver.findElement(DOWN_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(DOWN_ORDER_BUTTON));
        driver.findElement(DOWN_ORDER_BUTTON).click();//Клик на кнопку Заказать
    }
}
