package Commonfunctionpackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Utility_commonfunction {
	public static void evidencefilecreater(String filename,String requestBody,String responseBody) throws IOException
{
	File newfile=new File("C:\\Users\\Varsha\\OneDrive\\New folder\\F1\\f2\\"+filename+".txt");
	System.out.println("a new text file created to record request and response of API;"+newfile.getName());
	FileWriter datawrite=new FileWriter(newfile);
	datawrite.write("request body :"+requestBody+"\n\n");
	datawrite.write("response body :"+responseBody);
	datawrite.close();
	System.out.println("request body and response body are saved in:"+newfile.getName());
	
}
	public static ArrayList<String> readDataExcel(String Sheetname,String testcasename) throws IOException
	{
		ArrayList<String> ArrayData=new ArrayList<String>();
     //step1:create the object of file input stream
		FileInputStream fis=new FileInputStream("C:\\Users\\Varsha\\OneDrive\\New folder\\F1\\f2\\Varsha_API_TestData.xlsx");
		//step2:access excel file
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
	 // step3:excess the sheet name
		int countofsheet=workbook.getNumberOfSheets();
		for(int i=0;i<countofsheet;i++) 
		{
		String filesheetname=workbook.getSheetName(i);
		if(filesheetname.equalsIgnoreCase(Sheetname))
		{
		//step4:access the row from where data supposed to fetch
		XSSFSheet sheet=workbook.getSheetAt(i);	
		Iterator <Row> rows=sheet.iterator();
		//Row r=rows.next();
		while(rows.hasNext())
		{
		Row r2=rows.next();
		if(r2.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
		{
			Iterator<Cell> cellvalues=r2.cellIterator();
			while(cellvalues.hasNext()) {
			String testdata=cellvalues.next().getStringCellValue();	
			//System.out.println(testdata);
			ArrayData.add(testdata);
			}
		}
		}
		}
		}
		workbook.close();
		return ArrayData;
	}
}


