//https://www.geeksforgeeks.org/linked-list-in-java/
//https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import Model.DoublyLinkedList.Node;
import javafx.geometry.Point2D;

public class DoublyLinkedList2 
{
//	private LinkedList<Point2D> dll;
	private ArrayList<Point2D> convexPoints;
	// public instance initialized when loading the class
	private static final DoublyLinkedList2 instance = new DoublyLinkedList2();
	private int indexOfMaxPoint = 0;
	
	private DoublyLinkedList2()
	{
	    // private constructor
//		dll = new LinkedList<Point2D>();
	}
	public static DoublyLinkedList2 getInstance()
	{
		return instance;
	}
	
	public void setPoints(ArrayList<Point2D> convexPoints)
	{
		this.convexPoints = new ArrayList<Point2D>(convexPoints);
	}
	
	public int getSize()
	{
		return convexPoints.size();
	}
	
	public void deleteMaxNode()
	{
		convexPoints.remove(indexOfMaxPoint);
	}
	
	public void displayFirstToLast()
	{
		System.out.println("The ArrayList is --> ");
		for(int i=0; i<convexPoints.size(); i++)
		{
			System.out.println(" "+convexPoints.get(i));
		}
		System.out.println("");
	}
	
	//it must be implement here?
		//serial search, multiplexity O(n)
		public double findMaxNode()
		{
			double maxRadius = 0.0;
			double maxAngle = 0.0;
			double currentRadius = 0.0;
			double currentAngle = 0.0;
			int convexPointsLenght = convexPoints.size();
			
			if(convexPoints.size()==2)
			{
				return -1;
			}else //size at least = 3
			{
				for(int i=1; i<convexPoints.size()-1; i++)
				{
				
					currentRadius = getRadius(convexPoints.get(i-1), convexPoints.get(i), convexPoints.get(i+1));
					currentAngle = getAngle(convexPoints.get(i-1), convexPoints.get(i), convexPoints.get(i+1));
					System.out.println("convexPoints.get(i-1), convexPoints.get(i), convexPoints.get(i+1)"+convexPoints.get(i-1)+ convexPoints.get(i)+ convexPoints.get(i+1));
					
					if(currentRadius>maxRadius)
					{
						indexOfMaxPoint = i;
						maxRadius = currentRadius;
						maxAngle = currentAngle;
					}else if(currentRadius == maxRadius)
					{
						if(currentAngle >= maxAngle)
						{
							indexOfMaxPoint = i;
							maxAngle = currentAngle;
							maxRadius = currentRadius;
						}
					}
				}
				//----------------------------------
				currentRadius = getRadius(convexPoints.get(convexPointsLenght-2), convexPoints.get(convexPointsLenght-1), convexPoints.get(0));
				currentAngle = getAngle(convexPoints.get(convexPointsLenght-2), convexPoints.get(convexPointsLenght-1), convexPoints.get(0));
//				System.out.println("convexPoints.get(i-1), convexPoints.get(i), convexPoints.get(i+1)"+convexPoints.get(i-1)+ convexPoints.get(i)+ convexPoints.get(i+1));
				
				if(currentRadius>maxRadius)
				{
					indexOfMaxPoint = convexPointsLenght-1;
					maxRadius = currentRadius;
					maxAngle = currentAngle;
				}else if(currentRadius == maxRadius)
				{
					if(currentAngle >= maxAngle)
					{
						indexOfMaxPoint = convexPointsLenght-1;
						maxAngle = currentAngle;
						maxRadius = currentRadius;
					}
				}
				
				currentRadius = getRadius(convexPoints.get(convexPointsLenght-1), convexPoints.get(0), convexPoints.get(1));
				currentAngle = getAngle(convexPoints.get(convexPointsLenght-1), convexPoints.get(0), convexPoints.get(1));
				//System.out.println("convexPoints.get(i-1), convexPoints.get(i), convexPoints.get(i+1)"+convexPoints.get(i-1)+ convexPoints.get(i)+ convexPoints.get(i+1));
				
				if(currentRadius>maxRadius)
				{
					indexOfMaxPoint = 0;
					maxRadius = currentRadius;
					maxAngle = currentAngle;
				}else if(currentRadius == maxRadius)
				{
					if(currentAngle >= maxAngle)
					{
						indexOfMaxPoint = 0;
						maxAngle = currentAngle;
						maxRadius = currentRadius;
					}
				}
				
				//------------
			}
			System.out.println("FindMaxAngle == "+maxAngle);
			return maxAngle;
		}
	
	public double getRadius(Point2D p, Point2D q, Point2D r)
	{
//		System.out.println("\n\nHello\n\n");
		double x1 = p.getX();
		double y1 = p.getY();
		double x2 = q.getX();
		double y2 = q.getY();
		double x3 = r.getX();
		double y3 = r.getY();
		
		double R = 0;
		
		if((p!=q) && (q!=r) && (p!=r))
		{
			double x12 = x1 - x2;
			double x13 = x1 - x3;
		 
			double y12 = y1 - y2;
			double y13 = y1 - y3;
		 
			double y31 = y3 - y1;
			double y21 = y2 - y1;
		 
			double x31 = x3 - x1;
			double x21 = x2 - x1;
		 
		    // x1^2 - x3^2
			double sx13 = (Math.pow(x1, 2) - Math.pow(x3, 2));
		 
		    // y1^2 - y3^2
			double sy13 = (Math.pow(y1, 2) - Math.pow(y3, 2));
		 
			double sx21 = (Math.pow(x2, 2) - Math.pow(x1, 2));
		                     
			double sy21 = (Math.pow(y2, 2) - Math.pow(y1, 2));
		 
			double f = ((sx13) * (x12)
		            + (sy13) * (x12)
		            + (sx21) * (x13)
		            + (sy21) * (x13))
		            / (2 * ((y31) * (x12) - (y21) * (x13)));
			double g = ((sx13) * (y12)
		            + (sy13) * (y12)
		            + (sx21) * (y13)
		            + (sy21) * (y13))
		            / (2 * ((x31) * (y12) - (x21) * (y13)));
		 
			double c = -Math.pow(x1, 2) - Math.pow(y1, 2) -
		                                2 * g * x1 - 2 * f * y1;
		 
		    // eqn of circle be x^2 + y^2 + 2*g*x + 2*f*y + c = 0
		    // where centre is (h = -g, k = -f) and radius r
		    // as r^2 = h^2 + k^2 - c
			double h = -g;
		    double k = -f;
		    double sqr_of_r = h * h + k * k - c;
		 
		    // r is the radius
		    R = Math.sqrt(sqr_of_r);
//		    DecimalFormat df = new DecimalFormat("#.#####");
//		    System.out.println("Centre = (" + h + "," + k + ")");
//		    System.out.println("Radius = " + df.format(R));
		}
		
		return Math.round(R*1000.0)/1000.0;
	}
	
	public double getAngle(Point2D p, Point2D q, Point2D r)
	{
		Point2D pq = new Point2D(p.getX()-q.getX(), p.getY()-q.getY());
		Point2D qr = new Point2D(q.getX()-r.getX(), q.getY()-r.getY());
		double pq_qr = pq.getX()*qr.getX()+pq.getY()*qr.getY();
//		double _pq_qr_ = Math.sqrt(pq.getX()*pq.getX()+pq.getY()*pq.getY()) * Math.sqrt(qr.getX()*qr.getX()+qr.getY()*qr.getY());		
		double _pq_qr_ = Math.sqrt(Math.pow(pq.getX(),2)+Math.pow(pq.getY(),2)) * Math.sqrt(Math.pow(qr.getX(),2)+Math.pow(qr.getY(),2));	
		double angle = Math.acos(pq_qr/_pq_qr_);
		System.out.println("The angle is = "+Math.round(angle*1000.0)/1000.0);
		return Math.round(angle*1000.0)/1000.0;
	}
}
