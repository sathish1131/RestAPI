package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Methods {
	String path="C:\\Users\\Hcl\\eclipse-workspace\\RestAPI\\dataDrivenAPI.xlsx";
	File f;
	FileInputStream fis;
	XSSFWorkbook wb;
	FileOutputStream fos;
	
	public String fileRead(String sheetName,int row,int column) throws IOException {
		f = new File(path);
		fis = new FileInputStream(f);
		wb=new XSSFWorkbook(fis);
		String cellValue = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return cellValue;
	}
	public void fileWrite(String sheetName,int row,int column,String value) throws IOException {
		XSSFCell cell = wb.getSheet(sheetName).getRow(row).createCell(column);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(value);
		fos=new FileOutputStream(f);
		wb.write(fos);
	}
	public void workBookTearDown() throws IOException {
		fis.close();
		fos.close();
		wb.close();
	}
}
