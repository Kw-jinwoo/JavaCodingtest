package BasicCollection;

import java.util.*;
import java.util.stream.Collectors;

public class ListConcept {
    /// ================================
    /// List - 리스트 (동적배열)
    //  - 동일 참조타입 변수(Variable)들의 가변길이 순차(+연결)리스트
    //      리스트변수 list : Stack 메모리에 리스트객체의 참조값을 저장
    //      리스트값 list.get(i) : Heap 메모리에 저장된 리스트객체의 참조값
    //                            (Wrapper타입의 경우 AutoBoxing & AutoUnboxing 지원으로 리스트값을 원소값으로 취급가능!!)
    //  - ArrayList의 경우 인덱스 직접접근-O(1) 구조
    //  - LinkedList의 경우 순차링크접근-O(N) 구조
    //  - java.util.List 라이브러리 활용
    //  - Collection(Array(List로변환), List, Set, Deque, PQ)간 초기화 가능!
    /// ================================
    /// Collections - 유틸클래스
    //  - 자료구조(List, Collection 등)을 조작하는 정적메서드 제공클래스
    //  - 대부분 List 전용메서드!
    //      max(), min() 만 포괄적 적용
    /// ================================

    public static void ListPractice() {
        System.out.println("================ ListPractice ================");
        listBasic();
        listControl();
        listMethod();
        listSort();
        collectionsMethod();
        System.out.println("\n\n");
    }

    // 1. List 생성 및 초기화
    private static void listBasic() {
        // List 생성
        List<Integer> IntList1 = new ArrayList<>();
        List<Integer> IntList2 = new LinkedList<>();                        // 아주가끔 연결리스트를 써야할 때 사용

        // List 초기화
        List<Integer> IntList3 = new ArrayList<>(IntList1);                 // 새로운 리스트객체 생성 & 참조값 전체복사
                                                                            //    (인자로 Collection<? extends E> 타입을 모두 받을 수 있음)
                                                                            //    (참조값 복사이므로 "얕은복사"지만 Integer는 Immutable객체이므로 깊은복사효과!!)
        Integer[] IntArray = new Integer[]{3, 4, 2, 1, 5};
        List<Integer> IntList4 = new ArrayList<>(List.of(IntArray));        // 새로운 리스트객체 생성 & 참조값 전체복사 (얕은복사)
    }

    // 2. List 삽입 및 삭제 & 접근 및 수정
    private static void listControl() {
        List<Integer> IntList1 = new ArrayList<>();
        Integer[] IntArray = new Integer[]{6, 7, 8};
        List<Integer> IntList2 = new ArrayList<>(List.of(IntArray));
        List<Integer> IntList3;
        List<Integer> IntList4;

        // List 삽입
        IntList1.add(3);                                                    // 맨 마지막에 삽입 - O(1)
        IntList1.add(4);
        IntList1.add(5);
        IntList1.add(1, 4);                                    // idx 1에 삽입 - O(N)
        IntList1.addAll(IntList2);                                          // 맨 마지막에 Collection<? extends E> 삽입

        // List 삭제
        IntList1.remove(3);                                            // 해당위치 삭제 & 순서조정 - O(N)
        IntList1.remove(Integer.valueOf(5));                              // 해당객체 처음부터 찾아서 1개삭제 & 순서조정 - O(N)
        IntList2.clear();                                                   // 리스트 전체원소삭제 (초기화) - O(N)

        // List 접근
        IntList1.get(3);                                                    // 해당위치 원소값 Read - O(1)
        IntList3 = IntList1.subList(2, 4);                                  // index 2 ~ index 4-1 부분의 리스트 참조를 반환
        IntList4 = new ArrayList<>(IntList1.subList(2, 4));                 // index 2 ~ index 4-1 부분의 리스트 참조값을 신규리스트로 얕은복사!

        // List 수정
        IntList1.set(3, 100);                                               // 해당위치 원소값 Write - O(1)
    }

    // 3. List 메서드
    private static void listMethod() {
        Integer[] IntArray = new Integer[]{3, 2, 4, 1, 5};
        List<Integer> IntList1 = new ArrayList<>(List.of(IntArray));

        // List 길이확인 - O(1)
        System.out.println("리스트길이 : " + IntList1.size());

        // List 공백확인 - O(1)
        boolean isEmpty = IntList1.isEmpty();

        // List 객체탐색 - O(N)
        boolean isContains = IntList1.contains(1);                          // Auto-boxing

        // List 인덱스탐색 - O(N)
        int index = IntList1.indexOf(3);                                    // Auto-boxing
    }

    // 4. List 정렬
    private static void listSort() {
        Integer[] IntArray = new Integer[]{3, 2, 4, 1, 5};
        List<Integer> IntList1 = new ArrayList<>(List.of(IntArray));
        String[] StrArray = new String[]{"abc", "def", "ghi"};
//        List<String> StrList = Arrays.stream(StrArray).toList();          // Immutable 리스트 반환!
        List<String> StrList = Arrays.stream(StrArray).collect(Collectors.toCollection(ArrayList::new));
        List<String> StrList2 = new ArrayList<>(List.of(StrArray));

        // List 전체 오름차순 정렬 - O(NlogN)
        Collections.sort(IntList1);
        IntList1.sort(null);
        IntList1.sort(Comparator.naturalOrder());

        // List 전체 내림차순 정렬 - O(NlogN)
        IntList1.sort(Comparator.reverseOrder());

        // List 커스텀 정렬
        IntList1.sort((a, b) -> b - a);
            // 람다식 결과값 < 0 : a<b로 상태유지
            // 람다식 결과값 = 0 : a=b로 상태유지
            // 람다식 결과값 > 0 : a>b로 위치뒤집기!
        StrList.sort((a, b) -> a.length() > b.length() ? -1 : 1);
    }

    // 5. Collections 메서드
    private static void collectionsMethod() {
        Integer[] IntArray = new Integer[]{3, 2, 4, 1, 5};
        List<Integer> IntList1 = new ArrayList<>(List.of(IntArray));
        List<Integer> IntList2 = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        // List 정렬
        Collections.sort(IntList1);
        Collections.sort(IntList1, Collections.reverseOrder());

        // List 뒤집기
        Collections.reverse(IntList1);

        // List 석기
        Collections.shuffle(IntList1);

        // List 인덱스값 위치교환
        Collections.swap(IntList1, 2, 4);

        // List 원소순환
        Collections.rotate(IntList1, 3);                            // idx 1값이 4로 이동됨!!

        // List 전체원소 덮어쓰기
        Collections.fill(IntList1, 10);

        // List 원소복사
        Collections.copy(IntList1, IntList2);                               // IntList2의 길이가 IntList1 길이보다 크거나같아야함

        // List 특정값 전체교체
        Collections.replaceAll(IntList1, 10, 5);

        // 오름차순 정렬된 List 이진탐색 (인덱스반환)
        int idx = Collections.binarySearch(IntList1, 5);
    }
}
