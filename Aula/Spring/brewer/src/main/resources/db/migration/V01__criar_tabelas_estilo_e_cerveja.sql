create table estilo(
    codigo bigint(20) primary key serial,
    nome varchar(50) not null
) engine=InnoDB default charset=utf8;

create table cerveja(
    codigo bigint(20) serial primary key,
    sku varchar(50) not null,
    nome varchar(80) not null,
    descricao text not null,
    valor decimal(10,2) not null,
    teor_alcoolico decimal(10,2) not null,
    comissao decimal(10,2) not null,
    sabor varchar(50) not null,
    origem varchar(50) not null,
    codigo_estilo bigint(20) not null,
    foreign key (codigo_estilo) references  estilo(codigo)
) ENGINE=InnoDB default charset=utf8;

insert into estilo values (0, 'Amber Lager');
insert into estilo values (0, 'Dark Lager');
insert into estilo values (0, 'Pale Lager');
insert into estilo values (0, 'Pilsner');

