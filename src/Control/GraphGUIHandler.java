package Control;

import Model.DataBase;
import View.CircleGraphGUI;
import View.VoronoiGraphGUI;

public class GraphGUIHandler 
{
	private String path;
	private DataBase dataBase;
	private CircleGraphGUI circleGraphGUI;
	private VoronoiGraphGUI voronoiGraphGUI;
	
	public GraphGUIHandler(String path)
	{
		this.path = path;
		dataBase = DataBase.getInstance();
		
		makeCircleGraph();
		makeVoronoiGraph();	
	}
	
	private void makeCircleGraph()
	{
		circleGraphGUI = new CircleGraphGUI(path);
		circleGraphGUI.setAllPoints(dataBase.getAllPoints());
		circleGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		circleGraphGUI.setCirclePoints(dataBase.getCirclePoints());
		circleGraphGUI.setCircleObject(dataBase.findCircle());
		circleGraphGUI.initialize();
	}
	
	private void makeVoronoiGraph()
	{
		voronoiGraphGUI = new VoronoiGraphGUI(path);
		voronoiGraphGUI.setAllPoints(dataBase.getAllPoints());
		voronoiGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		voronoiGraphGUI.setCirclePoints(dataBase.getCirclePoints());
		voronoiGraphGUI.setCircleObject(dataBase.findCircle());
		voronoiGraphGUI.setK(dataBase.getK());
		voronoiGraphGUI.setE(dataBase.getE());
		
		voronoiGraphGUI.initialize();
	}
}
