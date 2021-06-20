package com.airbnb.booking.vo;

public class HotelRoom {
	
	/** 호텔 식별 코드 ref ==> com.airbnb.booking.vo.HoteInfomation.hotelCode */
	private String hotelCode;
	/** 객실 표현 이름 */
	private String hotelRoomName;
	/** 객실 숙박 가격(1일당) */
	private int hotelPrice;
	
	public HotelRoom ( String hotelCode, String hotelRoomName, int hotelPrice) {
		this.hotelCode = hotelCode;
		this.hotelRoomName = hotelRoomName;
		this.hotelPrice = hotelPrice;
	}

	public String getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}

	public String getHotelRoomName() {
		return hotelRoomName;
	}

	public void setHotelRoomName(String hotelRoomName) {
		this.hotelRoomName = hotelRoomName;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	

}
