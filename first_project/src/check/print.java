package yanolja;

public class print { // �޴� ������

	String leftBlank="                                 ";
	String upBlank="\n\n\n";
	String menuBlank="                 ";

	public String rogo() { // �޴� �ΰ�

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
				leftBlank+"��-������������������������������������������������������������������������������������������������������������\n" + 
				leftBlank+"��                                                                                                           ��\n" + 
				leftBlank+"��                                 __   __        _   _         _                                            ��\n" + 
				leftBlank+"��                                 \\ \\ / /       | \\ | |       | |                                           ��\n" + 
				leftBlank+"��                                  \\ V /   __ _ |  \\| |  ___  | | ____  __ _                                ��\n" + 
				leftBlank+"��                                   \\ /   / _` || . ` | / _ \\ | ||_  / / _` |                               ��\n"+ 
				leftBlank+"��                                   | |  | (_| || |\\  || (_) || | / / | (_| |                               ��\n" + 
				leftBlank+"��                                   \\_/   \\__,_|\\_| \\_/ \\___/ |_|/___| \\__,_|                               ��\n" + 
				leftBlank+"��                                                                                                           ��\n" + 
				leftBlank+"��                                                                                                           ��\n" + 
				leftBlank+"��-������������������������������������������������������������������������������������������������������������\n";

		return rogo;

	}

	public String id() { // ���� �α��� �� ���̵� ������

		
		String id = upBlank +
				leftBlank + leftBlank + "          �᦬����������������\n" +
				leftBlank + leftBlank + "              " + Member.member + " ��\n" +
				leftBlank + leftBlank + "          ��������������������\n";
		return id;

	}
	
	public String main() { // �α��� �� �޴�

		String main =
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��   1. �� ����   ��    2. ����    ��   3. �������   ��   4. �α׾ƿ�   ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";
		return main;
	}

	public String managerLogo() { // ������ �α��� �� �ΰ�

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
				leftBlank+"�᦬������������������������������������������������������������������������������������������������������������\n" + 
				leftBlank+" ��               ___  ___                                         ___  ___                                   �� \n" + 
				leftBlank+" ��               |  \\/  |                                         |  \\/  |                                   �� \n" + 
				leftBlank+" ��               | .  . |  __ _  _ __    __ _   __ _   ___  _ __  | .  . |  ___  _ __   _   _                ��\n" + 
				leftBlank+" ��               | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__| | |\\/| | / _ \\| '_ \\ | | | |               ��\n" + 
				leftBlank+" ��               | |  | || (_| || | | || (_| || (_| ||  __/| |    | |  | ||  __/| | | || |_| |               ��\n" + 
				leftBlank+" ��               \\_|  |_/ \\__,_||_| |_| \\__,_| \\__, | \\___||_|    \\_|  |_/ \\___||_| |_| \\__,_|               ��\n" + 
				leftBlank+" ��                                              __/ |                                                        ��\n" + 
				leftBlank+" ��                                             |___/                                                         ��\n" + 
				leftBlank+" ��                                                                                                           ��\n" + 
				leftBlank+" ��-������������������������������������������������������������������������������������������������������������\n";

		return managerlogo;

	}

	public String managerMenu() { // ������ �α��� �� �޴�

		String managermenu = upBlank + 
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                              ȣ�ڸŴ��� ����â                           \n" +
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " �� 1. ȣ�ڰ��� �� 2. ȣ�� ����� �� 3. ������� �� 4. ȸ������ �� 5.�ڷ� ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";

		return managermenu;
	}

	public String hotelMenu() { // ������ - 1. ȣ�ڰ��� �޴�

		String hotelmenu = upBlank + 
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                                 ȣ�� ����â                              \n" +
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " �� 1. ȣ����ȸ �� 2. ȣ�� �߰� �� 3. ȣ�� ���� �� 4. ȣ�� ���� �� 5.�ڷ� ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";

		return hotelmenu;


	}

	public String roomMenu() { // ������ - 2. ȣ�� ����� �޴�

		String roommenu = upBlank + 
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ȣ�� �� ����â                           \n" +
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��1.ȣ�� �� ��ȸ��2.ȣ�� �� �߰���3.ȣ�� �� ������4.ȣ�� �� ������5. �ڷΦ�\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";

		return roommenu;

	}
	
	public String managerRMMenu() { // ������ - 3. ������� �޴�

		String RMmenu = upBlank+
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                                  ���� ����                                \n" +
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " �� 1. ������ȸ �� 2. ����˻� �� 3. ���� ���� �� 4. ���� ��� �� 5. �ڷ� ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";

		return RMmenu;

	}

	public String managerUserMenu() { // ������ - 4. ȸ������ �޴�

		String userMenu = upBlank+
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                                 ȸ�� ����â                             \n" +
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " �� 1. ȸ����ȸ �� 2. ȸ�� �˻� �� 3. ȸ�� ���� �� 4. ȸ������ �� 5. �ڷ� ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";

		return userMenu;

	}

	public String selectHotel() { // print() �� ����ϴ� ���÷��� ?

		String sh = upBlank+
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ȣ���ڵ�  ���̸�                            \n" +
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" ;
		return sh;
	}

	public String printsr() { // print() �� �ڷΰ��� ?

		String vprint = upBlank + 
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��                               1. �ڷΰ���                             ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";

		return vprint;
	}

	public void blank() { // �� ����
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	public void downBlank() { // �� ����
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
	public String display() { // �ʱ� ȭ��

		String str =
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��   1. ȸ������   ��   2. �α���   ��  3. ������ �α���  ��   4. ����   ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                              ���Է� : ";
		return str;

	}

	public String myInfo() { // �α��θ޴� - 1. �� ����
		
		String str = 
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��     1. �� ���� ����     ��     2. �� ���� ����     ��     3. �ڷ�     ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                              ���Է� : ";
		return str;
		
	}
	
	
	

	public String RMMenu() { // �α��� - ������� �޴�

		String RMmenu = upBlank+
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                             " + Member.member + "���� ���� ����         \n" +
				leftBlank + menuBlank + "   ������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + " ��   1. ������ȸ   ��   2. ���� ����   ��   3. ���� ���   ��  4. �ڷ�   ��\n" +
				leftBlank + menuBlank + " ��-������������������������������������������������������������������������\n" +
				leftBlank + menuBlank + "                               ���Է�: ";

		return RMmenu;

	}
	
}