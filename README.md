### 투자 API 개발                  

---
#### **Introduce**   
> 개발환경 및 기능 요구사항에 대한 대한 **"핵심 문제 전략 및 분석"** 내용을 작성하였습니다.
---
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
---
#### **2. 기능요구사항**    
* API 구현 (전체 투자상품 조회, 투자하기, 나의 투자상품 조회)
* 요청한 사용자 식별자: X-USER-ID (숫자형), HTTP Header 로 유입
* 다수의 서버에서 다수의 인스턴스로 동작
* 단위 테스트 작성   
---
#### **3. API 설계서**
* 전체투자상품조회
  * GET ```/api/v1/products```
  * Request     
  * Response
      ```json 
        [
            {
                "productId": 1,
                "title": "빌라",
                "totalInvestingAmount": 10000,
                "currentInvestingAmount": 0,
                "investorCount": 0,
                "recruitCode": "모집중",
                "productPeriod": 30,
                "startedAt": "2021-03-13T22:41:08.682544",
                "finishedAt": "2021-03-15T22:41:08.682544"
            }
        ]
      ```
* 투자하기
   * POST ```/api/v1/invest```    
   * Request (Header: ```X-USER-ID: 7777```)
     ```json
        {
           "investingAmount": 10,
           "productId": 2
        }
     ```     
   * Response (정상응답)
     ```json
        {
           "investId": 2
        }
     ``` 
   * Response (Sold-Out 발생한 경우 비즈니스 예외 응답)
      ```json
        {
           "timeStamp": "2021-03-13T23:04:00.2676234",
           "message": "com.invest.server.exception.biz.NotEnoughProductException: SOLD OUT",
           "code": "SOO1",
           "status": 200
        }
      ```
* 나의 투자상품 조회
  * GET ```/api/v1/invest/{userID}```
  * Request
  * Response
    ```json
      [
          {
              "productId": 1,
              "title": "빌라",
              "totalInvestingAmount": 10000,
              "investingAmount": 10,
              "createdAt": "2021-03-13T22:52:05.243577"
          }
      ]
    ```
---

#### **4. API 설계 및 상세 구현을 위한 핵심 문제 전략 및 분석**    
(1) Domain 설계 전략
* 투자와 투자상품는 다대다 관계 (N : N 구조) 해결 전략: **"1 : N : 1 구조로 변경"**  
    * Invest (투자), InvestProduct (투자상품연관), Product (상품)
* TimeStamp 를 한곳에서 처리: @MapperSuperClass   
* 투자모집상태(모집중, 모집완료)는 Enumerate Type 으로 처리  

(2) API 별 상세 구현   
* 전체 투자 상품 조회 API    
    * 상품 모집 기간내의 상품만을 응답하기 위해 JPQL 중 @Query 어노테이션을 사용하여 처리  
    * 현재 날짜는 ```LocalDateTime.now()``` 사용 
* 투자하기 API  
    * 투자하기 이후 상품정보의 변경이 필요 (누적 투자모집 금액, 투자자 수)
    * 투자 이후 총투자금액이 상품의 총모집금액과 같은 경우 상품 정보 변경 (모집상태변경)
    * 총모집금액을 달성한 상품에 투자할 경우 "Sold-Out" 응답
    * **연관관계설정**을 통해 투자 도메인과 상품 도메인 설정
      * 투자 도메인의 변경 감지를 통해 상품 도메인의 변경 적용     
        (누적모집금액, 투자자수, 모집상태)
      * 총모집금액을 달성한 상품에 대해 투자하는 경우 "SOLD-OUT" 비즈니스 예외 처리
    * 비즈니스 예외는 공통으로 한 곳에서 처리하도록 처리  
      Code: SOO1, Message: SOLD OUT    
      Code: S002, Message: NOT FOUND   
* 나의 투자상품 조회 API  
    * 제공되어야 하는 필드(상품아이디, 상품제목, 총 모집금액, 나의 투자금액, 투자일시)가        
      다른 도메인(테이블)에 존재하여 Join 을 통해 해결    
    * Join 은 JPQL Native Query 를 적용      
---
#### 5. 성능 고려 방안   
* ```Open-Session-In-View: false```  
   * Spring Boot 내에서 OSIV 의 Default 설정인 ```true``` 를 ```false``` 변경
   * 커넥션 자원을 트랜젝션 범위에서만 사용하여 자원 최적화
      * 지연로딩 처리를 트랜젝션 범위 내에서만 처리하도록 구조화    
---

