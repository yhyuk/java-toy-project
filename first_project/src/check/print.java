package yanolja;

public class print { // 메뉴 디자인

	String leftBlank="                                 ";
	String upBlank="\n\n\n";
	String menuBlank="                 ";

	public String rogo() { // 메뉴 로고

		String rogo = upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				leftBlank+"■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" + 
				leftBlank+"┃                                                                                                           ┃\n" + 
				leftBlank+"┃                                 __   __        _   _         _                                            ┃\n" + 
				leftBlank+"┃                                 \\ \\ / /       | \\ | |       | |                                           ┃\n" + 
				leftBlank+"┃                                  \\ V /   __ _ |  \\| |  ___  | | ____  __ _                                ┃\n" + 
				leftBlank+"┃                                   \\ /   / _` || . ` | / _ \\ | ||_  / / _` |                               ┃\n"+ 
				leftBlank+"┃                                   | |  | (_| || |\\  || (_) || | / / | (_| |                               ┃\n" + 
				leftBlank+"┃                                   \\_/   \\__,_|\\_| \\_/ \\___/ |_|/___| \\__,_|                               ┃\n" + 
				leftBlank+"┃                                                                                                           ┃\n" + 
				leftBlank+"┃                                                                                                           ┃\n" + 
				leftBlank+"┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";

		return rogo;

	}

	public String id() { // 현재 로그인 된 아이디 디자인

		
		String id = upBlank +
				leftBlank + leftBlank + "          ■━━━━━━━━┓\n" +
				leftBlank + leftBlank + "              " + Member.member + " 님\n" +
				leftBlank + leftBlank + "          ┗━━━━━━━━┛\n";
		return id;

	}
	
	public String main() { // 로그인 후 메뉴

		String main =
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃   1. 내 계정   ┃    2. 예약    ┃   3. 예약관리   ┃   4. 로그아웃   ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";
		return main;
	}

	public String managerLogo() { // 관리자 로그인 후 로고

		String managerlogo = upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				leftBlank+"■━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" + 
				leftBlank+" ┃               ___  ___                                         ___  ___                                   ┃ \n" + 
				leftBlank+" ┃               |  \\/  |                                         |  \\/  |                                   ┃ \n" + 
				leftBlank+" ┃               | .  . |  __ _  _ __    __ _   __ _   ___  _ __  | .  . |  ___  _ __   _   _                ┃\n" + 
				leftBlank+" ┃               | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__| | |\\/| | / _ \\| '_ \\ | | | |               ┃\n" + 
				leftBlank+" ┃               | |  | || (_| || | | || (_| || (_| ||  __/| |    | |  | ||  __/| | | || |_| |               ┃\n" + 
				leftBlank+" ┃               \\_|  |_/ \\__,_||_| |_| \\__,_| \\__, | \\___||_|    \\_|  |_/ \\___||_| |_| \\__,_|               ┃\n" + 
				leftBlank+" ┃                                              __/ |                                                        ┃\n" + 
				leftBlank+" ┃                                             |___/                                                         ┃\n" + 
				leftBlank+" ┃                                                                                                           ┃\n" + 
				leftBlank+" ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";

		return managerlogo;

	}

	public String managerMenu() { // 관리자 로그인 후 메뉴

		String managermenu = upBlank + 
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + "                              호텔매니져 관리창                           \n" +
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃ 1. 호텔관리 ┃ 2. 호텔 방관리 ┃ 3. 예약관리 ┃ 4. 회원관리 ┃ 5.뒤로 ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";

		return managermenu;
	}

	public String hotelMenu() { // 관리자 - 1. 호텔관리 메뉴

		String hotelmenu = upBlank + 
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + "                                 호텔 관리창                              \n" +
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃ 1. 호텔조회 ┃ 2. 호텔 추가 ┃ 3. 호텔 수정 ┃ 4. 호텔 삭제 ┃ 5.뒤로 ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";

		return hotelmenu;


	}

	public String roomMenu() { // 관리자 - 2. 호텔 방관리 메뉴

		String roommenu = upBlank + 
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + "                               호텔 방 관리창                           \n" +
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃1.호텔 방 조회┃2.호텔 방 추가┃3.호텔 방 수정┃4.호텔 방 삭제┃5. 뒤로┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";

		return roommenu;

	}
	
	public String managerRMMenu() { // 관리자 - 3. 예약관리 메뉴

		String RMmenu = upBlank+
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + "                                  예약 관리                                \n" +
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃ 1. 예약조회 ┃ 2. 예약검색 ┃ 3. 예약 변경 ┃ 4. 예약 취소 ┃ 5. 뒤로 ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";

		return RMmenu;

	}

	public String managerUserMenu() { // 관리자 - 4. 회원관리 메뉴

		String userMenu = upBlank+
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + "                                 회원 관리창                             \n" +
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃ 1. 회원조회 ┃ 2. 회원 검색 ┃ 3. 회원 수정 ┃ 4. 회원삭제 ┃ 5. 뒤로 ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";

		return userMenu;

	}

	public String selectHotel() { // print() 때 사용하는 디스플레이 ?

		String sh = upBlank+
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + "                               호텔코드  방이름                            \n" +
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" ;
		return sh;
	}

	public String printsr() { // print() 후 뒤로가기 ?

		String vprint = upBlank + 
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃                               1. 뒤로가기                             ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";

		return vprint;
	}

	public void blank() { // 윗 공백
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	public void downBlank() { // 밑 공백
		String str =
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank ;
	}
	public String display() { // 초기 화면

		String str =
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃   1. 회원가입   ┃   2. 로그인   ┃  3. 관리자 로그인  ┃   4. 종료   ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                              ■입력 : ";
		return str;

	}

	public String myInfo() { // 로그인메뉴 - 1. 내 정보
		
		String str = 
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃     1. 내 정보 보기     ┃     2. 내 정보 수정     ┃     3. 뒤로     ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                              ■입력 : ";
		return str;
		
	}
	
	
	

	public String RMMenu() { // 로그인 - 예약관리 메뉴

		String RMmenu = upBlank+
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + "                             " + Member.member + "님의 예약 관리         \n" +
				leftBlank + menuBlank + "   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				leftBlank + menuBlank + " ■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				leftBlank + menuBlank + " ┃   1. 예약조회   ┃   2. 예약 변경   ┃   3. 예약 취소   ┃  4. 뒤로   ┃\n" +
				leftBlank + menuBlank + " ┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
				leftBlank + menuBlank + "                               ■입력: ";

		return RMmenu;

	}
	
}