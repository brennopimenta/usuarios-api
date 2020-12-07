package br.gov.go.pm.usuario_api.repository;

import br.gov.go.pm.usuario_api.entity.GrupoEntity;
import br.gov.go.pm.usuario_api.entity.PermissaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {

    List<PermissaoEntity> findByGrupos(GrupoEntity grupoEntity);

}
