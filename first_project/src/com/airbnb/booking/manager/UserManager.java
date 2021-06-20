package com.airbnb.booking.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.airbnb.booking.ui.UserDisplay;
import com.airbnb.booking.vo.UserInfomation;
import com.airbnb.booking.vo.UserLogin;

/**
 * UI 기능과 완전히 분리하지는 않음.
 * @author HYUK
 */
public class UserManager {
	
	private final static String USER_INFO_PATH;
	private final static String LEFT_BLANK;
	private final static String MENU_BLANK;
	private final static String LOGIN_BLANK;
	private final static String USER_BLANK;
	UserLogin log = new UserLogin();
	UserDisplay pr = new UserDisplay();
	Scanner sc = new Scanner(System.in);
	ArrayList<UserInfomation> userList = new ArrayList<UserInfomation>();
	
	static {
		USER_INFO_PATH = "data\\user_infomation.txt";
		LEFT_BLANK = "\t\t\t\t\t\t";
		MENU_BLANK = "\t\t\t";
		LOGIN_BLANK = LEFT_BLANK + MENU_BLANK + "\t\t\t▷";
		USER_BLANK = LEFT_BLANK + MENU_BLANK + "\t\t\t▶";	
	}
	
	/**
	 * (회원가입이라는 건)
	 * UserInformation user = new UserInformation()까지는 회원가입이 아님.
	 * userList.add( user ) 할 때가 실제 회원가입이 이루어지는 순간이라는 것.
	 * 
	 * 이런 동작을 이해해야 함.
	 */
	public void joinUser() {
		
		UserInfomation user = new UserInfomation();
		
		//아이디,패스워드,이름,나이,성별,국가,지역,이메일,전화번호,가입일자
		
		showUserList();
		
		// id가 존재한다면 재입력
		String userId = null;
		while(true) {
			System.out.print(LOGIN_BLANK + "아이디 입력: ");
			userId = sc.nextLine();
			
			if( hasDuplicateId(userId) ) {
				System.out.print(LOGIN_BLANK + "아이디 중복");
				continue;
			}
			break;
		}
		
		user.setId(userId);
		
		String userPw = input( LOGIN_BLANK + "비밀번호 입력: " );
		user.setPassword( userPw );
		
		String userName = input( LOGIN_BLANK + "이름 입력: ");
		user.setName( userName );
		
		int userAge = inputInt( LOGIN_BLANK + "나이 입력: ");
		user.setAge( userAge );
		
		String userGender;
		do {
			userGender = input( LOGIN_BLANK + "성별 입력( M / W): ");
		}while( userGender.equals("M") || userGender.equals("W") );
		user.setGender( userGender );
		
		String userCountry = input( LOGIN_BLANK + "국적 입력: ");
		user.setCountry( userCountry );
		
		String userCity = input ( LOGIN_BLANK + "지역 입력: ");
		user.setCity( userCity );
		
		String userEmail = input ( LOGIN_BLANK + "이메일 입력: ");
		user.setEmail( userEmail );
		
		String userTel = input ( LOGIN_BLANK + "전화번호 입력: ");
		user.setTel( userTel );
		
		System.out.printf(LOGIN_BLANK + "'%s'님 회원 가입이 완료 되었습니다. ^^  ", userName);
		saveUserList(userId, userPw, userName, userAge, userGender, userCountry, userCity, userEmail, userTel);
		
		System.out.print(LOGIN_BLANK + "잠시 후 첫 화면으로 돌아갑니다.");
		pr.displayDelay();

		return;
		
	}// join User();

	/** 사용자 로그인 화면 */
	public void login() {
		
		String userId = input ( LOGIN_BLANK + "아이디를 입력하세요: " );
		String userPw = input ( LOGIN_BLANK + "비밀번호를 입력하세요: " );
		
		showUserList();
		
		for(UserInfomation us : userList) {
			if(us.getId().equals(userId) && us.getPassword().equals(userPw)) {
				System.out.print(USER_BLANK + us.getName() + "님이 로그인에 성공 하셨습니다.");
				log.login(userId);
			}
		}
		
	}// login()
		
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
	
	/** 신규 등록된 사용자 정보 저장 하기(USER_INFO_PATH) */
	public void saveUserList(	String id, String password, String name, int age,
								String gender, String country, String city, String email, String tel) {
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd");
		String regDate = nowDate.format(now.getTime());

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(USER_INFO_PATH, true));
			writer.write(	id + "," + password + "," + name + "," + age + "," + gender + "," + country + "," +
							city + "," + email + "," + tel	+ "," + regDate);
			writer.newLine();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // saverUserList()
	
	// ■■■■■■■■■■■■■■■■■■■■■■■■ PRIVATE METHODS ■■■■■■■■■■■■■■■■■■■■■■■■

	// TODO id 중복 시 되돌아가는 것이 안되고 바로 비밀번호 입력으로 넘어감. 수정필요
	/** 아이디 중복 검사 */
	private boolean hasDuplicateId( String id ) {
		
		for(UserInfomation us : userList) {
			return us.getId().equals( id );
		}
		
		return true;
	}
	
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
	
}//END::public class
