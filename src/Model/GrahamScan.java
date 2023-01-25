//https://www.geeksforgeeks.org/convex-hull-using-graham-scan/
//https://iq.opengenus.org/graham-scan-convex-hull/
//https://www.tutorialspoint.com/Graham-Scan-Algorithm
//https://algorithmtutor.com/Computational-Geometry/Convex-Hull-Algorithms-Graham-Scan/
//https://blog.devgenius.io/grahams-scan-visually-explained-be54b712e2ba
//https://www.geeksforgeeks.org/stack-class-in-java/
//https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Stack.html
//https://stackabuse.com/quicksort-in-java/

//copy this implementation
//https://github.com/dochvam/GrahamScan
//Sort of arrayList is implemented with merge sort witch is far quicker than o(nlogn)
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import javafx.geometry.Point2D;

public class GrahamScan 
{
	private static Point2D start;
	
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexHullPoints;
	private Stack<Point2D> stack;
	private DataBase dataBase;
	
	public GrahamScan()
	{
		dataBase = DataBase.getInstance();
		System.out.println("The size of all Points = "+dataBase.getAllPointsSize());
		allPoints = new ArrayList<Point2D>(dataBase.getAllPoints());
		stack = new Stack<Point2D>();
//		computeGrahamScan();
//		convexHullPoints = new ArrayList<Point2D>(stack);
//		convexHullPoints.remove(0);
		
//		dataBase.setConvexPoints(convexHullPoints);
//		dataBase.setCirclePoints(convexHullPoints);
		convexHullPoints = new ArrayList<Point2D>(convexHull(allPoints));
		System.out.println(convexHullPoints.size());
		convexHullPoints.remove(convexHullPoints.size()-1);
		dataBase.setConvexPoints(convexHullPoints);
		dataBase.setCirclePoints(convexHullPoints);
	}
	
	private void computeGrahamScan()
	{
		//find the leftmost point
		double leftmost = 0;
		int leftIndex = 0;

		for(int i = 0; i < allPoints.size(); i++) 
		{
			double current = allPoints.get(i).getX();
			if (current < leftmost)
			{
				leftmost = current;
				leftIndex = i;
			}
		}

		//move ptP to the front of the list
		Point2D temp = allPoints.get(leftIndex);
		allPoints.set(leftIndex, allPoints.get(0));
		allPoints.set(0, temp);

		Point2D ptP = allPoints.get(0);

		//sort all points by slope to ptP

		Comparator<Point2D> slopeToPtP = new Comparator<Point2D>() 
		{
			@Override
			public int compare(Point2D pt1, Point2D pt2) 
			{

				//if both points are below or above the reference point, swap the order
				int corrector = 1;
				if (pt1.getY() > ptP.getY() && pt2.getY() > ptP.getY()) corrector = -1;
				if (pt1.getY() < ptP.getY() && pt2.getY() < ptP.getY()) corrector = -1;

				if (getSlope(pt1, ptP) < getSlope(pt2, ptP)) return corrector*-1;
				else return corrector*1;

			}
		};

		allPoints.sort(slopeToPtP);

		
		stack.push(allPoints.get(0));

		boolean complete = false;
		Point2D q = allPoints.get(1);
		int loc = 2;

		while (!complete){
			Point2D r = allPoints.get(loc);
			if( ccw(stack.peek(), q, r) < 0 )
			{
				stack.push(q);
				q = r;
				loc++;
			}
			else{
				q = stack.pop();
			}
			if (loc == allPoints.size())
			{
				complete = true;
				stack.push(q);
				stack.push(allPoints.get(0));
			}

			if (stack.peek() != ptP)
			{
				Stack<Point2D> sclone = (Stack<Point2D>)stack.clone();
			}
		}
	}

	/**
	 * Determine if the angle p1-p2-p3 is clockwise or counterclockwise
	 *
	 * @param p1 1st point
	 * @param p2 2nd point
	 * @param p3 3rd point
	 * @return positive number if the angle p1-p2-p3 is counterclockwise,
	 * negative if clockwise, zero if the 3 points are colinear.
	 */
	private double ccw(Point2D p1, Point2D p2, Point2D p3)
	{
		// compute coordinates of vectors from p2 to p1 and p3
		double v1x = p1.getX() - p2.getX();
		double v1y = p1.getY() - p2.getY();

		double v2x = p3.getX() - p2.getX();
		double v2y = p3.getY() - p2.getY();

		// desired quantity is 3rd component of cross product (other
		// components are zero as these vectors are 2d)
		return v1x * v2y - v2x * v1y;
	}

	private double getSlope(Point2D p1, Point2D p2) 
	{
		double slope = (p1.getX() - p2.getX()) / (p1.getY() - p2.getY());
		return slope;
	}	
	
	public ArrayList<Point2D> getconvexHullPoints()
	{
		return convexHullPoints;
	}
	
	
	
	//----------------------------------
	public static List<Point2D> convexHull(List<Point2D> points) {
        // Find the point with the lowest y-coordinate (or the leftmost point in case of a tie)
//        Point2D start = points.get(0);
        start = points.get(0);

        for (Point2D point : points) {
            if (point.getY() < start.getY() || (point.getY() == start.getY() && point.getX() < start.getX())) {
                start = point;
            }
        }

        // Sort the points by polar angle with respect to the start point
        List<Point2D> sortedPoints = new ArrayList<>(points);
        sortedPoints.remove(start);
        Collections.sort(sortedPoints, (a, b) -> {
            double angleA = Math.atan2(a.getY() - start.getY(), a.getX() - start.getX());
            double angleB = Math.atan2(b.getY() - start.getY(), b.getX() - start.getX());
            if (angleA < angleB) {
                return -1;
            } else if (angleA > angleB) {
                return 1;
            } else {
                return Double.compare(a.distance(start), b.distance(start));
            }
        });

        // Perform the Graham's scan
        List<Point2D> hull = new ArrayList<>();
        hull.add(start);
        for (Point2D point : sortedPoints) {
            while (hull.size() >= 2) {
                Point2D p2 = hull.get(hull.size() - 1);
                Point2D p1 = hull.get(hull.size() - 2);
				if (crossProduct(p1, p2, point) < 0) 
				{
					hull.remove(hull.size() - 1);
				} else 
				{
					break;
				}
            }
            hull.add(point);
        }
        hull.add(start);
        return hull;
    }

    private static double crossProduct(Point2D a, Point2D b, Point2D c) {
        double y1 = b.getY() - a.getY();
        double y2 = c.getY() - a.getY();
        double x1 = b.getX() - a.getX();
        double x2 = c.getX() - a.getX();
        return x1 * y2 - x2 * y1;
    }
}


