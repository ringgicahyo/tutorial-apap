package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    boolean checkOldPassword(String username, String oldPassword);
    boolean checkCharacter(String password);
    boolean validatePassword(String pass, String oldPassword, String checkPassword);
    UserModel changePassword(String username, String password);
    boolean checkPassword(String password, String checkPassword);
    UserModel findByUsername(String user);


}
