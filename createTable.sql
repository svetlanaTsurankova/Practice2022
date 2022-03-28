CREATE TABLE test.product (
  maker VARCHAR(10) NOT NULL,
  model VARCHAR(50) NOT NULL PRIMARY KEY,
  type VARCHAR(50) NULL);


CREATE TABLE test.laptop (
  code INT NOT NULL PRIMARY KEY,
  model VARCHAR(50) NULL,
  speed SMALLINT NULL,
  ram SMALLINT NULL,
  hd REAL NULL,
  price DOUBLE NOT NULL,
  screen TINYINT NULL,
  FOREIGN KEY (model) REFERENCES product (model));

CREATE TABLE test.pc (
  code INT NOT NULL PRIMARY KEY,
  model VARCHAR(50) NULL,
  speed SMALLINT NULL,
  ram SMALLINT NULL,
  hd REAL NULL,
  cd VARCHAR(10) NULL,
  price DOUBLE NOT NULL,
  FOREIGN KEY (model) REFERENCES product (model));


CREATE TABLE test.printer (
  code INT NOT NULL PRIMARY KEY,
  model VARCHAR(50) NULL,
  color CHAR(1) NULL,
  type VARCHAR(10) NULL,
  price DOUBLE NOT NULL, 
  FOREIGN KEY (model) REFERENCES product (model));