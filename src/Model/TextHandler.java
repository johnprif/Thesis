package Model;

public class TextHandler 
{
	private static TextHandler instance;
	
	//-----------parallel---------------
	private String changeLanguageButtonText = "EN";
	private String paperTitleText = "A SIMPLE ALGORITHM FOR COMPUTING THE SMALLEST ENCLOSING CIRCLE";
	private String loadFileButtonText = "Load Points From File";
	private String putPointsButtonText = "Create Points";
	private String exitButtonText = "Exit";
	
	//----------notParallel----------------
	private String fileChooserTitleText = "Choose the file who contains the points";
	
	private String notImpementPopupTitle = "Put points";
	private String notImpementPopupHeaderText = "Under construction!";
	private String notImpementContentText = "The manual addition of points has not been implemented yet!\\nIn the future the user will be able to add points manually and modify them without having to load them from an external file.";
	
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
    	changeLanguageButtonText = language;
    	if(language.equals("EN"))
    	{
    		//-----MainWidnow--------------   		
    		paperTitleText = "A SIMPLE ALGORITHM FOR COMPUTING THE SMALLEST ENCLOSING CIRCLE";
    		loadFileButtonText = "Load Points From File";
    		putPointsButtonText = "Create Points";
    		exitButtonText = "Exit";  		
    		
    		//-----FileChooserWindow--------------
    		fileChooserTitleText = "Choose the file who contains the points";
    		
    		//PutPointsButtonHandler popup
    		notImpementPopupTitle = "Put points";
    		notImpementPopupHeaderText = "Under construction!";
    		notImpementContentText = "The manual addition of points has not been implemented yet!\\nIn the future the user will be able to add points manually and modify them without having to load them from an external file.";
    		
    	}else //GR
    	{
    		//-----MainWidnow--------------
    		paperTitleText = "ΕΝΑΣ ΑΠΛΟΣ ΑΛΓΟΡΙΘΜΟΣ ΓΙΑ ΤΟΝ ΥΠΟΛΟΓΙΣΜΟ ΤΟΥ ΕΛΑΧΙΣΤΟΥ ΠΕΡΙΚΛΕΙΩΝΤΑ ΚΥΚΛΟΥ";
    		loadFileButtonText = "Φόρτωση Σημείων από Αρχείο";
    		putPointsButtonText = "Δημιουργία σημείων";
    		exitButtonText = "Έξοδος";
    		
    		//-----FileChooserWindow--------------
    		fileChooserTitleText = "Επιλέξτε το αρχείο που περιέχει τα σημεία";
    		
    		//PutPointsButtonHandler popup  		
    		notImpementPopupTitle = "Προσθήκη Σημείων";
    		notImpementPopupHeaderText = "Υπό κατασκευή!";
    		notImpementContentText = "Η χειροκίνητη προσθήκη σημείων δεν έχει υλοποιηθεί ακόμα!\nΜελλοντικά ο χρήστης θα μπορεί να προσθέσει σημεία με το χέρι του και να τα τροποποιεί χωρίς να χρειάζεται η φόρτωση τους από εξωτερικό αρχείο.";    	
    	}
    }
    
    public String getChangeLanguageButtonText()
    {
    	return changeLanguageButtonText;
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
    
    public String getNotImpementPopupTitle()
    {
    	return notImpementPopupTitle;
    }
    public String getNotImpementPopupHeaderText()
    {
    	return notImpementPopupHeaderText;
    }
    public String getNotImpementContentText()
    {
    	return notImpementContentText;
    }
    
}
