package com.airbnb.booking.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.airbnb.booking.vo.HotelInfomation;
import com.airbnb.booking.vo.HotelRoom;

public class HotelReservationDisplay {
	
	private final static String HOTEL_INFO_PATH;
	private final static String LEFT_BLANK;
	private final static String MENU_BLANK;
	private final static String INTRO_BLANK;
	private final static String HOTELROOM_INFO_PATH;
	
	Scanner sc = new Scanner(System.in);
	UserDisplay pr = new UserDisplay();
	ArrayList<HotelInfomation> hotelList = new ArrayList<HotelInfomation>();
	ArrayList<HotelRoom> hotelRoomList = new ArrayList<HotelRoom>();
	
	static {
		LEFT_BLANK = "\t\t\t\t\t\t\t\t";
		MENU_BLANK = "\t\t\t";
		INTRO_BLANK = "\t\t\t\t\t\t";
		HOTEL_INFO_PATH = "data\\hotel_Infomation.txt";
		HOTELROOM_INFO_PATH = "data\\hotel_room.txt";
	}
	
	/** 사용자의 예약 화면에 들어올 시 첫 콘솔 화면 */
	public void introDisplay() {
		
		System.out.print(
				INTRO_BLANK + "■━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				INTRO_BLANK + "┃                                                                                                                                   ┃\n" +
				INTRO_BLANK + "┃  ███╗   ███╗ █████╗ ██╗  ██╗███████╗    ██████╗ ███████╗███████╗███████╗██████╗ ██╗   ██╗ █████╗ ████████╗██╗ ██████╗ ███╗   ██╗  ┃\n" +
				INTRO_BLANK + "┃  ████╗ ████║██╔══██╗██║ ██╔╝██╔════╝    ██╔══██╗██╔════╝██╔════╝██╔════╝██╔══██╗██║   ██║██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║  ┃\n" +
				INTRO_BLANK + "┃  ██╔████╔██║███████║█████╔╝ █████╗      ██████╔╝█████╗  ███████╗█████╗  ██████╔╝██║   ██║███████║   ██║   ██║██║   ██║██╔██╗ ██║  ┃\n" +
				INTRO_BLANK + "┃  ██║╚██╔╝██║██╔══██║██╔═██╗ ██╔══╝      ██╔══██╗██╔══╝  ╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██╔══██║   ██║   ██║██║   ██║██║╚██╗██║  ┃\n" +
				INTRO_BLANK + "┃  ██║ ╚═╝ ██║██║  ██║██║  ██╗███████╗    ██║  ██║███████╗███████║███████╗██║  ██║ ╚████╔╝ ██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║  ┃\n" +
				INTRO_BLANK + "┃  ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝    ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝  ┃\n" +
				INTRO_BLANK + "┃                                                                                                                                   ┃\n" + 
				INTRO_BLANK + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n\n");
	}
	
	
	/** 
	 * 사용자가 예약할 Country의 Hotel 출력하기 
	 * @param country 사용자의 여행 국가 입력
	 * 
	 * 입력받은 값과 일치하는 값이 있을 때 호텔 정보 출력
	 */
	public void countryListDisplay(String country) {
		
		showHotelList();
		int num = 1;
		
		System.out.println();
		System.out.print(	LEFT_BLANK + 
							MENU_BLANK + "■━━━━━┳━━━━━━━━━━━┳━━━━━━━━━┳━━━━━━━━━┳━━━━━━━━┓\n");
		System.out.printf(	LEFT_BLANK + 
							MENU_BLANK + "┃ %3s ┃%10s ┃  %6s ┃%8s ┃%7s ┃\n",
										"No.", "HotelName", "Class", "Country", "City");
		System.out.print(	LEFT_BLANK + 
							MENU_BLANK + "┣━━━━━╋━━━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━┫\n");

		for (HotelInfomation us : hotelList) {
			
			if(us.getCountry().equals(country)) {
				
				System.out.printf(	LEFT_BLANK + 
									MENU_BLANK + "┃ %2d  ┃%10s ┃ %1s Class ┃%8s ┃ %7s┃\n", num++, us.getHotelName(), us.getHotelClass(), us.getCountry(), us.getCity());				
				System.out.print(	LEFT_BLANK + 
									MENU_BLANK + "┣━━━━━╋━━━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━┫\n");
			}
			
		}
		System.out.println();
		
	}
	
	/** 
	 * 사용자가 예약할 국가의 도시 입력
	 * @param city 도시 입력
	 */
	public void cityListDisplay(String city) {
		
		showHotelList();
		int num = 1;
		
		System.out.println();
		System.out.print(	LEFT_BLANK + 
							MENU_BLANK + "■━━━━━┳━━━━━━━━━━━┳━━━━━━━━━┳━━━━━━━━━┳━━━━━━━━┓\n");
		System.out.printf(	LEFT_BLANK + 
							MENU_BLANK + "┃ %3s ┃%10s ┃  %6s ┃%8s ┃%7s ┃\n",
										"No.", "HotelName", "Class", "Country", "City");
		System.out.print(	LEFT_BLANK + 
							MENU_BLANK + "┣━━━━━╋━━━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━┫\n");

		for (HotelInfomation us : hotelList) {
			
			if(us.getCity().equals(city)) {
				
				System.out.printf(	LEFT_BLANK + 
									MENU_BLANK + "┃ %2d  ┃%10s ┃ %1s Class ┃%8s ┃ %7s┃\n", num++, us.getHotelName(), us.getHotelClass(), us.getCountry(), us.getCity());				
				System.out.print(	LEFT_BLANK + 
									MENU_BLANK + "┣━━━━━╋━━━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━┫\n");
			}
			
		}
		System.out.println();
		
	}
	
	/**
	 * 사용자가 예약할 호텔 입력
	 * @param hotelName
	 */
	
	public void selectHotelDisplay(String hotelName) {
		
		showHotelList();
		showHotelRoomList();
		int num = 1;
		
		System.out.println();
		System.out.print(	LEFT_BLANK + 
							MENU_BLANK + "■━━━━━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━┓\n");
		System.out.printf(	LEFT_BLANK + 
							MENU_BLANK + "┃ %3s ┃%10s  ┃%8s ┃\n",
									"No.", "RoomName", "Price");
		System.out.print(	LEFT_BLANK + 
							MENU_BLANK + "┣━━━━━━━━━━━━╋━━━━━━━━━━━━╋━━━━━━━━━┫\n");
		
		for (HotelInfomation us : hotelList) {
			if(us.getHotelName().equals(hotelName)) {
				for (HotelRoom hr : hotelRoomList ) {
					if(us.getHotelCode().equals(hr.getHotelCode())) {
						System.out.printf(	LEFT_BLANK + 
											MENU_BLANK + "┃ %3s ┃%10s  ┃ %,d ┃\n", num++, hr.getHotelRoomName(), hr.getHotelPrice());
						System.out.print(	LEFT_BLANK + 
											MENU_BLANK + "┣━━━━━━━━━━━━╋━━━━━━━━━━━━╋━━━━━━━━━┫\n");
					}
				}
			}
		}
		
	}
	
	/**
	 * 사용자가 예약할 호텔의 객실명 입력하기
	 * 
	 * @param roomNmae
	 * */
	public void selectRoomDisplay(String roomName) {
		blank();
		introDisplay();
	}
	
	/** 콘솔화면 아래로 내리기 */
	public void blank() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	/** 
	 * 전체 호텔 목록 가져오기(HOTEL_INFO_PATH) 
	 * 
	 * hotelCode, hotelName, hotelClass, country, city
	 * 
	 * */
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
	
	/** 
	 * 전체 호텔 세부 목록 가져오기(HOTELROOM_INFO_PATH) 
	 * 
	 * hotelCode, hotelRoomName, hotelPrice
	 * 
	 * */
	public void showHotelRoomList() {
		
		hotelRoomList.clear();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(HOTELROOM_INFO_PATH))) {
			
			String temp;
			while ((temp = reader.readLine()) != null) {
				String[] data = temp.split(",");
				hotelRoomList.add(new HotelRoom(data[0], data[1], Integer.parseInt(data[2])));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// showHotelRoomList()
}
