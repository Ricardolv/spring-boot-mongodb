package com.richard.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richard.app.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

    Perfil findByNome(String nome);

}
