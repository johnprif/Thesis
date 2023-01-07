//https://coderslegacy.com/java/jfreechart-scatter-plot/
//https://www.jfree.org/jfreechart/javadoc/index.html
//https://github.com/jfree/jfreechart-fx/releases
//https://zetcode.com/java/jfreechart/
//https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm#

package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.MatrixSeries;
import org.jfree.data.xy.MatrixSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;


import Model.Algorithm1;
import Model.DoublyLinkedList2;
import Model.GrahamScan;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;

import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.jfree.chart.renderer.xy.XYItemRendererState;

public class GraphGUI
{
	private Stage graphStage;
	private ArrayList<Point2D> allPoints;
	private ArrayList<double[]> allDoublePoints;
	private GrahamScan convexPoints;
	private Algorithm1 al;
	
	public GraphGUI(ArrayList<Point2D> allPoints)
	{
		this.allPoints = new ArrayList<Point2D>(allPoints);
		System.out.println("The size of all points are = "+allPoints.size());
		computeConvex();
//		callAlgorithm1();
		createStage();
		callAlgorithm1();
		chart7();
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
			
	}
	
	private void printer()
	{
		for(int i=0; i<allPoints.size(); i++)
		{
			System.out.println(i + ": X="+allPoints.get(i).getX()+" Y="+allPoints.get(i).getY());
		}
	}
	
	private void callAlgorithm1()
	{
		al = new Algorithm1(convexPoints.getconvexHullPoints());	
		
	}
	
	private void createStage()
    {
		graphStage = new Stage();

//		myChart3();
		
		
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
        XYSeries series2 = new XYSeries("AllPoints");
        XYSeries series3 = new XYSeries("Algorithm1");
        
        
        for(int i=0; i<convexPoints.getconvexHullPoints().size(); i++)
        {
        	series1.add(convexPoints.getconvexHullPoints().get(i).getX(), convexPoints.getconvexHullPoints().get(i).getY());
        }
        
//        
//        for(int i=0; i<allPoints.size(); i++)
//        {
//        	series2.add(allPoints.get(i).getX(), allPoints.get(i).getY());
//        }
        
        DoublyLinkedList2 myDoublyLinkedList2 = DoublyLinkedList2.getInstance();
        
        System.out.println("The size of algorithm1 is = "+myDoublyLinkedList2.getPoints().size());
        
        for(int i=0; i<myDoublyLinkedList2.getPoints().size(); i++)
        {
        	series3.add(myDoublyLinkedList2.getPoints().get(i).getX(), myDoublyLinkedList2.getPoints().get(i).getY());
        }
        
        
//        dataset.addSeries(series1);
//        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series1);
         
        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "JFreeChart Scatter Plot", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );
//        final XYPlot plot = scatterPlot.getXYPlot( );
//        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
//	      renderer.setSeriesPaint( 0 , Color.RED );
//	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
//	      plot.setDomainPannable(true);
//	      plot.setRangePannable(true);
//	      plot.setRenderer( renderer ); 
        
      //Changes background color  
        XYPlot plot = (XYPlot)scatterPlot.getPlot();  
//        plot.setBackgroundPaint(new Color(255,228,196)); 
	    plot.setDomainPannable(true);
	    plot.setRangePannable(true);

	    
	    Shape oval = new Ellipse2D.Float(100, 100, 100, 100);
	    plot.addAnnotation(new XYShapeAnnotation(oval));
	    Ellipse2D circle = new Ellipse2D.Double(-5, -5, 10, 10);
        XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.BLACK, Color.BLACK);
        plot.addAnnotation(annotation);

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
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
		         "convexHull" ,
		         "X" ,
		         "Y" ,
		         createDataset() ,
		         PlotOrientation.VERTICAL ,
		         true , true , false);
		         
		      ChartPanel chartPanel = new ChartPanel( xylineChart );
		      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		      final XYPlot plot = xylineChart.getXYPlot( );
		      
		      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
//		      renderer.setSeriesPaint( 0 , Color.RED );
		      renderer.setSeriesPaint( 1 , Color.GREEN );
		      renderer.setSeriesPaint( 2 , Color.YELLOW );
//		      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
		      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
		      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
		      plot.setRenderer( renderer ); 
		      ChartViewer viewer = new ChartViewer(xylineChart);  
		      graphStage.setScene(new Scene(viewer));
    
	}
	
	private XYDataset createDataset( ) {
	      final XYSeries firefox = new XYSeries( "Firefox" );                   
	      
	      for(int i=0; i<convexPoints.getconvexHullPoints().size(); i++)
	        {
	    	  firefox.add(convexPoints.getconvexHullPoints().get(i).getX(), convexPoints.getconvexHullPoints().get(i).getY());
	        }
	      
	      
	      final XYSeries chrome = new XYSeries( "Chrome" );          
	      chrome.add( 1.0 , 4.0 );          
	      chrome.add( 2.0 , 5.0 );          
	      chrome.add( 3.0 , 6.0 );          
	      
	      final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
	      iexplorer.add( 3.0 , 4.0 );          
	      iexplorer.add( 4.0 , 5.0 );          
	      iexplorer.add( 5.0 , 4.0 );          
	      
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries( firefox );          
	      dataset.addSeries( chrome );          
	      dataset.addSeries( iexplorer );
	      return dataset;
	   }
	
	private void chart8()
	{
		XYSeries series = new XYSeries("circlePoints");
		XYSeries series2 = new XYSeries("convexPoints");
		DoublyLinkedList2 myDoublyLinkedList2 = DoublyLinkedList2.getInstance();
        
        for(int i=0; i<myDoublyLinkedList2.getPoints().size(); i++)
        {
        	series.add(myDoublyLinkedList2.getPoints().get(i).getX(), myDoublyLinkedList2.getPoints().get(i).getY());
        }
        
        for(int i=0; i<convexPoints.getconvexHullPoints().size(); i++)
        {
        	series2.add(convexPoints.getconvexHullPoints().get(i).getX(), convexPoints.getconvexHullPoints().get(i).getY());
        }
        
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        dataset.addSeries(series2);
        XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), new org.jfree.chart.renderer.xy.XYLineAndShapeRenderer());
        Ellipse2D circle = new Ellipse2D.Double(myDoublyLinkedList2.getPoints().get(0).getX(), myDoublyLinkedList2.getPoints().get(0).getY(), myDoublyLinkedList2.getRadius(myDoublyLinkedList2.getPoints().get(0), myDoublyLinkedList2.getPoints().get(1), myDoublyLinkedList2.getPoints().get(2)), myDoublyLinkedList2.getRadius(myDoublyLinkedList2.getPoints().get(0), myDoublyLinkedList2.getPoints().get(1), myDoublyLinkedList2.getPoints().get(2)));
        XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.BLACK, null);
        plot.addAnnotation(annotation);
        JFreeChart chart = new JFreeChart(plot);
        ChartViewer viewer = new ChartViewer(chart);
        graphStage.setScene(new Scene(viewer));
        System.out.println(circle);
        System.out.println(annotation);
        graphStage.show();
	}
	
	private void chart7()
	{
		XYSeries series = new XYSeries("circlePoints");
		XYSeries series2 = new XYSeries("convexPoints");
		DoublyLinkedList2 myDoublyLinkedList2 = DoublyLinkedList2.getInstance();

		for(int i=0; i<myDoublyLinkedList2.getPoints().size(); i++)
		{
		    series.add(myDoublyLinkedList2.getPoints().get(i).getX(), myDoublyLinkedList2.getPoints().get(i).getY());
		}

		for(int i=0; i<convexPoints.getconvexHullPoints().size(); i++)
		{
		    series2.add(convexPoints.getconvexHullPoints().get(i).getX(), convexPoints.getconvexHullPoints().get(i).getY());
		}

		XYSeriesCollection dataset = new XYSeriesCollection(series);
		dataset.addSeries(series2);
		
		
		JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "JFreeChart Scatter Plot", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );		
		
//		XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), null);
		XYPlot plot = (XYPlot)scatterPlot.getPlot(); 
//		Ellipse2D circle = new Ellipse2D.Double(myDoublyLinkedList2.getPoints().get(0).getX(), myDoublyLinkedList2.getPoints().get(0).getY(), myDoublyLinkedList2.getRadius(myDoublyLinkedList2.getPoints().get(0), myDoublyLinkedList2.getPoints().get(1), myDoublyLinkedList2.getPoints().get(2)), myDoublyLinkedList2.getRadius(myDoublyLinkedList2.getPoints().get(0), myDoublyLinkedList2.getPoints().get(1), myDoublyLinkedList2.getPoints().get(2)));
		Ellipse2D circle = myDoublyLinkedList2.findCircle(myDoublyLinkedList2.getPoints().get(0), myDoublyLinkedList2.getPoints().get(1), myDoublyLinkedList2.getPoints().get(2));
		XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.BLACK, null);
		plot.addAnnotation(annotation);
		plot.setDomainPannable(true);
	    plot.setRangePannable(true);
		JFreeChart chart = new JFreeChart(plot);
		ChartViewer viewer = new ChartViewer(chart);
		graphStage.setScene(new Scene(viewer));
		graphStage.show();
	}
}
