create table cliente (
id bigint not null auto_increment,
cpf varchar(20) not null,
nome varchar(100) not null,
cep varchar(20) not null,
endereco varchar(100) not null,
numero varchar(10) not null,
bairro varchar(50) not null,
complemento varchar(100) not null,
municipio varchar(100) not null,
uf varchar(10) not null,
rg varchar(20) not null,

primary key (id)
);