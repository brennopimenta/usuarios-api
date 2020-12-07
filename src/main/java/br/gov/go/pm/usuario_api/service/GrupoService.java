package br.gov.go.pm.usuario_api.service;

import br.gov.go.pm.usuario_api.entity.GrupoEntity;
import br.gov.go.pm.usuario_api.model.GrupoModel;
import br.gov.go.pm.usuario_api.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    /**CONSULA OS GRUPOS CADASTRADOS*/
    @Transactional(readOnly = true)
    public List<GrupoModel> consultarGrupos(){

        List<GrupoModel> gruposModel =  new ArrayList<>();

		/*CONSULTA TODOS OS GRUPOS*/
        List<GrupoEntity> gruposEntity = this.grupoRepository.findAll();


        gruposEntity.forEach(grupo ->{
            gruposModel.add(new GrupoModel(grupo.getCodigo(), grupo.getDescricao()));
        });

        return gruposModel;
    }
}
