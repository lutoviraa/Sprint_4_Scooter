package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static WebDriver driver;
    // Maine Page Locators
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private static final By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    public static By lowerOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");
    private final By headerOfQuestions = By.xpath(".//div[text()='Вопросы о важном']");
    private final By cookieButton = By.id("rcc-confirm-button");
   private static final By orderButton = By.xpath(".//*[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
       public MainPage(WebDriver driver) {

           this.driver = driver;
    }

    // Добавили методы
    public void openWebSite() {
       driver.get(url);
    }

   public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();}

    public void clickLowerOrderButton() {
        driver.findElement(lowerOrderButton).click();}
    //public void clickOrderButton() {
        //driver.findElement(MainPage.orderButton).click();    }
    public void scrollPageDown() {
        WebElement element = driver.findElement(headerOfQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickByQuestion(By question) {
        driver.findElement(question).click();
    }

    public String getText(By answer) {
        return driver.findElement(answer).getText();
    }

    public void clickOrderButton() {
        driver.findElement(MainPage.orderButton).click();
       }
}
