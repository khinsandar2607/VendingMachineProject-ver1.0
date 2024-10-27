package com.demo;
/*
 * 商品クラス
 * 属性：商品名、価格、在庫数量
 */
public class Item {
	private String itemName; // 商品名
	private int price; // 価格
	private int stock; // 在庫数量
	private String category; // カテゴリ
	
	//constructor
	public Item(String itemName, int price, int stock) {
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}
	
	public Item(String category) {
		this.category = category;
	}
		
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	// Reduce stock
	public void reduceStock() {
		if(stock > 0) {
		 stock--;
		}
	}

	
}
