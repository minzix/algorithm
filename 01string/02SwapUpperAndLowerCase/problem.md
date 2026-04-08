### 대소문자 변환
   
**설명**

- 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.


**입력**

- 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
- 문자열은 영어 알파벳으로만 구성되어 있습니다.


**출력**

- 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.


_예시 입력 1_
```json
StuDY
```

_예시 출력 1_
```json
sTUdy
```

**설명**

1. 대소문자 여부
- `Character.isUpperCase(str.charAt(i))` : true이면 대문자, false이면 소문자
- `Character.isLowerCase(str.charAt(i))` : true이면 소문자, false이면 대문자 

2. String
- Java에서는 String이 불변이라서 기존 문자열의 `charAt(i)` 값을 직접 바꿀 수는 없음
- 대신, `result += Character.toLowerCase(ch);` 처럼 `+=` 부호로 새 문자열에 추가하는 방식 추천