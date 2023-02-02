import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.model.MainPage;

import static org.hamcrest.CoreMatchers.containsString;

public class MainPageTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void AccordionExpandTextVisibilityTest() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickToCloseCookieNotification();//Закрываем уведомление о куках

        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); //Проматываем до аккордеона

        //В красивый массив не собрал из-за того, что в лямбда-выражение таймера нельзя подставить переменную, IDE ругается

        driver.findElement(By.id("accordion__heading-0")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-0")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-0")).getText(), containsString("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));

        driver.findElement(By.id("accordion__heading-1")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-1")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-1")).getText(), containsString("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));

        driver.findElement(By.id("accordion__heading-2")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-2")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-2")).getText(), containsString("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));

        driver.findElement(By.id("accordion__heading-3")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-3")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-3")).getText(), containsString("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));

        driver.findElement(By.id("accordion__heading-4")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-4")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-4")).getText(), containsString("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));

        driver.findElement(By.id("accordion__heading-5")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-5")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-5")).getText(), containsString("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));

        driver.findElement(By.id("accordion__heading-6")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-6")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-6")).getText(), containsString("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));

        driver.findElement(By.id("accordion__heading-7")).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.id("accordion__panel-7")).getText() != null));
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-7")).getText(), containsString("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }
    @After
    public void cleanUp() {
        new WebDriverWait(driver, 5);
        driver.quit();
    }

}
