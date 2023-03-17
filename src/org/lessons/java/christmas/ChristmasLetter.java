package org.lessons.java.christmas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ChristmasLetter {
	private String senderName;
	
	private String address;
	
	private List<Desiderio> wishlist;

	private boolean good;

	public ChristmasLetter(String senderName, String senderAddress, List<Desiderio> wishList) {
		this.good = new Random().nextBoolean();
		this.senderName = senderName;
		this.address = senderAddress;
		this.wishlist = wishList;
	}

	public List<Desiderio> getWishList() {
		return wishlist;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderAddress() {
		return address;
	}

	public void send() throws Exception {
		if (wishlist.size() > 5) {
			throw new Exception("Lista superiore a 5 elementi");
		}

		if (!good) {
			throw new Exception("I'm sorry, you were bad this year");
		}

		System.out.println("Lettera inviata a : " + getSenderName() + ", " + getSenderAddress() + "\n" + wishlist);
	}
	
	public Map<Desiderio, Integer> contaDesideri() {
		Map<Desiderio, Integer> conteggi = new HashMap<>();
		
		
		for (Desiderio desiderio : wishlist) {
			conteggi.putIfAbsent(desiderio, 0);
			conteggi.put(desiderio, conteggi.get(desiderio) + 1);
		}
		
		return conteggi;
	}
	
	public Map<String, Integer> contaDesideriPerDestinatario() {
		Map<String, Integer> conteggi = new HashMap<>();
		
		
		for (Desiderio desiderio : wishlist) {
			conteggi.merge(desiderio.getDestinatario(), 1, Integer::sum);
		}
		
		return conteggi;
	}
	
	public Set<Desiderio> desideriUnici() {
		return new HashSet<>(wishlist);
	}
}
