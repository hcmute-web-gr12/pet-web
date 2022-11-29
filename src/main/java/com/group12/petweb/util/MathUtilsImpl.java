package com.group12.petweb.util;

public class MathUtilsImpl implements MathUtils {
	@Override()
	public int clamp(int value, int min, int max) {
		return value > max ? max : value < min ? min : value;
	}

	@Override()
	public long clamp(long value, long min, long max) {
		return value > max ? max : value < min ? min : value;
	}

	@Override()
	public float clamp(float value, float min, float max) {
		return value > max ? max : value < min ? min : value;
	}

	@Override()
	public double clamp(double value, double min, double max) {
		return value > max ? max : value < min ? min : value;
	}

	@Override()
	public int clampLow(int value, int min) {
		return value < min ? min : value;
	}

	@Override()
	public long clampLow(long value, long min) {
		return value < min ? min : value;
	}

	@Override()
	public float clampLow(float value, float min) {
		return value < min ? min : value;
	}

	@Override()
	public double clampLow(double value, double min) {
		return value < min ? min : value;
	}

	@Override
	public int parseIntOrDefault(String s, int defaultValue) {
		try {
			return Integer.parseInt(s);
		} catch(NumberFormatException ex) {
			return defaultValue;
		}
	}

	@Override
	public long parseLongOrDefault(String s, long defaultValue) {
		try {
			return Long.parseLong(s);
		} catch(NumberFormatException ex) {
			return defaultValue;
		}
	}

	@Override
	public float parseFloatOrDefault(String s, float defaultValue) {
		try {
			return Float.parseFloat(s);
		} catch(NumberFormatException ex) {
			return defaultValue;
		}
	}

	@Override
	public double parseDoubleOrDefault(String s, double defaultValue) {
		try {
			return Double.parseDouble(s);
		} catch(NumberFormatException ex) {
			return defaultValue;
		}
	}
}
