package com.airbnb.booking.vo;

public class HotelInfomation {
	
	/** 호텔 식별 코드 */
	private String hotelCode;
	private String hotelName;
	private String hotelClass;
	private String country;
	private String city;
	
	
	public HotelInfomation () { }
	public HotelInfomation ( 	String hotelCode, String hotelName, String hotelClass,
								String country, String city) {
		this.hotelCode = hotelCode;
		this.hotelName = hotelName;
		this.hotelClass = hotelClass;
		this.country = country;
		this.city = city;
	}
	
	public String getHotelCode() {
		return hotelCode;
	}
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelClass() {
		return hotelClass;
	}
	public void setHotelClass(String hotelClass) {
		this.hotelClass = hotelClass;
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

}
