/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fabricio
 * Created: Oct 21, 2021
 */

drop table if exists usuarios;
create table usuarios (
    id integer not null auto_increment,
    email varchar(255) not null unique,
    senha char(32) not null,
    primary key(id)
);

select * from usuarios;