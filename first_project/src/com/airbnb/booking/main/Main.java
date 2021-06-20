package com.airbnb.booking.main;

import java.util.*;

import com.airbnb.booking.manager.UserManager;
import com.airbnb.booking.ui.UserDisplay;
import com.airbnb.booking.vo.UserInfomation;


public class Main {
	
	
	private static UserDisplay pr = new UserDisplay();
	private static Scanner sc = new Scanner(System.in);
	private static UserManager userData = new UserManager();
	
	public static void main(String[] args) {
		
		int ch;
		while(true) {
			
			System.out.print(pr.mainScreen());
			System.out.print(pr.loginScreen());
			
			ch = sc.nextInt();
			
			switch(ch) {
				case 1: userData.joinUser(); break; //회원가입
				case 2: userData.login(); break; //사용자 로그인
				case 3: break; //관리자 로그인
				case 4: break; //프로그램 종료
			} 
		}
		
	}
}
