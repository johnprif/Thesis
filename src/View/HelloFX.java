package View;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Model.CSVLoader;
import Model.DoublyLinkedList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application
{
	private Button loadFileButton;
	private Button putPointsButton;
	private Button exitButton;
	private Button changeLanguageButton;
	
	
	private GridPane gridPane;
	private BorderPane boredrPane;
	
	@Override
    public void start(Stage stage)
	{
		createButtons();
		createGridPane();
		
		
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        Scene scene = new Scene(new StackPane(l), 640, 480);
        
        Scene scene = new Scene(gridPane);
        
        stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        stage.setScene(scene);
//        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    private void createButtons()
	{
    	loadFileButton = new Button("Φόρτωση σημείων από εξωτερικό αρχείο");
    	putPointsButton = new Button("Βάλε τα σημειά με το χέρι");
    	exitButton = new Button("Έξοδος");
    	changeLanguageButton = new Button("Αλλαγή γλώσσας");
    	
    	loadFileButton.setMaxWidth(Double.MAX_VALUE);
    	putPointsButton.setMaxWidth(Double.MAX_VALUE);		    
	    exitButton.setMaxWidth(Double.MAX_VALUE);
	    changeLanguageButton.setMaxWidth(Double.MAX_VALUE);
	}
    
    private void createGridPane()
	{
    	boredrPane = new BorderPane();
    	
    	gridPane = new GridPane();
    	
    	gridPane.setAlignment(Pos.CENTER); 
  	  //Spaces between the buttons 
  	    gridPane.setHgap(10);
  	    gridPane.setVgap(10);
    	gridPane.setGridLinesVisible(true);
  	    
  	    gridPane.getColumnConstraints().add(new ColumnConstraints() {{
  	      setPercentWidth(10);
  	    }});

  	    gridPane.getColumnConstraints().add(new ColumnConstraints() {{
  	      setPercentWidth(50);
  	    }});
  	    gridPane.getColumnConstraints().add(new ColumnConstraints() {{
  	      setPercentWidth(10);
  	    }});
  	    
  	    gridPane.getRowConstraints().add(new RowConstraints() {{
  	      setPercentHeight(10);
  	    }});
  	    gridPane.getRowConstraints().add(new RowConstraints() {{
  	      setPercentHeight(50);
  	    }});
  	    gridPane.getRowConstraints().add(new RowConstraints() {{
  	      setPercentHeight(10);
  	    }});
  	    
    	gridPane.add(loadFileButton, 0, 1);	    
	    gridPane.add(putPointsButton, 0, 2);
	    gridPane.add(exitButton, 0, 3);
	    gridPane.add(changeLanguageButton, 2, 0);
	    
	    
	    
	}
}


