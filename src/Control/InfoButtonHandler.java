package Control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoButtonHandler  implements EventHandler<ActionEvent>
{

	@Override
	public void handle(ActionEvent arg0) 
	{
		Stage stage = new Stage();
        stage.setTitle("User Manual");

        WebView userManualView = new WebView();
        userManualView.getEngine().load("https://example.com/user-manual");
//        userManualView.getEngine().load(" https://github.com/johnprif/CV/blob/main/newCV.pdf");
       
        VBox layout = new VBox(10);
        layout.getChildren().addAll(userManualView);

        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
		
	}

}
