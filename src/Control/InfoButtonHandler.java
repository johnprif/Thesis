package Control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoButtonHandler  implements EventHandler<ActionEvent>
{
	private Stage stage;
	private WebView userManualView;
	private VBox layout;
	private Scene scene;
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		stage = new Stage();
        stage.setTitle("User Manual");

        userManualView = new WebView();
        userManualView.getEngine().load("https://github.com/johnprif");
       
        layout = new VBox(10);
        layout.getChildren().addAll(userManualView);

        scene = new Scene(layout, 500, 500);
        scene.getStylesheets().add("styles.css");
        
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
		
	}

}
