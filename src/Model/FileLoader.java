package Model;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;

public class FileLoader 
{
	private String path;
	private Object allPoints;
	
	public FileLoader(String path)
	{
		this.path = path;
	}
	
	private void callSpecificLoader()
	{
		try {
			if(path.contains(".csv"))
			{
				allPoints = new CSVLoader(path);
			}else if(path.contains(".txt"))
			{
				allPoints = new TXTLoader(path);
			}else if(path.contains(".xlsx"))
			{
				allPoints = new XLSXLoader(path);
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
		
		
		
	}
	
	
}
