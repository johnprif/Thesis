package Control;

import View.GraphGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PutPointsButtonHandler  implements EventHandler<ActionEvent>
{
	private Stage mainStage;
	private Stage graphStage;
	private GraphGUI graphGUI;
	
	public PutPointsButtonHandler(Stage mainStage)
	{
		this.mainStage = mainStage;		
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		mainStage.close();
		graphGUI = new GraphGUI();
	}

}
