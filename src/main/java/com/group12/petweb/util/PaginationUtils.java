package com.group12.petweb.util;

import java.util.Collection;

public interface PaginationUtils {
	Collection<String> generatePageStrings(long total, int start, int pageSize);
}
