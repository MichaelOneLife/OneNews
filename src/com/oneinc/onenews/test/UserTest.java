package com.oneinc.onenews.test;

import org.junit.Test;

import com.oneinc.onenews.entity.User;

public class UserTest {
	@Test
	public void userTest() {
		User user = new User();
		user.setId(1);
		System.out.println(user);
	}
}
