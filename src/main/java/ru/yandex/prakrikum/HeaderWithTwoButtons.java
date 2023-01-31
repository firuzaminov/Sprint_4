package ru.yandex.prakrikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Клас шапки страницы, элементы на ней не меняются, если переходить на разные вкладки.
public class HeaderWithTwoButtons {
    private static final By ORDER_BUTTON = By.className("Button_Button__ra12g");//Кнопка Заказать, которая находится в заголовке страницы
    private final WebDriver driver;

    public HeaderWithTwoButtons(WebDriver driver) {
        this.driver = driver;
    }

    //Метод нажатия на кнопку Заказать, которая находится в заголовке страницы.
    public void clickToOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }
}
