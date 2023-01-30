package Control;

import View.CircleGraphGUI;

public class GraphsGUIHandler 
{
	private String path;
	private CircleGraphGUI circleGraphGUI;
	
	public GraphsGUIHandler(String path)
	{
		this.path = path;
		
		circleGraphGUI = new CircleGraphGUI(path);
	}
}
