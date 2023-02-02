import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.model.MainPage;
import ru.yandex.practicum.model.OrderPage;

public class OrderPageTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void OrderViaUpperButton() { //Верхняя кнопка
        MainPage page = new MainPage(driver);
        page.open();
        page.clickUpperNewOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFirstName("Юзернейм");
        orderPage.inputLastName("Иванов");
        orderPage.inputAddress("Пушкина 18");
        orderPage.inputSubway("Комсомольская");
        orderPage.inputPhone("88005553535");
        orderPage.clickNextButton();
        orderPage.inputDeliveryDate("09");
        orderPage.inputDuration("трое суток");
        orderPage.chooseColor("black");
        orderPage.inputComment("Проверка");
        orderPage.clickNextButton();
        orderPage.clickFinalConfirmButton();
        Assert.assertTrue("Экран успешного создания заказа не отобразился", orderPage.isConfirmationDisplayed());

    }

    @Test
    public void OrderViaMiddleButtonPom() { //Средняя кнопка
        MainPage page = new MainPage(driver);
        page.open();
        page.clickMiddleNewOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFirstName("Константин");
        orderPage.inputLastName("Константинопольский");
        orderPage.inputAddress("Колотушкина 18");
        orderPage.inputSubway("Лубянка");
        orderPage.inputPhone("84952741001");
        orderPage.clickNextButton();
        orderPage.inputDeliveryDate("15");
        orderPage.inputDuration("сутки");
        orderPage.chooseColor("grey");
        orderPage.inputComment("Не приезжайте");
        orderPage.clickNextButton();
        orderPage.clickFinalConfirmButton();
        Assert.assertTrue("Экран успешного создания заказа не отобразился", orderPage.isConfirmationDisplayed());

    }


    @After
    public void cleanUp() {
        new WebDriverWait(driver, 5);
        driver.quit();
    }
}
