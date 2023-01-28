package Control;

import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;
import org.jfree.chart.title.TextTitle;
import javafx.scene.input.MouseButton;

public class CustomMouseListener  implements ChartMouseListenerFX
{
	private TextTitle textTitle;
	private double x;
	private double y;
	
	public CustomMouseListener(TextTitle textTitle)
	{
		this.textTitle = textTitle;
	}
	
	@Override
	public void chartMouseClicked(ChartMouseEventFX arg0) 
	{
		x = arg0.getChart().getXYPlot().getDomainCrosshairValue();
		y = arg0.getChart().getXYPlot().getRangeCrosshairValue();
		textTitle.setText("Current Point: ("+x+", "+y+")");
	}


	@Override
	public void chartMouseMoved(ChartMouseEventFX arg0) 
	{
	}
}
