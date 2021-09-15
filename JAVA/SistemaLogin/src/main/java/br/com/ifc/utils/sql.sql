create table usuarios (
    id int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    usuario varchar(45) not null,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(100) not null
);

create table lancamentos (
    id int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    dtlancamento date not null default current_date,
    descricao varchar(100) not null,
    tipo varchar(10) not null default 'Despesa',
    valor double not null
);