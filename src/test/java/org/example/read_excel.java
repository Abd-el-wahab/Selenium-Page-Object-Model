package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class read_excel {
    public Object[][] read_data() throws IOException, InvalidFormatException {
        File myFile = new File(".\\Testdata\\Book1.xlsx"); // 3arrft object mn el class el asmo File , 3ashan a3rf ashawr 3ala el fila beta3y
        XSSFWorkbook wb = new XSSFWorkbook(myFile); // lazm bastkhdm el class da ( XSSFWorkbook ) 3ahsna bat3aml ma3a Excel Sheet , we astkhdm el hagat el howa 3ahsan zay el get we row we call etc..
        XSSFSheet mySheet = wb.getSheet("Sheet1"); // hena ana ba2olo azm el sheet el 3aez ashtkhdmo gowa el excel nafso , Very Important
            int number_of_rows = mySheet.getPhysicalNumberOfRows();
            int number_of_columns = mySheet.getRow(0).getLastCellNum();
        Object[][] myArray = new Object[number_of_rows-1][number_of_columns];

            for (int r=1;r<number_of_rows;r++){

                for (int c=0; c<number_of_columns;c++){

                    XSSFRow row = mySheet.getRow(r);
                    myArray[r-1][c]= row.getCell(c).getStringCellValue();
                }

            }
        return myArray;
    }
}
