public class Solution {
	public static void main(String[] args){
		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int N = matrix.length, M = matrix[0].length;
		for(int I = 0; I < N; I++){
			for(int J = 0; J < M; J++){
				System.out.print(matrix[I][J]+ " ");
			}
			System.out.println();
		}
		int[][] matrixRes = new int[N][M];
		int i = 0;
		while(i < M){
			for(int j = 0; j < N; j++)
				matrixRes[j][i] = matrix[j][i];
			i++;
			if(i >= M) break;
			for(int j = 0; j < N; j++)
				matrixRes[j][i] = matrix[N-j-1][i];
			i++;
		}
		for(int I = 0; I < N; I++){
			for(int J = 0; J < M; J++){
				System.out.print(matrixRes[I][J]+ " ");
			}
			System.out.println();
		}
	}
}
