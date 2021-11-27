package calculator;

public class StringAddCalculator {
    /**
     * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
     * if (text == null || text.isEmpty()) {}
     *
     * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
     * int number = Integer.parseInt(text);
     *
     * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
     * String[] numbers = text.split(",");
     * // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
     *
     * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
     * String[] tokens= text.split(",|:");
     *
     * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
     * // java.util.regex 패키지의 Matcher, Pattern import
     * Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
     * if (m.find()) {
     *     String customDelimiter = m.group(1);
     *     String[] tokens= m.group(2).split(customDelimiter);
     *     // 덧셈 구현
     * }
     *
     * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
     * @param o
     * @return
     */
    public static int splitAndSum(Object o) {

        return 0;
    }
}
