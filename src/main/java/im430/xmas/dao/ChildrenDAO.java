package im430.xmas.dao;

import java.util.List;

import im430.xmas.business.Child;
import im430.xmas.business.Gift;

public interface ChildrenDAO {
	
	public void addChild(Child child);
	
	public void removeChild(Child child);
	
	public void updateChild(Child child);
	
	public Child getChildById(int id);
	
	public List<Child> getAllChildren();
	
	public void addGift(Child child, Gift gift);
	
	public void removeGift(Child child, Gift gift);
}