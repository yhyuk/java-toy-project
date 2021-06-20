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
	String insertBlank = leftBlank + menuBlank + "                              ��";
	String msgBlank = leftBlank + menuBlank + "                           ��";
	ManagerDAO dao = new ManagerDAO();
	Scanner sc = new Scanner(System.in);
	print pt = new print();
	int ch; // �ڷΰ��� ���ù��� �� �޴� ����

	public void printSc() { // ������ - ȣ�� ��ȸ ���÷���

		int ch;

		try {
			while (true) {
				System.out.println(leftBlank+menuBlank+"��-����������������������������������������������������������������������-��");
				System.out.println(leftBlank+menuBlank+"��    ȣ��ID ��  ȣ���̸�  ����ަ�   ��ǥ��   ��    ����    ��    ����   �� ");
				System.out.println(leftBlank+menuBlank+"��-����������������������������������������������������������������������-��");
				hotelPrint();
				System.out.println(leftBlank+menuBlank+" ��������������������������������������������������������������������������");
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

	public void hotelPrint() { // ��ü ȣ�� ��ȸ

		List<HotelDTO> lists = dao.hotelPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();
			System.out.println(hdto.toStringG());

		}

	}

	public void hotelInsert() { // ������ - ȣ�� �߰�

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ���ڵ� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ���̸� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelName(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ�ڵ�� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelClass(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܿ����̸� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setOwner(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"���ش籹�� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCountry(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"���ش����� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCity(sc.next());

			dao.hotelInsert(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelUpdate() { // ������ - ȣ�� ����

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ���ڵ� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܼ�)ȣ���̸� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelName(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܼ�)ȣ�ڵ�� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelClass(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܼ�)�����̸� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setOwner(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܼ�)�ش籹�� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCountry(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܼ�)�ش����� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCity(sc.next());

			dao.hotelUpdate(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelDelete() { // ������ - ȣ�� ����

		try {

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ���ڵ� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			String hotelcode = sc.next();

			dao.hotelDelete(hotelcode);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//-------------ȣ�ڷ� ����-------------------------

	public void roomPrint() { // ��ü ȣ�ڹ� ����

		List<HotelDTO> lists = dao.roomPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();

			System.out.println(hdto.toStringG());

		}

	}

	public void printRom() { // ������ - ȣ�ڹ� ��ȸ ���÷���
		int ch;

		try {

			while (true) {

				do {
					System.out.println();
					System.out.println(leftBlank+menuBlank+menuBlank+"          ��-��������������������-��");
					System.out.println(leftBlank+menuBlank+menuBlank+"          ��  ȣ��ID  ��  �� �̸� ��");
					System.out.println(leftBlank+menuBlank+menuBlank+"          ��-��������������������-��");
					roomPrint_ver2();
					// System.out.println(leftBlank+menuBlank+menuBlank+"          ��������������������������");
					System.out.print(pt.printsr());
					ch = sc.nextInt();

				} while (ch < 1 || ch > 1);

				switch (ch) {

				case 1:
					return; // �ڷ�
				}

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomPrint_ver2() { // ��ü ȣ�ڹ� ��ȸ

		List<HotelDTO> lists = dao.roomPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();

			System.out.println(hdto.toStringR());

		}

	}

	public void roomInsert() { // ȣ�� �� �߰�

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ���ڵ� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܹ��̸� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());

			dao.roomInsert(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomUpdate() { // ȣ�� �� ����

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ���ڵ� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܼ�) ���̸� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());

			dao.roomUpdate(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomDelete() { // ȣ�� �� ����

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"��ȣ���ڵ� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.println(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�ܻ����� ���̸� �Է��ϼ��� "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());


			dao.roomDelete(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//-----------------------------------------------------	

	ManagerDAO mdao = new ManagerDAO(); // ManagerDAO ��ü ����

	//-----------------������ �������---------------------

	public void viewAllHistory() { // ��ü ����� ���೻�� ����

		try {
			List<UserHistoryDTO> lists = mdao.getHistoryList();
			Iterator<UserHistoryDTO> it = lists.iterator();
			System.out.print(leftBlank+"               ��������������������������������������������������������������������������������\n");
			System.out.printf(leftBlank+"               %10s��%10s��%20s��%20s��%10s","USERID","HOTELCODE","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print("\n"+leftBlank+"               ��������������������������������������������������������������������������������\n");
			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserHistoryDTO hdto = it.next();
					System.out.printf(leftBlank+"               %10s��%10s��%20s��%20s��%10s",hdto.getUserId(),hdto.getHotelCode(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
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
				System.out.println(msgBlank+"��ȸ�Ǵ� ���� ������ �����ϴ�.");
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

	public void searchHistory() { // ���̵�� ȸ���� ���೻�� �˻�

		try {
			UserHistoryDTO hdto = null;
			boolean check = false; // ȸ�� �ִ��� Ȯ�ο� ����
			System.out.print(leftBlank+"               ��������������������������������������������������������������������������������\n");
			System.out.printf(leftBlank+"               %10s��%10s��%20s��%20s��%10s","USERID","HOTELCODE","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print("\n"+leftBlank+"               ��������������������������������������������������������������������������������\n");
			do { // �ִ� ���̵����� üũ ������ ���� X
				System.out.print(insertBlank+"�˻��� ȸ��ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"��ϵ��� ���� ���̵��Դϴ�.");
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
					System.out.printf(leftBlank+"               %10s��%10s��%20s��%20s��%10s",hdto.getUserId(),hdto.getHotelCode(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
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

	public void updateHistory() { // ���� ���� ����

		try {
			UserHistoryDTO hdto = null;
			boolean check = false;
			do {
				System.out.print(insertBlank+"������ ȸ�� ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"��ϵ��� ���� ���̵��Դϴ�.");
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
					System.out.print(insertBlank+"������ ȣ���̸�: ");
					String hotelname = sc.next();
					System.out.print(insertBlank+"�Խ� ��¥ ����(YYYY-MM-DD): ");
					hdto.setCheckIn(sc.next());
					System.out.print(insertBlank+"��� ��¥ ����(YYYY-MM-DD): ");
					hdto.setCheckOut(sc.next());
					if(mdao.updateHistoryData(id, hotelname)==true) {
						System.out.println(msgBlank+"���� ����");
						boolean flag = false;
						do {
							System.out.print(leftBlank + menuBlank + "                           ��ƹ�Ű�� �Է��ϼ��� ");
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
						System.out.println(msgBlank+"���� ����");
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

	public void deleteHistory() { // ���� ���

		try {
			boolean check = false; // ���̵� üũ�� ����
			do {
				System.out.print(insertBlank+"��������� ȸ�� ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"��ϵ��� ���� ���̵��Դϴ�.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check =false;
				}else {
					System.out.print(insertBlank+"��������� ȣ���̸�: ");
					String hotelcode = mdao.getHotelCode(sc.next()); // ȣ���̸� �޾Ƽ� ȣ���ڵ�� ��ȯ �� ȣ���� �ִ��� üũ
					if(mdao.checkHotel(hotelcode)==false) {
						System.out.println(msgBlank+"ȣ���̸��� �߸��ƽ��ϴ�."); 
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						break;
					}else {
						System.out.print(insertBlank+"�Խǿ�����(YYYY-MM-DD): ");
						String checkin = sc.next();
						if(mdao.checkCheckIn(hotelcode, checkin)==false) {
							System.out.println(msgBlank+"�ش��ϴ� ������� �����ϴ�.");
							do {
								System.out.print(pt.printsr());
								ch = sc.nextInt();
								switch (ch) {
								case 1: return;
								}
							}while(ch<1||ch>1);
							break;
						}else {
							System.out.print(insertBlank+"��ǿ�����(YYYY-MM-DD): ");
							String checkout = sc.next();
							if(mdao.checkCheckOut(hotelcode, checkin, checkout)==false) {
								System.out.println(msgBlank+"�ش��ϴ� ������� �����ϴ�.");
								do {
									System.out.print(pt.printsr());
									ch = sc.nextInt();
									switch (ch) {
									case 1: return;
									}
								}while(ch<1||ch>1);
								break;
							}else {
								String a; // �Է¹��� ���� y �Ǵ� n���� Ȯ���ϴ� ����
								do {
									System.out.print(insertBlank+"���� �����Ͻðڽ��ϱ�? ");
									a = sc.next();
									if(a.equalsIgnoreCase("y")) {
										if(mdao.deleteHistoryData(id,hotelcode,checkin,checkout)==true) {
											System.out.println(msgBlank+"���� ����");
											boolean flag = false;
											do {
												System.out.print(leftBlank + menuBlank + "                           ��ƹ�Ű�� �Է��ϼ��� ");
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
											System.out.println(msgBlank+"���� ����");
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
										System.out.println(msgBlank+"������ ����Ͽ����ϴ�.");
										do {
											System.out.print(pt.printsr());
											ch = sc.nextInt();
											switch (ch) {
											case 1: return;
											}
										}while(ch<1||ch>1);
										break;						
									}else {
										System.out.println(msgBlank+"�� �� �Է��ϼ̽��ϴ�.");					
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

	//------------------������ ȸ������----------------------


	public void viewAllUsers() { // ��ü ȸ�� ����

		try {
			List<UserDBDTO> lists = mdao.getUsersList();
			Iterator<UserDBDTO> it = lists.iterator();

			System.out.print("                      " + "������������������������������������������������������������������������������������������������������������������������������������������������������\n");
			System.out.printf("                      " + " %10s��%10s��%10s��%3s��%2s��%20s��%20s��%20s��%20s��%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
			System.out.print("\n                      " + "������������������������������������������������������������������������������������������������������������������������������������������������������\n");

			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserDBDTO dbdto = it.next();
					System.out.printf("                      " + " %10s��%10s��%10s��%3s��%3s��%20s��%20s��%20s��%20s��%15s",
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
				System.out.println(msgBlank+"��ȸ�Ǵ� ȸ�� ������ �����ϴ�.");
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

	public void searchUser() { // ���̵�� ȸ�� ���� �˻�

		try {
			UserDBDTO dbdto = null;
			boolean check = false;

			System.out.print("                      " + "������������������������������������������������������������������������������������������������������������������������������������������������������\n");
			System.out.printf("                      " + " %10s��%10s��%10s��%3s��%2s��%20s��%20s��%20s��%20s��%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
			System.out.print("\n                      " + "������������������������������������������������������������������������������������������������������������������������������������������������������\n");

			do {
				System.out.print(insertBlank+"�˻��� ȸ�� ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"��ϵ��� ���� ���̵��Դϴ�.");
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
					System.out.printf("                      " + " %10s��%10s��%10s��%3s��%3s��%20s��%20s��%20s��%20s��%15s",
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

	public void updateUser() { // ȸ�� ���� ����

		try {
			UserDBDTO dbdto = null;
			boolean check = false;
			do {
				System.out.print(insertBlank+"������ ȸ���� ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"��ϵ��� ���� ���̵��Դϴ�.");
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
					System.out.print(insertBlank+"��й�ȣ ����: ");
					dbdto.setPwd(sc.next());
					System.out.print(insertBlank+"�̸� ����: ");
					dbdto.setUserName(sc.next());;
					System.out.print(insertBlank+"���� ����(����): ");
					dbdto.setAge(sc.nextInt());
					System.out.print(insertBlank+"���� ����(M/W): ");
					dbdto.setSex(sc.next());
					System.out.print(insertBlank+"���� ����: ");
					dbdto.setCountry(sc.next());
					System.out.print(insertBlank+"���� ����: ");
					dbdto.setCity(sc.next());
					System.out.print(insertBlank+"�̸��� ����: ");
					dbdto.setEmail(sc.next());
					System.out.print(insertBlank+"��ȭ��ȣ ����: ");
					dbdto.setTel(sc.next());
					if(mdao.updateUserData(dbdto)==true) {
						System.out.println(msgBlank+"���� ����");
						boolean flag = false;
						do {
							System.out.print(leftBlank + menuBlank + "                           ��ƹ�Ű�� �Է��ϼ��� ");
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
						System.out.println(msgBlank+"���� ����");
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

	public void deleteUser() { // ȸ�� ���� ����

		try {
			boolean check = false; // ���̵� üũ�� ����
			do {
				System.out.print(insertBlank+"������ ȸ���� ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"��ϵ��� ���� ���̵��Դϴ�.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check =false;
				}else {
					String a; // �Է¹��� ���� y �Ǵ� n���� Ȯ���ϴ� ����
					do {
						System.out.print(insertBlank+"���� �����Ͻðڽ��ϱ�? ");
						a = sc.next();
						if(a.equalsIgnoreCase("y")) {
							if(mdao.deleteUserData(id)==true) {
								System.out.println(msgBlank+"���� ����");
								boolean flag = false;
								do {
									System.out.print(leftBlank + menuBlank + "                           ��ƹ�Ű�� �Է��ϼ��� ");
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
								System.out.println(msgBlank+"���� ����");
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
							System.out.println(msgBlank+"������ ����Ͽ����ϴ�.");
							do {
								System.out.print(pt.printsr());
								ch = sc.nextInt();
								switch (ch) {
								case 1: return;
								}
							}while(ch<1||ch>1);
							break;
						}else {
							System.out.println(msgBlank+"�� �� �Է��ϼ̽��ϴ�.");
						}
					}while(!a.equalsIgnoreCase("y")&&!a.equalsIgnoreCase("n"));
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
