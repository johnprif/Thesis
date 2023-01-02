//https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
//https://stackoverflow.com/questions/40066333/how-to-store-doubles-in-a-point
//https://github.com/johnprif/GoogleFromLidl
//https://www.digitalocean.com/community/tutorials/java-convert-string-to-double

package Model_Loader;

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
	private List<double[]> doubleCSVData;
	private ArrayList<Point2D> points2DCSVData;
	
	public CSVLoader(String csvPath) throws IOException, CsvException
	{
		this.csvPath=csvPath;
		stringCSVData = new ArrayList<String[]>();
		doubleCSVData = new ArrayList<double[]>();
		points2DCSVData = new ArrayList<Point2D>(); 
		System.out.println("I am CSV LOADER");
		readValues();
//		printResults();
		convertValuesToOther();
	}
		
	private void readValues()  throws IOException, CsvException
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
	
	private void printResults()
	{
		//Print data from csv
		int i=0;
		for (String[] row : stringCSVData) 
		{
            for (String cell : row) 
            {
                System.out.print("String: "+i+"="+cell + "\t");
//              System.out.println(cell + " is of type " + ((Object)cell).getClass().getSimpleName());   == STRING               
            }
            i++;
            System.out.println();
        }
	}
	
	public void convertValuesToOther()
	{
		//Convert data from String to double		
		double point[]=new double[2];
		for(int i=0; i<stringCSVData.size(); i++)
		{
			for(int j=0; j<stringCSVData.get(i).length; j++)
			{
				String temp = stringCSVData.get(i)[j].replace(',', '.');
//				point[j]=Double.parseDouble(stringCSVData.get(i)[j]);
//				point[j]=Double.valueOf(temp);
				point[j]=Double.parseDouble(temp);
//              System.out.println(point[j] + " is of type " + ((Object)point[j]).getClass().getSimpleName());
			}
			doubleCSVData.add(point);
			points2DCSVData.add(new Point2D(point[0], point[1]));		
		}
	}
	
	public List<double[]> getDoubleValues()
	{
		return doubleCSVData;
	}
	
	public ArrayList<Point2D> get2Dvalues()
	{
		return points2DCSVData;
	}
	
}
