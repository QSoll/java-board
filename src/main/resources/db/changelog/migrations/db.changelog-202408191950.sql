--liquibase formatted sql
--changeset solange:202408191950
--comment: adiciona coluna priority na tabela CARDS

ALTER TABLE CARDS ADD COLUMN priority INT DEFAULT 0;

--rollback ALTER TABLE CARDS DROP COLUMN priority;
