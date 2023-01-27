-- SCHEMA: common
DROP SCHEMA IF EXISTS common CASCADE;
CREATE SCHEMA common
    AUTHORIZATION postgres;

-- Table: common.doctor
DROP SEQUENCE IF EXISTS common.doctor_id_seq;
CREATE SEQUENCE common.doctor_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.doctor_id_seq
    OWNER TO postgres;

DROP TABLE IF EXISTS common.doctor;
CREATE TABLE common.doctor
(
    id bigint NOT NULL DEFAULT nextval('common.doctor_id_seq'::regclass),
    professional_license character varying(100) COLLATE pg_catalog."default",    
    active boolean DEFAULT true,
    CONSTRAINT doctor_pk PRIMARY KEY (id)
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.doctor
    OWNER to postgres;
	
-- Table: common.doctor_speciality
DROP SEQUENCE IF EXISTS common.doctor_speciality_id_seq;
CREATE SEQUENCE common.doctor_speciality_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.doctor_speciality_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.doctor_speciality;
CREATE TABLE common.doctor_speciality
(
    id bigint NOT NULL DEFAULT nextval('common.doctor_speciality_id_seq'::regclass),
    doctor_id bigint,
    speciality_id bigint,
    professional_license character varying(100) COLLATE pg_catalog."default",
    appointment_duration integer,
    active boolean DEFAULT true,
    CONSTRAINT doctor_speciality_pk PRIMARY KEY (id),
    CONSTRAINT doctor_speciality_uq1 UNIQUE (doctor_id, speciality_id),
    CONSTRAINT doctor_speciality_uq2 UNIQUE (professional_license),
    CONSTRAINT doctor_speciality_fk FOREIGN KEY (doctor_id)
        REFERENCES common.doctor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.doctor_speciality
    OWNER to postgres;

DROP INDEX IF EXISTS common.doctor_speciality_idx1;
CREATE INDEX doctor_speciality_idx1
    ON common.doctor_speciality USING btree
    (doctor_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.doctor_speciality_idx2;
CREATE INDEX doctor_speciality_idx2
    ON common.doctor_speciality USING btree
    (speciality_id)
    TABLESPACE pg_default;	
	
-- Table: common.assistant
DROP SEQUENCE IF EXISTS common.assistant_id_seq;
CREATE SEQUENCE common.assistant_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.assistant_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.assistant;
CREATE TABLE common.assistant
(
    id bigint NOT NULL DEFAULT nextval('common.assistant_id_seq'::regclass),
    active boolean DEFAULT true,
    CONSTRAINT assistant_pk PRIMARY KEY (id)
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.assistant
    OWNER to postgres;
	
-- Table: common.assistant_doctor
DROP SEQUENCE IF EXISTS common.assistant_doctor_id_seq;
CREATE SEQUENCE common.assistant_doctor_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.assistant_doctor_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.assistant_doctor;
CREATE TABLE common.assistant_doctor
(
    id bigint NOT NULL DEFAULT nextval('common.assistant_doctor_id_seq'::regclass),
    assistant_id bigint,
    doctor_id bigint,
    active boolean DEFAULT true,
    CONSTRAINT assistant_doctor_pk PRIMARY KEY (id),
    CONSTRAINT assistant_doctor_uq UNIQUE (assistant_id, doctor_id),
    CONSTRAINT assistant_doctor_fk1 FOREIGN KEY (assistant_id)
        REFERENCES common.assistant (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT assistant_doctor_fk2 FOREIGN KEY (doctor_id)
        REFERENCES common.doctor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.assistant_doctor
    OWNER to postgres;

DROP INDEX IF EXISTS common.assistant_doctor_idx1;
CREATE INDEX assistant_doctor_idx1
    ON common.assistant_doctor USING btree
    (assistant_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.assistant_doctor_idx2;
CREATE INDEX assistant_doctor_idx2
    ON common.assistant_doctor USING btree
    (doctor_id)
    TABLESPACE pg_default;
	
-- Table: common.nurse
DROP SEQUENCE IF EXISTS common.nurse_id_seq;
CREATE SEQUENCE common.nurse_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.nurse_id_seq
    OWNER TO postgres;

DROP TABLE IF EXISTS common.nurse;
CREATE TABLE common.nurse
(
    id bigint NOT NULL DEFAULT nextval('common.nurse_id_seq'::regclass),
    active boolean,
    CONSTRAINT nurse_pk PRIMARY KEY (id)
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.nurse
    OWNER to postgres;
	
-- Table: common.nurse_doctor
DROP SEQUENCE IF EXISTS common.nurse_doctor_id_seq;
CREATE SEQUENCE common.nurse_doctor_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.nurse_doctor_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.nurse_doctor;
CREATE TABLE common.nurse_doctor
(
    id bigint NOT NULL DEFAULT nextval('common.nurse_doctor_id_seq'::regclass),
    nurse_id bigint,
    doctor_id bigint,
    active boolean DEFAULT true,
    CONSTRAINT nurse_doctor_pk PRIMARY KEY (id),
    CONSTRAINT nurse_doctor_uq UNIQUE (nurse_id, doctor_id),
    CONSTRAINT nurse_doctor_fk1 FOREIGN KEY (nurse_id)
        REFERENCES common.nurse (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT nurse_doctor_fk2 FOREIGN KEY (doctor_id)
        REFERENCES common.doctor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.nurse_doctor
    OWNER to postgres;

DROP INDEX IF EXISTS common.nurse_doctor_idx1;
CREATE INDEX nurse_doctor_idx1
    ON common.nurse_doctor USING btree
    (nurse_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.nurse_doctor_idx2;
CREATE INDEX nurse_doctor_idx2
    ON common.nurse_doctor USING btree
    (doctor_id)
    TABLESPACE pg_default;
	
-- Table: common.person
DROP SEQUENCE IF EXISTS common.person_id_seq;
CREATE SEQUENCE common.person_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.person_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.person;
CREATE TABLE common.person
(
    id bigint NOT NULL DEFAULT nextval('common.person_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default",
    paternal_surname character varying(100) COLLATE pg_catalog."default",
    maternal_surname character varying(100) COLLATE pg_catalog."default",
    dob date,
    photo character varying(100) COLLATE pg_catalog."default",
    sex_id bigint NOT NULL,
    rfc character varying(100) COLLATE pg_catalog."default",
    curp character varying(100) COLLATE pg_catalog."default",
    country_id bigint,
    race_id bigint,
    academic_status_id bigint,
    marital_status_id bigint,
    occupation character varying(100) COLLATE pg_catalog."default",
    religion character varying(100) COLLATE pg_catalog."default",
    identity character varying(100) COLLATE pg_catalog."default",
    active boolean DEFAULT true,
    CONSTRAINT person_pk PRIMARY KEY (id),
    CONSTRAINT person_uq1 UNIQUE (rfc),
    CONSTRAINT person_uq2 UNIQUE (curp)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.person
    OWNER to postgres;

COMMENT ON COLUMN common.person.identity
    IS 'Nombre y Apellidos';

DROP INDEX IF EXISTS common.person_idx1;
CREATE INDEX person_idx1
    ON common.person USING btree
    (sex_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_idx2;
CREATE INDEX person_idx2
    ON common.person USING btree
    (country_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_idx3;
CREATE INDEX person_idx3
    ON common.person USING btree
    (race_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_idx4;
CREATE INDEX person_idx4
    ON common.person USING btree
    (academic_status_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_idx5;
CREATE INDEX person_idx5
    ON common.person USING btree
    (marital_status_id)
    TABLESPACE pg_default;
	
-- Table: common.person_access
DROP SEQUENCE IF EXISTS common.person_access_id_seq;
CREATE SEQUENCE common.person_access_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.person_access_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.person_access;
CREATE TABLE common.person_access
(
    id bigint NOT NULL DEFAULT nextval('common.person_access_id_seq'::regclass),
    person_id bigint NOT NULL,
    private_practice_id bigint,
    clinical_entity_id bigint,
    active boolean DEFAULT true,
    CONSTRAINT person_access_pk PRIMARY KEY (id),
    CONSTRAINT person_access_fk1 FOREIGN KEY (person_id)
        REFERENCES common.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.person_access
    OWNER to postgres;

DROP INDEX IF EXISTS common.person_access_idx1;
CREATE INDEX person_access_idx1
    ON common.person_access USING btree
    (private_practice_id, active)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_access_idx2;
CREATE INDEX person_access_idx2
    ON common.person_access USING btree
    (clinical_entity_id, active)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_access_idx3;
CREATE INDEX person_access_idx3
    ON common.person_access USING btree
    (person_id, private_practice_id, active)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_access_idx4;
CREATE INDEX person_access_idx4
    ON common.person_access USING btree
    (person_id, clinical_entity_id, active)
    TABLESPACE pg_default;
	
-- Table: common.person_address
DROP SEQUENCE IF EXISTS common.person_address_id_seq;
CREATE SEQUENCE common.person_address_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.person_address_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.person_address;
CREATE TABLE common.person_address
(
    id bigint NOT NULL DEFAULT nextval('common.person_address_id_seq'::regclass),
    person_id bigint NOT NULL,
    colony_mx_id bigint NOT NULL,
    street character varying(100) COLLATE pg_catalog."default",
    btw_street character varying(100) COLLATE pg_catalog."default",
    outside_number character varying(100) COLLATE pg_catalog."default",
    inside_number character varying(100) COLLATE pg_catalog."default",
    reference character varying(5000) COLLATE pg_catalog."default",
    active boolean DEFAULT true,
    CONSTRAINT person_address_pk PRIMARY KEY (id),
    CONSTRAINT person_address_fk1 FOREIGN KEY (person_id)
        REFERENCES common.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.person_address
    OWNER to postgres;

DROP INDEX IF EXISTS common.person_address_idx1;
CREATE INDEX person_address_idx1
    ON common.person_address USING btree
    (person_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.person_address_idx2;
CREATE INDEX person_address_idx2
    ON common.person_address USING btree
    (colony_mx_id)
    TABLESPACE pg_default;
	
-- Table: common.person_contact_info
DROP SEQUENCE IF EXISTS common.person_contact_info_id_seq CASCADE;
CREATE SEQUENCE common.person_contact_info_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.person_contact_info_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.person_contact_info;
CREATE TABLE common.person_contact_info
(
    id bigint NOT NULL DEFAULT nextval('common.person_contact_info_id_seq'::regclass),
    person_id bigint NOT NULL,
    phone1 character varying(20) COLLATE pg_catalog."default",
    phone2 character varying(20) COLLATE pg_catalog."default",
    phone3 character varying(20) COLLATE pg_catalog."default",
    mobile1 character varying(20) COLLATE pg_catalog."default",
    mobile2 character varying(20) COLLATE pg_catalog."default",
    mobile3 character varying(20) COLLATE pg_catalog."default",
    email1 character varying(100) COLLATE pg_catalog."default",
    email2 character varying(100) COLLATE pg_catalog."default",
    email3 character varying(100) COLLATE pg_catalog."default",
    web character varying(100) COLLATE pg_catalog."default",
    blog character varying(100) COLLATE pg_catalog."default",
    facebook character varying(100) COLLATE pg_catalog."default",
    twitter character varying(100) COLLATE pg_catalog."default",
    instagram character varying(100) COLLATE pg_catalog."default",
    linkedin character varying(100) COLLATE pg_catalog."default",
    youtube character varying(100) COLLATE pg_catalog."default",
    hash character varying(50) COLLATE pg_catalog."default" NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT person_contact_info_pk PRIMARY KEY (id),
    CONSTRAINT person_contact_info_uq1 UNIQUE (person_id),
    CONSTRAINT person_contact_info_uq2 UNIQUE (hash),
    CONSTRAINT person_contact_info_fk1 FOREIGN KEY (person_id)
        REFERENCES common.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.person_contact_info
    OWNER to postgres;

DROP INDEX IF EXISTS common.person_contact_info_idx;
CREATE INDEX person_contact_info_idx
    ON common.person_contact_info USING btree
    (person_id)
    TABLESPACE pg_default;
	
-- Table: common.patient
DROP SEQUENCE IF EXISTS common.patient_id_seq;
CREATE SEQUENCE common.patient_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.patient_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.patient;
CREATE TABLE common.patient
(
    id bigint NOT NULL DEFAULT nextval('common.patient_id_seq'::regclass),
    person_id bigint NOT NULL,
    blood_type_rh_id bigint,
    active boolean DEFAULT true,
    CONSTRAINT patient_pk PRIMARY KEY (id),
    CONSTRAINT patient_uq UNIQUE (person_id),
    CONSTRAINT patient_fk FOREIGN KEY (person_id)
        REFERENCES common.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.patient
    OWNER to postgres;

DROP INDEX IF EXISTS common.patient_idx1;
CREATE INDEX patient_idx1
    ON common.patient USING btree
    (person_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.patient_idx2;
CREATE INDEX patient_idx2
    ON common.patient USING btree
    (blood_type_rh_id)
    TABLESPACE pg_default;