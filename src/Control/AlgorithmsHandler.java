package Control;

import Model.Algorithm1;
import Model.Algorithm2;
import Model.DataBase;
import Model.GrahamScan;

public class AlgorithmsHandler 
{	
	private GrahamScan grahamScan;
	private Algorithm1 algorithm1;
	private Algorithm2 algorithm2;
	private DataBase dataBase;
	
	public AlgorithmsHandler()
	{
		dataBase = DataBase.getInstance();
		grahamScan = new GrahamScan();	
		algorithm1 = new Algorithm1();	
		algorithm2 = new Algorithm2();
		
	}
}
