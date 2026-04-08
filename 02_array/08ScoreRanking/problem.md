### 등수구하기
**설명**

- N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

- 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

- 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

**입력**

- 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.

**출력**

- 입력된 순서대로 등수를 출력한다.

_예시 입력 1_

```json
5
87 89 92 100 76
```

_예시 출력 1_

```json
4 3 2 1 5
```

**설명**

1. `Map` 의 메서드들

| 메서드                    | 설명         |
| ---------------------- | ---------- |
| `put(key, value)`      | 저장         |
| `get(key)`             | 값 꺼내기      |
| `remove(key)`          | 삭제         |
| `containsKey(key)`     | 키 존재 여부 확인 |
| `containsValue(value)` | 값 존재 여부 확인 |
| `size()`               | 개수         |
| `isEmpty()`            | 비었는지 확인    |


2. `HashMap` 이란? Map 인터페이스를 구현한 클래스 중 하나

- 검색/삽입 속도가 빠름
- 순서를 보장하지 않음 → 저장 순서 보장 필요 시 `LinkedHashMap` 사용
- 키는 중복 불가
- 값은 중복 가능
- null 키 1개 허용, null 값 여러 개 허용

_키 기준 자동 정렬 필요 시 `TreeMap` 사용_

3. `ArrayList<>` 의 메서드들

| 메서드                                     | 설명                | 반환값           |
| --------------------------------------- | ----------------- | ------------- |
| `add(E e)`                              | 맨 뒤에 원소 추가        | `boolean`     |
| `get(int index)`                        | 특정 인덱스의 값 조회      | `E`           |
| `size()`                                | 원소 개수 반환          | `int`         |
| `remove(int index)`                     | 특정 인덱스 원소 삭제      | `E`           |
| `remove(Object o)`                      | 특정 값과 같은 원소 하나 삭제 | `boolean`     |
| `set(int index, E element)`             | 특정 위치의 값을 변경      | `E`           |
| `isEmpty()`                             | 리스트가 비어 있는지 확인    | `boolean`     |
| `contains(Object o)`                    | 특정 값 포함 여부 확인     | `boolean`     |
| `clear()`                               | 모든 원소 삭제          | `void`        |
| `sort(Comparator<? super E> c)`         | 정렬                | `void`        |
| `indexOf(Object o)`                     | 특정 값의 첫 번째 위치 반환  | `int`         |
| `lastIndexOf(Object o)`                 | 특정 값의 마지막 위치 반환   | `int`         |
| `add(int index, E element)`             | 특정 위치에 원소 삽입      | `void`        |
| `toArray()`                             | 배열로 변환            | `Object[]`    |
| `iterator()`                            | 반복자 반환            | `Iterator<E>` |
