//https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

package Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import javafx.geometry.Point2D;

public class TXTLoader implements FileLoader
{
	private String path;
	private List<String[]> stringTXTData;
	private List<double[]> doubleTXTData;
	private ArrayList<Point2D> points2DTXTData;
	
	public TXTLoader(String path)
	{
		this.path = path;
		stringTXTData = new ArrayList<String[]>();
		doubleTXTData = new ArrayList<double[]>();
		points2DTXTData = new ArrayList<Point2D>(); 
		
		readValues();
//		printResults();
		convertValuesToOther();
	}
	
	private void readValues()  throws IOException, CsvException
	{
		// Create an object of file reader
        // class with CSV file as a parameter.
		CSVParser csvParser = new CSVParserBuilder().withSeparator(',').withSeparator(',').build();
		// create csvReader object
		CSVReader csvReader = new CSVReaderBuilder(new FileReader(path))
									.withCSVParser(csvParser)
									.withSkipLines(0).build();																					
		stringTXTData.addAll(csvReader.readAll());
	}
	
	public void convertValuesToOther()
	{
		//Convert data from String to double		
		double point[]=new double[2];
		for(int i=0; i<stringTXTData.size(); i++)
		{
			for(int j=0; j<stringTXTData.get(i).length; j++)
			{
				String temp = stringTXTData.get(i)[j].replace(',', '.');
//				point[j]=Double.parseDouble(stringCSVData.get(i)[j]);
				point[j]=Double.parseDouble(temp);
//                System.out.println(point[j] + " is of type " + ((Object)point[j]).getClass().getSimpleName());
			}
			doubleTXTData.add(point);
			points2DTXTData.add(new Point2D(point[0], point[1]));		
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
