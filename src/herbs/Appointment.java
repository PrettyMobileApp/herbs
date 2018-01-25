package herbs;

import java.io.Serializable;

public class Appointment implements Serializable{
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	String mobile;
	String status;
	String note;
	String day;
	String time;
	//String date;
	String[] detail;	
	
	public String[] getDetail() {
		return detail;
	}	

	public Appointment(String[] detail){
		if(detail[0].length() <= 1){
			id = Integer.toString( 100000+ (int)(Math.random()*900000));
			
		}else{
			id = detail[0];
		}
		this.detail = detail;
		if(detail[1].length()>19){detail[1] = detail[1].substring(0, 18);}
		name = detail[1];
		if(detail[2].length()>15){detail[2] = detail[2].substring(0, 14);}
		mobile = detail[2];
		day = detail[3];
		time = detail[4];
		status = detail[5];	
		if(detail[6].length()>60){detail[6] = detail[6].substring(0, 59);}
		note = detail[6];
		//date = detail[7];
	}	
	
	
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTime() {
		return time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return time + "   " + printFormat(status, 11) + printFormat(name, 20) + printFormat(mobile, 15) + printFormat(note, 60) + id;
		//return String.format(" %-15.15s \t\t %-15.15s \t\t %-25.25s \t\t %-15.15s \t\t %-60.55s", time, status, name, mobile, note);
		//return time + status + "" + name + "" + mobile;
		
		
	}
	
	private String printFormat(String s, int length){
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		for(int i=s.length(); i<length; i++){
			sb.append(" ");
		}
		
		return sb.toString();
		
	}
	
	
	
}

