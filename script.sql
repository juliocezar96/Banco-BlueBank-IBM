create table "Cliente"
(
    ID       LONG    not null,
    NOME     VARCHAR not null,
    TELEFONE VARCHAR not null,
    EMAIL    VARCHAR,
    CPF      VARCHAR not null,
    ENDERECO VARCHAR not null,
    constraint CLIENTE_PK
        primary key (ID)
);

create table "Conta"
(
    ID     LONG   not null,
    NUMERO LONG   not null,
    DIGITO LONG   not null,
    SALDO  DOUBLE not null,
    constraint CONTA_PK
        primary key (ID),
    constraint CLIENTE_ID
        foreign key (ID) references "Cliente" (ID)
            on update cascade on delete cascade
);

create table "Transacao"
(
    ID    LONG not null,
    DATA  DATE,
    VALOR DOUBLE,
    constraint TRANSACAO_PK
        primary key (ID),
    constraint CONTA_DESTINO_ID
        foreign key (ID) references "Conta" (ID),
    constraint CONTA_ORIGEM_ID
        foreign key (ID) references "Conta" (ID)
);


