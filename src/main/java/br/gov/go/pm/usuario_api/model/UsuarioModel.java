package br.gov.go.pm.usuario_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    private Long	  codigo;

    @NotEmpty(message ="O Nome é de preenchimento obrigatório.")
    private String	  nome;

    @NotEmpty(message ="O Login é de preenchimento obrigatório.")
    private String   login;

    @NotEmpty(message ="A Senha é de preenchimento obrigatório.")
    private String   senha;

    private boolean ativo;

    @NotEmpty(message ="Não existe nenhum grupo selecionado.")
    private List<Long> grupos = new ArrayList<>();

}
