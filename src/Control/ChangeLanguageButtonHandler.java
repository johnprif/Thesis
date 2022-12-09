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
	private Boolean flag=false;
	private ArrayList<Button> buttons;
		
	private Button changeLanguageButton;
	private Label paperTitle;	
	private Button loadFileButton;
	private Button putPointsButton;
	private Button exitButton;
	
	public ChangeLanguageButtonHandler(ArrayList<Button> buttons, Label paperTitle)
	{
		this.buttons = new ArrayList<Button>(buttons);
		this.paperTitle = paperTitle;
		
		changeLanguageButton = buttons.get(0);
		loadFileButton = buttons.get(1);
		putPointsButton = buttons.get(2);
		exitButton = buttons.get(3);
	}
	
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		//flag=0 -> EN
		//flag=1 -> GR
		
		flag=!flag;
		
		textHandler = TextHandler.getInstance();
		textHandler.setLanguage(flag? "EN" : "GR");
		
		changeLanguageButton.setText(flag? "EN" : "GR");
		paperTitle.setText(textHandler.getPaperTitleText());
		loadFileButton.setText(textHandler.getLoadFileButtonText());
		putPointsButton.setText(textHandler.getPutPointsButtonText());
		exitButton.setText(textHandler.getExitButtonText());
	}
	
	public String getPaperTitleText()
    {
    	return textHandler.getPaperTitleText();
    }
    
    public String getLoadFileButtonText()
    {
    	return textHandler.getLoadFileButtonText();
    }
    
    public String getPutPointsButtonText()
    {
    	return textHandler.getPutPointsButtonText();
    }
    
    public String getExitButtonText()
    {
    	return textHandler.getExitButtonText();
    }

}
