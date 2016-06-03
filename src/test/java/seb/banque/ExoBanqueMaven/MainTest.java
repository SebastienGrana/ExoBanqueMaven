package seb.banque.ExoBanqueMaven;

import static org.junit.Assert.*;

import javax.print.DocFlavor.STRING;

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
	private static final boolean TRUE_BOOLEAN = true;
	private static final boolean FALSE_BOOLEAN = false;
	private static final String STRING_BOOLEAN_OUI = "oui";
	private static final String STRING_BOOLEAN_YES = "yes";
	private static final String STRING_BOOLEAN_NON = "non";
	private static final String STRING_BOOLEAN_NO = "no";
	private static final String STRING_BOOLEAN_UPPERCASE = "YES";
	private static final String WRONG_STRING_BOOLEAN = "Yres";
	private static final String SPECIAL_CHAR_STRING_BOOLEAN = "Yes;!";
	 
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
	public void goodStringOuiReturnTrueFunctionToBooleanTest(){
		boolean booleanTrue = Main.toBoolean(STRING_BOOLEAN_OUI);
		
		assertTrue(booleanTrue);
	
	}
	
	@Test
	public void goodStringYesReturnTrueFunctionToBooleanTest(){
		boolean booleanTrue = Main.toBoolean(STRING_BOOLEAN_YES);
		
		assertTrue(booleanTrue);
	
	}
	
	@Test
	public void goodStringNonReturnFalseFunctionToBooleanTest(){
		boolean booleanFalse = Main.toBoolean(STRING_BOOLEAN_NON);
		
		assertFalse(booleanFalse);
	
	}
	
	@Test
	public void goodStringNoReturnFalseFunctionToBooleanTest(){
		boolean booleanFalse = Main.toBoolean(STRING_BOOLEAN_NO);
		
		assertFalse(booleanFalse);
	
	}
	
	@Test
	public void goodStringYesUpperCaseReturnTrueFunctionToBooleanTest(){
		boolean booleanTrue = Main.toBoolean(STRING_BOOLEAN_UPPERCASE);
		
		assertTrue(booleanTrue);
	
	}
//	@Test
//	public void twoAcountExistIsVirementDoableTest(){
//		
//		assertTrue(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE2, MONTANT));
//	}
//	
//	@Test
//	public void twoSameAccountOfIsVirementDoableTest(){
//		
//		assertFalse(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE1, MONTANT));
//	}
//	
//	@Test
//	public void debiteurNotEnoughMoneyOfIsVirementDoableTest(){
//		
//		assertFalse(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE2, BIG_MONTANT));
//	}
//	
//	@Test
//	public void negativeAmountOfIsVirementDoableTest(){
//		
//		assertFalse(Main.isVirementDoable(NUMCOMPTE1, NUMCOMPTE2, NEG_MONTANT));
//	}
	
}
