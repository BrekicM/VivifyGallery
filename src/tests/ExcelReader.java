package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	File file;
	FileInputStream fis;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public ExcelReader(String filePath) throws IOException {
		this.file = new File(filePath);
		this.fis = new FileInputStream(file);
		this.workBook = new XSSFWorkbook(fis);
	}
	
	public String getStringCellData(String sheetName, int rowNumber, int cellNumber) {
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNumber - 1);
		cell = row.getCell(cellNumber - 1);
		return cell.getStringCellValue();
	}
}
