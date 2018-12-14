package pl.shop.javaee.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.shop.javaee.domain.Tree;

@Stateless
public class TreeManager {

	@PersistenceContext
	EntityManager em;
	
	public void addTree(Tree tree){
		em.persist(tree);		
	}
	
	/*
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
		//return new Tree(0,"buk", true, new Date(), 88, 6);
		return new Tree();
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
	*/
}
