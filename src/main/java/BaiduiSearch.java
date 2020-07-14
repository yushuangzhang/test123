import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class BaiduiSearch {

//    public static void main(String[] args) {
//       // restart();
//        search();
//
//
//    }
    @Test
    public static void search(){

        try{
            WebDriver driver= browserConfig.chromeConfig();
            List<String> textAll=ExcelOperation.readerExcel();
            for (int i=0;i<textAll.size();i++){
                String text=textAll.get(i);
                if(text.length()!=0){
                    System.out.println(text);
                    PageOperation.homePage(text, driver);
                }

            }

            Thread.sleep(3000);    //1000指1000ms
            //跳转到新页面
           // String parentWin=driver.getWindowHandle();//获取当前窗口的句柄

            Set<String> allWindowsId = driver.getWindowHandles();//获取所有窗口句柄
            for(String windowId :allWindowsId){
               // System.out.println("当前窗口的句柄："+windowId+"---:"+driver.switchTo().window(windowId).getTitle());
                String tit=driver.switchTo().window(windowId).getTitle();
                String titRe=tit.replace("_百度搜索","");
                if(textAll.contains(titRe)){
                    driver.switchTo().window(windowId);
                    String CurrentUrl=driver.getCurrentUrl();
                    writeTxt(CurrentUrl);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    //重启电脑
    public static void restart(){
        try {
            Runtime.getRuntime().exec("shutdown -r ");
        }catch (Exception e){

        }
    }
    //将搜索的url写入文本文档
    public static void writeTxt(String url) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        SimpleDateFormat dfHM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String d=df.format(new Date());//2020-07-08
        String dHM=dfHM.format(new Date());//2020-07-08 16:09:39
        String currentDate=df.format(new Date());//2020-07-08
        String filePath=ReadProperties.urlTxtPath()+currentDate+".txt";
       // System.out.println("filePath:"+filePath);
        //String dataTxt=dHM+"\r\n";

        FileWriter fw = null;
            try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
                File file=new File(filePath);
                if(!file.exists()){
                    file.createNewFile();
                }
                fw = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);
            pw.println(dHM);
            pw.println(url);
            pw.flush();
            try {
                fw.flush();
                pw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }


}
