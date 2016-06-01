package seb.banque.ExoBanqueMaven;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {
	//CONSTANTES
	private static final int MONTANT = 50;
	private static final int NEG_MONTANT = -50;
	private static final int BIG_MONTANT = 50000000;
	private static final int BIG_NEG_MONTANT = -50000000;
	private static final String NUMCOMPTE1 = "5C9995";
	private static final String NUMCOMPTE2 = "3G7065";
	private static final String NOMBANQUE1 = "CIC";
	private static final String NOMBANQUE2 = "BNP Parisbas";
	 
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
	
	@Test
	public void twoAcountExistIsVirementDoableTest(){
		
		assertTrue(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE2, MONTANT));
	}
	
	@Test
	public void twoSameAccountOfIsVirementDoableTest(){
		
		assertFalse(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE1, MONTANT));
	}
	
	@Test
	public void debiteurNotEnoughMoneyOfIsVirementDoableTest(){
		
		assertFalse(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE2, BIG_MONTANT));
	}
	
	@Test
	public void negativeAmountOfIsVirementDoableTest(){
		
		assertFalse(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE2, NEG_MONTANT));
	}
	
}
