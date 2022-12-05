package com.group12.petweb.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;

@Embeddable
public class CartItemId implements Serializable {
	private UUID cartId;
	private UUID petId;

	@Column(name = "CART_ID")
	public UUID getCartId() {
		return cartId;
	}

	@Column(name = "PET_ID")
	public UUID getPetId() {
		return petId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public void setPetId(UUID petId) {
		this.petId = petId;
	}

	@Override
	public String toString() {
		return "CartItemId{" +
				"cartId='" + cartId + '\'' +
				", petId='" + petId + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		final var itemId = (CartItemId) obj;
		return this.cartId == itemId.cartId && this.petId == itemId.petId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.cartId == null) ? 0 : cartId.hashCode());
		result = prime * result
				+ ((this.petId == null) ? 0 : petId.hashCode());
		return result;
	}
}
