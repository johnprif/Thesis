package Control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import Model.Algorithm1;
import Model.CSVLoader;
import Model.FileLoaderFactory;
import Model.GrahamScan;
import Model.TextHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Point2D;

public class LoadFileButtonHandler implements EventHandler<ActionEvent>
{

	private Stage stage;
	private String path;

	private TextHandler textHandler;
	
	private FileChooser fileChooser;
	private FileLoaderFactory allPoints;
	
	public LoadFileButtonHandler()
	{
		textHandler = TextHandler.getInstance();
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		stage = new Stage();
		textHandler = TextHandler.getInstance();
		fileChooser(stage);
//		computeConvex();
	}
	
	private void fileChooser(Stage stage)
	{
		// set title for the stage
//        stage.setTitle(textHandler.getFileChooserTitleText());
 
        fileChooser = new FileChooser();
		fileChooser.setTitle(textHandler.getFileChooserTitleText());
		fileChooser.getExtensionFilters().addAll(
			     new FileChooser.ExtensionFilter("CSV", "*.csv")
			    ,new FileChooser.ExtensionFilter("txt", "*.txt")
			    ,new FileChooser.ExtensionFilter("Excel", "*.xlsx")
			);
		File selectedFile = fileChooser.showOpenDialog(stage);
		
		if(selectedFile != null)
		{
			path = selectedFile.getAbsolutePath();
			allPoints = new FileLoaderFactory(path);
		}else
		{
		}
	}
	
	public String getPath()
	{
		return path;
	}
	
	private void computeConvex()
	{	
		GrahamScan convexPoints;		
			convexPoints = new GrahamScan(allPoints.get2Dvalues());
			convexPoints.computeGrahamScan();
			convexPoints.moveStackToArrayList();
			ArrayList<Point2D> kati = new ArrayList<Point2D>(convexPoints.getconvexHullPoints());
//			System.out.println("------BELLOW ARE THE CONVEXHULL POINTS------");
//			for(int i=0; i<kati.size(); i++)
//			{
//				System.out.println("My points are = "+kati.get(i));
//			}
			Algorithm1 al = new Algorithm1(kati);		
	}
}
