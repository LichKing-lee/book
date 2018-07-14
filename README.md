# Document
## 사용기술
- java8, spring boot2, spring-data-jpa, spring-securiy
- 테스트계정
  - id: lcy0202 / pw: 123456

### /book/search [GET]
- kakao api를 이용하여 도서 검색을 합니다.
- 아래 필드들을 queryString으로 받습니다.
- ex) /book/search?query=미움받을 용기

```
private String query;
private Integer page;
private Integer size;
private Integer category;
private SortType sort;
private TargetType target;
```

### /history [GET]
- 검색 history 를 조회합니다.
- page, sort, direction 을 queryString으로 받습니다.
  - page 는 0 부터 시작합니다.
  - sort 는 정렬 컬럼이며 title, insertDatetime 을 받습니다.
  - direction 은 정렬순이며 asc, desc 를 받습니다.
- ex) /history?page=0&sort=title&direction=DESC

### /bookmark [POST]
- bookmark 를 추가합니다.
- 책 타이틀을 Request body 인자로 받습니다.

### /bookmark [DELETE]
- bookmark 를 삭제합니다.
- bookmark id 를 Request body 인자로 받습니다.

### /bookmark [GET]
- bookmark 를 조회합니다.
- page, sort, direction 을 queryString으로 받습니다.
  - page 는 0 부터 시작합니다.
  - sort 는 정렬 컬럼이며 title, insertDatetime 을 받습니다.
  - direction 은 정렬순이며 asc, desc 를 받습니다.
- ex) /bookmark?page=0&sort=insertDatetime&direction=DESC

# Getting Started
- build with test
`./gradlew clean build`

- build without test
`./gradlew clean build -x test`

- start
`java -jar build/libs/kakao-bank-0.0.1-SNAPSHOT.jar`
