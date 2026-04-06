### 회문 문자열

**설명**

- 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
- 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
- 단 회문을 검사할 때 대소문자를 구분하지 않습니다.

**입력**

- 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

**출력**

- 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.

_예시 입력 1_

```json
gooG
```

_예시 출력 1_

```json
YES
```
---

**설명**

1. 오답노트

- `return` 이 아닌 `break` 를 써서 아래와 같이 의도와 다른 동작 발생

_틀린 예시 입력_
```json
kstudkgksjlkgjlksjdggkkllllllllllllllllllllllsjgksjldgjlllllllllllllllgjks
```

_예시 출력_
```json
NO
```

_내 출력_
```json
NO
YES
```

2. `break` vs `return`

* `break`는 **반복문(`for`, `while`)이나 `switch`문만 즉시 종료**하고, 그 아래의 바깥 코드 실행은 계속됩니다.
* `return`은 **현재 메서드 자체를 즉시 종료**하며, 호출한 곳으로 돌아갑니다.
  * `void` 메서드에서는 `return;`만 가능하고, 반환값이 있는 메서드에서는 `return 값;` 형태를 써야 합니다.
