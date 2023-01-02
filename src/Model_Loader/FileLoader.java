//https://www.w3schools.com/java/java_interface.asp

package Model_Loader;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;

public interface FileLoader 
{
//	public void readValues();
	public List<double[]> getDoubleValues();
	public ArrayList<Point2D> get2Dvalues();
}
