package org.example.annotation_value2;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class MyEditor extends PropertyEditorSupport implements PropertyEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		B b = new B();
		b.name = text;
		this.setValue(b);
	}
}
