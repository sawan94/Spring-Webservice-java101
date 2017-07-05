package com.sawan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sawan.model.User;
import com.sawan.service.CommonService;

@RestController
@RequestMapping("/common/")
public class CommonRestController {

	@Autowired
	CommonService commonService;  //Service which will do all data retrieval/manipulation work


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Boolean> add(@RequestBody User user) {
		commonService.addUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody User user) {
		commonService.update(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Map<Integer,User>> list() {
		Map<Integer,User> users = commonService.listAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> del(@PathVariable int id) {
		Boolean check = commonService.deleteById(id);
		return new ResponseEntity<>(check,HttpStatus.OK);
	}


}