package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.OrderPage;
import pageobject.RentPage;

import java.time.Duration;
import java.util.Arrays;

    @RunWith(Parameterized.class)
    public class OrderTest {

        private WebDriver driver;
        private final String firstName;
        private final String lastName;
        private final String address;
        private final String metroStation;
        private final String phoneNumber;
        private final String anyDay;
        private final String comment;

        //Создали конструктор
        public OrderTest(String firstName, String lastName, String address, String metroStation, String phoneNumber, String anyDay, String comment) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.metroStation = metroStation;
            this.phoneNumber = phoneNumber;
            this.anyDay = anyDay;
            this.comment = comment;
        }

        // Parameterized Parameters
        @Parameterized.Parameters
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Ольга", "Иванова", "ул Мира, 1",
                            "ВДНХ", "89999999999", "01.07.2022", "спасибо"},
                    {"Сергей", "Сидоров", "пр Мира, 2", "Домодедовская", "86667775544", "22.10.2022",
                            "срочно"}

            });
        }

        @Before
        public void setUp() {
            //driver = new FireFoxDriver();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            MainPage mainPage = new MainPage(driver);
            mainPage.openWebSite();
            mainPage.clickCookieButton();
        }

        // Тест для создания заказа по верхней кнопке Button
        @Test
        public void orderSamokatFromTopOrderButton() {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickTopOrderButton();
            OrderPage orderPage = new OrderPage(driver);
            orderPage.setPersonality(firstName, lastName, address, metroStation, phoneNumber);
            //Test Data for Rent Page
            RentPage rentPage = new RentPage(driver);
            rentPage.setOrder(anyDay, comment);
            Assert.assertTrue(rentPage.checkComplitelyOrder());
        }

        // Тест для создания заказа по нижней кнопке Button
        @Test
        public void orderSamokatFromLowerOrderButton() {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickLowerOrderButton();
            // Test Data for Order Page
            OrderPage orderPage = new OrderPage(driver);
            orderPage.setPersonality(firstName, lastName, address, metroStation, phoneNumber);
            // Test Data for Rent Page
            RentPage rentPage = new RentPage(driver);
            rentPage.setOrder(anyDay, comment);
            Assert.assertTrue(rentPage.checkComplitelyOrder());
        }
       @After
        public void tearDown() {
            driver.quit();
        }
}
