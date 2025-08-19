# Bootcamp Santander 2025 - Back-End com Java

## Projeto Boards API

Este projeto é uma API desenvolvida em Java com suporte a migrações de banco de dados utilizando **Liquibase**. 

A estrutura foi pensada para facilitar a manutenção, rastreabilidade e evolução do banco de dados sem necessidade de acesso manual ao SQL.

## Estrutura de Migrações

As alterações no banco de dados são organizadas em arquivos `.sql` localizados em:

src/main/resources/db/changelog/migrations/

O arquivo principal de controle é:

src/main/resources/db/changelog/db.changelog-master.xml


Este arquivo utiliza o recurso `includeAll` para incluir automaticamente todos os changelogs presentes na pasta `migrations`.

## Alterações Recentes

### 1. Criação da Tabela `BOARDS`

Arquivo: `db.changelog-202408191938.sql`

```sql

CREATE TABLE BOARDS (

  id BIGINT AUTO_INCREMENT PRIMARY KEY,

  name VARCHAR(255) NOT NULL

);

Rollback:


sql

DROP TABLE BOARDS;

2. Adição da Coluna priority na Tabela CARDS

Arquivo: db.changelog-202408191950.sql


sql

ALTER TABLE CARDS ADD COLUMN priority INT DEFAULT 0;

A coluna priority foi adicionada com valor padrão 0

Não é obrigatória (NOT NULL não foi usado)

Não interfere no funcionamento atual do projeto

Pode ser usada futuramente para ordenação ou categorização de cartões


Rollback:

sql

ALTER TABLE CARDS DROP COLUMN priority;

Como aplicar as alterações no banco

Para aplicar todas as alterações no banco de dados, basta executar:



bash

liquibase update

Liquibase irá detectar os arquivos de changelog ainda não aplicados e executar os comandos automaticamente.

## Segurança e rastreabilidade

Cada changeset possui um identificador único (autor:timestamp) que garante controle de versão e evita duplicações. O histórico de alterações é armazenado na tabela DATABASECHANGELOG.

## Observações

Nenhuma alteração exige acesso manual ao banco

Todas as mudanças são reversíveis via rollback

O projeto está pronto para entrega e execução em qualquer ambiente com Liquibase configurado