package com.accp.springmvc.vo;

import java.util.Arrays;

public class scoreVo {
	
	@Override
	public String toString() {
		return "scoreVo [face_liveness=" + face_liveness + ", score=" + score + ", face_list="
				+ Arrays.toString(face_list) + "]";
	}

	private Double face_liveness;
	
	public Double getFace_liveness() {
		return face_liveness;
	}

	public void setFace_liveness(Double face_liveness) {
		this.face_liveness = face_liveness;
	}

	private Double score;
	
	private String[] face_list;
	
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String[] getFace_list() {
		return face_list;
	}

	public void setFace_list(String[] face_list) {
		this.face_list = face_list;
	}

	public scoreVo(Double score, String[] face_list) {
		super();
		this.score = score;
		this.face_list = face_list;
	}

	public scoreVo() {
		super();
	}
}
