package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TaskGithub {
	@Test
	public void github_CRUD() throws IOException {
		File f=new File("C:\\Users\\Hcl\\eclipse-workspace\\RestAPI\\dataDrivenAPI.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("github");
		
		Response postRes = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
								.headers("authorization", sheet.getRow(1).getCell(2).getStringCellValue())
								.body(sheet.getRow(1).getCell(3).getStringCellValue())
								.when().post(sheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println("Response Body : "+postRes.asString());
		System.out.println("Status Code : "+postRes.statusCode());
		
		Response putRes = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
								.headers("authorization", sheet.getRow(2).getCell(2).getStringCellValue())
								.body(sheet.getRow(2).getCell(3).getStringCellValue())
								.when().put(sheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println("Response Body : "+putRes.asString());
		System.out.println("Status Code : "+putRes.statusCode());
		
		Response getRes = RestAssured.given().accept(ContentType.JSON)
								.when().get(sheet.getRow(3).getCell(1).getStringCellValue());
		System.out.println("Response Body : "+getRes.asString());
		System.out.println("Status Code : "+getRes.statusCode());
		
		Response delRes = RestAssured.given().headers("authorization", sheet.getRow(4).getCell(2).getStringCellValue())
								.when().delete(sheet.getRow(4).getCell(1).getStringCellValue());
		System.out.println("Response Body : "+delRes.asString());
		System.out.println("Status Code : "+delRes.statusCode());
		
		ArrayList<Response> resList = new ArrayList<>();
		resList.add(postRes);
		resList.add(putRes);
		resList.add(getRes);
		resList.add(delRes);
		
		ArrayList<Integer> successCode = new ArrayList<>();
		successCode.add(200);
		successCode.add(201);
		successCode.add(204);
		for(int i=1;i<=4;i++) {
			sheet.getRow(i).createCell(4).setCellType(CellType.STRING);
			sheet.getRow(i).createCell(5).setCellType(CellType.STRING);
			sheet.getRow(i).createCell(6).setCellType(CellType.STRING);
			sheet.getRow(i).getCell(4).setCellValue(resList.get(i-1).statusCode());
			sheet.getRow(i).getCell(6).setCellValue(resList.get(i-1).asString());	
			if(successCode.contains(resList.get(i-1).statusCode())) {
				sheet.getRow(i).getCell(5).setCellValue("Passed");
			}else {
				sheet.getRow(i).getCell(5).setCellValue("Failed");
			}
		}
		
		FileOutputStream fos =new FileOutputStream(f);
		wb.write(fos);
		
		fos.close();
		fis.close();
		wb.close();		
		
	}
}
