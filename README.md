### 투자 API 개발                  

---
#### **Introduce**   
> 개발환경 및 기능 요구사항에 대한 대한 **"핵심 문제 전략 및 분석"** 내용을 작성하였습니다.

#### **1. 개발 환경**     
* 개발 Tool: IntelliJ
* Local PC OS: MAC OS
* Source Repository 관리: git
* JVM: JDK 11
* Spring Boot 2.4.3 (GA)
* ORM: Hibernate
* Database: H2 Database 
* Build: Gradle 6.8.3
* Test: JUnit 5

#### **2. 기능요구사항**    
* API 구현 (전체 투자상품 조회, 투자하기, 나의 투자상품 조회)
* 요청한 사용자 식별자: X-USER-ID (숫자형), HTTP Header 로 유입
* 다수의 서버에서 다수의 인스턴스로 동작
* 단위 테스트 작성       

#### **3. API 설계 및 상세 구현을 위한 핵심 문제 전략 및 분석**    
(1) Domain 설계 전략
* 투자와 투자상품는 다대다 관계 (N : N 구조) 해결 전략: **"1 : N : 1 구조로 변경"**  
    * Invest (투자), InvestProduct (투자상품연관), Product (상품)
* TimeStamp 를 한곳에서 처리: @MapperSuperClass   
* 투자모집상태(모집중, 모집완료)는 Enumerate Type 으로 처리  

(2) API 별 상세 구현   
* 전체 투자 상품 조회 API    
    * 상품 모집 기간내의 상품만을 응답하기 위해 JPQL 중 @Query 어노테이션을 사용하여 처리  
    * 현재 날짜는 ```LocalDateTime.now()``` 사용 

