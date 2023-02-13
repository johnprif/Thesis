package Model;

import javafx.geometry.Point2D;

public class FarthestNeighborVoronoiAlgorithm2 
{
	private DataBase dataBase;
	public FarthestNeighborVoronoiAlgorithm2()
	{
		dataBase = DataBase.getInstance();
	}
	
	public void computeFarthestNeighborVoronoiDiagram()
	{
		System.out.println("I am the second algorithm!");
		int n = dataBase.getConvexPointsSize();
		//I have to make (K,E) ArrayLits for each K, E
		dataBase.makeKandE();
		//for all p in S add u(p) to K;
		dataBase.addAllUpToK();
		Point2D  before_p;
		Point2D  p;
		Point2D  next_p;
		Point2D c;
		
		if(n > 2)
		{
			System.out.println("Algorithm 2 started with = " + n);
			do
			{
				//find p maximizing radius and angle
				p = dataBase.findMaxP2();
				before_p = dataBase.getPrev();				
				next_p = dataBase.getNext();
				c = dataBase.getCenter(before_p, p, next_p);
				dataBase.addCtoK(c);
				dataBase.addCandUtoE(c, dataBase.getUp(p));
				dataBase.addCandUtoE(c, dataBase.getUp(before_p));
				//u(q)=c;
				dataBase.deleteMaxP2();
				n = n-1;
			}while(n != 2);
//			dataBase.addCandUtoE(dataBase.getUp2(before_p), dataBase.getUp2(next_p));
			dataBase.addCandUtoE(c, dataBase.getUp(next_p));			
		}else
		{
			System.out.println("Algorithm 2 started with = " + n);
			if(n == 2) //S={p1, p2}
			{
				Point2D p1 = dataBase.getConvexPoints().get(0);
				Point2D p2 = dataBase.getConvexPoints().get(1);
				
				Point2D u_p1 = dataBase.getUp(p1);
				Point2D u_p2 = dataBase.getUp(p2);
				
				//add (u(p1), u(p2)) to E;
				dataBase.addCandUtoE(u_p1, u_p2);
			}
		}
		System.out.println("Algorithm 2 finished!");
	}
}
