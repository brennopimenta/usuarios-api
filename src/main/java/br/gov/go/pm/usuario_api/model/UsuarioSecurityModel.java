package br.gov.go.pm.usuario_api.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioSecurityModel extends User{

    private static final long serialVersionUID = 1L;

    public UsuarioSecurityModel(String login, String senha,Boolean ativo,  Collection<? extends GrantedAuthority> authorities) {
        super(login, senha, ativo,	true, true,true, authorities);
    }
}
