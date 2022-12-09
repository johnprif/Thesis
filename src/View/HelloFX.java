package View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Model.CSVLoader;
import Model.DoublyLinkedList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private BorderPane borderPane;
	
	private FileInputStream inputstreamMain;
	private Image imageMain;
	private ImageView imageViewMain;
	
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
    	borderPane = new BorderPane();
    	
	}
    
    private void createLogoForMain()
	{
		String saitecLogo = "ImportantFiles/Icons/MainLogo.png";
		
		File f = new File(saitecLogo);
		
		if(f.exists() && !f.isDirectory())
		{
			try {
				inputstreamMain = new FileInputStream(saitecLogo);
			} catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imageMain = new Image(inputstreamMain); 
			imageViewMain = new ImageView(imageMain);
			//setting the fit height and width of the image view 
		    imageViewMain.setFitHeight(96); 
		    imageViewMain.setFitWidth(96);
		}else
		{
			imageMain=null;
			imageViewMain = null;
		}
		
	}
    
}


