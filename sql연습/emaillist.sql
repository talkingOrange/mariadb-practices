CREATE TABLE `emillist` (
	`no`     INT         NOT NULL , -- order_no
	`first_name` VARCHAR(45)  NULL, -- order_number
	`last_name`   VARCHAR(45)   NULL,     -- order_price
	`email`      VARCHAR(45) NULL     -- address 
    );

-- member
ALTER TABLE `emillist`
	ADD CONSTRAINT `PK_emillist` -- member 기본키
	PRIMARY KEY (
	`no` -- no
	);

ALTER TABLE `emillist`
	MODIFY COLUMN `no` INT NOT NULL AUTO_INCREMENT;

insert into emillist values(null, '한', '예원', 'sonrisa-bonit@naver.com');

-- findAll

select no, first_name, last_name, email from emillist order by no;

-- delete

delete from emillist where email='sonrisa-bonita@naver.com');

-- findAll

select no, first_name, last_name, email from emillist order by no;
