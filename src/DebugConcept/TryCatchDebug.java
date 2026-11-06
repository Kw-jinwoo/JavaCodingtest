package DebugConcept;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TryCatchDebug {
    /// ================================
    /// Try-Catch Debug - 예외처리 구조로 디버깅하기
    //  - 문제풀이 코드 전체를 try-catch문으로 감싸기
    //  - catch 문에서 printStackTrace()를 활용해 에러 출력하기
    //      에러종류 / 에러위치 등의 부가정보를 얻어내기!!
    //  - 리플랙션 Arrays.toString(Collection.class.getMethods()).replace(",", ",\n"));
    //  - 별도 라이브러리 없이 사용가능!
    /// ================================

    public static void TryCatchPractice() {
        System.out.println("================ TryCatchPractice ================");
        TryCatchBasic();
        System.out.println("\n\n");
    }

    private static void TryCatchBasic() {
        // try-catch문 작성
        try {
            // 에러종류 & 에러위치 파악하기
            int value = 10 / 0;

            // 메서드의 리턴type을 모를 때 간단히 에러로 체크하기
            List<String> list = new LinkedList<>();
//            String unknownType = list.iterator();                                   // 일단 String으로 받아서 에러출력!

            // 리플렉션 활용해서 해당 클래스의 메서드 출력하기!!
            Class c = Class.forName("java.lang.String");
            System.out.println(Arrays.toString(c.getMethods()).replace(",",",\n"));
                                                                                      // .getMethods()는 Array로 반환됨
            System.out.println();
            System.out.println(Arrays.toString(LinkedList.class.getMethods()).replace(",",",\n"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
