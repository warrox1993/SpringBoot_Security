package com.example.Decouverte_Spring_boot.bll.service;

import com.example.Decouverte_Spring_boot.dal.domain.entities.User;

import java.util.List;
import java.util.Optional;

/**
 * Interface définissant les services pour la gestion des utilisateurs
 */
public interface UserService {

    /**
     * Récupère tous les utilisateurs
     * @return Liste de tous les utilisateurs
     */
    List<User> findAll();

    /**
     * Récupère un utilisateur par son ID
     * @param id L'ID de l'utilisateur
     * @return L'utilisateur trouvé ou Optional.empty()
     */
    Optional<User> findById(Long id);

    /**
     * Crée un nouvel utilisateur
     * @param user L'utilisateur à créer
     * @return L'utilisateur créé avec son ID généré
     */
    User save(User user);

    /**
     * Met à jour un utilisateur existant
     * @param id L'ID de l'utilisateur à mettre à jour
     * @param user Les nouvelles données de l'utilisateur
     * @return L'utilisateur mis à jour ou Optional.empty() si non trouvé
     */
    Optional<User> update(Long id, User user);

    /**
     * Supprime un utilisateur par son ID
     * @param id L'ID de l'utilisateur à supprimer
     * @return true si supprimé, false si non trouvé
     */
    boolean deleteById(Long id);

    /**
     * Vérifie si un utilisateur existe par son ID
     * @param id L'ID de l'utilisateur
     * @return true si l'utilisateur existe, false sinon
     */
    boolean existsById(Long id);

    /**
     * Recherche un utilisateur par email
     * @param email L'email de l'utilisateur
     * @return L'utilisateur trouvé ou Optional.empty()
     */
    Optional<User> findByEmail(String email);
}