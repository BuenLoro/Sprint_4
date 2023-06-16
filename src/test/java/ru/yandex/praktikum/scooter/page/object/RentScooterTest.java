package ru.yandex.praktikum.scooter.page.object;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
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
    private static WebDriver driver;
    private final String buttonClick;
    private final String name;
    private final String lastName;
    private final String addres;
    private final String metroStation;
    private final String number;
    private final String date;
    private final String colourId;
    private final String commentText;

    public RentScooterTest(String buttonClick, String name, String lastName, String addres, String metroStation, String number,
                           String date, String colourId, String commentText) {
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
    public static Object[][] getResult() {
        return new Object[][]{
                {"//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]", "Ольга", "Левицкая", "г. Москва, ул. Авиационная, д. 3", "Фили", "89036837281", "20.06.2023", "black", "позвоните за час"},
                {"//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]", "Ян", "Ким", "Улица Космонавтом, д. 18", "Тверская", "79035678909", "01.07.2023", "grey", "серая безысходность"},
                {"//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button", "Ольга", "Левицкая", "г. Москва, ул. Авиационная, д. 3", "Фили", "89036837281", "20.06.2023", "grey", "позвоните за час"},
                {"//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button", "Ян", "Ким", "Улица Космонавтом, д. 18", "Тверская", "79035678909", "01.07.2023", "black", "серая безысходность"},
        };
    }

    @Test
    public void getNumberOfOrder(){
       WebDriverManager.chromedriver().setup(); //для запуска в браузере Google Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
       /* WebDriverManager.firefoxdriver().setup(); // для запуска в Firefox
        FirefoxDriver options = new FirefoxDriver();
        driver = new FirefoxDriver(); */
        driver.manage().window().maximize();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        RentScooter rentScooter = new RentScooter(driver);
        rentScooter.firstForm(buttonClick, name, lastName, addres, metroStation, number);
        rentScooter.secondForm(date, colourId, commentText);
        String result = rentScooter.clickToCheckOrderStatus();
        MatcherAssert.assertThat("Ошибка при оформлении заказа", result, is("Посмотреть статус"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

