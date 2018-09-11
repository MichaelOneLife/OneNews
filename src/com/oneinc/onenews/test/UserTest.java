package com.oneinc.onenews.test;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.oneinc.onenews.util.CommonUtil;

public class UserTest {
	@Test
	public void md5Test() {
		String md5 = "";
		try {
			md5 = CommonUtil.md5("michael");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(md5);
	}
}
