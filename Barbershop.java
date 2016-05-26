// Matt Mensher & Jodell Morency
// April 1, 2013

// Barbershop class
// Runs a simulation of a barbershop
// Uses a queue of expected customers from the arrival class.
// Places customers from arrival class to the chairs queue as specified.
// Simulates a haircut when the barber has time for a customer.

public class Barbershop
{
	public static void main (String[] args)
	{
		// instance variables
		int time=1; 	// current time
		int timeLeft=0; // keeps track of how much time a customer has left on his hair cut 
		
		// Creation of objects/ queues
		Arrivals arrival= new Arrivals();
		arrival.readCustFile();
		
		Chairs chairs= new Chairs(5);
		Barber barber= new Barber();
		
		// while a customer is in some part of the system
		while ((!arrival.isEmpty()) || (!chairs.isEmpty()) || (!barber.isEmpty()))  
		{
			System.out.println("Time = " + time); //prints current time
			// if current time = the customer's arrival time
			if (time==(arrival.peek().getArrivalTime()))
			{	
				// check to see if there is an empty chair 
				if(!chairs.isFull())
				{
					System.out.println("A chair is available.");			// display that a chair is available
					System.out.println(arrival.peek().getName()+ " sits."); // display who sits
					chairs.add(arrival.peek());								// add customer from arrival queue to chairs queue
					arrival.remove();										// remove customer from arrival queue
					
					// checks to see if the barber is occupied
					if (!barber.isEmpty()) 
					{
					    // if haircut has ended
						if(timeLeft==0)
						{
							System.out.println("Hair cut finished. " + barber.peek().getName() + " leaves");
							barber.remove();				// removes customer from barber chair. (finished haircut)
							barber.add(chairs.peek());		// add customer from chairs to the barber chair
							timeLeft=barber.peek().getServiceTime(); //reset timeLeft for new customer
							chairs.remove();					// remove customer from waiting chair
						}	
						
					}
					else // barber chair was empty
					{
						barber.add(chairs.peek());			// add customer from chairs to the barber chair
						timeLeft=barber.peek().getServiceTime(); // set timeLeft for new customer
						chairs.remove();					// remove customer from waiting chair
					}
				}
				else // no chairs available
				{
						arrival.remove();					// customer goes home bc no chairs available
				}
			}
			// Options to run when no one arrives on the current iteration
			else if (barber.isEmpty()==false)
			{
				System.out.println("No one arrives");
				System.out.println("Barber is occupied");
				
				if(timeLeft==0) // Hair cut is done
				{
					System.out.println("Hair cut finished. " + barber.peek().getName() + " leaves");
					barber.remove();					// removes customer from barber chair. (finished haircut)
					if (!chairs.isEmpty())
					{
						barber.add(chairs.peek());		// add customer from chairs to the barber chair
						timeLeft=barber.peek().getServiceTime(); // reset timeLeft for new customer
						chairs.remove();				// remove customer from waiting chair
					}
				}
			}
			System.out.println("People in chairs:");				// display chairs
			chairs.displayCustomers();								// display info of people sitting
			System.out.println("Barber:");
			if (!barber.isEmpty())
				System.out.println("\t"+ barber.peek().getName() + " is being serviced");
				
			System.out.println(timeLeft+ " time left");             // displays time left for customer in b chair
			System.out.println("Arrival List:");					// display arrival list
			arrival.display();									    // display info of people in arrivals queue
			System.out.println();
			System.out.println("----------------------------------------------------------------------------");
			System.out.println();
			time++;
			timeLeft--;
		}			// end while
		System.out.println("All customers are serviced.  Barber Shop closes.");
	} 				// end main
} 					// end class
			
			
			
			
				
				
				
				
				
				
				
				
				
				
				
				
				
