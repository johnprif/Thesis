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
	private DoublyLinkedList myDoublyLinkedList;
	
	public Algorithm1(ArrayList<Point2D> convexPoints) 
	{
		this.convexPoints = new ArrayList<Point2D>(convexPoints);
		movePointsToDoublyLinkedList();
	}
	
	private void movePointsToDoublyLinkedList()
	{
		//check if convexPoints.size()==0
		//check if convexPoints.size()==1
		
		for(int i=0; i<convexPoints.size(); i++)
		{
			myDoublyLinkedList.insertAtLast(convexPoints.get(i));
		}
	}
	
	private void computeSmallestEnclosingCircle()
	{
		boolean finish;
		Node maxPoint;
		
		if(myDoublyLinkedList.getSize() != 1)
		{
			finish = false;
			do
			{
				maxPoint = myDoublyLinkedList.findMaxNode();
				//TO-DO 
				//How to find angle for specific point(paxPoint==p)
				if(myDoublyLinkedList.getAngle(maxPoint.before.data, maxPoint.data, maxPoint.next.data)<=Math.PI/2)
				{
					finish = true;
				}else
				{
					myDoublyLinkedList.deleteAtIndex(myDoublyLinkedList.searchIndexOfNode(maxPoint.data));
				}
			}while(finish);
		}else
		{
			System.out.println("Only 1 point");
		}
	}
	
	
}
