package com.project.dto;

import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;

public class BillDTO extends AbstractDTO<BillDTO> {

	private Long userId;
	private Long productId;
	private Long amount;
	private String productName;
	private String productColor;
	private Long productSold;
	private String customerName;
	private String phoneNumber;
	private String address;
	private String dateOfBill;
	private String statusOfBill;
	private UserEntity user;
	private ProductEntity product;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public Long getProductSold() {
		return productSold;
	}
	public void setProductSold(Long productSold) {
		this.productSold = productSold;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBill() {
		return dateOfBill;
	}
	public void setDateOfBill(String dateOfBill) {
		this.dateOfBill = dateOfBill;
	}
	public String getStatusOfBill() {
		return statusOfBill;
	}
	public void setStatusOfBill(String statusOfBill) {
		this.statusOfBill = statusOfBill;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
