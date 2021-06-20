package yanolja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import yanolja.HotelDTO;

public class HotelReservationView {

	String leftBlank="                                 ";
	String middleBlank="         ";

	public void introView() {

		System.out.println("\n"+
				leftBlank+"■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"+
				leftBlank+"┃  __  __       _                                                                      _   _             _  ┃\n"+
				leftBlank+"┃ |  \\/  |     | |                                                                    | | (_)           | | ┃\n"+
				leftBlank+"┃ | \\  / | __ _| | _____   _   _  ___  _   _ _ __   _ __ ___  ___  ___ _ ____   ____ _| |_ _  ___  _ __ | | ┃\n"+
				leftBlank+"┃ | |\\/| |/ _` | |/ / _ \\ | | | |/ _ \\| | | | '__| | '__/ _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\| | ┃\n"+
				leftBlank+"┃ | |  | | (_| |   <  __/ | |_| | (_) | |_| | |    | | |  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | |_| ┃\n"+
				leftBlank+"┃ |_|  |_|\\__,_|_|\\_\\___|  \\__, |\\___/ \\__,_|_|    |_|  \\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_(_) ┃\n"+
				leftBlank+"┃                           __/ |                                                                           ┃\n"+
				leftBlank+"┃                          |___/                                                                            ┃\n"+
				leftBlank+"┃                                                                                                           ┃\n"+
				leftBlank+"┗-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
	}

	public void hotelListView(List<HotelDTO> list) {

		Iterator<HotelDTO> it=list.iterator();
		int num=1;

		System.out.println("\n"+leftBlank+"■-━┳━━━━━┳━━-━┳━━━━━┳━━━━━┓");
		System.out.printf(leftBlank+"┃%3s┃%10s┃%7s┃%10s┃%10s┃\n","No.","Hotel Name","Class","Country","City");
		System.out.println(leftBlank+"┣-━╋━━━━━╋━━━-╋━━━━━╋━━━━━┫");

		while(it.hasNext()) {
			HotelDTO dto=it.next();	
			System.out.printf(leftBlank+"┃%3d┃%10s┃%1sClass┃%10s┃%10s┃\n",num++,dto.getHotelName(),dto.getHotelClass(),dto.getCountry(),dto.getCity());
			if(it.hasNext()) {
				System.out.println(leftBlank+"┣-━╋━━━━━╋━━━-╋━━━━━╋━━━━━┫");	
			}
		}
		System.out.println(leftBlank+"┗-━┻━━━━━┻━━━-┻━━━━━┻━━━━━┛\n");
	}

	public void hotelRoomListView(List<HotelDTO> list) {

		Iterator<HotelDTO> it=list.iterator();
		int num=1;

		System.out.println("\n"+leftBlank+"■-━┳━━━━━┳━--━-┓");
		System.out.printf(leftBlank+"┃%3s┃%10s┃%7s┃\n","No.","Room Name","Price");
		System.out.println(leftBlank+"┣-━╋━━━━━╋━━━-┫");

		while(it.hasNext()) {
			HotelDTO dto=it.next();	
			System.out.printf(leftBlank+"┃%3d┃%10s┃$%6d┃\n",num++,dto.getRoomName(),dto.getPrice());
			if(it.hasNext()) {
				System.out.println(leftBlank+"┣-━╋━━━━━╋━━━-┫");	
			}
		}
		System.out.println(leftBlank+"┗-━┻━━━━━┻━━━-┛\n");
	}


	public void calendarView(int year,int month,String answerHotelNameReturn,String answerRoomNameReturn,String hotelCodeRetrun) {

		Vector<String> thisMonth=new Vector<String>();
		Vector<String> nextMonth=new Vector<String>();
		class StateVO{
			int no;
			String state;
			public int getNo() {
				return no;
			}
			public void setNo(int no) {
				this.no = no;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
		}
		Vector<StateVO> thisState=new Vector<StateVO>();
		Vector<StateVO> nextState=new Vector<StateVO>();
		List<HotelDTO> reservedList=new ArrayList<HotelDTO>();
		Calendar cal=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		String strThisMonth=null,strNextMonth=null;
		int week,nextYear=year;

		//◆ 달력 조작
		cal.set(year, month-1, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			thisMonth.add("  ");
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=9) {
				thisMonth.add("0"+Integer.toString(i));
			}else {
				thisMonth.add(Integer.toString(i));
			}
			if(thisMonth.lastElement().equals(Integer.toString(cal.getActualMaximum(Calendar.DATE)))) {
				for(int j=0;j<=15;j++) {
					thisMonth.add("  ");
				}
			}
		}

		cal.set(year, month, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			nextMonth.add("  ");
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=9) {
				nextMonth.add("0"+Integer.toString(i));
			}else {
				nextMonth.add(Integer.toString(i));
			}
			if(nextMonth.lastElement().equals(Integer.toString(cal.getActualMaximum(Calendar.DATE)))) {
				for(int j=0;j<=15;j++) {
					nextMonth.add("  ");
				}
			}
		}

		if(month<=9) {
			strThisMonth="0"+Integer.toString(month);
		}else {
			strThisMonth=Integer.toString(month);
		}

		if(month+1<=9) {
			strNextMonth="0"+Integer.toString(month+1);
		}else {
			if(month+1<=12) {
				strNextMonth=Integer.toString(month+1);	
			}else {
				strNextMonth="0"+Integer.toString(1);
				nextYear+=1;
			}
		}

		//◆ 월별 객실 상태 표시
		cal.set(year, month-1, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			StateVO svo=new StateVO();
			svo.setNo(0);
			svo.setState("          ");
			thisState.add(svo);
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=cal.getActualMaximum(Calendar.DATE)) {
				StateVO svo=new StateVO();
				svo.setNo(i);
				svo.setState("■예약가능");	
				thisState.add(svo);
			}
			if(thisState.lastElement().getNo()==cal.getActualMaximum(Calendar.DATE)) {
				for(int j=0;j<=15;j++) {
					StateVO svo=new StateVO();
					svo.setNo(0);
					svo.setState("          ");
					thisState.add(svo);
				}
			}
		}

		cal.set(year, month, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			StateVO svo=new StateVO();
			svo.setNo(0);
			svo.setState("          ");
			nextState.add(svo);
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=cal.getActualMaximum(Calendar.DATE)) {
				StateVO svo=new StateVO();
				svo.setNo(i);
				svo.setState("■예약가능");	
				nextState.add(svo);
			}
			if(nextState.lastElement().getNo()==cal.getActualMaximum(Calendar.DATE)) {
				for(int j=0;j<=15;j++) {
					StateVO svo=new StateVO();
					svo.setNo(0);
					svo.setState("          ");
					nextState.add(svo);
				}
			}
		}

		//◆ 현재 날짜 이전 미표시
				cal=Calendar.getInstance();
				cal2.set(year, month-1, 1);
				if(year<cal.get(Calendar.YEAR)||(year==cal.get(Calendar.YEAR)&&month<cal.get(Calendar.MONTH)+1)) {
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}else if(year==cal.get(Calendar.YEAR)&&month==cal.get(Calendar.MONTH)+1){
					for(int i=0;i<=cal.get(Calendar.DATE)-1;i++) {
						thisState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}

				cal=Calendar.getInstance();
				cal2.set(year, month, 1);
				if(nextYear<cal.get(Calendar.YEAR)||(nextYear==cal.get(Calendar.YEAR)&&Integer.parseInt(strNextMonth)<cal.get(Calendar.MONTH)+1)) {
					cal.set(nextYear, Integer.parseInt(strNextMonth)-1, 1);
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}else if(nextYear==cal.get(Calendar.YEAR)&&Integer.parseInt(strNextMonth)==cal.get(Calendar.MONTH)+1){
					for(int i=0;i<=cal.get(Calendar.DATE)-1;i++) {
						nextState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}

		//◆ 2년 후 상태 미표시
		cal=Calendar.getInstance();
		if(year>cal.get(Calendar.YEAR)+2||(year==cal.get(Calendar.YEAR)+2&&month>cal.get(Calendar.MONTH)+1)) {
			cal.set(year, month-1, 1);
			for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
				thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
			}
		}else if(year==cal.get(Calendar.YEAR)+2&&month==cal.get(Calendar.MONTH)+1){
			for(int i=0;i<=cal.getActualMaximum(Calendar.DATE)-1;i++) {
				thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK))+cal.get(Calendar.DATE)+i).setState("          ");
			}
		}

		cal=Calendar.getInstance();
		if(nextYear>cal.get(Calendar.YEAR)+2||(nextYear==cal.get(Calendar.YEAR)+2&&Integer.parseInt(strNextMonth)>cal.get(Calendar.MONTH)+1)) {
			cal.set(nextYear, Integer.parseInt(strNextMonth)-1, 1);
			for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
				nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
			}
		}else if(nextYear==cal.get(Calendar.YEAR)+2&&Integer.parseInt(strNextMonth)==cal.get(Calendar.MONTH)+1){
			for(int i=0;i<=cal.getActualMaximum(Calendar.DATE)-1;i++) {
				nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK))+cal.get(Calendar.DATE)+i).setState("          ");
			}
		}

		//◆ 예약된 객실 표시 변경
		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql;
		int intCheckIn,intCheckOut;

		try {
			sql="select hotelcode,roomname,checkin,checkout from reservation";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				HotelDTO dto=new HotelDTO();

				dto.setHotelCode(rs.getString("hotelcode"));
				dto.setRoomName(rs.getString("roomname"));
				dto.setCheckIn(rs.getString("checkin"));
				dto.setCheckOut(rs.getString("checkout"));
				reservedList.add(dto);
			}

			Iterator<HotelDTO> it=reservedList.iterator();
			while(it.hasNext()) {
				HotelDTO dto=it.next();

				intCheckIn=Integer.parseInt(dto.getCheckIn().substring(0, 4)+dto.getCheckIn().substring(5, 7)+dto.getCheckIn().substring(8, 10));
				intCheckOut=Integer.parseInt(dto.getCheckOut().substring(0, 4)+dto.getCheckOut().substring(5, 7)+dto.getCheckOut().substring(8, 10));

				cal.set(year, month-1, 1);
				//this달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달에 체크인과 체크아웃이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<=Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//this달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달에 체크인이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//this달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달에 체크아웃이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month!=Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//this달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달이 체크인과 체크아웃 사이에 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month>Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}

				//this달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크인의 해에 해당하면서 체크인이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10));i<=cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-2)+i).setState("□매진    ");
					
					}
				}

				//this달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크인의 해에 해당하면서 체크인과 체크아웃 사이에 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month>Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//this달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크아웃의 해에 해당하면서 체크인과 체크아웃 사이에 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//this달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크아웃의 해에 해당하면서 체크아웃이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}

				cal.set(year, month, 1);
				//next달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달에 체크인과 체크아웃이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<=Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//next달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달에 체크인이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//next달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달에 체크아웃이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)!=Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//next달력 : 한 해에 체크인과 체크아웃이 있고, 출력 중인 달이 체크인과 체크아웃 사이에 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)>Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}

				//next달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크인의 해에 해당하면서 체크인이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10));i<=cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-2)+i).setState("□매진    ");
					
					}
				}

				//next달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크인의 해에 해당하면서 체크인과 체크아웃 사이에 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)>Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//next달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크아웃의 해에 해당하면서 체크인과 체크아웃 사이에 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
				
				//next달력 : 한 해에 체크인이 있고 다음해에 체크아웃이 있는 상태에서, 출력 중인 달이 체크아웃의 해에 해당하면서 체크아웃이 있을 때.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("□매진    ");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				leftBlank+"▶ "+answerHotelNameReturn+" / "+answerRoomNameReturn+" Calendar"+"\n"+
				leftBlank+"■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"+middleBlank+"■-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"+
				leftBlank+"┃      _    _       _       _                                      _   _                  ┃"+middleBlank+"┃      _    _       _       _                                      _   _                  ┃\n"+
				leftBlank+"┃     | |  | |     | |     | |                                    | | (_)                 ┃"+middleBlank+"┃     | |  | |     | |     | |                                    | | (_)                 ┃\n"+
				leftBlank+"┃     | |__| | ___ | |_ ___| |  _ __ ___  ___  ___ _ ____   ____ _| |_ _  ___  _ __       ┃"+middleBlank+"┃     | |__| | ___ | |_ ___| |  _ __ ___  ___  ___ _ ____   ____ _| |_ _  ___  _ __       ┃\n"+
				leftBlank+"┃     |  __  |/ _ \\| __/ _ \\ | | '__/ _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\      ┃"+middleBlank+"┃     |  __  |/ _ \\| __/ _ \\ | | '__/ _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\      ┃\n"+
				leftBlank+"┃     | |  | | (_) | ||  __/ | | | |  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | |     ┃"+middleBlank+"┃     | |  | | (_) | ||  __/ | | | |  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | |     ┃\n"+
				leftBlank+"┃     |_|  |_|\\___/ \\__\\___|_| |_|  \\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_|     ┃"+middleBlank+"┃     |_|  |_|\\___/ \\__\\___|_| |_|  \\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_|     ┃\n"+
				leftBlank+"┃                                                                                         ┃"+middleBlank+"┃                                                                                         ┃\n"+
				leftBlank+"┃                                                                                         ┃"+middleBlank+"┃                                                                                         ┃\n"+
				leftBlank+"┣-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫"+middleBlank+"┣-━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n"+
				leftBlank+"┃"+year+" / "+strThisMonth+"                                                                                ┃"+middleBlank+"┃"+nextYear+" / "+strNextMonth+"                                                                                ┃\n"+
				leftBlank+"┣-━━━━━┳━━-━━━┳━━━━━-┳━━━━━-┳━━━━━-┳━━━━━-┳━━━━━-┫"+middleBlank+"┣-━━━━━┳━━-━━━┳━━━━━-┳━━━━━-┳━━━━━-┳━━━━━-┳━━━━━-┫\n"+
				leftBlank+"┃    SUN    ┃    MON    ┃    TUS    ┃    WED    ┃    THU    ┃    FRI    ┃    SAT    ┃"+middleBlank+"┃    SUN    ┃    MON    ┃    TUS    ┃    WED    ┃    THU    ┃    FRI    ┃    SAT    ┃\n"+
				leftBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫"+middleBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫\n"+
				leftBlank+"┃"+thisMonth.get(0)+"         ┃"+thisMonth.get(1)+"         ┃"+thisMonth.get(2)+"         ┃"+thisMonth.get(3)+"         ┃"+thisMonth.get(4)+"         ┃"+thisMonth.get(5)+"         ┃"+thisMonth.get(6)+"         ┃"+middleBlank+"┃"+nextMonth.get(0)+"         ┃"+nextMonth.get(1)+"         ┃"+nextMonth.get(2)+"         ┃"+nextMonth.get(3)+"         ┃"+nextMonth.get(4)+"         ┃"+nextMonth.get(5)+"         ┃"+nextMonth.get(6)+"         ┃\n"+
				leftBlank+"┃"+thisState.elementAt(0).getState()+" ┃"+thisState.elementAt(1).getState()+" ┃"+thisState.elementAt(2).getState()+" ┃"+thisState.elementAt(3).getState()+" ┃"+thisState.elementAt(4).getState()+" ┃"+thisState.elementAt(5).getState()+" ┃"+thisState.elementAt(6).getState()+" ┃"+middleBlank+"┃"+nextState.elementAt(0).getState()+" ┃"+nextState.elementAt(1).getState()+" ┃"+nextState.elementAt(2).getState()+" ┃"+nextState.elementAt(3).getState()+" ┃"+nextState.elementAt(4).getState()+" ┃"+nextState.elementAt(5).getState()+" ┃"+nextState.elementAt(6).getState()+" ┃\n"+
				leftBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫"+middleBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫\n"+
				leftBlank+"┃"+thisMonth.get(7)+"         ┃"+thisMonth.get(8)+"         ┃"+thisMonth.get(9)+"         ┃"+thisMonth.get(10)+"         ┃"+thisMonth.get(11)+"         ┃"+thisMonth.get(12)+"         ┃"+thisMonth.get(13)+"         ┃"+middleBlank+"┃"+nextMonth.get(7)+"         ┃"+nextMonth.get(8)+"         ┃"+nextMonth.get(9)+"         ┃"+nextMonth.get(10)+"         ┃"+nextMonth.get(11)+"         ┃"+nextMonth.get(12)+"         ┃"+nextMonth.get(13)+"         ┃\n"+
				leftBlank+"┃"+thisState.elementAt(7).getState()+" ┃"+thisState.elementAt(8).getState()+" ┃"+thisState.elementAt(9).getState()+" ┃"+thisState.elementAt(10).getState()+" ┃"+thisState.elementAt(11).getState()+" ┃"+thisState.elementAt(12).getState()+" ┃"+thisState.elementAt(13).getState()+" ┃"+middleBlank+"┃"+nextState.elementAt(7).getState()+" ┃"+nextState.elementAt(8).getState()+" ┃"+nextState.elementAt(9).getState()+" ┃"+nextState.elementAt(10).getState()+" ┃"+nextState.elementAt(11).getState()+" ┃"+nextState.elementAt(12).getState()+" ┃"+nextState.elementAt(13).getState()+" ┃\n"+
				leftBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫"+middleBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫\n"+
				leftBlank+"┃"+thisMonth.get(14)+"         ┃"+thisMonth.get(15)+"         ┃"+thisMonth.get(16)+"         ┃"+thisMonth.get(17)+"         ┃"+thisMonth.get(18)+"         ┃"+thisMonth.get(19)+"         ┃"+thisMonth.get(20)+"         ┃"+middleBlank+"┃"+nextMonth.get(14)+"         ┃"+nextMonth.get(15)+"         ┃"+nextMonth.get(16)+"         ┃"+nextMonth.get(17)+"         ┃"+nextMonth.get(18)+"         ┃"+nextMonth.get(19)+"         ┃"+nextMonth.get(20)+"         ┃\n"+
				leftBlank+"┃"+thisState.elementAt(14).getState()+" ┃"+thisState.elementAt(15).getState()+" ┃"+thisState.elementAt(16).getState()+" ┃"+thisState.elementAt(17).getState()+" ┃"+thisState.elementAt(18).getState()+" ┃"+thisState.elementAt(19).getState()+" ┃"+thisState.elementAt(20).getState()+" ┃"+middleBlank+"┃"+nextState.elementAt(14).getState()+" ┃"+nextState.elementAt(15).getState()+" ┃"+nextState.elementAt(16).getState()+" ┃"+nextState.elementAt(17).getState()+" ┃"+nextState.elementAt(18).getState()+" ┃"+nextState.elementAt(19).getState()+" ┃"+nextState.elementAt(20).getState()+" ┃\n"+
				leftBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫"+middleBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫\n"+
				leftBlank+"┃"+thisMonth.get(21)+"         ┃"+thisMonth.get(22)+"         ┃"+thisMonth.get(23)+"         ┃"+thisMonth.get(24)+"         ┃"+thisMonth.get(25)+"         ┃"+thisMonth.get(26)+"         ┃"+thisMonth.get(27)+"         ┃"+middleBlank+"┃"+nextMonth.get(21)+"         ┃"+nextMonth.get(22)+"         ┃"+nextMonth.get(23)+"         ┃"+nextMonth.get(24)+"         ┃"+nextMonth.get(25)+"         ┃"+nextMonth.get(26)+"         ┃"+nextMonth.get(27)+"         ┃\n"+
				leftBlank+"┃"+thisState.elementAt(21).getState()+" ┃"+thisState.elementAt(22).getState()+" ┃"+thisState.elementAt(23).getState()+" ┃"+thisState.elementAt(24).getState()+" ┃"+thisState.elementAt(25).getState()+" ┃"+thisState.elementAt(26).getState()+" ┃"+thisState.elementAt(27).getState()+" ┃"+middleBlank+"┃"+nextState.elementAt(21).getState()+" ┃"+nextState.elementAt(22).getState()+" ┃"+nextState.elementAt(23).getState()+" ┃"+nextState.elementAt(24).getState()+" ┃"+nextState.elementAt(25).getState()+" ┃"+nextState.elementAt(26).getState()+" ┃"+nextState.elementAt(27).getState()+" ┃\n"+
				leftBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫"+middleBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫\n"+
				leftBlank+"┃"+thisMonth.get(28)+"         ┃"+thisMonth.get(29)+"         ┃"+thisMonth.get(30)+"         ┃"+thisMonth.get(31)+"         ┃"+thisMonth.get(32)+"         ┃"+thisMonth.get(33)+"         ┃"+thisMonth.get(34)+"         ┃"+middleBlank+"┃"+nextMonth.get(28)+"         ┃"+nextMonth.get(29)+"         ┃"+nextMonth.get(30)+"         ┃"+nextMonth.get(31)+"         ┃"+nextMonth.get(32)+"         ┃"+nextMonth.get(33)+"         ┃"+nextMonth.get(34)+"         ┃\n"+
				leftBlank+"┃"+thisState.elementAt(28).getState()+" ┃"+thisState.elementAt(29).getState()+" ┃"+thisState.elementAt(30).getState()+" ┃"+thisState.elementAt(31).getState()+" ┃"+thisState.elementAt(32).getState()+" ┃"+thisState.elementAt(33).getState()+" ┃"+thisState.elementAt(34).getState()+" ┃"+middleBlank+"┃"+nextState.elementAt(28).getState()+" ┃"+nextState.elementAt(29).getState()+" ┃"+nextState.elementAt(30).getState()+" ┃"+nextState.elementAt(31).getState()+" ┃"+nextState.elementAt(32).getState()+" ┃"+nextState.elementAt(33).getState()+" ┃"+nextState.elementAt(34).getState()+" ┃\n"+
				leftBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫"+middleBlank+"┣-━━━━━╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-╋━━━━━-┫\n"+
				leftBlank+"┃"+thisMonth.get(35)+"         ┃"+thisMonth.get(36)+"         ┃"+thisMonth.get(37)+"         ┃"+thisMonth.get(38)+"         ┃"+thisMonth.get(39)+"         ┃"+thisMonth.get(40)+"         ┃"+thisMonth.get(41)+"         ┃"+middleBlank+"┃"+nextMonth.get(35)+"         ┃"+nextMonth.get(36)+"         ┃"+nextMonth.get(37)+"         ┃"+nextMonth.get(38)+"         ┃"+nextMonth.get(39)+"         ┃"+nextMonth.get(40)+"         ┃"+nextMonth.get(41)+"         ┃\n"+
				leftBlank+"┃"+thisState.elementAt(35).getState()+" ┃"+thisState.elementAt(36).getState()+" ┃"+thisState.elementAt(37).getState()+" ┃"+thisState.elementAt(38).getState()+" ┃"+thisState.elementAt(39).getState()+" ┃"+thisState.elementAt(40).getState()+" ┃"+thisState.elementAt(41).getState()+" ┃"+middleBlank+"┃"+nextState.elementAt(35).getState()+" ┃"+nextState.elementAt(36).getState()+" ┃"+nextState.elementAt(37).getState()+" ┃"+nextState.elementAt(38).getState()+" ┃"+nextState.elementAt(39).getState()+" ┃"+nextState.elementAt(40).getState()+" ┃"+nextState.elementAt(41).getState()+" ┃\n"+
				leftBlank+"┗-━━━━━┻━━━━━-┻━━━━━-┻━━━━━-┻━━━━━-┻━━━━━-┻━━━━━-┛"+middleBlank+"┗-━━━━━┻━━━━━-┻━━━━━-┻━━━━━-┻━━━━━-┻━━━━━-┻━━━━━-┛\n\n\n\n\n\n\n\n\n\n");
	}

	public void blank() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
