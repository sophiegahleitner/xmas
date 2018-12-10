package im430.xmas.dao;

import java.util.List;

import im430.xmas.business.Address;

public interface AddressDAO {
	
	public void addAddress(Address address);
	
	public void removeAddress(Address address);
	
	public void updateAddress(Address address);
	
	public Address getAddressById(int id);
	
	public List<Address> getAllAddresses();
}
