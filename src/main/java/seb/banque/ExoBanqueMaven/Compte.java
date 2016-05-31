package seb.banque.ExoBanqueMaven;

//import org.hamcrest.core.SubstringMatcher;


public class Compte {
 
	private String number;
	private Client client;
	private double amount;
	
	
	public Compte() {
		super();
		if(number == null){
			this.number = generateCompteNumber();
		}
	}
	
	public Compte(Client client) {
		super();
		this.client = client;
		if(number == null){
			this.number = generateCompteNumber();
		}
	}
	

	
	public Compte(Client client, double amount) {
		super();
		this.client = client;
		this.amount = amount;
		if(number == null){
			this.number = generateCompteNumber();
		}
	}

	public String generateCompteNumber(){
		double rdm = Math.random();
		rdm = rdm*1000;
		int rdmInt = (int) rdm;
		String firstFirstNameLetter = client.getFirstName().substring(0, 1).toUpperCase();
		String firstLastNameLetter = client.getName().substring(0, 1).toUpperCase();
		number = firstFirstNameLetter + firstLastNameLetter + rdmInt;
		
		return number;
	}


	public String getNumber() {
		return number;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void credit(double amount){
		this.amount += amount;
	}
	
	public void debit(double amount){
		this.amount -= amount;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Compte [number=" + number + ", client=" + client.getFullName() + ", amount=" + amount + "]";
	}
	
	
	
}
