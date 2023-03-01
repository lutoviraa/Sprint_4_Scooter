package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class OrderPage {
        private WebDriver driver;
        // Локаторы для полей формы заказа
        private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
        private static final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
        private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
        private final By metroStationField = By.xpath(".//input[@class='select-search__input']");
        private final By metroStationSearch = By.xpath(".//div[@class='select-search__select']/ul/li/button/div[2]");
        private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
        private final By nextButton = By.xpath(".//button[text()='Далее']");

        public OrderPage(WebDriver driver) {

            this.driver = driver;
        }

        //Методы для ввода данных
        public void inputFirstName(String firstName) {
            driver.findElement(firstNameField).click();
            driver.findElement(firstNameField).sendKeys(firstName);
        }

        public void inputLastName(String lastName) {
            driver.findElement(lastNameField).click();
            driver.findElement(lastNameField).sendKeys(lastName);
        }

        public void inputAddress(String address) {
            driver.findElement(addressField).click();
            driver.findElement(addressField).sendKeys(address);
        }

        public void choiceMetroStation(String metroStation) {
            driver.findElement(metroStationField).click();
            driver.findElement(metroStationField).sendKeys(metroStation);
            driver.findElement(metroStationSearch).click();
        }

        public void inputPhoneNumber(String phoneNumber) {
            driver.findElement(phoneField).click();
            driver.findElement(phoneField).sendKeys(phoneNumber);
        }

        public void clickNextButton() {
            driver.findElement(nextButton).click();
        }

        public void setPersonality(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
            inputFirstName(firstName);
            inputLastName(lastName);
            inputAddress(address);
            choiceMetroStation(metroStation);
            inputPhoneNumber(phoneNumber);
            clickNextButton();
        }


    }
