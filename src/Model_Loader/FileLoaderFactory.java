package Model_Loader;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import javafx.geometry.Point2D;

public class FileLoaderFactory 
{
	private String path;
	private CSVLoader csvLoader;
	private TXTLoader txtLoader;
	private XLSXLoader xlsxLoader;
	private ArrayList<Point2D> allPoints;
	
	public FileLoaderFactory(String path)
	{
		this.path = path;
	}
	//allPoints??
	public ArrayList<Point2D> getAllPoints()
	{
		try {
			if(path.contains(".csv"))
			{
				csvLoader = new CSVLoader(path);
				allPoints = new ArrayList<Point2D>(csvLoader.get2Dvalues());
			}else if(path.contains(".txt"))
			{
				txtLoader = new TXTLoader(path);
				allPoints = new ArrayList<Point2D>(txtLoader.get2Dvalues());
			}else if(path.contains(".xlsx") || path.contains(".xls"))
			{
				xlsxLoader = new XLSXLoader(path);
				allPoints = new ArrayList<Point2D>(xlsxLoader.get2Dvalues());
			}else
			{
				
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allPoints;
		
	}
	
	
}
