//Sources
//https://www.javadevjournal.com/data-structure/doubly-linked-list-in-java/

package Model;

import java.text.DecimalFormat;

import javafx.geometry.Point2D;

public class DoublyLinkedList 
{
	class Node
	{
		Point2D data;
		Node before;
		Node next;
		
		public Node(Point2D data)
		{
			this.data = data;
		}
	}
	
	Node head, tail = null;
	int size=0;
		
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size)
	{
		this.size=size;
	}
	
	public boolean insertAtFirst(Point2D data)
	{
		Node newNode = new Node(data);
		//For the first element, head and tail both will point to it
		if(head == null)
		{
			tail = newNode;
		}else
		{
			head.before = newNode;
		}
		
		newNode.next = head;
		head = newNode;
		
		size++;
		
		return true;
	}
	
	public boolean insertAtIndex(Point2D data, int index)
	{			
		if(index>=0 && index<=size)
		{
			Node newNode = new Node(data);
			Node current = head;
			
			if(index==0)
			{
				insertAtFirst(data);
			}else if(index==size)
			{
				insertAtLast(data);
			}else
			{
				for(int i=0; i<index && current.next!=null; i++)
				{
					current=current.next;
				}
				
				newNode.next=current;
				current.before.next=newNode;
				newNode.before=current.before;
				current.before=newNode;
				
				size++;
				return true;
			}
		}else
		{
			System.out.println("Index "+index+" not valid for linked list of size "+size);
		}
		return false;
	}
	
	public boolean insertAtLast(Point2D data)
	{
		Node newNode = new Node(data);
		
		if(head==null)
		{
			head=newNode;
		}else
		{
			tail.next=newNode;
			newNode.before=tail;
		}
		tail=newNode;
		size++;
		
		return true;
	}
	
	public boolean deleteFirstNode()
	{
		Node newNode;
		if(head==null)
		{
			System.out.println("List is empty");
		}
		newNode = head;
		if(head.next==null)
		{
			tail=null;
		}else
		{
			head.next.before=null;
		}
		head=head.next;
		size--;		
		return true;
	}
	
	public boolean deleteAtIndex(int index)
	{
		Node current;
		if(index+1>=0 && index+1<=size)
		{
			current=head; 
			
			if(index==0) //remove at the start
			{
				deleteFirstNode();
			}else if(index==size-1) //remove at last
			{
				deleteLastNode();
			}else
			{
				for(int i=0; i<index && current.next!=null; i++)
				{
					current=current.next;
				}
				current.before.next=current.next;
				current.next.before=current.before;
				size--;
				return true;
			}			
		}else
		{
			System.out.println("Index "+index+" not valid for linked list of size "+size);
		}
		return false;
	}

	public boolean deleteLastNode() 
	{
		Node newNode;
		if(tail==null)
		{
			throw new RuntimeException("List is empty");
		}
		newNode=tail;
		if(head.next==null)
		{
			head=null;
		}else
		{
			tail.before.next=null;
		}
		tail=tail.before;
		size--;
		return true;
	}
	
	public void displayFirstToLast()
	{
		Node current=head;
		System.out.println("The doubly linked list is --> ");
		while(current!=null)
		{
			System.out.println(" "+current.data);
			current=current.next;
		}
		System.out.println("");
	}
	
	public void displayLastToFirst()
	{
		Node current=tail;
		System.out.println("The doubly linked list is --> ");
		while(current!=null)
		{
			System.out.println(" "+current.data);
			current=current.before;
		}
		System.out.println(" ");
	}
	
	public boolean searchNode(Point2D data)
	{
		Node current=head;
		if(head==null)
		{
			System.out.println("Doubly linked list is empty");
			return false;
		}
		System.out.println("Search node with data "+data+" in doubly linked list");
		while(current!=null)
		{
			if(current.data==data)
			{
				System.out.println("node with data "+data+" found");
				return true;
			}
			current=current.next;
		}
		return false;
	}
	
	
	//it must be implement here?
	public Point2D findMaxNode()
	{
		Node current = head;
		Node maxNode = head;
		double maxRadius = 0;
		double currentRadius = 0;
		
		if(head==null)
		{
			System.out.println("Doubly linked list is empty");
			return null;
		}
		//Start from second node
		current = current.next;
		//TO-DO
		//check if current.next == null  
		while(current!=null && current.next!=null)
		{
			currentRadius = getRadius(current.before.data, current.data, current.next.data);
			if(currentRadius>maxRadius)
			{
				maxNode = current;
				maxRadius = currentRadius;
			}
			current=current.next;
		}
		return maxNode.data;
	}
	
	private double getRadius(Point2D p, Point2D q, Point2D r)
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
			double sx13 = (int)(Math.pow(x1, 2) - Math.pow(x3, 2));
		 
		    // y1^2 - y3^2
			double sy13 = (int)(Math.pow(y1, 2) - Math.pow(y3, 2));
		 
			double sx21 = (int)(Math.pow(x2, 2) - Math.pow(x1, 2));
		                     
			double sy21 = (int)(Math.pow(y2, 2) - Math.pow(y1, 2));
		 
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
		 
			double c = -(int)Math.pow(x1, 2) - (int)Math.pow(y1, 2) -
		                                2 * g * x1 - 2 * f * y1;
		 
		    // eqn of circle be x^2 + y^2 + 2*g*x + 2*f*y + c = 0
		    // where centre is (h = -g, k = -f) and radius r
		    // as r^2 = h^2 + k^2 - c
			double h = -g;
		    double k = -f;
		    double sqr_of_r = h * h + k * k - c;
		 
		    // r is the radius
		    R = Math.sqrt(sqr_of_r);
		    DecimalFormat df = new DecimalFormat("#.#####");
		    System.out.println("Centre = (" + h + "," + k + ")");
		    System.out.println("Radius = " + df.format(R));
		}
		return R;
	}
	
	private double getAngle(Point2D p, Point2D q, Point2D r)
	{
		Point2D pq = new Point2D(p.getX()-q.getX(), p.getY()-q.getY());
		Point2D qr = new Point2D(q.getX()-r.getX(), q.getY()-r.getY());
		double pq_qr = pq.getX()*qr.getX()+pq.getY()*qr.getY();
		double _pq_qr_ = Math.sqrt(pq.getX()*pq.getX()+pq.getY()*pq.getY()) * Math.sqrt(qr.getX()*qr.getX()+qr.getY()*qr.getY());		
		double angle = Math.acos(pq_qr/_pq_qr_);
		
		return angle;
	}
}
