/**
 * 
 */
package com.mit.utils.dummy.impl;

import com.mit.utils.dummy.IContainer;
import com.mit.utils.dummy.IDummy;

import lombok.Builder;

/**
 * @author Kappappa
 *
 */
@Builder
public class Container implements IContainer {

	private SampleData sampleData;
	
	/* (非 Javadoc)
	 * @see com.mit.utils.dummy.impl.IContainer#createMes(com.mit.utils.dummy.IDummy)
	 */
	@Override
	public String createMes(IDummy iDummy){
		return sampleData.getWord() + " " + iDummy.helloWorld();
	}
	
}
