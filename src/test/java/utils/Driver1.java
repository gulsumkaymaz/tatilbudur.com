package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver1 {

    /*
  Creating the private constructor so this class' object
  is not reachable from outside
   */
    private Driver1() {
    }

    /*
    Making our 'driver' instance private so that it is not reachable from outside of the class.
    We make it static, because we want it to run before everything else, and also we will use it in a static method
     */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /*
    Creating re-usable utility method that will return same 'driver' instance everytime we call it.
     */
    public static WebDriver getDriver() {
        //setting various capabilities for browsers
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("use-fake-ui-for-media-stream");
        // co.addArguments("--incognito");
        // co.addArguments("--headless=new");

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("use-fake-ui-for-media-stream");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("use-fake-ui-for-media-stream");


        if (driverPool.get() == null) {
            synchronized (Driver1.class) {

            /*
            We read our browser type from configuration.properties file using
            .getProperty method we creating in ConfigurationReader class.
             */
                // String browserType = Config.getProperty("browser");

                // Maven parametres
                String browserType = "chrome";
            /*
            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */
                switch (browserType) {

                    case "chrome":
                        driverPool.set(new ChromeDriver(chromeOptions));

                        break;
                    case "firefox":
                        driverPool.set(new FirefoxDriver(firefoxOptions));

                        break;
                    case "edge":
                        driverPool.set(new EdgeDriver(edgeOptions));

                        break;

                    case "safari":
                        driverPool.set(new SafariDriver());
                        break;

                    case "chrome-headless":
                        chromeOptions.addArguments("--headless=new");
                        driverPool.set(new ChromeDriver(chromeOptions));
                        break;

                }

            }
        }

        driverPool.get().manage().window().maximize();
        driverPool.get().manage().deleteAllCookies();
        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driverPool.get();
    }

    /*
    This method makes sure we have some form of driver sesion or driver id has.
    Either null or not null it must exist.
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
