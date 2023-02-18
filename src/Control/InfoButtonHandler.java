package Control;

import java.net.URL;
import Model.TextHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoButtonHandler  implements EventHandler<ActionEvent>
{
	private Stage stage;
	private VBox layout;
	private Scene scene;
	private Label label;
	private ImageView circle;
	private ImageView nearestVoronoi;
	private ImageView farthestVoronoi;
	private TextHandler textHandler;
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		textHandler = TextHandler.getInstance();	
		createAndShowInfoWindow();
	}
	
	private void createAndShowInfoWindow()
	{	
		stage = new Stage();
        stage.setTitle(textHandler.getInfoWindowTitle());
        URL url = getClass().getResource("/Icons/circle.png");
    	Image stageImage = new Image(url.toString());
    	stage.getIcons().add(stageImage); 
              
        createLabelContent();  
        createGrahpImages(200);
        createBox();
       
        scene = new Scene(layout, 640, 700);
        scene.getStylesheets().add("styles.css");
        
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();		
	}
	
	private void createLabelContent() 
	{
		label = new Label(textHandler.getInfoContent());
        label.setId("infoLabel");
        label.setCursor(Cursor.HAND);
        label.setOnMouseClicked(new InfoContentHandler());
	}
	
	private void createBox()
	{
        layout = new VBox(10);     
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.getChildren().addAll(circle, nearestVoronoi, farthestVoronoi);
		layout.getChildren().addAll(label, hbox);
	}
	
	private void createGrahpImages(int size)
	{		
		createCircleImage(size);
		createNearestVoronoiImage(size);
		createFarthestVoronoiImage(size) ;		
	}
	
	private void createCircleImage(int size)
	{
		URL url0 = getClass().getResource("/Icons/circle (2).png");	
		Image circleImage = new Image(url0.toString()); 
		circle = new ImageView(circleImage);
		circle.setFitHeight(size); 
		circle.setFitWidth(size);
	}
	
	private void createNearestVoronoiImage(int size)
	{
		URL url1 = getClass().getResource("/Icons/nearestVoronoi.png");	
		Image nearestVoronoiImage = new Image(url1.toString()); 
		nearestVoronoi = new ImageView(nearestVoronoiImage);
		nearestVoronoi.setFitHeight(size); 
		nearestVoronoi.setFitWidth(size);
	}
	
	private void createFarthestVoronoiImage(int size) 
	{
		URL url2 = getClass().getResource("/Icons/farthestVoronoi.png");
		Image farthestVoronoiImage = new Image(url2.toString()); 
		farthestVoronoi = new ImageView(farthestVoronoiImage);
		farthestVoronoi.setFitHeight(size); 
		farthestVoronoi.setFitWidth(size);
	}

}
