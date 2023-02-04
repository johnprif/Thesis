//https://www.geeksforgeeks.org/linked-list-in-java/
//https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
//http://phrogz.net/angle-between-three-points
//https://www.geeksforgeeks.org/treemap-in-java/
//https://www.javatpoint.com/java-treemap

package Model;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javafx.geometry.Point2D;

public class DataBase 
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> circlePoints;
	private static final DataBase instance = new DataBase();
	
	private HashMap<Point2D, ArrayList<Point2D>> neighbours;
	private TreeMap<Double, Point2D> radiusForEachNode;
	private HashMap<Double, Point2D> existingRadius;
	
	private Point2D currCustom;
	private Point2D prevCustom;
	private Point2D nextCustom;
	private double maxAngleCustom;
	private double maxRadiusCustom;
	
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
		//-----------------------------------------------
		loadMaps();
		//-----------------------------------------------
	}
	
//	----------O(nlog(n))---------------
	private void loadMaps()
	{
		int size = circlePoints.size();
		double radius;
		
		neighbours = new HashMap<Point2D, ArrayList<Point2D>>();
		radiusForEachNode = new TreeMap<>();
		existingRadius = new HashMap<Double, Point2D>();
		
		for (int i = 0; i < size; i++) 
	    {
	        Point2D prev = circlePoints.get((i + size - 1) % size); //O(1)
	        Point2D curr = circlePoints.get(i); //O(1)
	        Point2D next = circlePoints.get((i + 1) % size); //O(1)
	        
	        radius = getRadius(prev, curr, next); //O(1)
	        ArrayList<Point2D> kati = new ArrayList<Point2D>();
	        kati.add(prev);
	        kati.add(next);

	        neighbours.put(curr, kati); //O(1)
	        radiusForEachNode.put(radius, curr); //O(log(n))
	        
	        existingRadius.put(radius, curr);
	    }
	}

//----------O(log(n)) for each calling---------------		
	public double findMaxAngle()
	{
		int size = neighbours.size(); //O(1)
	    
	    if (size <= 2)
	    {
	    	return -1;
	    }
		
		maxRadiusCustom = radiusForEachNode.lastKey(); //O(1)
		currCustom = radiusForEachNode.get(maxRadiusCustom); //O(log(n))
		prevCustom = neighbours.get(currCustom).get(0); //O(1)
		nextCustom = neighbours.get(currCustom).get(1); //O(1)
		maxAngleCustom = getAngle(prevCustom, currCustom, nextCustom); //O(1)
		//---------------------------------------------
//		existingRadius.put(maxRadiusCustom, currCustom);
		//---------------------------------------------
		return maxAngleCustom;
	}		
	
	//----------5*O(log(n)) for each calling---------------
	public void deleteNodeForCircle()
	{	
		ArrayList<Point2D> left = new ArrayList<Point2D>();
		ArrayList<Point2D> right = new ArrayList<Point2D>();
		
		//---I found that has changed
		Point2D leftCurr = neighbours.get(currCustom).get(0);
		Point2D leftPrev = neighbours.get(leftCurr).get(0);
		Point2D leftNext = neighbours.get(leftCurr).get(1);
		
		Point2D rightCurr = neighbours.get(currCustom).get(1); //O(1)
		Point2D rightPrev = neighbours.get(rightCurr).get(0); //O(1)
		Point2D rightNext = neighbours.get(rightCurr).get(1); //O(1)
		
		radiusForEachNode.remove(maxRadiusCustom);  //O(log(n))
		radiusForEachNode.remove(getRadius(leftPrev, leftCurr, leftNext)); //O(log(n))
		radiusForEachNode.remove(getRadius(rightPrev, rightCurr, rightNext)); //O(log(n))
		
		existingRadius.remove(maxRadiusCustom);//O(1)
		existingRadius.remove(getRadius(leftPrev, leftCurr, leftNext)); //O(1)
		existingRadius.remove(getRadius(rightPrev, rightCurr, rightNext)); //O(1))
		
		neighbours.remove(leftCurr); //O(1)
		neighbours.remove(currCustom); //O(1)
		neighbours.remove(rightCurr); //O(1)
				
		left.add(leftPrev); //O(1)
		left.add(rightCurr); //O(1)
		
		right.add(leftCurr); //O(1)
		right.add(rightNext); //O(1)			
		
		neighbours.put(leftCurr, left); //O(1)
		neighbours.put(rightCurr, right); //O(1)
		
		double beforeRadius = getRadius(leftPrev, leftCurr, rightCurr);
		double nextRadius = getRadius(leftCurr, rightCurr, rightNext);
		Point2D currPoint;

		if(!existingRadius.containsKey(beforeRadius)) //O(1)
		{
			radiusForEachNode.put(beforeRadius, leftCurr);  //O(log(n))
			existingRadius.put(beforeRadius, leftCurr);//O(1)
			
		}else
		{
			currPoint = existingRadius.get(beforeRadius);//O(1)
			
			if(getAngle(neighbours.get(leftCurr).get(0), leftCurr, neighbours.get(leftCurr).get(1)) >= getAngle(neighbours.get(currPoint).get(0), currPoint, neighbours.get(currPoint).get(1)))
			{
				radiusForEachNode.put(getRadius(neighbours.get(currPoint).get(0), currPoint, neighbours.get(currPoint).get(1)), leftCurr);  //O(log(n))
				existingRadius.put(getRadius(neighbours.get(currPoint).get(0), currPoint, neighbours.get(currPoint).get(1)), leftCurr);  //O(1)
			}
		}
		if(!existingRadius.containsKey(nextRadius)) //O(1)
		{
			radiusForEachNode.put(nextRadius, rightCurr); //O(log(n))
			existingRadius.put(nextRadius, rightCurr);//O(1)
		}else
		{
			currPoint = existingRadius.get(nextRadius);//O(1)
			
			if(getAngle(neighbours.get(rightCurr).get(0), rightCurr, neighbours.get(rightCurr).get(1)) >= getAngle(neighbours.get(currPoint).get(0), currPoint, neighbours.get(currPoint).get(1)))
			{
				radiusForEachNode.put(getRadius(neighbours.get(currPoint).get(0), currPoint, neighbours.get(currPoint).get(1)), rightCurr);  //O(log(n))
				existingRadius.put(getRadius(neighbours.get(currPoint).get(0), currPoint, neighbours.get(currPoint).get(1)), rightCurr);  //O(1)
			}
		}
	}
	
	public int getHashCirclePointsSize()
	{
		return neighbours.size();
	}
		
	public void moveToCircleArray()
	{
		HashMap<Point2D, Point2D> neighboursTemp = new HashMap<Point2D, Point2D>();
		
		for (Point2D key : neighbours.keySet()) 
		{
			neighboursTemp.put(key, key);
		}
		circlePoints = new ArrayList<Point2D>(neighboursTemp.values());
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
