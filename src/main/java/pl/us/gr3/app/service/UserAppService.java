package pl.us.gr3.app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.us.gr3.app.model.User;
import pl.us.gr3.app.repository.UserRepository;

import java.util.Optional;

@Service
public class UserAppService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserAppService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> userByEmail = userRepository.findUserByEmail(username);
        if (userByEmail.isPresent()){
            return userByEmail.get();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
