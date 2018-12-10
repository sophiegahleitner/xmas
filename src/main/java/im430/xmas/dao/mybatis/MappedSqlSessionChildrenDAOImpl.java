package im430.xmas.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import im430.xmas.dao.ChildrenDAO;

@Resource
@Transactional
public class MappedSqlSessionChildrenDAOImpl implements ChildrenDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addChild(Child child) {
		sqlSession.insert("im430.xmas.dao.mybatis.MappedSqlSessionChildrenDAOImpl.addChild", child);			
	}

	@Override
	public void removeChild(Child child) {
		sqlSession.delete("im430.xmas.dao.mybatis.MappedSqlSessionChildrenDAOImpl.removeChild", child);
		child.setId(-1);		
	}

	@Override
	public void updateChild(Child child) {
		sqlSession.update("im430.xmas.dao.mybatis.MappedSqlSessionChildrenDAOImpl.updateChild", child);
	}

	@Override
	@Transactional(readOnly = true)
	public Child getChildById(int id) {
		return sqlSession.selectOne("im430.xmas.dao.mybatis.MappedSqlSessionChildrenDAOImpl.getChildById", id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Child> getAllChildren() {
		return sqlSession.selectList("im430.xmas.dao.mybatis.MappedSqlSessionChildrenDAOImpl.getAllChildren");
	}

	@Override
	public void addGift(Child child, Gift gift) {
		Map<String, Object> sqlParameters = new HashMap<String, Object>();
		sqlParameters.put("gift", gift);
		sqlParameters.put("childID", child.getId());
		
		sqlSession.insert("im430.xmas.dao.mybatis.MappedSqlSessionChildrenDAOImpl.addGift",	sqlParameters);	
		
		child.getGifts().add(gift);	
	}

	@Override
	public void removeGift(Child child, Gift gift) {
		sqlSession.delete("im430.xmas.dao.mybatis.MappedSqlSessionChildrenDAOImpl.removeGift", gift);		
		child.getGifts().remove(gift);
		gift.setId(-1);		
	}
	
}
