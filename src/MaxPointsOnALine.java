import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/11/24.
 */
public class MaxPointsOnALine {
    //Passed40/41, can't pass the last one [[0,0],[94911151,94911150],[94911152,94911151]].
    private class AbPair {
        private double a;
        private double b;
        private boolean flag;
        private int number = 2;//indicate how many points are on this line

        public AbPair(double a, double b, boolean flag) {
            this.a = a;
            this.b = b;
            this.flag = flag;
        }

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    //[[0,0],[1,1],[0,0]]
    //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    //remember to use double type for a,b!
    public int maxPoints(int[][] points) {
        int numberOfPoints = points.length;
        if (numberOfPoints <= 2)
            return numberOfPoints;
        int maxNumberOfPointsOnALine = 0;
        //y=ax+b, compute the (a,b) pair for every two points.
        for (int i = 0; i < numberOfPoints; i++) {
            int numberOfRepeatedPoint = 0;
            for (int h = 0; h < numberOfPoints; h++) {
                if (h != i) {
                    if (points[i][0] == points[h][0] && points[i][1] == points[h][1])
                        numberOfRepeatedPoint++;
                }
            }
            List<AbPair> myList = new ArrayList<>();
            for (int j = 0; j < numberOfPoints; j++) {
                if (j != i) {
                    double a;
                    double b;
                    boolean flag;

                    if (points[i][0] - points[j][0] != 0) {
                        a = (double) (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);//a=(y1-y2)/(x1-x2)
                        //A problem should be noticed, what is x1==x2??
                        b = (double) points[i][1] - a * points[i][0];//b=y1-ax1;
                        flag = true;
                    } else {
                        a = points[i][0];
                        b = points[i][0];
                        flag = false;
                    }
                    if (myList.size() == 0) {
                        AbPair abPair = new AbPair(a, b, flag);
                        if (flag) {
                            abPair.setNumber(abPair.getNumber() + numberOfRepeatedPoint);
                            myList.add(abPair);
                            if (maxNumberOfPointsOnALine < 2 + numberOfRepeatedPoint)
                                maxNumberOfPointsOnALine = 2 + numberOfRepeatedPoint;
                        } else {
                            myList.add(abPair);
                            if (maxNumberOfPointsOnALine < 2)
                                maxNumberOfPointsOnALine = 2;
                        }
                    } else {
                        boolean isABExisted = false;
                        for (int k = 0; k < myList.size(); k++) {
                            if (myList.get(k).getA() == a && myList.get(k).getB() == b && myList.get(k).isFlag() == flag) {
                                isABExisted = true;
                                int currentNum = myList.get(k).getNumber();
                                myList.get(k).setNumber(currentNum + 1);
                                if (maxNumberOfPointsOnALine < currentNum + 1) {
                                    maxNumberOfPointsOnALine = currentNum + 1;
                                }
                            }
                        }
                        if (!isABExisted) {
                            AbPair abPair = new AbPair(a, b, flag);
                            if (flag) {
                                abPair.setNumber(abPair.getNumber() + numberOfRepeatedPoint);
                                myList.add(abPair);
                                if (maxNumberOfPointsOnALine < 2 + numberOfRepeatedPoint)
                                    maxNumberOfPointsOnALine = 2 + numberOfRepeatedPoint;
                            } else {
                                myList.add(abPair);
                                if (maxNumberOfPointsOnALine < 2)
                                    maxNumberOfPointsOnALine = 2;
                            }
                        }
                    }
                }
            }
        }
        return maxNumberOfPointsOnALine;
    }
}
