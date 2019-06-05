package com.project.calc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.calc.DAO.DataDAO;
import com.project.calc.config.PersistenceJPAConfig;
import com.project.calc.entity.Data;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class PersistenceDAOTest {

	@Autowired
	private DataDAO dataDAO;

	@Test
	public void saveData() {
		Data data = new Data();
		data.setParamA(2.5);
		dataDAO.save(data);
	}

	@Test
	public void recieveDatafromDataBase() {
		String testStr = "test";
		Data dataTest = new Data();
		dataTest.setX1(testStr);
		dataDAO.save(dataTest);
		List<Data> datas = dataDAO.findAll();
		List<Data> res = new ArrayList<>();
		for (Data data : datas) {
			if (data.getX1() == null) {
				continue;
			}
			if (data.getX1().equals(testStr)) {
				res.add(data);
			}
		}
		assertEquals(1, res.size());
		assertEquals(testStr, res.get(0).getX1());
		cleanDB(res.get(0));
	}

	private void cleanDB(Data data) {

		dataDAO.deleteById(data.getId());

	}
}
