# Kotlin BJ PS Tips

### Input Functions
```
val sc = Scanner(System.`in`)
val n =  sc.next()

next(): String! # String 타입으로 리턴
nextByte(): Byte # Byte 타입으로 리턴
nextShort(): Short # Short 타입으로 리턴
nextInt(): Int # Int 타입으로 리턴
nextLong(): Long # Long 타입으로 리턴
nextFloat(): Float # Float 타입으로 리턴
nextDouble(): Double # Double 타입으로 리턴
nextLine(): String! # '\n'을 포함하는 한 라인을 읽고 '\n'을 버린 나머지 문자열을 String  타입으로 리턴
```

### Data Structure
```
# Stack

val stack = Stack<Char>()
stack.push()
stack.pop()
stack.peek() # 맨위의 데이터 보기
stack.search('K') # 위치 검색

# Queue
# ArrayDeque 는 stack, queue 로도 사용 가능, Queue 는 LinkedList 로 대체 가능

val queue = ArrayDeque<Int>(n)
queue.poll() # 맨 앞의 데이터 제거 후 반환, 빈 값일 경우 null 반환
queue.add(), offer() # add 는 그냥 추가, offer 는 삽입 성공 여부 반환

# Deque
# 마찬가지로 ArrayDeque, LinkedList 로 deque 구현체 사용 가능

```