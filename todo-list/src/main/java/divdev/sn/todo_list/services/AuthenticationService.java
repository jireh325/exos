package divdev.sn.todo_list.services;

import divdev.sn.todo_list.dtos.LoginUserDto;
import divdev.sn.todo_list.dtos.RegisterUserDto;
import divdev.sn.todo_list.models.User;
import divdev.sn.todo_list.models.Enums.Status;
import divdev.sn.todo_list.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User(
            input.getNom(), 
            input.getPrenom(), 
            input.getEmail(), 
            passwordEncoder.encode(input.getPassword()), 
            Status.isEnabled
        );
    
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
            )
        );

        return userRepository.findByEmail(input.getEmail())
            .orElseThrow();
    }
}