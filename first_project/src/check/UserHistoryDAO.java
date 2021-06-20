package yanolja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserHistoryDAO {

	public List<UserHistoryDTO> getList(String userId) { // ��볻�� ������ ���� ����Ʈ

		List<UserHistoryDTO> lists = new ArrayList<>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select a.userid,a.checkin,a.checkout,a.totalexp,b.hotelname from userhistory a, hotel b where a.userid = ? and a.hotelcode=b.hotelcode";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				UserHistoryDTO udto = new UserHistoryDTO();
				udto.setUserId(rs.getString("userid"));
				udto.setHotelName(rs.getString("hotelname"));
				udto.setCheckIn(rs.getString("checkin"));
				udto.setCheckOut(rs.getString("checkout"));
				udto.setTotalExp(rs.getInt("totalexp"));
				lists.add(udto);			
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;

	}
	
	public boolean deleteHistoryData(String hotelcode, String checkin, String checkout) { // ���� ���� db���� ����

		UserHistoryDTO hdto = null;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;
		boolean check = false;
		String roomName=null;

		try {
			sql="select roomname from userhistory a, reservation b where a.userid=b.userid and a.userid=? and ";
			sql+="a.hotelcode=b.hotelcode and a.hotelcode=? and ";
			sql+="a.checkin=b.checkin and a.checkin=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			pstmt.setString(2, hotelcode);
			pstmt.setString(3, checkin);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				roomName=rs.getString("roomname");
			}
			
			System.out.println(roomName);
			
			
			sql = "delete userhistory where userid = ? and hotelcode = ? and checkin = ? and checkout = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			pstmt.setString(2, hotelcode);
			pstmt.setString(3, checkin);
			pstmt.setString(4, checkout);
			if(pstmt.executeUpdate()!=0) {
				check = true; // ���� ����
			}else {
				check = false; // ���� ����
			}
			
			sql="delete reservation where userid=? and roomname=? and hotelcode=? and checkin=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			pstmt.setString(2, roomName);
			pstmt.setString(3, hotelcode);
			pstmt.setString(4, checkin);
			pstmt.executeQuery();
			
			pstmt.close();					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean updateHistoryData(String hotelname) { // db���� ���� ���� (Ȯ���ʿ�)

		boolean check = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "update userhistory set hotelcode=(select hotelcode from hotel where hotelname=?) where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelname);
			pstmt.setString(2, Member.member);
			if(pstmt.executeUpdate()!=0) {
				check = true; // ���� ����
			}else {
				check = false; // ���� ����
			}
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}
	
// ---------------------------------------------
	
	public String getHotelCode(String hotelname) { // ȣ���̸��� ������ ȣ���ڵ带 �ݳ��ϴ� �޼ҵ� (Ȯ���ʿ�)

		String hc = null;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hotelcode from hotel where hotelname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hc = rs.getString("hotelcode");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return hc;
	}

	public boolean checkHotel(String hotelcode) { // ȣ���ڵ带 �޾Ƽ� ���೻���� �ش�ȣ���� �ִ��� Ȯ���ϴ� �޼ҵ�

		boolean check = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hotelcode from userhistory where hotelcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				
				check = false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean checkCheckIn(String hotelcode, String checkin) { // ȣ���ڵ�� �Խǳ�¥�� �޾Ƽ� userhistory���� �ش系���� �ִ��� Ȯ���ϴ� �޼ҵ�

		boolean check = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select checkin from userhistory where userid = ? and hotelcode = ? and checkin = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			pstmt.setString(2, hotelcode);
			pstmt.setString(3, checkin);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean checkCheckOut(String hotelcode, String checkin, String checkout) { // ȣ���ڵ�� �Խǿ����� ��ǿ������� �޾Ƽ� userhistory���� �ش系���� �ִ��� Ȯ���ϴ� �޼ҵ�

		boolean check = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select checkin from userhistory where userid = ? and hotelcode = ? and checkin = ? and checkout = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			pstmt.setString(2, hotelcode);
			pstmt.setString(3, checkin);
			pstmt.setString(4, checkout);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}
	
}
