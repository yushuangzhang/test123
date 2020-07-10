import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {


    //浏览器驱动位置
    public static String readBrowserConfigPath(){
        String browserConfigPath = "";
        try{
            //建立Properties对象
            Properties prop = new Properties();
            //获取文件流
            InputStream ips = ReadProperties.class.getClassLoader().getResourceAsStream("test.properties");
            //加载文件流
            prop.load(ips);
            browserConfigPath=prop.getProperty("chromeDriver");
           // ips.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return browserConfigPath;

    }
    //加载的浏览器
    public static String readrowserConfig(){
        String browserConfig = "";
        try{
            //建立Properties对象
            Properties prop = new Properties();
            //获取文件流
            InputStream ips = ReadProperties.class.getClassLoader().getResourceAsStream("test.properties");
            //加载文件流
            prop.load(ips);
            browserConfig=prop.getProperty("browserConfig");
           // ips.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return browserConfig;

    }
    //首页地址
    public static String readHomeUrl(){
        String homeUrl = "";
        try{
            //建立Properties对象
            Properties prop = new Properties();
            //获取文件流
            InputStream ips = ReadProperties.class.getClassLoader().getResourceAsStream("test.properties");
            //加载文件流
            prop.load(ips);
            homeUrl=prop.getProperty("homeUrl");
           // ips.close();

        }catch (Exception e){
            //e.printStackTrace();
            System.out.println(e);
        }
        return homeUrl;

    }

}
