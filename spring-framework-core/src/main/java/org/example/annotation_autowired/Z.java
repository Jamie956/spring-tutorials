package org.example.annotation_autowired;

import org.example.share.EmptyObject;
import org.springframework.beans.factory.annotation.Autowired;

public class Z {
	private EmptyObject emptyObject;
	@Autowired
	public void setEmptyObject(EmptyObject emptyObject) {
		this.emptyObject = emptyObject;
	}
}
