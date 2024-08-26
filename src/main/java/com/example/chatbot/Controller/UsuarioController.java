package com.example.chatbot.Controller;

import com.example.chatbot.Model.Usuario;
import com.example.chatbot.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("register")
    public ResponseEntity<Usuario> registerUsuario(Usuario user) {
        return new ResponseEntity<>(usuarioService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("login/{email}/{senha}")
    public ResponseEntity<Usuario> loginUser(String email, String senha) {
        return new ResponseEntity<>(usuarioService.loginUser(email, senha), HttpStatus.OK);
    }

    @GetMapping("find/{email}")
    public ResponseEntity<Usuario> getUser(String email){
        return new ResponseEntity<>(usuarioService.findUser(email), HttpStatus.OK);
    }
}
