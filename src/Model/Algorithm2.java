package Model;

import javafx.geometry.Point2D;

public class Algorithm2 
{
	private DataBase dataBase;
	public Algorithm2()
	{
		dataBase = DataBase.getInstance();
	}
	
	public void computeFarthestNeighborVoronoiDiagram()
	{
		System.out.println("I am the second algorithm!");
		double n = dataBase.getConvexPointsSize();
		int size = dataBase.getConvexPointsSize();
		//I have to make (K,E) ArrayLits for each K, E
		dataBase.makeKandE();
		//for all p in S add u(p) to K;
		dataBase.addAllUpToK();
		
		if(n > 2)
		{
			do
			{
				//find p maximizing radius and angle
				int placeOfP = dataBase.findMaxAngle2();
				Point2D p = dataBase.getConvexPoints2().get(placeOfP);
				Point2D q = dataBase.getConvexPoints2().get((placeOfP + size - 1) % size);
				//c=centre(q, p, next(p)); --> public Point2D getCenter(Point2D p, Point2D q, Point2D r)
				Point2D c = dataBase.getCenter(q, p, dataBase.getConvexPoints2().get((placeOfP + 1) % size));
				//add c to K;
				dataBase.addCtoK(c);
				//add (c, u(p)) and (c, u(q)) to E;
				dataBase.addCandUtoE(c, dataBase.getUp2(p, dataBase.getConvexPoints2().get((placeOfP + 1) % size)));
				dataBase.addCandUtoE(c, dataBase.getUp2(q, p));
				
				//u(q)=c; --> public Point2D getUP(Point2D p, Point2D nextP)
				
				//next(q)=next(p); --> convexPoints
				//before(next(q))=q; --> convexPoints
				n = n-1;
			}while(n == 2);
			//add (u(q), u(next(q))) to E;
//			addCandUtoE(getUp2());
		}else
		{
			if(n == 2) //S={p1, p2}
			{
				Point2D p1 = dataBase.getConvexPoints().get(0);
				Point2D p2 = dataBase.getConvexPoints().get(1);
				
				Point2D u_p1 = dataBase.getUp2(p1, p2);
				Point2D u_p2 = dataBase.getUp2(p2, p1);
				
				//add (u(p1), u(p2)) to E;
				dataBase.addCandUtoE(u_p1, u_p2);
			}
		}
	}
}
