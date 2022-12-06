package com.group12.petweb.util;

import java.util.function.Consumer;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.Url;
import com.group12.petweb.model.Pet;

public class CloudinaryUtilsImpl implements CloudinaryUtils {
	private final Cloudinary cloudinary;

	public CloudinaryUtilsImpl(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	public String generateImageUrl(Pet pet) {
		return cloudinary
				.url()
				.secure(true)
				.publicId(pet.getImagePublicId())
				.format(pet.getImageFormat())
				.version(pet.getImageVersion())
				.generate();
	}

	public String generateImageUrl(Pet pet, Consumer<Url> urlConsumer) {
		final var url = cloudinary
				.url()
				.secure(true)
				.publicId(pet.getImagePublicId())
				.format(pet.getImageFormat())
				.version(pet.getImageVersion());
		urlConsumer.accept(url);
		return url.generate();
	}

	public String generateImageUrl(Pet pet, Consumer<Url> urlConsumer,
			Consumer<Transformation> transformationConsumer) {
		final var url = cloudinary
				.url()
				.secure(true)
				.publicId(pet.getImagePublicId())
				.format(pet.getImageFormat())
				.version(pet.getImageVersion());
		urlConsumer.accept(url);
		final var transformation = new Transformation<>();
		transformationConsumer.accept(
				transformation);
		return url.transformation(transformation).generate();
	}
}
