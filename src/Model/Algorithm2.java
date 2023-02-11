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
		double n = dataBase.getCirclePointsSize();
		//I have to make (K,E) ArrayLits for each K, E
		if(n > 2)
		{
			do
			{
				//find p maximizing radius and angle
				//q=before(p); --> convexPoints
				//c=centre(q, p, next(p)); --> public Point2D getCenter(Point2D p, Point2D q, Point2D r)
				//add c to K;
				//add (c, u(p)) and (c, u(q)) to E;
				//u(q)=c; --> public Point2D getUP(Point2D p, Point2D nextP)
				//next(q)=next(p); --> convexPoints
				//before(next(q))=q; --> convexPoints
				n = n-1;
			}while(n == 2);
			//add (u(q), u(next(q))) to E;
		}else
		{
			if(n == 2) //S={p1, p2}
			{
				//add (u(p1), u(p2)) to E;
			}
		}
	}
}
