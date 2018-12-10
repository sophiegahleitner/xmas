package im430.xmas.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import im430.xmas.business.Address;
import im430.xmas.dao.AddressDAO;

@Repository
@Transactional
public class MappedSqlSessionAddressDAOImpl implements AddressDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addAddress(Address address) {
		sqlSession.insert("im430.xmas.dao.mybatis.MappedSqlSessionAddressDAOImpl.addAddress", address);	
	}

	@Override
	public void removeAddress(Address address) {
		sqlSession.delete("im430.xmas.dao.mybatis.MappedSqlSessionAddressDAOImpl.removeAddress", address);
		address.setId(-1);	
	}

	@Override
	public void updateAddress(Address address) {
		sqlSession.update("im430.xmas.dao.mybatis.MappedSqlSessionAddressDAOImpl.updateAddress", address);
	}

	@Override
	@Transactional(readOnly=true)
	public Address getAddressById(int id) {
		return sqlSession.selectOne("im430.xmas.dao.mybatis.MappedSqlSessionAddressDAOImpl.getAddressById", id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Address> getAllAddresses() {
		return sqlSession.selectList("im430.xmas.dao.mybatis.MappedSqlSessionAddressDAOImpl.getAllAddresses");	
	}	
}
