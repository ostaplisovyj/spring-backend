package software.sigma.springbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.sigma.springbackend.exception.AlreadyCreatedException;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getRoot() {
        return "Hello Server";
    }

    @GetMapping("api/users/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {
        return userRepository.findById(userId).map(user -> {
            System.out.println(user);

            return user;
        });
    }

    @PostMapping("api/users")
    public User createUser(@Valid @RequestBody User user) {

        if(userRepository.existsByFirstname(user.getFirstname())) {
            throw new AlreadyCreatedException("User is already created");
        }

        return userRepository.save(user);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
