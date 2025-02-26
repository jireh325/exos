package divdev.sn.todo_list.services;
import java.util.List;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.models.User;
import divdev.sn.todo_list.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public User getOneUser(int id){
        return this.userRepository.findById(id).orElseThrow();
    }

    public User updateUser(int id, User user){
        User userExist = this.userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("utilisateur inexistant : " + id));
        userExist.setNom(user.getNom());
        userExist.setPrenom(user.getPrenom());
        userExist.setEmail(user.getEmail());
        userExist.setPass(user.getPassword());
        userExist.setStatut(user.getStatut());

        return this.userRepository.save(userExist);
    }

    public void deteleUser(int id){
        this.userRepository.deleteById(id);
    }

}
