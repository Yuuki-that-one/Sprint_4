package ru.yandex.practicum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage {
    private final WebDriver driver;
    private static final By INPUT_ORDER_FIRST_NAME = By.xpath(".//input[@placeholder='* Имя']");
    private static final By INPUT_ORDER_LAST_NAME = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By INPUT_ORDER_ADDRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By INPUT_ORDER_SUBWAY = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By INPUT_ORDER_PHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By ORDER_NEXT_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By INPUT_ORDER_DELIVERY_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By INPUT_ORDER_DURATION = By.xpath(".//div[@class = 'Dropdown-control']");
    private static final By INPUT_ORDER_COURIER_MESSAGE = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private static final By ORDER_FINAL_CONFIRM_BUTTON = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String firstName) {
        driver.findElement(INPUT_ORDER_FIRST_NAME).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(INPUT_ORDER_LAST_NAME).sendKeys(lastName);
    }

    public void inputAddress(String address) {
        driver.findElement(INPUT_ORDER_ADDRESS).sendKeys(address);
    }

    public void inputSubway(String station) {
        driver.findElement(INPUT_ORDER_SUBWAY).click();
        driver.findElement(INPUT_ORDER_SUBWAY).sendKeys(station); //Выбираем станцию метро
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='Order_Text__2broi'][text()='" + station + "']"))); //Ожидаем подгрузку списка
        driver.findElement(By.xpath(".//div[@class='Order_Text__2broi'][text()='" + station + "']")).click();
        //new WebDriverWait(driver, 3)
        //        .until(ExpectedConditions.elementToBeClickable(By.xpath(".//li[@data-value='6']"))); //Ожидаем подгрузку списка
        //driver.findElement(By.xpath(".//li[@data-value='6']")).click();
        //Order_Text__2broi
    }

    public void inputPhone(String phone) {
        driver.findElement(INPUT_ORDER_PHONE).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(ORDER_NEXT_BUTTON).click();
    }

    public void inputDeliveryDate(String day) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(INPUT_ORDER_DELIVERY_DATE));
        driver.findElement(INPUT_ORDER_DELIVERY_DATE).click();
        driver.findElement(By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--0" + day + "']")).click();
    }

    public void inputDuration(String duration) {
        driver.findElement(INPUT_ORDER_DURATION).click();
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-option'][text()='" + duration + "']")).click();
    }

    public void chooseColor(String color) {
        driver.findElement(By.id(color)).click();
    }

    public void inputComment(String comment) {
        driver.findElement(INPUT_ORDER_COURIER_MESSAGE).sendKeys(comment);
    }

    public void clickFinalConfirmButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(ORDER_FINAL_CONFIRM_BUTTON));
        driver.findElement(ORDER_FINAL_CONFIRM_BUTTON).click();
    }
    public boolean isConfirmationDisplayed() {
        String name = driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']")).getText();
        return (name.equals("Заказ оформлен"));
    }
}