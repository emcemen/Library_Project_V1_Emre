select count(*) from users;

select distinct id  from users;
SELECT * FROM users WHERE 1=0; /* US1 query for verification  */

select count(*) from book_borrow
 where is_returned=0 ; /*  US2 query for verification*/

select name from book_categories; /*  US3 query for verification*/
