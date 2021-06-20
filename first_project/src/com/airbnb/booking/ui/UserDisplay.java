package com.airbnb.booking.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.airbnb.booking.vo.UserInfomation;

public class UserDisplay {
	
	private final static String LEFT_BLANK;
	private final static String UP_BLANK;
	private final static String MENU_BLANK;
	private final static String USER_INFO_PATH;
	
	UserInfomation user;
	ArrayList<UserInfomation> userList = new ArrayList<UserInfomation>();

	static {
		USER_INFO_PATH = "data\\user_infomation.txt";
		LEFT_BLANK = "\t\t\t\t\t\t";
		UP_BLANK = "\n\n\n";
		MENU_BLANK = "\t\t\t";
	}

	public String mainScreen() { // 메뉴 로고
		return String.format(
				UP_BLANK +
				UP_BLANK +
				UP_BLANK +
				UP_BLANK +
				UP_BLANK +
				UP_BLANK +
				LEFT_BLANK + "■━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				LEFT_BLANK + "┃                                                                                                                           ┃\n" +    
				LEFT_BLANK + "┃                                                                                                                           ┃\n" + 
				LEFT_BLANK + "┃  ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗     █████╗ ██╗██████╗ ██████╗ ███╗   ██╗██████╗    ██╗██╗ ┃\n" + 
				LEFT_BLANK + "┃  ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ██╔══██╗██║██╔══██╗██╔══██╗████╗  ██║██╔══██╗   ██║██║ ┃\n" + 
				LEFT_BLANK + "┃  ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗      ███████║██║██████╔╝██████╔╝██╔██╗ ██║██████╔╝   ██║██║ ┃\n" +
				LEFT_BLANK + "┃  ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝      ██╔══██║██║██╔══██╗██╔══██╗██║╚██╗██║██╔══██╗   ╚═╝╚═╝ ┃\n" +
				LEFT_BLANK + "┃  ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗    ██║  ██║██║██║  ██║██████╔╝██║ ╚████║██████╔╝   ██╗██╗ ┃\n" + 
				LEFT_BLANK + "┃   ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝    ╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═══╝╚═════╝    ╚═╝╚═╝ ┃\n" +
				LEFT_BLANK + "┃                                                                                                                           ┃\n" +    
				LEFT_BLANK + "┃                                                                                                                           ┃\n" +                                               
				LEFT_BLANK + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
	}
				
	public String loginScreen() {
		return String.format(
				LEFT_BLANK + MENU_BLANK + "      ■━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━┓\n" +
				LEFT_BLANK + MENU_BLANK + "      ┃ 1. 회원가입 ┃ 2. 사용자 로그인 ┃  3. 관리자 로그인 ┃ 4. 종료  ┃\n" +                                               
				LEFT_BLANK + MENU_BLANK + "      ┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━┛\n" +
				LEFT_BLANK + MENU_BLANK + "                               ■입력: ");

	}
	
	public String userId(String userId) {
		showUserList();
		String name = null;
		for (UserInfomation my : userList) {
			if(my.getId().equals(userId)) {
				name = my.getName();
			}
		}
		
		return String.format(
				LEFT_BLANK + LEFT_BLANK + "    ■━━━━━━━━━━━━━━━━━━━━┓\n" +
				LEFT_BLANK + LEFT_BLANK + "    ┃      %s님      ┃\n" +                                               
				LEFT_BLANK + LEFT_BLANK + "    ┗━━━━━━━━━━━━━━━━━━━━┛\n", name);
	}
	
	public String userMenu() {
		return String.format(
				LEFT_BLANK + MENU_BLANK + "      ■━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┓\n" +
				LEFT_BLANK + MENU_BLANK + "      ┃  1. 내 계정   ┃    2. 예약    ┃  3. 예약관리  ┃  4. 로그아웃  ┃\n" +                                               
				LEFT_BLANK + MENU_BLANK + "      ┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┛\n" +
				LEFT_BLANK + MENU_BLANK + "                               ■입력: ");

	}
	
	public String userInfoDisplay() {
		return String.format(
				LEFT_BLANK + MENU_BLANK + "      ■━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━┓\n" +
				LEFT_BLANK + MENU_BLANK + "      ┃  1. 내 정보 보기   ┃   2. 내 정보 수정  ┃       3. 뒤로       ┃\n" +                                               
				LEFT_BLANK + MENU_BLANK + "      ┗━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━┛\n" +
				LEFT_BLANK + MENU_BLANK + "                               ■입력: ");

	}
	
	public String backward() {
		return String.format(
				LEFT_BLANK + MENU_BLANK + "      ■━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				LEFT_BLANK + MENU_BLANK + "      ┃                           1. 뒤로가기                         ┃\n" +                                               
				LEFT_BLANK + MENU_BLANK + "      ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				LEFT_BLANK + MENU_BLANK + "                               ■입력: ");

	}

	/** 콘솔 화면 창 일정시간 대기화면 */
	public void displayDelay() {
		
		for(int i=0; i<6; i++) {
			System.out.print(".");
			try{
			    Thread.sleep(500);
			}catch(InterruptedException e){
			    e.printStackTrace();
			}
		}
		
	}// displayDate()

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
		
	}// static void userInfo()
}
