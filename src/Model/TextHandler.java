package Model;

public class TextHandler 
{
	private static TextHandler instance;
	
	//-----------parallel---------------
	private String changeLanguageButtonText = "EN";
	private String paperTitleText = "Implementation of an Algorithm for the Calculation of the Smallest Enclosing Circle and the Voronoi Diagram";
	private String loadFileButtonText = "Load Points From File";
	private String putPointsButtonText = "Create Points";
	private String exitButtonText = "Exit";
	
	//----------notParallel----------------
	private String fileChooserTitleText = "Choose the file who contains the points";
	
	private String notImpementPopupTitle = "Put points";
	private String notImpementPopupHeaderText = "Under construction!";
	private String notImpementContentText = "The manual addition of points has not been implemented yet!\\nIn the future the user will be able to add points manually and modify them without having to load them from an external file.";
	
	private String infoWindowTitle = "Information + Instructions for use";
	private String infoContent = "ABOUT\n"
			+ "This thesis was developed in the context of the paper by Sven Skyum 1991 entitled \"Implementation of an Algorithm for the Calculation of the Smallest Enclosing Circle and the Voronoi Diagram\" and concerns the implementation and visualization of an efficient complexity algorithm O(nlogn) and computes the least pericycle and with small changes and maintaining the same complexity is able to compute both the Voronoi diagrams of the nearest and the farthest neighbor\r\n\n"
			+ "IMPLEMENTATION INSTRUCTIONS:\r\n"
			+ "1) You can change the language from Greek to English and vice versa in real time by pressing the button on the top right with the corresponding mark\r\n"
			+ "2) By pressing the 'Exit' button the application terminates\r\n"
			+ "3) Pressing the 'Load Points' button will display a window asking you to load a file with points x,y from the supported application types (csv, txt, excel)\r\n"
			+ "4) Finally, the three charts with their corresponding graphs will be displayed.\r\n"
			+ "5) You can do the following actions on the graphs:\r\n"
			+ " - alt+leftclick: drag and drop\r\n"
			+ " - rightclick: export to file\r\n"
			+ " - leftclick: choose a point \r\n"
			+ " - scroll: zoom in or zoom out\r\n"
			+ "** The 'Create Points' button has not been implemented yet and will be implemented at some point in the future\r\n"
			+ "*** Leftclicking on the title will open the browser in the thesis paper\r\n\n"
			+ "IMAGES FROM THE APP\n";
	
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
    		paperTitleText = "Implementation of an Algorithm for the Calculation of the Smallest Enclosing Circle and the Voronoi Diagram";
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
    		infoWindowTitle = "Information + Instructions for use";
    		infoContent = "ABOUT\n"
    				+ "This thesis was developed in the context of the paper by Sven Skyum 1991 entitled \"Implementation of an Algorithm for the Calculation of the Smallest Enclosing Circle and the Voronoi Diagram\" and concerns the implementation and visualization of an efficient complexity algorithm O(nlogn) and computes the least pericycle and with small changes and maintaining the same complexity is able to compute both the Voronoi diagrams of the nearest and the farthest neighbor\r\n\n"
    				+ "IMPLEMENTATION INSTRUCTIONS:\r\n"
    				+ "1) You can change the language from Greek to English and vice versa in real time by pressing the button on the top right with the corresponding mark\r\n"
    				+ "2) By pressing the 'Exit' button the application terminates\r\n"
    				+ "3) Pressing the 'Load Points' button will display a window asking you to load a file with points x,y from the supported application types (csv, txt, excel)\r\n"
    				+ "4) Finally, the three charts with their corresponding graphs will be displayed.\r\n"
    				+ "5) You can do the following actions on the graphs:\r\n"
    				+ " - alt+leftclick: drag and drop\r\n"
    				+ " - rightclick: export to file\r\n"
    				+ " - leftclick: choose a point \r\n"
    				+ " - scroll: zoom in or zoom out\r\n"
    				+ "** The 'Create Points' button has not been implemented yet and will be implemented at some point in the future\r\n"
    				+ "*** Leftclicking on the title will open the browser in the thesis paper\r\n\n"
    				+ "IMAGES FROM THE APP\n";
    	}else //GR
    	{
    		//-----MainWidnow--------------
    		paperTitleText = "Υλοποίηση Αλγορίθμου για τον Υπολογισμό του Ελάχιστου Περικλείοντος Κύκλου και του Διαγράμματος Voronoi\n\t";
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
    		infoWindowTitle = "Πληροφορίες + Οδηγίες χρήσης";
    		infoContent = "ΣΧΕΤΙΚΑ\n"
    				+ "Αυτή η διπλωματική εργασία αναπτύχθηκε στα πλαίσια του Paper από τον Sven Skyum 1991 με τίτλο \"Implementation of an Algorithm for the Calculation of the Smallest Enclosing Circle and the Voronoi Diagram\" και αφορά την υλοποίηση και οπτικοποίηση ενός αποδοτικού αλγορίθμου πολυπλοκότητας O(nlogn) και υπολογίζει τον ελάχιστο περικλείοντα κύκλο και με μικρές αλλαγές και διατηρώντας την ίδια πολυπλοκότητα είναι ικανός να υπολογίσει και τα διαγράμματα Voronoi του πλησιέστερου και του πιο απομακρυσμένου γείτονα\r\n\n"
    				+ "ΟΔΗΓΙΕΣ ΕΦΑΡΜΟΓΗΣ:\r\n"
    				+ "1) Μπορείτε να αλλάξετε την γλώσσα από ελληνικά σε αγγλικά και αντίστροφα σε πραγματικό χρόνο πατώντας το κουμπί πάνω δεξιά με την αντίστοιχη σήμανση\r\n"
    				+ "2) Πατώντας το κουμπί 'Έξοδος' η εφαρμογή τερματίζει\r\n"
    				+ "3) Πατώντας το κουμπί 'Φόρτωση Σημείων' θα σας εμφανιστεί ένα παράθυρο στο οποίο θα σας ζητηθεί να φορτώσετε ένα αρχείο με σημεία x,y από τους υποστηριζόμενους τύπους της εφαρμογής(csv, txt, excel)\r\n"
    				+ "4) Τέλος, εμφανίζονται τα τρία διαγράμματα με τα αντίστοιχα γραφήματα.\r\n"
    				+ "5) Μπορείτε να κάνετε τις εξής ενέργειες στα γραφήματα:\r\n"
    				+ " - alt+αριστερό-κλικ: μετακίνηση\r\n"
    				+ " - δεξί-κλικ: export to file\r\n"
    				+ " - leftclick: choose a point \r\n"
    				+ " - scroll: zoom in or zoom out\r\n"
    				+ "** Το κουμπί 'Δημιουργία Σημείων' δεν έχει υλοποιηθεί ακόμα και θα υλοποιηθεί κάποια στιγμή στο μέλλον\r\n"
    				+ "*** Κάνοντας αριστερό-κλικ στον τίτλο θα ανοίξει ο browser στο paper της δηπλωματικής εργασίας\n\n"
    				+ "ΕΙΚΟΝΕΣ ΑΠΟ ΤΗΝ ΕΦΑΡΜΟΓΗ\n";
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
    
    public String getInfoWindowTitle()
    {
    	return infoWindowTitle;
    }
    
    public String getInfoContent()
    {
    	return infoContent;
    }
    
}
