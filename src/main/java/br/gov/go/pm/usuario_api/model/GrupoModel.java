package br.gov.go.pm.usuario_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrupoModel {

    private Long codigo;
    private String nome;
    private String descricao;
    private Boolean checked;

    public GrupoModel(Long codigo,String descricao) {
        super();
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
