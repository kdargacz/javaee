package pl.shop.javaee.service;

import java.util.Map;
import java.util.TreeMap;

import pl.shop.javaee.domain.Tree;

public class StorageService {

	// TreeMap — elementy są przechowywane w formie posortowanej (wg klucza)
	private Map<String, Tree> db = new TreeMap<String, Tree>();

	// put(klucz, wartość) - przy próbie dodania kolejnej wartości o tym samym
	// kluczu, zostanie nadpisana wartość już istniejąca
	public void add(String sku, Tree tree) {
		Tree newTree = new Tree(tree.getName(), tree.isLeafy(), tree.getDataSiewu(), tree.getCena(), tree.getQty());
		db.put(sku, newTree);
	}

	public void rm(String sku) {
		db.remove(sku);
	}

	public Map<String, Tree> getAllTrees() {
		return db;
	}

}
