package Control;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;

public class CustomMouseListener  implements ChartMouseListenerFX
{
	JFreeChart chart;
	public CustomMouseListener(JFreeChart chart)
	{
		this.chart = chart;
	}
	
	@Override
	public void chartMouseClicked(ChartMouseEventFX arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("CLICK -> x="+arg0.getTrigger().getX()+" y="+arg0.getTrigger().getY());
		System.out.println("Point -> x="+arg0.getChart().getXYPlot().getDomainCrosshairValue()+" y="+arg0.getChart().getXYPlot().getRangeCrosshairValue());
		chart.setTitle("Current Point: ("+arg0.getChart().getXYPlot().getDomainCrosshairValue()+", "+arg0.getChart().getXYPlot().getRangeCrosshairValue()+")");
	}


	@Override
	public void chartMouseMoved(ChartMouseEventFX arg0) 
	{
		// TODO Auto-generated method stub
//		System.out.println("CLICK-MOVE -> x="+arg0.getTrigger().getScreenX()+" y="+arg0.getTrigger().getScreenY());
	}

}
