public class BigNumber {
    // good for when dealing with number that is too long than java allow
    String number;

    public BigNumber(String number) {
        this.number = number + "";
    }

    public BigNumber(int num) {
        this.number = number + "";
    }

    public String toString() {
        return this.number;
    }

    public BigNumber add(BigNumber n2) {
        String answer = "";
        Stack operand1 = new Stack(this.number.length());
        String no2 = n2.toString();
        Stack operand2 = new Stack(no2.length());
        for (int i = 0; i < this.number.length(); i++) {
            operand1.push(this.number.charAt(i) - 48);
        }
        for (int i = 0; i < no2.length(); i++) {
            operand2.push(no2.charAt(i) - 48);
        }
        int size;
        size = Math.max(this.number.length(), no2.length()) + 1;
        Stack result = new Stack(size);
        int carry = 0, ans = 0;
        while (!operand1.isEmpty() || !operand2.isEmpty()) {
            ans = (operand1.isEmpty() ? 0 : operand1.pop()) + (operand2.isEmpty() ? 0 : operand2.pop()) + carry;
            result.push(ans % 10);
            carry = ans / 10;
        }
        if (carry > 0) {
            result.push(carry);
        }
        while (!result.isEmpty()) {
            answer += result.pop();
        }
        return new BigNumber(answer);
    }
}
