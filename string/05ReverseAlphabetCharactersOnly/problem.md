### 특정 문자 뒤집기
**설명**

- 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

- 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


**입력**

- 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


**출력**

- 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


_예시 입력 1_

```
a#b!GE*T@S
```

_예시 출력 1_

```
S#T!EG*b@a
```

**설명**

1. 알파벳인지 아닌지 판별하는 메서드
- `Character.isAlphabetic(ch)`

2. 자바에서 String 안의 특정 위치 문자끼리 swap 하기 
- String은 불변(immutable) 이라서 직접 바꿀 수는 없고, 보통 char 배열로 바꾼 뒤 swap 함
- `char[] arr = 문자열.toCharArray();`

```java
char temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
```
- 이후에는 `String str = new String(arr);` 로 다시 문자열로 변경함