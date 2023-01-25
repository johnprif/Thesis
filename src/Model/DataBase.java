//https://www.geeksforgeeks.org/linked-list-in-java/
//https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
//http://phrogz.net/angle-between-three-points
package Model;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Model.DoublyLinkedList.Node;
import javafx.geometry.Point2D;
import javafx.scene.shape.Ellipse;

public class DataBase 
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> circlePoints;
	// public instance initialized when loading the class
	private static final DataBase instance = new DataBase();
	private int indexOfMaxPoint = 0;
	private int indexOfMaxPoint2 = 0;
	
	private DataBase()
	{
	    // private constructor
//		dll = new LinkedList<Point2D>();
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
		System.out.println("The ArrayList All Points is --> ");
		for(int i=0; i<allPoints.size(); i++)
		{
			System.out.println(" "+allPoints.get(i));
		}
		System.out.println("");
	}
	
	public void displayConvexPoints()
	{
		System.out.println("The ArrayList of Convex Points is --> ");
		for(int i=0; i<convexPoints.size(); i++)
		{
			System.out.println(" "+convexPoints.get(i));
		}
		System.out.println("");
	}
	
	public void displayCirclePoints()
	{
		System.out.println("The ArrayList of Circle Points is --> ");
		for(int i=0; i<circlePoints.size(); i++)
		{
			System.out.println(" "+circlePoints.get(i));
		}
		System.out.println("");
	}
	
	public Ellipse2D findCircle()
	{
		Point2D point1;
		Point2D point2;
		Point2D point3;
		if (circlePoints.size() == 3)
		{
			point1 = circlePoints.get(0);
			point2 = circlePoints.get(1);
			point3 = circlePoints.get(2);
		}else
		{
			point1 = circlePoints.get(3);
			point2 = circlePoints.get(1);
			point3 = circlePoints.get(2);
		}
		
		// Assume that point1, point2, and point3 are Point2D objects
//		double x1 = point1.getX();
//		double y1 = point1.getY();
//		double x2 = point2.getX();
//		double y2 = point2.getY();
//		double x3 = point3.getX();
//		double y3 = point3.getY();
//
//		double a = (x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2) / 2;
//		double b = (x2 * x2 + y2 * y2 - x3 * x3 - y3 * y3) / 2;
//		double c = (x1 - x2) / (y2 - y1);
//		double d = (x2 - x3) / (y3 - y2);
//		double e = (a - b) / (d - c);
//		double f = a + c * e;
//
//		double centerX = e / 2;
//		double centerY = f / 2;
//		double radius = Math.sqrt(centerX * centerX + centerY * centerY);
		Ellipse2D circle = new Ellipse2D.Double(getCenter(point1, point2, point3).getX() - getRadius(point1, point2, point3), getCenter(point1, point2, point3).getY() - getRadius(point1, point2, point3), getRadius(point1, point2, point3) * 2, getRadius(point1, point2, point3) * 2);
		return circle;
	}
	
	//----------TEST--------------------
	public Ellipse2D findCircle2(List<Point2D> points) {
        int n = points.size();
        double[][] A = new double[n][3];
        double[] b = new double[n];

        for (int i = 0; i < n; i++) {
            Point2D point = points.get(i);
            A[i][0] = point.getX();
            A[i][1] = point.getY();
            A[i][2] = 1;
            b[i] = point.getX() * point.getX() + point.getY() * point.getY();
        }

        double[] x = new double[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                x[i] += A[j][i] * b[j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < n; k++) {
                    x[i] -= A[k][i] * A[k][j] * x[j];
                }
            }
        }

        double centerX = x[0] / 2;
        double centerY = x[1] / 2;
        double radius = Math.sqrt(x[2] + centerX * centerX + centerY * centerY);
        return new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
	
	 public Ellipse2D findCircle3(List<Point2D> points) {
	        int n = points.size();
	        if (n < 3) {
	            throw new IllegalArgumentException("At least 3 points are required to form a circle");
	        }

	        Point2D A, B, C, D, E;
	        A = B = C = D = E = new Point2D(0,0);

	        if (n == 3) {
	            A = points.get(0);
	            B = points.get(1);
	            C = points.get(2);
	        } else if (n == 4) {
	            A = points.get(0);
	            B = points.get(1);
	            C = points.get(2);
	            D = points.get(3);
	        } else if (n >= 5) {
	            A = points.get(0);
	            B = points.get(1);
	            C = points.get(2);
	            D = points.get(3);
	            E = points.get(4);
	        }
	        double yDelta_a = B.getY() - A.getY();
	        double xDelta_a = B.getX() - A.getX();
	        double yDelta_b = C.getY() - B.getY();
	        double xDelta_b = C.getX() - B.getX();

	        double aSlope = yDelta_a / xDelta_a;
	        double bSlope = yDelta_b / xDelta_b;

	        double centerX = (aSlope * bSlope * (A.getY() - C.getY()) + bSlope * (A.getX() + B.getX()) - aSlope * (B.getX() + C.getX())) / (2 * (bSlope - aSlope));
	        double centerY = -1 * (centerX - (A.getX() + B.getX()) / 2) / aSlope + (A.getY() + B.getY()) / 2;
	        Point2D center = new Point2D(centerX, centerY);
	        double radius = center.distance(A);
	        return new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
	    }
	 
	 public Ellipse2D findCircle4(List<Point2D> points) {
		    int n = points.size();
		    if (n < 3) {
		        throw new IllegalArgumentException("At least 3 points are required to form a circle");
		    }

		    // Sum of x, y and xy, x^2 and y^2
		    double Sx = 0, Sy = 0, Sxy = 0, Sx2 = 0, Sy2 = 0;
		    for (Point2D point : points) {
		        Sx += point.getX();
		        Sy += point.getY();
		        Sxy += point.getX() * point.getY();
		        Sx2 += point.getX() * point.getX();
		        Sy2 += point.getY() * point.getY();
		    }
		    // Mean of x and y
		    double x_bar = Sx / n;
		    double y_bar = Sy / n;

		    // Linear regression coefficients
		    double a = (n * Sxy - Sx * Sy) / (n * Sx2 - Sx * Sx);
		    double b = y_bar - a * x_bar;

		    // Center of the circle
		    double centerX = x_bar;
		    double centerY = a * centerX + b;
		    Point2D center = new Point2D(centerX, centerY);

		    // Radius of the circle
		    double radius = 0;
		    for (Point2D point : points) {
		        radius += center.distance(point);
		    }
		    radius /= n;

		    return new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
		}

	 public Ellipse2D findCircle5(List<Point2D> points) {
		    int n = points.size();
		    if (n < 2) {
		        throw new IllegalArgumentException("At least 2 points are required to form a circle");
		    }
		    if (n == 2) {
		        Point2D p1 = points.get(0);
		        Point2D p2 = points.get(1);
		        double centerX = (p1.getX() + p2.getX()) / 2.0;
		        double centerY = (p1.getY() + p2.getY()) / 2.0;
		        Point2D center = new Point2D(centerX, centerY);
		        double radius = center.distance(p1);
		        return new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
		    } else if (n == 3) {
		        Point2D A, B, C;
		        A = points.get(0);
		        B = points.get(1);
		        C = points.get(2);

		        double yDelta_a = B.getY() - A.getY();
		        double xDelta_a = B.getX() - A.getX();
		        double yDelta_b = C.getY() - B.getY();
		        double xDelta_b = C.getX() - B.getX();

		        double aSlope = yDelta_a / xDelta_a;
		        double bSlope = yDelta_b / xDelta_b;

		        double centerX = (aSlope * bSlope * (A.getY() - C.getY()) + bSlope * (A.getX() + B.getX()) - aSlope * (B.getX() + C.getX())) / (2 * (bSlope - aSlope));
		        double centerY = -1 * (centerX - (A.getX() + B.getX()) / 2) / aSlope + (A.getY() + B.getY()) / 2;

		        Point2D center = new Point2D(centerX, centerY);
		        double radius = center.distance(A);
		        return new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
		    } else {
		        // for 4 or more points you can use other algorithms like "gift wrapping" or "Melkman's algorithm"
		    }
		}

	//----------------END TEST-------------------
	
	
	public double findMaxNodeforCircle() 
	{
	    int size = circlePoints.size();
	    if (size <= 2) return -1;
	    
	    double maxRadius = 0.0;
	    double maxAngle = 0.0;
	    
	    for (int i = 0; i < size; i++) {
	        Point2D prev = circlePoints.get((i + size - 1) % size);
	        Point2D curr = circlePoints.get(i);
	        Point2D next = circlePoints.get((i + 1) % size);
	        
	        double radius = getRadius(prev, curr, next);
	        double angle = getAngle(prev, curr, next);
	        
	        if (radius > maxRadius || (radius == maxRadius && angle >= maxAngle)) {
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
	    double x3 = r.getX();
	    double y3 = r.getY();

	    double R = 0;

	    if ((!p.equals(q)) && (!q.equals(r)) && (!p.equals(r))) 
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

	    return Math.round(R * 1000.0) / 1000.0;
	}
	
	public Point2D getCenter(Point2D p, Point2D q, Point2D r) 
	{
	    double x1 = p.getX();
	    double y1 = p.getY();
	    double x2 = q.getX();
	    double y2 = q.getY();
	    double x3 = r.getX();
	    double y3 = r.getY();

	    double R = 0;

	    if ((!p.equals(q)) && (!q.equals(r)) && (!p.equals(r))) 
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
//	    return new Point2D(h,k);
	}
	
	private double getAngle(Point2D p, Point2D q, Point2D r) 
	{
		double a = (q.getX() - p.getX()) * (q.getX() - p.getX()) + (q.getY() - p.getY()) * (q.getY() - p.getY());
		double b = (q.getX() - r.getX()) * (q.getX() - r.getX()) + (q.getY() - r.getY()) * (q.getY() - r.getY());
		double c = (r.getX() - p.getX()) * (r.getX() - p.getX()) + (r.getY() - p.getY()) * (r.getY() - p.getY());
		return Math.round(Math.acos((a + b - c) / Math.sqrt(4 * a * b)) * 1000.0) / 1000.0;
	}
}
