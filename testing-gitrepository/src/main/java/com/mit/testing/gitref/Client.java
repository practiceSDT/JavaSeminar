package com.mit.testing.gitref;

import com.mit.utils.dummy.IDummy;
import com.mit.utils.dummy.impl.Dummy;

public class Client {

	public static void main(String[] args) {
		
		IDummy tes = new Dummy();
		System.out.println(tes.helloWorld());

	}

}
