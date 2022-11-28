package org.example.annotation_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Z {
	private X x;

	@Autowired
	public void setX(X x) {
		this.x = x;
	}

}
