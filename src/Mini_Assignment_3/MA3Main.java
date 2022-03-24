package Mini_Assignment_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MA3Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ndhurandher\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        frameAction(driver);
//        dragDrop(driver);
//        alertAction(driver);
        dragDropJS(driver);


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
//
        WebElement to =driver.findElement(By.xpath("//div[@id='column-b']"));
//
        Actions actions = new Actions(driver);
        actions.clickAndHold(from).moveToElement(to).release(from).perform();
        System.out.println("Drag & Drop performed by using JavascriptExecutor");


    }

}
