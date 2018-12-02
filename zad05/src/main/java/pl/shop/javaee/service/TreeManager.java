package pl.shop.javaee.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Singleton;

import pl.shop.javaee.domain.Tree;

@Singleton
public class TreeManager {

	private List<Tree> db = Collections.synchronizedList(new ArrayList<>());

	public void addTree(Tree tree) {
		db.add(tree);
	}

	public void updateTree(Tree tree) {
		int id = -1;
		Tree newTree;
		for (Tree t : db) {
			if (t.getName().equals(tree.getName())) {
				newTree = t;
				id = db.indexOf(newTree);
			}
		}
		if (id != -1)
			db.set(id, tree);
	}

	public Tree getTree(Integer id) {
		return db.get(id);
	}

	public Tree getTreeExample() {
		return new Tree("buk", true, new Date(), 88, 6);
	}

	public void deleteTree(Tree tree) {
		db.remove(tree);
	}

	public List<Tree> getAllTrees() {
		return db;
	}

	public void deleteAllTrees() {
		db.clear();
	}
}
