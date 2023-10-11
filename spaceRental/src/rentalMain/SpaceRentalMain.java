package rentalMain;

import java.util.Scanner;

import ServiceMenu.ListChoice;
import method.MemberShip;
import method.Menu;
import method.UserManager;

public class SpaceRentalMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		MemberShip memberShip = new MemberShip();
		ListChoice listChoice = new ListChoice();
		
		boolean stop = false;
		while (!stop) {
			Menu.menuPick();

			System.out.printf("선택>>> ");
			int numOrder = sc.nextInt();

			if (numOrder < 1 || numOrder > 4) {
				System.out.println("정해진 선택을 하시기 바랍니다");
			} else {
				switch (numOrder) {
				case 1:
					System.out.printf("============= %d 번 ============\n", numOrder);
					// 회원가입 memberShip
//					Menu.menuPick();
					System.out.println("ID : ");
					String idName = sc.next();
					System.out.println("PW : ");
					String pwnum = sc.next();
					System.out.println("이름 : ");
					String name = sc.next();
					System.out.println("전화번호 : ");
					String ponNum = sc.next();

					MemberShip member = MemberShip.membership(idName, pwnum, name, pwnum);
					userManager.adduaer(member);

					break;
				case 2:
					System.out.printf("============= %d 번 ============\n", numOrder);
					// 로그인 login
					if (userManager.getLoginuaer() != null) {
						System.out.println("이미 로그인 되어있습니다.");
					} else {
						System.out.println("ID : ");
						idName = sc.next();
						System.out.println("PW : ");
						pwnum = sc.next();
						sc.nextLine();
						  if (!userManager.login(idName, pwnum)) {
					            System.out.println("로그인 되었습니다.");
					        } else {
					            System.out.println("잘 못된 ID와 PW입니다.");
					        }
					} 
					break;
				case 3:
					System.out.printf("============= %d 번 ============\n", numOrder);
					// 메뉴보기 menu
					MemberShip loggedInUser = userManager.getLoginuaer();
					if (loggedInUser != null) {
						listChoice. showMenu(loggedInUser);
                    } else {
                        System.out.println("로그인 후에만 이용 가능합니다.");
                    }
                
					break;
				case 4:
					System.out.printf("============= %d 번 ============\n", numOrder);
					System.out.println("end");
					stop = true;
					break;
				case 5: 
					//관리자로그인
					break;
				}// switch
			} // else

		} // while

	}// main

	

}
