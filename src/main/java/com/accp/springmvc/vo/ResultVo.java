package com.accp.springmvc.vo;



public class ResultVo {
	

	public ResultVo() {
		super();
	}
	
	private scoreVo result;

	

	@Override
	public String toString() {
		return "ResultVo [result=" + result + "]";
	}

	public scoreVo getResult() {
		return result;
	}

	public void setResult(scoreVo result) {
		this.result = result;
	}

	
	

}
