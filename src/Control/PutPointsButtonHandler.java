package Control;

import View.GraphGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PutPointsButtonHandler  implements EventHandler<ActionEvent>
{
	private Stage graphStage;
	private GraphGUI graphGUI;
	
	public PutPointsButtonHandler()
	{	
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		//mainStage.close();
		System.out.println("Put points with mouse");
		notImpementPopup();
	}
	
	public void notImpementPopup()
    {
        // set alert type
        Alert a = new Alert(AlertType.INFORMATION);

        // set content text
        a.setContentText("Δεν έχει υλοποιηθεί ακόμα!");

        // show the dialog
        a.show();
    }

}
