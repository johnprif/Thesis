package View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Model.CSVLoader;
import Model.DoublyLinkedList;
import javafx.application.Application;
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
	private Button loadFileButton;
	private Button putPointsButton;
	private Button exitButton;
	private Button changeLanguageButton;
	private Button infoButton;
	
	private BorderPane borderPane;
	private GridPane gridPane;
	private VBox vbox;
	private VBox vbox2;
	
	private FileInputStream inputstreamMain;
	private Image imageMain;
	private ImageView imageViewMain;
	
	@Override
    public void start(Stage stage)
	{
		createButtons();
//		createSecondPane();
		createSecondPane2();
		createMainPane(stage);
		
		
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        Scene scene = new Scene(new StackPane(l), 640, 480);
        
        Scene scene = new Scene(borderPane);
        
        stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion);
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
//	    changeLanguageButton.setMaxWidth(Double.MAX_VALUE);
	}
    
    private void createMainPane(Stage stage)
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
    
    private void createSecondPane()
    {
    	Label myText = new Label("A simple aglorithm for computing \nthe smallest enclosing circle");
    	myText.setStyle("-fx-font-weight: bold;");
    	myText.setMaxWidth(Double.MAX_VALUE);
    	myText.setAlignment(Pos.CENTER);
    	
    	gridPane = new GridPane();
    	gridPane.setPadding(new Insets(10, 10, 10, 10));
    	gridPane.setVgap(10); 
    	gridPane.setHgap(10); 
    	gridPane.setAlignment(Pos.CENTER); 
    	gridPane.add(myText, 0, 0);
    	gridPane.add(loadFileButton, 0, 1);
    	gridPane.add(putPointsButton, 0, 2);
    	gridPane.add(exitButton, 0, 3);
    }
    
    private void createSecondPane2()
    {
//    	Label myText = new Label("A simple aglorithm for\ncomputing the smallest\nenclosing circle");
    	Label myText = new Label("A SIMPLE ALGORITHM FOR\nCOMPUTING THE SMALEST\n   ENCLOSING CIRCLE");
    	myText.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 17; -fx-font-family: 'Courier New'; -fx-underline: false;");
    	myText.setMaxWidth(Double.MAX_VALUE);
    	myText.setAlignment(Pos.CENTER);
    	
    	vbox = new VBox(10);
    	
    	vbox.setAlignment(Pos.CENTER);
    	
    	vbox.setMargin(myText, new Insets(5, 5, 50, 5)); 
//    	vbox.setStyle("-fx-background-color: yellow;");

    	vbox.getChildren().addAll(myText, loadFileButton, putPointsButton, exitButton);
    	
    	
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
    
}


