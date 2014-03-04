package ltoj;
import java.util.*;

/**
 * Created by jun on 14-2-26.
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> arr = new ArrayList<String[]>();

        Stack<Node> S = new Stack<Node>();
        S.push(new Node(0, 0));

        // S holds the valid positions in previous rows
        while(!S.empty()){

            if (getASolution(S, n))
                addSolution(S, arr);
            else if(GetQueenOnNextRow(S, n))
                continue;

            ChangeQueenToExpand(S, n);
        }

        return arr;
    }

    final static class Node{
        Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
        int x;
        int y;
    };

    private boolean conflict(Stack<Node> S, int x, int y){
        for (Node t: S){
            if (t.x == x || t.y == y)
                return true;

            if (t.x + y == t.y + x ||
                    t.x + t.y == x + y)
                return true;
        }

        return false;
    }

    private boolean getASolution(Stack<Node> s, int n) {
        return s.size() == n;
    }

    private void addSolution(Stack<Node> s, ArrayList<String[]> arr) {
        int n = s.size();
        String[] board = new String[n];
        for (int i=0; i<n; ++i) {
            Node node = s.get(i);
            StringBuilder builder = new StringBuilder(n);
            builder.setLength(n);
            for (int j=0; j<n; ++j)
                builder.setCharAt(j, '.');
            builder.setCharAt(node.x, 'Q');
            board[i] = builder.toString();
        }

        arr.add(board);
    }

    private void ChangeQueenToExpand(Stack<Node> s, int n) {
        do {
            Node t = s.pop();

            for (int i = t.x + 1; i < n; ++i) {
                if (!conflict(s, i, t.y)){
                    t.x = i;
                    s.push(t);
                    return;
                }
            }
        }while(!s.empty());
    }

    private boolean GetQueenOnNextRow(Stack<Node> s, int n) {
        Node t = s.lastElement();
        boolean bGetQueenOnNextRow = false;

        for (int i = 0; i<n; ++i) {
            if (!conflict(s, i, t.y + 1)) {
                s.push(new Node(i, t.y + 1));
                bGetQueenOnNextRow = true;
                break;
            }
        }
        return bGetQueenOnNextRow;
    }
}
