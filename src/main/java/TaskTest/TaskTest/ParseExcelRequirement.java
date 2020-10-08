package TaskTest.TaskTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ParseExcelRequirement {

		public String[][] getDataFromExcelSheet(String excelSheetFilePath,String sheetName) throws IOException {
			String allExcelData[][] = null;
			File file = new File(excelSheetFilePath);
			Workbook wb = null;
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				System.out.println("Excel file is not available at " + excelSheetFilePath);
			}

			String fileExtenstion = excelSheetFilePath.substring(excelSheetFilePath.indexOf("."));
			if (fileExtenstion.equals(".xlsx")) {
				wb = new XSSFWorkbook(fis);
			} else if (fileExtenstion.equals(".xls")) {
				wb = new HSSFWorkbook(fis);
			}
			Sheet mySheet = wb.getSheet(sheetName);
			int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
			for (int i = 0; i <= rowCount; i++) {
				 allExcelData[i]=new String[mySheet.getRow(i).getLastCellNum()] ;
				for (int j = 0; j < mySheet.getRow(i).getLastCellNum(); j++) {
					allExcelData[i][j]=mySheet.getRow(i).getCell(j).getStringCellValue();
				}
				
			}
	     return allExcelData;
		}

		
		public static List<String> readColumnDataFromExcel(String filePath,String fileName,String sheetName,String attributeName) {
			File file =    new File(filePath+"\\"+fileName);
			System.out.println(filePath+"\\"+fileName);
			System.out.println(file.getAbsolutePath());
			List<String> attributeValue=new ArrayList<String>();
			FileInputStream inputStream;
			Workbook workbook = null;
			Row row =null;
			try{
				inputStream = new FileInputStream(file);
				workbook = WorkbookFactory.create(inputStream);
			}
			catch(Exception e){

			}
			System.out.println(workbook.getSheetName(0));
			Sheet sheet = workbook.getSheet(sheetName);
			Row firstRow = sheet.getRow(0);
			int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			for (int i = 1; i <=rowCount; i++) {

				row = sheet.getRow(i);
				for (int j = 0; j < firstRow.getLastCellNum(); j++) {
					if((row.getCell(j)!=null)){
						row.getCell(j).setCellType(CellType.STRING);
						if(!row.getCell(j).getStringCellValue().trim().equals("")){
							if(firstRow.getCell(j).getStringCellValue().equals(attributeName)) {
								attributeValue.add(row.getCell(j).getStringCellValue().trim());
								break;
							}
						}
					}
				}

			}
			return attributeValue;
		}


}
