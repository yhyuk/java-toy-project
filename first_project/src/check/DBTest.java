package yanolja;



import java.sql.Connection;


import yanolja.DBConn;

public class DBTest {

	public static void main(String[] args) {
		
		Connection conn=DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("�����ͺ��̽� ���� ����");
			System.exit(0);
		}
		
		System.out.println("�����ͺ��̽� ���� ����");
		
		DBConn.close();

	}

}
