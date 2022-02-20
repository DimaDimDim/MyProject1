package First.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36 OPR/60.0.3255.170";
        //options.addPreference("general.useragent.override",userAgent);
        //options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver","D:\\Dima\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        String baseUrl = "https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D0%B1-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5";
        //String expectedTitle = "Welcome: Mercury Tours";
        //String actualTitle = "";

        driver.get(baseUrl);

        driver.manage().window().maximize();

        Thread.sleep(20000);

        //driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        //String innerText = js.executeScript(" return document.documentElement.innerText;").toString();LOOK HERE/*scrollable-wrapper*/
        String innerText = js.executeScript(" return document.getElementById('mw-content-text').innerText;").toString();
        //String innerText = driver.findElement(By.xpath("/html/body)")).getAttribute("innerText");
        System.out.println("Inner text of the first page = " + innerText);

        WebElement link = driver.findElement(By.linkText("клиент-серверное"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", link);

        /*((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://vbetua.com/uk/sports/pre-match/event-view/Soccer/World/18277589/18885573");
        https://parimatch.com/ru/events/romania-iceland-6764586


        Thread.sleep(5000);

        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        String innerText2 = js.executeScript(" return document.documentElement.innerText;").toString();
        System.out.println("Inner text of the second page = " + innerText2);


        /*List<WebElement> elements = driver.findElements(By.cssSelector("div[class='_2rPI9yrPGO1VWj1397_N7g.PoTHv8chiM7jFF-1Co2KR']"));
        System.out.println("Number of elements:" + elements.size());

        for (int i = 0; i<elements.size(); i++) {
            System.out.println("Radio button text:" + elements.get(i).getDomAttribute("class"));
        }

        //actualTitle = driver.getTitle();

        //System.out.println(actualTitle);

        /*if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }*/

        String input1 = "Total h1.5: 1.88 Total h2.5: 3.15 Total l1.5: 1.77 Total l2.5: 1.44";
        String input2 = "Total h1.5: 1.94 Total h2.5: 2.22 Total l1.5: 3.15 Total l2.5: 2.22";

        Pattern p = Pattern.compile("(Total h1.5|Total h2.5|Total l1.5|Total l2.5):\\s(\\S+)");
        Matcher m1 = p.matcher(input1);
        Matcher m2 = p.matcher(input2);

        while (m1.find()) {
            System.out.println(m1.group(1) + "\t" + m1.group(2));
        }

        while (m2.find()) {
            System.out.println(m2.group(1) + "\t" + m2.group(2));
        }
        //driver.close();
        //System.exit(0);
    }
}
