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
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Control.CustomMouseListener;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FarthestNeighborVoronoiGraphGUI 
{
	private ArrayList<Point2D> allPoints;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> circlePoints;
	private ArrayList<Point2D> K;
	private ArrayList<ArrayList<Point2D>> E;
	private Stage circleStage;
	private String path;

	private XYSeriesCollection dataset;
	
	private XYPlot plot;
	private TextTitle textSubTitle;
	private JFreeChart chart;
	private Ellipse2D circle;
	
	public FarthestNeighborVoronoiGraphGUI(String path)
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
	
	public void setK(ArrayList<Point2D> K) 
	{
		this.K = K;
	}


	public void setE(ArrayList<ArrayList<Point2D>> E) 
	{
		this.E = E;
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
		circleStage.setTitle("Farthest Neighbor Voronoi Diagram -> "+path+" -> "+(allPoints.size())+" points");
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
//		XYSeries series1 = new XYSeries("allPoints -> "+(allPoints.size()));
		XYSeries series0 = new XYSeries("convexPoints -> "+(convexPoints.size()));
//		XYSeries series3 = new XYSeries("circlePoints -> "+(circlePoints.size()));		
		
		XYSeries series1 = new XYSeries("Voronoi Edges -> "+(K.size())+" ||");
		XYSeries series2 = new XYSeries("Voronoi Cells-Lines -> "+(E.size()+" ||"));

		dataset = new XYSeriesCollection();

		for(int i=0; i<convexPoints.size(); i++)
		{
		    series0.add(convexPoints.get(i).getX(), convexPoints.get(i).getY());
		}
		
		for(int i=0; i<K.size(); i++)
		{
			series1.add(K.get(i).getX(), K.get(i).getY());
		}

		
		
		dataset.addSeries(series2); // Voronoi Cell
		dataset.addSeries(series1); // Voronoi Edges
		dataset.addSeries(series0); // convexPoints
		
		for(int i=0; i<E.size(); i++) // Voronoi Cells
		{
			XYSeries series = new XYSeries(i+"");
			series.add(E.get(i).get(0).getX(), E.get(i).get(0).getY());
			series.add(E.get(i).get(1).getX(), E.get(i).get(1).getY());
			dataset.addSeries(series);
		}
		
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
		//---------------------------------------------------------------------------------------------------------------------------
       
        //---------------------------------------------------------------------------------------------------------------------------
//		XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.RED, null);
//		annotation.setToolTipText("center=("+circle.getCenterX()+", "+circle.getCenterY()+")\nradius="+circle.getWidth()/2);
//		plot.addAnnotation(annotation);
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
//        plot.getRenderer().setSeriesPaint(0, Color.decode("#006699"));       
        
        XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
       
        renderer2.setSeriesPaint(2, Color.BLUE); //convex points
        renderer2.setSeriesLinesVisible(2, false);
        renderer2.setSeriesShapesVisible(2, true);
               
        renderer2.setSeriesPaint(1, Color.RED); //voronoi edges
        renderer2.setSeriesLinesVisible(1, false);
        renderer2.setSeriesShapesVisible(1, true);
        
        renderer2.setSeriesPaint(0, Color.PINK); //voronoi cells
        renderer2.setSeriesLinesVisible(0, false);
        renderer2.setSeriesShapesVisible(0, false);
        
        for(int i=0; i<E.size(); i++)
        {
        	renderer2.setSeriesPaint(3+i, Color.YELLOW); //voronoi cells
        	renderer2.setSeriesLinesVisible(3+i, true);
            renderer2.setSeriesShapesVisible(3+i, false);
            renderer2.setSeriesStroke(3+i, new BasicStroke(2.0f));
            renderer2.setSeriesItemLabelsVisible(3+i, false);
            renderer2.setDefaultItemLabelsVisible(false);
            renderer2.setSeriesVisibleInLegend(3+i, false);
        }
        
        plot.setRenderer(renderer2);
      //=======================================================
	}

	private void makeChart()
	{
		chart = new JFreeChart(plot);
		chart.setTitle("Farthest Neighbor Voronoi Diagram");
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
