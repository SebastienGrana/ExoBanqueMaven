package seb.banque.ExoBanqueMaven;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {
	//CONSTANTES
	static String NUMCOMPTE1 = "5C9995";
	static String NUMCOMPTE2 = "3G7065";
	static String NOMBANQUE1 = "CIC";
	static String NOMBANQUE2 = "BNP Parisbas";
	 
	@Test
	 public void goodNumCompteOfWitchBankTest(){
		
		 String nomBanque = Main.witchBank(NUMCOMPTE1);
		 
		 assertEquals(nomBanque, NOMBANQUE1);
	 }
	
	@Test
	 public void emptyNumCompteOfWitchBankTest(){
		
		 String nomBanque = Main.witchBank("");
		 
		 assertEquals(nomBanque, null);
	 }
	
	@Test
	 public void tooShortNumCompteOfWitchBankTest(){
		
		 String nomBanque = Main.witchBank("65");
		 
		 assertEquals(nomBanque, null);
	 }
	
	@Test
	 public void tooLongNumCompteOfWitchBankTest(){
		
		 String nomBanque = Main.witchBank("65965896548");
		 
		 assertEquals(nomBanque, null);
	 }
	
}
