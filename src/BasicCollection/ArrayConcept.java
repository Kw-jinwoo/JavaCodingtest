package BasicCollection;// import java.util.*;                              -> 필수헤더
import java.util.Arrays;
import java.util.Comparator;

public class ArrayConcept {
    /// ================================
    /// Array - 배열
    //  - 동일타입 변수(Variable)들의 고정길이 순차리스트
    //      배열변수 arr : Stack 메모리에 배열객체의 참조값을 저장
    //      배열값 arr[i] : Heap 메모리에 저장된 배열객체의 원소값
    //                     (원소값은 기본형값 or 참조값 (참조값은 주소값이 아닌 JVM이 이해하는 메모리 위치값 형태 != 포인터))
    //  - 인덱스 직접접근-O(1) RandomAccess 구조
    //  - java.util.Arrays 라이브러리 활용
    //  - Collection(List, Set, Deque, PQ)에서 즉시초기화 불가
    //      (Collection.toArray(new Type[]) 메서드 활용시 변환가능)
    /// ================================

    public static void ArrayPractice() {
        System.out.println("================ ArrayPractice ================");
        arrayBasic();
        arrayMethod();
        arraySort();
        System.out.println("\n\n");
    }

    // 1. Array 생성 및 초기화
    private static void arrayBasic() {
        // 기본형Array
        int[] intArr1 = new int[]{1, 2, 3, 4, 5};
        int lastElm = intArr1[intArr1.length - 1];                  // 마지막 원소값 접근
        int[] intArr2 = Arrays.copyOf(intArr1, intArr1.length);     // 새로운 배열객체 생성 & 원소값 전체 복사
        int[] intArr3 = Arrays.copyOfRange(intArr1, 2, 4); // "index 2부터 index 4-1"까지 부분 복사

        // 참조형Array
        Integer[] IntArr1 = new Integer[]{1, 2, 3, 4, 5};
//        Integer[] IntArr2 = Arrays.copyOf(intArr1, intArr1.length);  -> 배열변수 AutoBoxing 불가
        Integer[] IntArr2 = Arrays.copyOf(IntArr1, IntArr1.length);

        // 커스텀객체 참조형Array
        Node[] NodeArr1 = new Node[3];
        for (int i = 0; i < 3; i++) {
            NodeArr1[i] = new Node(i);
        }
        Node[] NodeArr2 = Arrays.copyOf(NodeArr1, NodeArr1.length); // 새로운 배열객체 생성 & 원소값(참조값) 복사, 이므로 실제로 얕은복사!!

        // 2차원Array
        int[][] intArr2D1 = new int[][]{{1, 2}, {3, 4}, {5, 6}};    // 3행 2열, 배열의 배열로 생성함로 JaggedArray 가능
        int[][] intArr2D2 = new int[intArr2D1.length][intArr2D1[0].length];
        for (int i = 0; i < intArr2D1.length; i++) {                // 2차원 배열은 배열의 배열으로 참조값 복사, 이므로 실제로 앝은복사기 때문에 행단위 직접순회복사!!
            intArr2D2[i] = Arrays.copyOf(intArr2D1[i], intArr2D1.length);
        }
    }

    // 2. Array 메서드
    private static void arrayMethod() {
        int[] intArr1 = new int[]{1, 2, 3, 4, 5};
        int[] intArr2 = new int[]{3, 4, 5, 6};

        // Array 길이확인 - O(1)
        System.out.println("배열길이 : " + intArr1.length);

        // Array 동등비교 - O(N)
        boolean isEqual = Arrays.equals(intArr1, intArr2);          // 배열 길이비교 > 각 배열의 원소값 순회비교-O(N)
        System.out.println("배열동등비교 : " + isEqual);

        // Array 크기비교 - O(N)
        int compareResult = Arrays.compare(intArr1, intArr2);       // 각 배열의 원소값 순회비교-O(N) > 배열 길이비교
        System.out.println("배열크기비교 : " + compareResult);        // 음수의 경우 intArr1 < intArr2
                                                                    // 0의 경우 Arrays.equals(intArr1, intArr2)는 true
                                                                    // 양수의 경우 intArr1 > intArr2

        // Array 출력
        System.out.println("배열출력 : " + Arrays.toString(intArr2));// 원소값 순회출력-O(N)
    }

    // 3. Array 정렬
    private static void arraySort() {
        int[] intArr1 = new int[]{3, 2, 4, 1, 5};
        int[] intArr2 = new int[]{3, 6, 7, 2};
        Integer[] IntArr1 = new Integer[]{3, 2, 4, 1, 5};
        Integer[] IntArr2 = new Integer[]{3, 6, 7, 2};

        // Array 전체 오름차순 정렬 - O(NlogN) ~ O(N^2)
        Arrays.sort(intArr1);

        // Array 부분 오름차순 정렬 (toIndex 미포함)
        Arrays.sort(intArr2, 1, 4);

        // 참조형Array 전체 내림차순 정렬
        Arrays.sort(IntArr1, Comparator.reverseOrder());

        // 기본형Array 전체 내림차순 정렬
        int[] intArr3 = Arrays.stream(intArr2)
                .boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        // 참조형Array 커스텀 정렬
        Arrays.sort(IntArr2, (a, b) -> b - a);
            // 람다식 결과값 < 0 : a<b로 상태유지
            // 람다식 결과값 = 0 : a=b로 상태유지
            // 람다식 결과값 > 0 : a>b로 뒤집기!
    }
}

class Node {
    Node(int num) {
        this.num = num;
    }
    int num;
    Node next;
}
