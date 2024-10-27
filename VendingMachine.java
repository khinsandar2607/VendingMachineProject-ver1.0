package com.demo;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private List<Item> items;
	private List<Item> categories;
	private int currentMoney;
	
	public VendingMachine() {
		items = new ArrayList();
		currentMoney = 0;
	}
	
	public void addCategory(Item category) {
		categories.add(category);
	}
	
	// 商品追加
	public void addItem(Item item) {
		items.add(item);
	}
	
	// お金投入
	public void insertMoney(int money) {
		if(money > 0) {
			currentMoney += money;
		}else {
			System.out.println("無効な金額です。\nお金を投入ください。");
		}
	}
	
	// 商品　カテゴリ表示
	public void showCagetories() {
		System.out.println("--------商品 カテゴリ　一覧--------");
		System.out.println("--------------------------------");
		for (Item category : categories) {
			System.out.printf("%s \n", category.getCategory());
		}
	}

	// 商品表示
	public void showItems() {
		System.out.println("----------------------");
		System.out.println("--------商品一覧--------");
		System.out.println("-----------------------");
//		for(int i = 0; i < items.size(); i++) {
//			Item listItem = items.get(i);
//			 System.out.printf("%d. %s - %d円（在庫：%d個）\n", i + 1,  listItem.getItemName(), listItem.getPrice(), listItem.getStock());
//		}
		for (Item item : items) {
			System.out.printf("%s - %d円) (在庫数：%d個)\n", item.getItemName(), item.getPrice(), item.getStock());
		}
	}
	
	// 商品購入
	public void buyItems(int itemNumber) {
		if(itemNumber < 0 || itemNumber > items.size()) {
			System.out.println("無効な商品番号です。商品番号は" + "1〜" + items.size() + "をお選びください");
			return;
		}
		Item item = items.get(itemNumber - 1);
		if(currentMoney >= item.getPrice() && item.getStock() > 0) {
			//currentMoney = currentMoney - item.getPrice();
			currentMoney -= item.getPrice();
			item.reduceStock();
			System.out.println(item.getItemName() + "を購入。　残り金額は" + currentMoney + "円です。");
		} else if (currentMoney < item.getPrice()) {
			System.out.println("金額が不足しています。もう一度ご確認ください");
		} else {
			System.out.println("在庫がありません。");
		}
	}
	
	// お釣りの払い戻し
	public void refund() {
		System.out.println("お釣りは" + currentMoney + "円です。");
		currentMoney = 0;
	}
}
