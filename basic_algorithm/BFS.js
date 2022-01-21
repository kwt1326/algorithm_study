/**
 * Graph BFS 구현 (무방향)
 * 
 * * TIP - 
 * 0 번째 index 는 실제 문제에서 1 index 부터 세는 경우가 많기 때문에
 * 구현 편의상 사용하지 않는 배열로 추가해 둡니다.
 * 
 * 최단 경로 탐색 등의 문제에 사용됩니다.
 * 큐 자료구조 / 반복문 사용 (재귀로 구현이 쉽지않고, 비효율적)
 * 
 * @param {Array<Array<number>>} g // 2차원 배열 그래프
 * @param {number} i               // 방문한 노드 인덱스
 * @param {Array<boolean>} visit   // 방문 처리 확인용 배열
 */
 function bfs(g, i, visit) {
  // 우선 방문 처리
  visit[i] = true;
  // 큐의 처음 (0 이 아닌 1부터) 세팅
  const queue = [i];

  // 큐가 빌때 까지 pop_front / push_back 반복
  while (queue.length !== 0) {
    const v = queue.shift();
    console.log(v)

    // 큐에서 꺼낸 노드 간선 검사 및 push
    for (num of g[v]) {
      if (visit[num] === false) {
        visit[num] = true;
        queue.push(num)
      }
    }
  }
}

// 한 줄당 하나의 노드를 나타내며, 각 번호는 연결된 노드를 의미합니다.
const graph = [
  [], // 0 번째 index 주석 참고
  [2,3,8],
  [1,7],
  [1,4,5],
  [3,5],
  [3,4],
  [7],
  [2,6,8],
  [1,7]
]

// 방문 체크할 용도의 배열
const visitedArr = Array(graph.length).fill(false)

// 0이 아닌 1번째 부터 방문이 가능하도록 1부터 시작합니다.
bfs(graph, 1, visitedArr)
console.log(visitedArr)