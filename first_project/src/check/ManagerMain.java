package yanolja;

import java.util.Scanner;

public class ManagerMain {

	Scanner sc = new Scanner(System.in);
	Manager ob = new Manager();
	print pt = new print();

	public void managerMain() { // ������ �α��� �� �޴�

		int ch;
		try {
			while (true) {
				System.out.println(pt.managerLogo());
				System.out.print(pt.managerMenu());
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					managerHotel(); // ������ ȣ�� ����
					break;
				case 2:
					managerHotelRoom(); // ������ ȣ�ں� �� ����
					break;
				case 3:
					managerReservation(); // ������ ���� ����
					break;
				case 4: 
					managerUsers(); // ������ ȸ�� ����
					break;
				case 5:
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void managerHotel() { // ������ - 1. ȣ�� ����

		int ch;
		try {
			while (true) {
				do {
					System.out.println(pt.managerLogo());
					System.out.print(pt.hotelMenu());
					ch = sc.nextInt();
				} while (ch < 1 || ch > 5);
				switch (ch) {
				case 1:
					pt.blank();
					ob.printSc(); // 1. ��ü ȣ�� ��ȸ
					break;
				case 2:
					ob.hotelInsert(); // 2. ȣ�� �߰�
					break;
				case 3:
					ob.hotelUpdate(); // 3. ȣ�� ����
					break;
				case 4:
					ob.hotelDelete(); // 4. ȣ�� ����
					break;
				case 5:
					return; // �ڷ�
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void managerHotelRoom() { // ������ - 2. ȣ�� �����

		int ch;
		while (true) {
			System.out.println(pt.managerLogo());
			System.out.print(pt.roomMenu());
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				pt.blank();
				ob.printRom(); // 1. ȣ�� �� ��ȸ
				break;
			case 2:
				ob.roomInsert(); // 2. ȣ�� �� �߰�
				break;
			case 3:
				ob.roomUpdate(); // 3. ȣ�� �� ����
				break;
			case 4:
				ob.roomDelete(); // 4. ȣ�� �� ����
				break;
			case 5:
				return;
			}
		}

	}

	public void managerReservation() { // ������ - 3. �������

		int ch;
		while(true) {
			System.out.println(pt.managerLogo());
			System.out.print(pt.managerRMMenu());
			ch = sc.nextInt();
			switch(ch) {
			case 1: ob.viewAllHistory(); break; // 1. ���� ��ȸ
			case 2: ob.searchHistory(); break; // 2. ���� �˻�
			case 3: ob.updateHistory(); break; // 3. ���� ����
			case 4: ob.deleteHistory();break; // 4. ���� ���
			case 5: return; // �ڷ�
			}
		}
		
	}

	public void managerUsers() { // ������ - 4. ȸ������

		int ch;
		while (true) {
			System.out.println(pt.managerLogo());
			System.out.print(pt.managerUserMenu());
			ch = sc.nextInt();
			switch(ch) {
			case 1: ob.viewAllUsers(); break; // 1. ȸ�� ��ȸ
			case 2: ob.searchUser(); break; // 2. ȸ�� �˻�
			case 3: ob.updateUser(); break; // 3. ȸ�� ����
			case 4: ob.deleteUser(); break; // 4. ȸ�� ����
			case 5: return; // �ڷ�
			}
		}
		
	}

}
