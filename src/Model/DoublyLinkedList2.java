//https://www.geeksforgeeks.org/linked-list-in-java/
package Model;

import java.util.Iterator;
import java.util.LinkedList;

import Model.DoublyLinkedList.Node;
import javafx.geometry.Point2D;

public class DoublyLinkedList2 
{
	LinkedList<Point2D> dll;

	public DoublyLinkedList2()
	{
		dll = new LinkedList<Point2D>();
	}
	
	public int getSize()
	{
		return dll.size();
	}
	
	public boolean insertAtFirst(Point2D data)
	{
		dll.addFirst(data);
		return true;
	}
	
	public boolean insertAtIndex(Point2D data, int index)
	{			
		dll.add(index, data);
		return true;
	}
	
	public boolean insertAtLast(Point2D data)
	{
		dll.addLast(data);
		return true;
	}
	
	public boolean deleteFirstNode()
	{
		dll.removeFirst();	
		return true;
	}
	
	public boolean deleteAtIndex(int index)
	{
		dll.remove(index);
		return true;
	}
	
	public boolean deleteLastNode() 
	{
		dll.removeLast();
		return true;
	}
	
	public void displayFirstToLast()
	{
		Iterator it = dll.iterator();
		System.out.println("The doubly linked list is --> ");
		while(it.hasNext())
		{
			System.out.println(" "+it.next());
		}
		System.out.println("");
	}
	
	public int searchIndexOfNode(Point2D data)
	{
		return dll.indexOf(data);
	}
	
	//it must be implement here?
		//serial search, multiplexity O(n)
		public Node findMaxNode()
		{
			Node current = head;
			Node maxNode = head;
			double maxRadius = 0;
			double maxAngle = 0;
			double currentRadius = 0;
			double currentAngle = 0;
			
			if(head==null)
			{
				System.out.println("Doubly linked list is empty");
				return null;
			}
			//Start from second node
			current = current.next;
			//TO-DO
			//check if current.next == null 
			//check current.next, head, head.next
			//check head, head.next, head.next.next
			while(current!=null && current.next!=null)
			{
				currentRadius = getRadius(current.before.data, current.data, current.next.data);
				currentAngle = getAngle(current.before.data, current.data, current.next.data);
				if(currentRadius>=maxRadius)
				{
					if(currentRadius==maxRadius)
					{					
						if(currentAngle>=maxAngle)
						{
							maxNode = current;
							maxRadius = currentRadius;
							maxAngle = currentAngle;
						}//else nothing
					}else//currentRadius>maxRadius
					{
						maxNode = current;
						maxRadius = currentRadius;
						maxAngle = currentAngle;
					}			
				}
				current=current.next;
			}
			return maxNode;
		}
	
	public double getRadius(Point2D p, Point2D q, Point2D r)
	{
		double x1 = p.getX();
		double y1 = p.getY();
		double x2 = q.getX();
		double y2 = q.getY();
		double x3 = r.getX();
		double y3 = r.getY();
		
		double R = 0;
		
		if((p!=q) && (q!=r) && (p!=r))
		{
			double x12 = x1 - x2;
			double x13 = x1 - x3;
		 
			double y12 = y1 - y2;
			double y13 = y1 - y3;
		 
			double y31 = y3 - y1;
			double y21 = y2 - y1;
		 
			double x31 = x3 - x1;
			double x21 = x2 - x1;
		 
		    // x1^2 - x3^2
			double sx13 = (Math.pow(x1, 2) - Math.pow(x3, 2));
		 
		    // y1^2 - y3^2
			double sy13 = (Math.pow(y1, 2) - Math.pow(y3, 2));
		 
			double sx21 = (Math.pow(x2, 2) - Math.pow(x1, 2));
		                     
			double sy21 = (Math.pow(y2, 2) - Math.pow(y1, 2));
		 
			double f = ((sx13) * (x12)
		            + (sy13) * (x12)
		            + (sx21) * (x13)
		            + (sy21) * (x13))
		            / (2 * ((y31) * (x12) - (y21) * (x13)));
			double g = ((sx13) * (y12)
		            + (sy13) * (y12)
		            + (sx21) * (y13)
		            + (sy21) * (y13))
		            / (2 * ((x31) * (y12) - (x21) * (y13)));
		 
			double c = -Math.pow(x1, 2) - Math.pow(y1, 2) -
		                                2 * g * x1 - 2 * f * y1;
		 
		    // eqn of circle be x^2 + y^2 + 2*g*x + 2*f*y + c = 0
		    // where centre is (h = -g, k = -f) and radius r
		    // as r^2 = h^2 + k^2 - c
			double h = -g;
		    double k = -f;
		    double sqr_of_r = h * h + k * k - c;
		 
		    // r is the radius
		    R = Math.sqrt(sqr_of_r);
//		    DecimalFormat df = new DecimalFormat("#.#####");
//		    System.out.println("Centre = (" + h + "," + k + ")");
//		    System.out.println("Radius = " + df.format(R));
		}
		return R;
	}
	
	public double getAngle(Point2D p, Point2D q, Point2D r)
	{
		Point2D pq = new Point2D(p.getX()-q.getX(), p.getY()-q.getY());
		Point2D qr = new Point2D(q.getX()-r.getX(), q.getY()-r.getY());
		double pq_qr = pq.getX()*qr.getX()+pq.getY()*qr.getY();
//		double _pq_qr_ = Math.sqrt(pq.getX()*pq.getX()+pq.getY()*pq.getY()) * Math.sqrt(qr.getX()*qr.getX()+qr.getY()*qr.getY());		
		double _pq_qr_ = Math.sqrt(Math.pow(pq.getX(),2)+Math.pow(pq.getY(),2)) * Math.sqrt(Math.pow(qr.getX(),2)+Math.pow(qr.getY(),2));	
		double angle = Math.acos(pq_qr/_pq_qr_);
//		System.out.println("The angle is = "+angle);
		return angle;
	}
}
