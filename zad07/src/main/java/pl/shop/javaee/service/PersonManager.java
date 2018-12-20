package pl.shop.javaee.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.shop.javaee.domain.Person;

@Stateless
public class PersonManager {	
	
	@PersistenceContext
	EntityManager em;
		
	public void addPerson(Person person){
		em.persist(person);		
	}
	
	public Person getPerson(Long id) {
		return em.find(Person.class, id);
	}

	public void updatePerson(Person person) {
		if (person != null)
		em.merge(person);
	}
	
	public void deletePerson(Long id) {
		Person person = em.find(Person.class, id);
		if (person != null)
		em.remove(person);
	}
}
