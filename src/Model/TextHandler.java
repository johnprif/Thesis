package Model;

public class TextHandler 
{
	private static TextHandler instance;
	
	private String changeLanguageButtonText;
	private String paperTitleText;	
	private String loadFileButtonText;
	private String putPointsButtonText;
	private String exitButtonText;
	
	
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
    		
    	}else //GR
    	{
    		//-----LoginWidnow--------------
    		paperTitleText = "ΕΝΑΣ ΑΠΛΟΣ ΑΛΓΟΡΙΘΜΟΣ\n ΓΙΑ ΤΟΝ ΥΠΟΛΟΓΙΣΜΟ\n   ΤΟΥ ΕΛΑΧΙΣΤΟΥ\n ΠΕΡΙΚΛΕΙΩΝΤΑ ΚΥΚΛΟΥ";
    		loadFileButtonText = "Φόρτωση Σημείων απο CSV";
    		putPointsButtonText = "Δημιουργία σημείων";
    		exitButtonText = "Έξοδος";
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
}
