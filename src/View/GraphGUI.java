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
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
//		circleStage.initModality(Modality.APPLICATION_MODAL);
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
		XYSeries series1 = new XYSeries("allPoints -> "+(dataBase.getAllPointsSize()));
		XYSeries series2 = new XYSeries("convexPoints -> "+(dataBase.getConvexPointsSize()));
		XYSeries series3 = new XYSeries("circlePoints -> "+(dataBase.getCirclePointsSize()));			
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
	
	private void makePlot()
	{
		JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "Current Point: None", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );	
		plot = (XYPlot)scatterPlot.getPlot(); 
		
		Ellipse2D circle = dataBase.findCircle();
		XYShapeAnnotation annotation = new XYShapeAnnotation(circle, new BasicStroke(1.0f), Color.RED, null);
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
		chart.getTitle().setFont(new Font("Arial", Font.BOLD, 24));
        chart.setBackgroundPaint(Color.decode("#f5f5f5"));
      //=======================================================
		chart.addSubtitle(textSubTitle);
		chart.setElementHinting(true);
		chart.setTextAntiAlias(true);
		chart.setNotify(true);
		chart.setAntiAlias(true);
		chart.setBorderVisible(false);
	}
}
