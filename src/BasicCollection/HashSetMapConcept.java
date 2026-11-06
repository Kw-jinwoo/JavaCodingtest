package BasicCollection;

import java.util.*;

public class HashSetMapConcept {
    /// ================================
    /// HashSet - 집합
    //  - 중복이 제거되는 순서없는 동일 참조타입 변수집합
    //  - 중복 제거와 값의 종류 카운팅이 필요할 때 사용
    //  - 고성능 탐색(contains), 삽입(add), 삭제(remove) - O(1)
    //  - Collection(Array(List로변환), List, Set, Deque, PQ)간 초기화 가능!
    //  - 순회시 인덱싱 및 순서 불가
    /// ================================
    /// TreeMap - 정렬된 집합
    //  - 제공된 Comparator<> (기본적으로 오름차순)로 항상 값의 정렬상태를 유지
    //  - 순회시 정렬 순서에 따라 조회
    /// ================================

    public static void HashSetPractice() {
        HashSetBasic();
        HashSetControl();
    }

    // 1. HashSet 생성 및 초기화 & 삽입 및 삭제
    private static void HashSetBasic() {
        // HashSet 생성
        Set<Integer> hashSet = new HashSet<>();

        // HashSet 삽입 - O(1)
        hashSet.add(1);                                             // 값 중복시 false 반환
        hashSet.add(2);                                             // 정상 삽입시 true 반환

        // HashSet 삭제 - O(1)
        hashSet.remove(2);
    }

    // 2. HashSet 탐색 & 메서드
    private static void HashSetControl() {
        Set<Integer> hashSet = new HashSet<>(List.of(1, 2, 3));

        // HashSet 존재여부탐색 - O(1)
        boolean isExists = hashSet.contains(1);

        // HashSet 무작위탐색 - O(1)
        if (!hashSet.isEmpty()) {                                   // isEmpty 체크필수! 없으면 Exception
            int elm = hashSet.iterator().next();
        }

        // HashSet 크기확인 - O(1)
        int size = hashSet.size();

        // HashSet 공백확인 - O(1)
        boolean isEmpty = hashSet.isEmpty();
    }

    // 3. TreeSet 생성 및 초기화 & 제어
    private static void TreeSetBasic() {
        // TreeSet 생성
        Set<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());

        // TreeSet 삽입 - O(logN)
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);

        // TreeSet 삭제 - O(logN)
        treeSet.remove(3);

        // TreeSet 존재여부탐색 - O(logN)
        boolean isExists = treeSet.contains(2);

        // TreeSet 크기확인 - O(1)
        int size = treeSet.size();

        // TreeSet 공백확인 - O(1)
        boolean isEmpty = treeSet.isEmpty();

        // TreeSet 순회 -> 정렬된 순서로 조회
        for (int i : treeSet) {
            System.out.println(i);
        }
    }


    /// ================================
    /// HashMap - KeyValue집합
    //  - Key중복이 제거되는 순서없는 동일 참조타입 Key-Value 변수쌍 집합
    //  - Key-Value 매핑으로 종류별카운팅, 종류별집계, 인덱싱, 그룹핑 활용
    //  - 고성능 탐색(contains), 삽입(add), 삭제(remove) - O(1)
    //  - 순회시 인덱스 및 순서 불가
    /// ================================
    /// TreeMap - 정렬된 KeyValue 집합
    //  - 제공된 Comparator<> (기본적으로 오름차순)로 항상 Key의 정렬상태를 유지
    //  - 순회시 정렬 순서에 따라 조회
    /// ================================

    public static void HashMapPractice() {
        HashMapBasic();
        HashMapControl();
        HashMapKeyValueControl();
    }

    // 1. HashMap 생성 및 초기화 & 삽입 및 삭제
    private static void HashMapBasic() {
        // HashMap 생성
        Map<String, Integer> hashMap = new HashMap<>();

        // HashMap 삽입
        hashMap.put("java", 20);
        hashMap.put("spring", 30);
        hashMap.put("java", 30);                                    // Key 중복 불허하므로 KV 덮어쓰기
        hashMap.putIfAbsent("java", 40);                            // Key 없을시에만 KV 삽입

        // HashMap 삭제
        hashMap.remove("java");
    }

    // 2. HashMap 탐색 & 메서드
    private static void HashMapControl() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("java", 30);
        hashMap.put("spring", 40);

        // HashMap Value탐색
        int java = hashMap.get("java");                             // Key 없을시 null 반환
        int spring = hashMap.get("spring");
        int sql = hashMap.getOrDefault("sql", 0);    // Key 없을시 default값 반환

        // HashMap Key탐색
        boolean isExists = hashMap.containsKey("java");

        // HashMap KV개수확인 - O(1)
        int size = hashMap.size();

        // HashMap 공백확인 - O(1)
        boolean isEmpty = hashMap.isEmpty();
    }

    // 3. HashMap KV제어
    private static void HashMapKeyValueControl() {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, List<Integer>> groupMap = new HashMap<>();
        String[] arr = {"codeit", "java", "codeit", "sql", "codeit"};

        // HashMap Key별 Value카운팅
        for (String key : arr) {
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);     // 덮어쓰기 방법으로 value를 카운팅
        }

        // HashMap Key 확인탐색
        groupMap.putIfAbsent("codeit", new ArrayList<>());          // Key 없을시 KV삽입
        groupMap.get("codeit").add(1);
    }

    // 4. HashMap 순회
    private static void HashMapTraversal() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("codeit", 10);
        hashMap.put("java", 20);
        hashMap.put("sql", 30);

        // HashMap Key순회
        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }

        // HashMap Value순회
        for (Integer value : hashMap.values()) {
            System.out.println(value);
        }

        // HashMap EntrySet순회
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
        }
    }

    // 5. TreeMap 생성 및 초기화 & 제어
    private static void TreeMapBasic() {
        // TreeMap 생성
        Map<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        // TreeSet 삽입 - O(logN)
        treeMap.put("codeit", 10);
        treeMap.put("java", 20);
        treeMap.put("sql", 30);
        treeMap.putIfAbsent("codeit", 40);

        // TreeSet 삭제 - O(logN)
        treeMap.remove("java");

        // TreeSet 탐색 - O(1)
        int java = treeMap.get("java");
        int sql = treeMap.getOrDefault("sql", 0);

        // TreeSet 존재여부탐색 - O(logN)
        boolean isExists = treeMap.containsKey("codeit");

        // TreeSet 크기확인 - O(1)
        int size = treeMap.size();

        // TreeSet 공백확인 - O(1)
        boolean isEmpty = treeMap.isEmpty();

        // TreeSet 순회 -> 정렬된 순서로 조회
        for (String i : treeMap.keySet()) {
            System.out.println(i);
        }
    }
}
