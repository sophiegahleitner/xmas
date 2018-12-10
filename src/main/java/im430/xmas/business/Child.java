package im430.xmas.business;

import java.util.ArrayList;
import java.util.List;

public class Child {
	
	private int id;
	private String name;
	private Address address;
	private List<Gift> gifts;
	
	public Child() {
		this.id = -1;
		this.name = "";
		this.address = null;
		this.gifts = new ArrayList<Gift>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Gift> getGifts() {
		return gifts;
	}
	
	public void setGifts(List<Gift> gifts) {
		this.gifts = gifts;
	}
}
