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
	
	private String infoContent = "This thesis was developed in the context of the paper by Sven Skyum 1991 entitled \"A SIMPLE ALGORITHM FOR COMPUTING THE SMALLEST ENCLOSING CIRCLE\" and concerns the implementation and visualization of an efficient complexity algorithm O(nlogn) and computes the least pericycle and with small changes and maintaining the same complexity is able to compute both the Voronoi diagrams of the nearest and the farthest neighbor\r\n";
	
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
    		notImpementContentText = "The manual addition of points has not been implemented yet!\nIn the future the user will be able to add points manually and modify them without having to load them from an external file.";
    		
    		//Info button
    		infoContent = "This thesis was developed in the context of the paper by Sven Skyum 1991 entitled \"A SIMPLE ALGORITHM FOR COMPUTING THE SMALLEST ENCLOSING CIRCLE\" and concerns the implementation and visualization of an efficient complexity algorithm O(nlogn) and computes the least pericycle and with small changes and maintaining the same complexity is able to compute both the Voronoi diagrams of the nearest and the farthest neighbor\r\n";
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
    	
    		//Info button  		
    		infoContent = "Αυτή η διπλωματική εργασία αναπτύχθηκε στα πλαίσια του Paper από τον Sven Skyum 1991 με τίτλο \"A SIMPLE ALGORITHM FOR COMPUTING THE SMALLEST ENCLOSING CIRCLE\" και αφορά την υλοποίηση και οπτικοποίηση ενός αποδοτικού αλγορίθμου πολυπλοκότητας O(nlogn) και υπολογίζει τον ελάχιστο περικλέιοντα κύκλο και με μικρές αλλαγές και διατηρώντας την ίδια πολυπλοκότητα είναι ικανός να υπολογίσει και τα διαγράμματα Voronoi του κοντινότερου και του μακρύτερου γείτονα";
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
    
    public String getInfoContent()
    {
    	return infoContent;
    }
    
}
