package com.accp.springmvc.pojo;
/**
 * 审查结果表(check_result)			
 * @author 小虎
 *
 */
public class CheckResult {
	//结果编号
	private Integer resultId;
	//结果名称
	private String resultName;
	
	public Integer getResultId() {
		return resultId;
	}
	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
	public String getResultName() {
		return resultName;
	}
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	public CheckResult() {
		super();
	}
	public CheckResult(Integer resultId, String resultName) {
		super();
		this.resultId = resultId;
		this.resultName = resultName;
	}
	@Override
	public String toString() {
		return "CheckResult [resultId=" + resultId + ", resultName=" + resultName + "]";
	}
	
	
	

}
