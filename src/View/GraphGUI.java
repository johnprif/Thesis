//https://coderslegacy.com/java/jfreechart-scatter-plot/
//https://www.jfree.org/jfreechart/javadoc/index.html
//https://github.com/jfree/jfreechart-fx/releases

package View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Model.Algorithm1;
import Model.GrahamScan;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GraphGUI
{
	private Stage graphStage;
	private ArrayList<Point2D> allPoints;
	private ArrayList<double[]> allDoublePoints;
	private GrahamScan convexPoints;
	
	public GraphGUI(ArrayList<Point2D> allPoints)
	{
		this.allPoints = new ArrayList<Point2D>(allPoints);
		System.out.println("The size of all points are = "+allPoints.size());
		computeConvex();
		createStage();
	}
	
	private void computeConvex()
	{	
		convexPoints = new GrahamScan(allPoints);	
//		printer();
//		convexPoints = new GrahamScan(allPoints.get2Dvalues());
//		convexPoints.computeGrahamScan();
		convexPoints.moveStackToArrayList();
//		ArrayList<Point2D> kati = new ArrayList<Point2D>(convexPoints.getconvexHullPoints());
		System.out.println("------BELLOW ARE THE CONVEXHULL POINTS------");
		for(int i=0; i<convexPoints.getconvexHullPoints().size(); i++)
		{
			System.out.println("My points are = "+convexPoints.getconvexHullPoints().get(i));
		}
		System.out.println("The size of convex points are = "+convexPoints.getconvexHullPoints().size());
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

		myChart3();
		
		
		graphStage.setTitle("GRAPH-GUI");
		graphStage.setHeight(700);
		graphStage.setWidth(700);
		graphStage.setResizable(false);
//		graphStage.setScene(scene);
		graphStage.show();
    }
	
	private void myChart()
	{
		double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
              };
		
		
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries("key", values, 20);
		JFreeChart histogram = ChartFactory.createHistogram("JFreeChart Histogram",
                "y values", "x values", dataset);
		
		
		
	    ChartViewer viewer = new ChartViewer(histogram);
	    graphStage.setScene(new Scene(viewer));
	}
	
	private void myChart2()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 
        dataset.addValue(60, "Python", "2010");
        dataset.addValue(80, "Python", "2015");
        dataset.addValue(90, "Python", "2020");
 
        dataset.addValue(50, "Java", "2010");
        dataset.addValue(45, "Java", "2015");
        dataset.addValue(32, "Java", "2020");
 
        dataset.addValue(0,  "Rust", "2010");
        dataset.addValue(10, "Rust", "2015");
        dataset.addValue(23, "Rust", "2020");
        
        JFreeChart areaChart = ChartFactory.createAreaChart(
                "JFreeChart Area Chart", // Chart title
                "Time", // X-Axis Label
                "Popularity", // Y-Axis Label
                dataset // Dataset for the Chart
                );
        
        ChartViewer viewer = new ChartViewer(areaChart);
	    graphStage.setScene(new Scene(viewer));
	}
	
	private void myChart3()
	{
		XYSeriesCollection dataset = new XYSeriesCollection();
        
        XYSeries series1 = new XYSeries("convexPoints");  
        
        for(int i=0; i<convexPoints.getconvexHullPoints().size(); i++)
        {
        	series1.add(convexPoints.getconvexHullPoints().get(i).getX(), convexPoints.getconvexHullPoints().get(i).getY());
        }
        
        
        dataset.addSeries(series1);
         
        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "JFreeChart Scatter Plot", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );
         
        try {
			ChartUtils.saveChartAsPNG(new File("C://Users/Joanis Prifti/Desktop/scatterplot1.png"), scatterPlot, 600, 400);
			ChartUtils.saveChartAsPNG(new File("C://Users/Joanis Prifti/Desktop/scatterplot2.png"), scatterPlot, 600, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ChartViewer viewer = new ChartViewer(scatterPlot);  
        graphStage.setScene(new Scene(viewer));
    
	}
	
	private void myChart4()
	{
		XYSeriesCollection dataset = new XYSeriesCollection();
        
        XYSeries series1 = new XYSeries("convexPoints");  
        
        for(int i=0; i<convexPoints.getconvexHullPoints().size(); i++)
        {
        	series1.add(convexPoints.getconvexHullPoints().get(i).getX(), convexPoints.getconvexHullPoints().get(i).getY());
        }
        
        
        dataset.addSeries(series1);
         
        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "JFreeChart Scatter Plot", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );
         
        try {
			ChartUtils.saveChartAsPNG(new File("C://Users/Joanis Prifti/Desktop/scatterplot1.png"), scatterPlot, 600, 400);
			ChartUtils.saveChartAsPNG(new File("C://Users/Joanis Prifti/Desktop/scatterplot2.png"), scatterPlot, 600, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ChartViewer viewer = new ChartViewer(scatterPlot);  
        graphStage.setScene(new Scene(viewer));
    
	}
	
}
