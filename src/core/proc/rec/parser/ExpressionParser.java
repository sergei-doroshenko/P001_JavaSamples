package core.proc.rec.parser;

/**
 * Created by Sergei on 23.02.2015.
 */
public class ExpressionParser {
    public static void main (String[] args) {
        System.out.println(eval("(3*3)"));
    }

    public static int eval(String expr) {

        if (expr.startsWith("(") && expr.endsWith(")")) {
            return eval(expr.substring(1, expr.length() - 1));
        } else if (expr.startsWith("(") && expr.endsWith(")")) {
            throw  new RuntimeException("Wrong expression");
        } else {
            int pos = 0;
            while (pos < expr.length()) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(0, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr.substring(pos + 1));

                    switch (operation) {
                        case '+': return leftOperand + rightOperand;
                        case '-': return leftOperand - rightOperand;
                        case '*': return leftOperand * rightOperand;
                        case '/': return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr);
        }
    }
}
