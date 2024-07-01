REM   Script: Activity10
REM   Activity10


select * from orders where salesman_id=(select distinct salesman_id from orders where customer_id=3007);


select * from orders where salesman_id in (select salesman_id from salesman where salesman_city='New York');


select grade, COUNT(*) from customers group by grade having grade>(select AVG(grade) from customers where salesman_city='New York');


select order_no, purchase_amount, order_date, salesman_id from orders where salesman_id in( select salesman_id from salesman where commission=( select MAX(commission) from salesman));