package com.emc.ps.bpm.arrayutils;

public class Options {

	private boolean checkElementLength = true;
	private boolean keepEmptyElements = false;
	private boolean trimElements = true;
	
	public void setCheckElementLength(boolean value) {
		checkElementLength = value;
	}
	public boolean getCheckElementLength() {
		return checkElementLength;
	}

	public void setKeepEmptyElements(boolean value) {
		keepEmptyElements = value;
	}
	public boolean getKeepEmptyElements() {
		return keepEmptyElements;
	}
	
	public boolean getTrimWhitespace() {
		return trimElements;
	}
	public void setTrimWhitespace(boolean value) {
		trimElements = value;
	}
}
