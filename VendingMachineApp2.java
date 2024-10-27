package com.demo;

import java.util.Scanner;

public class VendingMachineApp2 {

	public static void main(String[] args) {
		VendingMachine vending = new VendingMachine();
		Scanner scanner = new Scanner(System.in);
		int answer;
		// 商品 カテゴリ追加
		vending.addCategory(new Item("Drink"));
		vending.addCategory(new Item("Food"));
		// 商品追加
//		Item item = new Item("Water", 130, 20);
//		vending.addItem(item);
		vending.addItem(new Item("Water", 130, 1));
		vending.addItem(new Item("Ice Tea", 150, 1));
		vending.addItem(new Item("Coffee", 140, 1));
		vending.addItem(new Item("Monster", 160, 1));
		System.out.println("test");
		
		do {
			System.out.println("-----自動販売機----");
			vending.showCagetories();
			vending.showItems();
			System.out.println("1:お金を投入する");
			System.out.println("2:商品を購入する");
			System.out.println("3: お釣りを払い戻す");
            System.out.println("4: 終了する");
            System.out.print("選択: ");
			int selectItem = scanner.nextInt();
			switch(selectItem) {
			case 1: 
				System.out.println("投入金額を入力ください。");
				int money = scanner.nextInt();
				System.out.println("投入金額は" + money + "円");
				vending.insertMoney(money);
			case 2:
				System.out.println("購入したい商品番号を選んでください。");
				int itemNumber = scanner.nextInt();
				vending.buyItems(itemNumber);
			case 3:
				vending.refund();
			case 4:
				answer = 2;
				System.out.println("自動販売機を終了します。");
				break;
			default:
				System.out.println("無効な選択です。");
			}
			System.out.println("また購入したいですか ? はい : 1, いいえ : 2　を入力ください。");
			answer = scanner.nextInt();
		} while(answer == 1);
	}
}
