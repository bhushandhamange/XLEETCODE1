package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        
        driver.get("https://leetcode.com/");

        String currentURL = driver.getCurrentUrl();

        if(currentURL.contains("leetcode")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        
        System.out.println("end Test case: testCase01");
    }


    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        
        driver.get("https://leetcode.com/");
        boolean blnFound = false;

        WebElement questions = driver.findElement(By.xpath("//a//p[text()='View Questions ']"));
        questions.click();
        Thread.sleep(5000);

        String currentURL = driver.getCurrentUrl();

        if(currentURL.contains("problemset")){
            System.out.println("problemset present");
        } else {
            System.out.println("problemset not present");
        }

        List<WebElement> ques = driver.findElements(By.xpath("//div[@role='row']//div[@role='cell'][2]"));

        for(int i=1; i<=5; i++){
            System.out.println("Question "+ i+1 + " : "+ ques.get(i).getText());

            if (ques.get(i).getText().contains("Two Sum")) {
                blnFound = true;
            }
        }

        if(blnFound){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }       
        
        System.out.println("end Test case: testCase02");
    }


    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        
        driver.get("https://leetcode.com/");

        WebElement questions = driver.findElement(By.xpath("//a//p[text()='View Questions ']"));
        questions.click();
        Thread.sleep(5000);

        List<WebElement> ques = driver.findElements(By.xpath("//div[@role='row']//div[@role='cell'][2]//a"));

        for(int i=1; i<=5; i++){
            // System.out.println("Question "+ i+1 + " : "+ ques.get(i).getText());

            if (ques.get(i).getText().contains("Two Sum")) {
                ques.get(i).click();
                break;
            }
        }

        Thread.sleep(5000);

        String currentURL = driver.getCurrentUrl();

        System.out.println(currentURL);

        if(currentURL.contains("two-sum")){
            System.out.println("two-sum present");
        } else {
            System.out.println("two-sum not present");
        }
        
        System.out.println("end Test case: testCase03");
    }


    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        
        driver.get("https://leetcode.com/");

        WebElement questions = driver.findElement(By.xpath("//a//p[text()='View Questions ']"));
        questions.click();
        Thread.sleep(5000);

        List<WebElement> ques = driver.findElements(By.xpath("//div[@role='row']//div[@role='cell'][2]//a"));

        for(int i=1; i<=5; i++){
            if (ques.get(i).getText().contains("Two Sum")) {
                ques.get(i).click();
                break;
            }
        }

        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[text()='Submissions'][2]")).click();

        Thread.sleep(2000);

        WebElement registerSignIn = driver.findElement(By.xpath("//div[@class='flexlayout__tab']//a[contains(@class,'px-3')]"));

        if(registerSignIn.isDisplayed()){
            String text = registerSignIn.getText();
            if(text.contains("Register or Sign In")){
                System.out.println("Register or Sign In is displayed");
            } else {
                System.out.println("Register or Sign In is not displayed");
            }
        }
        
        System.out.println("end Test case: testCase04");
    }


}
