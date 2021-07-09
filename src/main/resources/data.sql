drop table if exists phones;

create table phones(
  id int auto_increment primary key,
  user_id uuid not null,
  number varchar(20) not null,
  city_code varchar(5) not null,
  country_code varchar(5) not null
);

drop table if exists users;

create table users(
  id uuid primary key,
  name varchar(200) not null,
  email varchar(50) not null,
  password varchar(20) not null,
  date_created date not null,
  date_modified date,
  date_last_login date,
  token varchar(5000),
  is_active boolean
);
