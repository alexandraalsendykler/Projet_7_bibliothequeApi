--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-28 00:05:23

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

DROP DATABASE bibliotheque;
--
-- TOC entry 2854 (class 1262 OID 27393)
-- Name: bibliotheque; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE bibliotheque WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_France.1252';


ALTER DATABASE bibliotheque OWNER TO postgres;

\connect bibliotheque

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
-- TOC entry 205 (class 1259 OID 27407)
-- Name: exemplaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exemplaire (
    id_exemplaire integer NOT NULL,
    id_livre integer NOT NULL
);


ALTER TABLE public.exemplaire OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 27405)
-- Name: exemplaire_id_exemplaire_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exemplaire_id_exemplaire_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exemplaire_id_exemplaire_seq OWNER TO postgres;

--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 204
-- Name: exemplaire_id_exemplaire_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exemplaire_id_exemplaire_seq OWNED BY public.exemplaire.id_exemplaire;


--
-- TOC entry 203 (class 1259 OID 27396)
-- Name: livre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livre (
    id_livre integer NOT NULL,
    titre character varying(300) NOT NULL,
    auteur character varying(100) NOT NULL,
    resume character varying(500)
);


ALTER TABLE public.livre OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 27394)
-- Name: livre_id_livre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livre_id_livre_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livre_id_livre_seq OWNER TO postgres;

--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 202
-- Name: livre_id_livre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livre_id_livre_seq OWNED BY public.livre.id_livre;


--
-- TOC entry 209 (class 1259 OID 27426)
-- Name: pret; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pret (
    id_pret integer NOT NULL,
    id_utilisateur integer NOT NULL,
    id_exemplaire integer NOT NULL,
    date_reservation date NOT NULL,
    date_de_fin date NOT NULL,
    statut character varying NOT NULL
);


ALTER TABLE public.pret OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 27424)
-- Name: pret_id_pret_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pret_id_pret_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pret_id_pret_seq OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 208
-- Name: pret_id_pret_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pret_id_pret_seq OWNED BY public.pret.id_pret;


--
-- TOC entry 207 (class 1259 OID 27415)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id_utilisateur integer NOT NULL,
    prenom character varying(50) NOT NULL,
    nom character varying(100) NOT NULL,
    email character varying(200) NOT NULL,
    mot_de_passe character varying(200) NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 27413)
-- Name: utilisateur_id_utilisateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_utilisateur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_utilisateur_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 206
-- Name: utilisateur_id_utilisateur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_id_utilisateur_seq OWNED BY public.utilisateur.id_utilisateur;


--
-- TOC entry 2709 (class 2604 OID 27410)
-- Name: exemplaire id_exemplaire; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exemplaire ALTER COLUMN id_exemplaire SET DEFAULT nextval('public.exemplaire_id_exemplaire_seq'::regclass);


--
-- TOC entry 2708 (class 2604 OID 27399)
-- Name: livre id_livre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livre ALTER COLUMN id_livre SET DEFAULT nextval('public.livre_id_livre_seq'::regclass);


--
-- TOC entry 2711 (class 2604 OID 27429)
-- Name: pret id_pret; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pret ALTER COLUMN id_pret SET DEFAULT nextval('public.pret_id_pret_seq'::regclass);


--
-- TOC entry 2710 (class 2604 OID 27418)
-- Name: utilisateur id_utilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id_utilisateur SET DEFAULT nextval('public.utilisateur_id_utilisateur_seq'::regclass);


--
-- TOC entry 2715 (class 2606 OID 27412)
-- Name: exemplaire exemplaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exemplaire
    ADD CONSTRAINT exemplaire_pk PRIMARY KEY (id_exemplaire);


--
-- TOC entry 2713 (class 2606 OID 27404)
-- Name: livre livre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livre
    ADD CONSTRAINT livre_pk PRIMARY KEY (id_livre);


--
-- TOC entry 2719 (class 2606 OID 27431)
-- Name: pret pret_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pret
    ADD CONSTRAINT pret_pk PRIMARY KEY (id_pret);


--
-- TOC entry 2717 (class 2606 OID 27423)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur);


--
-- TOC entry 2721 (class 2606 OID 27437)
-- Name: pret exemplaire_pret_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pret
    ADD CONSTRAINT exemplaire_pret_fk FOREIGN KEY (id_exemplaire) REFERENCES public.exemplaire(id_exemplaire);


--
-- TOC entry 2720 (class 2606 OID 27432)
-- Name: exemplaire livre_exemplaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exemplaire
    ADD CONSTRAINT livre_exemplaire_fk FOREIGN KEY (id_livre) REFERENCES public.livre(id_livre);


--
-- TOC entry 2722 (class 2606 OID 27442)
-- Name: pret utilisateur_pret_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pret
    ADD CONSTRAINT utilisateur_pret_fk FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur);


-- Completed on 2021-04-28 00:05:23

--
-- PostgreSQL database dump complete
--

