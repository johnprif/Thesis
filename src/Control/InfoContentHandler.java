package Control;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class InfoContentHandler implements EventHandler<MouseEvent>
{
private String paperURL = "https://github.com/johnprif/Thesis";
	
	@Override
	public void handle(MouseEvent arg0) 
	{      
        try {
            Desktop.getDesktop().browse(new URI(paperURL));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }		
	}
}
