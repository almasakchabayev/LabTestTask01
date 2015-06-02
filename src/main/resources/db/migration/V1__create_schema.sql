CREATE TABLE news (
  id NUMBER(6) NOT NULL,
  deleted CHAR DEFAULT 0 check (deleted in (0,1)) ,
  title VARCHAR2(255),
  creation_date DATE,
  brief VARCHAR2(1023),
  content CLOB,
  CONSTRAINT news_pk PRIMARY KEY (id)
);

CREATE SEQUENCE news_id_seq;

CREATE OR REPLACE TRIGGER news_bir
BEFORE INSERT ON news
FOR EACH ROW

BEGIN
  SELECT news_id_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;