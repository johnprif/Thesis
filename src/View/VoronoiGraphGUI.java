package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import Control.CustomMouseListener;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VoronoiGraphGUI 
{
	private int allPointsSize;
	private ArrayList<Point2D> convexPoints;
	private ArrayList<Point2D> K;
	private ArrayList<ArrayList<Point2D>> E;
	private Stage voronoiStage;
	private String path;
	private String title;
	
	private XYPlot plot;
	private TextTitle textSubTitle;
	
	public VoronoiGraphGUI(String path)
	{
		this.path = path;
	}
		
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setAllPointsSize(int allPointsSize)
	{
		this.allPointsSize = allPointsSize;
	}
	
	public void setConvexPoints(ArrayList<Point2D> convexPoints)
	{
		this.convexPoints = convexPoints;
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
		voronoiStage.show();
	}
	
	private void createStage()
    {
		voronoiStage = new Stage();		
		voronoiStage.setTitle(title+" -> "+path+" -> "+(allPointsSize)+" points");
		voronoiStage.setHeight(700);
		voronoiStage.setWidth(700);
		voronoiStage.setX(700);
		voronoiStage.setY(0);
		voronoiStage.setResizable(true);
    }
	
	private void displaySmallestEnclosingCircle()
	{	
		textSubTitle = new TextTitle("Current Point: None");
		textSubTitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
		    
	    makePlot();
	    
		ChartViewer viewer = new ChartViewer(makeChart());
		viewer.addChartMouseListener(new CustomMouseListener(textSubTitle));
		
		voronoiStage.setScene(new Scene(viewer));
	}

	private XYSeriesCollection makeSeriesAndDataset()
	{
		XYSeries series0 = new XYSeries("convexPoints -> "+(convexPoints.size()));			
		XYSeries series1 = new XYSeries("Voronoi Edges -> "+(K.size())+" ||");
		XYSeries series2 = new XYSeries("Voronoi Lines -> "+(E.size()+" ||"));

		XYSeriesCollection dataset = new XYSeriesCollection();

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

	private XYLineAndShapeRenderer makeRenderer()
	{
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
        	int offset = 3;
        	renderer2.setSeriesPaint(offset+i, Color.decode("#8fbc8f")); //voronoi cells
        	renderer2.setSeriesLinesVisible(offset+i, true);
            renderer2.setSeriesShapesVisible(offset+i, false);
            renderer2.setSeriesStroke(offset+i, new BasicStroke(2.0f));
            renderer2.setSeriesItemLabelsVisible(offset+i, false);
            renderer2.setDefaultItemLabelsVisible(false);
            renderer2.setSeriesVisibleInLegend(offset+i, false);
        }
        
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
