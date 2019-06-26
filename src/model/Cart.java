package model;

public class Cart {
	private int cart_id;
	private String email;
	private String img_src;
	private float price;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "{\"" + "img_src\":\"" + img_src + "\", \"price\":\"" + price
				+  "\"}";
	}
	public static void main(String[] args) {
		Cart cart = new Cart();
		System.out.println(cart);
	}
}
