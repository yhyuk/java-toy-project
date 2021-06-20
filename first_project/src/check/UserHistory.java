package yanolja;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import yanolja.HotelDTO;

public class UserHistory {

	Scanner sc = new Scanner(System.in);
	UserHistoryDAO hdao = new UserHistoryDAO();
	print pt = new print();
	int ch;
	
	String leftBlank="                                 ";
	String menuBlank="                 ";
    String insertBlank = leftBlank + menuBlank + "                              ��";
    String msgBlank = leftBlank + menuBlank + "                           ��";
	String upBlank="\n\n\n\n\n\n\n\n\n\n";

	public void Menu() { // ���೻�� �޴�

		int ch;
		try {
			while (true) {			
				System.out.println(pt.rogo());
				System.out.print(pt.RMMenu());
				ch = sc.nextInt();
				switch (ch) {
				case 1: // �α��ε� ����� ���೻�� Ȯ�� 
					viewUserHistory();
					break;
				case 2: // ���� ����
					updateHistory();
					break;
				case 3: // ���� ���
					deleteHistory();
					break;
				case 4: // �ڷ� ����
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void viewUserHistory() { // �α��ε� ����� ���೻�� ����

		try {
			List<UserHistoryDTO> lists = hdao.getList(Member.member);
			Iterator<UserHistoryDTO> it = lists.iterator();
			System.out.print(leftBlank+"          ��������������������������������������������������������������������������������������������\n");
			System.out.printf(leftBlank+"                %10s��%10s��%20s��%20s��%10s\n","USERID","HOTELNAME","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print(leftBlank+"          ��������������������������������������������������������������������������������������������\n");
			
			
			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserHistoryDTO hdto = it.next();
					System.out.printf(leftBlank+"                %10s��%10s��%20s��%20s��%10s\n",hdto.getUserId(),hdto.getHotelName(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
				}
				do {
					System.out.print(pt.printsr());
					ch = sc.nextInt();
					switch (ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}else {
				System.out.println(msgBlank+"���೻���� �����ϴ�.");
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
	

	public void deleteHistory() { // ���� ���

		try {
			boolean check = false; // ���̵� üũ�� ����
			do {
				System.out.print(insertBlank+"��������� ȣ���̸�: ");
				String hotelcode = hdao.getHotelCode(sc.next()); // ȣ���̸� �޾Ƽ� ȣ���ڵ�� ��ȯ �� ȣ���� �ִ��� üũ
				if(hdao.checkHotel(hotelcode)==false) {
					System.out.println(msgBlank+"�ش� ȣ�� ���೻���� �����ϴ�.");
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
					if(hdao.checkCheckIn(hotelcode, checkin)==false) {
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
						if(hdao.checkCheckOut(hotelcode, checkin, checkout)==false) {
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
									if(hdao.deleteHistoryData(hotelcode,checkin,checkout)==true) {
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
				return;
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/* public void updateHistory() { // ���� ����

		try {
			HotelDTO hdto = new HotelDTO();
			System.out.println(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�� ���ຯ���� ȣ���̸��� �Է��ϼ���");
			if(hdao.updateHistoryData(hdto.getHotelCode(sc.next()))==true) {
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
			}else {
				System.out.println(msgBlank+"���� ����");
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

	} */
	
	public void updateHistory() { // ���ຯ��??

		try {
			HotelDTO hdto = new HotelDTO();
			System.out.println(upBlank+upBlank+upBlank+leftBlank+menuBlank+"�� ���ຯ���� ȣ���̸��� �Է��ϼ���");
			if(hdao.updateHistoryData(sc.next())==true) {
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
			}else {
				System.out.println(msgBlank+"���� ����");
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
	
}


