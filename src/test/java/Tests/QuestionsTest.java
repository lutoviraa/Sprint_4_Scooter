package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.FaqData;
import pageobject.MainPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

// Class of Test answers && questions
    @RunWith(Parameterized.class)
    public class CompareAnswersText {
    //driver = new FireFoxDriver();
    private WebDriver driver = new ChromeDriver();
        private static By question;
        private static By answer;
        private static String text;

        // Составили конструктор с вопросами,
        public CompareAnswersText(By question, By answer, String text) {
            this.question = question;
            this.answer = answer;
            this.text = text;
        }

       @Parameterized.Parameters

        public static Iterable<Object[]> data() {
            List<Object[]> objects = Arrays.asList(new Object[][]{
                    {FaqData.question1, FaqData.answer1, FaqData.text1},
                    {FaqData.question2, FaqData.answer2, FaqData.text2},
                    {FaqData.question3, FaqData.answer3, FaqData.text3},
                    {FaqData.question4, FaqData.answer4, FaqData.text4},
                    {FaqData.question5, FaqData.answer5, FaqData.text5},
                    {FaqData.question6, FaqData.answer6, FaqData.text6},
                    {FaqData.question7, FaqData.answer7, FaqData.text7},
                    {FaqData.question8, FaqData.answer8, FaqData.text8}
            });
            return objects;
        }
        @Before
        public void setUp() {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            MainPage mainPage = new MainPage(driver);
            mainPage.clickCookieButton();
            mainPage.openWebSite();
            mainPage.scrollPageDown();

        }

        // Прописан тест к вопросам
        @Test
        public void compareTextAnswers() {
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

