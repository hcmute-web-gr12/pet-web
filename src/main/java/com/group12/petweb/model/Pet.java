package com.group12.petweb.model;

import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import jakarta.persistence.*;

@Entity
@Table(name = "PET")
public class Pet {
	private UUID id;
	private String name;
	private long price;
	private long stock;
	private String imageUrl;
	private String description;

	@Id
	@NotNull
	@Column(name = "ID")
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	public UUID getId() {
		return id;
	}

	@NotNull
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	@Column(name = "PRICE")
	public long getPrice() {
		return price;
	}

	@Column(name = "STOCK")
	public long getStock() {
		return stock;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	@Column(name = "IMAGE_URL")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Pet{" +
				"id=" + id +
				", name='" + name + '\'' +
				", stock='" + stock + '\'' +
				", price='" + price + '\'' +
				", description='" + description + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				'}';
	}
}
