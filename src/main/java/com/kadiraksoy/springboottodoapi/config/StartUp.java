//package com.kadiraksoy.springboottodoapi.config;
//
//import com.kadiraksoy.springboottodoapi.model.User;
//import com.kadiraksoy.springboottodoapi.repository.UserRepository;
//import com.kadiraksoy.springboottodoapi.service.UserService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class StartUp implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final UserService userService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        if (userRepository.count() == 0) {
//
//            User newUser = User
//                    .builder()
//                    .username("kadir")
//                    .email("kadir@aksoy.com")
//                    .password(passwordEncoder.encode("password"))
//                    .build();
//
//            userService.save(newUser);
//            log.debug("created  user - {}", newUser);
//        }
//    }
//
//}