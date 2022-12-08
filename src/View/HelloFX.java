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
import javafx.scene.layout.Region;
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
        stage.setMinHeight(600);
        stage.setMinWidth(600);
        stage.setHeight(600);
        stage.setWidth(600);
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
    	
    	
    	loadFileButton.setAlignment(Pos.CENTER);
    	putPointsButton.setAlignment(Pos.CENTER);
    	exitButton.setAlignment(Pos.CENTER);
    	changeLanguageButton.setAlignment(Pos.CENTER);
    	
//    	loadFileButton.setMaxWidth(Double.MAX_VALUE);
//    	putPointsButton.setMaxWidth(Double.MAX_VALUE);		    
//	    exitButton.setMaxWidth(Double.MAX_VALUE);
//	    changeLanguageButton.setMaxWidth(Double.MAX_VALUE);
	}
    
    private void createGridPane()
	{
    	Label kati = new Label("A gridpane's unbounded maximum width and height are an indication to the parent that it may be resized beyond its preferred size to fill whatever space is assigned to it.");
    	Label kat2 = new Label("GridPane provides properties for setting the size range directly. These properties default to the sentinel value USE_COMPUTED_SIZE, however the application may set them to other values as needed");
    	Label kat3 = new Label("GridPanntinel value USE_COMPUTED_SIZE, however the application may set them to other values as needed");


    	
    	boredrPane = new BorderPane();
    	
    	gridPane = new GridPane();
    	
    	gridPane.setAlignment(Pos.CENTER); 
  	  //Spaces between the buttons 
  	    gridPane.setHgap(10);
  	    gridPane.setVgap(10);
    	gridPane.setGridLinesVisible(true);
    	
    	//Column1
  	    gridPane.getColumnConstraints().add(new ColumnConstraints() 
  	    {
  	    	{
  	    		setPercentWidth(20);
  	    	}
  	    });
  	    //Column2
  	    gridPane.getColumnConstraints().add(new ColumnConstraints() 
  	    {
  	    	{
  	    		setPercentWidth(80);
  	    	}
  	    });
  	    //Column3
  	    gridPane.getColumnConstraints().add(new ColumnConstraints() 
  	    {
  	    	{
  	    		setPercentWidth(20);	   
  	    	}
  	    });
  	    //Row1
  	    gridPane.getRowConstraints().add(new RowConstraints() 
  	    {
  	    	{
  	    		setPercentHeight(20);
  	    	}
  	    });
  	    //Row2
  	    gridPane.getRowConstraints().add(new RowConstraints() 
  	    {
  	    	{
  	    		setPercentHeight(20);
  	    	}
  	    });
  	    //Row3
  	    gridPane.getRowConstraints().add(new RowConstraints() 
  	    {
  	    	{
  	    		setPercentHeight(20);
  	    	}
  	    });
  	    //Row4
  	    gridPane.getRowConstraints().add(new RowConstraints() 
  	    {
  	    	{
  	    		setPercentHeight(20);
  	    	}
  	    });
  	    
    	gridPane.add(loadFileButton, 0, 1);	    
	    gridPane.add(putPointsButton, 0, 2);
	    gridPane.add(exitButton, 0, 3);
	    
	    gridPane.add(kati, 1, 1);
	    gridPane.add(kat2, 1, 2);
	    gridPane.add(kat3, 1, 3);
	    
	    gridPane.add(changeLanguageButton, 2, 0);
	    
	    
	    
	}
}


