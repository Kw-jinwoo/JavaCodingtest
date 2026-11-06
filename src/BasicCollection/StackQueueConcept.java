package BasicCollection;

import java.util.*;

public class StackQueueConcept {
    /// ================================
    /// Deque - 덱(Double Ended Queue)
    //  - 앞/뒤 모두에서 삽입/삭제 가능
    //  - Stack과 Queue를 모두 대체할 수 있는 자료구조!! (사실상 이것만 사용함!!)
    //  - java.util.ArrayDeque / java.util.Deque 라이브러리 활용 (LinkedList<> 로도 선언가능)
    //  - Collection(Array(List로변환), List, Set, Deque, PQ)간 초기화 가능!
    /// ================================

    public static void DequePractice() {
        System.out.println("================ DequePractice() ================");
        DequeBasic();
        DequeMethod();
        System.out.println("\n\n");
    }

    // 1. Deque 생성 및 초기화 & 탐색 및 삽입 및 삭제
    private static void DequeBasic() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Deque 생성
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>(list);

        // Deque First(idx=0) 확인 -> NPE 방지를 위해 isEmpty check 후 조회, O(1)
        if (!deque2.isEmpty()) {
            int first = deque2.peekFirst();
        }

        // Deque Last(idx=(deque.size()-1)) 확인 -> NPE 방지를 위해 isEmpty check 후 조회, O(1)
        if (!deque2.isEmpty()) {
            int last = deque2.peekLast();
        }

        // Deque First 삽입 -> First에 추가 & 순서조정, O(1)
        deque1.offerFirst(2);
        deque1.offerFirst(1);

        // Deque Last 삽입 -> Last에 추가 & 순서조정, O(1)
        deque1.offerLast(3);
        deque1.offerLast(4);

        // Deque First 삭제 -> First를 삭제하고 반환, O(1)
        if (!deque1.isEmpty()) {
            int first = deque1.pollFirst();
        }

        // Deque Last 삭제 -> Last를 삭제하고 반환, O(1)
        if (!deque1.isEmpty()) {
            int last = deque1.pollLast();
        }
    }

    // 2. Deque 메서드 & 순회
    private static void DequeMethod() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>(list);

        // Deque 길이확인 - O(1)
        int size = deque1.size();

        // Deque 공백확인 - O(1)
        boolean isEmpty = deque2.isEmpty();

        // Deque 순회
        for (int i : deque2) {
            System.out.print(i);
        }
    }


    /// ================================
    /// Stack - 스택(LIFO)
    //  - 가장 최근 데이터부터 처리 (like 디스펜서)
    //  - Deque<> 타입을 활용하고 ArrayDeque<>()로 선언!
    //  - java.util.ArrayDeque / java.util.Deque 라이브러리 활용
    //  - Collection(Array(List로변환), List, Set, Deque, PQ)간 초기화 가능!
    /// ================================

    public static void StackPractice() {
        System.out.println("================ StackPractice() ================");
        StackBasic();
        System.out.println("\n\n");
    }

    // 1. Stack 생성 및 초기화 & 삽입 및 삭제
    private static void StackBasic() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Stack 생성
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>(list);

        // Stack TOP 확인 -> NPE 방지를 위해 isEmpty check 후 조회, O(1)
        if (!stack2.isEmpty()) {
            int top = stack2.peek();
        }

        // Stack 삽입 -> TOP(idx=0)에 추가 & 순서조정, O(1)
        stack1.push(1);
        stack1.push(2);

        // Stack 삭제 -> TOP(idx=0)을 삭제하고 반환, O(1)
        if (!stack2.isEmpty()) {
            int top = stack2.pop();
        }
    }


    /// ================================
    /// Queue - 큐(FIFO)
    //  - 먼저 들어온 데이터부터 처리 (like 줄세우기)
    //  - Deque<> 타입을 활용하고 ArrayDeque<>()로 선언!
    //  - java.util.ArrayDeque / java.util.Deque 라이브러리 활용
    //  - Collection(Array(List로변환), List, Set, Deque, PQ)간 초기화 가능!
    /// ================================

    public static void QueuePractice() {
        System.out.println("================ QueuePractice() ================");
        QueueBasic();
        System.out.println("\n\n");
    }

    // 1. Queue 생성 및 초기화 & 삽입 및 삭제
    private static void QueueBasic() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Queue 생성
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>(list);

        // Queue Front 확인 -> NPE 방지를 위해 isEmpty check 후 조회, O(1)
        if (!queue2.isEmpty()) {
            int front = queue2.peek();
        }

        // Queue 삽입 -> Rear(idx=(queue.size()-1))에 추가 & 순서조정, O(1)
        queue1.offer(1);
        queue1.offer(2);

        // Queue 삭제 -> Front(idx=0)을 삭제하고 반환, O(1)
        if (!queue2.isEmpty()) {
            int front = queue2.pop();
        }
    }
}
