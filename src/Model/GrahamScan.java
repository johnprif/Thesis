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
import java.util.List;
import javafx.geometry.Point2D;

public class GrahamScan 
{
	private static Point2D start;
	
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexHullPoints;
	private DataBase dataBase;
	
	public GrahamScan()
	{
		dataBase = DataBase.getInstance();
		allPoints = new ArrayList<Point2D>(dataBase.getAllPoints());
		convexHullPoints = new ArrayList<Point2D>(computeGrahamScan(allPoints));
		convexHullPoints.remove(convexHullPoints.size()-1);
		dataBase.setConvexPoints(convexHullPoints);
		dataBase.setCirclePoints(convexHullPoints);
	}
		
	//----------------------------------O(nlogn)
	public static List<Point2D> computeGrahamScan(List<Point2D> points) {
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

    private static double crossProduct(Point2D p, Point2D q, Point2D r) {
        double y1 = q.getY() - p.getY();
        double y2 = r.getY() - p.getY();
        double x1 = q.getX() - p.getX();
        double x2 = r.getX() - p.getX();
        return x1 * y2 - x2 * y1;
    }
}


