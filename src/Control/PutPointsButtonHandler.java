package Control;

import View.GraphGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PutPointsButtonHandler  implements EventHandler<ActionEvent>
{
	private Stage stage;
	private Stage graphStage;
	private GraphGUI graphGUI;
	
	public PutPointsButtonHandler(Stage stage)
	{
		this.stage = stage;		
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		stage.close();
		graphStage = new Stage();
		graphStage.setHeight(600);
		graphStage.setWidth(600);
		graphGUI = new GraphGUI(graphStage);
	}

}
