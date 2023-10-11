package ServiceMenu;

import java.util.List;
import java.util.Scanner;

import cartTxt.CaetFileMap;
import cartTxt.Price;
import method.MemberShip;
import method.UserManager;

public class ListChoice {
	public static Scanner sc = new Scanner(System.in);

	public static void showMenu(MemberShip loggedInUser) {
		int choice = 0;
		boolean stop = false;
		while (!stop) {
			DetailedList();
			System.out.printf("선택>>> ");
			int numOrder = sc.nextInt();
			if (numOrder < 1 || numOrder > 5) {
				System.out.println("목록 내에서 활동바랍니다.");
			} else {
				switch (numOrder) {
				case 1:
					// 계정 메뉴 처리
					Memberinformation(loggedInUser);
					break;
				case 2:
					// 대여공간 리스트
					RentList();
					//구매하기(선택)
					SpaceSelection();
					
					break;
				case 3:
					// 장바구니 1.구매목록(수량, 가격)보이게하기 2.구매취소 누르면 취소 되게
					CartListOfRevoke();
					System.out.println("1.구매목록 2.구매취소 3.exit");
					System.out.println("===============================");
					int buy = sc.nextInt();
					
					switch (buy) {
					case 1:
						System.out.println("===============================");
						List<String> cartContents = CaetFileMap.readCart();
						for (int i = 1; i < cartContents.size(); i++) {
							System.out.println(i + ". " + cartContents.get(i));
						}
						System.out.println("===============================");
						break;
					case 2:
						List<String> cartList = CaetFileMap.readCart();
						System.out.println(cartList);
						System.out.print("제거할 항목을 입력하세요: ");
						String shaceNum = sc.next();
						for (int i = 1; i < cartList.size(); i++) {
							if (cartList.get(i).contains(shaceNum)) {
								CaetFileMap.removeFromCart(i - 1);
								stop = true;
								System.out.println(shaceNum + " 항목이 카트에서 제거되었습니다.");
								break;
							}
						}
						if (!stop) {
							System.out.println(shaceNum + " 항목을 찾을 수 없습니다.");
						}
						break;
					case 3:
						stop = true;
						break;
					}
					break;
				case 4:
					// 영수증
					//저장 값 문자열로 들고오기
					List<String> cartContents = CaetFileMap.readCart();
					int totalCost = 0; // 총 가격을 저장할 변수
					int spacesOfNum = 1;
					
				    for (int i = 1; i < cartContents.size(); i++) {
				        String cartItem = cartContents.get(i);
				     // substring 문자열자르기 첫 글자 S, A, B, C
				        String spaceType = cartItem.substring(0, 1); 
				        int spaceCount = Integer.parseInt(cartItem.substring(1)); // 숫자 1 ~ 10

				        int spacePrice = Price.getPrice(spaceType);
				        if (spacePrice > 0) {
				            int itemTotal = spacePrice * spacesOfNum;
				            System.out.printf("%d. %s%d 수량: %d  가격: %d\n", i, spaceType, spaceCount,spacesOfNum,spacePrice);
				            totalCost += itemTotal;
				        } else {
				            System.out.println("올바르지 않은 항목: " + cartItem);
				        }
				    }
				    
				    System.out.println("총 금액: " + totalCost + "원");
					
					break;
				case 5:
					System.out.println("나가기");
					stop = true;
					break;
				}
			}
		} // while

	}

	private static void CartListOfRevoke() {
		// TODO Auto-generated method stub
		
	}


	// 계정 나의 정보
	private static void Memberinformation(MemberShip memberShip) {

		System.out.println("===============================");
		System.out.println();
		System.out.println("계정 정보:");
		System.out.println("ID: " + memberShip.getId());
		System.out.println("이름: " + memberShip.getName());
		System.out.println("전화번호: " + memberShip.getPhoneNum());
		System.out.println();
		System.out.println("===============================");

	}

	// 세부리스트 목록
	private static void DetailedList() {
		System.out.println("===============================");
		System.out.println("1. 계정");
		System.out.println("2. 렌탈서비스");
		System.out.println("3. 장바구니");
		System.out.println("4. 영수증");
		System.out.println("5. 나가기");
		System.out.println("===============================");

	}

	// 대여공간 리스트
	private static void RentList() {
		System.out.println("===============================");
		System.out.println("1.S: 15평  |  2.A: 10평  |  3.B: 8평  |  4.C: 5평 ");
		System.out.println("===============================");
		System.out.println("s : S1 S2 S3 S4 S5 S6 S7 S8 S9 S10");
		System.out.println("A : A1 A2 A3 A4 A5 A6 A7 A8 A9 A10");
		System.out.println("B : B1 B2 B3 B4 B5 B6 B7 B8 B9 B10");
		System.out.println("C : C1 C2 C3 C4 C5 C6 C7 C8 C9 C10");
		System.out.println("===============================");
	}

	//렌탈 공간대여 구매하기(선택)
	private static void SpaceSelection() {
		int choice = 0;
		boolean stop = false;
		System.out.println("S: 15평  |  A: 10평  |  B: 8평  |  C: 5평 |  E: Exit");
		System.out.println("20일기준 S: 300000  |  A: 250000 |  B: 200000  |  C: 150000 ");
		System.out.println("원하는 크기에 컨테이너 공간을 선택>>");
		String sizString = sc.next();
		if (sizString.equals("E")) {
			stop = true;
		} else if ("SABC".contains(sizString)) {
			System.out.println("렌탈목록을 선택하셨습니다.");
			System.out.println("1Space / 2Space / 3Space / 4Space / 5Space / 6Space "
					+ "/ 7Space / 8Space / 9Space / 10Space");
			System.out.print("원하는 컨테이너 숫자(1~10)를 선택하세요: ");
			choice = sc.nextInt();
			if (1 <= choice && choice <= 10) {
				System.out.printf("렌탈 목록에 %s %d 를 를 저장하였습니다.\n", sizString, choice);
				CaetFileMap.addToCart(sizString + choice);
				System.out.println("카트에 항목이 추가되었습니다.");
			} else {
				System.out.println("올바른 번호를 선택하세요.");
			}
			System.out.println("===============================");
		} else {
			System.out.println("올바른 크기를 선택하세요 (S/A/B/C/E).");
		}
		
	}
	
	
}
