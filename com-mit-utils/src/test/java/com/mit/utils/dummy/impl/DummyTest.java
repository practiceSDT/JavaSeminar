package com.mit.utils.dummy.impl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.mit.utils.dummy.IDummy;

public class DummyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@InjectMocks
	private IDummy target = new Dummy();

	@Test
	public void testname() throws Exception {
		
		List<String> mockedList = mock(List.class);
		mockedList.add("one");
		mockedList.clear();
		
		verify(mockedList).add("one");
		verify(mockedList).clear();
		
		LinkedList<String> mockedLinkList = mock(LinkedList.class);

		when(mockedLinkList.get(0)).thenReturn("first");
		when(mockedLinkList.get(1)).thenThrow(new RuntimeException());
		
		assertThat(target.helloWorld(), is("HelloWorld !"));
	}
	
	@Test
	public void helloWorldTest() throws Exception {
		
		
		
	}

}
