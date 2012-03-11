package com.emc.ps.bpm.arrayutils;

import java.util.ArrayList;
import java.util.List;

import com.documentum.fc.client.DfSingleDocbaseModule;
import com.documentum.fc.common.DfException;

public class ArrayUtilsImpl extends DfSingleDocbaseModule implements ArrayUtils {

	/**
	 * @throws DfException 
	 * 
	 */
	public String[] removeEmptyElements(final String[] elements, Options options) throws DfException {
		if (options == null) {
			options = new Options();
		}
		if (elements == null || elements.length == 0) {
			return new String[0];
		}
		List<String> result = new ArrayList<String>();
		try {
			processElements(result, elements, options);
		} catch(RuntimeException e) {
			throw new DfException("RuntimeException", e);
		}
		return result.toArray(new String[result.size()]);
	}

	/**
	 * @throws DfException 
	 * 
	 */
	public String[] merge(final Arrays[] inputs, Options options) throws DfException {
		if (options == null) {
			options = new Options();
		}
		if (inputs == null || inputs.length == 0) {
			return new String[0];
		}
		List<String> result = new ArrayList<String>();
		try {
			for(int ix = 0; ix < inputs.length; ++ix) {
				Arrays array = inputs[ix];
				if (array != null) {
					String[] elements = array.getArray();
					if (elements != null && elements.length > 0) {
						processElements(result, elements, options);
					}
				}
			}
		} catch(RuntimeException e) {
			throw new DfException("RuntimeException", e);	
		}
		return result.toArray(new String[0]);
	}

	private void processElements(List<String> result, final String[] elements, final Options options) {
		for(int jx = 0; jx < elements.length; ++jx) {
			String element = elements[jx];
			processElement(result, element, options);
		}
	}

	private void processElement(List<String> result, final String element, final Options options) {
		if (isEmpty(element, options)) {
			if (options.getKeepEmptyElements()) {
				addElement(result, element, options);
			}	
		} else {
			addElement(result, element, options);
		}
	}

	private void addElement(List<String> result, final String element, final Options options) {
		String processedElement = transformElement(element, options);
		result.add(processedElement);
	}
	
	private boolean isEmpty(final String element, final Options options) {
		if (element == null) {
			return true;
		}
		String processedElement = element.trim();
		if (options.getCheckElementLength()) {
			return processedElement == null || processedElement.length() == 0;
		} else {
			return processedElement == null;
		}
	}
	
	private String transformElement(final String element, final Options options) {
		if (options.getTrimWhitespace()) {
			return element.trim();
		}
		return element;
	}
}