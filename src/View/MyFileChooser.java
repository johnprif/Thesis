//https://www.geeksforgeeks.org/javafx-filechooser-class/

package View;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import java.io.*;
import javafx.stage.FileChooser;

public class MyFileChooser extends Application
{

	@Override
	public void start(Stage stage) throws Exception 
	{
		// set title for the stage
        stage.setTitle("FileChooser");
 
        // create a File chooser
        FileChooser fil_chooser = new FileChooser();
 
        // create a Label
        Label label = new Label("no files selected");
 
        // create a Button
        Button button = new Button("Show open dialog");
 
        // create an Event Handler
        EventHandler<ActionEvent> event =
        new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent e)
            {
 
                // get the file selected
                File file = fil_chooser.showOpenDialog(stage);
 
                if (file != null) {
                     
                    label.setText(file.getAbsolutePath()
                                        + "  selected");
                }
            }
        };
 
        button.setOnAction(event);
 
        // create a Button
        Button button1 = new Button("Show save dialog");
 
        // create an Event Handler
        EventHandler<ActionEvent> event1 =
         new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent e)
            {
 
                // get the file selected
                File file = fil_chooser.showSaveDialog(stage);
 
                if (file != null) {
                    label.setText(file.getAbsolutePath()
                                        + "  selected");
                }
            }
        };
 
        button1.setOnAction(event1);
 
        // create a VBox
        VBox vbox = new VBox(30, label, button, button1);
 
        // set Alignment
        vbox.setAlignment(Pos.CENTER);
 
        // create a scene
        Scene scene = new Scene(vbox, 800, 500);
 
        // set the scene
        stage.setScene(scene);
 
        stage.show();
//    }catch (Exception e) 
//    {
//        System.out.println(e.getMessage());
//    }
		
	}
}
