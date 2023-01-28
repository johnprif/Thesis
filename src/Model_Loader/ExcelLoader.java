//https://www.baeldung.com/java-microsoft-excel
//https://github.com/johnprif/AdvancedText2SpeechApp/blob/main/src/input/ExcelReader.java

package Model_Loader;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import javafx.geometry.Point2D;

public class ExcelLoader implements FileLoader
{
	private String path;
	private ArrayList<Point2D> points2DXLSXData;
	
	public ExcelLoader(String path)
	{
		this.path = path;
		points2DXLSXData = new ArrayList<Point2D>(); 
		System.out.println("I am EXCEL LOADER");
		readValues();
	}

	private void readValues()
	{
		try {
            // Create a FileInputStream object to read the Excel file
            FileInputStream fis = new FileInputStream(new File(path));

            // Create a Workbook object to read the Excel file
            Workbook workbook = WorkbookFactory.create(fis);

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through the rows of the sheet
            for (Row row : sheet) 
            {
                convertDoubleToPoint2D(row.getCell(0), row.getCell(1));
            }
            // Close the FileInputStream object
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
	public void convertDoubleToPoint2D(Cell column1, Cell column2)
	{
		double a = column1.getNumericCellValue();
		double b = column2.getNumericCellValue();
		points2DXLSXData.add(new Point2D(a, b));	
	}
	
	

	@Override
	public ArrayList<Point2D> get2Dvalues() 
	{
		// TODO Auto-generated method stub
		return points2DXLSXData;
	}
}
