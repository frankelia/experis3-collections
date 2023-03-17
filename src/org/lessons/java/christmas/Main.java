package org.lessons.java.christmas;

import java.util.*;

/*
 * - Creare un metodo contaDesideri(List<String> desideri) che conta quante volte ogni desiderio
 * appare nella lista e restituisce una Map<String, Integer> con i relativi conteggi.
 * 
 * - Vogliamo rimuovere i duplicati dalla lista. Creare un metodo desideriUnici() che restituisce 
 * un Set<String> contenente i desideri della lista (saranno già deduplicati per via del Set)
 * 
 * - Creare una classe Desiderio che contiene nome e destinatario. Modificare il codice scritto in precedenza
 * in maniera tale da non avere più i desideri come List<String> ma List<Desiderio> (dobbiamo di conseguenza chiedere all'utente
 * non solo il desiderio ma anche il destinatario).
 * 
 * Modificare adeguatamente anche i metodi creati contaDesideri e desideriUnici per farli funzionare correttamente
 * con la nuova List<Desiderio>.
 * 
 * Creare un nuovo metodo contaDesiderPerDestinatario(List<Desiderio> desideri) che funziona analogamente a 
 * contaDesideri ma restituisce una Map<String, Integer> dove la chiave è il destinatario e il valore è
 * il numero dei suoi desideri.
 *   
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Desiderio> wishlist = new ArrayList<>();
		
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.print("Inserisci desiderio: ");
			String desiderio = scan.nextLine();
			
			System.out.print("Inserisci destinatario: ");
			String destinatario = scan.nextLine();
			
			wishlist.add(new Desiderio(desiderio, destinatario));
			
			System.out.print("Hai in totale " + wishlist.size() + " desideri. Vuoi aggiungerne altri? (s/n) ");
			keepGoing = scan.nextLine().equalsIgnoreCase("s");
		}

		System.out.print("Come ti chiami? ");
		String name = scan.nextLine();
		
		System.out.print("Dove abiti? ");
		String address = scan.nextLine();

		ChristmasLetter christmasLetter = new ChristmasLetter(name, address, wishlist);

		System.out.println(christmasLetter.desideriUnici());
		
//		try {
//			christmasLetter.send();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		System.out.println("Lista ordinata");
//		Collections.sort(wishlist);
//		System.out.println(wishlist);
		
		System.out.println(christmasLetter.contaDesideriPerDestinatario());
		
		scan.close();
	}
}