drop table tb_task 


CREATE SEQUENCE task_id_seq;

CREATE TABLE tb_task (
    id integer NOT NULL DEFAULT nextval('task_id_seq'),
    title varchar(100) null,
    status integer not null
);

ALTER SEQUENCE task_id_seq
OWNED BY tb_task.id;