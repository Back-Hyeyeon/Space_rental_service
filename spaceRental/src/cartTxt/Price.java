package cartTxt;

public class Price {
	public static int getPrice(String receipt) {
		// 각 공간에 대한 가격 설정
		if (receipt.equals("S")) {
			return 300000;
		} else if (receipt.equals("A")) {
			return 250000;
		} else if (receipt.equals("B")) {
			return 200000;
		} else if (receipt.equals("C")) {
			return 150000;
		} else {
			return 0;
		}
	}
}