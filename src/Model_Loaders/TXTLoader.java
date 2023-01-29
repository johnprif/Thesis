//https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

package Model_Loaders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.exceptions.CsvException;

import javafx.geometry.Point2D;

public class TXTLoader implements FileLoader
{
	private String path;
	private ArrayList<Point2D> points2DTXTData;
	
	public TXTLoader(String path) throws IOException, CsvException
	{
		this.path = path;
		points2DTXTData = new ArrayList<Point2D>(); 
		System.out.println("I am TXT LOADER");
		readValues();
	}
	
	private void readValues()  throws IOException, CsvException
	{
		File file = new File(path);
	    Scanner scanner = new Scanner(file);
	    String line;
	    String[] values ;
	    
	    while (scanner.hasNextLine()) 
	    {
	        line = scanner.nextLine();
	        values = line.split("\\s+"); // assuming the values are separated by whitespace
	        convertStringToPoint2D(values[0], values[1]);
	    }
	    scanner.close();
	}
	
	public void convertStringToPoint2D(String x, String y)
	{
		String temp1 = x.replace(',', '.');
		String temp2 = y.replace(',', '.');
		double a = Double.parseDouble(temp1);
        double b = Double.parseDouble(temp2);
		points2DTXTData.add(new Point2D(a, b));
	}


	@Override
	public ArrayList<Point2D> get2Dvalues() 
	{
		return points2DTXTData;
	}
	
}
