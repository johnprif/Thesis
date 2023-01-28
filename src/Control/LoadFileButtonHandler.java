package Control;

import java.io.File;
import java.util.ArrayList;
import Model.TextHandler;
import Model_Loader.FileLoaderFactory;
import View.GraphGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private AlgorithmsHandler algorithmsHandler;
	
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
	}
	
	private void fileChooser(Stage stage)
	{
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
		fileFactoryLoader.getAllPoints();
		mainStage.close();
//		allPoints = new ArrayList<Point2D>(fileFactoryLoader.getAllPoints());
//		graphGUI = new GraphGUI(fileFactoryLoader.getAllPoints());
		algorithmsHandler = new AlgorithmsHandler();
		graphGUI = new GraphGUI(path);
	}
	
	public String getPath()
	{
		return path;
	}
	
}
