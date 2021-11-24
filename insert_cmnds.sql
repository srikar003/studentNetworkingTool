insert into studentRegistration values ('pearson','clear lake'),('mcgraw','katy'),('dolphin','houston');

insert into instructorRegistration values ('tom','boston'),('lulu','denver'),('abcd','miami');

insert into students values ('111','joseph','boston','jb@gmail.com','1995-11-01','pearson'),('222','john','austin','ja@gmail.com','1995=11-08','mcgraw'),('333','mike','dallas','md@gmail.com','1992-09-09','dolphin');

insert into courses values ('10','dbms',0),('11','cpsm',1),('12','rm',0);

insert into studentContact values (1234567,111),(9856473,222),(3628573,333);

insert into events values ('one','code'),('two','test'),('three','develop');

insert into instructors values ('101',5,'kh','ha','kh@gmail.com','1995-11-01','tom'),('102',3,'hi','md','himd@gmail.com','1993-11-01','lulu'),('103',2,'te','fi','tefi@gmail.com','1991-11-01','abcd');

insert into instructorContact values (78392868,101),(18394737,102),(9482736,103);

insert into enrollment values ('111','10'),('222','11'),('333','12');

insert into eventParticipation values ('111','one'),('222','two'),('333','three');

insert into corporateProfessionals values ('101','cg'),('102','ag'),('103','og');

insert into professors values ('101','uhcl'),('102','uhcl'),('103','uhcl');

insert into queries values ('55','abc','111','10'),('66','def','222','11'),('77','ghi','333','12');

insert into queryResponses values ('101','hhh','55'),('102','ccc','66'),('103','iii','77');

insert into queryTags values ('python','55'),('cad','66'),('dbms','77');

insert into payment values (11111,'card',100,0,'111','10'),(22222,'card',200,0,'222','11'),(33333,'card',300,0,'333','12');

insert into cardPayment values ('xxxx',12345,11,25,532,11111),('aaaa',8962849,08,29,410,22222),('bhiaes',7284722,03,24,253,33333);

insert into electronicCheck values ('bhui',12345,'chase','cl',11111),('wscd',8962849,'boa','ho',22222),('lkhn',7284722,'pnc','kt',33333);


select * from studentRegistration;

select * from instructorRegistration;








