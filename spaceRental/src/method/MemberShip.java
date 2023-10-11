package method;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MemberShip {
	// 회원가입

	private String id = null;
	private String pw = null;
	private String name = null;
	private String phoneNum = null;

	public MemberShip() {
	}
	
	public MemberShip(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public MemberShip(String id, String pw, String name, String phoneNum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
	//회원가입 정보 텍스트 파일에 저장
	public void saveMember() {
		try {
			FileWriter fw = new FileWriter("member.txt");
			PrintWriter printW = new PrintWriter(fw);
			//회원정보 파일에 추가
			printW.printf("ID : %s\n",id);
			printW.printf("ID : %s\n",pw);
			printW.printf("ID : %s\n",name);
			printW.printf("ID : %s\n",phoneNum);
			printW.println();//빈 줄로 구분
			
			System.out.println("회원가입 되었습니다. 로그인해주세요");
			printW.close();
			
		} catch (IOException e) {
			System.out.println("오류. 종료후 다시 시도해 주세요.");
			e.printStackTrace();
		}
	}
	//회원가입 메소드
	public static MemberShip membership(String id, String pw, String name, String phoneNum) {
		MemberShip member = new MemberShip(id,pw,name,phoneNum);
		member.saveMember();
		return member;
	}
	

}
