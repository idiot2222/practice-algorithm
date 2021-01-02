package kakao2018.cache;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        String[] cache = new String[cacheSize];
        int[] cacheCnt = new int[cacheSize];
        int len = cities.length;

        if(cacheSize == 0) {
            return len * 5;
        }

        for(int i = 0 ; i < len ; i++) {
            String now = cities[i].toUpperCase();
            int idx = indexOf(cache, now);

            if(idx == -1) {
                answer += 5;

                int b = findBlank(cacheCnt);

                if(b >= 0) {
                    cache[b] = now;
                    cacheCnt[b] = i+1;
                }
                else {
                    int min = findMin(cacheCnt);

                    cache[min] = now;
                    cacheCnt[min] = i+1;
                }
            }

            else {
                answer++;
                cacheCnt[idx] = i+1;
            }
        }

        return answer;
    }

    private int findMin(int[] cacheCnt) {
        int min = 100001;
        int idx = -1;
        int len = cacheCnt.length;

        for (int i = 0 ; i < len ; i++) {
            if(cacheCnt[i] < min) {
                min = cacheCnt[i];
                idx = i;
            }
        }


        return idx;
    }

    private int findBlank(int[] cacheCnt) {
        int len = cacheCnt.length;

        for(int i = 0 ; i < len ; i++) {
            if(cacheCnt[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    private int indexOf(String[] cache, String now) {
        int len = cache.length;

        for(int i = 0 ; i < len ; i++) {
            if(now.equals(cache[i])) {
                return i;
            }
        }

        return -1;
    }
}