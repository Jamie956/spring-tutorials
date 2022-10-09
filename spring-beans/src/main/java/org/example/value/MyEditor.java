package org.example.value;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class MyEditor extends PropertyEditorSupport implements PropertyEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		B b = new B();
		b.setName(text);
		this.setValue(b);
	}
}
