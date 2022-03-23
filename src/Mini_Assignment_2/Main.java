package Mini_Assignment_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ndhurandher\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Function function = new Function(driver);
        function.runProgram();
    }
}
