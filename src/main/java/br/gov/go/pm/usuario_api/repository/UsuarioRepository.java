package br.gov.go.pm.usuario_api.repository;

import br.gov.go.pm.usuario_api.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByLogin(String login);

}
