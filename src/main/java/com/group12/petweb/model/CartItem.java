package com.group12.petweb.model;

import org.jetbrains.annotations.NotNull;

import jakarta.persistence.*;

@Entity
@Table(name = "CART_ITEM")
public class CartItem {
	private CartItemId id = new CartItemId();
	private Cart cart;
	private Pet pet;
	private int quantity;

	public CartItem() {
	}

	public CartItem(Cart cart, Pet pet, int quantity) {
		this.cart = cart;
		this.pet = pet;
		this.quantity = quantity;
	}

	@EmbeddedId
	public CartItemId getId() {
		return id;
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

	public void setId(CartItemId id) {
		this.id = id;
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
				"id='" + id + '\'' +
				", cart='" + cart.getId() + '\'' +
				", pet='" + pet.getId() + '\'' +
				", quantity=" + quantity +
				'}';
	}
}
