package seb.banque.ExoBanqueMaven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Banque {
	private String name;
	private String adresse;
	private List<Client> clients;
	// new ArrayList<>();
	private List<Compte> comptes;
	// 
	



	public Banque(String name, String adresse, List<Client> clients, List<Compte> comptes) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.clients = clients;
		this.comptes = comptes;
	}

	




	@Override
	public String toString() {
		return "Banque [name=" + name + ", adresse=" + adresse + ", clients=" + clients + ", comptes=" + comptes + "]";
	}






	//-------MethodeClient-------//
	public List<Client> getClients() {
		//Catch all client of the bank in a List
			
		return clients;
	}
	
	public Client getClients(String lastName, String firstName) { //TODO Exception
		//Catch the specific client of the bank in a Client
		Client goodClient = new Client ();
		for (Client client : this.getClients()) {
			if(client.getFirstName() == firstName && client.getName() == lastName){
				goodClient = client;
			}
		}
		return goodClient;
	}
	
	public void addClient(Client client) { //TODO Exception
			//Throw a confirmation of the adding
		clients.add(client);

	}
	
	public void addClient(String lastName, String firstName) { //TODO Exception
			//Throw a confirmation of the adding
		Client client = new Client(lastName, firstName);
		clients.add(client);
	}
	
	public Boolean deletClient(Client client){ //TODO Exception
		//Throw a confirmation of the Deleting		
		return clients.remove(client);
	}
	
	public Boolean deletClient(String lastName, String firstName){ //TODO Exception
		//Throw a confirmation of the Deleting
		Client client = new Client(lastName, firstName);
		return clients.remove(client);
	}
	
	//--------MethodeCompte-------//
	public List<Compte> getComptes() {
		return comptes;
	}
	
	public  Compte getCompte(String numCompte) { //TODO Exception
		Compte goodCompte = new Compte();
		for (Compte compte : comptes) {
			if(compte.getNumber() == numCompte){
				goodCompte = compte;
			}
		}
		return goodCompte;
	}
	
	public  Compte openCompte(Client client) { //TODO Exception
		Compte compte = new Compte(client);
		comptes.add(compte);
		return compte;
	}
	
	public Compte openCompte(Client client, double deposit) { //TODO Exception
		Compte compte = new Compte(client,deposit);
		comptes.add(compte);
		return compte;
	}
	
	public Compte openCompte(String lastName, String firstName) { //TODO Exception
		Compte compte = new Compte();
		
		//TODO faire test si client existe && exception
		for (Client clientBanque : clients) {
			if(clientBanque.getName()==lastName && clientBanque.getFirstName()==firstName){
				Client client = new Client(lastName, firstName);
				compte.setClient(client);
				comptes.add(compte);
			}
		}
		
		return compte; //TODO Exception cas ou le nom et les prenom n'existe dans la liste des client de la banque
	}
	
	public Compte openCompte(String lastName, String firstName, double deposit) { //TODO Exception
		Compte compte = new Compte();
		
		//TODO faire test si client existe && exception
		for (Client clientBanque : clients) {
			if(clientBanque.getName()==lastName && clientBanque.getFirstName()==firstName){
				Client client = new Client(lastName, firstName);
				compte.setClient(client);
				compte.credit(deposit);
				comptes.add(compte);
			}
		}
		
		return compte; //TODO Exception cas ou le nom et les prenom n'existe dans la liste des client de la banque
	}
	
	public Boolean closeCompte(String numberCompte) { //TODO Exception*
		
		Boolean bool = false;
		for (Compte compte : comptes) {
			if(compte.getNumber()==numberCompte){
				comptes.remove(compte);
				bool=true;
			}
		}

		return bool;
	}
	
	public Boolean closeCompte(Compte compte) { //TODO Exception
		Boolean bool = false;
		
		//TODO try catch for an exception
		comptes.remove(compte);
		bool=true;
		//
		
		return bool;
	}
	
	
	//--------------//

}
