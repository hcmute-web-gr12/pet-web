package com.group12.petweb.model;

import org.jetbrains.annotations.NotNull;

import jakarta.persistence.*;

@Entity
@Table(name = "CART_ITEM")
public class CartItem {
	private CartItemId cartItemId;
	private Cart cart;
	private Pet pet;
	private int quantity;

	@EmbeddedId
	public CartItemId getCartItemId() {
		return cartItemId;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CART")
	@MapsId("cartId")
	public Cart getCart() {
		return cart;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "PET")
	@MapsId("petId")
	public Pet getPet() {
		return pet;
	}

	@NotNull
	@Column(name = "QUANTITY")
	public int getQuantity() {
		return quantity;
	}

	public void setCartItemId(CartItemId cartItemId) {
		this.cartItemId = cartItemId;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem{" +
				"cart='" + cart.getId() + '\'' +
				", pet='" + pet.getId() + '\'' +
				", quantity='" + quantity + '\'' +
				'}';
	}
}
