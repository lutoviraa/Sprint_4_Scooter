package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.FaqData;
import pageobject.MainPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

        // Составили конструктор с вопросами,
        @RunWith(Parameterized.class)
    public class QuestionsTest {
        private WebDriver driver;
        private static By question;
        private static By answer;
        private static String text;

        // Конструктор
        public QuestionsTest(By question, By answer, String text) {
            this.question = question;
            this.answer = answer;
            this.text = text;
        }
            //Параметры
        @Parameterized.Parameters

        public static Iterable<Object[]> data(){
            return  Arrays.asList(new Object[][] {
                    {FaqData.question1, FaqData.answer1, FaqData.text1},
                    {FaqData.question2, FaqData.answer2, FaqData.text2},
                    {FaqData.question3, FaqData.answer3, FaqData.text3},
                    {FaqData.question4, FaqData.answer4, FaqData.text4},
                    {FaqData.question5, FaqData.answer5, FaqData.text5},
                    {FaqData.question6, FaqData.answer6, FaqData.text6},
                    {FaqData.question7, FaqData.answer7, FaqData.text7},
                    {FaqData.question8, FaqData.answer8, FaqData.text8}
            });
        }
        @Before
        public void setUp() {
            //driver = new FireFoxDriver();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            MainPage mainPage = new MainPage(driver);
            mainPage.openWebSite();
            mainPage.scrollPageDown();
            mainPage.clickCookieButton();
        }
        @Test
        public void TextAnswers() {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickByQuestion(question);
            mainPage.getText(answer);
            Assert.assertEquals(mainPage.getText(answer), text);
        }
       @After
        public void tearDown() {
            driver.quit();
        }
    }