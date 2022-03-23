package Mini_Assignment_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessMode {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ndhurandher\\Downloads\\chromedriver.exe");

        WebDriver driver;
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        driver=new ChromeDriver(options);


        Function function = new Function(driver);
        function.runProgram();

    }
}
