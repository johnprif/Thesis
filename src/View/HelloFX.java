package View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import Control.ChangeLanguageButtonHandler;
import Control.ExitButtonHandler;
import Control.InfoButtonHandler;
import Control.LoadFileButtonHandler;
import Control.PutPointsButtonHandler;
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
	
	private Button changeLanguageButton;
	private Button loadFileButton;
	private Button putPointsButton;
	private Button exitButton;	
	private Button infoButton;

	private ChangeLanguageButtonHandler changeLanguageButtonHandler;
	private LoadFileButtonHandler loadFileButtonHandler;
	private PutPointsButtonHandler putPointsButtonHandler;
	private ExitButtonHandler exitButtonHandler;

	private InfoButtonHandler infoButtonHandler;
	
	private BorderPane borderPane;
	private VBox vbox;
	
	private Label paperTitle;
	
	private FileInputStream inputstreamMain;
	private Image imageMain;
	private ImageView imageViewMain;
	
	private FileInputStream inputstreamMain2;
	private Image imageMain2;
	private ImageView imageViewMain2;
	
	private ArrayList<Button> buttons;
	
	@Override
    public void start(Stage stage)
	{
		buttons = new ArrayList<Button>();		
		this.stage = stage;
		
		createButtons();
		createPaperTitle();
		createSecondPane();
		createMainPane();
		      
        scene = new Scene(borderPane);
        
        createAndSetHandlers();
        
        createMainLogo2();
        
        createStage();       
        
    }

    public static void main(String[] args) {
        launch();
    }
    
    private void createAndSetHandlers()
    {
    	changeLanguageButtonHandler = new ChangeLanguageButtonHandler(buttons, paperTitle);
    	loadFileButtonHandler = new LoadFileButtonHandler();
    	putPointsButtonHandler = new PutPointsButtonHandler();
    	exitButtonHandler = new ExitButtonHandler(stage);   	
    	infoButtonHandler = new InfoButtonHandler();
    	
    	changeLanguageButton.setOnAction(changeLanguageButtonHandler); 
    	loadFileButton.setOnAction(loadFileButtonHandler);   	
    	putPointsButton.setOnAction(putPointsButtonHandler);   	
    	exitButton.setOnAction(exitButtonHandler);   	  	
    	infoButton.setOnAction(infoButtonHandler);
    	
    	
    }
    
    
    private void createButtons()
	{
    	changeLanguageButton = new Button("GR");
    	loadFileButton = new Button("Φόρτωση Σημείων απο CSV");
    	putPointsButton = new Button("Δημιουργία σημείων");
    	exitButton = new Button("Έξοδος");    	
    	infoButton = new Button("?");
    	
    	changeLanguageButton.setAlignment(Pos.CENTER);
    	loadFileButton.setAlignment(Pos.CENTER);
    	putPointsButton.setAlignment(Pos.CENTER);
    	exitButton.setAlignment(Pos.CENTER);   	
    	infoButton.setAlignment(Pos.CENTER);
    	
    	loadFileButton.setMaxWidth(Double.MAX_VALUE);
    	putPointsButton.setMaxWidth(Double.MAX_VALUE);		    
	    exitButton.setMaxWidth(Double.MAX_VALUE);
	    
	    changeLanguageButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-font-family: 'Courier New'; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    loadFileButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-font-family: 'Courier New'; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    putPointsButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-font-family: 'Courier New'; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    exitButton.setStyle("-fx-font-weight: bold; -fx-text-fill: red; -fx-font-family: 'Courier New'; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	    infoButton.setStyle("-fx-font-weight: bold; -fx-text-fill: darkslategrey; -fx-font-family: 'Courier New'; -fx-border-radius: 5; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

	    buttons.add(changeLanguageButton);
	    buttons.add(loadFileButton);
	    buttons.add(putPointsButton);
	    buttons.add(exitButton);	    
	    buttons.add(infoButton);
	    
	}
    
    private void createMainPane()
	{
    	borderPane = new BorderPane();
    	createMainLogo();
    	borderPane.setStyle("-fx-background: #4682b4;");
//    	imageViewMain.fitWidthProperty().bind(stage.widthProperty()); 
    	borderPane.setPadding(new Insets(10, 10, 10, 10));
    	
    	borderPane.setTop(null);
    	
    	
    	if(imageViewMain !=null)
    	{
    		borderPane.setLeft(imageViewMain);
        	borderPane.setAlignment(imageViewMain, Pos.CENTER); 
    	}
    	
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
    	paperTitle = new Label("ΕΝΑΣ ΑΠΛΟΣ ΑΛΓΟΡΙΘΜΟΣ\n ΓΙΑ ΤΟΝ ΥΠΟΛΟΓΙΣΜΟ\n   ΤΟΥ ΕΛΑΧΙΣΤΟΥ\n ΠΕΡΙΚΛΕΙΩΝΤΑ ΚΥΚΛΟΥ");
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
    
    private void createMainLogo2()
	{
		String saitecLogo = "ImportantFiles/Icons/MainLogo_B2.png";
		
		File f = new File(saitecLogo);
		
		if(f.exists() && !f.isDirectory())
		{
			try {
				inputstreamMain2 = new FileInputStream(saitecLogo);
			} catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imageMain2 = new Image(inputstreamMain2); 
			imageViewMain2 = new ImageView(imageMain2);
			//setting the fit height and width of the image view 
		    imageViewMain2.setFitHeight(38); 
		    imageViewMain2.setFitWidth(20);
		}else
		{
			imageMain2=null;
			imageViewMain2 = null;
		}
		
	}
    
    private void createStage()
    {
    	if(imageViewMain2 != null)
		{
    		stage.getIcons().add(imageMain2);
		}
    	
    	stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion);
        stage.setHeight(700);
        stage.setWidth(600);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
}


