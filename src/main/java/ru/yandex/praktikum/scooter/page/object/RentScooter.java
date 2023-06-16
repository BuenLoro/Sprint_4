package ru.yandex.praktikum.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentScooter {
    private WebDriver driver;

    // поле Имя клиента
    private final By userName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");

    // поле Фамилия клиента
    private final By userLastName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");

    // поле Адрес клиента
    private final By userAddress = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");

    // поле с выпадающим списком станций метро
    private final By subwayStation = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/input");

    // поле Номера телефона клиента
    private final By phoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");

    // кнопка Далее в окне Для кого самокат
    private final By openSecondForm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    // поле Когда привезут самокат (выбор даты)
    private final By rentDay = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");

    //ниже находятся локаторы на каждый вариант длительности аренды самоката
    private final By countOfDays = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]"); //сутки
    // private final By countOfDays = By.xpath("//*[@id="root"]/div/div[2]/div[2]/div[2]/div[2]/div[2]"); //двое суток
    // private final By countOfDays = By.xpath("//*[@id="root"]/div/div[2]/div[2]/div[2]/div[2]/div[3]"); // трое суток
    // private final By countOfDays = By.xpath("//*[@id="root"]/div/div[2]/div[2]/div[2]/div[2]/div[4]"); //четверо суток
    // private final By countOfDays = By.xpath("//*[@id="root"]/div/div[2]/div[2]/div[2]/div[2]/div[5]"); //пять суток
    // private final By countOfDays = By.xpath("//*[@id="root"]/div/div[2]/div[2]/div[2]/div[2]/div[6]"); //шестеро суток
    // private final By countOfDays = By.xpath("//*[@id="root"]/div/div[2]/div[2]/div[2]/div[2]/div[7]"); //семеро суток

    // поле Срок аренды
    private final By rentDuring = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/span");

    // поле Комментарий
    private final By comment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");

    // кнопка Заказать в окне Про аренду
    private final By buttonToOrder = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");

    // кнопка ДА (подтверждение заказа) в окне Хотите оформить заказ
    private final By buttonToConfirmOrder = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    // кнопка Посмотреть статус в окне Заказ оформлен
    private final By buttonCheckStatus = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button");

    // кнопка Уже привыкли в сообщении о cookie
    private final By closeCookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    // поле Номер телефона
    public RentScooter(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnButton(String buttonClick) {
        driver.findElement(By.xpath(buttonClick)).click();
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
    public void clickOnColour(String colourId){
        driver.findElement(By.id(colourId)).click();
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
    public void firstForm(String buttonClick, String name, String lastName, String addres, String metroStation, String number){
        clickToCloseCookie();
        clickOnButton(buttonClick);
        clickOnName(name);
        clickOnLastName(lastName);
        clickOnAddress(addres);
        clickToChooseStation(metroStation);
        clickOnNumber(number);
        clickToOpenSecondForm();
    }
    public void secondForm(String date, String colourId, String commentText){
        clickOnRentDay(date);
        clickOnDuring();
        chooseDuring();
        clickOnColour(colourId);
        clickOnComment(commentText);
        clickToOrder();
        clickToConfirm();
    }
}
