package com.project.calc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.calc.config.PersistenceJPAConfig;
import com.project.calc.entity.Data;
import com.project.calc.service.DataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class DataServiceTest {

	@Autowired
	private DataService dataService;

	@Test
	public void calculationResultTwoRoots() {
		Data data = new Data();
		data.setParamA(1);
		data.setParamB(-2);
		data.setParamC(-3);

		data = dataService.calculation(data);
		assertEquals("-1.0", data.getX1());
		assertEquals("3.0", data.getX2());
	}

	@Test
	public void calculationResultOneRoot() {
		Data data = new Data();
		data.setParamA(1);
		data.setParamB(12);
		data.setParamC(36);

		data = dataService.calculation(data);
		assertEquals("-6.0", data.getX1());
		assertNull(data.getX2());
	}

	@Test
	public void calculationResultWithoutRoots() {
		Data data = new Data();
		data.setParamA(3);
		data.setParamB(5);
		data.setParamC(10);

		data = dataService.calculation(data);
		assertNull(data.getX1());
		assertNull(data.getX2());
	}

	@Test
	public void recieveAllDatasFromDB() {
		Data data = new Data();
		data.setParamA(1);
		data.setParamB(-2);
		data.setParamC(-3);

		data = dataService.calculation(data);
		dataService.saveResultToDB(data);
		assertFalse(dataService.getAllResults().isEmpty());
	}
	@Test
	public void calculationResultNull() {
		Data data = null;

		data = dataService.calculation(data);
		assertNull(data.getX1());
		assertNull(data.getX2());
	}
}
