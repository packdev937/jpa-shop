### H2 Database를 연결하는 법 

1. h2/bin/h2.sh를 실행하면 H2 Database가 실행된다
2. h2를 연결하기 위해서는 Database 생성을 먼저 해야한다.
   
    ```java
   jdbc:h2:~/jpashop
   ```
3. 해당 명령어를 통해 `jpashop.mv.db` 라는 파일이 생긴다.
4. 이후에는 `application.yml`에 다음과 같은 경로를 설정해야 한다.
   ```java
   spring:
    datasource:
    url: jdbc:h2:tcp://localhost/~/jpashop
    username: sa
    password:
    driver-class-name: org.h2.Driver
   ```
5. 설정이 끝났다면 `./h2.sh` 실행 후 `jdbc:h2:tcp://localhost/~/jpashop` 로 접속한다 