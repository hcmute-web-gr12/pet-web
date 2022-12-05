package com.group12.petweb.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import jakarta.persistence.*;

@Entity
@Table(name = "CART")
public class Cart {
	private UUID id;
	private UserCredentials user;
	private List<CartItem> items;
	private Timestamp createdDate;

	@Id
	@NotNull
	@Column(name = "ID")
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	public UUID getId() {
		return id;
	}

	@Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	@NotNull
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "USER")
	public UserCredentials getUser() {
		return user;
	}

	@Column(name = "ITEMS")
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<CartItem> getItems() {
		return items;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setUser(UserCredentials user) {
		this.user = user;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	protected void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", createdDate='" + createdDate + '\'' +
				", user='" + user.getId() + '\'' +
				", items='" + items + '\'' +
				'}';
	}
}
