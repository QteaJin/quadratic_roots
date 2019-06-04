package com.project.calc.service;

import java.util.List;

import com.project.calc.entity.Data;

public interface DataService {

	Data calculation(Data data);

	Data calculateResult(Data data);

	boolean saveResultToDB(Data data);

	List<Data> getAllResults();

}
