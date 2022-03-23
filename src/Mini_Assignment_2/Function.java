package Mini_Assignment_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class Function {

    WebDriver driver;


    public  Function (WebDriver driver){

        this.driver  = driver;

    }

    public void runProgram() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");

        System.out.println("Main Page open");

        String parentWindow = driver.getWindowHandle();

        String homePageTitle = driver.getTitle();


        if(homePageTitle.contains("PHPTRAVELS")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


        WebElement loginBtn = driver.findElement(By.xpath("//a[text() = 'Login']"));
        loginBtn.click();
        System.out.println("Open Login Page");
        sleep(5000);
        String loginPageTitle = driver.getTitle();

        if(loginPageTitle.equals(homePageTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


        driver.switchTo().window(parentWindow);

        System.out.println("Back to Main Page");

        String webPageUrl = driver.getCurrentUrl();

        System.out.println("Current Page Url : -"+webPageUrl);

        sleep(3000);

        WebElement priceBtn= driver.findElement(By.xpath("//a[text() = 'Pricing']"));

        priceBtn.click();

        System.out.println("Open Pricing Page");

        sleep(3000);

        driver.navigate().back();

        System.out.println("Again Back to Main Page");

        sleep(3000);

        driver.navigate().refresh();

        System.out.println("Refresh Page ");

        sleep(3000);

        driver.close();

        System.out.println("Close tab");

        System.out.println("End of Program");
    }
}
