package View;

import java.net.URL;
import java.util.ArrayList;
import Control.ChangeLanguageButtonHandler;
import Control.ExitButtonHandler;
import Control.InfoButtonHandler;
import Control.LoadFileButtonHandler;
import Control.PutPointsButtonHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application
{
	private String javaVersion = System.getProperty("java.version");
    private String javafxVersion = System.getProperty("javafx.version");
	private String version = "v0.4";
    
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
	
	private Image imageMain;
	private ImageView imageViewMain;
	
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
    	changeLanguageButtonHandler = new ChangeLanguageButtonHandler(buttons, paperTitle);
    	loadFileButtonHandler = new LoadFileButtonHandler(stage);
    	putPointsButtonHandler = new PutPointsButtonHandler(stage);
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
    	changeLanguageButton = new Button("EN");
    	loadFileButton = new Button("Load Points From File");
    	putPointsButton = new Button("Create Points");
    	exitButton = new Button("Exit");    	
    	infoButton = new Button("?");
    	
    	changeLanguageButton.setId("changeLanguageButton");
    	loadFileButton.setId("loadFileButton");
    	putPointsButton.setId("putPointsButton");
    	exitButton.setId("exitButton");
    	infoButton.setId("infoButton");
    	
    	changeLanguageButton.setAlignment(Pos.CENTER);
    	loadFileButton.setAlignment(Pos.CENTER);
    	putPointsButton.setAlignment(Pos.CENTER);
    	exitButton.setAlignment(Pos.CENTER);   	
    	infoButton.setAlignment(Pos.CENTER);
    	
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
    	createMainLogo();
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
    	paperTitle = new Label("A SIMPLE ALGORITHM FOR\nCOMPUTING THE SMALLEST\n   ENCLOSING CIRCLE\n  ");\
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
    	URL url = getClass().getResource("/Icons/MainLogo_W.png");	
		imageMain = new Image(url.toString()); 
		imageViewMain = new ImageView(imageMain);
		imageViewMain.setFitHeight(573); 
		imageViewMain.setFitWidth(300);		
	}
    
    private void createMainLogo2()
	{
		URL url = getClass().getResource("/Icons/MainLogo_W.png");	
		imageMain2 = new Image(url.toString()); 
		imageViewMain2 = new ImageView(imageMain2);
		imageViewMain2.setFitHeight(38); 
		imageViewMain2.setFitWidth(17);
	}
    
    private void createStage()
    {
    	stage.getIcons().add(imageMain2);   	
    	stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion +", "+version);
    	stage.setHeight(700);
        stage.setWidth(600);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }
    
}


