package yanolja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDBDAO {

	public boolean insertData(UserDBDTO dbdto) { // UserDBDTO�� ȸ������ ���� ���� �߰�

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "insert into userdb(userid,pwd,username,age,sex,country,city,email,regdate,tel) values"
					+ "(?,?,?,?,?,?,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dbdto.getUserId());
			pstmt.setString(2, dbdto.getPwd());
			pstmt.setString(3, dbdto.getUserName());
			pstmt.setInt(4, dbdto.getAge());
			pstmt.setString(5, dbdto.getSex());
			pstmt.setString(6, dbdto.getCountry());
			pstmt.setString(7, dbdto.getCity());
			pstmt.setString(8, dbdto.getEmail());
			pstmt.setString(9, dbdto.getTel());
			if(pstmt.executeUpdate()!=0) {
				check = true; // �߰� ����
			}else {
				check = false; // �߰� ����
			}
			pstmt.close();			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;

	}

	public int userLoginCheck(String userId, String pwd) { // UserDB ���̺��� �α���(���̵�,��й�ȣ) üũ

		int check = -1;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		String dbpw = ""; // �����ͺ��̽��� ���̵�� �Բ� ����Ǿ� �ִ� ��й�ȣ

		try {
			sql = "select pwd from userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				dbpw = rs.getString("pwd");
				if(dbpw.equalsIgnoreCase(pwd)) {
					check = 1; // �α��� ����
				}else {
					check = 0; // ��й�ȣ ����
				}
			}else {
				check = -1; // ���̵� ����				
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public List<UserDBDTO> getList(String userId){ // �� ���� ���⸦ ���� ����Ʈ ������
		List<UserDBDTO> lists = new ArrayList<>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,pwd,username,age,sex,country,city,email,regdate,tel from userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserDBDTO dbdto = new UserDBDTO();
				dbdto.setUserId(rs.getString("userid"));
				dbdto.setPwd(rs.getString("pwd"));
				dbdto.setUserName(rs.getString("username"));
				dbdto.setAge(rs.getInt("age"));
				dbdto.setSex(rs.getString("sex"));
				dbdto.setCountry(rs.getString("country"));
				dbdto.setCity(rs.getString("city"));
				dbdto.setEmail(rs.getString("email"));
				dbdto.setRegDate(rs.getString("regdate"));
				dbdto.setTel(rs.getString("tel"));
				lists.add(dbdto);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;

	}

	public boolean updateData(UserDBDTO dbdto) { // �� ���� db���� ����

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "update userdb set pwd = ?, username = ?, age = ?, sex = ?, country = ?, city = ?, email = ?, tel = ? where userid =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dbdto.getPwd());
			pstmt.setString(2, dbdto.getUserName());
			pstmt.setInt(3, dbdto.getAge());
			pstmt.setString(4, dbdto.getSex());
			pstmt.setString(5, dbdto.getCountry());
			pstmt.setString(6, dbdto.getCity());
			pstmt.setString(7, dbdto.getEmail());
			pstmt.setString(8, dbdto.getTel());
			pstmt.setString(9, dbdto.getUserId());
			if(pstmt.executeUpdate()!=0){
				check = true;
			}else {
				check = false;
			}
			pstmt.close();			
		} catch (Exception e) {
			System.out.println(e.toString());

		}
		return check;
	}

	public int managerCheck(String userId, String pwd) { // �Ŵ��� �α��� üũ

		int check = -1;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		String dbpw = "";

		try {
			sql = "select pwd from manager where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbpw = rs.getString("pwd");
				if(dbpw.equalsIgnoreCase(pwd)) {
					check = 1; // ������ �α��� ����
				}else {
					check = 0; // ��й�ȣ ����
				}
			}else {
				check = -1; // �α��� ����
			}
			rs.close();
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;

	}

	public boolean dbidCheck(String id) { // ���̵� �ߺ�üũ

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "select userid from userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			if(pstmt.executeUpdate()!=0) {
				check = true; // ���̵� ����
			}else {
				check = false; // ���� ���̵�
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}		
		return check;

	}

}
