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
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import Control.CustomMouseListener;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Point2D;

public class SmallestEnclosingCircleGraphGUI
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> circlePoints;
	
	private Stage circleStage;
	private String path;
	private String title;

	private XYSeriesCollection dataset;
	
	private XYPlot plot;
	private TextTitle textSubTitle;
	
	private Ellipse2D circle;
	
	public SmallestEnclosingCircleGraphGUI(String path)
	{
		this.path = path;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
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
	
	public void initialize(int x, int y)
	{
		createStage(x, y);
		displaySmallestEnclosingCircle();
		circleStage.show();
	}
	
	private void createStage(int x, int y)
    {
		circleStage = new Stage();		
		circleStage.setTitle(title+" -> "+path+" -> "+(allPoints.size())+" points");
		circleStage.setHeight(700);
		circleStage.setWidth(700);
		circleStage.setX(x);
		circleStage.setY(y);
		circleStage.setResizable(true);
    }
	
	private void displaySmallestEnclosingCircle()
	{	
		textSubTitle = new TextTitle("Current Point: None");
		textSubTitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
  
	    makePlot();
	    
		ChartViewer viewer = new ChartViewer(makeChart());
		viewer.addChartMouseListener(new CustomMouseListener(textSubTitle));
		
		circleStage.setScene(new Scene(viewer));
	}

	private XYSeriesCollection makeSeriesAndDataset()
	{
		int circlePointsSize = circlePoints.size();
		int convexPointsSize = convexPoints.size();
		int allPointsSize = allPoints.size();
		
		XYSeries series1 = new XYSeries("allPoints -> "+(allPointsSize-convexPointsSize - circlePointsSize)+"+convexPoints+circlePoints");
		XYSeries series2 = new XYSeries("convexPoints -> "+(convexPointsSize - circlePointsSize)+"+circlePoints"+" ||");
		XYSeries series3 = new XYSeries("circlePoints -> "+circlePointsSize+" ||");			
		
		dataset = new XYSeriesCollection();
		
		for(int i=0; i<allPointsSize; i++)
		{
		    series1.add(allPoints.get(i).getX(),allPoints.get(i).getY());
		}

		for(int i=0; i<convexPointsSize; i++)
		{
		    series2.add(convexPoints.get(i).getX(), convexPoints.get(i).getY());
		}

		for(int i=0; i<circlePointsSize; i++)
		{
		    series3.add(circlePoints.get(i).getX(), circlePoints.get(i).getY());
		}
		
		dataset.addSeries(series3);
		dataset.addSeries(series2);
		dataset.addSeries(series1);
		dataset.setAutoWidth(true);
		
		return dataset;
	}
	
	private void makePlot()
	{
		JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "Current Point: None", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                makeSeriesAndDataset() // Dataset for the Chart
                );	
		plot = (XYPlot)scatterPlot.getPlot(); 
		plot.addAnnotation(makeCircle());
		plot.setDomainPannable(true);
	    plot.setRangePannable(true);
	    plot.setDomainCrosshairLockedOnData(true);
	    plot.setRangeMinorGridlinesVisible(true);
	    plot.setDomainCrosshairVisible(true);
	    plot.setDomainZeroBaselineVisible(true);
	    plot.setOutlineVisible(true);
	    plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setRenderer(makeRenderer());
	}

	private XYShapeAnnotation makeCircle()
	{
		XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.RED, null);
		annotation.setToolTipText("center=("+circle.getCenterX()+", "+circle.getCenterY()+")\nradius="+circle.getWidth()/2);
		return annotation;
	}
	
	private XYLineAndShapeRenderer makeRenderer()
	{
		XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
        renderer2.setSeriesPaint(0, Color.RED); //circle points
        renderer2.setSeriesLinesVisible(0, false);
        renderer2.setSeriesShapesVisible(0, true);
      
        renderer2.setSeriesPaint(1, Color.BLUE); //convex points
        renderer2.setSeriesLinesVisible(1, false);
        renderer2.setSeriesShapesVisible(1, true);
      
        renderer2.setSeriesPaint(2, Color.ORANGE); // all points
        renderer2.setSeriesLinesVisible(2, false);
        renderer2.setSeriesShapesVisible(2, true);
        return renderer2;
	}
	
	private JFreeChart makeChart()
	{
		JFreeChart chart = new JFreeChart(plot);
		chart.setTitle(title);
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
		return chart;
	}
}
