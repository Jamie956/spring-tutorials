package org.example.annotation_bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Z {
	private Y y;

	@Autowired
	public void setY(Y y) {
		//debug
		this.y = y;
	}

	public Y getY() {
		return y;
	}
}
