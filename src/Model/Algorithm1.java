//https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
//https://www.geeksforgeeks.org/java-math-acos-method-examples/
//https://www.geeksforgeeks.org/java-sqrt-method-examples/
//https://www.geeksforgeeks.org/equation-of-circle-when-three-points-on-the-circle-are-given/
//https://qc.edu.hk/math/Advanced%20Level/circle%20given%203%20points.htm

//https://planetcalc.com/8116/
//https://www.geeksforgeeks.org/equation-of-circle-when-three-points-on-the-circle-are-given/
//https://www.had2know.org/academics/circle-through-three-points.html
//https://www.math-only-math.com/circle-passing-through-three-given-points.html#gallery[pageGallery]/0/
//https://qc.edu.hk/math/Advanced%20Level/circle%20given%203%20points.htm
//https://math.stackexchange.com/questions/2836274/3-point-to-circle-and-get-radius
//https://jdmeducational.com/how-to-find-center-radius-of-a-circle-3-methods/

package Model;

import java.lang.Math;

public class Algorithm1 
{
	private DataBase dataBase;
	
	public Algorithm1() 
	{
		dataBase = DataBase.getInstance();		
	}
	
	public void computeSmallestEnclosingCircle()
	{
		boolean finish;
		double maxAngle;
		double myPi2 = Math.PI/2;
		
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
	
	public void computeSmallestEnclosingCircle2()
	{
		boolean finish;
		double maxAngle;
		double myPi2 = Math.PI/2;
		
		if(dataBase.getHashCirclePointsSize() != 1)
		{
			finish = false;
			do
			{
				maxAngle = dataBase.customFindMaxAngle();
				if(maxAngle>myPi2)
				{
					dataBase.customDeleteNodeForCircle();					
				}else
				{
					dataBase.moveToCircleArray();
					System.out.println("The algorithm 1 finished = "+dataBase.getHashCirclePointsSize());
					finish = true;
				}
			}while(!finish);
		}else
		{
			System.out.println("Only 1 point");
		}
	}
}
