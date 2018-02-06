package com.richard.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richard.app.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    
    Usuario findByEmail(String email);
}
