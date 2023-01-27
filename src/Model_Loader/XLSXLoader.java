//https://www.baeldung.com/java-microsoft-excel
//https://github.com/johnprif/AdvancedText2SpeechApp/blob/main/src/input/ExcelReader.java

package Model_Loader;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.geometry.Point2D;

public class XLSXLoader implements FileLoader
{
	private String path;
	private List<String[]> stringXLSXData;
	private List<double[]> doubleXLSXData;
	private ArrayList<Point2D> points2DXLSXData;
	
	public XLSXLoader(String path)
	{
		this.path = path;
		stringXLSXData = new ArrayList<String[]>();
		doubleXLSXData = new ArrayList<double[]>();
		points2DXLSXData = new ArrayList<Point2D>(); 
		System.out.println("I am EXCEL LOADER");
		readValues();
//		printResults();
	}

	private void readValues()
	{
		try {
            // Create a FileInputStream to read the Excel file
            FileInputStream inputStream = new FileInputStream(path);

            // Create a Workbook using the FileInputStream
            Workbook workbook = WorkbookFactory.create(inputStream);

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Skip the first row (header)
                if (row.getRowNum() == 0) {
                    continue;
                }
                // Get the first cell (column A)
                Cell cellA = row.getCell(0);
                // Get the second cell (column B)
                Cell cellB = row.getCell(1);

                // Print the cell values
                if(cellA.getCellType() != CellType.BLANK)
                {
                    if(cellA.getCellType() == CellType.NUMERIC)
                        System.out.println("Column A: " + cellA.getNumericCellValue());
                    else
                        System.out.println("Column A: " + cellA.getStringCellValue());
                }
                if(cellB.getCellType() != CellType.BLANK)
                {
                    if(cellB.getCellType() == CellType.NUMERIC)
                        System.out.println("Column B: " + cellB.getNumericCellValue());
                    else
                        System.out.println("Column B: " + cellB.getStringCellValue());
                }
                convertValuesToOther(cellA.getNumericCellValue(), cellB.getNumericCellValue());
            }
            // Close the input stream
            inputStream.close();
            // Close the input stream
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void convertValuesToOther(Double a, Double b)
	{
		//Convert data from String to double		
//		double point[]=new double[2];
//		String tempA = a.replace(',', '.');
//		String tempB = b.replace(',', '.');
		points2DXLSXData.add(new Point2D(a, b));		
	}
	
	@Override
	public List<double[]> getDoubleValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Point2D> get2Dvalues() {
		// TODO Auto-generated method stub
		return points2DXLSXData;
	}
}
