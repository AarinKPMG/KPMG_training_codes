-- First, creating the procedure
CREATE OR REPLACE PROCEDURE print_message IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hi PLSQL');
END print_message;
/

-- Enabling output
SET SERVEROUTPUT ON SIZE 30000;

-- Executing the procedure
EXECUTE print_message;

-- Creating the table using anonymous PL/SQL block
BEGIN
    EXECUTE IMMEDIATE 'CREATE TABLE employee(
        employee_id NUMBER(10) PRIMARY KEY,
        first_name VARCHAR2(50),
        last_name VARCHAR2(50),
        performance_rating VARCHAR2(100),
        salary NUMBER(10),
        department_id NUMBER(10),
        bonus NUMBER(10)
    )';
END;
/

-- Cursor for selecting employees with salary > 5000
DECLARE
    CURSOR emp_cur IS
        SELECT * FROM employee
        WHERE salary > 5000;
    emp_rec emp_cur%ROWTYPE;
BEGIN
    OPEN emp_cur;
    LOOP
        FETCH emp_cur INTO emp_rec;
        EXIT WHEN emp_cur%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(emp_rec.employee_id || ' - ' || emp_rec.first_name
            || ' - ' || emp_rec.last_name || ' - ' || emp_rec.performance_rating
            || ' - ' || emp_rec.salary || ' - ' || emp_rec.department_id || ' - ' ||
            emp_rec.bonus);
    END LOOP;
    CLOSE emp_cur;
END;
/

-- Inserting a new employee record
DECLARE
    name VARCHAR2(50) := 'Mike';
    salary NUMBER := 5001;
BEGIN
    INSERT INTO employee VALUES(1, name , 'XYZ', 5 , salary , 3 , 5) ;
    INSERT INTO employee VALUES(2, 'john', 'wick', 4 , 4000, 3, 5);
    INSERT INTO employee VALUES(3, 'sofiya', 'vargara', 9 , 2000, 4, 7);
    COMMIT;
END;
/

DECLARE
    dept_id number := 3 ;
    percentage_increase number := 10;
BEGIN
    for emp in (select employee_id, salary from employee where department_id = dept_id ) loop
        update employee set salary = emp.salary*(1 + percentage_increase/100 )
        where employee_id = emp.employee_id ;
    end loop;
    commit;
end;

DECLARE
    bonus_rate number := 0.25 ;
BEGIN
    for emp in (select employee_id , performance_rating , salary from employee) loop
        if emp.performance_rating<=4 then
            update employee set bonus=emp.salary + bonus_rate
            where employee_id = emp.employee_id;
        end if;
    end loop;
    commit;
end;

select * from employee ;
    
BEGIN
    for emp in (select employee_id from employee) loop
        update employee set performance_rating = 4
        where employee_id = emp.employee_id ;
    end loop ;
    commit ;
END;

DECLARE
    emp_id number := 1;
    emp_name varchar2(50) ;
BEGIN
    select first_name || '-' || last_name into emp_name
    from employee
    where employee_id = emp_id ;
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE Name ' || emp_name );
END;


CREATE OR REPLACE PROCEDURE get_employee_name( p_employee_id in number , p_employee_name out varchar2 )
as
BEGIN
    select first_name || ' ' || last_name into p_employee_name
    from employee
    where employee_id = p_employee_id ;
END;

DECLARE 
    emp_id number := 1;
    emp_name varchar2(50);
BEGIN
    get_employee_name( emp_id , emp_name ) ;
    DBMS_OUTPUT.PUT_LINE('Employee Name ' || emp_name );
END;


CREATE OR REPLACE FUNCTION calculate_bonus( p_employee_id in number)
return number
is
    bonus number;
begin
    select salary into bonus
    from employee
    where employee_id = p_employee_id;
    bonus := bonus*0.1;
    return bonus ;
end;

declare
    emp_id number := 1;
    expected_bonus number := 500 ;
    actual_bonus number ;
begin
    actual_bonus  := calculate_bonus(emp_id);
    if actual_bonus = expected_bonus then
        DBMS_OUTPUT.PUT_LINE('unit test passed');
    else
        DBMS_OUTPUT.PUT_LINE('Unit test failed');
    end if;
end;
/

DECLARE
    v_name varchar2(100) ;
BEGIN
    select first_name || ' ' || last_name
    into v_name
    from employee
    where employee_id = 10;
    DBMS_OUTPUT.PUT_LINE('Employee Name : ' || v_name);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee Not FOUND');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error Occured');
END;

DECLARE
    v_grade char(1) := 'A';
BEGIN
    case v_grade
    when 'A' then 
        DBMS_OUTPUT.PUT_LINE('Excellent');
    when 'B' then 
        DBMS_OUTPUT.PUT_LINE('Good');
    when 'C' then 
        DBMS_OUTPUT.PUT_LINE('Average');
    when 'F' then 
        DBMS_OUTPUT.PUT_LINE('Fail');
    else
        DBMS_OUTPUT.PUT_LINE('Invalid Grade !');
    end case;
END;

DECLARE
    v_counter number := 1;
BEGIN
    loop
        exit when v_counter > 5 ;
            DBMS_OUTPUT.PUT_LINE('Counter : ' || v_counter);
            v_counter := v_counter + 1;
    end loop;
END;

CREATE PROCEDURE add_employee( p_first_name VARCHAR2 , p_last_name VARCHAR2 , p_age NUMBER ) AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee added : ' || p_first_name || ' ' || p_last_name || ' ' || p_age);
END add_employee;

BEGIN 
    add_employee('PQR','MNO', 90);
END;

CREATE FUNCTION calculate_age( p_birth_date date) return number as
    v_age number;
BEGIN
    v_age := floor(months_between(sysdate , p_birth_date) / 12 );
    return v_age;
end calculate_age;

declare
    v_birth_date date := to_date('1995-01-01','YYYY-MM-DD');
    v_age number;
begin
    v_age := calculate_age( v_birth_date );
    DBMS_OUTPUT.PUT_LINE('Age : ' || v_age );
end;

CREATE PROCEDURE get_employee_info(
    p_employee_id IN number,
    p_first_name OUT varchar2 ,
    p_last_name OUT varchar2 ,
    p_salary IN OUT number
) as
BEGIN
    
    select first_name , last_name 
    into p_first_name , p_last_name 
    from employee
    where employee_id = p_employee_id ;

    select floor(salary/12)
    into p_salary
    from employee
    where employee_id = p_employee_id ;
END get_employee_info;
/
DECLARE
    v_employee_id number := 1;
    v_first_name varchar2(50) ;
    v_last_name varchar2(50) ;
    v_salary number := 5501 ;
BEGIN
    get_employee_info( v_employee_id , v_first_name , v_last_name , v_salary );
    DBMS_OUTPUT.PUT_LINE('Employee : ' || v_first_name || ' ' || v_last_name );
    DBMS_OUTPUT.PUT_LINE('Salary : ' || v_salary);
END get_employee_info ;

BEGIN
    execute immediate 'Create table accounts( acount_id number primary key ,
        account_name varchar2(100) , balance number(10,2)) ';
        DBMS_OUTPUT.PUT_LINE('Account table created Successfully');
    exception when others then 
        DBMS_OUTPUT.PUT_LINE('Error creating accounts table' || SQLERRM );
END;

Declare 
    ac_no number := 201679900;
    ac_name varchar(50) := 'aarin';
    ac_bal number := 4000.00;
BEGIN
    insert into accounts values (ac_no , ac_name , ac_bal );
END;

select * from accounts; 
