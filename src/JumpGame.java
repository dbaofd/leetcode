import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dbaofd on 2020/9/28.
 */
public class JumpGame {
    //recursive method is low efficiency, passed 74/75 tests
//    private boolean doJump(int[] nums, int index){
//        if(index==nums.length-1)
//            return true;
//        boolean result=false;
//        for(int i=nums[index];i>=1;i--){
//            if(index+i<=nums.length-1) {
//                result=doJump(nums, index + i);
//                if(result)
//                    break;
//            }
//        }
//        return result;
//    }
    // Idea of the algorithm is to mark the reachable index as '1', for example, [2,3,1,1,4],
    // 2(0) can reach 3(1) and 1(2) which will be marked as '1' in markArray.
    // then 3(1) can reach 1(2),1(3)and 4(4). when reach 4(4), return true.
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int[] markArray = new int[nums.length];
        markArray[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (markArray[i] == 1) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j == nums.length - 1)
                        return true;
                    markArray[i + j] = 1;
                }
            }
        }
        return false;
        //return doJump(nums,0);
    }
}
