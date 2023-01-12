//https://coderslegacy.com/java/jfreechart-scatter-plot/
//https://www.jfree.org/jfreechart/javadoc/index.html
//https://github.com/jfree/jfreechart-fx/releases
//https://zetcode.com/java/jfreechart/
//https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm#

package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.event.PlotChangeListener;
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

import Control.CustomMouseListener;

import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;
import org.jfree.chart.fx.interaction.ZoomHandlerFX;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import Model.Algorithm1;
import Model.DataBase;
import Model.GrahamScan;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import org.jfree.chart.fx.ChartViewer;

import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.jfree.chart.renderer.xy.XYItemRendererState;



public class GraphGUI
{
	private Stage graphStage;
	private ArrayList<Point2D> allPoints;
	private DataBase dataBase;
	private String path;
	
	public GraphGUI(String path)
	{
		this.path = path;
		dataBase = DataBase.getInstance();
		System.out.println("The size of all points are = "+dataBase.getAllPointsSize());
		createStage();
		displaySmallestEnclosingCircle();
		graphStage.show();
	}
	
	
	private void createStage()
    {
		graphStage = new Stage();		
		graphStage.setTitle("SmallestEnclosingCircle -> "+path+" -> "+(dataBase.getAllPointsSize()-1)+" points");
		graphStage.setHeight(700);
		graphStage.setWidth(700);
		graphStage.setResizable(true);
    }
	
	private void displaySmallestEnclosingCircle()
	{
		XYSeries series = new XYSeries("circlePoints -> "+(dataBase.getCirclePointsSize()-1));
		XYSeries series2 = new XYSeries("convexPoints -> "+(dataBase.getConvexPointsSize()-1));

		for(int i=0; i<dataBase.getConvexPointsSize(); i++)
		{
		    series.add(dataBase.getConvexPoints().get(i).getX(), dataBase.getConvexPoints().get(i).getY());
		}

		for(int i=0; i<dataBase.getCirclePointsSize(); i++)
		{
		    series2.add(dataBase.getCirclePoints().get(i).getX(), dataBase.getCirclePoints().get(i).getY());
		}

		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series2);
		dataset.addSeries(series);
		dataset.setAutoWidth(true);
		JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "JFreeChart Scatter Plot", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );		
		scatterPlot.setElementHinting(true);
		scatterPlot.setTextAntiAlias(true);
		scatterPlot.setNotify(true);
		scatterPlot.setAntiAlias(true);
//		XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), null);
		XYPlot plot = (XYPlot)scatterPlot.getPlot(); 
//		Ellipse2D circle = new Ellipse2D.Double(myDoublyLinkedList2.getPoints().get(0).getX(), myDoublyLinkedList2.getPoints().get(0).getY(), myDoublyLinkedList2.getRadius(myDoublyLinkedList2.getPoints().get(0), myDoublyLinkedList2.getPoints().get(1), myDoublyLinkedList2.getPoints().get(2)), myDoublyLinkedList2.getRadius(myDoublyLinkedList2.getPoints().get(0), myDoublyLinkedList2.getPoints().get(1), myDoublyLinkedList2.getPoints().get(2)));
		Ellipse2D circle = dataBase.findCircle(dataBase.getCirclePoints().get(0), dataBase.getCirclePoints().get(1), dataBase.getCirclePoints().get(2));
		XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.BLACK, null);
		plot.addAnnotation(annotation);
		plot.setDomainPannable(true);
	    plot.setRangePannable(true);
	    plot.setDomainCrosshairLockedOnData(true);
	    plot.setRangeMinorGridlinesVisible(true);
	    plot.setDomainCrosshairVisible(true);
	    plot.setDomainZeroBaselineVisible(true);
	    plot.setOutlineVisible(true);
		JFreeChart chart = new JFreeChart(plot);
		chart.setTitle("Current Point:");
		ChartViewer viewer = new ChartViewer(chart);
		//---------------------------------------------------------------------------
		viewer.addChartMouseListener(new CustomMouseListener(chart));

		//--------------------------------------------------
		graphStage.setScene(new Scene(viewer));
	}



}
