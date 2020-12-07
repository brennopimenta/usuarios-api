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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_permissao")
public class PermissaoEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name="seq_id_permissao", sequenceName="seq_id_permissao")
    @Column(name="id_permissao")
    private Long codigo;

    @Column(name="ds_permissao")
    private String permissao;

    @Column(name="ds_descricao")
    private String descricao;

    @ManyToMany(mappedBy = "permissoes")
    private List<GrupoEntity> grupos = new ArrayList<>();
}
