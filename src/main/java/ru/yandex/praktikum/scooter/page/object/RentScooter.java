package ru.yandex.praktikum.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentScooter {
    private WebDriver driver;

    // верхняя кнопка Заказать
    private final By firstButton = By.xpath("//div/button[@class='Button_Button__ra12g']");

    // нижняя кнопка Заказать
    private final By secondButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // поле Имя клиента
    private final By userName = By.xpath(".//input[@placeholder='* Имя']");

    // поле Фамилия клиента
    private final By userLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле Адрес клиента
    private final By userAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле с выпадающим списком станций метро
    private final By subwayStation = By.className("select-search__input");

    // поле Номера телефона клиента
    private final By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка Далее в окне Для кого самокат
    private final By openSecondForm = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // поле Когда привезут самокат (выбор даты)
    private final By rentDay = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //ниже находится локатор на каждый вариант длительности аренды самоката
    private final By countOfDays = By.xpath("//div[contains(text(),'сутки')]"); //сутки

    // поле Срок аренды
    private final By rentDuring = By.className("Dropdown-placeholder");

    // поле Комментарий
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // кнопка Заказать в окне Про аренду
    private final By buttonToOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // кнопка ДА (подтверждение заказа) в окне Хотите оформить заказ
    private final By buttonToConfirmOrder = By.xpath(".//button[text()='Да']");

    // кнопка Посмотреть статус в окне Заказ оформлен
    private final By buttonCheckStatus = By.xpath(".//button[text()='Посмотреть статус']");

    // кнопка Уже привыкли в сообщении о cookie
    private final By closeCookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Локатор для  чёрного цвета
    private By blackColour = By.id("black");

    //Локаторы для серого цвета
    private By greyColour = By.id("grey");

    public RentScooter(WebDriver driver) {

        this.driver = driver;
    }

    public void clickOnButton(int chooseTheButton) {
            if (chooseTheButton == 0){
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(firstButton));
                driver.findElement(firstButton).click();
            }else {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(secondButton));
                driver.findElement(secondButton).click();
            }
    }
    public void clickOnName(String name){
        driver.findElement(userName).click();
        driver.findElement(userName).sendKeys(name);
    }
    public void clickOnLastName(String lastName){
        driver.findElement(userLastName).sendKeys(lastName);
    }
    public void clickOnAddress(String address){
        driver.findElement(userAddress).sendKeys(address);
    }
    public void clickToChooseStation(String metroStation){
        driver.findElement(subwayStation).click();
        driver.findElement(subwayStation).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void clickOnNumber(String number){
        driver.findElement(phoneNumber).sendKeys(number);
    }
    public void clickToOpenSecondForm(){
        driver.findElement(openSecondForm).click();
    }
    public void clickOnRentDay(String date){ //выбрать дату когда привезут самокат
        driver.findElement(rentDay).sendKeys(date, Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void clickOnDuring(){ //нажать на стрелочку, чтобы увидеть выпадающий список
        driver.findElement(rentDuring).click();
    }
    public void chooseDuring(){
        driver.findElement(countOfDays).click();
    }
    public void clickOnColour(int chooseColour){
        if (chooseColour == 0){
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(greyColour));
            driver.findElement(greyColour).click();
        } else {
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(blackColour));
            driver.findElement(blackColour).click();
        }
    }
    public void clickOnComment(String commentText){
        driver.findElement(comment).sendKeys(commentText);
    }
    public void clickToOrder(){
        driver.findElement(buttonToOrder).click();
    }
    public void clickToConfirm(){
        driver.findElement(buttonToConfirmOrder).click();
    }
    public String clickToCheckOrderStatus(){
        return driver.findElement(buttonCheckStatus).getText();
    }
    public void clickToCloseCookie(){
        driver.findElement(closeCookie).click();
    }
    public void firstForm(String name, String lastName, String addres, String metroStation, String number){
        clickOnName(name);
        clickOnLastName(lastName);
        clickOnAddress(addres);
        clickToChooseStation(metroStation);
        clickOnNumber(number);
        clickToOpenSecondForm();
    }
    public void secondForm(String date, int chooseColour, String commentText){
        clickOnRentDay(date);
        clickOnDuring();
        chooseDuring();
        clickOnColour(chooseColour);
        clickOnComment(commentText);
        clickToOrder();
        clickToConfirm();
    }
}
