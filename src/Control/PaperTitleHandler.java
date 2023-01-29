package Control;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PaperTitleHandler implements EventHandler<MouseEvent>
{
	private String paperURL = "https://reader.elsevier.com/reader/sd/pii/002001909190030L?token=792B047EFD2FBA85B976C2FCB728380392A08F2C78D489ECFB26B2F3CE023E7512BEC247BC14F3EBE21A61E69DDFFC54&originRegion=eu-west-1&originCreation=20230129211433";
	
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
