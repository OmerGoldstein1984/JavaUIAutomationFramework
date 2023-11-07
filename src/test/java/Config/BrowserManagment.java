package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserManagment {
    static WebDriver driver;

    public static WebDriver SetDriver() {
        String browser = System.getProperty("browser", "ch");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");

        if (browser.equalsIgnoreCase("ch")) {
            WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().setup();
            if (System.getProperty("os.name").toLowerCase().equals("linux")) {
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }
        }
        if (browser.equalsIgnoreCase("ff")) {
            WebDriverManager.firefoxdriver().create();
            if (System.getProperty("os.name").toLowerCase().equals("linux")) {
                driver = new FirefoxDriver(firefoxOptions);
            } else {
                driver = new FirefoxDriver();
            }
        }
        //driver.manage().window().max();
        return driver;
    }

}
