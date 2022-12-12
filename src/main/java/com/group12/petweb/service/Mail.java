package com.group12.petweb.service;

import jakarta.mail.MessagingException;

public interface Mail {
	void sendTo(String addressList, String subject, String text) throws MessagingException;
}
