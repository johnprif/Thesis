//https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
//https://stackoverflow.com/questions/40066333/how-to-store-doubles-in-a-point
//https://github.com/johnprif/GoogleFromLidl
//https://www.digitalocean.com/community/tutorials/java-convert-string-to-double

package Model_Loaders;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import javafx.geometry.Point2D;

public class CSVLoader implements FileLoader
{
	private String csvPath;
	private List<String[]> stringCSVData;
	private ArrayList<Point2D> points2DCSVData;
	
	public CSVLoader(String csvPath) throws IOException, CsvException
	{
		this.csvPath=csvPath;
		stringCSVData = new ArrayList<String[]>();
		points2DCSVData = new ArrayList<Point2D>(); 
		System.out.println("I am CSV LOADER");
		readValues();
		convertStringToPoint2D();
	}
		
	private void readValues() throws IOException, CsvException
	{
		// Create an object of file reader
        // class with CSV file as a parameter.
		CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
		// create csvReader object
		CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvPath))
//									.withCSVParser(csvParser)
									.withSkipLines(0).build();																					
		stringCSVData.addAll(csvReader.readAll());
	}
	
	public void convertStringToPoint2D()
	{
		//Convert data from String to double		
		double a;
		double b;
		String temp1;
		String temp2;
		
		for(int i=0; i<stringCSVData.size(); i++)
		{
			temp1 = stringCSVData.get(i)[0].replace(',', '.');
			temp2 = stringCSVData.get(i)[1].replace(',', '.');
			a=Double.parseDouble(temp1);
			b=Double.parseDouble(temp2);
			
			points2DCSVData.add(new Point2D(a, b));	
		}
	}
	
	public ArrayList<Point2D> get2Dvalues()
	{
		return points2DCSVData;
	}
	
}
