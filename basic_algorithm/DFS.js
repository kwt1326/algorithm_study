/**
 * Graph DFS 구현 (무방향)
 * 
 * * TIP - 
 * 0 번째 index 는 실제 문제에서 1 index 부터 세는 경우가 많기 때문에
 * 구현 편의상 사용하지 않는 배열로 추가해 둡니다.
 * 
 * 미로 탐색 등의 문제에 사용됩니다.
 * 스택 자료구조 / 재귀 알고리즘 사용
 * 
 * @param {Array<Array<number>>} g // 2차원 배열 그래프
 * @param {number} i               // 방문한 노드 인덱스
 * @param {Array<boolean>} visit   // 방문 처리 확인용 배열
 */
function dfs(g, i, visit) {
  // 우선 방문 처리
  visit[i] = true;

  console.log(`NODE-${i} ${g[i]} 방문 중`)

  // 노드 간선을 탐색해, 가장 먼저 발견된 미방문 노드 부터 깊게 탐색합니다.
  for (j of g[i]) {
    if (visit[j] === false) {
      dfs(g, j, visit)
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
dfs(graph, 1, visitedArr)