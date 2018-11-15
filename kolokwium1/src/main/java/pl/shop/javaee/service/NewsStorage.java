package pl.shop.javaee.service;



import java.util.Map;
import java.util.TreeMap;

import pl.shop.javaee.domain.Newsletter;

public class NewsStorage {
	
	private Map<String, Newsletter> db = new TreeMap<String, Newsletter>();
	
	public void add(String fullName, Newsletter newsletter) {
		Newsletter newNewsletter = new Newsletter(newsletter.getOdCzasu(), newsletter.getDoCzasu(), newsletter.getCzestotliwosc(), newsletter.getTematy());
		db.put(fullName, newNewsletter);
	}
	public Map<String, Newsletter> getAllNewsletters(){
		return db;
	}
}
