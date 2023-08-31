alter table pacientes add column ativo boolean;
update pacientes set ativo = true;