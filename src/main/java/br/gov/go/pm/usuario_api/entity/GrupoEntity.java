package br.gov.go.pm.usuario_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_grupo")
public class GrupoEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name="seq_id_grupo", sequenceName="seq_id_grupo")
    @Column(name="id_grupo")
    private Long codigo;

    @Column(name="ds_nome")
    private String nome;

    @Column(name="ds_descricao")
    private String descricao;

    @ManyToMany
    @JoinTable(
            name="TB_USUARIO_X_GRUPO",
            joinColumns=@JoinColumn(name="id_grupo", referencedColumnName="id_grupo"),
            inverseJoinColumns=@JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    )
    private List<UsuarioEntity> usuarios = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="TB_PERMISSAO_X_GRUPO",
            joinColumns=@JoinColumn(name="id_grupo", referencedColumnName="id_grupo"),
            inverseJoinColumns=@JoinColumn(name="id_permissao", referencedColumnName="id_permissao")
    )
    private List<PermissaoEntity> permissoes = new ArrayList<>();
}
