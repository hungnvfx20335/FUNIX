public class MyCalculator implements AdvancedArithmetic{
    @Override
    public int divisor_sum(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }

        }
        return answer;
    }
}
