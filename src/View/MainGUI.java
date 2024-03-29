package View;

import java.net.URL;
import java.util.ArrayList;
import Control.ChangeLanguageButtonHandler;
import Control.ExitButtonHandler;
import Control.InfoButtonHandler;
import Control.LoadFileButtonHandler;
import Control.PaperTitleHandler;
import Control.PutPointsButtonHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainGUI extends Application
{
	private String javaVersion = System.getProperty("java.version");
    private String javafxVersion = System.getProperty("javafx.version");
	private String version = "v1.0";
    
	private Stage stage;
	private Scene scene;
	
	private Button changeLanguageButton;
	private Button loadFileButton;
	private Button putPointsButton;
	private Button exitButton;	
	private Button infoButton;
	
	private BorderPane borderPane;
	private VBox vbox;
	
	private Label paperTitle;
	
	private ImageView imageViewMain;
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
        scene.getStylesheets().add("styles.css");
        
        createAndSetHandlers();
        
        createMainLogo2();
        
        createStage();  
    }

    public static void main(String[] args) 
    {
        launch();
    }
    
    private void createAndSetHandlers()
    {  	
    	changeLanguageButton.setOnAction(new ChangeLanguageButtonHandler(buttons, paperTitle)); 
    	loadFileButton.setOnAction(new LoadFileButtonHandler());   	
    	putPointsButton.setOnAction(new PutPointsButtonHandler());   	
    	exitButton.setOnAction(new ExitButtonHandler(stage));   	  	
    	infoButton.setOnAction(new InfoButtonHandler());   	
    }
       
    private void createButtons()
	{
    	changeLanguageButton = new Button();
    	loadFileButton = new Button();
    	putPointsButton = new Button();
    	exitButton = new Button();    	
    	infoButton = new Button(" ? ");
    	
    	changeLanguageButton.setId("changeLanguageButton");
    	loadFileButton.setId("loadFileButton");
    	putPointsButton.setId("putPointsButton");
    	exitButton.setId("exitButton");
    	infoButton.setId("infoButton");
    	
    	loadFileButton.setMaxWidth(Double.MAX_VALUE);
    	putPointsButton.setMaxWidth(Double.MAX_VALUE);		    
	    exitButton.setMaxWidth(Double.MAX_VALUE);
	    	    
	    buttons.add(changeLanguageButton);
	    buttons.add(loadFileButton);
	    buttons.add(putPointsButton);
	    buttons.add(exitButton);	    
	    buttons.add(infoButton);	    
	}
    
    private void createMainPane()
	{
    	borderPane = new BorderPane();
    	borderPane.setId("borderPane");
    	createMainLogo();  	
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
    	paperTitle = new Label();
    	paperTitle.setOnMouseClicked(new PaperTitleHandler());
    }
    
    private void createSecondPane()
    { 	
    	vbox = new VBox(10);   
    	vbox.setId("vbox");   	
    	vbox.getChildren().addAll(paperTitle, loadFileButton, putPointsButton, exitButton);    	
    }
    
    private void createMainLogo()
	{
    	URL url = getClass().getResource("/Icons/MainLogo_W.png");	
    	Image imageMain = new Image(url.toString()); 
		imageViewMain = new ImageView(imageMain);
		imageViewMain.setFitHeight(573); 
		imageViewMain.setFitWidth(300);		
	}
    
    private void createMainLogo2()
	{
		URL url = getClass().getResource("/Icons/MainLogo_W.png");	
		Image imageMain2 = new Image(url.toString()); 
		imageViewMain2 = new ImageView(imageMain2);
		imageViewMain2.setFitHeight(38); 
		imageViewMain2.setFitWidth(17);
	}
    
    private void createStage()
    {
    	URL url = getClass().getResource("/Icons/circle.png");
    	Image stageImage = new Image(url.toString());
    	stage.getIcons().add(stageImage);   	
    	stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion +", "+version);
    	stage.setHeight(700);
        stage.setWidth(600);
        stage.setResizable(false);
        stage.setScene(scene);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) 
	          {
	              stage.close();
	              System.exit(0);	              
	          }
	      });
        
        stage.show();
    }
    
}


