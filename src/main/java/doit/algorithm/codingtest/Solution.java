package doit.algorithm.codingtest;

import java.util.*;

class Solution {
    LinkedList<String> cache = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public int solution(int cacheSize, String[] cities) {
        int result = 0;
        for(int i = 0; i<cities.length; i++) {
            String city = cities[i];
            boolean hasHitCache = lruCache(city, cacheSize);
            if(hasHitCache) {
                result += 1;
            } else {
                result += 5;
            }
        }
        return result;
    }

    public boolean lruCache (String city, int cacheSize) {
        if(cache.size() < cacheSize) {
            if(map.get(city) == null) {
                cache.addFirst(city);
                map.put(city, 0);
                return false;
            }
        } else {
            if(map.get(city) == null) {
                String removeCity = cache.getLast();
                map.remove(removeCity);
                cache.removeLast();
                cache.addFirst(city);
                map.put(city, 0);
                return false;
            } else {
                for(int i = 0; i<cache.size(); i++) {
                    String cacheHitCity = cache.get(i);
                    if(cacheHitCity.equals(city)) {
                        cache.remove(i);
                        cache.addFirst(city);
                    }
                }
                return true;
            }
        }
        return false;
    }

}
