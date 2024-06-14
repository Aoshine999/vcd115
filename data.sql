create database vcd;


create table VCD
(
    Vno char(10) not null primary key ,
    Vname varchar(30) not null ,
    Author varchar(30) null ,
    Price decimal(10,2) null ,
    VType char(10) null ,
    amount int not null check ( amount >= 0 )
);

create table Client
(
    Cno char(10) not null primary key ,
    Cname varchar(30) not null ,
    Cph varchar(20) not null
);

create table Hire
(
    Vno char(10) not null ,
    Cno char(10) not null ,
    Hprice decimal null ,
    Hamount int not null check ( Hamount > 0 ),
    Htime date not null ,
    Rtime date null ,
    Hstatus ENUM('borrowed','returned') not null ,
    primary key (Vno,Cno),
    foreign key (Vno) references VCD(Vno),
    foreign key (Cno) references Client(Cno)
);

create table Sell
(
    Vno char(10) not null ,
    Cno char(10) not null ,
    Stime date not null ,
    Samount int not null ,
    primary key (Vno,Cno),
    foreign key (Vno) references VCD(Vno),
    foreign key (Cno) references Client(Cno)
);

create table Stock
(
    Vno char(10) not null ,
    Samount int not null ,
    Stime date not null ,
    primary key (Vno,Samount),
    foreign key (Vno) references VCD(Vno)
);

INSERT INTO VCD (Vno, Vname, Author, Price, VType, amount)
VALUES
    ('V001', 'The Shawshank Redemption', 'Frank Darabont', 9.99, 'Movie', 100),
    ('V002', 'Breaking Bad', 'Vince Gilligan', 29.99, 'TV Series', 50),
    ('V003', 'The Godfather', 'Francis Ford Coppola', 14.99, 'Movie', 75),
    ('V004', 'Game of Thrones', 'David Benioff, D. B. Weiss', 39.99, 'TV Series', 30),
    ('V005', 'Pulp Fiction', 'Quentin Tarantino', 12.99, 'Movie', 60);

INSERT INTO VCD (Vno, Vname, Author, Price, VType, amount)
VALUES ('V005', 'Pulp Fiction', 'Quentin Tarantino', 12.99, 'Movie', 60);

DELETE FROM VCD WHERE Vno = 'V006' or Vno = 'V007' or Vno = 'V008';

create trigger update_vcd_amount
    after insert on Stock
    for each row
begin
    update VCD set amount = NEW.Samount + VCD.amount where Vno = NEW.Vno;
end;

insert into Stock(Vno, Samount, Stime) VALUES ('V004',20,'2024-5-19');

insert into Stock(Vno, Samount, Stime) VALUES ('V004',21,'2024-5-20');

create trigger update_vcd_amount
    after insert on Stock
    for each row
begin
    update VCD set amount = NEW.Samount + VCD.amount where Vno = NEW.Vno;
end;


DELIMITER $$
CREATE TRIGGER hire_update_vcd_amount
    AFTER UPDATE ON hire
    FOR EACH ROW
BEGIN
    DECLARE vcd_amount INT;

    -- 根据 Hire 表中的 Vno 获取 Vcd 表中对应的 amount
    SELECT amount INTO vcd_amount FROM vcd WHERE Vno = NEW.Vno;

    -- 根据 Hire 表中的 Hstatus 更新 Vcd 表中的 amount
    IF NEW.Hstatus != OLD.Hstatus THEN
        IF NEW.Hstatus = 'borrowed' THEN
            SET vcd_amount = vcd_amount - NEW.Hamount;
        ELSEIF NEW.Hstatus = 'returned' THEN
            SET vcd_amount = vcd_amount + NEW.Hamount;
        END IF;
    END IF;

    -- 更新 Vcd 表中的 amount
    UPDATE vcd SET amount = vcd_amount WHERE Vno = NEW.Vno;
END
$$
DELIMITER ;

create trigger hire_insert_alter_vcd_amount
    after insert on hire
    for each row
begin
    declare vcd_amount int;

    -- 根据 Hire 表中的 Vno 获取 Vcd 表中对应的 amount
    select amount into vcd_amount from vcd where Vno = NEW.Vno;

    if NEW.Hstatus = 'borrowed' then
        set vcd_amount = vcd_amount - NEW.Hamount;
    end if;

    -- 更新 Vcd 表中的 amount
    UPDATE vcd SET amount = vcd_amount WHERE Vno = NEW.Vno;
end;


DROP TRIGGER IF EXISTS hire_update_vcd_amount;


insert into Client(Cno, Cname, Cph)
VALUES ('C001','丁真','100-100-100'),
       ('C002','科比','100-100-101'),
       ('C003','孙笑川','100-100-102');


insert into Hire(Vno, Cno, Hprice, Hamount, Htime, Rtime, Hstatus)
VALUES ('V001','C001',3.00,10,'2024-5-20','2024-5-24','borrowed');

update Hire set Hstatus = 'returned' where Vno = 'V001' and Cno = 'C001';


