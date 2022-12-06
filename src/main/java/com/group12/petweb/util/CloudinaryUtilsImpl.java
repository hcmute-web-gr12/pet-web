package com.group12.petweb.util;

import com.cloudinary.Cloudinary;
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
}
