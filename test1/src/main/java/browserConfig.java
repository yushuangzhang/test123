import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserConfig {
    public static void closeDriver(WebDriver driver){
        driver.close();

    }
    public static WebDriver chromeConfig(){
//        System.setProperty("webdriver.chrome.driver","D:\\IDEAProject\\test1\\.idea\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver(); // 新建一个WebDriver 的对象，但是new 的是谷歌的驱动
//        driver.get("http://www.hao123.com/"); // 打开指定的网站.
        System.setProperty(ReadProperties.readrowserConfig(),ReadProperties.readBrowserConfigPath());
        WebDriver driver = new ChromeDriver(); // 新建一个WebDriver 的对象，但是new 的是谷歌的驱动
        driver.get(ReadProperties.readHomeUrl()); // 打开指定的网站
        deleteAllCookies(driver);
        return driver;
    }
    public static void deleteAllCookies(WebDriver driver){
        driver.manage().deleteAllCookies();
    }
}
