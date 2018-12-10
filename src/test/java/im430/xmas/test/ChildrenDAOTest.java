package im430.xmas.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import im430.xmas.business.Address;
import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import im430.xmas.dao.AddressDAO;
import im430.xmas.dao.ChildrenDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("DAOTest-context.xml")
public class ChildrenDAOTest {
	
	@Autowired
	private ChildrenDAO childrenDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Test
	public void testChild() {
		
		Address a1 = new Address();
		a1.setText("Hauptstraﬂe 81, 4040 Linz");
		addressDAO.addAddress(a1);
		
		Child c1 = new Child();
		c1.setName("Sophie Gahleitner");
		c1.setAddress(a1);
		
		childrenDAO.addChild(c1);
		
		Child c2 = childrenDAO.getChildById(c1.getId());
		
		assertEquals(c1.getName(), c2.getName());
		
		c1.setName("Michael Sieghartsleitner");
		
		childrenDAO.updateChild(c1);
		
		Child c3 = childrenDAO.getChildById(c1.getId());
		
		assertEquals(c1.getName(), c3.getName());
		
		int size1 = childrenDAO.getAllChildren().size();

		childrenDAO.removeChild(c1);
		
		int size2 = childrenDAO.getAllChildren().size();
		
		assertEquals(size1 - 1, size2);
	}
	
	@Test
	public void testGift() {
		
		Child c = childrenDAO.getChildById(1);
		Gift g = new Gift();
		g.setDescription("Parfum Testxx");

		childrenDAO.addGift(c, g);
					
		List<Gift> gifts1 = childrenDAO.getChildById(c.getId()).getGifts();
		
		assertEquals(g.getDescription(), gifts1.get(gifts1.size()-1).getDescription());
		
		childrenDAO.removeGift(c, g);
		
		List<Gift> gifts2 = childrenDAO.getChildById(c.getId()).getGifts();

		assertEquals(gifts1.size() - 1, gifts2.size());
	}
}
