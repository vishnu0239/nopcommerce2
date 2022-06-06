package com.nopcommerce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

		Properties pro;
		public Readconfig() {

		File src=new File("./configuration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
		System.out.println("Exception is"+e.getMessage());
	}
	}
		public String getURL() {
			String url=pro.getProperty("baseURL");
			return url;
		}
		public String getuname() {
			String username=pro.getProperty("username");
			return username;
		}
		public String getpword() {
			String password=pro.getProperty("password");
			return password;
		}
	}