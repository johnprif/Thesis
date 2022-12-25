//https://www.baeldung.com/java-microsoft-excel
//https://github.com/johnprif/AdvancedText2SpeechApp/blob/main/src/input/ExcelReader.java

package Model;

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
		
		readValues();
//		printResults();
		convertValuesToOther();
	}

	private void readValues()  throws IOException, CsvException
	{
		FileInputStream file = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(0);

		Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();
		int i = 0;
		for (Row row : sheet) {
		    data.put(i, new ArrayList<String>());
		    for (Cell cell : row) {
		        switch (cell.getCellType()) {
		            case STRING: ... break;
		            case NUMERIC: ... break;
		            case BOOLEAN: ... break;
		            case FORMULA: ... break;
		            default: data.get(new Integer(i)).add(" ");
		        }
		    }
		    i++;
		}
		
		// Create an object of file reader
        // class with CSV file as a parameter.
		CSVParser csvParser = new CSVParserBuilder().withSeparator(',').withSeparator(',').build();
		// create csvReader object
		CSVReader csvReader = new CSVReaderBuilder(new FileReader(path))
									.withCSVParser(csvParser)
									.withSkipLines(0).build();																					
		stringXLSXData.addAll(csvReader.readAll());
	}
	
	public void convertValuesToOther()
	{
		//Convert data from String to double		
		double point[]=new double[2];
		for(int i=0; i<stringXLSXData.size(); i++)
		{
			for(int j=0; j<stringXLSXData.get(i).length; j++)
			{
				String temp = stringXLSXData.get(i)[j].replace(',', '.');
//				point[j]=Double.parseDouble(stringCSVData.get(i)[j]);
				point[j]=Double.parseDouble(temp);
//                System.out.println(point[j] + " is of type " + ((Object)point[j]).getClass().getSimpleName());
			}
			doubleXLSXData.add(point);
			points2DXLSXData.add(new Point2D(point[0], point[1]));		
		}
	}
	
	@Override
	public List<double[]> getDoubleValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Point2D> get2Dvalues() {
		// TODO Auto-generated method stub
		return null;
	}
}
