--DROP TABLE Message IF EXISTS;

create sequence SEQ
  START WITH 10
  INCREMENT BY 1;


CREATE TABLE Message (
    id int,
    user varchar(100),
    date date,
    content varchar(255));
    
