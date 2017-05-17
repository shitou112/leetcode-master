package array;

/**
 * Created by Administrator on 2017/5/12.
 */
public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int[][] marked;
        for(int i=0; i < board.length; ++i){
            for(int j=0; j < board[0].length; ++j){
                marked= new int[board.length][board[0].length];
                if(ismarch(board, i, j, marked, word, 0))
                    return true;
            }
        }
        return false;

    }

    public boolean ismarch(char[][] board, int i, int j, int[][] marked, String word, int index){
        if(index == word.length())
            return true;
        marked[i][j] += 1;
//        System.out.println(i+"   "+j+"   "+word.charAt(index));
//        System.out.println(board[i][j]+"  "+word.charAt(index));
        if(board[i][j] == word.charAt(index)){
            if (ismarch(board, i, j, marked,word, index+1)){
                return true;
            }

            if(i-1 >= 0 && marked[i-1][j] == 0){
                if(ismarch(board, i-1, j, marked, word, index+1)) {
//                    System.out.println("up");
                    return true;
                }
            }
            if(i+1 < board.length && marked[i+1][j] == 0){
                if(ismarch(board, i+1, j, marked, word, index+1)) {
//                    System.out.println("down");
                    return true;
                }
            }
            if(j-1 >= 0 && marked[i][j-1] == 0){
                if(ismarch(board, i, j-1, marked, word, index+1)) {
//                    System.out.println("left");
                    return true;
                }
            }
            if(j+1 < board[0].length && marked[i][j+1] == 0){
                if(ismarch(board, i, j+1, marked, word, index+1)) {
//                    System.out.println("right");
                    return true;
                }
            }
        }
        marked[i][j] -= 1;
        return false;
    }

    public static void main(String[] args) {

        String[] str = {"aa"};
        char[][] board = new char[str.length][];
        for(int i=0; i < str.length; ++i){
            board[i] = str[i].toCharArray();
        }
        for(int i=0; i < str.length; ++i){
            for (int j=0; j < str[0].length(); ++j){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        String word = "aaa";
        WordSearch_79 wordSearch_79 = new WordSearch_79();
        System.out.println(wordSearch_79.exist(board, word));
    }
}
