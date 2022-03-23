package Mini_Assignment_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class main {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ndhurandher\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        String parentWindow = driver.getWindowHandle();

        String homePageTitle = driver.getTitle();


        if(homePageTitle.contains("PHPTRAVELS")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


        WebElement loginBtn = driver.findElement(By.xpath("//a[text() = 'Login']"));
        loginBtn.click();
        sleep(5000);
        String loginPageTitle = driver.getTitle();

        if(loginPageTitle.equals(homePageTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


        driver.switchTo().window(parentWindow);

        String webPageUrl = driver.getCurrentUrl();

        System.out.println("Current Page Url : -"+webPageUrl);

        sleep(3000);

        WebElement priceBtn= driver.findElement(By.xpath("//a[text() = 'Pricing']"));

        priceBtn.click();

        sleep(3000);

        driver.navigate().back();

        sleep(3000);

        driver.navigate().refresh();

        sleep(3000);

        driver.close();

        System.out.println("End of Program");


    }
}
