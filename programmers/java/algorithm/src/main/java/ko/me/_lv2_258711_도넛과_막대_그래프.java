package ko.me;

import java.util.*;

// Graph
// https://school.programmers.co.kr/learn/courses/30/lessons/258711
public class _lv2_258711_도넛과_막대_그래프 {

    // 첫 시도, 정점부터 8자 -> 도넛.. 순으로 무차별 간선 수 탐색
    // 구현이 시간안에 풀 수 없을 정도로 길어져서 중단
    static class Solution1 {
        public int extractConnectionNode(final Map<Integer, List<Integer>> injects) {
            final Set<Integer> keys = injects.keySet();
            for (Integer key : keys) {
                final List<Integer> nodes = injects.get(key);
                // 간선 사이즈가 2 초과면 정점이다.
                if (nodes.size() > 2) {
                    return key;
                }
                // 간선 사이즈가 2 이면서, 자신을 향하는 노드가 2개가 아니어야 한다. (8자 그래프 조건)
                if (nodes.size() == 2) {
                    int count = 0;
                    for (Integer key2 : keys) {
                        final List<Integer> nodes2 = injects.get(key2);
                        if (nodes2.contains(key)) {
                            count++;
                        }
                    }
                    if (count != 2) {
                        return key;
                    }
                }
            }
            return -1;
        }

        // 구현 중단
        public int extractDonuts(final Map<Integer, List<Integer>> injects) {
            int count = 0;

            final Set<Integer> keys = injects.keySet();

            for (Integer key : keys) {
                final List<Integer> nodes = injects.get(key);
                // 자신을 보는 도넛
                if (nodes.size() == 1) {
                    if (key == nodes.get(0)) {
                        count++;
                        continue;
                    }
                }
            }

            return -1;
        }

        // 구현 중단
        public int extractLines(final Map<Integer, List<Integer>> injects) {
            return -1;
        }

        public int extractEights(final Map<Integer, List<Integer>> injects) {
            int count = 0;

            final Set<Integer> keys = injects.keySet();

            // 정점들 추출
            List<Integer> connectionNodes = new ArrayList<>();
            for (Integer key : keys) {
                final List<Integer> nodes = injects.get(key);
                if (nodes.size() == 2) {
                    int ways = 0;
                    for (Integer key2 : keys) {
                        final List<Integer> nodes2 = injects.get(key2);
                        if (nodes2.contains(key)) {
                            ways++;
                        }
                    }
                    if (ways == 2) {
                        connectionNodes.add(key);
                    }
                }
            }

            // 8자 그래프 검사
            int twoWayChecked = 0;
            for (Integer n : connectionNodes) {
                // 순환 체크
                final List<Integer> nodes = injects.get(n);
                for (Integer n2 : nodes) {
                    List<Integer> checked = new ArrayList<>();
                    int key = n2;
                    List<Integer> nodes2 = injects.get(key);
                    checked.add(key);
                    while (nodes2.size() == 1 && !checked.contains(key)) {
                        checked.add(key);
                        key = nodes2.get(0);
                        nodes2 = injects.get(key);
                    }
                    if (key == checked.get(0)) {
                        twoWayChecked++;
                    }
                }
                // 2방향 순환 성공시 count + 1
                if (twoWayChecked == 2) {
                    count++;
                }
            }

            return count;
        }

        public int[] solution(int[][] edges) {
            final Map<Integer, List<Integer>> injectionListMap = new HashMap<>();

            for (final int[] e : edges) {
                int from = e[0];
                int to = e[1];
                final List<Integer> nodes = injectionListMap.getOrDefault(from, new ArrayList<>());
                nodes.add(to);
                injectionListMap.put(from, nodes);
            }

            // 정점
            final int connectionNode = extractConnectionNode(injectionListMap);
            // 8자 (이걸 먼저하고 제거해야 도넛할 때 문제가 없다)
            final int eights = extractEights(injectionListMap);
            // 도넛
            final int donuts = extractDonuts(injectionListMap);
            // 막대
            final int lines = extractLines(injectionListMap);

            return new int[]{connectionNode, donuts, lines, eights};
        }
    }

    // in,out 간선 차수를 이용하는 방법으로 구현이 훨씬 간소화되었다.
    public static class Solution {
        public static int[] solution(int[][] edges) {
            final Map<Integer, List<List<Integer>>> countMap = new HashMap<>();

            // 각 노드 별 들어오는 노드, 나가는 노드들을 모두 관리해야 한다.
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                final List<List<Integer>> fromOutNodes = countMap.get(from);
                if (fromOutNodes == null) {
                    countMap.putIfAbsent(from, new ArrayList<>());
                    countMap.get(from).add(new ArrayList<>());
                    countMap.get(from).add(new ArrayList<>());
                }
                countMap.get(from).get(1).add(to);
                final List<List<Integer>> toOutNodes = countMap.get(to);
                if (toOutNodes == null) {
                    countMap.putIfAbsent(to, new ArrayList<>());
                    countMap.get(to).add(new ArrayList<>());
                    countMap.get(to).add(new ArrayList<>());
                }
                countMap.get(to).get(0).add(from);
            }
            
            int extraNode = 0;
            int donutCount = 0;
            int barCount = 0;
            int eightCount = 0;

            for (Integer key : countMap.keySet()) {
                final List<List<Integer>> nodesList = countMap.get(key);
                final List<Integer> inputNodes = nodesList.get(0);
                final List<Integer> outNodes = nodesList.get(1);
                final int inputNodesSize = inputNodes.size();
                final int outNodesSize = outNodes.size();

                if (inputNodesSize == 0 && outNodesSize >= 2) {
                    extraNode = key;
                } else if (inputNodesSize > 0 && outNodesSize == 0) {
                    barCount++;
                } else if (inputNodesSize > 1 && outNodesSize > 1) {
                    eightCount++;
                }
            }

            // 모든 그래프는 정점으로부터 연결되므로,
            // [정점 => 8자/막대 그래프] 간선 수를 제외하면 도넛 그래프로 향하는 간선의 수가 나온다.
            final int extraNodeOutCount = countMap.get(extraNode).get(1).size();
            donutCount = Math.max(extraNodeOutCount - barCount - eightCount, 0);

            return new int[]{extraNode, donutCount, barCount, eightCount};
        }

        public static void main(String[] args) {
            int[][] edges1 = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
            System.out.println(Arrays.toString(solution(edges1))); // [2, 1, 1, 0]

            int[][] edges2 = {
                    {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8},
                    {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
            };
            System.out.println(Arrays.toString(solution(edges2))); // [4, 0, 1, 2]
        }
    }
}
