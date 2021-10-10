CREATE TABLE IF NOT EXISTS users (
	id SERIAL,
	f_name varchar(100) NOT NULL,
	l_name varchar(100),
	email varchar(100) NOT NULL UNIQUE,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS address (
    id SERIAL,
    linea varchar(100) NOT NULL,
	lineb varchar(100),
	state varchar(100) NOT NULL,
	city varchar(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS address_junction (
    id SERIAL,
    user_id integer,
    address_id integer,
    CONSTRAINT pk_userid
      FOREIGN KEY(user_id) 
	  REFERENCES users(id),
     CONSTRAINT pk_address
      FOREIGN KEY(address_id) 
	  REFERENCES address(id) 
);

CREATE TABLE IF NOT EXISTS deleted_users (
	id SERIAL,
	f_name varchar(100) NOT NULL,
	l_name varchar(100),
	email varchar(100) NOT NULL UNIQUE,
	PRIMARY KEY(id),
    address varchar
);