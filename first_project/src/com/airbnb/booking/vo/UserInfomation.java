package com.airbnb.booking.vo;

public class UserInfomation {
	
	private String id;
	private String password;
	private String name;
	private int age; 
	private String gender;
	private String country;
	private String city;
	private String email;
	private String tel;
	private String regDate;
	
	
	public UserInfomation () { }
	
	public UserInfomation(	String id, String password, 
							String name, int age, String gender, 
							String country, String city, String email, String tel,
							String regDate) {
	
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.country = country;
		this.city = city;
		this.email = email;
		this.tel = tel;
		this.regDate = regDate;
	
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	

}
