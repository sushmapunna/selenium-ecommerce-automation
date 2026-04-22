package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    // This method reads data from Excel file
    public static String[][] getLoginData(String filePath) throws IOException {

        // Step 1 — Open the Excel file
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        // Step 2 — Get the first sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Step 3 — Count rows and columns
        // -1 because first row is header, we skip it
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        // Step 4 — Read all data into a 2D array
        String[][] data = new String[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.getStringCellValue();
            }
        }

        // Step 5 — Close file and return data
        workbook.close();
        fis.close();
        return data;
    }
}