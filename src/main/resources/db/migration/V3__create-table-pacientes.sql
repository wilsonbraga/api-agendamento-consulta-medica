create Table pacientes (
	id bigint not null  auto_increment,
    nome varchar(180) not null,
    telefone varchar(20) not null,
    email varchar(100) not null,
    cpf varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(28),
    complemento varchar(100),
    cidade varchar(100) not null,
    uf char(2) not null,
    
    primary key(id)
);
