create table pacientes(

    id serial primary key,
    nome varchar(255) not null,
    email varchar(255) not null,
    telefone varchar(20) not null,
    cpf varchar(11) not null,
    logradouro varchar(255) not null,
    numero varchar(50),
    complemento varchar(255),
    bairro varchar(255) not null,
    cidade varchar(255) not null,
    uf varchar(2) not null,
    cep varchar(8) not null

);