package org.example.programmers.dvide_conquer;

public class 표현가능한이진트리_recursive {
    public int[] solution(long[] numbers) {
        int[] answer = new int [numbers.length];
        int idx = 0;
        for (long number : numbers) {
            String binaryNum = getFullBinary(Long.toBinaryString(number));
            if (isBinaryTree(binaryNum))
                answer[idx++] = 1;
            else
                answer[idx++] = 0;
        }
        return answer;
    }

    private boolean isBinaryTree(String binaryNum) {
        int length = binaryNum.length();
        int root = length / 2;
        if (root == 0)
            return true;
        System.out.println(length + " " + root);

        String leftSubTree = binaryNum.substring(0, root);
        String rightSubTree = binaryNum.substring(root+1);

        if (binaryNum.charAt(root) == '0') {
            return (isOnlyZero(leftSubTree) && isOnlyZero(rightSubTree));
        } else {
            return (isBinaryTree(leftSubTree) && isBinaryTree(rightSubTree));
        }
    }

    private String getFullBinary (String binaryNum) {
        long depth = findDepth(binaryNum.length());
        // System.out.println(depth);
        int gap = (int)(Math.pow(2, depth) -1 - binaryNum.length());
        return "0".repeat(gap) + binaryNum;
    }

    private long findDepth(long binaryLength) {
        int depth = 0;
        while (true) {
            if (Math.pow(2, depth) -1 >= binaryLength)
                return depth;
            else
                depth++;
        }
    }

    private boolean isOnlyZero(String tree) {
        if (tree.contains("1"))
            return false;
        return true;
    }


//     private String makeBinaryNum(long number) {
//         StringBuilder sb = new StringBuilder();

//         while (number != 1) {
//             if (number % 2 == 0)
//                 sb.append("0");
//             else
//                 sb.append("1");
//         }
//         return sb.reverse().toString();
//     }
}
