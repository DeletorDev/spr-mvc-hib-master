-- Database: ticketsdb

-- DROP DATABASE ticketsdb;

CREATE DATABASE ticketsdb
  WITH OWNER = postgres
        ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;


-- Table: employee

-- DROP TABLE employee;

CREATE TABLE employee
(
  id_employee serial NOT NULL,
  nu_badge character varying(5),
  first_name character varying(30) NOT NULL,
  last_name character varying(30) NOT NULL,
  status character(1) NOT NULL DEFAULT 'A'::bpchar,
  CONSTRAINT pk_employee PRIMARY KEY (id_employee)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE employee
  OWNER TO zygxxggutohjhp;

-- Index: idx_employee

-- DROP INDEX idx_employee;

CREATE INDEX idx_employee
  ON employee
  USING btree
  (id_employee);

-- Table: routes
-- DROP TABLE routes;

CREATE TABLE routes
(
  id_route serial NOT NULL,
  desc_route character varying(20) NOT NULL,
  price numeric(8,2) NOT NULL,
  status character(1) NOT NULL DEFAULT 'A'::bpchar,
  CONSTRAINT pk_routes PRIMARY KEY (id_route)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE routes
  OWNER TO zygxxggutohjhp;


-- Table: public.request

-- DROP TABLE public.request;

CREATE TABLE public.request
(
  id_request serial NOT NULL ,
  id_employee integer,
  id_route integer,
  quantity smallint,
  dt_requested timestamp without time zone NOT NULL,
  dt_delivered timestamp without time zone,
  status character(1) NOT NULL DEFAULT 'R'::bpchar,
  CONSTRAINT pk_request PRIMARY KEY (id_request),
  CONSTRAINT fk_employee_request FOREIGN KEY (id_employee)
      REFERENCES public.employee (id_employee) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_route_request FOREIGN KEY (id_route)
      REFERENCES public.routes (id_route) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.request
  OWNER TO zygxxggutohjhp;

-- Index: public.idx_request

-- DROP INDEX public.idx_request;

CREATE INDEX idx_request
  ON public.request
  USING btree
  (id_request);
  
--Table teams  
-- DROP TABLE teams;

  CREATE TABLE teams
(
  id serial NOT NULL,
  name character varying(40) NOT NULL,
  rating integer NOT NULL,
  CONSTRAINT pk_team PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


ALTER TABLE teams
  OWNER TO zygxxggutohjhp;

CREATE INDEX idx_teams
  ON teams
  USING btree
  (id);