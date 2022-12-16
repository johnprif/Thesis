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
import java.util.Comparator;
import java.util.Stack;

import javafx.geometry.Point2D;

public class GrahamScan 
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexHullPoints;
	private Stack<Point2D> stack;
	
	public GrahamScan(ArrayList<Point2D> points)
	{
		this.allPoints = new ArrayList<Point2D>(points);
		stack = new Stack<Point2D>();
	}
	
	public void computeGrahamScan()
	{
		//find the leftmost point
		double leftmost = 0;
		int leftIndex = 0;

		for(int i = 0; i < allPoints.size(); i++) {
			double current = allPoints.get(i).getX();
			if (current < leftmost){
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
	
	public void moveStackToArrayList()
	{
		convexHullPoints = new ArrayList<Point2D>(stack);
	}
	
	public ArrayList<Point2D> getconvexHullPoints()
	{
		return convexHullPoints;
	}
}


