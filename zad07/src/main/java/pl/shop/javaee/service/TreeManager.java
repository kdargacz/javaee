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
	
	public Tree getTree(Long id) {
		return em.find(Tree.class, id);
	}

	public void updateTree(Tree tree) {
		if (tree != null)
		em.merge(tree);
	}
	
	public void deleteTree(Long id) {
		Tree tree = em.find(Tree.class, id);
		if (tree != null)
		em.remove(tree);
	}
	
	
	public Tree findTreeById(long id) {
		
		//		Dog dog = em.find(Dog.class, id);
		//sysout  dog.getOwner().getFirstName();
		return em.find(Tree.class, id);
		
	}
	
	/*
	public List<Tree> getAllTrees() {
		return db;
	}

	public void deleteAllTrees() {
		db.clear();
	}
	*/
}
