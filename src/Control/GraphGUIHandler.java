package Control;

import Model.DataBase;
import View.SmallestEnclosingCircleGraphGUI;
import View.VoronoiGraphGUI;

public class GraphGUIHandler 
{
	private String path;
	private DataBase dataBase;
	private SmallestEnclosingCircleGraphGUI circleGraphGUI;
	private VoronoiGraphGUI farthestNeighborVoronoiGraphGUI;
	
	public GraphGUIHandler(String path)
	{
		this.path = path;
		dataBase = DataBase.getInstance();
		
		makeCircleGraph("Smallest Enclosing Circle", 0, 0);
		makeVoronoiGraph("Nearest Neighbor Voronoi Diagram", 700, 0, 0);	
		makeVoronoiGraph("Farthest Neighbor Voronoi Diagram", 1400, 0, 1);
	}
	
	private void makeCircleGraph(String title, int x, int y)
	{
		circleGraphGUI = new SmallestEnclosingCircleGraphGUI(path);
		circleGraphGUI.setTitle(title);
		circleGraphGUI.setAllPoints(dataBase.getAllPoints());
		circleGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		circleGraphGUI.setCirclePoints(dataBase.getCirclePoints());
		circleGraphGUI.setCircleObject(dataBase.getCircleShape());
		circleGraphGUI.initialize(x, y);
	}
	
	private void makeVoronoiGraph(String title, int x, int y, int mode)
	{
		farthestNeighborVoronoiGraphGUI = new VoronoiGraphGUI(path);
		farthestNeighborVoronoiGraphGUI.setTitle(title);
		farthestNeighborVoronoiGraphGUI.setAllPointsSize(dataBase.getAllPointsSize());
		farthestNeighborVoronoiGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		farthestNeighborVoronoiGraphGUI.setK(dataBase.getK(mode));
		farthestNeighborVoronoiGraphGUI.setE(dataBase.getE(mode));		
		farthestNeighborVoronoiGraphGUI.initialize(x, y);
	}
}
