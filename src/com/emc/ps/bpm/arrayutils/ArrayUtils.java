package com.emc.ps.bpm.arrayutils;

import com.documentum.fc.client.IDfModule;
import com.documentum.fc.common.DfException;

public interface ArrayUtils extends IDfModule {
	String[] removeEmptyElements(String[] elements, Options options) throws DfException;
	String[] merge(Arrays[] inputs, Options options) throws DfException;
}
