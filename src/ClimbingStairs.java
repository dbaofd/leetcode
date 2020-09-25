/**
 * Created by dbaofd on 2020/9/23.
 */
//Unsolved
public class ClimbingStairs {
    // Using tree to solve this problem has very low efficiency, the algorithm is all right.
    public static int numberOfStairs = 0;

    public class MyNode {
        public MyNode() {
        }

        public MyNode(int currentBrunchSum) {
            this.currentBrunchSum = currentBrunchSum;
            this.leftNode = null;
            this.rightNode = null;
        }

        MyNode leftNode;
        MyNode rightNode;
        int currentBrunchSum;
    }

    public MyNode addNode(MyNode node) {
        if (node.currentBrunchSum < numberOfStairs) {
            node.leftNode = addNode(new MyNode(node.currentBrunchSum + 1));
            node.rightNode = addNode(new MyNode(node.currentBrunchSum + 2));
        }
        return node;
    }

    public int traverseTree(MyNode node) {
        int leftSum = 0;
        int rightSum = 0;
        int nodeSum = 0;
        if (node != null) {
            if (node.currentBrunchSum == numberOfStairs)
                nodeSum = 1;
            leftSum = traverseTree(node.leftNode);
            rightSum = traverseTree(node.rightNode);
        }
        return nodeSum + leftSum + rightSum;
    }

//    public static long factorial(long number) {
//        if (number <= 1)
//            return 1;
//        else
//            return number * factorial(number - 1);
//    }

    public int climbStairs(int n) {
        numberOfStairs = n;
        MyNode root = addNode(new MyNode(0));
        int result = traverseTree(root);
//        int numOfTwos = 0;
//        int numOfApproaches = 0;
//        while (n >= 0) {
//
//            if (numOfTwos == 0) {
//                numOfApproaches++;
//            } else {
//                if (n == 0) {
//                    numOfApproaches++;
//                } else {
//                    int fc=(int) (factorial(n + numOfTwos) / (factorial(n) * factorial(numOfTwos)));
//                    numOfApproaches = numOfApproaches + fc;
//                    System.out.println(n+" "+fc+" "+numOfTwos);
//                }
//            }
//            numOfTwos++;
//            n = n - 2;
//
//        }
        return result;
    }

    //14930352
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int a = climbingStairs.climbStairs(35);
        System.out.println(a);
    }
}
