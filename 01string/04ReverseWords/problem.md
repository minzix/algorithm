### 단어 뒤집기

**설명**

- N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


**입력**

- 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
- 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


**출력**
- N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


_예시 입력 1_

```java
3
good
Time
Big
```

_예시 출력 1_

```java
doog
emiT
giB
```

**설명**

1. 배열 선언 방법: `자료형[] 배열이름 = new 자료형[길이];`

```java
String[] words = new String[3]; // words[0] = "good";
int[] numbers = new int[5]; // numbers[0] = 10;
char[] letters = new char[4]; // letters[0] = 'a';
double[] scores = new double[3]; // scores[0] = 95.5;
boolean[] checks = new boolean[3]; // checks[0] = true;
long[] arr = new long[3]; // arr[0] = 100L;
float[] arr = new float[3]; // arr[0] = 1.2f;
```

2. 배열에 값 할당 방법
- `배열이름[i] = 값`

3. 배열에 값 할당 시 주의사항!
- `String[] reversedArr = new String[N];` 에 바로 값을 `+=` 으로 `reversedArr[i] += word.charAt(j);` 와 같이 할당 시, 기본값이 null이므로 nulla 와 같은 의도치 않은 garbage 값이 들어갈 수 있음.
- 따라서 반드시 `reversedArr[i] = "";` 등을 통해 빈 문자열로 초기화 후 할당해야 함.


4. `input.nextInt();` 사용 시 주의사항!
- nextInt 뒤 남은 \n 제거하기 위해 반드시 뒤에 `input.nextLine();` 을 함께 사용해야 함

