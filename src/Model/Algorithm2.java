package Model;

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
		
		if(n > 2)
		{
			do
			{
				//find p maximizing radius and angle
				//q=before(p);
				//c=centre(q, p, next(p));
				//add c to K;
				//add (c, u(p)) and (c, u(q)) to E;
				//u(q)=c;
				//next(q)=next(p);
				//before(next(q))=q;
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
