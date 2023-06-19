package ru.yandex.praktikum.scooter.page.object;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
    public class RentScooterTest {
    private WebDriver driver;
    private final int buttonClick;
    private final String name;
    private final String lastName;
    private final String addres;
    private final String metroStation;
    private final String number;
    private final String date;
    private final int colourId;
    private final String commentText;

    public RentScooterTest(int buttonClick, String name, String lastName, String addres, String metroStation, String number,
                           String date, int colourId, String commentText) {
        this.buttonClick = buttonClick;
        this.name = name;
        this.lastName = lastName;
        this.addres = addres;
        this.metroStation = metroStation;
        this.number = number;
        this.date = date;
        this.colourId = colourId;
        this.commentText = commentText;
    }


    @Parameterized.Parameters
    public static Object[][] testOfMakingOrder() {
        return new Object[][]{
                {0, "Ольга", "Левицкая", "г. Москва, ул. Авиационная, д. 3", "Фили", "89036837281", "20.06.2023", 1, "позвоните за час"},
                {0, "Ян", "Ким", "Улица Космонавтом, д. 18", "Тверская", "79035678909", "01.07.2023", 0, "осторожно, злой кот"},
                {1, "Ольга", "Левицкая", "г. Москва, ул. Авиационная, д. 3", "Фили", "89036837281", "20.06.2023", 0, "позвоните за час"},
                {1, "Ян", "Ким", "Улица Космонавтом, д. 18", "Тверская", "79035678909", "01.07.2023", 1, "осторожно, злой кот"},
        };
    }

    @Before
    public void chooseBrowser(){
        WebDriverManager.chromedriver().setup(); //для запуска в браузере Google Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        /*WebDriverManager.firefoxdriver().setup(); // для запуска в Firefox
        FirefoxDriver options = new FirefoxDriver();
        driver = new FirefoxDriver(); */
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void getNumberOfOrder(){
        RentScooter rentScooter = new RentScooter(driver);
        rentScooter.clickToCloseCookie();
        rentScooter.clickOnButton(buttonClick);
        rentScooter.firstForm(name, lastName, addres, metroStation, number);
        rentScooter.secondForm(date, colourId, commentText);
        String result = rentScooter.clickToCheckOrderStatus();
        MatcherAssert.assertThat("Ошибка при оформлении заказа", result, is("Посмотреть статус"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

