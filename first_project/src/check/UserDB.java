package yanolja;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserDB {

	Scanner sc = new Scanner(System.in);
	UserDBDAO dbdao = new UserDBDAO();
	String leftBlank="                                 ";
	String menuBlank="                 ";
    String insertBlank = leftBlank + menuBlank + "                              ��";
    String msgBlank = leftBlank + menuBlank + "                           ��";
    print pt = new print();
    int ch;

	public void joinUserDB() { // ȸ������

		try {
			UserDBDTO dbdto = null;
			boolean check = false;
			
			System.out.print(insertBlank+"���̵�: ");
			do {	
				String id = sc.next();
				if(dbdao.dbidCheck(id)==true) { // �ߺ����̵� üũ (���̵�� ��ҹ��� ����, ��й�ȣ�� X)
					System.out.println(msgBlank+"�ߺ��� ���̵��Դϴ�.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
					break;
				}else {
					dbdto = new UserDBDTO();
					dbdto.setUserId(id);
					System.out.print(insertBlank+"��й�ȣ: ");
					dbdto.setPwd(sc.next());
					System.out.print(insertBlank+"�̸�: ");
					dbdto.setUserName(sc.next());
					System.out.print(insertBlank+"����(����): "); // ���̰� ���ڰ� �ƴϸ� ������ ����
					dbdto.setAge(sc.nextInt());
					System.out.print(insertBlank+"����(M/W): "); // ���� M �� W�� �Էµǰ� Ȯ���ϴ� ���� �ʿ�
					dbdto.setSex(sc.next());
					System.out.print(insertBlank+"����: ");
					dbdto.setCountry(sc.next());
					System.out.print(insertBlank+"����: ");
					dbdto.setCity(sc.next());
					System.out.print(insertBlank+"�̸���: ");
					dbdto.setEmail(sc.next());
					System.out.print(insertBlank+"��ȭ��ȣ: ");
					dbdto.setTel(sc.next());
					if(dbdao.insertData(dbdto)==true) {
						System.out.println(msgBlank+"ȸ������ ����");
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
						System.out.println(msgBlank+"ȸ������ ����");
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						check = false;
						break;
					}
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public String loginUserDB() { // �α��� (���̵�� ��ҹ��� ����, ��й�ȣ�� X)

		Member.member = null; // �α��ε� ���̵� ��� ���� �ʱ�ȭ
			
		try {
			boolean check = false; // �α��� �������� Ȯ��
			do {
				System.out.print(insertBlank+"���̵�: ");
				String userId = sc.next();
				System.out.print(insertBlank+"��й�ȣ: ");
				String pwd = sc.next();
				if(dbdao.userLoginCheck(userId, pwd)==1) {
					System.out.println(msgBlank+userId + "���� �α����ϼ̽��ϴ�.");
					Member.member = userId; // �α��ο� ���� �� Member.member�� �α��� ������ userId�� ����
					check = true;
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
					break;
				}else if(dbdao.userLoginCheck(userId, pwd)==0) {
					System.out.println(msgBlank+"��й�ȣ�� �߸��Ǿ����ϴ�.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: break;
						}
					}while(ch<1||ch>1);
					Member.member = null;
					check = false;
				}else {
					System.out.println(msgBlank+"�������� �ʴ� ���̵��Դϴ�.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: break;
						}
					}while(ch<1||ch>1);
					Member.member = null;
					check = false;
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return Member.member;
	}

	public boolean loginManager() { // �Ŵ��� �α��� (���̵�� ��ҹ��� ����, ��й�ȣ�� X)

		boolean check = false;

		System.out.print(insertBlank+"������ ���̵�: ");
		String userId = sc.next();
		System.out.print(insertBlank+"��й�ȣ: ");
		String pwd = sc.next();
		if(dbdao.managerCheck(userId, pwd)==1) {
			System.out.println(msgBlank+"�����ڴ��� �����ϼ̽��ϴ�.");
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
		}else if(dbdao.managerCheck(userId, pwd)==0) {
			System.out.println(msgBlank+"��й�ȣ�� �߸��Ǿ����ϴ�.");
			do {
				System.out.print(pt.printsr());
				ch = sc.nextInt();
				switch (ch) {
				case 1: break;
				}
			}while(ch<1||ch>1);
			check = false;
		}else {
			System.out.println(msgBlank+"�߸��� �����Դϴ�!!");do {
				System.out.print(pt.printsr());
				ch = sc.nextInt();
				switch (ch) {
				case 1: break;
				}
			}while(ch<1||ch>1);
			check = false;
		}
		return check;

	}

	public void selectMyAccount() { // �� ���� ����

		List<UserDBDTO> lists = dbdao.getList(Member.member);
		Iterator<UserDBDTO> it = lists.iterator();

		System.out.print("                       " + "������������������������������������������������������������������������������������������������������������������������������������������������������\n");
		System.out.printf("                       " + " %10s��%10s��%10s��%3s��%2s��%20s��%20s��%20s��%20s��%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
		System.out.print("\n                       " + "������������������������������������������������������������������������������������������������������������������������������������������������������\n");
		
		while(it.hasNext()) {
			UserDBDTO dbdto = it.next();
			System.out.printf("                       " + " %10s��%10s��%10s��%3s��%3s��%20s��%20s��%20s��%20s��%15s",
					dbdto.getUserId(),dbdto.getPwd(),dbdto.getUserName(),dbdto.getAge(),dbdto.getSex(),dbdto.getCountry(),dbdto.getCity(),dbdto.getEmail(),dbdto.getRegDate(),dbdto.getTel());
			System.out.println();
		}
		do {
			System.out.print(pt.printsr());
			ch = sc.nextInt();
			switch (ch) {
			case 1: return;
			}
		}while(ch<1||ch>1);
	}
	
	public void updateAccount() { // �� ���� ����

		try {
			UserDBDTO dbdto = new UserDBDTO();
			System.out.print(insertBlank+"��й�ȣ ����: ");
			dbdto.setPwd(sc.next());
			System.out.print(insertBlank+"�̸� ����: ");
			dbdto.setUserName(sc.next());
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
			dbdto.setUserId(Member.member);
			if(dbdao.updateData(dbdto)==true) {
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