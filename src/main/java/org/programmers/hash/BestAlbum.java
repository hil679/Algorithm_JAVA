package org.programmers.hash;

import java.util.*;

public class BestAlbum {

    static class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        // 1. 장르 선정
        ArrayList<String> genres_ordered = new ArrayList<>();
        while(map.size()!=0){ // 없으면 classic은 안들어가고 pop만 genres_ordered에 들어감
            int max = -1;
            String max_key = "";
            for(String key : map.keySet()){
                int tmp_cnt = map.get(key);
                if(tmp_cnt>max){
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            map.remove(max_key); // ex) classic 다 없앰
        }

        // 2. 장르 내 노래 선정
        ArrayList<Music> result = new ArrayList<>();
        for(String gern : genres_ordered){ // pop, classic 순서
            ArrayList<Music> list = new ArrayList<>(); // 장르 하나씩만 들어감,gern== pop이면 pop만 list에 존재
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(gern)){
                    list.add(new Music(gern, plays[i], i)); // p p (처음 나온 것 부터 순서대로 들어감, 즉 인덱스 순서대로 들어감)
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 소팅
            result.add(list.get(0)); 	// 1개는 무조건 수록
            if(list.size()!=1){ 	// 더 수록할 곡이 있으면(==장르 내의 노래가 1개보다 많으면) 수록
                result.add(list.get(1));
            }
        }

        // print result
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;
    }
}


// import java.util.*;
// class Solution {
//     public int[] solution(String[] genres, int[] plays) {
//         int[] answer = {};
//         Map<Integer, Integer> hm = new HashMap<>();
//         Map<String, Integer> hmForGenres= new HashMap<>();
//         for(int i = 0; i < genres.length; i++){
//             hm.put(i, plays[i]);
//         }
//         hm.entrySet().stream().sorted(Map.Entry.comparingByValue());
//         return answer;
//     }
// }