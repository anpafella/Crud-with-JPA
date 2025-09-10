package com.anpa.crud.service;

import com.anpa.crud.model.User;
import com.anpa.crud.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<User> getAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    public String deleteUserById(long id){
        userRepository.deleteById(id);
        return "Se ha borrado el usuario con id + " + id;
    }

    public String deleteAll() {
        userRepository.deleteAll();
        return "Se han borrado todos los Users";
    }

    public Optional<User> modifyById(long id, User userDetails) throws ChangeSetPersister.NotFoundException {

        Optional<User> userAntiguo = userRepository.findById(id);

        if (userAntiguo.isPresent()){
            User user = userAntiguo.get();

            if (userDetails.getName() != null) {
                user.setName(userDetails.getName());

            } if (userDetails.getLastName() != null) {
                user.setLastName(userDetails.getLastName());

            } if (userDetails.getLugarResidencia() != null) {
                user.setLugarResidencia(userDetails.getLugarResidencia());
            }
            userRepository.save(user);
            return Optional.of(user);

        } else {
            throw new ObjectNotFoundException("No se encontró el User por el siguiente ID : ", id);
        }
    }
}
