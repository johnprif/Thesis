package Model_Loader;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import Model.DataBase;
import javafx.geometry.Point2D;

public class FileLoaderFactory 
{
	private String path;
	private CSVLoader csvLoader;
	private TXTLoader txtLoader;
	private ExcelLoader xlsxLoader;
	private ArrayList<Point2D> allPoints;
	private DataBase dataBase;
	
	public FileLoaderFactory(String path)
	{
		this.path = path;
		dataBase = DataBase.getInstance();
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
				xlsxLoader = new ExcelLoader(path);
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
		System.out.println("The size of allPoints is = "+allPoints.size());
		dataBase.setAllPoints(allPoints);
		return allPoints;
		
	}
	
	
}
