# Problem 5622 - 다이얼

[백준 5622번](https://www.acmicpc.net/problem/5622)

## 풀이 요약

알파벳 문자열을 입력받아 각 문자에 해당하는 다이얼 번호를 합산하여 출력.

## 코드 리뷰

### 불필요한 중간 배열

```java
char[] answer = new char[a.length()];
for(int i=0; i<a.length(); i++) {
    answer[i] = a.charAt(i);          // answer 배열에 저장했다가
    result = result + dialNum(answer[i]); // 바로 같은 인덱스로 꺼냄
}
```

`answer` 배열은 아무 역할을 하지 않는다. `a.charAt(i)`를 직접 사용하면 된다.

```java
for (int i = 0; i < a.length(); i++) {
    result += dialNum(a.charAt(i));
}
```

### else 절의 dead code

```java
else {
    return 11;  // A-Z만 입력된다는 문제 조건 상 도달 불가
}
```

문제 조건상 입력은 A-Z 대문자만 보장된다. 이 분기는 실행되지 않으므로 실질적인 의미가 없다. 남겨두려면 `throw new IllegalArgumentException()`으로 대체해 실수를 빠르게 잡을 수 있다.

### if-else 체인 단순화

26개 알파벳에 대한 반복적인 if-else 대신 배열 룩업으로 깔끔하게 표현할 수 있다.

```java
// 다이얼 번호 배열: 인덱스 0='A', 1='B', ...
private static final int[] DIAL = {
    3, 3, 3,        // A B C
    4, 4, 4,        // D E F
    5, 5, 5,        // G H I
    6, 6, 6,        // J K L
    7, 7, 7,        // M N O
    8, 8, 8, 8,     // P Q R S
    9, 9, 9,        // T U V
    10, 10, 10, 10  // W X Y Z
};

static int dialNum(char a) {
    return DIAL[a - 'A'];
}
```

가독성과 유지보수성이 크게 향상된다.

### 입출력 속도

`Scanner` 대신 `BufferedReader`를 사용하면 더 빠르다.
