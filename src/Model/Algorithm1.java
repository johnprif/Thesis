//https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points

package Model;

import java.util.ArrayList;
import javafx.geometry.Point2D;

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
		Point2D maxPoint;
		
		if(myDoublyLinkedList.getSize() != 1)
		{
			finish = false;
			do
			{
				maxPoint = findMax();
				if()
			}while(finish);
		}else
		{
			System.out.println("Only 1 point");
		}
	}
	
	private Point2D findMax()
	{
		return null;
	}
}
