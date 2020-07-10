import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelOperation {
    //读取excel中的关键字
    public static List<String> readerExcel(){
        List<String> list=new ArrayList<String>();

        try{
            //获取输入流
            //同时支持Excel 2003、2007
            //Excel文件所在位置
            File excelFile =  new File("D:\\IDEAProject\\搜索关键字.xlsx"); //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量
            //遍历每个Sheet
            for (int s = 0; s < sheetCount; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数
                //遍历每一行
                for (int r = 1; r < rowCount; r++) {
                    Row row = sheet.getRow(r);
                    //避免空行
                    if(row!=null){
                        int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
                        //遍历每一个单元格
                        for (int c = 0; c < cellCount; c++) {
                            Cell cell = row.getCell(c);
                            int a= cell.toString().length();
                            String cellValue = null;
                            //在读取单元格内容前,设置所有单元格中内容都是字符串类型
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            //按照字符串类型读取单元格内数据
                            cellValue = cell.getStringCellValue();
                            /*在这里可以对每个单元格中的值进行二次操作转化*/
                            if (cellValue!=null) {
                                //System.out.print(cell+"\t");
                                list.add(cellValue);
                            }
                        }
                    }else{
                        System.out.println("是null");

                    }
                }
            }

//            //用流的方式先读取到你想要的excel的文件  new File("D:\\IDEAProject\\搜索关键字.xlsx")
//            FileInputStream fis=null;
//            fis = new FileInputStream(new File(""));
//            //解析excel
//
//            POIFSFileSystem fs  =new POIFSFileSystem(new FileInputStream(sourceFilePath));
//            HSSFWorkbook wb = new HSSFWorkbook(fs);
//            HSSFSheet sheet = wb.getSheetAt(0);
//
//            POIFSFileSystem pSystem=new POIFSFileSystem(fis);
//            //获取整个excel
//            //如果是xls，使用HSSFWorkbook；如果是xlsx，使用XSSFWorkbook
//           // HSSFWorkbook hb=new HSSFWorkbook(pSystem);
//            XSSFWorkbook hb=new XSSFWorkbook(pSystem);
//            System.out.println(hb.getNumCellStyles());
//            //获取第一个表单sheet
//            HSSFSheet sheet=hb.getSheetAt(0);
//            //获取第一行
//            int firstrow=    sheet.getFirstRowNum();
//            //获取最后一行
//            int lastrow=    sheet.getLastRowNum();
//            //循环行数依次获取列数
//            for (int i = firstrow; i < lastrow+1; i++) {
//                //获取哪一行i
//                Row row=sheet.getRow(i);
//                if (row!=null) {
//                    //获取这一行的第一列
//                    int firstcell=    row.getFirstCellNum();
//                    //获取这一行的最后一列
//                    int lastcell=    row.getLastCellNum();
//                    //创建一个集合，用处将每一行的每一列数据都存入集合中
//
//                    for (int j = firstcell; j <lastcell; j++) {
//                        //获取第j列
//                        Cell cell=row.getCell(j);
//
//                        if (cell!=null) {
//                            System.out.print(cell+"\t");
//                            list.add(cell.toString());
//                        }
//                    }
//                }
//            }
            //fis.close();
        }catch (Exception e){
            System.out.println(e);

        }
        return list;

    }
}
