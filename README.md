## Android MVC 패턴 템플릿

### MVC 패턴
+ Model : 애플리케이션에서 데이터를 저장하고 처리하는 계층
+ View : 애플리케이션에서 사용자가 직접 보는 화면을 담당하는 계층
+ Controller : 뷰와 모델간의 관계를 설정하는 계층, 로직을 담당

### 흐름
1. 사용자의 Action을 Controller에서 받습니다. (사용자 Action → Controller)
2. Controller에서는 이를 확인하고 Model을 업데이트 수행합니다.(Controller → Model)
3. 수정된 값을 Controller로 반환합니다.(Controller ← Model)
4. Controller에서는 View의 수정합니다.(View ← Controller)
5. 사용자에게 변경된 화면을 반환합니다.(사용자 Action ← View)

### Spec
+ Core-ktx : 1.7.0
+ Retrofit2 : 2.9.0
+ Okhttp : 5.0.0

### 디렉토리 구조

```bash
├─config
├─src
│  ├─home
│  │  └─models
│  └─my
└─util
```

+ config : 프로젝트의 근간이 되는 코드
  + Application
  + BaseActivity
  + BaseFragment
  + BaseResponse
  + Interceptor

+ src : config를 이용해 구현한 코드
  + MainActivity
  + Fragment
  + FragmentInterface
  + RetrofitInterface
  + Service <sub>API통신을 위한 서비스, 4대 컴포넌트 아님</sub>
  + models
    + Response, Request
    + dataclass
+ util : 도구로 사용하는 코드
