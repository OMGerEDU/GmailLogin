import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;


public class automate
{
    public static void main(String[] args) {


        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        // Add arguments to mimic undetected_chromedriver
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);        driver.manage().window().maximize();
        rumGmail(driver);
        //rumGmail(driver);

        // driver.quit();
    }

    private  static  void waitForMe(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private  static  void waitForMe(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private static void rumGmail(WebDriver driver){
        //warmUp(driver);
        driver.get("https://accounts.google.com/InteractiveLogin");
        waitForMe();
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("pehankannangara20@gmail.com");
        waitForMe();
        driver.findElement(By.id("identifierNext")).click();
        waitForMe(10);
        driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("LMS@Pehan0");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        waitForMe(10);
        System.out.println("operation sucessful");
        waitForMe(10);
        driver.quit();





    }

    public static void warmUp(WebDriver driver) {
        String[] urls = {"https://www.google.com/", "https://login.yahoo.com/","https://www.wikipedia.org/","https://www.facebook.com/"};
        for(String str: urls) {
            driver.get(str);
            waitForMe(10);
        }
    }

}
