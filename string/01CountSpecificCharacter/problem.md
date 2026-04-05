### 문자 찾기
   
**설명**

- 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
- 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.


**입력**

- 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
- 문자열은 영어 알파벳으로만 구성되어 있습니다.


**출력**

- 첫 줄에 해당 문자의 개수를 출력한다.


_예시 입력 1_

```json
Computercooler
c
```

_예시 출력 1_
```json
2
```

**설명**

1. 입력 받는 방식
- `Scanner input = new Scanner(System.in);`
  - `input.next()`: 다음 공백 전까지만 저장
  - `input.nextLine()`: 입력받은 한 줄 전체 저장

2. 기본 자료형 _(Java에서 정해둔 아주 기본 타입)_ vs 클래스 타입 자료형

- 기본 자료형: `char`, `int`, `double`, `boolean`, `long` → 소문자
- 클래스 타입 자료형: `String`, `Scanner`, `Integer`, ...

| 구분            | 기본형(Primitive Type)                | 클래스 자료형(Wrapper/Class Type)                           |
|---------------| ---------------------------------- | ----------------------------------------------------- |
| 의미            | 값을 직접 저장하는 자료형                     | 값을 감싼 객체 형태의 자료형                                      |
| 예시            | `int`, `char`, `double`, `boolean` | `Integer`, `Character`, `Double`, `Boolean`, `String` |
| 저장 방식         | 값 자체 저장                            | 객체로 저장                                                |
| `null` 저장     | 불가능                                | 가능                                                    |
| method 사용     | 불가능                                | 가능                                                    |
| collection 사용 | 불가능                                | 가능                                                    |
| 성능            | 더 빠르고 메모리 효율적                      | 상대적으로 느리고 메모리 사용량이 큼                                  |
| 사용 상황         | 단순 계산, 반복문, 일반 변수, 성능 중요할 때        | 컬렉션 사용, `null` 필요, 메서드 활용 등 추가 기능이 필요할 때              |
| 대표 특징         | 가볍고 단순함                            | 기능이 더 많고 객체처럼 다룰 수 있음                                 |


3. Collection

- 정의: 값 하나만 저장하는 게 아니라, 여러 개를 한꺼번에 관리하는 객체
- Array vs Collection
  - Array: 크기가 고정되어있음 `int[] arr = new int[3];`
  - Collection: 크기가 유동적임 `ArrayList<Integer> list = new ArrayList<>();`

4. String 메서드

- `str.length()` : 문자열 길이 
- `str.charAt(i)` : 문자열의 i번째 문자
- `str.toLowerCase()` : 문자열의 문자를 소문자로 변경