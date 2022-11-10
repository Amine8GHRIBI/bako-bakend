package com.bakomotors.backend.Controller;

import com.bakomotors.backend.Model.Address;
import com.bakomotors.backend.Model.LoginUser;
import com.bakomotors.backend.Model.Role;
import com.bakomotors.backend.Model.User;
import com.bakomotors.backend.Repositories.RoleRepository;
import com.bakomotors.backend.Repositories.UserRepository;
import com.bakomotors.backend.security.jwt.JwtTokenUtil;
import com.bakomotors.backend.security.response.JwtResponse;
import com.bakomotors.backend.security.services.UserDetailsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtils;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestParam("loginUser") String data) throws IOException, NullPointerException{
         LoginUser user = new ObjectMapper().readValue(data, LoginUser.class);

        if(!userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("User with this email is not exist");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(new JwtResponse(jwt,userDetails.getId(), userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPassword(), roles));
    }

    /*@PostMapping(path = "/register", consumes = "multipart/form-data")
    public ResponseEntity<?> registerUser(@RequestParam("registerUser") String registerUser, @RequestParam("address")String address) throws IOException {
        User userData = new ObjectMapper().readValue(registerUser, User.class);
        Address userAddress = new ObjectMapper().readValue(address, Address.class);
        Role roleUser = roleRepository.findByName("ROLE_USER");
        
        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
       
        User user = new User(userData.getId(), userData.getUserName(), userData.getEmail(), encoder.encode(userData.getPassword()), userAddress, roles);
         
        if(userRepository.existsByUserName(user.getUserName())){
            return ResponseEntity.badRequest().body("Error: Name is already taken");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("Error: Email is already taken");
        }
         userRepository.save(user);
         return ResponseEntity.ok().body(HttpStatus.OK);
    }*/
    

    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws IOException {
       // User userData = new ObjectMapper().readValue(registerUser, User.class);
       // Address userAddress = new ObjectMapper().readValue(address, Address.class);
       Role roleUser = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        user.setRoles(roles);
        user.setPassword(encoder.encode(user.getPassword()));
        //User user = new User(userData.getId(), userData.getUserName(), userData.getEmail(), encoder.encode(userData.getPassword()), userAddress, roles);
       if(userRepository.existsByUserName(user.getUserName())){
            return ResponseEntity.badRequest().body("Error: Name is already taken");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("Error: Email is already taken");
        }
         userRepository.save(user);
         return ResponseEntity.ok().body(HttpStatus.OK);
    }
    
    @PostMapping(path = "/addrole")
    public ResponseEntity<?> addrole(@RequestBody Role role) throws IOException {
         roleRepository.save(role);
         return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findUserById(id);
        }
}
