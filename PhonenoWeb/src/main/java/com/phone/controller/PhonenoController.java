package com.phone.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.model.PhoneNumber;

@CrossOrigin
@RequestMapping(path="/api", produces= MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PhonenoController {
	
	@GetMapping(path="/getModifiedPhoneNumbers/{phoneNo}")
	public ResponseEntity<List<PhoneNumber>> getModifiedPhoneNumbers(@PathVariable("phoneNo") String phoneNo){
		
		return ResponseEntity.status(HttpStatus.OK).body(getModifiedNumbers(phoneNo));
	}
	
	private List<PhoneNumber> getModifiedNumbers(String phoneNumber){
		List<PhoneNumber> numbers = new ArrayList<>();
		String lastNumbers ="";
		Integer value = Integer.valueOf(phoneNumber);
		for(int i=0;i<phoneNumber.length();i++) {
			int k = Integer.valueOf(value)%10;
			int temp = value;
			value = Integer.valueOf(value)/10;
			if(getPhoneKeyMap().containsKey(String.valueOf(k))) {
				List<String> list = getPhoneKeyMap().get(String.valueOf(k));
				for(String key:list) {
					if(value!=0) {
						numbers.add(new PhoneNumber(value+key+lastNumbers));
					}else {
						numbers.add(new PhoneNumber(key+lastNumbers));
					}
				}
				
			}
			lastNumbers=Integer.valueOf(temp)%10+lastNumbers;
		}
		return numbers;
	}
	
	private Map<String, List<String>> getPhoneKeyMap(){
		Map<String,List<String>> combinationMap = new HashMap<>();
		combinationMap.put("2",Arrays.asList("A,B,C".split(",")));
		combinationMap.put("3",Arrays.asList("D,E,F".split(",")));
		combinationMap.put("4",Arrays.asList("G,H,I".split(",")));
		combinationMap.put("5",Arrays.asList("J,K,L".split(",")));
		combinationMap.put("6",Arrays.asList("M,N,O".split(",")));
		combinationMap.put("7",Arrays.asList("P,Q,R,S".split(",")));
		combinationMap.put("8",Arrays.asList("T,U,V".split(",")));
		combinationMap.put("9",Arrays.asList("W,X,Y,Z".split(",")));
		return combinationMap;
	}
}
