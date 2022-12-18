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
		double x1 = p.getX();
		double y1 = p.getY();
		double x2 = q.getX();
		double y2 = q.getY();
		double x3 = r.getX();
		double y3 = r.getY();
		
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
			double sx13 = (int)(Math.pow(x1, 2) - Math.pow(x3, 2));
		 
		    // y1^2 - y3^2
			double sy13 = (int)(Math.pow(y1, 2) - Math.pow(y3, 2));
		 
			double sx21 = (int)(Math.pow(x2, 2) - Math.pow(x1, 2));
		                     
			double sy21 = (int)(Math.pow(y2, 2) - Math.pow(y1, 2));
		 
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
		 
			double c = -(int)Math.pow(x1, 2) - (int)Math.pow(y1, 2) -
		                                2 * g * x1 - 2 * f * y1;
		 
		    // eqn of circle be x^2 + y^2 + 2*g*x + 2*f*y + c = 0
		    // where centre is (h = -g, k = -f) and radius r
		    // as r^2 = h^2 + k^2 - c
			double h = -g;
		    double k = -f;
		    double sqr_of_r = h * h + k * k - c;
		 
		    // r is the radius
		    double R = Math.sqrt(sqr_of_r);
		    DecimalFormat df = new DecimalFormat("#.#####");
		    System.out.println("Centre = (" + h + "," + k + ")");
		    System.out.println("Radius = " + df.format(R));
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
