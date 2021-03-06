package yanolja;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import yanolja.HotelDTO;
import yanolja.ManagerMain;
import yanolja.print;


public class Manager {

	String leftBlank="                                 ";
	String upBlank="\n\n\n\n\n\n\n\n\n\n";
	String menuBlank="                 ";
	String insertBlank = leftBlank + menuBlank + "                              ▷";
	String msgBlank = leftBlank + menuBlank + "                           ▶";
	ManagerDAO dao = new ManagerDAO();
	Scanner sc = new Scanner(System.in);
	print pt = new print();
	int ch; // 뒤로가기 선택받을 때 받는 변수

	public void printSc() { // 관리자 - 호텔 조회 디스플레이

		int ch;

		try {
			while (true) {
				System.out.println(leftBlank+menuBlank+"■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━-┓");
				System.out.println(leftBlank+menuBlank+"┃    호텔ID ┃  호텔이름  ┃등급┃   대표자   ┃    국가    ┃    도시   ┃ ");
				System.out.println(leftBlank+menuBlank+"┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━-┛");
				hotelPrint();
				System.out.println(leftBlank+menuBlank+" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.print(pt.printsr());
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelPrint() { // 전체 호텔 조회

		List<HotelDTO> lists = dao.hotelPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();
			System.out.println(hdto.toStringG());

		}

	}

	public void hotelInsert() { // 관리자 - 호텔 추가

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔코드 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔이름 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelName(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔등급 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelClass(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●오너이름 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setOwner(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●해당국가 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCountry(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●해당지역 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCity(sc.next());

			dao.hotelInsert(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelUpdate() { // 관리자 - 호텔 수정

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔코드 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●수)호텔이름 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelName(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●수)호텔등급 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelClass(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●수)오너이름 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setOwner(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●수)해당국가 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCountry(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●수)해당지역 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCity(sc.next());

			dao.hotelUpdate(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelDelete() { // 관리자 - 호텔 삭제

		try {

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔코드 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			String hotelcode = sc.next();

			dao.hotelDelete(hotelcode);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//-------------호텔룸 관리-------------------------

	public void roomPrint() { // 전체 호텔방 보기

		List<HotelDTO> lists = dao.roomPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();

			System.out.println(hdto.toStringG());

		}

	}

	public void printRom() { // 관리자 - 호텔방 조회 디스플레이
		int ch;

		try {

			while (true) {

				do {
					System.out.println();
					System.out.println(leftBlank+menuBlank+menuBlank+"          ■-━━━━━━━━━━-┓");
					System.out.println(leftBlank+menuBlank+menuBlank+"          ┃  호텔ID  ┃  방 이름 ┃");
					System.out.println(leftBlank+menuBlank+menuBlank+"          ┗-━━━━━━━━━━-┛");
					roomPrint_ver2();
					// System.out.println(leftBlank+menuBlank+menuBlank+"          ┗━━━━━━━━━━━┛");
					System.out.print(pt.printsr());
					ch = sc.nextInt();

				} while (ch < 1 || ch > 1);

				switch (ch) {

				case 1:
					return; // 뒤로
				}

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomPrint_ver2() { // 전체 호텔방 조회

		List<HotelDTO> lists = dao.roomPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();

			System.out.println(hdto.toStringR());

		}

	}

	public void roomInsert() { // 호텔 방 추가

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔코드 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●방이름 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());

			dao.roomInsert(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomUpdate() { // 호텔 방 수정

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔코드 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●수) 방이름 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());

			dao.roomUpdate(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomDelete() { // 호텔 방 삭제

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●호텔코드 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.println(upBlank+upBlank+upBlank+leftBlank+menuBlank+"●삭제할 방이름 입력하세요 "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());


			dao.roomDelete(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//-----------------------------------------------------	

	ManagerDAO mdao = new ManagerDAO(); // ManagerDAO 객체 생성

	//-----------------관리자 예약관리---------------------

	public void viewAllHistory() { // 전체 사용자 예약내역 보기

		try {
			List<UserHistoryDTO> lists = mdao.getHistoryList();
			Iterator<UserHistoryDTO> it = lists.iterator();
			System.out.print(leftBlank+"               ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			System.out.printf(leftBlank+"               %10s┃%10s┃%20s┃%20s┃%10s","USERID","HOTELCODE","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print("\n"+leftBlank+"               ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserHistoryDTO hdto = it.next();
					System.out.printf(leftBlank+"               %10s┃%10s┃%20s┃%20s┃%10s",hdto.getUserId(),hdto.getHotelCode(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
					System.out.println();
				}
				do {
					System.out.print(pt.printsr());
					ch = sc.nextInt();
					switch (ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}else {
				System.out.println(msgBlank+"조회되는 예약 내역이 없습니다.");
				do {
					System.out.print(pt.printsr());
					ch = sc.nextInt();
					switch (ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void searchHistory() { // 아이디로 회원의 예약내역 검색

		try {
			UserHistoryDTO hdto = null;
			boolean check = false; // 회원 있는지 확인용 변수
			System.out.print(leftBlank+"               ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			System.out.printf(leftBlank+"               %10s┃%10s┃%20s┃%20s┃%10s","USERID","HOTELCODE","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print("\n"+leftBlank+"               ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			do { // 있는 아이디인지 체크 없으면 진행 X
				System.out.print(insertBlank+"검색할 회원ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"등록되지 않은 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					hdto = new UserHistoryDTO();
					hdto = mdao.getHistory(id);
					System.out.printf(leftBlank+"               %10s┃%10s┃%20s┃%20s┃%10s",hdto.getUserId(),hdto.getHotelCode(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
					System.out.println();
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = true;
					break;
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void updateHistory() { // 예약 정보 수정

		try {
			UserHistoryDTO hdto = null;
			boolean check = false;
			do {
				System.out.print(insertBlank+"수정할 회원 ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"등록되지 않은 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					hdto = new UserHistoryDTO();
					System.out.print(insertBlank+"수정할 호텔이름: ");
					String hotelname = sc.next();
					System.out.print(insertBlank+"입실 날짜 수정(YYYY-MM-DD): ");
					hdto.setCheckIn(sc.next());
					System.out.print(insertBlank+"퇴실 날짜 수정(YYYY-MM-DD): ");
					hdto.setCheckOut(sc.next());
					if(mdao.updateHistoryData(id, hotelname)==true) {
						System.out.println(msgBlank+"수정 성공");
						boolean flag = false;
						do {
							System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
							String str = sc.next();
							if(str!=null) {
								flag = true;
								break;
							}else {
								flag = false;
							}
						}while(flag);
						check = true;
					}else {
						System.out.println(msgBlank+"수정 실패");
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						check = false;
					}
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void deleteHistory() { // 예약 취소

		try {
			boolean check = false; // 아이디 체크용 변수
			do {
				System.out.print(insertBlank+"예약취소할 회원 ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"등록되지 않은 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check =false;
				}else {
					System.out.print(insertBlank+"예약취소할 호텔이름: ");
					String hotelcode = mdao.getHotelCode(sc.next()); // 호텔이름 받아서 호텔코드로 반환 후 호텔이 있는지 체크
					if(mdao.checkHotel(hotelcode)==false) {
						System.out.println(msgBlank+"호텔이름이 잘못됐습니다."); 
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						break;
					}else {
						System.out.print(insertBlank+"입실예정일(YYYY-MM-DD): ");
						String checkin = sc.next();
						if(mdao.checkCheckIn(hotelcode, checkin)==false) {
							System.out.println(msgBlank+"해당하는 예약건이 없습니다.");
							do {
								System.out.print(pt.printsr());
								ch = sc.nextInt();
								switch (ch) {
								case 1: return;
								}
							}while(ch<1||ch>1);
							break;
						}else {
							System.out.print(insertBlank+"퇴실예정일(YYYY-MM-DD): ");
							String checkout = sc.next();
							if(mdao.checkCheckOut(hotelcode, checkin, checkout)==false) {
								System.out.println(msgBlank+"해당하는 예약건이 없습니다.");
								do {
									System.out.print(pt.printsr());
									ch = sc.nextInt();
									switch (ch) {
									case 1: return;
									}
								}while(ch<1||ch>1);
								break;
							}else {
								String a; // 입력받은 값이 y 또는 n인지 확인하는 변수
								do {
									System.out.print(insertBlank+"정말 삭제하시겠습니까? ");
									a = sc.next();
									if(a.equalsIgnoreCase("y")) {
										if(mdao.deleteHistoryData(id,hotelcode,checkin,checkout)==true) {
											System.out.println(msgBlank+"삭제 성공");
											boolean flag = false;
											do {
												System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
												String str = sc.next();
												if(str!=null) {
													flag = true;
													break;
												}else {
													flag = false;
												}
											}while(flag);
											check = true;
											break;
										}else {
											System.out.println(msgBlank+"삭제 실패");
											do {
												System.out.print(pt.printsr());
												ch = sc.nextInt();
												switch (ch) {
												case 1: return;
												}
											}while(ch<1||ch>1);
											check = true;
											break;
										}
									}else if(a.equalsIgnoreCase("n")){
										System.out.println(msgBlank+"삭제를 취소하였습니다.");
										do {
											System.out.print(pt.printsr());
											ch = sc.nextInt();
											switch (ch) {
											case 1: return;
											}
										}while(ch<1||ch>1);
										break;						
									}else {
										System.out.println(msgBlank+"잘 못 입력하셨습니다.");					
									}
								}while(!a.equalsIgnoreCase("y")&&!a.equalsIgnoreCase("n"));
							}
						}
					}
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//------------------관리자 회원관리----------------------


	public void viewAllUsers() { // 전체 회원 보기

		try {
			List<UserDBDTO> lists = mdao.getUsersList();
			Iterator<UserDBDTO> it = lists.iterator();

			System.out.print("                      " + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			System.out.printf("                      " + " %10s┃%10s┃%10s┃%3s┃%2s┃%20s┃%20s┃%20s┃%20s┃%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
			System.out.print("\n                      " + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserDBDTO dbdto = it.next();
					System.out.printf("                      " + " %10s┃%10s┃%10s┃%3s┃%3s┃%20s┃%20s┃%20s┃%20s┃%15s",
							dbdto.getUserId(),dbdto.getPwd(),dbdto.getUserName(),dbdto.getAge(),dbdto.getSex(),dbdto.getCountry(),dbdto.getCity(),dbdto.getEmail(),dbdto.getRegDate(),dbdto.getTel());
					System.out.println();
				}
				int ch;
				do {
					System.out.println(pt.printsr());
					ch = sc.nextInt();
					switch(ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}else {
				System.out.println(msgBlank+"조회되는 회원 정보가 없습니다.");
				do {
					System.out.print(pt.printsr());
					ch = sc.nextInt();
					switch (ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void searchUser() { // 아이디로 회원 정보 검색

		try {
			UserDBDTO dbdto = null;
			boolean check = false;

			System.out.print("                      " + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			System.out.printf("                      " + " %10s┃%10s┃%10s┃%3s┃%2s┃%20s┃%20s┃%20s┃%20s┃%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
			System.out.print("\n                      " + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

			do {
				System.out.print(insertBlank+"검색할 회원 ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"등록되지 않은 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					dbdto = new UserDBDTO();
					dbdto = mdao.getUser(id);
					System.out.printf("                      " + " %10s┃%10s┃%10s┃%3s┃%3s┃%20s┃%20s┃%20s┃%20s┃%15s",
							dbdto.getUserId(),dbdto.getPwd(),dbdto.getUserName(),dbdto.getAge(),dbdto.getSex(),dbdto.getCountry(),dbdto.getCity(),dbdto.getEmail(),dbdto.getRegDate(),dbdto.getTel());
					System.out.println();
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = true;
					break;
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void updateUser() { // 회원 정보 수정

		try {
			UserDBDTO dbdto = null;
			boolean check = false;
			do {
				System.out.print(insertBlank+"수정할 회원의 ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"등록되지 않은 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					dbdto = new UserDBDTO();
					dbdto.setUserId(id);
					System.out.print(insertBlank+"비밀번호 변경: ");
					dbdto.setPwd(sc.next());
					System.out.print(insertBlank+"이름 변경: ");
					dbdto.setUserName(sc.next());;
					System.out.print(insertBlank+"나이 변경(숫자): ");
					dbdto.setAge(sc.nextInt());
					System.out.print(insertBlank+"성별 변경(M/W): ");
					dbdto.setSex(sc.next());
					System.out.print(insertBlank+"국적 변경: ");
					dbdto.setCountry(sc.next());
					System.out.print(insertBlank+"도시 변경: ");
					dbdto.setCity(sc.next());
					System.out.print(insertBlank+"이메일 변경: ");
					dbdto.setEmail(sc.next());
					System.out.print(insertBlank+"전화번호 변경: ");
					dbdto.setTel(sc.next());
					if(mdao.updateUserData(dbdto)==true) {
						System.out.println(msgBlank+"수정 성공");
						boolean flag = false;
						do {
							System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
							String str = sc.next();
							if(str!=null) {
								flag = true;
								break;
							}else {
								flag = false;
							}
						}while(flag);
						check = true;
						break;
					}else {
						System.out.println(msgBlank+"수정 실패");
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						check = false;
					}				
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void deleteUser() { // 회원 정보 삭제

		try {
			boolean check = false; // 아이디 체크용 변수
			do {
				System.out.print(insertBlank+"삭제할 회원의 ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"등록되지 않은 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check =false;
				}else {
					String a; // 입력받은 값이 y 또는 n인지 확인하는 변수
					do {
						System.out.print(insertBlank+"정말 삭제하시겠습니까? ");
						a = sc.next();
						if(a.equalsIgnoreCase("y")) {
							if(mdao.deleteUserData(id)==true) {
								System.out.println(msgBlank+"삭제 성공");
								boolean flag = false;
								do {
									System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
									String str = sc.next();
									if(str!=null) {
										flag = true;
										break;
									}else {
										flag = false;
									}
								}while(flag);
								check = true;
							}else {
								System.out.println(msgBlank+"삭제 실패");
								do {
									System.out.print(pt.printsr());
									ch = sc.nextInt();
									switch (ch) {
									case 1: return;
									}
								}while(ch<1||ch>1);
								check = true;
								break;
							}
						}else if(a.equalsIgnoreCase("n")){
							System.out.println(msgBlank+"삭제를 취소하였습니다.");
							do {
								System.out.print(pt.printsr());
								ch = sc.nextInt();
								switch (ch) {
								case 1: return;
								}
							}while(ch<1||ch>1);
							break;
						}else {
							System.out.println(msgBlank+"잘 못 입력하셨습니다.");
						}
					}while(!a.equalsIgnoreCase("y")&&!a.equalsIgnoreCase("n"));
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
