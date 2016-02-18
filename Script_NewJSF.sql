Create Database NewJSF;

use NewJSF;

create table usuario (
	matricula int primary key,
    dt_nasc varchar(10),
    nome varchar(60) 
);

drop table usuario;

insert into usuario(matricula,dt_nasc,nome) values(2012, "02/04/1997", "Bruno Lira");
insert into usuario(matricula,dt_nasc,nome) values(2013, "02/04/1996", "Leo Silva");
insert into usuario(matricula,dt_nasc,nome) values(2014, "02/04/1995", "Lourenço");

select * from usuario;