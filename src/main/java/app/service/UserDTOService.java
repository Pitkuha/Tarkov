package app.service;

import app.domain.Fighter;
import app.domain.User;
import app.domain.UserDTO;
import app.repository.FighterRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDTOService implements UserDetailsService {
    private final UserRepository userRepository;
    private final FighterRepository fighterRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UserDTOService(UserRepository userRepository, FighterRepository fighterRepository) {
        this.userRepository = userRepository;
        this.fighterRepository = fighterRepository;
    }

    public User register(UserDTO userData) {
        User user = new User();
        user.setUsername(userData.getUsername());
        user.setPassword(encoder.encode(userData.getPassword()));
        userRepository.save(user);
        return user;
    }

    public boolean isLoginVacant(String login) {
        return userRepository.countByUsername(login) == 0;
    }

    public boolean isLoginThere(String login, String password) {
        String encoded = encoder.encode(password);
        return userRepository.findByUsernameAndPassword(login, encoded) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDTO(userRepository.findByUsername(username));
    }

    public Fighter getFighter(String name){
        Fighter fighter = fighterRepository.findByCallsign(name).get(0);
        return fighter;
    }
}
