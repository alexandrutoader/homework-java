# 1. Să se selecteze deptno, enume, job și sal pentru angajatii care au sef-ul cu id-ul 7902.
#     select e.DEPTNO AS DEPARTAMENT,ENAME AS NUME, SAL AS SALARIU, JOB FROM EMP e WHERE e.MGR = 7902;

# 2. Să se selecteze numele, funcția și salariu pentru angajații care au aceași funcție.
# SELECT group_concat(ENAME separator ', '),
#        JOB,
#        group_concat(SAL separator ', ') as salaries,
#        avg(SAL)
# FROM EMP e
# where e.SAL > 1500 #actioneaza pe randuri
# group by e.JOB #actioneaza pe grupuri
# having count(e.ENAME) > 1;


# 3. Să se selecteze numele, funcția și salariul anual pentru toți angajații din același departament.
# select group_concat(ENAME, concat(':', (SAL + ifnull(COMM, 0)) * 12), concat(':', JOB) separator ',       ') employees
# from EMP e
# group by e.DEPTNO;

# 4. Să se selecteze numele, funcția și venitul lunar pentru toți angajații care au venitul lunar mai mare de 2000.
# Venitul lunar este o funcție care are formula salariu + ifnull(comision, 0)

# select ENAME, JOB, (SAL + ifnull(COMM, 0)) as venit_lunar, HIREDATE
# from EMP
# where SAL + ifnull(COMM, 0) > 2000
# order by SAL + ifnull(COMM, 0) DESC;


# 5.Să se selecteze id-ul angajatului, numele, funcția și data angajării pentru toți angajații care au aceași funcție
# și au venit în firmă după o anumită dată.

# select EMPNO, ENAME, JOB, HIREDATE
# from EMP
# where HIREDATE > '1982-12-01'
#   AND JOB = 'ANALYST';

#
# 6. Să se adauge 10 noi angajati.
# INSERT INTO EMP VALUES (10000, 'John', 'SALESMAN', 7698, '1981-02-22', 2000, 500, 30),
#                        (10001, 'Ion', 'SALESMAN', 7698, '1981-02-22', 2000, 500, 30),
#                        (10002, 'Joe', 'SALESMAN', 7698, '1981-02-22', 2000, 500, 30);

# 7. Să se calculeze o primă de 15% pentur toți angajații din departamentul 20.
# alter table EMP drop COLUMN PRIMA;
# ALTER TABLE EMP ADD COLUMN PRIMA int(4) default 0;
# update EMP e
# set e.PRIMA = e.SAL * 0.15
# where DEPTNO = 20;

# select * from EMP
# order by EMPNO asc
# limit 500; #primary key-ul


# 8. Să se selecteze id-ul și numele departamentului din tabela departamente.
SELECT d.id, d.name
FROM department d;

# 9. Să se selecteze id-ul, numele, funcția și data angajării pentru toți angajații din firmă.
SELECT e.id, e.name, e.job, e.hiredate
FROM employee e;

# Ordonați descrescător în funcție de id. Concatenați id-ul cu numele.
# 10. Să se selecteze id-ul, numele, fucția și venitul lunar pentru toți angajatii din firmă.
SELECT CONCAT(e.id, ' ', e.name) AS id_and_name, e.job, e.salary
FROM employee e
ORDER BY e.id DESC;

#  Să se adauge la select o coloană goală care să se numească semnătura. Concatenați id-ul cu numele. Ordonați după departament.
# 11. Să se selecteze numele și funcția angajaților.
SELECT e.name, e.job, CONCAT(e.id,' ',e.name) AS semnatura
FROM employee e
ORDER BY e.department_id;

# 12. Să se facă o listă cu numele departamentului și codul acestuia. Ordonați după numele departamentului.
SELECT d.name, d.id
FROM department d
ORDER BY d.name;

# 13. Să se selecteze toți angajații care au funcția manager. Ordonați după id-ul departamentului
SELECT *
FROM employee e
WHERE e.job="MANAGER"
ORDER BY e.department_id;

# 14. Selectați toate persoanele care s-au angajat intr-o anumită perioadă aleasa de voi.
SELECT *
FROM employee e
WHERE e.hiredate BETWEEN "1981-01-01" AND "1981-12-01";

# 15. Să se listeze id-ul, numele, funcția, venitul lunar pentru angajații care au următoarele id-uri: 7499,7902, 7876
SELECT  e.id, e.name, e.job, e.salary
FROM employee e
WHERE e.id IN (7499,7902, 7876);

# 16. Să se selecteze toate persoanele care au fost angajate în anul 1980
SELECT *
FROM employee e
WHERE e.hiredate BETWEEN "1980-01-01" AND "1980-12-31";

# 17. Să se selecteze toate persoanele al căror nume începe cu litera F și numele funcției are 7 caractere.
select e.name
from employee e
where e.name like 'F%'
  and length(e.job) = 7;

# 18. Să se listeze angajații din departamentul 20 care nu au primit comision.
SELECT *
FROM employee e
WHERE e.department_id = 20
AND e.comm < 1;

# 19. Să se listeze angajații care au primit comision și au funcția SALESMAN
SELECT *
FROM employee e
WHERE e.comm > 1
AND e.job="SALESMAN";

# 20. Să se selecteze toți angajații care au funcția MANAGER și salariul peste 1500 și toți angajații care au funcția ANALYST.
SELECT *
FROM employee e
WHERE e.job IN ("MANAGER","ANALYST")
AND e.salary > 1500;

# 21. Selectați toți angajații care s-au angajat înainte de anul 1982 și nu au primit comision.
SELECT *
FROM employee e
WHERE e.hiredate < "1982-01-01"
AND e.comm < 1;

# 22. Selectați toți angajații care au salariul peste 3000 și nu au șefi, ordonați după departament.
SELECT *
FROM employee e
WHERE e.salary > 3000
AND e.mgr IS NULL
ORDER BY e.department_id;

# 23. Selectați numele, funcția și venitul anual al angajaților care nu au funcția MANAGER pentru un departament ales de voi.
SELECT e.name, e.job, e.salary
FROM employee e
WHERE e.job != "MANAGER"
AND e.department_id = 20;

# 24. Selectați numele, numele, data angajării și
# salariul tuturor persoanelor angajate în anul 1981
# din două departamente alese de voi.
select d.name, e.name, e.hiredate, e.salary
from employee e
join department d
     on e.department_id = d.id
 where year(e.hiredate) = 1981;

select e.name, e.department_id, d.id, d.name
from employee e
         join department d # din tabelul joinuit
              on e.department_id = d.id;


# 25. angajatii care lucreaza la dept din Chicago

select e.name
from employee e
         join department d
              on e.department_id = d.id
where d.city = 'CHICAGO';

#cu subquery necorelat echivalent
select e.name, (select city from department where id = e.department_id) as dept_city
from employee e;
# where e.department_id in (select id from department where city='CHICAGO');


# union operators --> ca un join pe verticala
select e.name as emps_then_depts
from employee e
UNION
select d.name
from department d;

select e.*, d.*
from employee e
         join department d;
# daca nu pui "ON" obtii produs cartezian
