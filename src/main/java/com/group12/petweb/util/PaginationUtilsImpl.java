package com.group12.petweb.util;

import java.util.ArrayList;
import java.util.Collection;

public class PaginationUtilsImpl implements PaginationUtils {
	public Collection<String> generatePageStrings(long total, int start, int pageSize) {
		final var totalPages = (int) Math.ceil((double) total / (double) pageSize);
		final var pages = new ArrayList<String>();
		final var mid = (int)Math.floor((double)start + (double)(totalPages - start) / 2);
		for (int i = Math.max(1, start - 3 + (int)Math.ceil((double)(totalPages - start) / 2)), size = Math.min(start + 1, mid - 1); i <= size; ++i) {
			pages.add(String.valueOf(i));
		}
		if (mid <= start + 1) {
			pages.add(String.valueOf(mid));
		} else {
			pages.add("...");
		}
		for (int i = Math.max(mid + 1, totalPages - 2); i <= totalPages; ++i) {
			pages.add(String.valueOf(i));
		}
		return pages;
	}
}
