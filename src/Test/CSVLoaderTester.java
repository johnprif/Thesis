package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

import Model_Loader.CSVLoader;

class CSVLoaderTester {

	private static CSVLoader myCSVLoader;
	private static String csvPath="test.csv";
	private static List<double[]> doubleCSVData;
	
	@BeforeAll
	public static void initialize() throws IOException, CsvException
	{
		myCSVLoader=new CSVLoader(csvPath);
		myCSVLoader.readValues();
		doubleCSVData = new ArrayList<double[]>(myCSVLoader.getValues());
	}
	
	@Test
	void test() 
	{
		myCSVLoader.printResults();
		myCSVLoader.convertValuesToDouble();
//		assertEquals(csvData.size(), myCSVLoader.convertValues().size());
//		assertEquals(csvData.size(), csvData.size());
//		fail("Not yet implemented");
	}

}
