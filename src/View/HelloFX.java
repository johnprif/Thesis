package View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Control.ExitButtonHandler;
import Model.CSVLoader;
import Model.DoublyLinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFX extends Application
{
	private String javaVersion = System.getProperty("java.version");
    private String javafxVersion = System.getProperty("javafx.version");
	
	private Stage stage;
	private Scene scene;
		
	private Button loadFileButton;
	private Button putPointsButton;
	private Button exitButton;
	private Button changeLanguageButton;
	private Button infoButton;
	
	private ExitButtonHandler exitButtonHandler;
	
	private BorderPane borderPane;
	private GridPane gridPane;
	private VBox vbox;
	private VBox vbox2;
	
	private Label paperTitle;
	
	private FileInputStream inputstreamMain;
	private Image imageMain;
	private ImageView imageViewMain;
	
	@Override
    public void start(Stage stage)
	{
				
		this.stage = stage;
		
		createButtons();
		createPaperTitle();
		createSecondPane();
		createMainPane();
		      
        scene = new Scene(borderPane);
        
        createAndSetHandlers();
        
        createStage();       
        
    }

    public static void main(String[] args) {
        launch();
    }
    
    private void createAndSetHandlers()
    {
    	exitButtonHandler = new ExitButtonHandler(stage);
    	exitButton.setOnAction(exitButtonHandler);
    	
    	
    }
    
    private void createButtons()
	{
    	loadFileButton = new Button("Φόρτωση σημείων από εξωτερικό αρχείο");
    	putPointsButton = new Button("Βάλε τα σημειά με το χέρι");
    	exitButton = new Button("Έξοδος");
    	changeLanguageButton = new Button("EN");
    	infoButton = new Button("?");
    	
    	loadFileButton.setAlignment(Pos.CENTER);
    	putPointsButton.setAlignment(Pos.CENTER);
    	exitButton.setAlignment(Pos.CENTER);
    	changeLanguageButton.setAlignment(Pos.CENTER);
    	infoButton.setAlignment(Pos.CENTER);
    	
    	loadFileButton.setMaxWidth(Double.MAX_VALUE);
    	putPointsButton.setMaxWidth(Double.MAX_VALUE);		    
	    exitButton.setMaxWidth(Double.MAX_VALUE);
	    
	    loadFileButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    putPointsButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    exitButton.setStyle("-fx-font-weight: bold; -fx-text-fill: red; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    changeLanguageButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    infoButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

	}
    
    private void createMainPane()
	{
    	borderPane = new BorderPane();
    	createMainLogo();
    	borderPane.setStyle("-fx-background: #4682b4;");
//    	imageViewMain.fitWidthProperty().bind(stage.widthProperty()); 
    	borderPane.setPadding(new Insets(10, 10, 10, 10));
    	
    	borderPane.setTop(null);
    	
    	borderPane.setLeft(imageViewMain);
    	borderPane.setAlignment(imageViewMain, Pos.CENTER); 

    	//------------------------------------------------------------------
    	borderPane.setCenter(vbox);
    	borderPane.setAlignment(vbox, Pos.CENTER);
    	//------------------------------------------------------------------
       	borderPane.setTop(changeLanguageButton);
       	borderPane.setAlignment(changeLanguageButton, Pos.CENTER_RIGHT);
       	
       	borderPane.setBottom(infoButton);
       	borderPane.setAlignment(infoButton, Pos.CENTER_RIGHT);
	}
    
    
    private void createPaperTitle()
    {
    	paperTitle = new Label("A SIMPLE ALGORITHM FOR\nCOMPUTING THE SMALEST\n   ENCLOSING CIRCLE");
    	paperTitle.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 17; -fx-font-family: 'Courier New'; -fx-underline: false;");
    	paperTitle.setMaxWidth(Double.MAX_VALUE);
    	paperTitle.setAlignment(Pos.CENTER);
    }
    
    private void createSecondPane()
    { 	
    	vbox = new VBox(10);    	
    	vbox.setAlignment(Pos.CENTER);    	
    	vbox.setMargin(paperTitle, new Insets(5, 5, 50, 5)); 
    	vbox.getChildren().addAll(paperTitle, loadFileButton, putPointsButton, exitButton);    	
    	vbox.setPadding(new Insets(10, 10, 130, 10));
    	vbox.setAlignment(Pos.CENTER); 
    }
    
    private void createMainLogo()
	{
		String saitecLogo = "ImportantFiles/Icons/MainLogo_W.png";
		
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
    
    private void createStage()
    {
    	stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion);
        stage.setHeight(700);
        stage.setWidth(600);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
}


