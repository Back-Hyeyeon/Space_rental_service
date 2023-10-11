package method;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
	private static List<MemberShip> uaers;
	private static MemberShip loginuaer;

	public UserManager() {
		uaers = new ArrayList<>();
		loginuaer = null;
	}

	// 로그인 메서드
	public boolean login(String id, String pw) {
		for (MemberShip uaer : uaers) {
			if (uaer.getId().equals(id) && uaer.getPw().equals(pw)) {
				loginuaer = uaer;
			}
		}
		return false;
	}

	// 로그아웃 매서드
	public void logout() {
		loginuaer = null;
	}


	//회원가입 메서드
	public  void adduaer(MemberShip uaer) {
		uaers.add(uaer);
	}

	// 사용자 리스트 반환 매서드
	public  List<MemberShip> getUaers() {
		return uaers;
	}
	// 로그인 사용자 반환하는 매서드
	public  MemberShip getLoginuaer() {
		return loginuaer;
	}



}
