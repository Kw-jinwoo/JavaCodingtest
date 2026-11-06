package BasicCollection;

import java.util.Arrays;

public class StringConcept {
    /// ================================
    /// String - 문자열 (불변객체)
    //  - 문자열값("str") 할당 후 수정이 불가능한 불변객체
    //      (문자열 재할당은 새로운 메모리 생성 및 값저장 & 참조값을 문자열변수에 저장)
    //      (마치 Wrapper Class처럼 사용!)
    //  - 다양한 문자열메서드 지원
    //      Read / Write(불가) / Search / Parsing / Indexing
    //      (문자열은 불변하므로 메서드를 통한 변경시 반드시 재할당 필요!!)
    //  - 인덱스 직접접근-O(1) 구조
    //  - 별도 라이브러리 없이 String 타입 사용가능!
    /// ================================

    public static void StringPractice() {
        System.out.println("================ StringPractice ================");
        StringBasic();
        StringControl1();
        StringControl2();
        StringMethod();
        StringSort();
        System.out.println("\n\n");
    }

    // 1. String 생성 및 초기화
    private static void StringBasic() {
        // String 생성
        String str1 = "abc";                                            // new 비권장!
                                                                        //      (Java는 StringPool을 사용)
        String str2 = String.valueOf(40);                             // 문자열 형변환!
        String str3 = String.format("%s, %d, %d\n", "abc", 10, 20);     // 형식지정자를 활용한 문자열 초기화
        String str4 = str1 + str2;                                      // '+'를 활용한 문자열붙이기 (저성능, 권장X) -> O(N+M)
    }

    // 2. String 접근 및 교체(수정X -> "재할당이 필요"함!!)
    private static void StringControl1() {
        String str1 = "abc";

        // String 접근
        char c = str1.charAt(1);                                        // 해당위치 문자반환 -> O(1)
        String str2 = str1.substring(0, 2);                             // index 0 ~ index 2-1 부분의 문자열 반환

        // String 부분교체
        str1 = str1.replaceFirst("a", "z");             // 가장 첫 str|regex "a" 하나를 str|regex "z"로 교체 및 반환

        // String 전체교체
        str1 = str1.replace('c', 'd');                   // 모든 char|str 'c'를 char|str 'd'로 교체 및 반환
        str1 = str1.replaceAll("a", "z");               // 모든 str|regex "a"를 str|regex "z"로 교체 및 반환
        str1 = str1.toUpperCase();                                      // 모두 대문자로 교체 및 반환 -> O(N)
        str1 = str1.toLowerCase();                                      // 모두 소문자로 교체 및 반환 -> O(N)
    }

    // 3. String 탐색 및 비교
    private static void StringControl2() {
        String str1 = "abc";
        String str2 = "abd";

        // String 인덱스탐색
        int idx1 = str1.indexOf("b");
        int idx2 = str1.indexOf("bc");                                  // 인자문자열의 첫문자기준 인덱스반환

        // String 문자탐색
        boolean isExists = str1.contains("c");                          // 해당 str의 포함여부를 탐색
        boolean isStarts = str1.startsWith("a");                        // 해당 str로 시작여부를 탐색
        boolean isEnds = str1.endsWith("d");                            // 해당 str로 종료여부를 탐색

        // String 비교
        boolean isEquals = str1.equals(str2);                           // 반드시 equals(str) 메서드를 사용하여 비교!! (==사용금지)
        int compare = str1.compareTo(str2);                             // 사전순 비교결과 반환
            // 음수결과 : a > b
            // 양수결과 : a < b
            // 0 결과 : a.equals(b) 결과는 true
    }

    // 4. String 메서드
    private static void StringMethod() {
        String str1 = "abc";
        String str2 = " abc def ghi ";

        // String 길이확인 -> O(1)
        int length = str1.length();

        // String 공백확인 -> O(1)
        boolean isEmpty = str1.isEmpty();

        // String 파싱 -> String[] 배열로 출력, O(N)
        String[] parsed = str2.split(" ");
        System.out.println(parsed.length);                              // 맨앞 공백문자열은 유지, 맨뒤 공백문자열은 제거 (따라서 결과값 4)

        // String 앞뒤 ASCII 공백제거 및 반환(재할당필요) -> O(N)
        str2 = str2.trim();
        System.out.println(str2);

        // String 앞뒤 UniCode 공백제거 및 반환(재할당필요) -> O(N)
        str2 = str2.strip();
    }

    // 5. String 정렬 및 순회
    private static void StringSort() {
        String str1 = "abcdefg";

        // String 정렬 - char[] 전환 후 배열정렬, O(N)
        char[] charArr1 = str1.toCharArray();
        Arrays.sort(charArr1);

        // String 순회 - char[] 전환 후 배열순회
        char[] charArr2 = str1.toCharArray();
        for(char c : charArr2) {
            System.out.println(c);
        }
    }



    /// ================================
    /// StringBuilder - 고성능 문자열 (가변객체)
    //  - 문자열로부터 생성 후 수정이 가능한 객체
    //      (일반문자열을 인자로 새로운 StringBuilder 객체생성(new))
    //      (toString()으로 StringBuilder에서 일반문자열로 반환)
    //  - 고성능 문자열메서드 지원
    //      Append / Insert / Delete / Set / Indexing
    //  - 인덱스 직접접근-O(1) 구조
    //  - 별도 라이브러리 없이 String 타입 사용가능!
    /// ================================

    public static void StringBuilderPractice() {
        System.out.println("================ StringBuilderPractice ================");
        StringBuilderBasic();
        StringBuilderControl();
        StringBuilderMethod();
        StringBuilderSort();
        System.out.println("\n\n");
    }

    // 1. StringBuilder 생성 및 초기화 & 탐색 및 비교
    private static void StringBuilderBasic() {
        String str1 = "abc";
        String str2 = "def";

        // StringBuilder 생성 -> O(N)
        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);
        String str = sb1.toString();

        // StringBuilder 인덱스탐색 -> O(N)
        int idx1 = sb1.indexOf("b");

        // StringBuilder 문자탐색 불가
        // boolean isExists = sb1.contains("c");
        // boolean isStarts = sb1.startsWith("a");
        // boolean isEnds = sb1.endsWith("d");

        // StringBuilder 비교
        boolean isEquals = sb1.equals(sb2);                             // 문자열 내용이 아닌 "참조동일성을 비교!!"
        int compare = sb1.compareTo(sb2);                               // 사전순 비교결과 반환
    }

    // 2. StringBuilder 삽입 및 삭제 & 접근 및 수정
    private static void StringBuilderControl() {
        StringBuilder sb = new StringBuilder("abc");

        // StringBuilder 삽입
        sb.append("d");                                                 // 맨 마지막에 문자열 삽입 - O(1)
        sb.insert(0, "0");                                    // 해당위치에 문자열 삽입 -> O(N+K)

        // StringBuilder 삭제
        sb.delete(0, 1);                                                // index 0 ~ index 1-1 범위삭제 -> O(N)
        sb.deleteCharAt(sb.length()-1);                           // 해당위치만 삭제 -> O(N)

        // StringBuilder 접근
        char c = sb.charAt(1);                                          // 해당위치 문자 반환 -> O(1)
        String substr = sb.substring(0, 2);                             // index 0 ~ index 2-1 부분의 문자열 반환 -> O(K)

        // StringBuilder 부분교체 (+삽입)
        sb.replace(1, 2, "d");                             // index 1 ~ index 2-1 부분의 문자열 교체 -> O(N+K)
        sb.replace(1, 1, "c");                             // start==end 이므로 교체대상없음 -> 해당위치에 삽입!! -> O(N+K)
        sb.setCharAt(1, 'c');                                  // 해당위치 문자 고성능교체 -> O(1)

        // StringBuilder 전체교체 불가
        // sb.replaceAll("a", "z");                                     // 모든 'a'를 'z'로 교체
        // sb.toUpperCase();                                            // 모두 대문자로 교체
        // sb.toLowerCase();                                            // 모두 소문자로 교체
    }

    // 3. StringBuilder 메서드
    private static void StringBuilderMethod() {
        StringBuilder sb = new StringBuilder("abc");

        // StringBuilder 길이확인 -> O(1)
        int length = sb.length();

        // StringBuilder 공백확인 -> O(1)
        boolean isEmpty = sb.isEmpty();

        // StringBuilder 문자열뒤집기 (StringBuilder만가능!!) -> O(N)
        sb.reverse();

        // StringBuilder 문자열 길이조정 -> O(1) ~ O(K)
        sb.setLength(5);
    }

    // 4. StringBuilder 정렬 및 순회
    private static void StringBuilderSort() {
        String str1 = "abcdefg";
        StringBuilder sb1 = new StringBuilder(str1);

        // StringBuilder 정렬 - String전환 & char[] 전환 후 배열정렬 -> O(NlogN)
        char[] charArr1 = sb1.toString().toCharArray();
        Arrays.sort(charArr1);
        sb1 = new StringBuilder(new String(charArr1));

        // StringBuilder 순회 - String전환 & char[] 전환 후 배열순회 -> O(N)
        char[] charArr2 = sb1.toString().toCharArray();
        for(char c : charArr2) {
            System.out.println(c);
        }
    }
}
