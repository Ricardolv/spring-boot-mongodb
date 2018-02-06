package com.richard.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richard.app.entity.Usuario;
import com.richard.app.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return this.usuarioService.listaUsuario();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable String id) {
        return this.usuarioService.getById(id);
    }

    @GetMapping("/{page}/{count}")
    public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count) {
        return this.usuarioService.listaPaginada(count, page);
    }

    @GetMapping("/{nome}")
    public List<Usuario> listaPaginada(@PathVariable String nome) {
        return this.usuarioService.buscaPorNome(nome);
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @PutMapping
    public Usuario editar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        this.usuarioService.deleteUsuario(id);
    }
    
    @GetMapping("/logado")
    public Usuario currentUserName(Principal principal) {
    	Usuario usuario = this.usuarioService.findByEmail(principal.getName());
    	usuario.setSenha("");
    	return usuario;
    }

}
