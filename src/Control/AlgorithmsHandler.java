package Control;

import Model.SmallestEnclosingCirlceAlgorithm1;
import Model.VoronoiAlgorithm2and3;
import Model.DataBase;
import Model.GrahamScan;

public class AlgorithmsHandler 
{	
	private GrahamScan grahamScan;
	private SmallestEnclosingCirlceAlgorithm1 algorithm1;
	private VoronoiAlgorithm2and3 nearestNeighbor;
	private VoronoiAlgorithm2and3 farthestNeighbor;
	private DataBase dataBase;
	
	public AlgorithmsHandler()
	{
		dataBase = DataBase.getInstance();
		dataBase.initializeKandE();
		
		grahamScan = new GrahamScan();			
		grahamScan.initialize();
		
		algorithm1 = new SmallestEnclosingCirlceAlgorithm1();	
		dataBase.prepareForAlgorithm(0);		
		algorithm1.computeSmallestEnclosingCircle();
		
		nearestNeighbor = new VoronoiAlgorithm2and3();
		dataBase.prepareForAlgorithm(1);	
		nearestNeighbor.computeVoronoiDiagram();
		
		farthestNeighbor = new VoronoiAlgorithm2and3();
		dataBase.prepareForAlgorithm(2);
		farthestNeighbor.computeVoronoiDiagram();
	}
}
