package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	public void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
                // Les montants ont été correctement additionnés  
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");              
	}
	@Test
    // S3 : on n’imprime pas leticket si le montant inséré est insuffisant
    public void dontPrint() {
        // On met pas assez d'argent
        machine.insertMoney(PRICE - 1);
        assertFalse(machine.printTicket(), "On ne doit pas imprimer");
    }
	  @Test
	    // S4 : on imprime le ticket si le montant inséré est suffisant
	    public void print() {
	        // On met assez d'argent
	        machine.insertMoney(PRICE + 1);
	        assertTrue(machine.printTicket(), "On doit imprimer");
	    }
	  @Test
      // S5 : on imprime un ticket la balance est décrémentée du prix du ticket
      public void decrementTicketPrix() {
          machine.insertMoney(PRICE);
          machine.printTicket();
          assertEquals(machine.getBalance(),machine.getPrice()-PRICE);
      }
	  @Test
      // S6 : montant collecté est mis à jour quand on imprime un ticket (pas avant)
      public void montantCollecterMisAJour() {
        machine.insertMoney(PRICE);
        assertEquals(PRICE,machine.getBalance());

      }
	  @Test
      // S7 :rend correctement la monnaie
      public void rendCorrectementLaMonnaie() {
        machine.insertMoney(PRICE);
        assertEquals(PRICE,machine.refund());

      }
    @Test
      // S8 :remet la balance à zéro
      public void remetLaBalanceAZero() {
        machine.insertMoney(PRICE);
        machine.refund();
        assertEquals(0,machine.getBalance());
      }
    @Test
    // S9 : on ne peut pas insérer un montant négatif
    public void cantInsertNegAmount() {
        assertThrows(IllegalArgumentException.class, () -> { machine.insertMoney(-10); }, "Cet appel doit lever une exception");
    }


    @Test
    // S10 :  on ne peut pas créer de machine qui délivre des tickets dont le prix est négatif
    public void cantCreateMachineWithNegPrice() {
        assertThrows(IllegalArgumentException.class, () -> { new TicketMachine(-10);  }, "Cet appel doit lever une exception");
    }
}

