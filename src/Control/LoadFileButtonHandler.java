package Control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import Model.Algorithm1;
import Model.GrahamScan;
import Model.TextHandler;
import Model_Loader.CSVLoader;
import Model_Loader.FileLoaderFactory;
import View.GraphGUI;
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

	private Stage fileChooserStage;
	private Stage mainStage;
	private String path;
	private ArrayList<Point2D> allPoints;
	private TextHandler textHandler;
	
	private FileChooser fileChooser;
	private FileLoaderFactory fileFactoryLoader;
	
	private GraphGUI graphGUI;
	
	public LoadFileButtonHandler(Stage mainStage)
	{
		this.mainStage = mainStage;
		textHandler = TextHandler.getInstance();
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		fileChooserStage = new Stage();
		textHandler = TextHandler.getInstance();
		fileChooser(fileChooserStage);
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
			    ,new FileChooser.ExtensionFilter("Excel", "*.xls")
			);
		File selectedFile = fileChooser.showOpenDialog(stage);
		
		if(selectedFile != null)//pressed OK
		{
			path = selectedFile.getAbsolutePath();
			nextSteps();
		}else//pressed Cancel
		{
		}
	}
	
	private void nextSteps()
	{
		fileFactoryLoader = new FileLoaderFactory(path);
		mainStage.close();
//		allPoints = new ArrayList<Point2D>(fileFactoryLoader.getAllPoints());
		graphGUI = new GraphGUI(fileFactoryLoader.getAllPoints());
	}
	
	public String getPath()
	{
		return path;
	}
	
//	private void computeConvex()
//	{	
//		GrahamScan convexPoints;		
//			convexPoints = new GrahamScan(allPoints.get2Dvalues());
//			convexPoints.computeGrahamScan();
//			convexPoints.moveStackToArrayList();
//			ArrayList<Point2D> kati = new ArrayList<Point2D>(convexPoints.getconvexHullPoints());
//			System.out.println("------BELLOW ARE THE CONVEXHULL POINTS------");
//			for(int i=0; i<kati.size(); i++)
//			{
//				System.out.println("My points are = "+kati.get(i));
//			}
//			Algorithm1 al = new Algorithm1(kati);		
//	}
}
