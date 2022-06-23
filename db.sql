create database db_lista_tarefas;

use db_lista_tarefas;

create table tbl_tarefas(
	tarefa_id int not null primary key auto_increment,
    tarefa_titulo text not null,
    tarefa_data_cadastro date not null,
    tarefa_status varchar(255) not null
);
drop table tbl_tarefas;
insert into tbl_tarefas(tarefa_titulo, tarefa_data_cadastro, tarefa_status) values('Teste 1', now(), 'Em execução');

select * from tbl_tarefas;