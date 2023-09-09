
# 🧡 [ MYSQL | JDBC ] BOOKMALL 🧡

### 👉 DDL 실행

![image](https://github.com/talkingOrange/mariadb-practices/assets/88815795/d103aa9c-0432-412d-98fb-5c2fbbe0c661)


```sql

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

```


### 👉 ConnectionUtil의 IP주소 수정

```cmd
파일 위치 :  jdbc-practices/src/main/java/bookmall/dao/ConnectionUtil.java
```

```java
 public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                String url = "jdbc:mariadb://[✨✨HERE✨✨]/bookmall?charset=utf8";
                connection = DriverManager.getConnection(url, "bookmall", "bookmall");
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버 로딩 실패:" + e);
            }
        }
        return connection;
    }
```

### 👉 Bookmall.java 실행

```cmd
파일 위치 :  jdbc-practices/src/main/java/bookmall/main/Bookmall.java
```



> 실행 결과

```
##1 회원 리스트
이름:에옹씨, 전화번호:01034781504, 이메일:sonrisa-bonita@naver.com, 비밀번호:1111
이름:은영씨, 전화번호:01024796740, 이메일:rlo0_jjang@naver.com, 비밀번호:2222

##2 카테고리 리스트
카테고리명:철학
카테고리명:기술과학
카테고리명:문학

##3 상품 리스트
도서명:자바가 사람 자바, 가격:36000
도서명:설득의 심리학, 가격:24000
도서명:불편한 편의점, 가격:18000

##4 카트 리스트
도서명:설득의 심리학, 수량:2, 가격:24000
도서명:불편한 편의점, 수량:1, 가격:18000

##5 주문 리스트
주문번호:a123, 주문자:에옹씨/sonrisa-bonita@naver.com, 결제금액:30000, 배송지:경기도 용인시 기흥구

##6 주문도서
도서번호:2, 도서제목:설득의 심리학, 수량:3
도서번호:1, 도서제목:자바가 사람 자바, 수량:2
```
