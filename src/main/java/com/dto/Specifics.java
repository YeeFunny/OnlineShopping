package com.dto;

import java.util.Map;

public class Specifics {

	private Integer specificsNameId;
	private String specificsName;
	private Map<Integer, String> specificsValue;

	public Integer getSpecificsNameId() {
		return specificsNameId;
	}

	public void setSpecificsNameId(Integer specificsNameId) {
		this.specificsNameId = specificsNameId;
	}

	public String getSpecificsName() {
		return specificsName;
	}

	public void setSpecificsName(String specificsName) {
		this.specificsName = specificsName;
	}

	public Map<Integer, String> getSpecificsValue() {
		return specificsValue;
	}

	public void setSpecificsValue(Map<Integer, String> specificsValue) {
		this.specificsValue = specificsValue;
	}

}
