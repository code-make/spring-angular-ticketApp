package com.example.canan.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.canan.dto.LoginRequest;
import com.example.canan.dto.RegistirationRequest;
import com.example.canan.dto.TokenResponse;
import com.example.canan.model.User;
import com.example.canan.repository.UserRepository;
import com.example.canan.security.JwtTokenUtil;
import com.example.canan.service.Impl.UserServiceImp;
import com.example.canan.util.ApiPaths;

@RestController
@RequestMapping(ApiPaths.MainCtrl.CTRL)
@CrossOrigin
public class MainController {

	private final AuthenticationManager authenticationManager;

	private final UserRepository userRepository;
	private final UserServiceImp userServiceImp;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final ModelMapper modelMapper;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public MainController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			AuthenticationManager authenticationManager, ModelMapper modelMapper, UserServiceImp userServiceImp) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.modelMapper = modelMapper;
		this.authenticationManager = authenticationManager;
		this.userServiceImp = userServiceImp;
	}

	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		final User user = userRepository.findByUsername(request.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(new TokenResponse(user.getUsername(), token));
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public ResponseEntity<Boolean> signUp(@RequestBody RegistirationRequest registirationRequest) throws Exception {

		Boolean result = userServiceImp.register(registirationRequest);
		return ResponseEntity.ok(result);
	}
}
