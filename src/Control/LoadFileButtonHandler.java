package Control;

import java.io.File;
import Model.TextHandler;
import Model_Loaders.FileLoaderFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LoadFileButtonHandler implements EventHandler<ActionEvent>
{
	private Stage fileChooserStage;
	private String path;
	private TextHandler textHandler;
	
	private FileChooser fileChooser;
	private FileLoaderFactory fileFactoryLoader;
	
	private AlgorithmsHandler algorithmsHandler;
	
	private GraphGUIHandler graphGUIHandler;
	
	public LoadFileButtonHandler()
	{
		textHandler = TextHandler.getInstance();	
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		fileChooserStage = new Stage();
		fileChooser();
	}
	
	private void fileChooser()
	{
        fileChooser = new FileChooser();
		fileChooser.setTitle(textHandler.getFileChooserTitleText());
		fileChooser.getExtensionFilters().addAll(
			     new FileChooser.ExtensionFilter("CSV", "*.csv")
			    ,new FileChooser.ExtensionFilter("txt", "*.txt")
			    ,new FileChooser.ExtensionFilter("Excel 2007-2022", "*.xlsx")
			    ,new FileChooser.ExtensionFilter("Excel 1997-2003", "*.xls")
			);
		File selectedFile = fileChooser.showOpenDialog(fileChooserStage);
		
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
		algorithmsHandler = new AlgorithmsHandler();
		graphGUIHandler = new GraphGUIHandler(path);
	}
}
