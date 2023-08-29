

0. 모든 작업은 dba(root)로 한다.
```sh
# mysql -u root -p
```

1. 데이터베이스 생성
```sh
MariaDB [(none)]> create database webdb;
MariaDB [(none)]> show databases;
```


2. 사용자 생성 (마지막에 비밀번호 설정하는 것임.)
```sh
MariaDB [(none)]> create user 'webdb'@'localhost' identified by 'webdb'; 
MariaDB [(none)]> create user 'webdb'@'192.168.%' identified by 'webdb';
```

3. 권한 주기
```sh
MariaDB [(none)]> grant all privileges on webdb.* to 'webdb'@'localhost'; 
MariaDB [(none)]> flush privileges;
```

4. 확인하기

```sh
# mysql -u webdb -D webdb -p
password: webdb
MariaDB[webdb] 
```


- 마리아 워크벤치에

3307
webdb
