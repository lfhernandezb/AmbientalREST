--
-- PostgreSQL database dump
--

-- Dumped from database version 14.11
-- Dumped by pg_dump version 14.11

-- Started on 2024-02-26 15:26:01 -03

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 16527)
-- Name: companies; Type: TABLE; Schema: public; Owner: ambiental
--

CREATE TABLE public.companies (
    id_company bigint NOT NULL,
    name character varying(128) NOT NULL
);


ALTER TABLE public.companies OWNER TO ambiental;

--
-- TOC entry 210 (class 1259 OID 16530)
-- Name: finding_states; Type: TABLE; Schema: public; Owner: ambiental
--

CREATE TABLE public.finding_states (
    id_finding_state integer NOT NULL,
    description character varying(32) NOT NULL
);


ALTER TABLE public.finding_states OWNER TO ambiental;

--
-- TOC entry 211 (class 1259 OID 16533)
-- Name: findings; Type: TABLE; Schema: public; Owner: ambiental
--

CREATE TABLE public.findings (
    id_finding bigint NOT NULL,
    identifier character varying(16) NOT NULL,
    description character varying(8192) NOT NULL,
    comment character varying(8192) NOT NULL,
    id_finding_state integer NOT NULL,
    image character varying(1048576),
    id_project bigint,
    date timestamp with time zone NOT NULL
);


ALTER TABLE public.findings OWNER TO ambiental;

--
-- TOC entry 212 (class 1259 OID 16538)
-- Name: projects; Type: TABLE; Schema: public; Owner: ambiental
--

CREATE TABLE public.projects (
    id_project bigint NOT NULL,
    description character varying(256) NOT NULL,
    address character varying(2048) NOT NULL,
    id_company bigint
);


ALTER TABLE public.projects OWNER TO ambiental;

--
-- TOC entry 213 (class 1259 OID 16543)
-- Name: seq_companies_id_company; Type: SEQUENCE; Schema: public; Owner: ambiental
--

CREATE SEQUENCE public.seq_companies_id_company
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.seq_companies_id_company OWNER TO ambiental;

--
-- TOC entry 3612 (class 0 OID 0)
-- Dependencies: 213
-- Name: seq_companies_id_company; Type: SEQUENCE OWNED BY; Schema: public; Owner: ambiental
--

ALTER SEQUENCE public.seq_companies_id_company OWNED BY public.companies.id_company;


--
-- TOC entry 214 (class 1259 OID 16544)
-- Name: seq_findings_id_finding; Type: SEQUENCE; Schema: public; Owner: ambiental
--

CREATE SEQUENCE public.seq_findings_id_finding
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.seq_findings_id_finding OWNER TO ambiental;

--
-- TOC entry 3613 (class 0 OID 0)
-- Dependencies: 214
-- Name: seq_findings_id_finding; Type: SEQUENCE OWNED BY; Schema: public; Owner: ambiental
--

ALTER SEQUENCE public.seq_findings_id_finding OWNED BY public.findings.id_finding;


--
-- TOC entry 215 (class 1259 OID 16545)
-- Name: seq_projects_id_project; Type: SEQUENCE; Schema: public; Owner: ambiental
--

CREATE SEQUENCE public.seq_projects_id_project
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.seq_projects_id_project OWNER TO ambiental;

--
-- TOC entry 3614 (class 0 OID 0)
-- Dependencies: 215
-- Name: seq_projects_id_project; Type: SEQUENCE OWNED BY; Schema: public; Owner: ambiental
--

ALTER SEQUENCE public.seq_projects_id_project OWNED BY public.projects.id_project;


--
-- TOC entry 3444 (class 2604 OID 16546)
-- Name: companies id_company; Type: DEFAULT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.companies ALTER COLUMN id_company SET DEFAULT nextval('public.seq_companies_id_company'::regclass);


--
-- TOC entry 3445 (class 2604 OID 16547)
-- Name: findings id_finding; Type: DEFAULT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.findings ALTER COLUMN id_finding SET DEFAULT nextval('public.seq_findings_id_finding'::regclass);


--
-- TOC entry 3446 (class 2604 OID 16548)
-- Name: projects id_project; Type: DEFAULT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.projects ALTER COLUMN id_project SET DEFAULT nextval('public.seq_projects_id_project'::regclass);


--
-- TOC entry 3600 (class 0 OID 16527)
-- Dependencies: 209
-- Data for Name: companies; Type: TABLE DATA; Schema: public; Owner: ambiental
--

COPY public.companies (id_company, name) FROM stdin;
\.


--
-- TOC entry 3601 (class 0 OID 16530)
-- Dependencies: 210
-- Data for Name: finding_states; Type: TABLE DATA; Schema: public; Owner: ambiental
--

COPY public.finding_states (id_finding_state, description) FROM stdin;
1	Pendiente
2	Ok
3   Solicitado
4   En revisión
5   No aplica
\.


--
-- TOC entry 3602 (class 0 OID 16533)
-- Dependencies: 211
-- Data for Name: findings; Type: TABLE DATA; Schema: public; Owner: ambiental
--

COPY public.findings (id_finding, identifier, description, comment, id_finding_state, image, id_project, date) FROM stdin;
\.


--
-- TOC entry 3603 (class 0 OID 16538)
-- Dependencies: 212
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: ambiental
--

COPY public.projects (id_project, description, address, id_company) FROM stdin;
\.


--
-- TOC entry 3615 (class 0 OID 0)
-- Dependencies: 213
-- Name: seq_companies_id_company; Type: SEQUENCE SET; Schema: public; Owner: ambiental
--

SELECT pg_catalog.setval('public.seq_companies_id_company', 1, false);


--
-- TOC entry 3616 (class 0 OID 0)
-- Dependencies: 214
-- Name: seq_findings_id_finding; Type: SEQUENCE SET; Schema: public; Owner: ambiental
--

SELECT pg_catalog.setval('public.seq_findings_id_finding', 1, false);


--
-- TOC entry 3617 (class 0 OID 0)
-- Dependencies: 215
-- Name: seq_projects_id_project; Type: SEQUENCE SET; Schema: public; Owner: ambiental
--

SELECT pg_catalog.setval('public.seq_projects_id_project', 1, false);


--
-- TOC entry 3448 (class 2606 OID 16550)
-- Name: companies companies_pkey; Type: CONSTRAINT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.companies
    ADD CONSTRAINT companies_pkey PRIMARY KEY (id_company);


--
-- TOC entry 3450 (class 2606 OID 16552)
-- Name: finding_states finding_states_pkey; Type: CONSTRAINT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.finding_states
    ADD CONSTRAINT finding_states_pkey PRIMARY KEY (id_finding_state);


--
-- TOC entry 3452 (class 2606 OID 16554)
-- Name: findings findings_pkey; Type: CONSTRAINT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.findings
    ADD CONSTRAINT findings_pkey PRIMARY KEY (id_finding);


--
-- TOC entry 3457 (class 2606 OID 16556)
-- Name: projects projects_pkey; Type: CONSTRAINT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id_project);


--
-- TOC entry 3453 (class 1259 OID 16558)
-- Name: fki_fk_findings_id_finding_state; Type: INDEX; Schema: public; Owner: ambiental
--

CREATE INDEX fki_fk_findings_id_finding_state ON public.findings USING btree (id_finding_state);


--
-- TOC entry 3454 (class 1259 OID 16557)
-- Name: fki_fk_findings_id_project; Type: INDEX; Schema: public; Owner: ambiental
--

CREATE INDEX fki_fk_findings_id_project ON public.findings USING btree (id_project);


--
-- TOC entry 3455 (class 1259 OID 16559)
-- Name: fki_fk_projects_id_company; Type: INDEX; Schema: public; Owner: ambiental
--

CREATE INDEX fki_fk_projects_id_company ON public.projects USING btree (id_company);


--
-- TOC entry 3458 (class 2606 OID 16560)
-- Name: findings fk_findings_id_project; Type: FK CONSTRAINT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.findings
    ADD CONSTRAINT fk_findings_id_project FOREIGN KEY (id_project) REFERENCES public.projects(id_project) NOT VALID;


--
-- TOC entry 3459 (class 2606 OID 16565)
-- Name: findings fk_findings_id_state; Type: FK CONSTRAINT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.findings
    ADD CONSTRAINT fk_findings_id_state FOREIGN KEY (id_finding_state) REFERENCES public.finding_states(id_finding_state) NOT VALID;


--
-- TOC entry 3460 (class 2606 OID 16570)
-- Name: projects fk_projects_id_company; Type: FK CONSTRAINT; Schema: public; Owner: ambiental
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT fk_projects_id_company FOREIGN KEY (id_company) REFERENCES public.companies(id_company) NOT VALID;


-- Completed on 2024-02-26 15:26:01 -03

--
-- PostgreSQL database dump complete
--

