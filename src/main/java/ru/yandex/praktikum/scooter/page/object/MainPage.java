package ru.yandex.praktikum.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    // форма с популярными вопросами и ответами
    private final By questionForm = By.xpath("//div[text()='Вопросы о важном']");

    //Локатор для вопроса о цене
    private final By price = By.id("accordion__heading-0");

    //Локатор для вопроса о нескольких самокатах
    private final By fewScooters = By.id("accordion__heading-1");

    //Локатор для вопроса о расчёте времени аренды
    private final By rentDuration = By.id("accordion__heading-2");

    //Локатор для вопроса о доставке скутара в день заказа
    private final By scooterToday = By.id("accordion__heading-3");

    //Локатор для вопроса о продлении аренды
    private final By moreTimeToRent = By.id("accordion__heading-4");

    //Локатор для вопроса о зарядке для самоката
    private final By powerBank = By.id("accordion__heading-5");

    //Локатор для вопроса можно ли отменить заказ
    private final By cancelOrder = By.id("accordion__heading-6");

    //Локатор для вопроса о доставке за мкад
    private final By moscowArea = By.id("accordion__heading-7");

    //Локатор для ответа на вопрос о цене
    private final By answerPrice = By.id("accordion__panel-0");

    //Локатор для ответа на вопрос нескольких самокатах
    private final By answerFewScooters = By.id("accordion__panel-1");

    //Локатор для ответа на вопрос о расчёте времени аренды
    private final By answerRentDuration = By.id("accordion__panel-2");

    //Локатор для ответа на вопрос о доставке самоката в день заказа
    private final By answerScooterToday = By.id("accordion__panel-3");

    //Локатор для ответа на вопрос о продлении аренды самоката
    private final By answerMoreTimeToRent = By.id("accordion__panel-4");

    //Локатор для ответа на вопроспривизут ли зарядку
    private final By answerPowerBank = By.id("accordion__panel-5");

    //Локатор для ответа на вопрос можно ли отменить заказ
    private final By answerCancelOrder = By.id("accordion__panel-6");

    //Локатор для ответа на вопрос доставляетсяли за мкад
    private final By answerMoscowArea = By.id("accordion__panel-7");


    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public void getTextQuestionForm() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(questionForm));
        WebElement element = driver.findElement(questionForm);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getTextOfPrice() {
        getTextQuestionForm();
        driver.findElement(price).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerPrice));
        return driver.findElement(answerPrice).getText();
    }

    public String getTextOfFewScooters() {
        getTextQuestionForm();
        driver.findElement(fewScooters).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerFewScooters));
        return driver.findElement(answerFewScooters).getText();
    }

    public String getTextOfRentDuration() {
        getTextQuestionForm();
        driver.findElement(rentDuration).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerRentDuration));
        return driver.findElement(answerRentDuration).getText();
    }

    public String getTextOfScooterToday() {
        getTextQuestionForm();
        driver.findElement(scooterToday).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerScooterToday));
        return driver.findElement(answerScooterToday).getText();
    }

    public String getTextOfMoreTimeToRent() {
        getTextQuestionForm();
        driver.findElement(moreTimeToRent).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerMoreTimeToRent));
        return driver.findElement(answerMoreTimeToRent).getText();
    }

    public String getTextOfPowerBank() {
        getTextQuestionForm();
        driver.findElement(powerBank).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerPowerBank));
        return driver.findElement(answerPowerBank).getText();
    }

    public String getTextOfCancelOrder() {
        getTextQuestionForm();
        driver.findElement(cancelOrder).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerCancelOrder));
        return driver.findElement(answerCancelOrder).getText();
    }

    public String getTextOfMoscowAreaField() {
        getTextQuestionForm();
        driver.findElement(moscowArea).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(answerMoscowArea));
        return driver.findElement(answerMoscowArea).getText();
    }

    public String getTextOfQuestionField(int id) {
        if (id == 0) {
            return getTextOfPrice();
        } else if (id == 1) {
            return getTextOfFewScooters();
        } else if (id == 2) {
            return getTextOfRentDuration();
        } else if (id == 3) {
            return getTextOfScooterToday();
        } else if (id == 4) {
            return getTextOfMoreTimeToRent();
        } else if (id == 5) {
            return getTextOfPowerBank();
        } else if (id == 6) {
            return getTextOfCancelOrder();
        } else if (id == 7) {
            return getTextOfMoscowAreaField();
        } else {
            return "Несуществующий id";
        }
    }
}