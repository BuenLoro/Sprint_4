package ru.yandex.praktikum.scooter.page.object;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
    public class MainPageTest {
        private static WebDriver driver;
        private final String answerText;
        private final String answerId;
        private final String questionId;

        public MainPageTest(String answerText, String answerId, String questionId) {
            this.answerText = answerText;
            this.answerId = answerId;
            this.questionId = questionId;
        }

        @Parameterized.Parameters
        public static Object[][] getText() {
            return new Object[][]{
                    {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "accordion__panel-0", "accordion__heading-0"},
                    {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "accordion__panel-1", "accordion__heading-1"},
                    {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "accordion__panel-2", "accordion__heading-2"},
                    {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "accordion__panel-3", "accordion__heading-3"},
                    {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "accordion__panel-4", "accordion__heading-4"},
                    {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "accordion__panel-5", "accordion__heading-5"},
                    {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "accordion__panel-6", "accordion__heading-6"},
                    {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", "accordion__panel-7", "accordion__heading-7"},
            };

        }

        @Test
        public void getMainPageTest() {
            WebDriverManager.chromedriver().setup(); //для запуска в браузере Google Chrome
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            /* WebDriverManager.firefoxdriver().setup(); // для запуска в Firefox
            FirefoxDriver options = new FirefoxDriver();
            driver = new FirefoxDriver(); */
            driver.manage().window().maximize();
            // переход на страницу тестового приложения
            driver.get("https://qa-scooter.praktikum-services.ru/");
            MainPage mainPage = new MainPage(driver);
            String result = mainPage.getTextQuestionForm(answerId, questionId);
            MatcherAssert.assertThat("текст не соответствует", answerText, is(result));
        }
        @After
        public void teardown() {
            driver.quit();
        }
    }

