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

import java.text.*;
import java.util.ArrayList;
import java.util.LinkedList;

import Model.DoublyLinkedList.Node;
import javafx.geometry.Point2D;
import java.lang.Math;
public class Algorithm1 
{
	private DataBase dataBase;
	
	public Algorithm1() 
	{
		dataBase = DataBase.getInstance();
		computeSmallestEnclosingCircle();
	}
	
	private void computeSmallestEnclosingCircle()
	{
		boolean finish;
		double maxAngle;
		double myPi2 = Math.round(Math.PI/2*1000.0)/1000.0;
		if(dataBase.getCirclePointsSize() != 1)
		{
			finish = false;
			do
			{
				maxAngle = dataBase.findMaxNode();
				if(maxAngle>myPi2)
				{
					dataBase.deleteMaxNode();					
					System.out.println("The length of DLL is = "+dataBase.getCirclePointsSize());
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
//		myDoublyLinkedList2.displayFirstToLast();
		System.out.print("----------------------------------------------------------------------\n");
		System.out.println("The final size is = "+dataBase.getCirclePointsSize());
	}
}
