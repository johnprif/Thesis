//https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
//https://github.com/johnprif/GoogleFromLidl

package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

public class CSVLoader 
{
	private String csvPath="test.csv";
	private List<String[]> csvData;
	FileReader filereader;
	
	public CSVLoader(String CSVpath) throws IOException, CsvException
	{
//		this.csvPath=csvPath;
		csvData=new ArrayList<String[]>();
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
		csvData.addAll(csvReader.readAll());
	}
	
	public void printResults()
	{
		//Print data from csv
		for (String[] row : csvData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
	}
	
	public List<String[]> getValues()
	{
		return csvData;
	}
	
}
