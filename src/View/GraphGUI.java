package View;

import java.util.ArrayList;

import Model.Algorithm1;
import Model.GrahamScan;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.stage.Stage;

public class GraphGUI
{
	private Stage graphStage;
	private ArrayList<Point2D> allPoints;

	public GraphGUI(ArrayList<Point2D> allPoints)
	{
		this.allPoints = new ArrayList<Point2D>(allPoints);
		computeConvex();
		createStage();
	}
	
	private void computeConvex()
	{	
		GrahamScan convexPoints = new GrahamScan(allPoints);	
		printer();
//		convexPoints = new GrahamScan(allPoints.get2Dvalues());
//		convexPoints.computeGrahamScan();
//		convexPoints.moveStackToArrayList();
//		ArrayList<Point2D> kati = new ArrayList<Point2D>(convexPoints.getconvexHullPoints());
		System.out.println("------BELLOW ARE THE CONVEXHULL POINTS------");
//		for(int i=0; i<kati.size(); i++)
//		{
//			System.out.println("My points are = "+kati.get(i));
//		}
//		Algorithm1 al = new Algorithm1(kati);		
	}
	
	private void printer()
	{
		for(int i=0; i<allPoints.size(); i++)
		{
			System.out.println(i + ": X="+allPoints.get(i).getX()+" Y="+allPoints.get(i).getY());
		}
	}
	
	private void createStage()
    {
		graphStage = new Stage();
		graphStage.setTitle("GRAPH-GUI");
		graphStage.setHeight(700);
		graphStage.setWidth(700);
		graphStage.setResizable(false);
//		graphStage.setScene(scene);
		graphStage.show();
    }
	
}
