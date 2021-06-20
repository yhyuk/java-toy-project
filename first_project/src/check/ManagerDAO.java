package yanolja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {

	public List<HotelDTO> hotelPrint() { // ��üȣ�� ����Ʈ ������

		List<HotelDTO> lists = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select hotelcode,hotelname,hotelclass,owner,country,city ";
			sql+= "from hotel";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				HotelDTO hdto = new HotelDTO();

				hdto.setHotelCode(rs.getString("hotelcode"));
				hdto.setHotelName(rs.getString("hotelname"));
				hdto.setHotelClass(rs.getString("hotelclass"));
				hdto.setOwner(rs.getString("Owner"));
				hdto.setCountry(rs.getString("country"));
				hdto.setCity(rs.getString("city"));

				lists.add(hdto);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}

	public void hotelInsert(HotelDTO hdto) { // ȣ�� �߰�

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into hotel values (?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getHotelCode());
			pstmt.setString(2, hdto.getHotelName());
			pstmt.setString(3, hdto.getHotelClass());
			pstmt.setString(4, hdto.getOwner());
			pstmt.setString(5, hdto.getCountry());
			pstmt.setString(6, hdto.getCity());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("�߰�����");
			} else {
				System.out.println("�߰�����");
			}

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelUpdate(HotelDTO hdto) { // ȣ�� ����

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update hotel set hotelname=?,hotelclass=?,owner=?,country=?,city=? ";
			sql+= "where hotelcode=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getHotelName());
			pstmt.setString(2, hdto.getHotelClass());
			pstmt.setString(3, hdto.getOwner());
			pstmt.setString(4, hdto.getCountry());
			pstmt.setString(5, hdto.getCity());
			pstmt.setString(6, hdto.getHotelCode());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("��������");
			} else {
				System.out.println("��������");
			}

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelDelete(String hotelcode) { // ȣ�� ����

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete hotel where hotelcode=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hotelcode);

			if(pstmt.executeUpdate()!=0) {
				System.out.println("��������");
			} else {
				System.out.println("��������");
			} 

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//---------------ȣ�ڷ� ����-----------------------

	public List<HotelDTO> roomPrint() { // ��ü ȣ�ڹ� ����Ʈ ������

		List<HotelDTO> lists = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select hotelcode,roomname ";
			sql+= "from hotelroom";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				HotelDTO hdto = new HotelDTO();

				hdto.setHotelCode(rs.getString("hotelcode"));
				hdto.setRoomName(rs.getString("roomname"));

				lists.add(hdto);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}

	public void roomInsert(HotelDTO hdto) { // ȣ�ڹ� �߰�

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into hotelroom values (?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getHotelCode());
			pstmt.setString(2, hdto.getRoomName());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("�߰�����");
			} else {
				System.out.println("�߰�����");
			} 

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomUpdate(HotelDTO hdto) { // ȣ�ڹ� ����

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update hotelroom set roomname=? ";
			sql+= "where hotelcode=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getRoomName());
			pstmt.setString(2, hdto.getHotelCode());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("��������");
			} else {
				System.out.println("��������");
			} 

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomDelete(HotelDTO hdto) { // ȣ�ڹ� ����

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete hotelroom where hotelcode=? and roomname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hdto.getHotelCode());
			pstmt.setString(2, hdto.getRoomName());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("��������");
			} else {
				System.out.println("��������");
			}  
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//---------------������ ���� ����-----------------------

	public List<UserHistoryDTO> getHistoryList() { // ��볻�� ������ ��ü ����� ����Ʈ

		List<UserHistoryDTO> lists = new ArrayList<>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,hotelcode,checkin,checkout,totalexp from userhistory";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				UserHistoryDTO udto = new UserHistoryDTO();
				udto.setUserId(rs.getString("userid"));
				udto.setHotelCode(rs.getString("hotelCode"));
				udto.setCheckIn(rs.getString("checkIn"));
				udto.setCheckOut(rs.getString("checkOut"));
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

	public UserHistoryDTO getHistory(String id) { // ��볻�� ������ ��ü ����� ����Ʈ �� �Ѹ��� ���̵� ��������

		UserHistoryDTO hdto = new UserHistoryDTO();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hotelcode,checkin,checkout,totalexp from userhistory where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				hdto = new UserHistoryDTO();
				hdto.setHotelCode(rs.getString("hotelCode"));
				hdto.setCheckIn(rs.getString("checkIn"));
				hdto.setCheckOut(rs.getString("checkOut"));
				hdto.setTotalExp(rs.getInt("totalexp"));			
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return hdto;

	}

	public boolean updateHistoryData(String id, String hotelname) { // ������ - ���� ���� db���� ����

		UserHistoryDTO hdto = null;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "update userhistory set checkin = ?, checkout = ? where userid = ? and hotelcode = (select hotelcode from hotel where hotelname = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hdto.getCheckIn());
			pstmt.setString(2, hdto.getCheckOut());
			pstmt.setString(3, id);
			pstmt.setString(4, hotelname);
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

	public boolean deleteHistoryData(String id, String hotelcode, String checkin, String checkout) { // ������ - ���� ���� db���� ���

		UserHistoryDTO hdto = null;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "delete userhistory where userid = ? and hotelcode = (select hotelcode from userhistory where hotelcode = ?) and checkin = ?, checkout = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, hotelcode);
			pstmt.setString(3, checkin);
			pstmt.setString(4, checkout);
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


	//---------------������ ȸ�� ����-----------------------

	public List<UserDBDTO> getUsersList(){ // ������ - ��ü ȸ�� ���� ����Ʈ ������ (userid ����)
		List<UserDBDTO> lists = new ArrayList<>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,pwd,username,age,sex,country,city,email,regdate,tel from userdb order by userid";
			pstmt = conn.prepareStatement(sql);
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

	public UserDBDTO getUser(String id) { // ȸ������ ������ ��ü ȸ�� ����Ʈ �� �Ѹ��� ���̵� ��������

		UserDBDTO dbdto = new UserDBDTO();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,pwd,username,age,sex,country,city,email,regdate,tel from userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dbdto;

	}

	public boolean updateUserData(UserDBDTO dbdto) { // ������ - ȸ�� ���� db���� ����

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

	public boolean deleteUserData(String id) { // ������ - ȸ�� ���� db���� ����

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "delete userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			if(pstmt.executeUpdate()!=0) {
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

	public boolean dbidCheck(String id) { // ȸ�� �˻��� �� ���̵� �ֳ� ���� üũ

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
			sql = "select checkin from userhistory where hotelcode = ? and checkin = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelcode);
			pstmt.setString(2, checkin);
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
			sql = "select checkin from userhistory where hotelcode = ? and checkin = ? and checkout = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelcode);
			pstmt.setString(2, checkin);
			pstmt.setString(3, checkout);
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
