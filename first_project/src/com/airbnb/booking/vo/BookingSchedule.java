package com.airbnb.booking.vo;

import java.util.Calendar;

public class BookingSchedule {
	
	/** 예약한 객실(호텔별 구분 가능) */
	private HotelRoom room;
	/** 예약한 사용자 */
	private UserInfomation user;
	/** 예약 신청이 이루어진 일시 */
	private Calendar resDate;
	/** 숙박 체크인(날짜 및 시간) */
	private Calendar hotelCheckIn;
	/** 숙박 체크아웃(날짜 및 시간) */
	private Calendar hotelCheckOut;
	/** 총 숙박비 */
	private int hotelTotalPrice;
	
	
	
}
