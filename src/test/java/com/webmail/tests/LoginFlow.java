package com.webmail.tests;

import org.testng.annotations.Test;

import com.webmail.keywords.MyKeywords;

public class LoginFlow {

	MyKeywords mk = new MyKeywords();

	@Test
	public void loginFlow(){

		mk.ExecutionStarts("login");
	}

}
