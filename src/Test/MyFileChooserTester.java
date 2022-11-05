package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

import Model.CSVLoader;
import View.MyFileChooser;
import javafx.stage.Stage;

public class MyFileChooserTester 
{
	private static MyFileChooser myFileChooser;
	private static Stage stage;
	
	@BeforeAll
	public static void initialize() throws Exception
	{
		stage=new Stage();
		myFileChooser=new MyFileChooser();
		myFileChooser.start(stage);
	}
	
	@Test
	void test() throws Exception 
	{
		
//		assertEquals(csvData.size(), myCSVLoader.convertValues().size());
//		fail("Not yet implemented");
	}

}
