package Model;

import Model.DoublyLinkedList.Node;

public class Algorithm2 
{
	public Algorithm2()
	{
		
	}
	
	private void computeVoronoiDiagram()
	{
		boolean finish;
		Node maxPoint;
		int n = myDoublyLinkedList.getSize();
		
		
		if(n > 2)
		{
			finish = false;
			do
			{
				maxPoint = myDoublyLinkedList.findMaxNode();
				System.out.println("maxPoint.data = "+maxPoint.data);
				//TO-DO 
				//How to find angle for specific point(paxPoint==p)
				if(myDoublyLinkedList.getAngle(maxPoint.before.data, maxPoint.data, maxPoint.next.data)<=3.14/2)
//				if(Double.compare(myDoublyLinkedList.getAngle(maxPoint.before.data, maxPoint.data, maxPoint.next.data), Math.PI/2) < 0)
				{
					finish = true;
				}else
				{
					myDoublyLinkedList.deleteAtIndex(myDoublyLinkedList.searchIndexOfNode(maxPoint.data));					
					System.out.println("The length of DLL is = "+myDoublyLinkedList.getSize());
				}
			}while(n==2);
		}else
		{
			System.out.println("Only 1 point");
		}
		System.out.print("The size of latest DLL is = "+myDoublyLinkedList.getSize()+"\n");
		myDoublyLinkedList.displayFirstToLast();
		System.out.print("----------------------------------------------------------------------\n");
		System.out.println("The final size is = "+myDoublyLinkedList.getSize());
	}
}
