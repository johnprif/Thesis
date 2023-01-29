package Control;

import Model.TextHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PutPointsButtonHandler  implements EventHandler<ActionEvent>
{	
	private TextHandler textHandler;
	
	public PutPointsButtonHandler()
	{	
		textHandler = TextHandler.getInstance();
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		notImpementPopup();
	}
	
	public void notImpementPopup()
    {
        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle(textHandler.getNotImpementPopupTitle());
        a.setHeaderText(textHandler.getNotImpementPopupHeaderText());
        a.setContentText(textHandler.getNotImpementContentText());
        a.show();
    }

}
