//https://coderslegacy.com/java/jfreechart-scatter-plot/
//https://www.jfree.org/jfreechart/javadoc/index.html
//https://github.com/jfree/jfreechart-fx/releases
//https://zetcode.com/java/jfreechart/
//https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm#

package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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
import org.jfree.chart.title.TextTitle;
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
	private Stage circleStage;
	private Stage voronoiStage;
	private DataBase dataBase;
	private String path;

	private XYSeriesCollection dataset;
	
	private XYPlot plot;
	private TextTitle textSubTitle;
	private JFreeChart chart;
	
	public GraphGUI(String path)
	{
		this.path = path;
		dataBase = DataBase.getInstance();
		System.out.println("The size of all points are = "+dataBase.getAllPointsSize());
		createStage();
		displaySmallestEnclosingCircle();
		circleStage.show();
	}
	
	
	private void createStage()
    {
		circleStage = new Stage();		
		circleStage.setTitle("SmallestEnclosingCircle -> "+path+" -> "+(dataBase.getAllPointsSize())+" points");
		circleStage.setHeight(700);
		circleStage.setWidth(700);
		circleStage.setResizable(true);
    }
	
	private void displaySmallestEnclosingCircle()
	{	
		textSubTitle = new TextTitle("Current Point: None");
		textSubTitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
		makeSeries();
	    
	    makePlots();
	    
		
		//---------------------
		ChartViewer viewer = new ChartViewer(chart);
		//---------------------------------------------------------------------------
		viewer.addChartMouseListener(new CustomMouseListener(textSubTitle));

		//--------------------------------------------------
		circleStage.setScene(new Scene(viewer));
	}

	private void makeSeries()
	{
		XYSeries series1 = new XYSeries("allPoints -> "+(dataBase.getAllPointsSize()));
		XYSeries series2 = new XYSeries("convexPoints -> "+(dataBase.getConvexPointsSize()-1));
		XYSeries series3 = new XYSeries("circlePoints -> "+(dataBase.getCirclePointsSize()-1));			
		dataset = new XYSeriesCollection();
		
		for(int i=0; i<dataBase.getAllPointsSize(); i++)
		{
		    series1.add(dataBase.getAllPoints().get(i).getX(), dataBase.getAllPoints().get(i).getY());
		}

		for(int i=0; i<dataBase.getConvexPointsSize(); i++)
		{
		    series2.add(dataBase.getConvexPoints().get(i).getX(), dataBase.getConvexPoints().get(i).getY());
		}

		for(int i=0; i<dataBase.getCirclePointsSize(); i++)
		{
		    series3.add(dataBase.getCirclePoints().get(i).getX(), dataBase.getCirclePoints().get(i).getY());
		}
		
		dataset.addSeries(series3);
		dataset.addSeries(series2);
		dataset.addSeries(series1);
		dataset.setAutoWidth(true);
	}
	
	private void makePlots()
	{
		JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "Current Point: None", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );	
//		scatterPlot.setElementHinting(true);
//		scatterPlot.setTextAntiAlias(true);
//		scatterPlot.setNotify(true);
//		scatterPlot.setAntiAlias(true);
//		scatterPlot.setBorderVisible(true);
		plot = (XYPlot)scatterPlot.getPlot(); 
//		Ellipse2D circle = dataBase.findCircle();
		
		Ellipse2D circle = dataBase.findCircle();
		XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.BLACK, null);
		plot.addAnnotation(annotation);
		plot.setDomainPannable(true);
	    plot.setRangePannable(true);
	    plot.setDomainCrosshairLockedOnData(true);
	    plot.setRangeMinorGridlinesVisible(true);
	    plot.setDomainCrosshairVisible(true);
	    plot.setDomainZeroBaselineVisible(true);
	    plot.setOutlineVisible(true);
	    
	    chart = new JFreeChart(plot);
		chart.setTitle("Smallest Enclosing Circle");
		chart.addSubtitle(textSubTitle);
		//---------------------
		chart.setElementHinting(true);
		chart.setTextAntiAlias(true);
		chart.setNotify(true);
		chart.setAntiAlias(true);
		chart.setBorderVisible(true);
	}

}
