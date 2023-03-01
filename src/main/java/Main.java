import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.lutovinova\\chromedriver_win32\\chromedriver.exe");
        driver.get ("https://qa-scooter.praktikum-services.ru/");
    }
}
