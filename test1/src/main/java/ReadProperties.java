import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    //URLTxt地址
    public static String urlTxtPath(){
        String urlTxtPath = "";
        try{
            //建立Properties对象
            Properties prop = new Properties();
            //获取文件流
            InputStream ips = ReadProperties.class.getClassLoader().getResourceAsStream("test.properties");
            //加载文件流
            prop.load(ips);
            urlTxtPath=prop.getProperty("urlTxtPath");
            // ips.close();

        }catch (Exception e){
            //e.printStackTrace();
            System.out.println(e);
        }
        return urlTxtPath;

    }
    public static String excelTxtPath(){
        String excelTxtPath = "";
        try{
            //建立Properties对象
            Properties prop = new Properties();
            //获取文件流
            InputStream ips = ReadProperties.class.getClassLoader().getResourceAsStream("test.properties");
            //加载文件流
            prop.load(ips);
            excelTxtPath=prop.getProperty("excelTxtPath");
            //设置乱码
            excelTxtPath=new String(excelTxtPath.getBytes("ISO-8859-1"),"gbk");
            //System.out.println("excel文件："+excelTxtPath);
            // ips.close();

        }catch (Exception e){
            //e.printStackTrace();
            System.out.println(e);
        }
        return excelTxtPath;

    }
}
