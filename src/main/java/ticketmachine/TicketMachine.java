package ticketmachine;

/**
 * TicketMachine models a naive ticket machine that issues flat-fare tickets. The price of a ticket is specified via the
 * constructor. It is a naive machine in the sense that it trusts its users to insert enough money before trying to print a
 * ticket. It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class TicketMachine {
	// The price of a ticket from this machine.
	private final int price;
	// The amount of money entered by a customer so far.
	private int balance;
	// The total amount of money collected by this machine.
	private int total;

	/**
	 * Create a machine that issues tickets of the given price.
	 *
	 * @param ticketCost the price of a ticket, >=0
	 */
	public TicketMachine(int ticketCost) {
		// Test de validité du paramètre
		if (ticketCost <= 0) {
			throw new IllegalArgumentException("Ticket price must be positive");
		}
		price = ticketCost;
		balance = 0;
		total = 0;
	}

	/**
	 * Return the price of a ticket.
	 *
	 * @return the price of tickets for this machine
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Return the total amount collected by the machine.
	 *
	 * @return the total amount collected by the machine.
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @return the amount of money already inserted for the next ticket.
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Receive an amount of money in cents from a customer.
	 *
	 * @param amount the amount inserted, in cents (positive)
	 * @throws IllegalArgumentException if amount is not positive
	 */
	 public void insertMoney(int amount) {
	        if(amount > 0){

	            balance = balance + amount;
	        } else {
	            throw new IllegalArgumentException("Argument must not be negative");
	        }
	    }

	/**
	 * Refunds the balance to customer
	 *
	 * @return the balance
	 */
	public int refund() {
		System.out.println("Je vous rends : " + balance + " centimes");
		int balanceTemp= balance ;
		balance=0;
		total=0;
		return balanceTemp;
		
	}

	/**
	 * Print a ticket. Update the total collected and reduce the balance 
	 *
	 * @return vrai si le ticket a été imprimé, faux sinon
	 */
	public boolean printTicket() {
        
        // Simulate the printing of a ticket.
        if(this.getBalance()< this.getPrice()) return false; 
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();
        
        this.balance-=this.price;
        return true;
    }
}
