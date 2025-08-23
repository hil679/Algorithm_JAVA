package org.programmers.hash;
import java.util.*;
public class ProgrammmersHash1Ponkémon {
    public int solution(int[] nums) {
        int getMonNums= nums.length / 2;
        List<Integer> Mons = new ArrayList<>();
        for(int num : nums){
            if(Mons.size()==getMonNums)
                break;
            if(!Mons.contains(num)){
                Mons.add(num);
            }
        }
        return Mons.size();

    }
}