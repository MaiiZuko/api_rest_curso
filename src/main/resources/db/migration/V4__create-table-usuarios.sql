CREATE TABLE usuarios (
    id bigint not null AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
);
