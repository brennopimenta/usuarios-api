/*CRIANDO A SEQUENCIA*/
CREATE SEQUENCE seq_id_grupo;

/*CRIANDO A TABELA DE GRUPOS*/
CREATE TABLE tb_grupo
(
  id_grupo     BIGINT       PRIMARY KEY NOT NULL DEFAULT NEXTVAL('seq_id_grupo'),
  ds_nome      VARCHAR(50)   NOT NULL,
  ds_descricao VARCHAR(200)  NOT NULL
);

/*CRIANDO A SEQUENCIA*/
CREATE SEQUENCE seq_id_permissao;

/*CRIANDO A TABELA DE PERMISSÕES*/
CREATE TABLE tb_permissao
(
   id_permissao BIGINT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('seq_id_permissao'),
   ds_permissao VARCHAR(50)    NOT NULL,
   ds_descricao VARCHAR(200)   NOT NULL
);


/*CRIANDO A SEQUENCIA*/
CREATE SEQUENCE seq_id_usuario;

/*CRIANDO A TABELA DE USUÁRIOS*/
CREATE TABLE tb_usuario
(
  id_usuario BIGINT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('seq_id_usuario'),
  ds_nome    VARCHAR(60)      NOT NULL,
  ds_login   VARCHAR(60)      NOT NULL,
  ds_senha   VARCHAR(400)     NOT NULL,
  fl_ativo   BOOLEAN          NOT NULL
);

/*CRIANDO A TABELA DE USUÁRIO X GRUPO*/
CREATE TABLE tb_usuario_x_grupo
(
  id_usuario BIGINT NOT NULL,
  id_grupo   BIGINT NOT NULL,
  CONSTRAINT PK_USU_GRUP   PRIMARY KEY(id_usuario,id_grupo),
  FOREIGN KEY(id_usuario) REFERENCES tb_usuario(id_usuario),
  FOREIGN KEY(id_grupo)  REFERENCES tb_grupo(id_grupo)
);

/*CRIANDO A TABELA DE PERMISSÃO X GRUPO*/
CREATE TABLE tb_permissao_x_grupo
(
  id_permissao BIGINT NOT NULL,
  id_grupo     BIGINT NOT NULL,
  CONSTRAINT PK_PER_GRUP   PRIMARY KEY(id_permissao,id_grupo),
  CONSTRAINT FK_PERM_1 FOREIGN KEY(id_permissao) REFERENCES tb_permissao(id_permissao),
  CONSTRAINT FK_GRUP_1 FOREIGN KEY(id_grupo)  REFERENCES tb_grupo(id_grupo)
);


/* POPULANDO AS TABELAS*/
INSERT INTO tb_grupo( ds_nome, ds_descricao) VALUES( 'ADMINISTRADORES', 'Adminitrador');
INSERT INTO tb_grupo(ds_nome, ds_descricao) VALUES('USUARIOS', 'Usuários Comum');
INSERT INTO tb_grupo(ds_nome, ds_descricao) VALUES('BACKOFFICE', 'Backoffice - Cadastros');

INSERT INTO tb_usuario (ds_nome, ds_login, ds_senha, fl_ativo) VALUES('Brenno Pimenta', 'brenno', '$2a$10$YYe9VtFGZoWvrNSZNV/AeuVSTOMQLxcGia4IQEl/yVaxrfAnPDcuO', TRUE);

INSERT INTO tb_permissao(ds_permissao, ds_descricao) VALUES('ROLE_CADASTROUSUARIO', 'CADASTRO DE NOVOS USUÁRIOS');
INSERT INTO tb_permissao(ds_permissao, ds_descricao) VALUES('ROLE_CONSULTAUSUARIO', 'CONSULTA DE USUÁRIOS');
INSERT INTO tb_permissao(ds_permissao, ds_descricao) VALUES('ROLE_ADMIN', 'ADMINISTRAÇÂO COMPLETA');

/*VINCULANDO AS TABELAS*/
INSERT INTO tb_usuario_x_grupo(id_usuario,id_grupo)VALUES(1,1);

/*INSERINDO AS PERMISSOES PARA OS GRUPOS*/
/*ROLE_CADASTROUSUARIO x BACKOFFICE*/
INSERT INTO tb_permissao_x_grupo(id_permissao,id_grupo)VALUES(1,3);

/*ROLE_CONSULTAUSUARIO x USUARIOS*/
INSERT INTO tb_permissao_x_grupo(id_permissao,id_grupo)VALUES(2,2);

/*ROLE_ADMIN x ADMINISTRADORES*/
INSERT INTO tb_permissao_x_grupo(id_permissao,id_grupo)VALUES(3,1);

/* SELECT PARA VER AS PERMISSOES*/
SELECT
  TB_PERMISSAO_X_GRUPO.ID_PERMISSAO,
  TB_PERMISSAO.DS_PERMISSAO,
  TB_PERMISSAO.DS_DESCRICAO,
  TB_PERMISSAO_X_GRUPO.ID_GRUPO,
  TB_GRUPO.DS_NOME
FROM
  TB_PERMISSAO_X_GRUPO TB_PERMISSAO_X_GRUPO
INNER JOIN  TB_GRUPO TB_GRUPO ON  TB_GRUPO.ID_GRUPO = TB_PERMISSAO_X_GRUPO.ID_GRUPO
INNER JOIN  TB_PERMISSAO TB_PERMISSAO ON TB_PERMISSAO.ID_PERMISSAO  = TB_PERMISSAO_X_GRUPO.ID_PERMISSAO;