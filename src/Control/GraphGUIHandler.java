package Control;

import Model.DataBase;
import Model.NearestNeighborVoronoiAlgorithm3;
import View.SmallestEnclosingCircleGraphGUI;
import View.VoronoiGraphGUI;

public class GraphGUIHandler 
{
	private String path;
	private DataBase dataBase;
	private SmallestEnclosingCircleGraphGUI circleGraphGUI;
	private VoronoiGraphGUI farthestNeighborVoronoiGraphGUI;
	private VoronoiGraphGUI nearestNeighborVoronoiGraphGUI;
	
	public GraphGUIHandler(String path)
	{
		this.path = path;
		dataBase = DataBase.getInstance();
		
		makeCircleGraph();
//		makeFarthestNeighborVoronoiGraph();	
		makeNearestNeighborVoronoiGraph();
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
		farthestNeighborVoronoiGraphGUI = new VoronoiGraphGUI(path);
		farthestNeighborVoronoiGraphGUI.setTitle("Farthest Neighbor Voronoi Diagram");
		farthestNeighborVoronoiGraphGUI.setAllPoints(dataBase.getAllPoints());
		farthestNeighborVoronoiGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		farthestNeighborVoronoiGraphGUI.setK(dataBase.getK());
		farthestNeighborVoronoiGraphGUI.setE(dataBase.getE());		
		farthestNeighborVoronoiGraphGUI.initialize();
	}
	
	private void makeNearestNeighborVoronoiGraph()
	{
		nearestNeighborVoronoiGraphGUI = new VoronoiGraphGUI(path);
		nearestNeighborVoronoiGraphGUI.setTitle("Nearest Neighbor Voronoi Diagram");
		nearestNeighborVoronoiGraphGUI.setAllPoints(dataBase.getAllPoints());
		nearestNeighborVoronoiGraphGUI.setConvexPoints(dataBase.getConvexPoints());
		nearestNeighborVoronoiGraphGUI.setK(dataBase.getK());
		nearestNeighborVoronoiGraphGUI.setE(dataBase.getE());		
		nearestNeighborVoronoiGraphGUI.initialize();
	}
}
