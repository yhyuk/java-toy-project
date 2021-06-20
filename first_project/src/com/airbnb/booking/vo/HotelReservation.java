package com.airbnb.booking.vo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airbnb.booking.ui.HotelReservationDisplay;
import com.airbnb.booking.ui.UserDisplay;
/**
 * 사용자의 호텔 예약 서비스
 * 
 * @author hyuk
 */
public class HotelReservation {
	
	HotelReservationDisplay hrd = new HotelReservationDisplay();
	
	Scanner sc = new Scanner(System.in);
	String country, city, hotelName, roomName;
	
	private final static String HOTEL_INFO_PATH;
	private final static String LEFT_BLANK;
	private final static String MENU_BLANK;
	
	ArrayList<HotelInfomation> hotelList = new ArrayList<HotelInfomation>();
	ArrayList<String> countryList = new ArrayList<String>();	
	
	static {
		LEFT_BLANK = "\t\t\t\t\t\t\t";
		MENU_BLANK = "\t\t\t\t";
		HOTEL_INFO_PATH = "data\\hotel_Infomation.txt";
	}

	
	public void reservation() {
		searchCountry();
	}
	
	/** 사용자의 예약할 국가 선택 */
	public void searchCountry() {
				
		showHotelList();
		
		hrd.blank();
		hrd.introDisplay();
		
		country = input( LEFT_BLANK + MENU_BLANK + "● 국가를 검색하세요 [예 : KOREA / USA··] : " );
		hrd.countryListDisplay(country);
		searchCity();
	}
	
	/** 사용자의 예약할 도시 선택 */
	public void searchCity() {
		city = input ( LEFT_BLANK + MENU_BLANK + "● 도시를 검색하세요 [예 : SEOUL / LONDON··] : " );
		hrd.cityListDisplay(city);
		selectHotel();
	}
	
	private void selectHotel() {
		hotelName = input ( LEFT_BLANK + MENU_BLANK + "● 호텔을 선택하세요. : " );
		hrd.selectHotelDisplay(hotelName);
		selectRoom();
	}

	private void selectRoom() {
		roomName = input ( LEFT_BLANK + MENU_BLANK + "● 객실을 선택하세요. : " );
		hrd.selectRoomDisplay(roomName);
		
	}

	//TODO 국가검색 유효성 검사 메소드 만들어야함.. hrd클래스에 만들지, 여기에 만들지 생각해보기!
	public void countryCheck(String country) {
		
		for (HotelInfomation ho : hotelList) {
			if(ho.getCountry().equals(country)) {
				countryList.add(ho.getHotelClass());
				
			} else {
				input ( LEFT_BLANK + "● 검색 결과 일치하는 국가가 없습니다." );
				break;
			}
			
		}		
	}
	
	/** 전체 호텔 목록 가져오기(HOTEL_INFO_PATH) */
	public void showHotelList() {
		
		hotelList.clear();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(HOTEL_INFO_PATH))) {
			
			String temp;
			while ((temp = reader.readLine()) != null) {
				String[] data = temp.split(",");
				hotelList.add(new HotelInfomation(data[0], data[1], data[2], data[3], data[4]));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// showHotelList()

	
	
	// ■■■■■■■■■■■■■■■■■■■■■■■■ PRIVATE METHODS ■■■■■■■■■■■■■■■■■■■■■■■■
	/** 콘솔 입력(문자열) */
	private String input(String msg) {
		System.out.print( msg );
		return sc.nextLine();
	}
	
	/** 콘솔 입력(정수) */
	private int inputInt(String msg) {
		while(true) {
			System.out.print( msg );
			try {
				return sc.nextInt();
			} catch ( NumberFormatException e ) {
				e.printStackTrace();
			} finally {
				// 버퍼 비우기
				sc.nextLine();
			}
		}
	}

}
