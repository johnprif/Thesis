package Control;

import Model.DataBase;
import View.SmallestEnclosingCircleGraphGUI;
import View.FarthestNeighborVoronoiGraphGUI;

public class GraphGUIHandler 
{
	private String path;
	private DataBase dataBase;
	private SmallestEnclosingCircleGraphGUI circleGraphGUI;
	private FarthestNeighborVoronoiGraphGUI farthestNeighborVoronoiGraphGUI;
	
	public GraphGUIHandler(String path)
	{
		this.path = path;
		dataBase = DataBase.getInstance();
		
		makeCircleGraph();
		makeFarthestNeighborVoronoiGraph();	
		
	}
	
	private void makeCircleGraph()
	{
		circleGraphGUI = new SmallestEnclosingCircleGraphGUI(path);
		circleGraphGUI.setAllPoints(dataBase.getAllPoints());
		circleGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		circleGraphGUI.setCirclePoints(dataBase.getCirclePoints());
		circleGraphGUI.setCircleObject(dataBase.findCircle());
		circleGraphGUI.initialize();
	}
	
	private void makeFarthestNeighborVoronoiGraph()
	{
		farthestNeighborVoronoiGraphGUI = new FarthestNeighborVoronoiGraphGUI(path);
		farthestNeighborVoronoiGraphGUI.setAllPoints(dataBase.getAllPoints());
		farthestNeighborVoronoiGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		farthestNeighborVoronoiGraphGUI.setCirclePoints(dataBase.getCirclePoints());
		farthestNeighborVoronoiGraphGUI.setCircleObject(dataBase.findCircle());
		farthestNeighborVoronoiGraphGUI.setK(dataBase.getK());
		farthestNeighborVoronoiGraphGUI.setE(dataBase.getE());
		
		farthestNeighborVoronoiGraphGUI.initialize();
	}
}
