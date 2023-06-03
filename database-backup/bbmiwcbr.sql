--
-- PostgreSQL database dump
--

-- Dumped from database version 11.19 (Ubuntu 11.19-1.pgdg20.04+1)
-- Dumped by pg_dump version 11.19 (Ubuntu 11.19-1.pgdg20.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: btree_gin; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS btree_gin WITH SCHEMA public;


--
-- Name: EXTENSION btree_gin; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION btree_gin IS 'support for indexing common datatypes in GIN';


--
-- Name: btree_gist; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS btree_gist WITH SCHEMA public;


--
-- Name: EXTENSION btree_gist; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION btree_gist IS 'support for indexing common datatypes in GiST';


--
-- Name: citext; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS citext WITH SCHEMA public;


--
-- Name: EXTENSION citext; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION citext IS 'data type for case-insensitive character strings';


--
-- Name: cube; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS cube WITH SCHEMA public;


--
-- Name: EXTENSION cube; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION cube IS 'data type for multidimensional cubes';


--
-- Name: dblink; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS dblink WITH SCHEMA public;


--
-- Name: EXTENSION dblink; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION dblink IS 'connect to other PostgreSQL databases from within a database';


--
-- Name: dict_int; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS dict_int WITH SCHEMA public;


--
-- Name: EXTENSION dict_int; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION dict_int IS 'text search dictionary template for integers';


--
-- Name: dict_xsyn; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS dict_xsyn WITH SCHEMA public;


--
-- Name: EXTENSION dict_xsyn; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION dict_xsyn IS 'text search dictionary template for extended synonym processing';


--
-- Name: earthdistance; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS earthdistance WITH SCHEMA public;


--
-- Name: EXTENSION earthdistance; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION earthdistance IS 'calculate great-circle distances on the surface of the Earth';


--
-- Name: fuzzystrmatch; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS fuzzystrmatch WITH SCHEMA public;


--
-- Name: EXTENSION fuzzystrmatch; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION fuzzystrmatch IS 'determine similarities and distance between strings';


--
-- Name: hstore; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS hstore WITH SCHEMA public;


--
-- Name: EXTENSION hstore; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION hstore IS 'data type for storing sets of (key, value) pairs';


--
-- Name: intarray; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS intarray WITH SCHEMA public;


--
-- Name: EXTENSION intarray; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION intarray IS 'functions, operators, and index support for 1-D arrays of integers';


--
-- Name: ltree; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS ltree WITH SCHEMA public;


--
-- Name: EXTENSION ltree; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION ltree IS 'data type for hierarchical tree-like structures';


--
-- Name: pg_stat_statements; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pg_stat_statements WITH SCHEMA public;


--
-- Name: EXTENSION pg_stat_statements; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pg_stat_statements IS 'track execution statistics of all SQL statements executed';


--
-- Name: pg_trgm; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pg_trgm WITH SCHEMA public;


--
-- Name: EXTENSION pg_trgm; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pg_trgm IS 'text similarity measurement and index searching based on trigrams';


--
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


--
-- Name: pgrowlocks; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pgrowlocks WITH SCHEMA public;


--
-- Name: EXTENSION pgrowlocks; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgrowlocks IS 'show row-level locking information';


--
-- Name: pgstattuple; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pgstattuple WITH SCHEMA public;


--
-- Name: EXTENSION pgstattuple; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgstattuple IS 'show tuple-level statistics';


--
-- Name: tablefunc; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS tablefunc WITH SCHEMA public;


--
-- Name: EXTENSION tablefunc; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION tablefunc IS 'functions that manipulate whole tables, including crosstab';


--
-- Name: unaccent; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS unaccent WITH SCHEMA public;


--
-- Name: EXTENSION unaccent; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION unaccent IS 'text search dictionary that removes accents';


--
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


--
-- Name: xml2; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS xml2 WITH SCHEMA public;


--
-- Name: EXTENSION xml2; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION xml2 IS 'XPath querying and XSLT';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: academico; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.academico (
    id_academico bigint NOT NULL,
    carrera character varying(255),
    escuela character varying(255),
    fin character varying(255),
    imagen character varying(255),
    inicio character varying(255),
    puntaje integer NOT NULL,
    titulo character varying(255),
    persona_id bigint
);


ALTER TABLE public.academico OWNER TO bbmiwcbr;

--
-- Name: academico_id_academico_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.academico_id_academico_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.academico_id_academico_seq OWNER TO bbmiwcbr;

--
-- Name: academico_id_academico_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.academico_id_academico_seq OWNED BY public.academico.id_academico;


--
-- Name: compania; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.compania (
    id_compania bigint NOT NULL,
    imagen character varying(255),
    nombre character varying(255),
    url character varying(255),
    persona_id bigint
);


ALTER TABLE public.compania OWNER TO bbmiwcbr;

--
-- Name: compania_id_compania_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.compania_id_compania_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compania_id_compania_seq OWNER TO bbmiwcbr;

--
-- Name: compania_id_compania_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.compania_id_compania_seq OWNED BY public.compania.id_compania;


--
-- Name: escuela; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.escuela (
    id_escuela bigint NOT NULL,
    imagen character varying(255),
    nombre character varying(255),
    url character varying(255),
    persona_id bigint
);


ALTER TABLE public.escuela OWNER TO bbmiwcbr;

--
-- Name: escuela_id_escuela_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.escuela_id_escuela_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.escuela_id_escuela_seq OWNER TO bbmiwcbr;

--
-- Name: escuela_id_escuela_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.escuela_id_escuela_seq OWNED BY public.escuela.id_escuela;


--
-- Name: experiencia; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.experiencia (
    id_experiencia bigint NOT NULL,
    ciudad character varying(255),
    desde character varying(255),
    duracion character varying(255),
    establecimiento character varying(255),
    hasta character varying(255),
    imagen character varying(255),
    lugar character varying(255),
    pais character varying(255),
    provincia character varying(255),
    titulo character varying(255),
    persona_id bigint
);


ALTER TABLE public.experiencia OWNER TO bbmiwcbr;

--
-- Name: experiencia_id_experiencia_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.experiencia_id_experiencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.experiencia_id_experiencia_seq OWNER TO bbmiwcbr;

--
-- Name: experiencia_id_experiencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.experiencia_id_experiencia_seq OWNED BY public.experiencia.id_experiencia;


--
-- Name: persona; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.persona (
    dni bigint NOT NULL,
    apellido character varying(255),
    fecha_nacimiento character varying(255),
    image_background character varying(255),
    image_perfil character varying(255),
    mail character varying(255),
    nacionalidad character varying(255),
    nombres character varying(255),
    ocupacion character varying(255)
);


ALTER TABLE public.persona OWNER TO bbmiwcbr;

--
-- Name: proyecto; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.proyecto (
    id_proyecto bigint NOT NULL,
    descripcion character varying(255),
    link character varying(255),
    titulo character varying(255),
    persona_id bigint
);


ALTER TABLE public.proyecto OWNER TO bbmiwcbr;

--
-- Name: proyecto_id_proyecto_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.proyecto_id_proyecto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proyecto_id_proyecto_seq OWNER TO bbmiwcbr;

--
-- Name: proyecto_id_proyecto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.proyecto_id_proyecto_seq OWNED BY public.proyecto.id_proyecto;


--
-- Name: rol; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.rol (
    id integer NOT NULL,
    rol_nombre character varying(255)
);


ALTER TABLE public.rol OWNER TO bbmiwcbr;

--
-- Name: rol_id_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_id_seq OWNER TO bbmiwcbr;

--
-- Name: rol_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.rol_id_seq OWNED BY public.rol.id;


--
-- Name: seccion; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.seccion (
    id_seccion bigint NOT NULL,
    descripcion character varying(255),
    titulo character varying(255),
    persona_id bigint
);


ALTER TABLE public.seccion OWNER TO bbmiwcbr;

--
-- Name: seccion_id_seccion_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.seccion_id_seccion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seccion_id_seccion_seq OWNER TO bbmiwcbr;

--
-- Name: seccion_id_seccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.seccion_id_seccion_seq OWNED BY public.seccion.id_seccion;


--
-- Name: skill; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.skill (
    id_skill bigint NOT NULL,
    progreso character varying(255),
    titulo character varying(255),
    persona_id bigint
);


ALTER TABLE public.skill OWNER TO bbmiwcbr;

--
-- Name: skill_id_skill_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.skill_id_skill_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.skill_id_skill_seq OWNER TO bbmiwcbr;

--
-- Name: skill_id_skill_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.skill_id_skill_seq OWNED BY public.skill.id_skill;


--
-- Name: usuario_rol; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.usuario_rol (
    id_usuario bigint NOT NULL,
    id_rol integer NOT NULL
);


ALTER TABLE public.usuario_rol OWNER TO bbmiwcbr;

--
-- Name: usuariojwt; Type: TABLE; Schema: public; Owner: bbmiwcbr
--

CREATE TABLE public.usuariojwt (
    id bigint NOT NULL,
    dni_usuario bigint,
    password character varying(255),
    persona_id bigint
);


ALTER TABLE public.usuariojwt OWNER TO bbmiwcbr;

--
-- Name: usuariojwt_id_seq; Type: SEQUENCE; Schema: public; Owner: bbmiwcbr
--

CREATE SEQUENCE public.usuariojwt_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuariojwt_id_seq OWNER TO bbmiwcbr;

--
-- Name: usuariojwt_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bbmiwcbr
--

ALTER SEQUENCE public.usuariojwt_id_seq OWNED BY public.usuariojwt.id;


--
-- Name: academico id_academico; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.academico ALTER COLUMN id_academico SET DEFAULT nextval('public.academico_id_academico_seq'::regclass);


--
-- Name: compania id_compania; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.compania ALTER COLUMN id_compania SET DEFAULT nextval('public.compania_id_compania_seq'::regclass);


--
-- Name: escuela id_escuela; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.escuela ALTER COLUMN id_escuela SET DEFAULT nextval('public.escuela_id_escuela_seq'::regclass);


--
-- Name: experiencia id_experiencia; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.experiencia ALTER COLUMN id_experiencia SET DEFAULT nextval('public.experiencia_id_experiencia_seq'::regclass);


--
-- Name: proyecto id_proyecto; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.proyecto ALTER COLUMN id_proyecto SET DEFAULT nextval('public.proyecto_id_proyecto_seq'::regclass);


--
-- Name: rol id; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.rol ALTER COLUMN id SET DEFAULT nextval('public.rol_id_seq'::regclass);


--
-- Name: seccion id_seccion; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.seccion ALTER COLUMN id_seccion SET DEFAULT nextval('public.seccion_id_seccion_seq'::regclass);


--
-- Name: skill id_skill; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.skill ALTER COLUMN id_skill SET DEFAULT nextval('public.skill_id_skill_seq'::regclass);


--
-- Name: usuariojwt id; Type: DEFAULT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.usuariojwt ALTER COLUMN id SET DEFAULT nextval('public.usuariojwt_id_seq'::regclass);


--
-- Data for Name: academico; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.academico (id_academico, carrera, escuela, fin, imagen, inicio, puntaje, titulo, persona_id) FROM stdin;
1	Informatica	FCEQyN - UNaM Módulo Informática	Actualidad	https://www.fceqyn.unam.edu.ar/wp-content/uploads/2021/10/logoFCEQyN2017.PNG.png	2019	4	Analista en Sistemas de Computación	41419890
2	Informatica	FCEQyN - UNaM Módulo Informática	Actualidad	https://www.fceqyn.unam.edu.ar/wp-content/uploads/2021/10/logoFCEQyN2017.PNG.png	2019	4	Licenciatura en Sistemas de Informacion	41419890
3	Procesos Productivos	EPET N°10 Luis Federico Leloir	2017	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2aZk5-HMk0lJ3akTmBPq99KzVZKEvblaY_Q&usqp=CAU	2012	6	Tecnico en Industria de Procesos	41419890
4	Desarrollo de Videojuegos	PoloTIC, Posadas	2021	https://play-lh.googleusercontent.com/0goocG7RJZDZ41ShfBPl-h7ctwHKHjqzn4nSImyL8_RWyXqeYNKw-CdGAKhgPGZG5Es	2021	1	Taller de Diseño de Videojuegos	41419890
5	Desarrollo de Software	PoloTIC, Posadas	2021	https://cdn-icons-png.flaticon.com/512/226/226777.png	2021	1	Desarrollador web Java fullstack junior	41419890
6	Desarrollo de Software	PoloTIC, Posadas	2021	https://upload.wikimedia.org/wikipedia/commons/2/27/PHP-logo.svg	2020	1	Desarrollador web PHP full stack junior	41419890
7	Introducción a la programación	Ministerio de Desarrollo Productivo y CESSI	2021	https://media-exp1.licdn.com/dms/image/C560BAQGv-Dd7A2pQ0g/company-logo_200_200/0/1646458288684?e=2147483647&v=beta&t=2bEkW38L80hsKUeV4gucwORSlBcJNmYd5H6CBz_Z00E	2021	1	#SéProgramar	41419890
8	Programador con perfil web full stack Junior	Ministerio de Desarrollo Productivo, INTI y CESSI	2022	https://cdn-sp.radionacional.com.ar/wp-content/uploads/2021/12/Diseno-sin-titulo-1-1.png	2021	1	#YoProgramo	41419890
\.


--
-- Data for Name: compania; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.compania (id_compania, imagen, nombre, url, persona_id) FROM stdin;
1	https://www.fceqyn.unam.edu.ar/wp-content/uploads/2021/10/logoFCEQyN2017.PNG.png	FCEQyN	https://www.fceqyn.unam.edu.ar/	41419890
\.


--
-- Data for Name: escuela; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.escuela (id_escuela, imagen, nombre, url, persona_id) FROM stdin;
1	https://www.unam.edu.ar/images/NOTICIAS/logo_original_unam.png	UNaM	https://www.unam.edu.ar/	41419890
\.


--
-- Data for Name: experiencia; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.experiencia (id_experiencia, ciudad, desde, duracion, establecimiento, hasta, imagen, lugar, pais, provincia, titulo, persona_id) FROM stdin;
1	Posadas	FEBRERO DE 2021	7 meses	PoloTIC	AGOSTO DE 2021	https://cdn-icons-png.flaticon.com/512/226/226777.png	Silicon Misiones	Argentina	Misiones	Desarrollador web Java fullstack junior	41419890
\.


--
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.persona (dni, apellido, fecha_nacimiento, image_background, image_perfil, mail, nacionalidad, nombres, ocupacion) FROM stdin;
41419890	Fernández	1999-06-12	https://img.freepik.com/fotos-premium/colores-neon-fluyen-efecto-textura-granulada-fondo-degradado-color-azul-rosa-purpura-diseno-banner-futurista-borroso_284753-2322.jpg?w=996	https://pbs.twimg.com/profile_images/1652921641117048832/BaeLJvNa_400x400.jpg	matias.fernandez@gmail.com	Garuhape, Misiones (Argentina)	Matías Daniel	Analista Programador y estudiante de las carreras Analista en Sistemas de Computacion y Licenciatura en Sistemas de Informacion.
\.


--
-- Data for Name: proyecto; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.proyecto (id_proyecto, descripcion, link, titulo, persona_id) FROM stdin;
5	Desarrollo de una aplicación web para enseñar el portfolio personal utilizando Angular y Node.js para el frontend, Java y Spring Boot para el backend.	https://porfolio-matias-fernandez.web.app/	Portfolio con Java	41419890
3	Orientado a introducir conocimientos básicos sobre estructuras de datos en Java. Pequeña introducción al frontend, backend, modelado de capas en aplicaciones desktop.	https://github.com/Matias198/Fernandez_Matias_tpo1	ABM lógico en Java	41419890
4	Desarrollo de un software para administrar un gimnasio, seguimiento por clientes y tutores, rutinas personalizadas. Proyectos integrador de la materia Programación Orientada a Objetos	https://github.com/Matias198/tp_integrador_poo	CRUD en Java, con JavaFX y Postgres	41419890
2	Desarrollo de una aplicación de escritorio para el registro de mascotas de una veterinaria utilizando el lenguaje Java, con MySQL como base de datos.	https://github.com/Matias198/Fernandez_Matias_tpo2	CRUD en Java, con JavaSwing y MySQL	41419890
1	Desarrollo de una aplicación web para la gestion de un hotel utilizando el lenguaje Java, con MySQL como base de datos.	https://github.com/Matias198/Fernandez_Matias_tpo3	CRUD en Java, con JSP y MySQL	41419890
\.


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.rol (id, rol_nombre) FROM stdin;
1	ROLE_ADMIN
2	ROLE_USER
3	ROLE_GUEST
\.


--
-- Data for Name: seccion; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.seccion (id_seccion, descripcion, titulo, persona_id) FROM stdin;
12	Estudiante de la facultad de ciencias exactas, quimicas y naturales de la universidad nacional de misiones, en el modulo Apostoles.	Acerca de	41419890
\.


--
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.skill (id_skill, progreso, titulo, persona_id) FROM stdin;
1	85	Resolucion de problemas	41419890
2	70	Diseño de sistemas	41419890
3	75	Trabajo en equipo	41419890
4	85	Lógica matemática y habilidades para la computación e informática	41419890
5	90	Adaptabilidad	41419890
\.


--
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.usuario_rol (id_usuario, id_rol) FROM stdin;
1	2
1	3
2	1
2	2
\.


--
-- Data for Name: usuariojwt; Type: TABLE DATA; Schema: public; Owner: bbmiwcbr
--

COPY public.usuariojwt (id, dni_usuario, password, persona_id) FROM stdin;
1	1	$2a$10$o.dyKjQvxEVrM8.NqmHUnesnUsn4Q/mY3LnguL0xEazrrJIrwnD0a	\N
2	41419890	$2a$10$3b686zCBxCslfWRIsDNS4unIVUBgmhiRoSksrVRnSYTFC6pbYlU7y	\N
\.


--
-- Name: academico_id_academico_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.academico_id_academico_seq', 9, true);


--
-- Name: compania_id_compania_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.compania_id_compania_seq', 1, true);


--
-- Name: escuela_id_escuela_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.escuela_id_escuela_seq', 1, true);


--
-- Name: experiencia_id_experiencia_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.experiencia_id_experiencia_seq', 4, true);


--
-- Name: proyecto_id_proyecto_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.proyecto_id_proyecto_seq', 6, true);


--
-- Name: rol_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.rol_id_seq', 3, true);


--
-- Name: seccion_id_seccion_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.seccion_id_seccion_seq', 14, true);


--
-- Name: skill_id_skill_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.skill_id_skill_seq', 6, true);


--
-- Name: usuariojwt_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bbmiwcbr
--

SELECT pg_catalog.setval('public.usuariojwt_id_seq', 2, true);


--
-- Name: academico academico_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.academico
    ADD CONSTRAINT academico_pkey PRIMARY KEY (id_academico);


--
-- Name: compania compania_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.compania
    ADD CONSTRAINT compania_pkey PRIMARY KEY (id_compania);


--
-- Name: escuela escuela_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.escuela
    ADD CONSTRAINT escuela_pkey PRIMARY KEY (id_escuela);


--
-- Name: experiencia experiencia_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.experiencia
    ADD CONSTRAINT experiencia_pkey PRIMARY KEY (id_experiencia);


--
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (dni);


--
-- Name: proyecto proyecto_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT proyecto_pkey PRIMARY KEY (id_proyecto);


--
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id);


--
-- Name: seccion seccion_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_pkey PRIMARY KEY (id_seccion);


--
-- Name: skill skill_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id_skill);


--
-- Name: usuario_rol usuario_rol_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT usuario_rol_pkey PRIMARY KEY (id_usuario, id_rol);


--
-- Name: usuariojwt usuariojwt_pkey; Type: CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.usuariojwt
    ADD CONSTRAINT usuariojwt_pkey PRIMARY KEY (id);


--
-- Name: experiencia fk30e9aa2tv4x2kirmadmmggsme; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.experiencia
    ADD CONSTRAINT fk30e9aa2tv4x2kirmadmmggsme FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- Name: usuario_rol fk6j71y4bqh9iimk3ogm3h3hoof; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT fk6j71y4bqh9iimk3ogm3h3hoof FOREIGN KEY (id_usuario) REFERENCES public.usuariojwt(id);


--
-- Name: academico fkbxru1w1ru219u8ehjr45h67p2; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.academico
    ADD CONSTRAINT fkbxru1w1ru219u8ehjr45h67p2 FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- Name: usuariojwt fkf4q3wc0vbprxtx0ko8rx1986k; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.usuariojwt
    ADD CONSTRAINT fkf4q3wc0vbprxtx0ko8rx1986k FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- Name: seccion fkgifelsgd22kt1mid5hrvdtkfj; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT fkgifelsgd22kt1mid5hrvdtkfj FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- Name: proyecto fkh9q3ib0v2a6x56ch8dbcw40by; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT fkh9q3ib0v2a6x56ch8dbcw40by FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- Name: compania fkkv0a55d2hrkvwf1bc98ol17r7; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.compania
    ADD CONSTRAINT fkkv0a55d2hrkvwf1bc98ol17r7 FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- Name: usuario_rol fkkxcv7htfnm9x1wkofnud0ewql; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT fkkxcv7htfnm9x1wkofnud0ewql FOREIGN KEY (id_rol) REFERENCES public.rol(id);


--
-- Name: skill fkq5lt52vexik5gkhcy4v6r03eb; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.skill
    ADD CONSTRAINT fkq5lt52vexik5gkhcy4v6r03eb FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- Name: escuela fks1v0qmd2iufbjn2hekk25r7sx; Type: FK CONSTRAINT; Schema: public; Owner: bbmiwcbr
--

ALTER TABLE ONLY public.escuela
    ADD CONSTRAINT fks1v0qmd2iufbjn2hekk25r7sx FOREIGN KEY (persona_id) REFERENCES public.persona(dni);


--
-- PostgreSQL database dump complete
--

