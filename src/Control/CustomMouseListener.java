package Control;

import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;

public class CustomMouseListener  implements ChartMouseListenerFX
{

	@Override
	public void chartMouseClicked(ChartMouseEventFX arg0) {
		// TODO Auto-generated method stub
		System.out.println("CLICK -> x="+arg0.getTrigger().getX()+" y="+arg0.getTrigger().getY());
		System.out.println("CLICK-NEW -> x="+arg0.getChart().getXYPlot().getDomainCrosshairValue()+" y="+arg0.getChart().getXYPlot().getRangeCrosshairValue());
//		System.out.println("CLICK-NEW -> x="+arg0.getEntity().getToolTipText());
//		System.out.println("CLICK-NEW -> x="+arg0.getChart().getXYPlot().getRangeAxis().toString()+" y="+arg0.getChart().getXYPlot().getRangeCrosshairValue());


	}


	@Override
	public void chartMouseMoved(ChartMouseEventFX arg0) {
		// TODO Auto-generated method stub
//		System.out.println("CLICK-MOVE -> x="+arg0.getTrigger().getScreenX()+" y="+arg0.getTrigger().getScreenY());
	}

}
