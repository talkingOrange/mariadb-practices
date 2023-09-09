
-- book
CREATE TABLE `book` (
	`book_no`     INT         NOT NULL, -- book_no
	`title`       VARCHAR(45) NULL,     -- title
	`price`       INT         NULL,     -- price
	`category_no` INT         NOT NULL  -- category_no
);

-- book
ALTER TABLE `book`
	ADD CONSTRAINT `PK_book` -- book 기본키
	PRIMARY KEY (
	`book_no` -- book_no
	);

ALTER TABLE `book`
	MODIFY COLUMN `book_no` INT NOT NULL AUTO_INCREMENT;


-- member
CREATE TABLE `member` (
	`member_no` INT         NOT NULL, -- member_no
	`name`      VARCHAR(45) NULL,     -- name
	`tel`       VARCHAR(45) NULL,     -- tel
	`email`     VARCHAR(45) NULL,     -- email
	`passwd`    VARCHAR(45) NOT NULL  -- passwd
);

-- member
ALTER TABLE `member`
	ADD CONSTRAINT `PK_member` -- member 기본키
	PRIMARY KEY (
	`member_no` -- member_no
	);

ALTER TABLE `member`
	MODIFY COLUMN `member_no` INT NOT NULL AUTO_INCREMENT;

-- category
CREATE TABLE `category` (
	`category_no` INT         NOT NULL, -- category_no
	`name`        VARCHAR(45) NOT NULL  -- name
);

-- category
ALTER TABLE `category`
	ADD CONSTRAINT `PK_category` -- category 기본키
	PRIMARY KEY (
	`category_no` -- category_no
	);

ALTER TABLE `category`
	MODIFY COLUMN `category_no` INT NOT NULL AUTO_INCREMENT;
    
    
-- cart
CREATE TABLE `cart` (
	`count`     INT NULL, -- count
	`member_no` INT NULL, -- member_no
	`book_no`   INT NULL  -- book_no
);

-- order
CREATE TABLE `orders` (
	`order_no`     INT         NOT NULL, -- order_no
	`order_number` VARCHAR(45) NOT NULL, -- order_number
	`order_price`  INT         NULL,     -- order_price
	`address`      VARCHAR(45) NULL,     -- address
	`member_no`    INT         NULL      -- member_no
);

-- order
ALTER TABLE `orders`
	ADD CONSTRAINT `PK_order` -- order 기본키
	PRIMARY KEY (
	`order_no` -- order_no
	);

ALTER TABLE `orders`
	MODIFY COLUMN `order_no` INT NOT NULL AUTO_INCREMENT;

-- order_book
CREATE TABLE `order_book` (
	`order_no` INT NULL, -- order_no
	`book_no`  INT NULL, -- book_no
	`count`    INT NULL  -- count
);

-- book
ALTER TABLE `book`
	ADD CONSTRAINT `FK_category_TO_book` -- category -> book
	FOREIGN KEY (
	`category_no` -- category_no
	)
	REFERENCES `category` ( -- category
	`category_no` -- category_no
	);

-- cart
ALTER TABLE `cart`
	ADD CONSTRAINT `FK_member_TO_cart` -- member -> cart
	FOREIGN KEY (
	`member_no` -- member_no
	)
	REFERENCES `member` ( -- member
	`member_no` -- member_no
	);

-- cart
ALTER TABLE `cart`
	ADD CONSTRAINT `FK_book_TO_cart` -- book -> cart
	FOREIGN KEY (
	`book_no` -- book_no
	)
	REFERENCES `book` ( -- book
	`book_no` -- book_no
	);

-- order
ALTER TABLE `orders`
	ADD CONSTRAINT `FK_member_TO_order` -- member -> order
	FOREIGN KEY (
	`member_no` -- member_no
	)
	REFERENCES `member` ( -- member
	`member_no` -- member_no
	);

-- order_book
ALTER TABLE `order_book`
	ADD CONSTRAINT `FK_order_TO_order_book` -- order -> order_book
	FOREIGN KEY (
	`order_no` -- order_no
	)
	REFERENCES `orders` ( -- order
	`order_no` -- order_no
	);

-- order_book
ALTER TABLE `order_book`
	ADD CONSTRAINT `FK_book_TO_order_book` -- book -> order_book
	FOREIGN KEY (
	`book_no` -- book_no
	)
	REFERENCES `book` ( -- book
	`book_no` -- book_no
	);
    
    
    
    -- book
ALTER TABLE `book`
	DROP FOREIGN KEY `FK_category_TO_book`; -- category -> book

-- cart
ALTER TABLE `cart`
	DROP FOREIGN KEY `FK_member_TO_cart`; -- member -> cart

-- cart
ALTER TABLE `cart`
	DROP FOREIGN KEY `FK_book_TO_cart`; -- book -> cart

-- order
ALTER TABLE `orders`
	DROP FOREIGN KEY `FK_member_TO_order`; -- member -> order

-- order_book
ALTER TABLE `order_book`
	DROP FOREIGN KEY `FK_order_TO_order_book`; -- order -> order_book

-- order_book
ALTER TABLE `order_book`
	DROP FOREIGN KEY `FK_book_TO_order_book`; -- book -> order_book
