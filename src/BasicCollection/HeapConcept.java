package BasicCollection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapConcept {
    /// ================================
    /// Heap - 정렬된 완전이진트리 (PriorityQueue)
    //  - PriorityQueue<> 가 내부적으로 Heap 구조로 동작
    //  - "최소값 or 최대값을 반복적으로 빠르게 꺼내야 하는 문제"에서 유용 (정렬이나 List기반 활용시 시간초과발생함)
    //  - 최소값 or 최대값 반환시 O-log(N) 보장!
    //  - 시뮬레이션, 라운딩, 스케줄링 유형 문제에 최적의 자료구조
    //  - 순회시 정렬되지 않음 (순회에 사용하지 않음)
    //  - TreeSet<> 과 성격이 비슷하나 중복을 불허하므로 대체될 수 없음!
    /// ================================

    public static void HeapPractice() {
        System.out.println("================ HeapPractice ================");
        priorityQueueBasic();
        System.out.println("\n\n");
    }

    // 1. PriorityQueue 생성 및 초기화 & 삽입 및 삭제
    private static void priorityQueueBasic() {
        // Min-Heap 생성 (minimum값이 높은 우선순위)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Max-Heap 생성 (maximum값이 높은 우선순위)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Custom-Heap 생성
        PriorityQueue<String> customHeap = new PriorityQueue<>((a, b) -> a.length() > b.length() ? 1 : -1);
    }

    // 2. PriorityQueue 삽입 및 삭제 & 접근 및 메서드
    private static void priorityQueueControl() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Heap 삽입
        pq.offer(1);
        pq.add(2);

        // Heap head접근
        int head = 0;
        if (!pq.isEmpty()){
            head = pq.peek();
        }

        // Heap 삭제
        int min = 0;
        if (!pq.isEmpty()) {
            min = pq.poll();
        }
    }
}
