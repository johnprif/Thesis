package Control;

import java.io.File;

import Model.CSVLoader;
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

public class LoadFileButtonHandler implements EventHandler<ActionEvent>
{

	private Stage stage;
	private String path;

	private TextHandler textHandler;
	
	private FileChooser fileChooser;
	
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
		computeConvex();
	}
	
	private void fileChooser(Stage stage)
	{
		// set title for the stage
//        stage.setTitle(textHandler.getFileChooserTitleText());
 
        fileChooser = new FileChooser();
		fileChooser.setTitle(textHandler.getFileChooserTitleText());
		fileChooser.getExtensionFilters().addAll(
			     new FileChooser.ExtensionFilter("CSV", "*.csv")
//			    ,new FileChooser.ExtensionFilter("Microsoft Access Data Base 2008-2021 Files", "*.accdb")
			);
		File selectedFile = fileChooser.showOpenDialog(stage);

		
		
		if(selectedFile != null)
		{
			path = selectedFile.getAbsolutePath();
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
		CSVLoader allPoints = new CSVLoader(path);
		GrahamScan convexPoints = new GrahamScan(allPoints.getValues());
	}

}
