package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public boolean checkOldPassword(String username, String oldPassword) {
        UserModel user = userDB.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(oldPassword, user.getPassword())) return true;
        return false;
    }

    @Override
    public boolean checkCharacter(String password) {
        String number = ".*[0-9].*";
        String upperCase = ".*[A-Z].*";
        String lowerCase = ".*[a-z].*";
        Integer length = password.length();
        if (length >= 8 && password.matches(number) && (password.matches(upperCase) || password.matches(lowerCase))) return true;
        return false;
    }

    @Override
    public boolean validatePassword(String password, String oldPassword, String checkPassword){
        if (password.equals(checkPassword) && !password.equals(oldPassword)) return true;
        return false;
    }

    @Override
    public UserModel changePassword(String username, String password) {
        UserModel targetUser = userDB.findByUsername(username);
        try {
            targetUser.setPassword(encrypt(password));
            return userDB.save(targetUser);
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public UserModel findByUsername(String user){
        return userDB.findByUsername(user);
    }
}
