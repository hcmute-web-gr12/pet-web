package com.group12.petweb.util;

import java.util.function.Consumer;

import com.cloudinary.Transformation;
import com.cloudinary.Url;
import com.group12.petweb.model.Pet;

public interface CloudinaryUtils {
	String generateImageUrl(Pet pet);

	String generateImageUrl(Pet pet, Consumer<Url> urlConsumer);

	String generateImageUrl(Pet pet, Consumer<Url> urlConsumer, Consumer<Transformation> transformationConsumer);
}
