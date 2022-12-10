package Model;

public class TextHandler 
{
	private static TextHandler instance;
	
	//parallel
	private String changeLanguageButtonText;
	private String paperTitleText;	
	private String loadFileButtonText;
	private String putPointsButtonText;
	private String exitButtonText;
	
	//notParallel
	private String fileChooserTitleText = "Επιλέξτε το αρχείο που περιέχει τα σημεία";
	
	private TextHandler()
    {
		//TextClass();
    }

    //Get the only object available
    public static TextHandler getInstance()
    {
        if (instance == null) 
        {
            instance = new TextHandler();
        }
        return instance;
    }
    
    public void setLanguage(String language)
    {
    	if(language.equals("EN"))
    	{
    		//-----MainWidnow--------------
    		paperTitleText = "A SIMPLE ALGORITHM FOR\nCOMPUTING THE SMALEST\n   ENCLOSING CIRCLE\n  ";
    		loadFileButtonText = "Load Points From CSV";
    		putPointsButtonText = "Create Points";
    		exitButtonText = "Exit";  		
    		
    		//-----FileChooserWindow--------------
    		fileChooserTitleText = "Choose the file who contains the points";
    		
    	}else //GR
    	{
    		//-----MainWidnow--------------
    		paperTitleText = "ΕΝΑΣ ΑΠΛΟΣ ΑΛΓΟΡΙΘΜΟΣ\n ΓΙΑ ΤΟΝ ΥΠΟΛΟΓΙΣΜΟ\n   ΤΟΥ ΕΛΑΧΙΣΤΟΥ\n ΠΕΡΙΚΛΕΙΩΝΤΑ ΚΥΚΛΟΥ";
    		loadFileButtonText = "Φόρτωση Σημείων από CSV";
    		putPointsButtonText = "Δημιουργία σημείων";
    		exitButtonText = "Έξοδος";
    		
    		//-----FileChooserWindow--------------
    		fileChooserTitleText = "Επιλέξτε το αρχείο που περιέχει τα σημεία";
    	}
    }
    
    public String getPaperTitleText()
    {
    	return paperTitleText;
    }
    
    public String getLoadFileButtonText()
    {
    	return loadFileButtonText;
    }
    
    public String getPutPointsButtonText()
    {
    	return putPointsButtonText;
    }
    
    public String getExitButtonText()
    {
    	return exitButtonText;
    }
    
    public String getFileChooserTitleText()
    {
    	return fileChooserTitleText;
    }
}
