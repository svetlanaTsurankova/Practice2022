/*Task 1 */
SELECT model,speed, hd FROM test.pc where price <500;

/*Task 2 */
SELECT maker from test.product where type='printer';

/*Task 3 */
SELECT model,hd,screen FROM test.laptop where price>1000 ;

/*Task 4 */
SELECT * from test.printer where color='y';

/*Task 5 */
SELECT model,speed,hd FROM test.pc where cd in ('12x','24x') and price<600;

/*Task 6 */
SELECT product.maker,laptop.speed  FROM test.laptop
inner join test.product on(laptop.model=product.model) 
where hd>=1000;

/*Task 7 */
SELECT product.model, laptop.price, pc.price, printer.price  FROM test.product 
left join  test.laptop on (laptop.model=product.model)
left join  test.pc  on (pc.model=product.model)
left join  test.printer   on (printer.model=product.model)
where product.maker like '%b%';

/*Task 8 */
select maker from test.product where type='PC' and maker not in   
(select maker from test.product where type = 'laptop') group by maker;

/*Task 9 */
SELECT product.maker FROM test.pc 
inner join test.product on (pc.model = product.model)
where pc.speed >=450;

/*Task 10 */
SELECT model, max(price) FROM test.printer;

/*Task 11 */
SELECT avg(speed) FROM test.pc;

/*Task 12 */
SELECT avg(speed) FROM test.laptop where price>1000;

/*Task 13 */
SELECT avg(speed) FROM test.pc
inner join test.product on (pc.model = product.model and product.maker like '%a%');

/*Task 14 */
SELECT speed,avg(price) from test.pc group by speed;

/*Task 15 */
SELECT hd  from test.pc  group by hd having  count(hd)>=2;

/*Task 16 */
SELECT DISTINCT B.model, A.model, A.speed, A.ram 
FROM test.pc AS A, test.pc AS B 
WHERE A.speed = B.speed AND A.ram = B.ram and A.model < B.model;

/*Task 17 */
SELECT distinct product.type,laptop.model,laptop.speed from test.laptop 
inner join test.product on laptop.model= product.model  
where laptop.speed < (select MIN(pc.speed) from test.pc);

/*Task 18 */
SELECT DISTINCT maker,price  FROM test.printer inner JOIN test.product ON printer.model= product.model  
WHERE price = (select min(price)from test.printer where color = 'y' ) and color = 'y';

/*Task 19 */
SELECT maker ,avg(screen) from test.laptop 
inner join test.product on laptop.model =  product.model group by maker; 

/*Task 20 */
SELECT maker , count(model) from test.product where type = 'PC' group by maker 
having count(model) >= 3;

/*Task 21 */
SELECT maker , max(price) from test.pc 
inner join test.product on pc.model= product.model group by maker ;

/*Task 22 */
SELECT speed , avg(price) FROM test.pc  WHERE speed > 600 group by speed ;

/*Task 23 */
SELECT distinct maker from test.pc 
inner join test.product on pc.model = product.model  
where pc.speed >= 750 and maker in (select maker from test.laptop 
inner join test.product on laptop.model = product.model where laptop.speed >= 750);

/*Task 24 */
SELECT model FROM( 
SELECT distinct model, price FROM test.laptop WHERE laptop.price = (SELECT MAX(price) FROM test.laptop)  
UNION SELECT distinct model, price FROM test.pc WHERE pc.price = (SELECT MAX(price) FROM test.pc)  
UNION SELECT distinct model, price FROM test.printer WHERE printer.price = (SELECT MAX(price) FROM test.printer)  
) as model WHERE 
model.price=(SELECT MAX(price) FROM ( 
SELECT distinct price FROM test.laptop WHERE laptop.price = (SELECT MAX(price) FROM test.laptop)  
UNION SELECT distinct price FROM test.pc WHERE pc.price = (SELECT MAX(price) FROM test.pc)  
UNION SELECT distinct price FROM test.printer WHERE printer.price = (SELECT MAX(price) FROM test.printer)  
) as maxprice );

/*Task 25 */
SELECT DISTINCT maker FROM test.product WHERE model 
IN (SELECT model FROM test.pc WHERE ram = (SELECT MIN(ram) FROM test.pc)
AND speed = (SELECT MAX(speed) FROM test.pc  WHERE ram = (SELECT MIN(ram) FROM test.pc ))
)
AND maker IN (SELECT maker FROM test.product WHERE type='printer');