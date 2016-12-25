/**
 * テスト用実装クラスとして試験的な実装を提供する。<p>
 */
package com.mit.utils.dummy.impl;

import com.mit.utils.dummy.IDummy;

/**
 * ハローワールドを提供する。<p>
 * @author Kappappa
 *
 */
public class Dummy implements IDummy {
	

	/* (非 Javadoc)
	 * @see com.mit.utils.dummy.impl.IDummy#helloWorld()
	 */
	@Override
	public String helloWorld(){
		return "HelloWorld !";
		
	}
	
}
