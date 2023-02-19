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
	requires com.opencsv;
	requires org.junit.jupiter.api;
	requires org.apache.poi.ooxml;
	requires java.base;
	requires org.jfree.chart.fx;
	requires org.jfree.jfreechart;
	requires jdk.internal.le;
	requires javafx.web;
	requires org.apache.logging.log4j;
	
	opens View to javafx.graphics, javafx.fxml;
}