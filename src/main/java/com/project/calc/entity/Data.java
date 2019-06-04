package com.project.calc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data implements Serializable {
	private long id;
	private double paramA;
	private double paramB;
	private double paramC;
	private String x1;
	private String x2;

	public Data() {
	}

	public Data(long id, double paramA, double paramB, double paramC, String x1, String x2) {

		this.paramA = paramA;
		this.paramB = paramB;
		this.paramC = paramC;
		this.x1 = x1;
		this.x2 = x2;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getParamA() {
		return paramA;
	}

	public void setParamA(double paramA) {
		this.paramA = paramA;
	}

	public double getParamB() {
		return paramB;
	}

	public void setParamB(double paramB) {
		this.paramB = paramB;
	}

	public double getParamC() {
		return paramC;
	}

	public void setParamC(double paramC) {
		this.paramC = paramC;
	}

	public String getX1() {
		return x1;
	}

	public void setX1(String x1) {
		this.x1 = x1;
	}

	public String getX2() {
		return x2;
	}

	public void setX2(String x2) {
		this.x2 = x2;
	}

}
