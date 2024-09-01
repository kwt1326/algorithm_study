package ko.me;

// O(m + n), Brute force, Optimize
public class _MEDIUM_240_Search_a_2D_Matrix_II {

    // 열이 오름차순인 특징을 이용해서 행 탐색 범위를 한번의 배열 순회로 줄여놓고 시작한다.
    // 일반적인 탐색 알고리즘을 사용하기 까다롭기 때문에, 조금 특수하게 접근해야 한다.
    // 첫 행의 뒤부터 크기를 비교해서 최초로 타겟보다 작아지는 지점부터 행 탐색을 시작한다.
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;

        int[] firstRow = matrix[0];

        for (int i = firstRow.length - 1; i >= 0; --i) {
            int v = firstRow[i];
            if (target == v) {
                return true;
            }
            else if (target > v) {
                for (int j = 0; j <= matrix.length - 1; ++j) {
                    int vv = matrix[j][i];
                    if (target == vv) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 26));
    }
}
