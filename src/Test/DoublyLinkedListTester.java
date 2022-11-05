package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

import Model.CSVLoader;
import Model.DoublyLinkedList;

class DoublyLinkedListTester {

	private static DoublyLinkedList list;
	
	@BeforeAll
	public static void initialize() throws IOException, CsvException
	{
		list = new DoublyLinkedList();
	}
	
	@Test
	void test() 
	{	
		int i=0;
		
		assertEquals(list.insertAtFirst(1), list.searchNode(1));
		i++;
		assertEquals(list.getSize(), i);
		
		assertEquals(list.insertAtFirst(2), list.searchNode(2));
		i++;
		assertEquals(list.getSize(), i);
		
		assertEquals(list.insertAtFirst(3), list.searchNode(3));
		i++;			
		assertEquals(list.getSize(), i);
		
		assertEquals(list.insertAtLast(4), list.searchNode(4));
		i++;
		assertEquals(list.getSize(), i);
		
		assertEquals(list.insertAtIndex(5, 3), list.searchNode(5));
		i++;
		assertEquals(list.getSize(), i);		

		list.deleteAtIndex(2);
		i--;
		assertEquals(list.getSize(), i);
		
		list.deleteFirstNode();
		i--;
		assertEquals(list.getSize(), i);

		list.deleteLastNode();
		i--;
		assertEquals(list.getSize(), i);
	}

}
