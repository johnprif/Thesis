package Control;

import java.io.File;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;
import org.jfree.chart.title.TextTitle;

import javafx.scene.input.MouseButton;
import java.io.File;
import java.io.IOException;

public class CustomMouseListener  implements ChartMouseListenerFX
{
//	JFreeChart chart;
	TextTitle textTitle;
	
	public CustomMouseListener(TextTitle textTitle)
	{
//		this.chart = chart;
		this.textTitle = textTitle;
	}
	
	@Override
	public void chartMouseClicked(ChartMouseEventFX arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("CLICK -> x="+arg0.getTrigger().getX()+" y="+arg0.getTrigger().getY());
		System.out.println("Point -> x="+arg0.getChart().getXYPlot().getDomainCrosshairValue()+" y="+arg0.getChart().getXYPlot().getRangeCrosshairValue());
//		chart.setTitle("Current Point: ("+arg0.getChart().getXYPlot().getDomainCrosshairValue()+", "+arg0.getChart().getXYPlot().getRangeCrosshairValue()+")");
//		chart.addSubtitle(new TextTitle("Current Point: ("+arg0.getChart().getXYPlot().getDomainCrosshairValue()+", "+arg0.getChart().getXYPlot().getRangeCrosshairValue()+")"));
		textTitle.setText("Current Point: ("+arg0.getChart().getXYPlot().getDomainCrosshairValue()+", "+arg0.getChart().getXYPlot().getRangeCrosshairValue()+")");
		if(arg0.getTrigger().getButton()==MouseButton.SECONDARY)
		{
			System.out.println("RIGHT CLICK -> x="+arg0.getTrigger().getX()+" y="+arg0.getTrigger().getY());
//			File XYChart = new File( "XYLineChart.jpeg" ); 
//		    ChartUtilities.saveChartAsPNG( XYChart, chart, 700, 700);

		}
	}


	@Override
	public void chartMouseMoved(ChartMouseEventFX arg0) 
	{
		// TODO Auto-generated method stub
//		System.out.println("CLICK-MOVE -> x="+arg0.getTrigger().getScreenX()+" y="+arg0.getTrigger().getScreenY());
	}
}
