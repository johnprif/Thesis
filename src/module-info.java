/**
 * 
 */
/**
 * @author Joanis Prifti
 *
 */
module Java_Paper 
{
	exports View;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires java.desktop;
	requires java.xml;
//	requires com.healthmarketscience.jackcess;
	
	opens View to javafx.graphics, javafx.fxml;
}