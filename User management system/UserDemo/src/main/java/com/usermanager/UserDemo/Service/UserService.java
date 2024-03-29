package com.usermanager.UserDemo.Service;

import com.usermanager.UserDemo.Model.User;
import com.usermanager.UserDemo.UserRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.usermanager.UserDemo.UserRepo.UserRepo.*;

@Service
public class UserService {
    @Autowired
    UserRepo userrepo;
    public  String addUsers(List<User> users) {

        for(User user : users) {
            userrepo.addUser(user);
        }
        return "users are added!!!";
    }


    public List<User> getusers() {
        return userrepo.getAll();
    }

    public String updateUserById(Integer Id,User users) {


            User user = userrepo.getUserById(Id);
            user.setName(users.getName());
            user.setUserName( users.getUserName());
            user.setAddress( users.getAddress());
            user.setPhoneNumber( users.getPhoneNumber());


        return "Users Updated";


    }

    public  String removeUser(Integer id) {


        User user =userrepo.getUserById(id);
        if(user!=null)
        {
            userrepo.remove(id);
            return id + " removed!!!";
        }
        else {
            return id + " not found!!!";
        }
    }

    public User getAllUsersbyId(Integer id) {
        return userrepo.getUserById(id);
    }
}
