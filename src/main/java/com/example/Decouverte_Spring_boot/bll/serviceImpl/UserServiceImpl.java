package com.example.Decouverte_Spring_boot.bll.serviceImpl;

import com.example.Decouverte_Spring_boot.bll.service.UserService;
import com.example.Decouverte_Spring_boot.dal.domain.entities.User;
import com.example.Decouverte_Spring_boot.dal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service UserService
 * Cette classe contient la logique métier pour la gestion des utilisateurs
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        // Ici on pourrait ajouter de la logique métier comme :
        // - Validation de l'email
        // - Vérification que l'email n'existe pas déjà
        // - Formatage des données
        return userRepository.save(user);
    }

    @Override
    public Optional<User> update(Long id, User user) {
        return userRepository.findById(id)
                .map(userExistant -> {
                    userExistant.setNom(user.getNom());
                    userExistant.setEmail(user.getEmail());
                    userExistant.setAge(user.getAge());
                    return userRepository.save(userExistant);
                });
    }

    @Override
    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        // Note: Cette méthode nécessiterait d'ajouter la méthode correspondante
        // dans UserRepository si on veut l'implémenter
        // Pour l'instant, on peut simuler en cherchant dans tous les users
        return userRepository.findAll()
                .stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst();
    }
}