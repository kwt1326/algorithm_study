## **Backjoon Node.js 문제풀이 주의사항**

### 필수사항

1. dummy.txt 파일 작성시, Windows 의 경우
VSCode 하단 CRLF -> LF 로 변경해야
readFileSync 로 읽을때 \r 이 붙지 않는다.

2. output 출력시, console.log 가 많이 느리기 때문에 아래와 같이 사용해야 제한 시간내에 풀수 있다.

```
const logs = [];
console.log(logs.join('\n')); // 한번에 출력!
```

3. input 을 받는 경우에 따라 readFileSync 사용방법은 `nodejs/nodejs_stdin.js` 를 참고해주세요.

### 기타

4. string 을 parsing 한 숫자는 parseInt 등을 사용해 필히 파싱 해줍니다.

5. Array loop 성능 비교 (일반 for loop 가 가장 빠르다)

![image](https://res.cloudinary.com/dyfuiigbw/image/upload/v1642347193/develop%20resource/loopperformance_pcw2du.png)

### 문제풀이 팁

6. Swap (array structure assign - 구조 분해 할당)

```[arr[1], arr[2]] = [arr[2], arr[1]]```

위와 같이 사용하면 간단히 swap 할 수 있다.

문자열은 뒤집을 때 string.reverse() 함수를 쓰지 말고 풀어보자.