toc.dat                                                                                             0000600 0004000 0002000 00000014345 14232432765 0014456 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       #    $                z            customers_products    14.1    14.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                    0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                    0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                    1262    16455    customers_products    DATABASE     v   CREATE DATABASE customers_products WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1251';
 "   DROP DATABASE customers_products;
                user    false         ?            1259    16457 	   customers    TABLE     ?   CREATE TABLE public.customers (
    id bigint NOT NULL,
    first_name character varying(50),
    last_name character varying(50)
);
    DROP TABLE public.customers;
       public         heap    user    false         ?            1259    16456    customers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.customers_id_seq;
       public          user    false    210                    0    0    customers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;
          public          user    false    209         ?            1259    16464    products    TABLE     ?   CREATE TABLE public.products (
    id bigint NOT NULL,
    title character varying(255) NOT NULL,
    price numeric(8,2) NOT NULL
);
    DROP TABLE public.products;
       public         heap    user    false         ?            1259    16463    products_id_seq    SEQUENCE     x   CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.products_id_seq;
       public          user    false    212                    0    0    products_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;
          public          user    false    211         ?            1259    16507 	   purchases    TABLE     ?   CREATE TABLE public.purchases (
    id bigint NOT NULL,
    customer_id bigint NOT NULL,
    product_id bigint NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_DATE
);
    DROP TABLE public.purchases;
       public         heap    postgres    false         ?            1259    16506    purchases_id_seq    SEQUENCE     y   CREATE SEQUENCE public.purchases_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.purchases_id_seq;
       public          postgres    false    214         	           0    0    purchases_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.purchases_id_seq OWNED BY public.purchases.id;
          public          postgres    false    213         f           2604    16460    customers id    DEFAULT     l   ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);
 ;   ALTER TABLE public.customers ALTER COLUMN id DROP DEFAULT;
       public          user    false    210    209    210         g           2604    16467    products id    DEFAULT     j   ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);
 :   ALTER TABLE public.products ALTER COLUMN id DROP DEFAULT;
       public          user    false    212    211    212         h           2604    16510    purchases id    DEFAULT     l   ALTER TABLE ONLY public.purchases ALTER COLUMN id SET DEFAULT nextval('public.purchases_id_seq'::regclass);
 ;   ALTER TABLE public.purchases ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    214    214         ?          0    16457 	   customers 
   TABLE DATA           >   COPY public.customers (id, first_name, last_name) FROM stdin;
    public          user    false    210       3324.dat ?          0    16464    products 
   TABLE DATA           4   COPY public.products (id, title, price) FROM stdin;
    public          user    false    212       3326.dat            0    16507 	   purchases 
   TABLE DATA           F   COPY public.purchases (id, customer_id, product_id, date) FROM stdin;
    public          postgres    false    214       3328.dat 
           0    0    customers_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.customers_id_seq', 30, true);
          public          user    false    209                    0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.products_id_seq', 22, true);
          public          user    false    211                    0    0    purchases_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.purchases_id_seq', 2, true);
          public          postgres    false    213         k           2606    16462    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            user    false    210         m           2606    16469    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            user    false    212         o           2606    16513    purchases purchases_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.purchases
    ADD CONSTRAINT purchases_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.purchases DROP CONSTRAINT purchases_pkey;
       public            postgres    false    214                                                                                                                                                                                                                                                                                                   3324.dat                                                                                            0000600 0004000 0002000 00000001572 14232432765 0014262 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Иван	Иванов
2	Петр	Иванов
3	Андрей	Петров
4	Игорь	Ласточкин
5	Алексей	Петров
6	Евгений	Лучший
7	Екатерина	Андреева
8	Вадим	Сидоров
9	Борис	Кузнецов
10	Андрей	Павлов
11	Ольга	Зайцева
12	Павел	Котов
13	Артем	Лукин
14	Борис	Лукин
15	Антон	Петров
16	Павел	Кузнецов
17	Борис	Колесников
18	Виктор	Кузнецов
19	Иван	Никонов
20	Павел	Лагутин
21	Николай	Струков
22	Виктор	Николаев
23	Андрей	Сорокин
24	Мария	Зайцева
25	Наталья	Иванова
26	Дарья	Иванова
27	Сергей	Сорокин
28	София	Прядкина
29	Анна	Сорокина
30	Андрей	Котов
\.


                                                                                                                                      3326.dat                                                                                            0000600 0004000 0002000 00000001005 14232432765 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Хлеб	35.50
2	Молоко	60.00
3	Яблоки	135.00
4	Шоколад	50.00
5	Сыр	150.00
6	Апельсины	170.00
7	Масло	140.00
8	Багет	40.00
9	Печенье	70.00
10	Мороженое	60.00
11	Булочка	40.00
12	Бекон	200.00
13	Мясо	420.00
14	Сосиски	380.00
15	Картофель	37.00
16	Капуста	70.00
17	Морковь	19.00
18	Клубника	320.00
19	Сок	130.00
20	Вода	25.00
21	Кока-кола	80.00
22	Минеральная вода	42.00
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3328.dat                                                                                            0000600 0004000 0002000 00000020754 14232432765 0014271 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	1	1	2022-04-22 00:00:00
2	1	2	2022-03-18 00:00:00
3	2	2	2022-02-18 00:00:00
4	2	2	2022-02-18 00:00:00
5	2	2	2022-02-18 00:00:00
6	2	8	2022-02-15 00:00:00
7	2	15	2021-10-02 00:00:00
8	3	4	2022-01-11 00:00:00
9	3	14	2022-01-24 00:00:00
10	4	1	2022-04-07 00:00:00
11	5	10	2021-12-03 00:00:00
12	5	21	2022-03-29 00:00:00
13	6	13	2022-01-30 00:00:00
14	7	11	2021-11-07 00:00:00
15	7	9	2021-10-26 00:00:00
16	7	17	2022-03-04 00:00:00
17	7	9	2022-01-04 00:00:00
18	28	18	2022-01-01 00:00:00
19	14	13	2022-02-15 00:00:00
20	11	13	2021-10-10 00:00:00
21	12	21	2022-03-24 00:00:00
22	10	7	2021-06-01 00:00:00
23	24	10	2021-07-05 00:00:00
24	16	14	2022-01-19 00:00:00
25	24	19	2021-06-21 00:00:00
26	16	18	2021-09-01 00:00:00
27	13	16	2022-01-27 00:00:00
28	20	8	2021-06-21 00:00:00
29	2	16	2021-10-26 00:00:00
30	20	10	2021-09-04 00:00:00
31	28	5	2022-03-07 00:00:00
32	18	16	2021-07-13 00:00:00
33	13	21	2021-12-29 00:00:00
34	6	22	2021-11-12 00:00:00
35	16	19	2021-06-30 00:00:00
36	19	6	2021-07-22 00:00:00
37	13	6	2022-01-17 00:00:00
38	14	21	2022-04-09 00:00:00
39	23	6	2022-04-10 00:00:00
40	3	6	2021-09-25 00:00:00
41	14	9	2021-10-24 00:00:00
42	21	1	2022-02-26 00:00:00
43	9	10	2021-09-09 00:00:00
44	14	13	2022-04-09 00:00:00
45	23	1	2022-02-18 00:00:00
46	11	14	2021-11-23 00:00:00
47	26	17	2021-06-25 00:00:00
48	17	20	2021-08-08 00:00:00
49	25	8	2021-07-26 00:00:00
50	17	13	2021-09-11 00:00:00
51	17	8	2021-07-16 00:00:00
52	30	19	2022-02-15 00:00:00
53	11	9	2022-01-03 00:00:00
54	18	21	2022-02-17 00:00:00
55	12	14	2021-08-18 00:00:00
56	23	10	2021-06-08 00:00:00
57	24	7	2021-10-06 00:00:00
58	12	7	2021-07-06 00:00:00
59	13	11	2021-12-27 00:00:00
60	8	18	2021-12-17 00:00:00
61	14	9	2021-05-21 00:00:00
62	2	5	2021-10-30 00:00:00
63	27	19	2021-11-22 00:00:00
64	20	9	2021-11-27 00:00:00
65	28	2	2022-03-14 00:00:00
66	29	7	2021-12-10 00:00:00
67	12	22	2022-03-18 00:00:00
68	11	18	2021-08-09 00:00:00
69	17	5	2021-10-24 00:00:00
70	30	17	2021-07-03 00:00:00
71	8	11	2021-12-24 00:00:00
72	12	1	2022-03-05 00:00:00
73	1	10	2021-10-13 00:00:00
74	20	7	2022-02-08 00:00:00
75	22	7	2022-04-09 00:00:00
76	16	2	2022-03-10 00:00:00
77	26	8	2021-12-02 00:00:00
78	29	20	2021-05-31 00:00:00
79	12	21	2021-10-10 00:00:00
80	15	9	2022-01-23 00:00:00
81	8	5	2022-01-24 00:00:00
82	3	3	2021-06-04 00:00:00
83	6	10	2021-06-09 00:00:00
84	9	15	2021-06-07 00:00:00
85	7	9	2021-09-22 00:00:00
86	10	9	2022-03-27 00:00:00
87	1	7	2021-07-29 00:00:00
88	15	9	2022-02-12 00:00:00
89	2	21	2022-03-30 00:00:00
90	15	16	2021-08-19 00:00:00
91	16	2	2021-10-11 00:00:00
92	9	16	2022-02-02 00:00:00
93	10	14	2022-03-11 00:00:00
94	30	21	2021-07-12 00:00:00
95	10	12	2022-03-09 00:00:00
96	10	14	2021-06-04 00:00:00
97	16	12	2021-11-01 00:00:00
98	22	1	2021-11-28 00:00:00
99	20	5	2021-11-26 00:00:00
100	27	18	2022-03-14 00:00:00
101	8	9	2021-09-03 00:00:00
102	13	12	2021-06-03 00:00:00
103	16	10	2022-04-15 00:00:00
104	2	5	2021-12-10 00:00:00
105	14	5	2021-11-21 00:00:00
106	4	20	2022-04-08 00:00:00
107	21	11	2021-11-27 00:00:00
108	8	15	2022-01-02 00:00:00
109	6	3	2022-03-22 00:00:00
110	12	6	2021-05-30 00:00:00
111	15	14	2021-11-13 00:00:00
112	2	13	2021-05-10 00:00:00
113	26	3	2022-01-27 00:00:00
114	14	22	2021-10-22 00:00:00
115	10	18	2021-10-17 00:00:00
116	29	20	2022-03-24 00:00:00
117	3	6	2021-06-24 00:00:00
118	13	11	2021-05-26 00:00:00
119	24	9	2022-01-22 00:00:00
120	22	15	2022-03-06 00:00:00
121	24	5	2021-05-02 00:00:00
122	7	17	2021-09-13 00:00:00
123	15	2	2022-04-26 00:00:00
124	11	14	2021-06-12 00:00:00
125	20	7	2021-08-24 00:00:00
126	15	18	2021-08-25 00:00:00
127	3	19	2022-03-11 00:00:00
128	5	10	2022-03-19 00:00:00
129	7	14	2022-04-23 00:00:00
130	21	16	2022-03-18 00:00:00
131	7	21	2021-12-08 00:00:00
132	3	14	2021-08-03 00:00:00
133	21	8	2021-08-26 00:00:00
134	5	18	2021-11-22 00:00:00
135	29	17	2021-09-28 00:00:00
136	9	9	2021-09-17 00:00:00
137	19	20	2022-03-26 00:00:00
138	3	13	2021-11-04 00:00:00
139	29	14	2022-01-15 00:00:00
140	24	6	2021-10-04 00:00:00
141	4	4	2021-07-18 00:00:00
142	24	21	2022-04-22 00:00:00
143	22	16	2022-01-26 00:00:00
144	23	11	2021-05-15 00:00:00
145	25	15	2021-11-28 00:00:00
146	23	19	2021-11-29 00:00:00
147	25	4	2021-08-02 00:00:00
148	23	5	2022-04-05 00:00:00
149	19	13	2022-01-21 00:00:00
150	8	5	2021-08-08 00:00:00
151	28	11	2022-02-26 00:00:00
152	2	10	2021-08-04 00:00:00
153	11	11	2021-06-18 00:00:00
154	1	20	2021-07-25 00:00:00
155	12	17	2022-03-26 00:00:00
156	17	16	2021-11-18 00:00:00
157	13	19	2022-04-17 00:00:00
158	25	8	2022-01-01 00:00:00
159	14	5	2022-04-26 00:00:00
160	6	17	2021-11-09 00:00:00
161	21	22	2021-10-11 00:00:00
162	17	3	2022-03-23 00:00:00
163	5	13	2021-06-25 00:00:00
164	21	1	2021-10-06 00:00:00
165	7	15	2021-06-20 00:00:00
166	8	13	2021-12-24 00:00:00
167	25	18	2021-08-16 00:00:00
168	9	22	2021-10-16 00:00:00
169	26	22	2022-01-03 00:00:00
170	10	9	2021-11-11 00:00:00
171	30	21	2021-12-27 00:00:00
172	16	8	2021-09-02 00:00:00
173	15	17	2021-11-25 00:00:00
174	17	9	2021-07-17 00:00:00
175	6	3	2021-10-16 00:00:00
176	9	11	2021-06-23 00:00:00
177	23	9	2022-01-07 00:00:00
178	6	8	2021-10-09 00:00:00
179	22	2	2021-06-06 00:00:00
180	20	7	2021-12-10 00:00:00
181	3	4	2021-07-05 00:00:00
182	20	2	2021-05-12 00:00:00
183	19	17	2022-04-01 00:00:00
184	19	19	2021-05-02 00:00:00
185	30	17	2021-07-11 00:00:00
186	30	1	2021-07-13 00:00:00
187	5	16	2021-10-15 00:00:00
188	9	22	2022-01-08 00:00:00
189	10	15	2021-06-24 00:00:00
190	29	21	2022-03-19 00:00:00
191	28	1	2021-10-08 00:00:00
192	29	4	2022-01-05 00:00:00
193	11	14	2022-01-17 00:00:00
194	16	3	2022-01-21 00:00:00
195	30	1	2021-06-29 00:00:00
196	1	6	2022-01-29 00:00:00
197	28	3	2022-03-16 00:00:00
198	27	7	2022-04-24 00:00:00
199	25	10	2022-02-25 00:00:00
200	28	22	2021-07-31 00:00:00
201	12	10	2022-02-17 00:00:00
202	23	2	2021-08-21 00:00:00
203	5	22	2022-01-31 00:00:00
204	17	18	2022-04-14 00:00:00
205	3	22	2022-01-23 00:00:00
206	7	17	2021-10-14 00:00:00
207	22	19	2021-12-05 00:00:00
208	24	16	2021-10-23 00:00:00
209	17	17	2022-03-25 00:00:00
210	23	2	2022-04-02 00:00:00
211	16	19	2021-09-25 00:00:00
212	28	18	2021-10-18 00:00:00
213	14	5	2022-03-27 00:00:00
214	1	15	2021-05-31 00:00:00
215	20	13	2021-10-20 00:00:00
216	11	14	2022-01-31 00:00:00
217	10	12	2022-01-28 00:00:00
218	24	4	2021-09-19 00:00:00
219	25	20	2022-04-03 00:00:00
220	17	10	2021-11-11 00:00:00
221	3	11	2021-05-01 00:00:00
222	8	3	2021-05-26 00:00:00
223	15	12	2022-03-24 00:00:00
224	16	10	2021-07-08 00:00:00
225	27	10	2022-02-21 00:00:00
226	18	5	2021-06-05 00:00:00
227	28	16	2021-06-15 00:00:00
228	18	17	2022-01-13 00:00:00
229	8	8	2021-05-31 00:00:00
230	16	11	2021-10-12 00:00:00
231	3	9	2021-12-03 00:00:00
232	14	11	2021-11-23 00:00:00
233	26	9	2021-05-16 00:00:00
234	12	5	2022-04-05 00:00:00
235	23	16	2021-09-01 00:00:00
236	9	10	2021-12-19 00:00:00
237	1	22	2021-11-17 00:00:00
238	27	7	2022-03-18 00:00:00
239	11	14	2021-07-21 00:00:00
240	3	5	2021-12-14 00:00:00
241	5	2	2021-10-25 00:00:00
242	13	18	2021-07-29 00:00:00
243	4	10	2022-03-07 00:00:00
244	10	17	2021-12-03 00:00:00
245	4	3	2021-08-26 00:00:00
246	23	10	2021-06-14 00:00:00
247	8	1	2021-11-12 00:00:00
248	25	6	2021-10-29 00:00:00
249	25	18	2021-05-30 00:00:00
250	24	2	2022-03-12 00:00:00
251	7	9	2022-01-24 00:00:00
252	13	15	2022-02-10 00:00:00
253	15	22	2021-12-14 00:00:00
254	4	20	2022-01-09 00:00:00
255	3	12	2021-11-02 00:00:00
256	27	10	2021-12-24 00:00:00
257	25	22	2021-07-13 00:00:00
258	25	14	2021-12-21 00:00:00
259	14	8	2022-04-21 00:00:00
260	29	21	2022-01-04 00:00:00
261	18	1	2022-01-06 00:00:00
262	25	9	2021-06-28 00:00:00
263	29	3	2021-05-23 00:00:00
264	15	6	2021-07-03 00:00:00
265	13	8	2021-07-14 00:00:00
266	26	10	2021-05-25 00:00:00
267	30	15	2021-06-21 00:00:00
268	15	5	2021-08-21 00:00:00
269	5	4	2022-03-03 00:00:00
270	11	8	2021-08-01 00:00:00
271	15	2	2021-07-15 00:00:00
272	26	10	2021-06-02 00:00:00
273	25	2	2021-05-13 00:00:00
274	12	13	2021-05-29 00:00:00
275	17	15	2021-05-08 00:00:00
276	19	21	2021-08-02 00:00:00
277	18	15	2021-07-13 00:00:00
278	7	11	2021-09-15 00:00:00
279	27	2	2021-06-19 00:00:00
280	27	14	2022-01-22 00:00:00
281	11	12	2022-03-11 00:00:00
282	26	10	2022-04-16 00:00:00
283	3	17	2022-04-19 00:00:00
284	20	8	2021-09-25 00:00:00
285	4	4	2021-08-21 00:00:00
286	10	3	2021-09-16 00:00:00
287	3	20	2021-05-29 00:00:00
288	5	12	2021-05-23 00:00:00
289	24	2	2021-08-10 00:00:00
290	20	10	2022-04-09 00:00:00
291	13	11	2022-02-11 00:00:00
292	20	9	2021-08-21 00:00:00
293	16	16	2021-08-21 00:00:00
294	21	21	2022-03-11 00:00:00
295	15	18	2021-05-22 00:00:00
296	27	7	2021-07-13 00:00:00
297	11	6	2021-06-29 00:00:00
298	21	21	2021-12-27 00:00:00
299	30	14	2021-12-02 00:00:00
300	3	19	2021-05-07 00:00:00
\.


                    restore.sql                                                                                         0000600 0004000 0002000 00000012745 14232432765 0015405 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

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

DROP DATABASE customers_products;
--
-- Name: customers_products; Type: DATABASE; Schema: -; Owner: user
--

CREATE DATABASE customers_products WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1251';


ALTER DATABASE customers_products OWNER TO "user";

\connect customers_products

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
-- Name: customers; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.customers (
    id bigint NOT NULL,
    first_name character varying(50),
    last_name character varying(50)
);


ALTER TABLE public.customers OWNER TO "user";

--
-- Name: customers_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customers_id_seq OWNER TO "user";

--
-- Name: customers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.products (
    id bigint NOT NULL,
    title character varying(255) NOT NULL,
    price numeric(8,2) NOT NULL
);


ALTER TABLE public.products OWNER TO "user";

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO "user";

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: purchases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchases (
    id bigint NOT NULL,
    customer_id bigint NOT NULL,
    product_id bigint NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_DATE
);


ALTER TABLE public.purchases OWNER TO postgres;

--
-- Name: purchases_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.purchases_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.purchases_id_seq OWNER TO postgres;

--
-- Name: purchases_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.purchases_id_seq OWNED BY public.purchases.id;


--
-- Name: customers id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Name: purchases id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchases ALTER COLUMN id SET DEFAULT nextval('public.purchases_id_seq'::regclass);


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.customers (id, first_name, last_name) FROM stdin;
\.
COPY public.customers (id, first_name, last_name) FROM '$$PATH$$/3324.dat';

--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.products (id, title, price) FROM stdin;
\.
COPY public.products (id, title, price) FROM '$$PATH$$/3326.dat';

--
-- Data for Name: purchases; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchases (id, customer_id, product_id, date) FROM stdin;
\.
COPY public.purchases (id, customer_id, product_id, date) FROM '$$PATH$$/3328.dat';

--
-- Name: customers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.customers_id_seq', 30, true);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.products_id_seq', 22, true);


--
-- Name: purchases_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchases_id_seq', 2, true);


--
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: purchases purchases_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchases
    ADD CONSTRAINT purchases_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           