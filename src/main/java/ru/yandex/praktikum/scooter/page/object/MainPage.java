package ru.yandex.praktikum.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static WebDriver driver;
    // форма с популярными вопросами и ответами
    private final By questionForm = By.xpath("//div[text()='Вопросы о важном']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTextQuestionForm(String answerText, String questionText) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(questionForm));
        WebElement element = driver.findElement(questionForm);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id(questionText)).click();
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerText)));
        return driver.findElement(By.id(answerText)).getText();
    }
}