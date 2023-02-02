package ru.yandex.practicum.model;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;

public class MainPage {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By UPPER_ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private static final By MIDDLE_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Заказать']");
    private static final By COOKIE_BUTTON = By.id("rcc-confirm-button");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(PAGE_URL);
    }
    public void clickUpperNewOrderButton() {
         driver.findElement(UPPER_ORDER_BUTTON).click();
    }
    public void clickMiddleNewOrderButton() {
        WebElement element = driver.findElement(MIDDLE_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(MIDDLE_ORDER_BUTTON).click();
    }
    public void clickToCloseCookieNotification() {
        driver.findElement(COOKIE_BUTTON).click(); //Закрываем уведомление о куках
    }
}
