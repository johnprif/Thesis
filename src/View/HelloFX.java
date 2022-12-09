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
import javafx.scene.layout.VBox;
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
		createGridPane(stage);
		
		
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        Scene scene = new Scene(new StackPane(l), 640, 480);
        
        Scene scene = new Scene(borderPane);
        
        stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        stage.setHeight(700);
        stage.setWidth(600);
        stage.setResizable(false);
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
    
    private void createGridPane(Stage stage)
	{
    	borderPane = new BorderPane();
    	createLogoForMain();
    	
//    	imageViewMain.fitWidthProperty().bind(stage.widthProperty()); 

    	
    	borderPane.setTop(null);
    	
    	borderPane.setLeft(imageViewMain);
    	borderPane.setAlignment(imageViewMain, Pos.CENTER); 

    	borderPane.setCenter(null);
    	
    	borderPane.setRight(new VBox(loadFileButton, putPointsButton, exitButton));
    	System.out.println("HERE");
	}
    
    private void createLogoForMain()
	{
		String saitecLogo = "ImportantFiles/Icons/MainLogo_B.png";
		
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
		    imageViewMain.setFitHeight(573); 
		    imageViewMain.setFitWidth(300);
		}else
		{
			imageMain=null;
			imageViewMain = null;
		}
		
	}
    
}


