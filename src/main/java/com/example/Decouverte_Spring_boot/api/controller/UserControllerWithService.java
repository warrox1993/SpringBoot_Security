package com.example.Decouverte_Spring_boot.api.controller;

import com.example.Decouverte_Spring_boot.bll.service.UserService;
import com.example.Decouverte_Spring_boot.dal.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Version améliorée du UserController utilisant le service
 * au lieu d'accéder directement au repository.
 *
 * Cette approche respecte mieux l'architecture en couches :
 * Controller -> Service -> Repository
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserControllerWithService {

    private final UserService userService;

    /**
     * Récupère tous les utilisateurs
     * GET http://localhost:8080/user/
     */
    @GetMapping
    public List<User> all() {
        return userService.findAll();
    }

    /**
     * Récupère un utilisateur par son ID
     * GET http://localhost:8080/user/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouvel utilisateur
     * POST http://localhost:8080/user/
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    /**
     * Met à jour un utilisateur existant
     * PUT http://localhost:8080/user/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime un utilisateur
     * DELETE http://localhost:8080/user/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (userService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Recherche un utilisateur par email
     * GET http://localhost:8080/user/email/{email}
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}