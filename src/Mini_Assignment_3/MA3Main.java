package Mini_Assignment_3;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MA3Main {
    public static void main(String[] args) throws InterruptedException, IOException, AWTException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ndhurandher\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        frameAction(driver);
//        dragDrop(driver);
//        alertAction(driver);
//        dragDropJS(driver);
        ticketBooking(driver);

//        driver.quit();


    }
    public static void frameAction(WebDriver driver) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com");
        System.out.println("website opened");
        driver.findElement(By.xpath("//a[text() = 'Frames']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text() = 'Nested Frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println("frame opened");
        Thread.sleep(2000);
        WebElement l = driver.findElement(By.cssSelector("body"));
        System.out.println(l.getText());

    }

    public static void dragDrop(WebDriver driver){
        driver.get("https://jqueryui.com/droppable/");

        System.out.println("website opened");

        WebElement iframe  = driver.findElement(new By.ByClassName("demo-frame"));

        driver.switchTo().frame(iframe);

        WebElement From =driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement To =driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions act=new Actions(driver);

        act.dragAndDrop(From, To).build().perform();

        System.out.println("Drag & Drop performed");

    }

    public static void alertAction(WebDriver driver) throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com");
        System.out.println("website opened");
        driver.findElement(By.xpath("//a[text() = 'JavaScript Alerts']")).click();
        System.out.println("JavaScript Alerts clicked");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']")).click();
        System.out.println("Click for JS Prompt clicked");

        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.sendKeys("Test");
        String alertText = javascriptAlert.getText();
        System.out.println("input data :- " + alertText);
        javascriptAlert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id = 'result']"));
        String resultText = result.getText();

        if(resultText.contains(alertText)){
            System.out.println("Result is equal to input data");
        }else{
            System.out.println("Result is not equal to input data");

        }

    }

    public static void dragDropJS(WebDriver driver) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com");
        System.out.println("website opened");
        driver.findElement(By.xpath("//a[text() = 'Drag and Drop']")).click();
        System.out.println("Drag and Drop clicked");
        Thread.sleep(2000);

        WebElement from =driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='column-b']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(from).moveToElement(to).release(from).perform();
        System.out.println("Drag & Drop performed by using JavascriptExecutor");

    }

    public static void ticketBooking(WebDriver driver) throws InterruptedException, IOException, AWTException {

        driver.get("https://www.goibibo.com");
        System.out.println("website opened");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text() = 'Round-trip']")).click();
        System.out.println("Round trip clicked");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text() = 'From']")).click();
        driver.findElement(By.cssSelector("input[type*='text']")).sendKeys("New York");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//div[contains(@class,'sc-iAKWXU iyyKqe')]) ["+1+"]")).click();
        Thread.sleep(2000);
        System.out.println("From selected");

        driver.findElement(By.cssSelector("input[type*='text']")).sendKeys("Seattle");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//div[contains(@class,'sc-iAKWXU iyyKqe')]) ["+1+"]")).click();
        Thread.sleep(2000);

        System.out.println("To selected");


        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span[class*='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[class*='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[class*='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text() = '24']")).click();
        System.out.println("Departure date  selected");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text() = 'Return']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[class*='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text() = '8']")).click();
        System.out.println("Return date  selected");

        Thread.sleep(2000);

        takeScreenshot("flight booking");

        System.out.println("Take Screenshot ");

        driver.findElement(By.xpath("//span[text() = 'Travellers & Class']")).click();
        Thread.sleep(2000);

//
        driver.findElement(By.xpath("//span[text() = 'SEARCH FLIGHTS']")).click();
        System.out.println("Search for flight");

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        System.out.println("Cheapest flight :- "+ driver.findElement(By.xpath("(//div[contains(@class,'srp-card-uistyles__Price-sc-3flq99-17 gqEhhU alignItemsCenter dF fb lh1 padT5')]) ["+1+"]")).getText() );

        driver.findElement(By.xpath("(//button[contains(@class,'srp-card-uistyles__BookButton-sc-3flq99-21 bgObmb dF justifyCenter alignItemsCenter txtUpper')]) ["+1+"]")).click();
        System.out.println("Cheapest flight selected");
        Thread.sleep(2000);

        System.out.println("Booked");


    }

    public static void takeScreenshot(String fileName) throws IOException, AWTException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        ImageIO.write(image, "png", new File("C:\\Users\\ndhurandher\\Pictures\\Screenshorts\\"+fileName+".png"));

    }


}
