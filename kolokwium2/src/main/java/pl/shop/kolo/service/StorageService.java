package pl.shop.kolo.service;

import java.util.Map;
import java.util.TreeMap;

import pl.shop.kolo.domain.Card;

public class StorageService {

	// cardMap — elementy są przechowywane w formie posortowanej (wg klucza)
	private Map<String, Card> db = new TreeMap<String, Card>();

	// put(klucz, wartość) - przy próbie dodania kolejnej wartości o tym samym
	// kluczu, zostanie nadpisana wartość już istniejąca
	public void add(String sku, Card card) {
		Card newCard = new Card(card.getProdukcja(), card.getCena(), card.getProducent(), card.getQty(), card.getKolory());
		db.put(sku, newCard);
	}

	public void rm(String sku) {
		db.remove(sku);
	}

	public Map<String, Card> getAllcards() {
		return db;
	}

}
