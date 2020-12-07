package br.gov.go.pm.usuario_api.repository;

import br.gov.go.pm.usuario_api.entity.GrupoEntity;
import br.gov.go.pm.usuario_api.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<GrupoEntity, Long> {

//    List<GrupoEntity> findByUsuariosIn(UsuarioEntity usuarioEntity);
    List<GrupoEntity> findByUsuarios(UsuarioEntity usuarioEntity);

}
