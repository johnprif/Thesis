//https://www.geeksforgeeks.org/linked-list-in-java/
//https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
//http://phrogz.net/angle-between-three-points
package Model;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javafx.geometry.Point2D;

public class DataBase 
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> circlePoints;
	private static final DataBase instance = new DataBase();
	private int indexOfMaxPoint = 0;
	private int indexOfMaxPoint2 = 0;
	
	private DataBase()
	{
	}
	
	public static DataBase getInstance()
	{
		return instance;
	}
	
	public ArrayList<Point2D> getAllPoints()
	{
		return allPoints;
	}
	
	public ArrayList<Point2D> getConvexPoints()
	{
		return convexPoints;
	}
	
	public ArrayList<Point2D> getCirclePoints()
	{
		return circlePoints;
	}
	
	public void setAllPoints(ArrayList<Point2D> allPoints)
	{
		this.allPoints = new ArrayList<Point2D>(allPoints);
	}
	
	public void setConvexPoints(ArrayList<Point2D> convexPoints)
	{
		this.convexPoints = new ArrayList<Point2D>(convexPoints);
	}
	
	public void setCirclePoints(ArrayList<Point2D> circlePoints)
	{
		this.circlePoints = new ArrayList<Point2D>(circlePoints);
	}
	
	public int getAllPointsSize()
	{
		return allPoints.size();
	}
	
	public int getConvexPointsSize()
	{
		return convexPoints.size();
	}
	
	public int getCirclePointsSize()
	{
		return circlePoints.size();
	}
	
	public void deleteMaxNodeForVoronoi()
	{
		convexPoints.remove(indexOfMaxPoint2);
	}
	
	public void deleteMaxNodeForCircle()
	{
		circlePoints.remove(indexOfMaxPoint);
	}
	
	public void displayAllPoints()
	{
		System.out.println("The ArrayList '"+getAllPointsSize()+"' All Points is --> ");
		for(int i=0; i<allPoints.size(); i++)
		{
			System.out.println(" "+allPoints.get(i));
		}
		System.out.println("");
	}
	
	public void displayConvexPoints()
	{
		System.out.println("The ArrayList of '"+getConvexPointsSize()+"' Convex Points is --> ");
		for(int i=0; i<convexPoints.size(); i++)
		{
			System.out.println(" "+convexPoints.get(i));
		}
		System.out.println("");
	}
	
	public void displayCirclePoints()
	{
		System.out.println("The ArrayList of '"+getCirclePointsSize()+"' Circle Points is --> ");
		for(int i=0; i<circlePoints.size(); i++)
		{
			System.out.println(" "+circlePoints.get(i));
		}
		System.out.println("");
	}
	
	public Ellipse2D findCircle()
	{
		int n = circlePoints.size();
		Ellipse2D circle;
		Point2D point1 = circlePoints.get(0);
		Point2D point2 = circlePoints.get(1);
		Point2D point3 = null;
		
		if (n == 3) 
		{
			point3 = circlePoints.get(2);
		}
		
		circle = new Ellipse2D.Double(getCenter(point1, point2, point3).getX() - getRadius(point1, point2, point3), getCenter(point1, point2, point3).getY() - getRadius(point1, point2, point3), getRadius(point1, point2, point3) * 2, getRadius(point1, point2, point3) * 2);
		return circle;
	}
	
	public double findMaxNodeforCircle() 
	{
	    int size = circlePoints.size();
	    
	    if (size <= 2)
	    {
	    	return -1;
	    }
	    
	    double maxRadius = 0.0;
	    double maxAngle = 0.0;
	    
	    for (int i = 0; i < size; i++) 
	    {
	        Point2D prev = circlePoints.get((i + size - 1) % size);
	        Point2D curr = circlePoints.get(i);
	        Point2D next = circlePoints.get((i + 1) % size);
	        
	        double radius = getRadius(prev, curr, next);
	        double angle = getAngle(prev, curr, next);
	        
	        if (radius > maxRadius || (radius == maxRadius && angle >= maxAngle)) 
	        {
	        	indexOfMaxPoint = i;
	            maxRadius = radius;
	            maxAngle = angle;
	        }
	    }
	    
	    return maxAngle;
	}
		
	public double findMaxNodeforVoronoi() 
	{
	    int size = convexPoints.size();
	    if (size <= 2) return -1;
	    
	    double maxRadius = 0.0;
	    double maxAngle = 0.0;
	    
	    for (int i = 0; i < size; i++) {
	        Point2D prev = convexPoints.get((i + size - 1) % size);
	        Point2D curr = convexPoints.get(i);
	        Point2D next = convexPoints.get((i + 1) % size);
	        
	        double radius = getRadius(prev, curr, next);
	        double angle = getAngle(prev, curr, next);
	        
	        if (radius > maxRadius || (radius == maxRadius && angle >= maxAngle)) {
	        	indexOfMaxPoint2 = i;
	            maxRadius = radius;
	            maxAngle = angle;
	        }
	    }
	    
	    return maxAngle;
	}
	
	public double getRadius(Point2D p, Point2D q, Point2D r) 
	{
	    double x1 = p.getX();
	    double y1 = p.getY();
	    double x2 = q.getX();
	    double y2 = q.getY();
	    double x3;
	    double y3;

	    double R = 0;

	    if(r == null)
	    {
	    	R = p.distance(q) / 2;
	    	return R;	
	    }
	    
	    if ((!p.equals(q)) && (!q.equals(r)) && (!p.equals(r))) 
	    {
	    	//----------------------
	    	x3 = r.getX();
		    y3 = r.getY();
	    	//----------------------
	        double x12 = x1 - x2;
	        double x13 = x1 - x3;

	        double y12 = y1 - y2;
	        double y13 = y1 - y3;

	        double y31 = y3 - y1;
	        double y21 = y2 - y1;

	        double x31 = x3 - x1;
	        double x21 = x2 - x1;

	        // x1^2 - x3^2
	        double sx13 = x1 * x1 - x3 * x3;

	        // y1^2 - y3^2
	        double sy13 = y1 * y1 - y3 * y3;

	        double sx21 = x2 * x2 - x1 * x1;

	        double sy21 = y2 * y2 - y1 * y1;

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

	        double c = -x1 * x1 - y1 * y1 - 2 * g * x1 - 2 * f * y1;

	        // eqn of circle be x^2 + y^2 + 2*g*x + 2*f*y + c = 0
	        // where centre is (h = -g, k = -f) and radius r
	        // as r^2 = h^2 + k^2 - c
	        double h = -g;
	        double k = -f;
	        double sqr_of_r = h * h + k * k - c;

	        // r is the radius
	        R = Math.sqrt(sqr_of_r);
	    }
	    return R;
	}
	
	public Point2D getCenter(Point2D p, Point2D q, Point2D r) 
	{
	    double x1 = p.getX();
	    double y1 = p.getY();
	    double x2 = q.getX();
	    double y2 = q.getY();
	    double x3;
	    double y3;

	    double R = 0;

	    if(r == null)
	    {
	    	double centerX = (x1 + x2) / 2;
	        double centerY = (y1 + y2) / 2;
	        return new Point2D(centerX, centerY);
	    }
	    
	    if ((!p.equals(q)) && (!q.equals(r)) && (!p.equals(r))) 
	    {
	    	//----------------------
	    	x3 = r.getX();
		    y3 = r.getY();
	    	//----------------------
	        double x12 = x1 - x2;
	        double x13 = x1 - x3;

	        double y12 = y1 - y2;
	        double y13 = y1 - y3;

	        double y31 = y3 - y1;
	        double y21 = y2 - y1;

	        double x31 = x3 - x1;
	        double x21 = x2 - x1;

	        // x1^2 - x3^2
	        double sx13 = x1 * x1 - x3 * x3;

	        // y1^2 - y3^2
	        double sy13 = y1 * y1 - y3 * y3;

	        double sx21 = x2 * x2 - x1 * x1;

	        double sy21 = y2 * y2 - y1 * y1;

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

	        double c = -x1 * x1 - y1 * y1 - 2 * g * x1 - 2 * f * y1;

	        // eqn of circle be x^2 + y^2 + 2*g*x + 2*f*y + c = 0
	        // where centre is (h = -g, k = -f) and radius r
	        // as r^2 = h^2 + k^2 - c
	        double h = -g;
	        double k = -f;
	        double sqr_of_r = h * h + k * k - c;

	        // r is the radius
	        R = Math.sqrt(sqr_of_r);
	        return new Point2D(h,k);
	    }
	    return null;
	}
	
	private double getAngle(Point2D p, Point2D q, Point2D r) 
	{
		double a = (q.getX() - p.getX()) * (q.getX() - p.getX()) + (q.getY() - p.getY()) * (q.getY() - p.getY());
		double b = (q.getX() - r.getX()) * (q.getX() - r.getX()) + (q.getY() - r.getY()) * (q.getY() - r.getY());
		double c = (r.getX() - p.getX()) * (r.getX() - p.getX()) + (r.getY() - p.getY()) * (r.getY() - p.getY());
		return Math.acos((a + b - c) / Math.sqrt(4 * a * b));
	}
}
