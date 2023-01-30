//https://coderslegacy.com/java/jfreechart-scatter-plot/
//https://www.jfree.org/jfreechart/javadoc/index.html
//https://github.com/jfree/jfreechart-fx/releases
//https://zetcode.com/java/jfreechart/
//https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm#

package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import Control.CustomMouseListener;
import Model.DataBase;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Point2D;

public class CircleGraphGUI
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> circlePoints;
	
	private Stage circleStage;
	private String path;

	private XYSeriesCollection dataset;
	
	private XYPlot plot;
	private TextTitle textSubTitle;
	private JFreeChart chart;
	
	private Ellipse2D circle;
	
	public CircleGraphGUI(String path)
	{
		this.path = path;
	}
	
	public void setAllPoints(ArrayList<Point2D> allPoints)
	{
		this.allPoints = allPoints;
	}
	
	public void setConvexPoints(ArrayList<Point2D> convexPoints)
	{
		this.convexPoints = convexPoints;
	}
	
	public void setCirclePoints(ArrayList<Point2D> circlePoints)
	{
		this.circlePoints = circlePoints;
	}
	
	public void setCircleObject(Ellipse2D circle)
	{
		this.circle = circle;
	}
	
	public void initialize()
	{
		createStage();
		displaySmallestEnclosingCircle();
		circleStage.show();
	}
	
	private void createStage()
    {
		circleStage = new Stage();		
		circleStage.setTitle("SmallestEnclosingCircle -> "+path+" -> "+(allPoints.size())+" points");
		circleStage.setHeight(700);
		circleStage.setWidth(700);
		circleStage.setResizable(true);
    }
	
	private void displaySmallestEnclosingCircle()
	{	
		textSubTitle = new TextTitle("Current Point: None");
		textSubTitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		makeSeries();	    
	    makePlot();
	    makeChart();
	    
		ChartViewer viewer = new ChartViewer(chart);
		viewer.addChartMouseListener(new CustomMouseListener(textSubTitle));
		
		circleStage.setScene(new Scene(viewer));
	}

	private void makeSeries()
	{
		XYSeries series1 = new XYSeries("allPoints -> "+(allPoints.size()));
		XYSeries series2 = new XYSeries("convexPoints -> "+(convexPoints.size()));
		XYSeries series3 = new XYSeries("circlePoints -> "+(circlePoints.size()));			
		dataset = new XYSeriesCollection();
		
		for(int i=0; i<allPoints.size(); i++)
		{
		    series1.add(allPoints.get(i).getX(),allPoints.get(i).getY());
		}

		for(int i=0; i<convexPoints.size(); i++)
		{
		    series2.add(convexPoints.get(i).getX(), convexPoints.get(i).getY());
		}

		for(int i=0; i<circlePoints.size(); i++)
		{
		    series3.add(circlePoints.get(i).getX(), circlePoints.get(i).getY());
		}
		
		dataset.addSeries(series3);
		dataset.addSeries(series2);
		dataset.addSeries(series1);
		dataset.setAutoWidth(true);
	}
	
	private void makePlot()
	{
		JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "Current Point: None", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );	
		plot = (XYPlot)scatterPlot.getPlot(); 
		
		XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.RED, null);
		annotation.setToolTipText("center=("+circle.getCenterX()+", "+circle.getCenterY()+")\nradius="+circle.getWidth()/2);
		plot.addAnnotation(annotation);
		plot.setDomainPannable(true);
	    plot.setRangePannable(true);
	    plot.setDomainCrosshairLockedOnData(true);
	    plot.setRangeMinorGridlinesVisible(true);
	    plot.setDomainCrosshairVisible(true);
	    plot.setDomainZeroBaselineVisible(true);
	    plot.setOutlineVisible(true);
	    //=======================================================
	    plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.getRenderer().setSeriesPaint(0, Color.decode("#006699"));       
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED); //circle points
        renderer.setSeriesPaint(1, Color.BLUE); //convex points
        renderer.setSeriesPaint(2, Color.ORANGE); // all points
      //=======================================================
	}

	private void makeChart()
	{
		chart = new JFreeChart(plot);
		chart.setTitle("Smallest Enclosing Circle");
		//=======================================================
		chart.getTitle().setPaint(Color.decode("#006699"));
		chart.getTitle().setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
        chart.setBackgroundPaint(Color.decode("#f0f9f6"));
      //=======================================================
		chart.addSubtitle(textSubTitle);
		chart.setElementHinting(true);
		chart.setTextAntiAlias(true);
		chart.setNotify(true);
		chart.setAntiAlias(true);
		chart.setBorderVisible(false);
	}
}
