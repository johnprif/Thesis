package Model;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class XLSXLoader implements FileLoader
{
	private String path;
	
	public XLSXLoader(String path)
	{
		this.path = path;
	}

	@Override
	public List<double[]> getDoubleValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Point2D> get2Dvalues() {
		// TODO Auto-generated method stub
		return null;
	}
}
