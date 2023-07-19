create Table medicos (
	id bigint not null  auto_increment,
    nome varchar(180) not null,
    telefone varchar(20) not null,
    email varchar(100) not null,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(28),
    complemento varchar(100),
    cidade varchar(100) not null,
    uf char(2) not null,
    
    primary key(id)
);
