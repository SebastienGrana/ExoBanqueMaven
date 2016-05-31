package seb.banque.ExoBanqueMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void connectionBD() {
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hbexo", "postgres", "1234")) {
			System.out.println("Connextion à la base de donnée établie \n");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static String afficheurSelecteurOptions() {
		// Affiche le choix des options (1 - Votre Solde / 2 - Faire un
		// virement)
		boolean isOptionSelectedOk = false;
		String returnOption = null;
		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("Choisir votre option:");
			System.out.println("1- Votre Solde");
			System.out.println("2- Faire un virement");

			returnOption = scanner.nextLine();

			if (returnOption.equals("1") || returnOption.equals("2")) {
				isOptionSelectedOk = true;

			} else if (returnOption == null) {
				// .... dead code
			} else {
				System.out.println("Selection d'option invalide, veuillez recommencez");
			}

		} while (isOptionSelectedOk != true);

		return returnOption;
	}

	public static boolean afficheurSolde() {
		Scanner scanner = new Scanner(System.in);
		// try de la connextion a la bd + text
		try (Connection connec = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hbexo", "postgres",
				"1234")) {

			System.out.println("Vous avez choisis d'afficher la solde d'un compte");
			System.out.println("Veuillez saisir votre numéro de compte:");
			String numCompte = scanner.nextLine();
			Statement statement = connec.createStatement();
			
			//TODO cas ou le num de compte est FAUX !!!!
			if (witchBank(numCompte) == null) {
				System.out.println("Numéro de compte invalide : " + numCompte);
				return false;//PAS BEAU !!
			}
			
			// try des requetes pour la récup du compte et du clien associer
			try (ResultSet resultSet = statement
					.executeQuery("SELECT * FROM compte WHERE num_compte = '" + numCompte + "'")) {

				int idCompte = 0;
				double amount = 0;
				int idClient = 0;
				while (resultSet.next()) {
					int idCompteTmp = resultSet.getInt("id");
					double amountTmp = resultSet.getInt("amount");
					int idClientTmp = resultSet.getInt("id_client");

					idCompte = idClientTmp;
					amount = amountTmp;
					idClient = idClientTmp;

				}
				String nomBanque = witchBank(numCompte);

				System.out.println("Compte de la banque: " + nomBanque);
				System.out.println("Compte n°: " + numCompte);
				System.out.println("amount : " + amount + "€");
				System.out.println();

			} catch (Exception e) {
				System.out.println(e);
			}

			// TODO AFFICAGE DES CLIENT POUR CHAQUE BANQUE
		} catch (SQLException e) {
			System.out.println(e);
		}
		return true; //PAS BEAU !!

	}

	// donnez nimportequel numCompte -> renvoie le nom de la banque
	// correspondante ou null si elle n'existe pas
	public static String witchBank(String numCompte) {
		String bank = null;
		if (numCompte.length() == 6) {
			String codeBank = numCompte.substring(0, 3);

			switch (codeBank) {
			case "5C9":
				bank = "CIC";
				break;
			case "3G7":
				bank = "BNP Parisbas";
				break;
			}
		}
		return bank;
	}

	public static boolean selectVirement() {
		Boolean isVirementDone = false;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Vous avez selectionner le virement entre deux comptes");
		System.out.println("Veuillez saisir le compte a Débiter");
		String numCompteDebit = scanner.nextLine();
		// TODO EXCEPTIONS !!!!!!!!!

		// test des trois premiers char, si bank existe
		if (witchBank(numCompteDebit) == null) {
			System.out.println("Numéro de compte à Débiter invalide : " + numCompteDebit);
			return isVirementDone;
		}
		System.out.println("Veuillez saisir le compte a Créditer");
		String numCompteCredit = scanner.nextLine();
		// test des trois premiers char, si bank existe
		if (witchBank(numCompteCredit) == null) {
			System.out.println("Numéro de compte à Crediter invalide : " + numCompteCredit);
			return isVirementDone;
		}
		System.out.println("Saisissez la somme à Créditer sur le compte n°" + numCompteCredit);
		int montant = Integer.parseInt(scanner.nextLine());

		isVirementDone = faireVirement(numCompteDebit, numCompteCredit, montant);

		return isVirementDone;
	}

	public static boolean faireVirement(String numCompteDebit, String numCompteCredit, int montant) {
		Boolean isVirementDone = false;

		// try de connection à la bd
		try (Connection connec = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hbexo", "postgres",
				"1234")) {
			Statement statement = connec.createStatement();
			// try d'update du compte crediteur (++) avec le montant
			try (ResultSet resultSet = statement.executeQuery("UPDATE compte SET amount =  amount + '" + montant
					+ "' WHERE num_compte = '" + numCompteCredit + "'")) {

			} catch (Exception e) {
				System.out.println(e);
			}

			int montantNeg = montant * -1;
			// try d'update du compte débiteur (--) avec le montant
			try (ResultSet resultSet = statement.executeQuery("UPDATE compte SET amount = amount + '" + montantNeg
					+ "' WHERE num_compte = '" + numCompteDebit + "'")) {
				isVirementDone = true;
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return isVirementDone;
	}

	public static boolean toBoolean(String strBoolean) {
		boolean boolBoolean = false;
		if (strBoolean.equals("oui")) {
			boolBoolean = true;
		} else if (strBoolean.equals("non")) {
			boolBoolean = false;
		}
		return boolBoolean;
	}

	public static void main(String[] args) throws SQLException {

		connectionBD();
		boolean continuer = true;
		boolean virementOk = false;
		Scanner scanner = new Scanner(System.in);

		do {
			String optionSelected = afficheurSelecteurOptions();
			if (optionSelected.equals("1")) {
				afficheurSolde();
			} else if (optionSelected.equals("2")) {
				virementOk = selectVirement();
			}

			if (continuer == true) {
				System.out.println("Voullez vous continuez ? ");
				System.out.print("oui/non ?");
				String repContinue = scanner.nextLine();
				continuer = toBoolean(repContinue.toLowerCase());
			}
		} while (continuer == true);

	}

}
