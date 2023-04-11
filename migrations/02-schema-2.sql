--liquibase formatted sql

--changeset Dellout4:table-chat

create table chat(
    id bigserial primary key,
    name text
)

--rollback DROP TABLE "link";