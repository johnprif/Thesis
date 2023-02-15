package Control;

import Model.SmallestEnclosingCirlce;
import Model.NeighborVoronoiDiagram;
import Model.DataBase;
import Model.GrahamScan;

public class AlgorithmsHandler 
{	
	private GrahamScan grahamScan;
	private SmallestEnclosingCirlce algorithm1;
	private NeighborVoronoiDiagram nearestNeighbor;
	private NeighborVoronoiDiagram farthestNeighbor;
	private DataBase dataBase;
	
	public AlgorithmsHandler()
	{
		dataBase = DataBase.getInstance();
		dataBase.initializeKandE();
		
		callAlgorithms();
	}
	
	private void callAlgorithms()	
	{
		callGrahamScan();
		
		callSmallestEnclosingCircle();
		
		callNearestNeighborVoronoi();
		
		callFarthestNeighborVoronoi();
	}
	
	private void callGrahamScan()
	{
		grahamScan = new GrahamScan();			
		grahamScan.initialize();
	}
	
	private void callSmallestEnclosingCircle()
	{
		algorithm1 = new SmallestEnclosingCirlce();	
		dataBase.prepareForAlgorithm(0);		
		algorithm1.computeSmallestEnclosingCircle();
	}
	
	private void callNearestNeighborVoronoi()
	{
		nearestNeighbor = new NeighborVoronoiDiagram();
		dataBase.prepareForAlgorithm(1);	
		nearestNeighbor.computeVoronoiDiagram();
	}
	
	private void callFarthestNeighborVoronoi()
	{
		farthestNeighbor = new NeighborVoronoiDiagram();
		dataBase.prepareForAlgorithm(2);
		farthestNeighbor.computeVoronoiDiagram();
	}
}
