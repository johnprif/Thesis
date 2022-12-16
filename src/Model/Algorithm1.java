//https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
//https://www.geeksforgeeks.org/java-math-acos-method-examples/
//https://www.geeksforgeeks.org/java-sqrt-method-examples/
package Model;

import java.util.ArrayList;
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
	
	private double getRadius(Point2D p, Point2D q, Point2D r)
	{
		if((p!=q) && (q!=r) && (p!=r))
		{
			
		}
	}
	
	private double getAngle(Point2D p, Point2D q, Point2D r)
	{
		Point2D pq = new Point2D(p.getX()-q.getX(), p.getY()-q.getY());
		Point2D qr = new Point2D(q.getX()-r.getX(), q.getY()-r.getY());
		double pq_qr = pq.getX()*qr.getX()+pq.getY()*qr.getY();
		double _pq_qr_ = Math.sqrt(pq.getX()*pq.getX()+pq.getY()*pq.getY()) * Math.sqrt(qr.getX()*qr.getX()+qr.getY()*qr.getY());		
		double angle = Math.acos(pq_qr/_pq_qr_);
		
		return angle;
	}
	
	private Point2D findMax()
	{
		return null;
	}
}
