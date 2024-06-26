PGDMP  /                    |            examen    16.2    16.2     	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    25551    examen    DATABASE     h   CREATE DATABASE examen WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE examen;
                postgres    false            �            1259    25553    empresa    TABLE     �  CREATE TABLE public.empresa (
    id bigint NOT NULL,
    razon_social character varying(255),
    tipo_documento character varying(1),
    numero_documento character varying(11),
    condicion character varying(10),
    direccion character varying(255),
    distrito character varying(255),
    provincia character varying(255),
    departamento character varying(255),
    es_agente_retencion boolean,
    estado integer,
    usua_crea character varying(50),
    date_create timestamp with time zone,
    usua_modif character varying(50),
    date_modif timestamp with time zone,
    usua_delet character varying(50),
    date_delet timestamp with time zone
);
    DROP TABLE public.empresa;
       public         heap    postgres    false            �            1259    25552    empresa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.empresa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.empresa_id_seq;
       public          postgres    false    216                       0    0    empresa_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.empresa_id_seq OWNED BY public.empresa.id;
          public          postgres    false    215            s           2604    25561 
   empresa id    DEFAULT     h   ALTER TABLE ONLY public.empresa ALTER COLUMN id SET DEFAULT nextval('public.empresa_id_seq'::regclass);
 9   ALTER TABLE public.empresa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216                      0    25553    empresa 
   TABLE DATA           �   COPY public.empresa (id, razon_social, tipo_documento, numero_documento, condicion, direccion, distrito, provincia, departamento, es_agente_retencion, estado, usua_crea, date_create, usua_modif, date_modif, usua_delet, date_delet) FROM stdin;
    public          postgres    false    216   "                  0    0    empresa_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.empresa_id_seq', 1, false);
          public          postgres    false    215            u           2606    25563    empresa empresa_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            postgres    false    216                  x������ � �     