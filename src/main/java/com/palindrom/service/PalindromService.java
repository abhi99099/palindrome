package com.palindrom.service;

import com.palindrom.model.Palindrom;

public interface PalindromService {

	Palindrom storeLongestPalindrom(String input);

	String retrieveLongestPalindrom(String input);

}
