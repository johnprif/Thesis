package Control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ExitButtonHandler  implements EventHandler<ActionEvent>
{
	private Stage stage;
	
	public ExitButtonHandler(Stage stage)
	{
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent arg0)
	{
		stage.close();
    	System.exit(0);		
	}

}
