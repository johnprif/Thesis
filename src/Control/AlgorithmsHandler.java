package Control;

import Model.Algorithm1;
import Model.Algorithm2;
import Model.Algorithm3;
import Model.DataBase;
import Model.GrahamScan;

public class AlgorithmsHandler 
{	
	private GrahamScan grahamScan;
	private Algorithm1 algorithm1;
	private Algorithm2 algorithm2;
	private Algorithm3 algorithm3;
	private DataBase dataBase;
	
	public AlgorithmsHandler()
	{
		dataBase = DataBase.getInstance();
		
		grahamScan = new GrahamScan();	
		grahamScan.initialize();
		
		algorithm1 = new Algorithm1();	
		algorithm1.computeSmallestEnclosingCircle();
		
		algorithm2 = new Algorithm2();
		algorithm2.computeFarthestNeighborVoronoiDiagram();
		
//		algorithm3 = new Algorithm3();
//		algorithm3.computeNearestNeighborVoronoiDiagram();
	}
}
