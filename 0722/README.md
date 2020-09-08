(7/22 수)

file:///C:/Users/anyej/Documents/GIT/PWA/%EC%88%98%EC%97%85%200722/0722.html


## 프레임워크(framework)란?
    

- 빠른 개발을 위해서 자주 사용되는 기능을 api로 만들어 놓은 것.- 
- 살을 붙여서 구체적인 개발 방향을 잡음
ex. SPRING: mvc 패턴으로 개발하도록 한 웹 framework
- request.getparameter 없이 데이터 송수신이 간편
ex2. android: 모바일 앱 개발을 위한 앱 framework (linux os 위에 올라가있는 형태)

  

## 1.  웹 어플리케이션의 구조 | http 프로토콜을 사용하는 경우


### 1. **클라이언트에서 웹 app으로 요청(get 방식 or post 방식)**
두 방식 모두 서버에 요청을 하는 메서드

-   get방식: 클라이언트의 데이터를 URL 뒤에 붙여서 보냄  <br/>

![](https://lh5.googleusercontent.com/iVF2j3FN1-hDW9cmjpULRqutn0-qODlDv9FKguo1kmhBaJlEisMD8izzhKtldJC08THwZ7Calw6PQC7bLV5xbVNSMvqv7H0Rm2lZrgxawtNiUPNn-P2nCbnznYi2GblyWruHHduN)

-   post방식: URL에 직접 붙이지 않고 BODY에 데이터를 넣어서 보냄<br/>

<br/>
    

### 2.  **웹 app에서 클라이언트로 응답 (클라이언트에서 볼 수 있는 형태로 요청한 페이지 제공)**

<br/>
    
### 3.  **클라이언트단 언어와 서버단 언어?**
-   클라이언트단 언어(view단 개발용)
    -  웹 컨테이너 없이 클라이언트가 확인할 수 있게 하는 언어
    - 하지만, back 단과 연동 불가능(db 연동, 클라이언트와 커뮤니케이션..)
    -  예시
       - html(view page의 정적인 text, image, link 단순 조합)
       -  css(html에서 구현해놓은 단순 조합을 좀 더 세련되게 조합
       -   javascript(콜백 함수 처리, if/for문등을 이용해 로직 구축, 클래스 이용, view page내의 동적인 이동을 가능케 함)
-   서버단 언어
     - 클라이언트에서 바로 볼 수 없는 서버단 언어
     - 예시
        -   servlet(controller 역할): 일반 자바지만, http servlet 클래스를 상속받아서 http 프로토콜로 네트워킹을 가능케 함. 웹 기능에 대한 동작을 알고 있는 자바 언어인 셈.
        - http servlet: (request reponse 기능이 가능한 클래스)연결지향의 tcp 프로토콜과 달리 요청에 따른 응답을 보내주고 연결을 끊음
        -   jsp(view단 개발 역할-중간다리 역할): 클라이언트 단 언어는 자바 객체 인식 불가. jsp는 자바에서 만든 멤버 객체를 이해하여 service에서 던져준 코드를 이해하여 html로 view단에 뿌려줄 수 있는 언어.
    
- 클라이언트단에서 볼 수 있게 하려면? 웹 컨테이너를 사용해 번역.
    - 해당 언어들을 컴파일하여 클라이언트단 언어로 변환해주는 웹 컨테이너 필요. ex. 톰캣

<br/>


### 4. **MVC 패턴**
- 소프트웨어 디자인 패턴 중 하나
   - 사용자 인터페이스와 비즈니스 로직을 분리하여 서로 영향 없이 쉽게 고칠 수 있는 어플리케이션을 만들 수 있다.

-   Model(백그라운드 로직을 처리)
    
-   View(사용자가 보게 될 결과 화면을 출력)
    
-   Controller(사용자의 입력처리와 흐름 제어 담당)
    

![](https://lh4.googleusercontent.com/AOAzzbY4zpEkeI4jgwynvPjd62yzMcaKaOrbtb5ujFjMrZ2rpoaQkzTdTt36PIc47JQnPQBdfGrye-q5SOl_TAOsBBaMAGRqeI8fNCcchF7o7qCzvDjDcaJaIg3Xw7KPu7KWef3B)

  

-   웹 브라우저 사용자가 요청을 보냄
    
-   서블릿이 해당 요청을 받아 즉시 view로 보여줄 것인지 model로 보내줄 것인지 정한 뒤 전송
    
-   view: html로 구성된 웹 페이지를 출력
    
-   model: java로 구성된 실질적인 기능 담당
    
    <br/>
    
### 5.  **웹 컨테이너의 역할**
    

-   java 언어: 인터프리터 방식과 컴파일 방식을 모두 가짐
    
-   jsp(java server pages): html 내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹브라우저를 관리하는 언어
ex. 다음: 몇 만명이 동시접속 <br/>
jsp나 서블릿 페이지를 자바로 컴파일하여 메모리 풀에 얹어 놓는다.<br/>  

<br/>

## 2.  웹 프로젝트 내 구조
    

### 1.  java resources => src 패키지
: 확장자가 자바인 파일들이 존재하는 패키지. <br>
ex. model(dto,dao,service), servlet 파일들.. <br>

![](https://lh4.googleusercontent.com/8vl33uktAX19YF_Yf28S2mei86LSYHIXdvq8N-bBkGai0MVsVd5rpQgQ2Yo7L9oeHMJGHTZZuyk8sIlmGq45JLcaEycbZZJteLZMsQZ7jQ8YW5GFojOfA7QvHcfJoEfTrN6915_C)

 <br>
 
### 2.  webContent: view단 파일들이 존재하는 디렉토리
ex. html, css, jsp 파일들... <br>

![](https://lh3.googleusercontent.com/kbz2gGyFbjkXJWQonJ4uz5XcElzvI1JpAADA_9fRp5sPK8NMkwTOdQV1XS7eUppCW1ZmnpaDra6ZM-86-SjTNUTqDmUY4EYqdU7pOMmu3VpzPgt-bpPk-Cy6Cl5RaIjxsqcjV48Y)

-   web-inf
: 웹 어플리케이션을 실행하는데 필요한 클래스 파일 및 설정 파일 등이 저장되는 디렉터리
- web.xml: 웹 컨테이너에게 현재 웹 어플리케이션에 대한 설명을 해주는 파일
- 메이븐 연동 안한 경우에는 web-inf 디렉토리에 넣으면 not found 404
- 메이븐: 버전 관리 tool(버전 맞지 않으면 충돌 多)
- web-inf => lib => 드라이버 저장
- ojdbc6.jar: 데이터 베이스와 연동을 위한 드라이버<br>
![](https://lh5.googleusercontent.com/b33KKDQo3dXKJG_IT58zi6Kb1skIkWwI5wVhuTRe4YtzTkj2-x06KwQtGHO2gqd77GXR9hC11v4jiryo2Ze0GWuJPS-j_jDnFvcmjC1NLfrZgz-RTI9FoPfkT7HXWRnb_clVmxqW)

- 참고 <br/>
![](https://lh3.googleusercontent.com/I1BOauOgDZ8Ls7Swos3Zwi2BtO8IKxE-_86ixXd3bbCo234uE-h3VB2rfzP6mtSlgqzngFbIRtCjaeH7TumFaz_qB946klUO2mOxSFWF29Uf0_DaVcmBZ3mbHccMutQGuwHZv0it)

  
<br>

### 3.  웹 프로젝트 내 경로지정 (중요): URL로 접근
   
-   jsp 파일(루트/상위디렉토리/해당파일명) <br>

![](https://lh4.googleusercontent.com/lfxpAOt0CC3PcgRDNbpmMvVE7N1_PGe2mBCvIUIZOO6TSYE0IO7DH9AUPs99J3STkjzKp01y8GsNmIJTBE8bPgjUdHwFnvZaFi2TVhgRmp_MEU9Qf_URaFllgfyy33jueGkg_F1D)

`ip 주소: port 번호/root 프로젝트명/폴더명/파일명`

-   servlet 파일(루트/해당파일명) *변경가능
annotation: web.xml을 생략하고 대신 정보를 annotation 형태로 넣어줌<br>

![](https://lh3.googleusercontent.com/JlHGvMqtP2GSIsylH8mjWFGKGywLPiAwjc1pCtawN7vsXSBWNgy-hZDevGZiUoj1ZoY53V2idiyiSRz4PBE-hgi8I3HEsXAEd0I9q0uVr1YNLS4Tx1iPXmPUu_UCHQ2P8oiI-0GP)

-   ../=>한 단계 위
- ../../=>두 단계 위
  
<br>

### 4.  html 파일 구성
    

-   <!DOCTYPE html>: 문서 종류(html 문서다.)
    
-   태그(명령어): < 여는 태그 >, </ 닫는 태그 >
    
    - 반드시 쌍으로 된 것은 아님
    - 각 태그 안에 각각 상이한 attribute(속성)이 존재. 갈색
    - 따옴표 유무 상관 없음. 따옴표 종류 상관 없음
    - 하지만 ajax로 dom(document object model)사용하는 경우 서로 다른 따옴표 사용하여 묶어줌. ex. ‘../”img”/img1.jpg’
-   주석: <!-- text →>
   
-   `<head>`와 `<body>`로 구성
     - head: 제목, body: 실제 웹 페이지의 내용
  
-   `<meta charset= 인코딩 정보>`  utf-8, post 방식이 가장 안깨짐
-   \n : `<br>` or `<br/>`
-   글자 크기 조정 + \n : `<h1>` text `</h1>`
-   이미지 띄우기: `<img src=경로 width=n1 height=n2 (단위는 픽셀)>` <br/>


![](https://lh4.googleusercontent.com/Ly9dZm5C60B40uxv6D3hCg5Kbb6D8kaqJON_YTf1yeQSLBDC7snAyZaJHtepzsDzquI8V3rbB6DSFeeH1MSRK32rp1l3pMz42N3X0vcFiviJdCYPJXOGHGpZbCK3pGdPrwkmchUn)

-   링크 걸기: `<a href=link> 링크명 or 이미지 </a>`

![](https://lh4.googleusercontent.com/Ly9dZm5C60B40uxv6D3hCg5Kbb6D8kaqJON_YTf1yeQSLBDC7snAyZaJHtepzsDzquI8V3rbB6DSFeeH1MSRK32rp1l3pMz42N3X0vcFiviJdCYPJXOGHGpZbCK3pGdPrwkmchUn)

![](https://lh6.googleusercontent.com/FqWoRFClxUEf6x7TiIozEhAaNeencWWI6ZJEWrHxbZF54L8it9lPza_J5dri1bMMA9hMjzhe4wrtwHR1xt5l7916zMHaP1JQ_gktemSqpDaXilucipEczVm3geHG5_BKeJZkizo9)

-   테이블 생성
    - 테이블:` <table> `*border = 테두리 두께
    - 행: `<tr>`
    - 열: `<td>`, `<th>` *글자 진하게

<br>

![](https://lh6.googleusercontent.com/Cmuwa3McAfvz5Pnxt6aFfTGSdJaPNNZXEa2fEzOrA3iqpTtMcZtyttZbMHMDz81NAJaIxW9UmFokZLSjjAA9K9IcTpfa2tkLSU2FqAB4SvDXRW6QJ23JrP-IOLvBuixuyazibxTU)
<br>
![](https://lh6.googleusercontent.com/wbiTR54DraWqbQtV0NBUZgIl_7OrrUjtjI35VkAnpcG3kyKXEdvsncDvV1Yu5_nxiqNfn5B1l1PEuq336QAM6Qn9R7vCHWkLYs4manJE7SYW8u_Kgd9Q81OW30EWRB5a63PG_yNh)
  

- 가로칸 합치기: `<td colspan=”num”>`

- 세로칸 합치기: `<td rowspan=”num”>`
<br>
![](https://lh5.googleusercontent.com/XXaKjXS35Dv_TvwPuNj5vqdSX1F-B_vcTEoRII_Gjw85Tte5SNFobBJbxd2V1aDGNmMqeLM9TudU-iQm6GeTzt5N7OC7IMEg57UZ-3XzAshPV1KP4zaJ8DaceIbF7oHEBNMGEgAz)
<br>
![](https://lh5.googleusercontent.com/TZHUuVEnUTsMwACHarNSGtnn-dZvMBV2BQNhTPXDvdkS5gk4sK4j_Jw4YIBo4_WMbcz7ETqM2YpRPnmawqIpzWswmX2y6kARldzmhoOPJoQ-1iWzBgVXWRsD2hQq5dALHR4L6Ssb)
<br>

#### 연습문제 : naver 기사 format 만들기

![](https://lh5.googleusercontent.com/yZrh_fqA69dVY5-7YSO_Ktwne_4odhpt2nm0y-uDH8mZdXt0bRW5bMW-hRFH4MkPW-jPksDjUFPoE4JYwkehr9DBHXVROna1d_WqFhW7OM0q2_52dLkgC3hDyWFxThqrPHc6FdJu)
<br>

![](https://lh5.googleusercontent.com/AsygxL5mSufkmk_j8wZvNjo8JTbpchJAkd72JPjCNgK7nf3jsk7yx3_aAbJZ1Vqtkw7-T3YIKwxWomFkhLqgDZlon8XnvVOMIhdjJa3Azxwd_8cb9xfLUxfxw-vdWnvohv1m1st2)

<br>

-   다른 프레임 추가: iframe
ex. 약관내용 등… 너무 길 때
`<iframe src=파일경로 width=n1 height=n2></iframe>`

-   단락 구분: 이후에 출력으로 쓸 영역을 미리 잡아두기.. ex. 아이디 유무.
     - p 아래 위 한줄씩 벌려줌
     - div: 사이에 엔터를 넣어줌
     - span: 영역을 만들어줌 <br>
![](https://lh4.googleusercontent.com/q2_AGrrWRa8KvWblnuIjZppCjvbGdQyzJ3T48lDN9rKid5UdH_WZVkD12PQnLVT7xgUW7bfluk_mfxVoT14eim_yjWe72p1ca17SlOAtQmR8QKsngpB0xdsDJKuyCnrh0t0Z726n)
<br>
![](https://lh5.googleusercontent.com/VzrmX6HkQHR3uECtTkm47h_8ITtSorTAEcUfx7CB3jxyGE_wc-80FxJKO7rQjQzr00v5QdK7bpyPipI0UN_jyf3--aeCOBMMZhsYPrGTJRKs5I2Rk2PwgEZFoJxt5VgmvmwSiJvt)

 

### 5.  html form 양식(중요): 기능 구현하기 위해 클라이언트로 부터 데이터를 받는 방식
    
![](https://lh6.googleusercontent.com/vTle1O0ohT6oYC7B4XTbWhOwwUWCL4WsH4AeitddOVpQ5luJOZ_XYFXODiiR7aIr_1MmzjGIy_Q8Bo6cnMpqW2etCQa1C7WbCHp707tu6yAQL1zZy5d9YdyTs-GCiEp93GSrsvvm)

<br>

-   `<form action="서버페이지" method ="전송방식"></form>`
-   서버페이지가 받아서 처리하겠다.
-   전송방식(get, post)
    -   get:URL뒤에 붙어서 가기 때문에 데이터 길이에 제한이 있고 보안상 안 좋음
    -   post:패킷 헤더에 담아서 보내기 때문에 데이터 길이에 제한이 없고 보안상 좋음. 한글 덜 깨짐
-   태그 형태
ex. form(전송방식), input(), select(단일 선택), textarea(장문 입력)
-   type: 해당 태그 내에 입력 형태
      -  예시
			  -   text(단문 입력),
			  -  checkbox(다중 선택), 
			  -  radio(단일 선택), 
			  -  button(버튼), 
			  -  submit(전송-전체 폼 데이터가 action에 지정한 서버 페이지로 전송됨),    
			  -  reset(초기화), 
			  - hidden(클라이언트 화면에는 안보이지만 서버(서블릿)에 값을 보내줘야 하는 경우)
-   name: 서버페이지에서 받아갈 때 어떤 값인지 인식하기 위한 이름
-   value: 실제 서버에 전달되는 값
    
    
#### <출력 결과>
<br>

![](https://lh3.googleusercontent.com/LIghHVb1CCAEsStU4tdAxI-dhfL9kViQfHEj9JMPw4XYspNQFwV7pJ8JjGTFhOT08Lahp5NFw3g4CutF8dkn7vkG8ErFlOOKha1N9ar4yP1sNd3K5y5-DGp_Jtf7nXHInofb7K3l)

  
<br>

### 6.  jsp
    
 - html로부터 받아온 폼데이터들을 수신(원래 해당 역할은 서블릿이 수행함.)
-   현재 페이지 기본 설명
`<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>`
-   자바 코드 삽입: `<% %>`(스크립트릿)
-   출력: 1)%=, 2)out.print()
- out이라는 이름의 PrintWriter 객체를 사용하여 응답으로 보낼 웹페이지에 일정 내용을 추가
(servlet 참고) <br>

![](https://lh5.googleusercontent.com/wdIlCQjqUK9sqtUAXQR20QiPA_39zP8ylflaUC_wu7okPpP0eesLofPnWqrcthhXCpqvt9aTMFrk6pKOi2YpifEygduYlVa0Cj92pDoz5FhS-lUNa-tRiwvGRStWTaznY7wt1Kg9)

-   request와 response
   -   request + 폼데이터: 폼데이터와 함께 일정 기능을 요청 
   -   response + html: 출력할 웹페이지 전송
    
    <br>
    
### 7.  CSS
-   특징
    -   style: 속성이름
    -  콜론: 값 할당
    -  세미콜론: 복수의 속성 나열
     -   pt: 포인트
     -   px: 픽셀
     -   color: 글자 색
     -   background: 배경
    
-   예시: p 태그에 css 문법 적용 <br>

![](https://lh4.googleusercontent.com/okVS6qsTta6PrnQRbVdlofGiU_89FjuegJLid85emnFnNK78ZSfvVXTJaRLcCzmuUu5bk1RaAIzSXZ4Rewstz38ISYpyqIMCfb0SsGQHgXYKP0PIwYHTW5lT-hGmcXhe7CZ9NM2O)![](https://lh3.googleusercontent.com/OnkuJrZqEu4U1o1rN_645PrmiTdSaoHaZUBQZRcI-PmD7BWc7hHH-ytcXgcy_Yi1cTlVY3jZw7FeEH690XcXF2T30G845JJIc8LWPByCbwe6ELnZlzldAIR384Nr0K4wNl53TC_x)

  <br>

-   예시2: 페이지 전체의 p태그에 css 문법 적용 *재정의한 p 태그는 새로 정의한 속성으로 출력  <br>    

![](https://lh3.googleusercontent.com/62cMDety7OoHoKKAAJkl6reM1OECDYO1U_VgFSsmQ4GeFGeJ_FTaC0u7eCmZ_YHdO18uSfPXBsPaHKgCSgiLMjZsGh-T9KhNLmd1Y--hOUorQh0nALEb_4iYwopUfxq1M7WKboLM)![](https://lh5.googleusercontent.com/Sx0_2M_FT1w1mcS6rmyeAtNhy9M-xE2mzu0oNVqus5BxJiSWRqTb3d_Sb3cgSyS-A0o5vw9dLBHJmjs7_O0_CpHJuYvsXZlaAJ3XuqT6veb1QWKajKueoum0rqPnb94lmp0Sxugj)
  <br>

-   예시3: class - 일정 그룹에 적용할 때, id - 단일 태그에 적용할 때      <br>

![](https://lh6.googleusercontent.com/N27ussawb_heKjSnOH70sHu5c-sP_G_m6E16Y5LfORbQ7ucWNaS_thdYD7x7G9Mtf3uBH7Rd7KoboXThPBFnPwNg5Xw2skwgfPeuGmqkHI642IbvhevvK_JXyUNHl_4L0AKsanyp)

![](https://lh6.googleusercontent.com/RCZf4Fvg5LYihGj7Y4DL4leE4_idn-CC9YaV1UT2m04N7OqDj0NIRYeKka8XI7DEffEM9QoT3YgtYqIA9WCNnLlpBlEX2V1CnT-XVLovjtNm_t8Y_X19g8FwBwXsNhKpU9g4c8xy)![](https://lh6.googleusercontent.com/8WRZDoqO3b7rnz-9vEPm9VFAWgkU3HAKW0njcSkC5-x0EkqE4VLpT0fgvgKtsiAImDp2aKdgSlglJMp1MwdFNvFbWyWGgkKGgyLuVyLatkYLEphhdVBzASFJwRk_B55Sn0WkBf94)

  <br>

-   예시4: 배경이미지 지정  <br>

default: 바둑판 모양으로 반복, repeat-x: x축으로만 반복, repeat-y: y축으로만 반복, no-repeat: 반복 없음  <br>


![](https://lh4.googleusercontent.com/PZdctvH8y16gvutfrYk2EVA1-wS1gjU5WOjDV8_Jdu5Jp_eb4WoCyX3jZ0pH09VIz04zfMTpAODMBE8iG257HCZquhtZvbI1pL42WRy4aPVBFS8ZrrwPVWnvq19dOyJDrg0CvrlN)

  <br>

-   예시5: 위치 제어 position    
     - absolute(위치 고정)
      - relative(바로 앞 요소의 왼쪽 상단 꼭지점을 기준으로 이동)

![](https://lh3.googleusercontent.com/1DXE4FJQmoCZ5BcorhS8J4k2_l6AUsSvcrnOYi1T_Y6jDHkTATy3ZuVBmKwK_WbqI54RsmeF_X8qZa6lzk8Vr1pCUzYxs3dYjFlIEO4XTEkEkNkgVvG24BHP96GSvaikPsCfPH4b)

![](https://lh5.googleusercontent.com/nNHcWaqeojN348G7MQ__S3nyMevDxXXPXhxV5s-WZs4OqLW5HNmj6jgF9qKFCsbhWPwlXRrA7cj9owEcA0mOtLc1hi24t379Q6CoC8yEx6RlSA3cX8f3BoxT-rbDf4A4LWMqjGCD)

![](https://lh4.googleusercontent.com/t5KnP3eFHy-o6tkh2QWznDRZuUrsw1MTeiP941dtG_xyqdSh4TcJ29wXCrDSgIoPL-wBqfku8Q1OpOsbbSlTYb4rEKMPARVVTCEfRjCwnEh4noBLATTZFhMQFZIvrlFhIf4V_UTB)

-   css 파일로 따로 저장 가능.
    

### 8.  javascript | 동적 텍스트/이미지 사용, 이벤트 핸들링

-   특징
    -   세미콜론 생략 가능
    -   `<script> text~~ </script>` 태그 안에 작성
    -   document: 자바스크립트 내장 객체. 웹페이지에 출력 담당
     -   var: 변수 선언. 하지만 변수 선언없이도 사용 가능하다.
     -   prompt: 입력박스 창
     -   alert: 알림 창
 <br>
    
![](https://lh5.googleusercontent.com/E7K7Dv5koPPcl4_VQWW2MCK3dwZLFnlh7KQztv45wQVtHSa3Qj1a8IwRI-jInYYrqEF4TKkFMiUGe1zZ_zQ3lNRrWycUaYtQEe800MbaS4GVWXcZyeWE6fFPFk5i-AxDqzm4YiZ5)

![](https://lh4.googleusercontent.com/RTixHq1mBAtFmq8sOXbZCfROApYtcDSgv0sBHiC7maG1UJiG-zHAFAFCfFFnuMtomoPTTOOaSl6BEewjl3bTVVfNZmzm3aUQtVeVzJuK6wrdX9CTYgRzKmSFPnKsrEFbx4jFStqU)

-   for문 if문   <br>    

![](https://lh4.googleusercontent.com/Ttxx9pp2-SbSVH82k4cPiqTsknlF53fjmbCnsv-qGzyG8_Jmd_ykHDcniJ9sg-9N2hpYlM-tVa-uZURX73TdPc320NFt-21Qmg_TbpkpCVP5Tk9EgNUkvCCCXPH28Yd50X41TXGT)

![](https://lh4.googleusercontent.com/HQH-br-6uXd7gLf7s_vpqRoi0-0-Tk-ZDYtc89VjdCvtuJh84W5V5zYbp5NZGV5TgawL17akDu2qH9ikmCH88mU6CCebW-99dgXyIosw1gGTrTC1UWaDr0D5TopoJtnGZOzQ4t4G)

  <br>

-   java script 연습문제: 구구단 => 한 칸 다 채우고 다음 칸
    

![](https://lh4.googleusercontent.com/mmlMuOw_fjGoy7SQXMZGkwTWEWvTfG2pkOQB-ga3Y9mB4WYF07l2Fw-2Igd_RRNLyIG85Lv8Z2DnTq5ARA2TqbcWmVd6feKDNFdgBHzi6-YJdJB7h9gZLbdepAaXtAcrNjNlk9Qi)

![](https://lh6.googleusercontent.com/wgyikZuIJ_GMJF8qAgIoOC_JC5FT4c36IVH9vV1EEOmSuyzixVpTBBpTeaTyvGb8Wh_ceA4PVJC_b1h26Fz2TJhdEpgUUAZwM7jq2gWlWmcB94B-C4H6R-BEcJxB1KmnfbgvI8dA)

<br>

#### 숙제: 계산기 UI 만들어오기

![](https://lh5.googleusercontent.com/WoqmCoHOykIWTZdygCn0x7xgdpqiKmfZx4LvcziukByRzuIz9YbsWbbm6kiRewvROQKVwjftfsyGwz94JR2DZKKx0dOgSJ5m061L18e1NvzXswZe5ZrGr-NekfUjcjVylzexl6V4)![](https://lh3.googleusercontent.com/iZ4e-ZHpynyEIPQwmP7eJjUDoeCD6i7lF9kx4lI6kPStIlU8Nf1R-hNL7SJIldqCtek2htfZP8sUIfmZjVY9d_cOG09W7NRVy2gxydUUH5d5swVmjzHLoGZjMj0xR2PDzS6Gtty3)
