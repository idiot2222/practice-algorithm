package programmers.level3.best_album;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, int[]> genreMap = getGenreMap(genres, plays);
        Map<String, Integer> playsMap = getPlaysMap(genres, plays);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(playsMap.entrySet());

        list.sort((x, y) -> y.getValue() - x.getValue());
        List<String> collect = list.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String key : collect) {
            int[] arr = genreMap.get(key);

            result.add(arr[0]);
            if(arr[1] != -1) {
                result.add(arr[1]);
            }
        }

        return listToArray(result);
    }

    private int[] listToArray(List<Integer> list) {
        int len = list.size();
        int[] arr = new int[len];

        for(int i = 0 ; i < len ; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    private Map<String, Integer> getPlaysMap(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        int len = genres.length;

        for (int i = 0 ; i < len ; i++) {
            String genre = genres[i];

            if(map.containsKey(genre)) {
                int temp = map.get(genre);

                map.replace(genre, temp + plays[i]);
            }
            else {
                map.put(genre, plays[i]);
            }
        }

        return map;
    }

    private Map<String, int[]> getGenreMap(String[] genres, int[] plays) {
        Map<String, int[]> map = new HashMap<>();
        int len = genres.length;

        for(int i = 0 ; i < len ; i++) {
            String temp = genres[i];

            if(map.containsKey(temp)) {
                int[] arr = map.get(temp);

                if(arr[1] < 0 || plays[arr[1]] < plays[i]) {
                    arr[1] = i;

                    if(plays[arr[0]] < plays[arr[1]] || plays[arr[0]] == plays[arr[1]] && arr[0] > arr[1]) {
                        swap(arr);
                    }
                }
            }
            else {
                int[] arr = {i, -1};

                map.put(temp, arr);
            }
        }

        return map;
    }

    private void swap(int[] arr) {
        if(arr[0] < arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
    }
}
