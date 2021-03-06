package br.gov.go.pm.usuario_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="tb_usuario")
public class UsuarioEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name="seq_id_usuario", sequenceName="seq_id_usuario")
    @Column(name="id_usuario")
    private Long codigo;

    @Column(name="ds_nome")
    private String	nome;

    @Column(name="ds_login")
    private String login;

    @Column(name="ds_senha")
    private String senha;

    @Column(name="fl_ativo")
    private boolean ativo;

    @JoinTable(name = "TB_USUARIO_X_GRUPO",
            joinColumns = {@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID_GRUPO")}
    )
    @ManyToMany(cascade ={ CascadeType.PERSIST, CascadeType.MERGE})
    private List<GrupoEntity> grupos = new ArrayList<>();
}
