import java.util.*;

class CelebrityProblem {
    /**
     * celebrity is a person in a party who knows no one but everyone in the
     * party(excluding him) knows him.
     * 
     * @param matrix
     */
    public static void findCeleb(int[][] matrix) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < matrix.length; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int personOne = st.pop();
            int personTwo = st.pop();

            if (matrix[personOne][personTwo] == 1) {
                st.push(personTwo);
            } else {
                st.push(personOne);
            }
        }

        int expCeleb = st.pop();

        for (int i = 0; i < matrix.length; i++) {
            if (i == expCeleb)
                continue;
            if (matrix[i][expCeleb] == 0 || matrix[expCeleb][i] == 1) {
                System.out.println("No Celebrity Exists");
                return;
            }
        }

        System.out.println("Celebrity exists at index : " + expCeleb);
    }

    /**
     * we will maintain two arrays of type int say indegree and outdegree
     * we will find the index where inDegree is equal to n - 1 and outDegree is
     * equal to 0
     * than index will be our celebrity
     * 
     * @param matrix
     */
    public static void inOutMethod(int[][] matrix) {
        int[] inDegree = new int[matrix.length];
        int[] outDegree = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (outDegree[i] == 0 && inDegree[i] == matrix.length - 1) {
                System.out.println("Celeb found at index : " + i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 1, 0, 1 },
                { 1, 1, 0, 0 }
        };

        // inOutMethod(matrix);
        findCeleb(matrix);
    }
}