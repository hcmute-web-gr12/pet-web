package com.group12.petweb.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import jakarta.persistence.*;

@Entity
@Table(name = "PET")
public class Pet {
	private UUID id;
	private String name;
	private Byte category;
	private long price;
	private long stock;
	private String imagePublicId;
	private String description;
	private Timestamp createdDate;

	public static final byte CATEGORY_DOG = 1;
	public static final byte CATEGORY_CAT = 2;

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
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	@Column(name = "CATEGORY")
	public Byte getCategory() {
		return category;
	}

	@Column(name = "PRICE")
	public long getPrice() {
		return price;
	}

	@Column(name = "STOCK")
	public long getStock() {
		return stock;
	}

	@Column(name = "DESCRIPTION", columnDefinition="TEXT")
	public String getDescription() {
		return description;
	}

	@Column(name = "IMAGE_PUBLIC_ID")
	public String getImagePublicId() {
		return imagePublicId;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(Byte category) {
		this.category = category;
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

	public void setImagePublicId(String imagePublicId) {
		this.imagePublicId = imagePublicId;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Pet{" +
				"id=" + id +
				", createdDate='" + createdDate + '\'' +
				", name='" + name + '\'' +
				", stock='" + stock + '\'' +
				", price='" + price + '\'' +
				", description='" + description + '\'' +
				", imagePublicId='" + imagePublicId + '\'' +
				'}';
	}
}
