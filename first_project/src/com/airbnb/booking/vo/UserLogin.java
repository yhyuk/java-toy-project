package com.airbnb.booking.vo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import com.airbnb.booking.ui.UserDisplay;
/**
 * 
 * @author hyuk
 *
 */
public class UserLogin {

	private final static String USER_INFO_PATH;
	private final static String LEFT_BLANK;
	private final static String MENU_BLANK;
	private final static String LOGIN_BLANK;
	private final static String USER_BLANK;
	
	private static HotelReservation hr = new HotelReservation();
	private static UserDisplay pr = new UserDisplay();
	private static Scanner sc = new Scanner(System.in);
	private static UserInfomation user;
	private static ArrayList<UserInfomation> userList = new ArrayList<UserInfomation>();
	
	static {
		USER_INFO_PATH = "data\\user_infomation.txt";
		LEFT_BLANK = "\t\t\t\t\t\t";
		MENU_BLANK = "\t\t\t";
		LOGIN_BLANK = LEFT_BLANK + MENU_BLANK + "\t\t\t▷";
		USER_BLANK = LEFT_BLANK + MENU_BLANK + "\t\t\t▶";
	}
	
	static String ch;
	// TODO 예약, 예약관리, 로그아웃
	/** 사용자 로그인 후 선택 할 수 있는 메인 화면*/
	public void login(String userid) {
		
		System.out.print(pr.mainScreen());
		System.out.print(pr.userId(userid));
		System.out.print(pr.userMenu());
		
		ch = sc.nextLine();
		
		boolean flag = true;
		while(flag) {
			switch(ch) {
				case "1": userMyPage(userid); break; //내 계정
				case "2": hr.reservation(); break; //예약
				case "3": break; //예약관리
				case "4": break; //로그아웃
			}                
		}
	} // login()
	
	// TODO 내 계정 확인하기, 내 정보 수정하기, 뒤로가기
	/** 사용자 정보 관리하기 */
	public void userMyPage(String userid) {
		
		System.out.print(pr.userInfoDisplay());
		ch = sc.nextLine();
		
		while(true) {
			switch(ch) {
				case "1": selectMyAcoount(userid); break; //내 정보 확인하기
				case "2": modifyMyAccount(userid); break; //내 정보 수정하기
				case "3": break; //뒤로 가기
			}
		}
		
	} //userMyPage()

	
	// ■■■■■■■■■■■■■■■■■■■■■■■■ PRIVATE METHODS ■■■■■■■■■■■■■■■■■■■■■■■■
	
	// TODO 정보 변경 구현은 했는데 테스트 해봐야함..
	// TODO 각 카테고리에서 입력받는 변수 ch 자료형 String으로 변경 -> nextInt -> nextLine
	
	/** 사용자의 정보 변경 하기 */
	private void modifyMyAccount(String userid) {
		
		showUserList();
		for (UserInfomation us : userList) {
			if(us.getId().equals(userid)) {
				
				String userPw = input( LOGIN_BLANK + "비밀번호 변경: " );
				us.setPassword( userPw );
				
				String userName = input( LOGIN_BLANK + "이름 변경: ");
				us.setName( userName );
				
				int userAge = inputInt( LOGIN_BLANK + "나이 변경: ");
				us.setAge( userAge );
				
				String userGender;
				do {
					userGender = input( LOGIN_BLANK + "성별 변경( M / W): ");
				}while( userGender.equals("M") || userGender.equals("W") );
				us.setGender( userGender );
				
				String userCountry = input( LOGIN_BLANK + "국적 변경: ");
				us.setCountry( userCountry );
				
				String userCity = input ( LOGIN_BLANK + "지역 변경: ");
				us.setCity( userCity );
				
				String userEmail = input ( LOGIN_BLANK + "이메일 변경: ");
				us.setEmail( userEmail );
				
				String userTel = input ( LOGIN_BLANK + "전화번호 변경: ");
				us.setTel( userTel );
				
				System.out.printf(LOGIN_BLANK + "'%s'님 개인 정보 변경이 완료 되었습니다. ^^  ", userName);
				
				saveMyAccount();
				
				System.out.print(LOGIN_BLANK + "잠시 후 첫 화면으로 돌아갑니다.");
				pr.displayDelay();

			}
		}
		
	}
	
	/** 변경된 사용자 정보 저장 하기(USER_INFO_PATH) */
	private void saveMyAccount() {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_INFO_PATH))) {
			
			for (UserInfomation us : userList) {
				writer.write(String.format("%s,%s,%s,%d,%s,%s,%s,%s,%s,%s", 
								us.getId(), 	us.getPassword(), 	us.getName(), us.getAge(),
								us.getGender(), us.getCountry(), 	us.getCity(), us.getEmail(),
								us.getTel(), 	us.getRegDate())
							);
				writer.newLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // saverUserList();

	/** 사용자의 정보 상세 보기 */
	private void selectMyAcoount(String userid) {
		
		showUserList(); 
		
		// ┳ ┻ ┗ ┛ ┏ ┓
		System.out.print(MENU_BLANK + "■━━━━━━━━━━━┳━━━━━━━━━━━┳━━━━━━━━┳━━━━━┳━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓\n");
		System.out.printf(MENU_BLANK + "┃%10s ┃%10s ┃ %5s  ┃ %3s ┃ %2s ┃ %10s ┃%10s ┃%20s ┃%15s ┃%15s ┃\n",
										"ID", "PW", "NAME", "AGE", "GENDER", "COUNTRY", "CITY", "EMAIL", "TEL", "REGDATE");
		System.out.print(MENU_BLANK + "┣━━━━━━━━━━━╋━━━━━━━━━━━╋━━━━━━━━╋━━━━━╋━━━━━━━━╋━━━━━━━━━━━━╋━━━━━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━━┫\n");

		for (UserInfomation us : userList) {
			if(us.getId().equals(userid)) {
				System.out.printf(MENU_BLANK + "┃%10s ┃%10s ┃%4s ┃%3s  ┃ %4s   ┃%10s  ┃%10s ┃%20s ┃%15s ┃%15s ┃\n",
						us.getId(), us.getPassword(), us.getName(), us.getAge(), us.getGender(), us.getCountry(),
						us.getCity(), us.getEmail(), us.getTel(), us.getRegDate());
				System.out.print(MENU_BLANK + "┗━━━━━━━━━━━┻━━━━━━━━━━━┻━━━━━━━━┻━━━━━┻━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┛\n");
			}
		}
		int ck;
		do {
			System.out.print(pr.backward());
			ck = sc.nextInt();
			switch (ck) {
				case 1: break;
			}
		} while( ck < 1 || ck >1 );

	} // selectMyAccount()
	
	/** 콘솔 입력(문자열) */
	private String input(String msg) {
		System.out.print( msg );
		return sc.nextLine();
	}// String input(String msg)
	
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
	}// int inputInt(String msg)

	/** 전체 유저 목록 가져오기(USER_INFO_PATH) */
	public void showUserList() {
		
		userList.clear();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(USER_INFO_PATH))) {
			
			String temp;
			while ((temp = reader.readLine()) != null) {
				String[] data = temp.split(",");
				
				userList.add(new UserInfomation(
						data[0],data[1],data[2],
						Integer.parseInt(data[3]),data[4],data[5],
						data[6], data[7], data[8], data[9]) 
						);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// showUserList()


}
