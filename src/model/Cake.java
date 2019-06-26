package model;

public class Cake {
	private int cake_id;
	private String cake_name;
	private float cake_price;
	private float cake_discount;
	public int getCake_id() {
		return cake_id;
	}
	public void setCake_id(int cake_id) {
		this.cake_id = cake_id;
	}
	public String getCake_name() {
		return cake_name;
	}
	public void setCake_name(String cake_name) {
		this.cake_name = cake_name;
	}
	public float getCake_price() {
		return cake_price;
	}
	public void setCake_price(float cake_price) {
		this.cake_price = cake_price;
	}
	public float getCake_discount() {
		return cake_discount;
	}
	public void setCake_discount(float cake_discount) {
		this.cake_discount = cake_discount;
	}
	@Override
	public String toString() {
		return "Cake [cake_id=" + cake_id + ", cake_name=" + cake_name + ", cake_price=" + cake_price
				+ ", cake_discount=" + cake_discount + "]";
	}
	
}
