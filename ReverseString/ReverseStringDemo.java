package ReverseString;

public class ReverseStringDemo {
    public static void main(String[] args) {
        char[] input = {'R', 'e', 'v', 'e', 'r', 's', 'e', ' ', 'M', 'e', '!'};
        char[] output = reverseString(input);
        for(char c : output)
            System.out.print(c);
    }

    public static char[] reverseString(char[] str) {
        for(int i = 0; i < str.length / 2; i++) {
            str[i] = (char) (str[i] + str[str.length - i - 1]);
            str[str.length - i - 1] = (char) (str[i] - str[str.length - i - 1]);
            str[i] = (char) (str[i] - str[str.length - i - 1]);
        }

        return str;
    }
}
