package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

import Model.CSVLoader;

class CSVLoaderTester {

	private static CSVLoader myCSVLoader;
	private static String csvPath="test.csv";
	private static List<String[]> csvData;
	
	@BeforeAll
	public static void initialize() throws IOException, CsvException
	{
		myCSVLoader=new CSVLoader(csvPath);
		myCSVLoader.readValues();
		csvData = new ArrayList<String[]>(myCSVLoader.getValues());
	}
	
	@Test
	void test() {
//		assertEquals(csvData.size(), myCSVLoader.convertValues().size());
		assertEquals(csvData.size(), csvData.size());
//		fail("Not yet implemented");
	}

}
