create database sql_concepts;
use sql_concepts;

show databases;

create table dept_tab(
	deptno varchar(5),
    dname varchar(50),
    mgr_id varchar(10),
    location_id varchar(10),
    constraint pk_dept_tab primary key(deptno)
);

describe dept_tab;
show tables;

create table emp_tab(
	empno varchar(5),
    name varchar(50) not null,
    job varchar(50),
    manager varchar(10),
    hiredate date,
    salary varchar(20),
    commission varchar(10),
    deptno varchar(5),
	constraint pk_emp_tab primary key(empno),
    constraint fk_emp_tab foreign key(deptno) references dept_tab(deptno)
);

describe emp_tab;

create table country_tab(
	country_id varchar(5),
    country_name varchar(50),
    constraint pk_country_tab primary key(country_id)
);

create table state_tab(
	state_id varchar(10),
	state_name varchar(50),
    country_id varchar(5),
    constraint pk_states_tab primary key (state_id),
    constraint fk_states_tab foreign key (country_id) references country_tab(country_id);
);

show tables;
describe country_tab;
describe state_tab;

insert into dept_tab values( 30 , 'purchasing' , 114, 1700 );
insert into dept_tab values( 40 , 'human resources' , 203, 2400 );
insert into dept_tab values( 70 , 'public relations' , 204 , 2700 );
insert into dept_tab values( 80 , 'sales' , 145 , 2500 );
insert into dept_tab values( 90 , 'executives' , 100, 1700 );
insert into dept_tab values( 100 , 'finance' , 108, 2400 );
insert into dept_tab values( 110 , 'accounting' , 202, 2100 );

insert into dept_tab values( 120 , 'teasury' , null , 2100 );
insert into dept_tab values( 130 , 'coperate tax' , null , 1700 );
insert into dept_tab values( 140 , 'control and credit' , null , 1600 );
insert into dept_tab values( 150 , 'shareholder services' , null , 1800 );

select * from dept_tab ;
select count(*) from dept_tab;

insert into emp_tab values( 7000, 'KING' , 'president' , null , '2005-11-17' , 5000 , null , 40);
insert into emp_tab values( 7003, 'clark' , 'manager' , null , str_to_date('2-11-2006', '%d-%m-%Y') , 3400 , null , 40);
insert into emp_tab values( 7004, 'scott' , 'manager' , null , str_to_date('21-03-2006', '%d-%m-%Y') , 2450 , null , 40);
insert into emp_tab values( 7005, 'jones' , 'analyst' , null , str_to_date('14-10-2002', '%d-%m-%Y') , 3000 , null , 70);
insert into emp_tab values( 7001, 'cooper' , 'analyst' , null , str_to_date('06-03-2002', '%d-%m-%Y') , 5300 , null , 30);
insert into emp_tab values( 7002, 'Miller' , 'programmer' , null , str_to_date('2-11-2003', '%d-%m-%Y') , 4400 , null , 30);

select * from emp_tab; 

drop table emp_tab;

insert into country_tab values(1, 'USA');
insert into country_tab values(2, 'India');
insert into country_tab values(3, 'Canada');

select * from country_tab;

insert into state_tab values(1,'California',1);
insert into state_tab values(2,'Texas',1);
insert into state_tab values(3,'Karnataka',2);

select * from state_tab;

select empno , 10*(salary+100) as 'Updated Salary' from emp_tab;
select concat(name, ' belongs to ',deptno,' department number') as "employee department data" from emp_tab;
select count(distinct deptno) from dept_tab;

select distinct name , deptno from emp_tab;
select distinct deptno , name from emp_tab;

select empno , name , salary from emp_tab where salary>4200;
select empno , name , salary from emp_tab where name='KING';
select empno , name , salary from emp_tab where name<>'KING';

select empno , name , salary from emp_tab where salary between 2000 and 4500;
select empno , name , salary from emp_tab where salary not between 2000 and 4500;
select empno , name , salary from emp_tab where deptno in (30,40) ;
select empno , name , salary from emp_tab where deptno not in (30,40) ;
select empno , name , salary from emp_tab where name in ('KING','miller');

select empno , name , salary from emp_tab where name like '%i%';

select empno , name , salary from emp_tab where deptno is null;
select empno , name , salary from emp_tab where deptno in (30,40) and salary>4200 ;
select empno , name , salary from emp_tab where deptno in (30,40) or salary>=4200 ;
select empno , name , salary from emp_tab where deptno not in (30,40) or salary>4200 ;

select empno , name , salary from emp_tab where deptno=30 or deptno=40 and salary>3000;
select empno , name , salary from emp_tab where (deptno=30 or deptno=40) and salary>3000;

select empno , name , deptno , salary from emp_tab order by salary desc ;
select empno , name , deptno , salary from emp_tab order by name desc ;
select empno , name , deptno , salary from emp_tab order by hiredate desc ;

select concat('hello',' everyone !') as 'Message' from dual ;
select concat('hello everyone! ', 7, 5) as 'substring message' from dual ;
select length('hello everyone! ', 7, 5) as 'Total message' from dual ;

CREATE TABLE Guide (
    GuideID INT PRIMARY KEY,
    GuideName VARCHAR(50)
);

CREATE TABLE Student (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50),
    GuideID INT,
    FOREIGN KEY (GuideID) REFERENCES Guide(GuideID)
); 

ALTER TABLE Student ADD COLUMN Age INT;
ALTER TABLE Student DROP COLUMN Age;
ALTER TABLE Student MODIFY COLUMN StudentName VARCHAR(100);
ALTER TABLE Student RENAME COLUMN StudentName TO FullName;
ALTER TABLE Student RENAME TO Pupils;
ALTER TABLE Student ADD PRIMARY KEY (StudentID);
ALTER TABLE Student DROP PRIMARY KEY;
ALTER TABLE Student ADD CONSTRAINT FK_GuideID FOREIGN KEY (GuideID) REFERENCES Guide(GuideID);
ALTER TABLE Student DROP FOREIGN KEY FK_GuideID;


DROP TABLE Student;
DROP TABLE Guide;

TRUNCATE TABLE Student;

INSERT INTO Guide (GuideID, GuideName) VALUES (1, 'Dr. Smith');
INSERT INTO Student (StudentID, StudentName, GuideID) VALUES (101, 'John Doe', 1);

SELECT * FROM Student;

UPDATE Student SET StudentName = 'Jane Doe' WHERE StudentID = 101;
UPDATE Student SET StudentName = 'Jane Doe', Age = 20 WHERE StudentID = 101;
UPDATE Student SET Age = Age + 1 WHERE Age < 20;
UPDATE Student SET GuideID = (SELECT GuideID FROM Guide WHERE GuideName = 'Dr. Smith') WHERE StudentName = 'Jane Doe';
UPDATE Student SET Age = 21 WHERE StudentID = 101 AND Age = 20;

DELETE FROM Student WHERE StudentID = 101;

select lpad(5000,8,'*') from dual ;
select lpad(10000,8,'*') from dual ;
select lpad(10000,8,'*') from dual ;

select trim('d' from 'helloWorld') from dual;
select replace('helloWorld','hello','bye') from dual;

select name , job , salary ,CASE job 
when 'manager' then 1.20*salary 
when 'analyst' then 1.15*salary
when 'clerk' then 1.10*salary
else salary
end 'revised salary'
from emp_tab;

select name , job , salary , decode(job, 'manager' , 120*salary ,
'analyst',1.15*salary , 'clerk' , 1.10*salary , salary )"Revised Salary"
from emp_tab;

select sum(salary) from emp_tab;
select avg(salary) from emp_tab;
select count(*) from emp_tab;
select count(distinct(empno)) from emp_tab;

select manager , max(salary) from emp_tab group by manager order by max(salary) desc;

# joins :

CREATE TABLE Students2 (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50),
    CourseID INT
);

CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(50)
);

-- Insert data into Students table
INSERT INTO Students2 (StudentID, StudentName, CourseID)
VALUES
    (1, 'Alice', 101),
    (2, 'Bob', 102),
    (3, 'Charlie', 103),
    (4, 'David', 101);

-- Insert data into Courses table
INSERT INTO Courses (CourseID, CourseName)
VALUES
    (101, 'Math'),
    (102, 'Science'),
    (103, 'History'),
    (104, 'Art');


SELECT Students2.StudentID, Students2.StudentName, Courses.CourseName
FROM Students2
INNER JOIN Courses ON Students2.CourseID = Courses.CourseID;

SELECT Students2.StudentID, Students2.StudentName, Courses.CourseName
FROM Students2
LEFT JOIN Courses ON Students2.CourseID = Courses.CourseID;

SELECT Students2.StudentID, Students2.StudentName, Courses.CourseName
FROM Students2
RIGHT JOIN Courses ON Students2.CourseID = Courses.CourseID;

SELECT Students2.StudentID, Students2.StudentName, Courses.CourseName
FROM Students2
FULL JOIN Courses ON Students2.CourseID = Courses.CourseID;


# access modifier in SQL :

create database libraryDB ; 
use libraryDB ;

create table books(
bookID int primary key auto_increment,
title varchar(255) not null ,
author varchar(255) ,
publicationYear int ,
genre varchar(50) ,
availableCopies int 
);

show tables ;

insert into books(title,  author , publicationYear , genre , availableCopies) values 
('atomic habits' , 'james' , 2005 , 'self-growth' , 100 ),
('SAONGAF' , 'mark' , 2012 , 'self-growth' , 300 );

select * from books;

CREATE USER 'username'@'hostname' IDENTIFIED BY 'password';
GRANT select , update , delete , insert ON libraryDB.books TO 'username'@'hostname';

select * from information_schema.user_privileges;

REVOKE delete ON libraryDB.books from 'username'@'hostname';
SHOW GRANTS FOR 'username'@'hostname';

create table customers(
customer_id int not null auto_increment ,
name varchar(255) not null ,
email varchar(255) not null,
primary key(customer_id));

insert into customers(name , email ) values 
( 'aarin' , 'aarin@gmail.com' ),
( 'poorni' , 'poorni@gmail.com' ) ;

select * from customers ;

set autocommit = 0;

start transaction;

update customers set name = 'ABC XYZ' 
where customer_id =1 ;

commit ;

update customers set name = 'ABC PQR'
where customer_id = 1 ;

rollback ;

create table orders(
order_id int not null auto_increment ,
customer_id int null ,
quantity int not null ,
primary key(order_id) ,
foreign key(customer_id) references customers(customer_id));

insert into orders(customer_id , quantity) values (1,250) , (2,390) ;

select * from orders ;

create view cusotmer_orders as 
select distinct order_id , quantity from 
orders where customer_id = 1 ;

create table strangerthings(
id int  primary key ,
character_name varchar(255) ,
last_seen date ,
next_appearance date ,
location varchar(255) );

insert into strangerthings values 
(1, 'mike' , '1985-01-23' , '1993-03-01' , 'hawkins'),
(2, 'nancy' , '1980-12-12' , '1999-07-21' , 'manhattan');

select character_name , datediff(next_appearance, last_seen) as days_until_next_appearance from strangerthings;
select character_name , dayofweek(next_appearance) as days_of_week from strangerthings;
select character_name , dayofyear(next_appearance) as days_of_year from strangerthings;
select character_name , dayname(next_appearance) as day_name from strangerthings;
select character_name , dayofmonth(next_appearance) as days_of_month from strangerthings;

select character_name , dayofyear(next_appearance) ,
if( dayofyear(next_appearance) = '1' , 'Happy New Year !' , 'Just another day...' ) as message from strangerthings ;

select character_name , adddate(next_appearance , interval 1 day) as next_appearance_tomorrow from strangerthings ;

create table employees(
 id varchar(36) primary key ,
 name varchar(255),
 email varchar(255),
 password varchar(255),
 salary decimal(10,2) ,
 job_experience int );

DELIMITER //
create trigger adjust_salary_before_insert 
before insert on employees 
for each row
begin
	if new.job_experience>5 then
		set new.salary = new.salary*1.20 ;
	else
		set new.salary = new.salary*1.10 ;
end if;
end;
DELIMITER;

DELIMITER //
create trigger adjust_salary_before_update 
before update on employees 
for each row
begin
	if new.job_experience>5 then
		set new.salary = new.salary*1.20 ;
	else
		set new.salary = new.salary*1.10 ;
end if;
end;
DELIMITER;

INSERT INTO employees (id, name, email, password, salary, job_experience)
VALUES
    ('1', 'Alice Johnson', 'alice.johnson@example.com', 'password123', 55000.00, 5),
    ('2', 'Bob Smith', 'bob.smith@example.com', 'bobpassword456', 60000.00, 6),
    ('3', 'Charlie Brown', 'charlie.brown@example.com', 'charliepassword789', 70000.00, 8),
    ('4', 'Diana Lee', 'diana.lee@example.com', 'dianapassword012', 65000.00, 7);

DELIMITER //
create trigger prevent_employee_deletion
before delete on employees
for each row
begin 
	signal sqlstate '45000'
    set message_text = 'Deletion of employee record is not allowed' ;
end ;
delimiter ;    


select * from employees ;

delete from employees where id=1;

-- creating a database to connect with JAVA :
create database JDBC_ConnectionDB ;
use JDBC_ConnectionDB ;

create table employee(
empID int
);

drop table employee;
describe employee;
show tables ;

select * from employee;


-- Creating procedures to call it from java

CREATE TABLE JDBC_ConnectionDB.employeeRecords(
empid int not null primary key,
name varchar(20) not null ,
role varchar(20) default null ,
city varchar(25) ,
country varchar(25)
);

DELIMITER //;
create procedure JDBC_ConnectionDB.insertEmployeeRecord(
IN in_id int,
IN in_name varchar(20),
IN in_role varchar(20),
IN in_city varchar(20),
IN in_country varchar(25),
OUT out_result varchar(20)
)
BEGIN
	INSERT into jdbc_connectiondb.employeeRecord( empid , name , role , city , country ) 
    VALUES (in_id , in_name , in_role , in_city , in_country );
    commit ;
    SET out_result := 'TRUE' ;
END;

update employee set first_name = 'pop' where id = 233 ;

insert into employee values(233 , 'pop' , 'medi' , 'SDE' );
