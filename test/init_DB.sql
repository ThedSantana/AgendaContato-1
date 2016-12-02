/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Maikon Albuquerque
 * Created: 02/12/2016
 */

CREATE DATABASE agendb
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE public.contato
(
    nome character varying(200) COLLATE pg_catalog."default" NOT NULL,
    endereco character varying(200) COLLATE pg_catalog."default" NOT NULL,
    bairro character varying COLLATE pg_catalog."default",
    cidade character varying COLLATE pg_catalog."default",
    uf character varying COLLATE pg_catalog."default",
    telefone character varying COLLATE pg_catalog."default" NOT NULL,
    id character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_id PRIMARY KEY (id)
)