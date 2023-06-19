package ru.yandex.praktikum.scooter.page.object;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
    public class MainPageTest {
        private WebDriver driver;
        private final String answerText;
        private final int idOfField;

        public MainPageTest(String answerText, int idOfField) {
            this.answerText = answerText;
            this.idOfField = idOfField;
        }

        @Parameterized.Parameters
        public static Object[][] getText() {
            return new Object[][]{
                    {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                    {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                    {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                    {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                    {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                    {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                    {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                    {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
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
        public void getMainPageTest() {
            MainPage mainPage = new MainPage(driver);
            String result = mainPage.getTextOfQuestionField(idOfField);
            MatcherAssert.assertThat("текст не соответствует", result, is(answerText));
        }
        @After
        public void teardown() {
            driver.quit();
        }
    }

