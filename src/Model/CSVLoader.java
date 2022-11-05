//https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
//https://github.com/johnprif/GoogleFromLidl

package Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

public class CSVLoader 
{
	private String csvPath="test.csv";
	private List<String[]> stringCSVData;
	private List<double[]> doubleCSVData;
	
	public CSVLoader(String CSVpath) throws IOException, CsvException
	{
//		this.csvPath=csvPath;
		stringCSVData=new ArrayList<String[]>();
		doubleCSVData=new ArrayList<double[]>();
	}
		
	public void readValues()  throws IOException, CsvException
	{
		// Create an object of file reader
        // class with CSV file as a parameter.
		CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
		// create csvReader object
		CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvPath))
									.withCSVParser(csvParser)
									.withSkipLines(0).build();																					
		stringCSVData.addAll(csvReader.readAll());
	}
	
	public void printResults()
	{
		//Print data from csv
		int i=0;
		for (String[] row : stringCSVData) 
		{
            for (String cell : row) 
            {
                System.out.print("String: "+i+"="+cell + "\t");
//                System.out.println(cell + " is of type " + ((Object)cell).getClass().getSimpleName());   == STRING               
            }
            i++;
            System.out.println();
        }
	}
	
	public void convertValuesToDouble()
	{
		//Convert data from String to double
		
		double point[]=new double[2];
		int i;
		
		for (String[] row : stringCSVData) 
		{
			i=0;
            for (String cell : row) 
            {
                point[i]=Double.parseDouble(cell);
                System.out.println(point[i] + " is of type " + ((Object)point[i]).getClass().getSimpleName());
                i++;
            }
            doubleCSVData.add(point);
        }
	}
	
	public List<double[]> getValues()
	{
		return doubleCSVData;
	}
	
}
