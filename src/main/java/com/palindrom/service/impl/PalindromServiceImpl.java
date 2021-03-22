package com.palindrom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palindrom.model.Palindrom;
import com.palindrom.repository.PalindromRepository;
import com.palindrom.service.PalindromService;

@Service
public class PalindromServiceImpl implements PalindromService{

	@Autowired
	private PalindromRepository repository;
	
	@Override
	public Palindrom storeLongestPalindrom(String input) {
		boolean[][] dp = new boolean[input.length()][input.length()];

        int maxLength = 1;
        int startIndex = 0;
        for(int j = 1 ; j < input.length() ; j ++) {
            for(int i = 0; i <= j ; i ++) {
                if(input.charAt(i) != input.charAt(j)) {
                    dp[i][j] = false;
                }else{
                    int len = j - i + 1;
                    if(len <= 3) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }

                    if(dp[i][j] && len > maxLength) {
                        maxLength = len;
                        startIndex = i;
                    }
                }
            }
        }

        String longest = input.substring(startIndex, startIndex + maxLength);
		return saveDetails(input,longest);
	}
	
	private Palindrom saveDetails(String s , String longest) {
		Palindrom t = new Palindrom();
		t.setName(s);
		t.setLongestPalindrom(longest);
		return repository.save(t);
	}

	@Override
	public String retrieveLongestPalindrom(String input) {
		Palindrom t = repository.findByName(input);
		return t !=null ? t.getLongestPalindrom():"Longest palindrom is not available in database. Please try with different input";
	}

}
