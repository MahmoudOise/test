package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis =  null;

	public FileInputStream getFileInputStream()
	{
		String filePath = System.getProperty("user.dir")+
				"\\src\\test\\java\\data\\Test.xlsx";
		File srcFile = new File(filePath);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. terminating Process "
					+ ": Check file path of TestData" 
					+ e.getMessage());
			System.exit(0);
		}
		return fis;
	}
	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int TotalNubmerOfRows = (sheet.getLastRowNum() + 1);
		int TotalNubmerOfCols = 4;
		String [][] arrayExcelData = new String[TotalNubmerOfRows][TotalNubmerOfCols];

		for(int i  = 0 ; i <TotalNubmerOfRows; i++)
		{
			for(int j  = 0 ; j <TotalNubmerOfCols; j++)
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
