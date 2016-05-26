// Matt Mensher & Jodell Morency
// April 1, 2013

// Barber class
// Creates a Barber object
// contains methods for seeing if the barber is occupied, who is in the barber chair, and methods for adding and removign customers to the chair. 

public class Barber
{
	// Instance variables
	
	private boolean occupied=false;
	private Customer customerInChair;
	
	// Constructor(s)
	
	public Barber()
	{
	}
	
	// Methods
	
	// Checks to see if a customer is currently in the Barber's Chair
	public boolean isEmpty()
	{
	  	return (occupied==false);
	}
	
	// Adds a customer to the Barber's Chair
	public void add(Customer customer)
	{
		occupied=true;
		customerInChair = customer;
	}
	
	// Removes a customer from the Barber's Chair
	public void remove()
	{
		occupied=false;
		customerInChair=null;
	}
	
	// Returns the customer in the Barber's Chair. *only use if the chair is occupied*
	public Customer peek()
	{
		return customerInChair;
	}
	
	// Displays the customer info of who is in the Barber Chair
	public void display()
	{
		if (occupied==true)
			peek().printCustomer();
		else
			System.out.println("The Barber's Chair is empty");
	}
}
	
	
	
