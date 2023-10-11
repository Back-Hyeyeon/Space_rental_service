package cartTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CaetFileMap {
	private static final String CART_FILE_NAME = "Cart.txt";

	//
	public static List<String> readCart() {
		List<String> cart = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(CART_FILE_NAME))) {
			String line;
			while ((line = br.readLine()) != null) {
				cart.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cart;
	}

	// 카트에 추가 하는 소스
	public static void addToCart(String rentalList) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(CART_FILE_NAME, true))) {
			bw.write(rentalList);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 카트에서 제거하는 소스 remove
	public static void removeFromCart(int index) {
		List<String> cartContents = readCart();
		if (index >= 0 && index < cartContents.size()) {
			cartContents.remove(index);
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(CART_FILE_NAME))) {
				for (String item : cartContents) {
					bw.write(item);
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}