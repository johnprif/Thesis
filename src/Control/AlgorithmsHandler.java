package Control;

import Model.SmallestEnclosingCirlceAlgorithm1;
import Model.FarthestNeighborVoronoiAlgorithm2;
import Model.NearestNeighborVoronoiAlgorithm3;
import Model.DataBase;
import Model.GrahamScan;

public class AlgorithmsHandler 
{	
	private GrahamScan grahamScan;
	private SmallestEnclosingCirlceAlgorithm1 algorithm1;
	private FarthestNeighborVoronoiAlgorithm2 algorithm2;
	private NearestNeighborVoronoiAlgorithm3 algorithm3;
	private DataBase dataBase;
	
	public AlgorithmsHandler()
	{
		dataBase = DataBase.getInstance();
		
		grahamScan = new GrahamScan();	
		grahamScan.initialize();
		
		algorithm1 = new SmallestEnclosingCirlceAlgorithm1();	
		algorithm1.computeSmallestEnclosingCircle();
		
//		algorithm2 = new FarthestNeighborVoronoiAlgorithm2();
//		algorithm2.computeFarthestNeighborVoronoiDiagram();
		
		algorithm3 = new NearestNeighborVoronoiAlgorithm3();
		algorithm3.computeNearestNeighborVoronoiDiagram();
	}
}
