DROP TABLE IF EXISTS PERSONALTRAINER_USER;

CREATE TABLE PERSONALTRAINER_USER (
  id       BIGSERIAL PRIMARY KEY,
  name     TEXT    NOT NULL,
  surname  TEXT    NOT NULL,
  email    TEXT    NOT NULL,
  loginname TEXT   NOT NULL,
  hashedPassword TEXT NOT NULL,
  role     TEXT    NOT NULL,
  enabled  BOOLEAN NOT NULL,
  verified  BOOLEAN NOT NULL,
  created  DATE NOT NULL,
  updated DATE
);
