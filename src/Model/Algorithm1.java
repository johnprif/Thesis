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
	private ArrayList<Point2D> convexPoints;
	private DoublyLinkedList2 myDoublyLinkedList2;
	
	public Algorithm1(ArrayList<Point2D> convexPoints) 
	{
		this.convexPoints = new ArrayList<Point2D>(convexPoints);
		myDoublyLinkedList2 = DoublyLinkedList2.getInstance();
		myDoublyLinkedList2.setPoints(this.convexPoints);
//		movePointsToDoublyLinkedList();
		computeSmallestEnclosingCircle();
	}
	
	private void movePointsToDoublyLinkedList()
	{
		//check if convexPoints.size()==0
		//check if convexPoints.size()==1
		
		for(int i=0; i<convexPoints.size(); i++)
		{
			myDoublyLinkedList2.insertAtLast(convexPoints.get(i));
		}
		System.out.print("The size of initial DLL is = "+myDoublyLinkedList2.getSize()+"\n");
		myDoublyLinkedList2.displayFirstToLast();
		System.out.print("----------------------------------------------------------------------\n");
	}
	
	private void computeSmallestEnclosingCircle()
	{
		boolean finish;
		double maxAngle;
		double myPi2 = Math.round(Math.PI/2*1000.0)/1000.0;
		System.out.println("myPi2 = "+myPi2);
		if(myDoublyLinkedList2.getSize() != 1)
		{
			finish = false;
			do
			{
				maxAngle = myDoublyLinkedList2.findMaxNode();
				System.out.println("maxAngle = "+maxAngle);
				if(maxAngle>myPi2)
				{
					myDoublyLinkedList2.deleteMaxNode();					
					System.out.println("The length of DLL is = "+myDoublyLinkedList2.getSize());
				}else
				{
					System.out.println("The algorithm 1 finished = "+myDoublyLinkedList2.getSize());
					finish = true;
				}
			}while(!finish);
		}else
		{
			System.out.println("Only 1 point");
		}
//		System.out.print("The size of latest DLL is = "+myDoublyLinkedList2.getSize()+"\n");
//		myDoublyLinkedList2.displayFirstToLast();
		System.out.print("----------------------------------------------------------------------\n");
		System.out.println("The final size is = "+myDoublyLinkedList2.getSize());
	}
	
	
}
