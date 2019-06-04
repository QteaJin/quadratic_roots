package com.project.calc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.calc.DAO.DataDAO;
import com.project.calc.entity.Data;

@Service
public class DataServiceImpl implements DataService {
	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

	@Autowired
	private DataDAO dataDAO;

	@Override
	public Data calculateResult(Data data) {
		data = calculation(data);
		if (!saveResultToDB(data)) {
			logger.error("Error save results to DB", new Exception("saveResultToDB with error"));
		}
		return data;
	}

	@Override
	public boolean saveResultToDB(Data data) {
		boolean status = false;
		Data dataTest = dataDAO.save(data);
		if (dataTest != null) {
			status = true;
		}

		return status;

	}

	@Override
	public List<Data> getAllResults() {

		return dataDAO.findAll();
	}

	@Override
	public Data calculation(Data data) {
		double a = data.getParamA();
		double b = data.getParamB();
		double c = data.getParamC();
		double discr;

		discr = b * b - 4 * a * c;

		if (discr > 0) {
			double x1, x2;
			x1 = (-b - Math.sqrt(discr)) / (2 * a);
			x2 = (-b + Math.sqrt(discr)) / (2 * a);
			data.setX1(String.valueOf(x1));
			data.setX2(String.valueOf(x2));
		} else if (discr == 0) {
			double x;
			x = -b / (2 * a);
			data.setX1(String.valueOf(x));
		}

		return data;
	}

}
