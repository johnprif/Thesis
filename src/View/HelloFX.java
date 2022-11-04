package View;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Model.CSVLoader;
import Model.DoublyLinkedList;
import Model.DoublyLinkedListTester;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application
{
	@Override
    public void start(Stage stage)
	{
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        Scene scene = new Scene(new StackPane(l), 640, 480);
        
        stage.setTitle("Sven Skyum 1991, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        
//        stage.setScene(scene);
        stage.show();
        try {
			DoublyLinkedListTester tester = new DoublyLinkedListTester();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public static void main(String[] args) {
        launch();
    }
}
