package Control;

import java.util.ArrayList;
import Model.TextHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChangeLanguageButtonHandler  implements EventHandler<ActionEvent>
{
	private TextHandler textHandler;
	private Boolean flag=true;
		
	private Button changeLanguageButton;
	private Label paperTitle;	
	private Button loadFileButton;
	private Button putPointsButton;
	private Button exitButton;
	
	public ChangeLanguageButtonHandler(ArrayList<Button> buttons, Label paperTitle)
	{
		textHandler = TextHandler.getInstance();
		
		this.paperTitle = paperTitle;
		
		changeLanguageButton = buttons.get(0);
		loadFileButton = buttons.get(1);
		putPointsButton = buttons.get(2);
		exitButton = buttons.get(3);
		
		//first time
		setTexts();
	}
	
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		//flag=true -> EN
		//flag=false -> GR
		
		flag=!flag;
		
		textHandler = TextHandler.getInstance();
		
		textHandler.setLanguage(flag? "EN" : "GR");
		
		setTexts();		
	}
	
	private void setTexts()
	{
		changeLanguageButton.setText(textHandler.getChangeLanguageButtonText());
		paperTitle.setText(textHandler.getPaperTitleText());
		loadFileButton.setText(textHandler.getLoadFileButtonText());
		putPointsButton.setText(textHandler.getPutPointsButtonText());
		exitButton.setText(textHandler.getExitButtonText());
	}

}
