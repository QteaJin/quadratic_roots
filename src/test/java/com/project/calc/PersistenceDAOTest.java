package com.project.calc;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.calc.DAO.DataDAO;
import com.project.calc.config.PersistenceJPAConfigTest;
import com.project.calc.entity.Data;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfigTest.class)
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
		Data data = new Data();
		data.setParamA(2.5);
		dataDAO.save(data);
		List<Data> datas = dataDAO.findAll();
		assertEquals(2.5, datas.get(0).getParamA(), 0.01);
	}
}
