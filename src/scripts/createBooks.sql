INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-3');
SET @book1 = LAST_INSERT_ID();
INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-4');
SET @book2 = LAST_INSERT_ID();


INSERT INTO CUSTOMER VALUES(null,"Lars", "Mortensen");
INSERT INTO CUSTOMER VALUES(null,"Thomas", "Hartmann");
INSERT INTO CUSTOMER VALUES(null,"Sofus", "Altbertsen");
