CREATE TABLE IF NOT EXISTS veiculo (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(40) not null,
    type int not null,
    price decimal not null,
    PRIMARY KEY (id)
);