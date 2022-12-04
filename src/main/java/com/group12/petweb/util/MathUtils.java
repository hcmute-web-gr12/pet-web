package com.group12.petweb.util;

public interface MathUtils {
	int clamp(int value, int min, int max);

	long clamp(long value, long min, long max);

	float clamp(float value, float min, float max);

	double clamp(double value, double min, double max);

	int clampLow(int value, int min);

	long clampLow(long value, long min);

	float clampLow(float value, float min);

	double clampLow(double value, double min);

	byte parseByteOrDefault(String s, byte defaultValue);

	int parseIntOrDefault(String s, int defaultValue);

	long parseLongOrDefault(String s, long defaultValue);

	float parseFloatOrDefault(String s, float defaultValue);

	double parseDoubleOrDefault(String s, double defaultValue);
}
