create table consulta(

       id serial primary key,
       idMedico integer not null,
       idPaciente integer not null,
       data timestamp not null,

       foreign key (idMedico)
       references medicos (id),

       foreign key (idPaciente)
       references pacientes (id)

)

