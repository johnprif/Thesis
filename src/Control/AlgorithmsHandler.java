package Control;

import java.util.ArrayList;

import Model.Algorithm1;
import Model.DataBase;
import Model.GrahamScan;
import javafx.geometry.Point2D;

public class AlgorithmsHandler 
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> circlePoints;
	
	private GrahamScan grahamScan;
	private Algorithm1 algorithm1;
	private DataBase dataBase;
	
	public AlgorithmsHandler()
	{
		dataBase = DataBase.getInstance();
		grahamScan = new GrahamScan();	
		algorithm1 = new Algorithm1();	
	}
}
