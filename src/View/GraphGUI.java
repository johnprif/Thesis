package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class GraphGUI
{
	private Stage graphStage;

	public GraphGUI()
	{
		createStage();
//		stage.close();
	}
	
	private void createStage()
    {
		graphStage = new Stage();
		graphStage.setTitle("GRAPH-GUI");
		graphStage.setHeight(700);
		graphStage.setWidth(700);
		graphStage.setResizable(false);
//		graphStage.setScene(scene);
		graphStage.show();
    }
	
}
