package Model;

public class Algorithm2 
{
	private DataBase dataBase;
	public Algorithm2()
	{
		dataBase = DataBase.getInstance();
	}
	
	public void computeVoronoiDiagram()
	{
		System.out.println("I am the second algorithm!");
		boolean finish;
		double maxAngle;
		double myPi2 = Math.round(Math.PI/2*1000.0)/1000.0;
		
		if(dataBase.getCirclePointsSize() != 1)
		{
			finish = false;
			do
			{
				maxAngle = dataBase.findMaxNodeforCircle();
				if(maxAngle>myPi2)
				{
					dataBase.deleteMaxNodeForCircle();					
				}else
				{
					System.out.println("The algorithm 1 finished = "+dataBase.getCirclePointsSize());
					finish = true;
				}
			}while(!finish);
		}else
		{
			System.out.println("Only 1 point");
		}
	}
}
