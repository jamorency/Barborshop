// Matt Mensher & Jodell Morency
// April 1, 2013

// Customer class
// Creates a customer object with 3 characteristics: name, arrival time, and service time

public class Customer
{
	// Instance variables
	
	private int arrivalTime; 
	private int serviceTime;
	private String name;
	private Customer next;
	
	// Constructor(s)

	public Customer(int iArrivalTime, int iServiceTime, String iName)
	{
		arrivalTime=iArrivalTime;
		serviceTime=iServiceTime;
		name=iName;
	}	
	
	// Instance Methods

	// retrieves arrival time
	public int getArrivalTime()
	{  
		return arrivalTime;
	}
	
	// retrieves service time
	public int getServiceTime()
	{  
		return serviceTime;
	}
	
	// rettieves customer name	
	public String getName()
	{ 
		return name;
	}
	
	// prints the 3 characteristics of the customer object
	public void printCustomer()
	{ 
		System.out.println("Customer name: "+ name + ", arrival time: " + arrivalTime + ", service time: "+ serviceTime);	
	}
	
	// sets the next vaiable to the designated next customer in line
	public void setNext(Customer newCustomer)
	{
		next=newCustomer;
	}
	
	// retrieves next customer
	public Customer getNext()
	{
		return next;
	}
	
	// checks to see if there is a next customer
	public boolean hasNext()
	{
		return next==null;
	}
}
