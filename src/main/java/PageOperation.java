import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOperation {
    //首页
    public static void homePage(String searchText, WebDriver driver){
        driver.findElement(By.xpath("//*[@id=\"search\"]/form/div[2]/input")).sendKeys(searchText);
        //点击“搜索”
        driver.findElement(By.xpath("//*[@id=\"search\"]/form/div[3]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/form/div[2]/input")).clear();
    }
    //其他页面
    public static void otherPage(){

    }
}
