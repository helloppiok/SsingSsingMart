![header](https://capsule-render.vercel.app/api?type=Cylinder&color=6B9F38&height=150&section=header&text=🥑씽씽마트🥑%20&fontSize=90&fontColor=FFFFFF&fontAlignY=57&animation=twinkling)

![main](https://user-images.githubusercontent.com/95897233/153393179-d993df18-89ee-44a2-aa7c-22c7c29e0b4e.JPG)


<h6>ㅤ  
 
---

<h3>🌿 1. 프로젝트 개요</h3>

``` 
 증가하는 온라인 상거래 및 쇼핑 거래액은 코로나 발병 이후로 더 큰 증가 추세를 보이고 있습니다. 
 그에 반해 오프라인 지출은 감소하고 있는데, 이러한 추세에 따라 온라인으로 더 쉽고 편리하게 상품의 
 관리 및 구매를 하는 것에 중점을 두었습니다. 
 ```

<h6>ㅤ
<div align="center">▫&nbsp;&nbsp;&nbsp;▫&nbsp;&nbsp;&nbsp;▫</div>  
<h3>🌿 2. 개발환경</h3>  

- 프로젝트 기간 : 2021.10.21 - 2021.11.05  
- 개발 플랫폼 &nbsp;&nbsp;&nbsp;&nbsp;: Windows 10  
- 개발 툴 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: Eclipse IDE
- 사용 언어 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: JAVA
---
<h3>🍴 3. 담당 기능 구현</h3>

```
1. 로그인
▪ 로그인 성공시 안내멘트가 출력  
▪ 로그인 실패시 재입력을 받고 안내멘트가 출력  
▪ 로그인 실패 원인에 대해 각각 다른 안내멘트를 출력  
▪ 관리자 계정과 회원 계정을 구분하고 각각 다른안내멘트를 출력  
▪ 초기화면으로 돌아가기  
▪ 회원정보를 저장하는 파일을 확인
```
```
2. 회원가입
▪ 회원가입을 통해 고객의 정보를 저장  
▪ 아이디, 비밀번호, 이름, 나이, 전화번호 설정에 길이 및 문자 유효성 검사  
▪ 주소, 베지테리언 단계 유효성 검사  
▪ 전화번호 입력시 '-' 유무 관련없이 데이터 입력 가능  
▪ 중복아이디는 설정 불가  
▪ 제약사항에 위배되는 경우 경고멘트와 함께 재입력  
▪ 사용자를 위한 멈추기 기능
```
<div align="center">▫&nbsp;&nbsp;&nbsp;▫&nbsp;&nbsp;&nbsp;▫</div>  
<h4>1. 로그인</h4>

<h5>1-1. 로그인 성공</h5>

![login](https://user-images.githubusercontent.com/95897233/153420419-36066d5f-2a99-4e11-a299-00b435c2b979.png)
```
로그인 성공시 안내멘트가 나오고, 관리자와 회원을 구분하여 멘트가 다르게 출력됩니다.
아이디와 비밀번호 자리에 0을 입력하면 초기화면으로 돌아갑니다.
```  
<h6>ㅤ

<h5>1-2. 로그인 실패</h5>
 
 ![loginacces](https://user-images.githubusercontent.com/95897233/153419155-93fad3bd-9269-4217-9008-38cff0300250.png)
```
로그인 실패시 실패 원인에 대한 안내 메시지가 출력되고 재입력을 받습니다.
```

<h6>ㅤ
<div align="center">▫&nbsp;&nbsp;&nbsp;▫&nbsp;&nbsp;&nbsp;▫</div>  
<h6>ㅤ

<h4>2. 회원가입</h4>
<h5>2-1. 회원가입 성공</h5>

 ![idnew](https://user-images.githubusercontent.com/95897233/153424342-807eb624-28a1-4793-8f80-c3471d5a88b2.png)
```
올바른 정보를 입력하면 회원가입이 완료되고 해당 데이터가 저장됩니다. 
가입 후 입력한 정보로 로그인을 할 수 있습니다. 
```  
<h6>ㅤ

<h5>2-2. 회원가입 실패</h5>

![loginerror](https://user-images.githubusercontent.com/95897233/153431596-77a859bb-9f59-4bf7-ade2-f315abf60a4f.png)
```
회원가입 유효성 검사입니다. 대표적인 유효성 검사들을 보여드리며 이외에도 다른 유효성 검사들이 있습니다.
중복검사, 길이, 문자열 검사 등이 있으며 모든 입력 정보에 대한 유효성 검사를 할 수 있고 잘못입력시 
재입력을 받고 안내멘트를 출력합니다.
```
<h6>ㅤ
<h6>ㅤ

--- 
<h3>🌿 4. </h3>  
 
