package com.example.canan.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canan.dto.UserDto;
import com.example.canan.dto.UserPasswordDto;
import com.example.canan.service.Impl.UserServiceImp;
import com.example.canan.util.ApiPaths;

import javassist.NotFoundException;

@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@CrossOrigin
public class UserController {

	@Autowired
	private UserServiceImp userServiceImp;

	@GetMapping("/{username}")
	public ResponseEntity<UserDto> findByUserName(@PathVariable(name = "username", required = true) String username)
			throws NotFoundException {
		return ResponseEntity.ok(userServiceImp.findByUserName(username));
	}

	@PutMapping("/{username}")
	public ResponseEntity<Boolean> updateUser(@PathVariable(name = "username", required = true) String username,
			@Valid @RequestBody UserDto userDto) throws NotFoundException {
		return ResponseEntity.ok(userServiceImp.update(username, userDto));
	}

	@PutMapping("/password/{username}")
	public ResponseEntity<Boolean> updatePassword(@PathVariable(name = "username", required = true) String username,
											  @Valid @RequestBody UserDto userDto) throws NotFoundException {
		return ResponseEntity.ok(userServiceImp.updatePasword(username, userDto));
	}
	
	@PatchMapping("/change-password")
	public ResponseEntity<Boolean> signUp(@RequestBody UserPasswordDto userPasswordDto) throws NotFoundException {

		Boolean result = userServiceImp.changePassword(userPasswordDto);
		return ResponseEntity.ok(result);
	}
}
