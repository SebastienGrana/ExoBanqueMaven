package seb.banque.ExoBanqueMaven;

import java.util.List;

public class Client {

	private String name;
	private String firstName;
	private int age;
	private String adress;
	private List<Compte> compte;
	
	
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", firstName=" + firstName + ", age=" + age + ", adress=" + adress + ", compte="
				+ compte + ", getName()=" + getName() + ", getFirstName()=" + getFirstName() + ", getFullName()="
				+ getFullName() + ", getAge()=" + getAge() + ", getAdress()=" + getAdress() + ", getComptes()="
				+ getComptes() + "]";
	}


	public Client() {
		super();
	}


	public Client(String name, String firstName) {
		super();
		if(name.length() >= 2){
			this.name = name;
		}else{ 
			throw new IllegalArgumentException("Last name too short"); 
		}
		
		if(firstName.length() >= 2){
			this.firstName = firstName;
		}else{ 
			throw new IllegalArgumentException("First name too short"); 
		}
	}


	public Client(String name, String firstName, int age, String adress/*, List<Compte> compte*/) {
		super();
		if(name.length() >= 2){
			this.name = name;
		}else{ 
			throw new IllegalArgumentException("Last name too short"); 
		}
		if(firstName.length() >= 2){
			this.firstName = firstName;
		}else{ 
			throw new IllegalArgumentException("First name too short"); 
		}
		this.age = age;
		this.adress = adress;
//		this.compte = compte;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFullName() {
		String fullName = this.getFirstName()+" "+this.getName();
		return fullName;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	public List<Compte> getComptes() {
		return compte;
	}
	public void addCompte(Compte compte) {
		this.compte.add(compte);
	}
	
	
	
}
