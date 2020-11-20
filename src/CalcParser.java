import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CalcParser {
    public final static String[] romeNumber = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    private InputOutputConsole inputOutputConsole = new InputOutputConsole();

    private String[] mainParts;


    public String resultCalcMethod(String primer) {
        mainParts = operation(primer);

        return result();

    }

    private String[] operation(String text) {

        StringBuilder elementOne = new StringBuilder();
        StringBuilder elementTwo = new StringBuilder();
        String operator = "";
        int numberOfOperator = 0;

        char[] chars = text.trim().toCharArray();

        for (char aChar : chars) {
            if (aChar == '+' || aChar == '-' || aChar == '/' || aChar == '*') {
                operator = Character.toString(aChar);
                numberOfOperator++;
            } else if (numberOfOperator == 0) {
                elementOne.append(Character.toString(aChar).toUpperCase());
            } else if (numberOfOperator == 1) {
                elementTwo.append(Character.toString(aChar).toUpperCase());
            }

            if (numberOfOperator > 1) {
                inputOutputConsole.outputToConsole("Неправельный ввод примера");
                inputOutputConsole.outputToConsole("Должен быть один оператор +,-,/,*");
                inputOutputConsole.outputToConsole("Приложение завершает работу");
                System.exit(0);
            }
        }

        String[] partsOfExampl = new String[3];
        partsOfExampl[0] = elementOne.toString();
        partsOfExampl[1] = elementTwo.toString();
        partsOfExampl[2] = operator;
        return partsOfExampl;
    }


    private boolean isArabicNumbers(String text) {
        boolean checkFlag = false;
        try {
            Integer.parseInt(text);
            checkFlag = true;
        } catch (NumberFormatException e) {
            checkFlag = false;
        }

        return checkFlag;
    }

    private boolean isRomeNumber(String text) {
        boolean checkFlag = false;
        for (String s : romeNumber) {
            if (text.equals(s)) {
                checkFlag = true;
            }
        }

        return checkFlag;

    }

    private int romeToArabic(String numberString) {
        for (int i = 0; i < romeNumber.length; i++) {
            if (romeNumber[i].equals(numberString)) {
                if (i == 0) {
                    return 10;
                } else {
                    return i;
                }
            }

        }
        return 0;
    }

    private String arabicToRome(int number) {
        if (number > 10) {
            StringBuilder stringBuilder = new StringBuilder();
            int hun=number/100;
            int lastPartHun=number%100;
            int fiveDec = lastPartHun / 50;
            int lastPartFiveDec = lastPartHun % 50;
            int dec = lastPartFiveDec / 10;
            for (int i = 0; i <hun ; i++) {
                stringBuilder.append("C");
            }
            for (int i = 0; i < fiveDec; i++) {
                stringBuilder.append("L");
            }
            for (int i = 0; i < dec; i++) {
                stringBuilder.append(romeNumber[0]);
            }
            int lastPart = number % 10;
            if (lastPart != 0) {
                stringBuilder.append(romeNumber[lastPart]);
            }
            return stringBuilder.toString();

        } else {
            if (number == 10) {
                return romeNumber[0];
            } else if (number == 0) {
                return "";
            } else {
                return romeNumber[number];
            }
        }
    }


    private String result() {
        if (isArabicNumbers(mainParts[0]) && isArabicNumbers(mainParts[1])) {
            int one = Integer.parseInt(mainParts[0]);
            int two = Integer.parseInt(mainParts[1]);

            int resultArabic = 0;

            if (mainParts[2].equals("+")) {
                resultArabic = one + two;
            } else if (mainParts[2].equals("-")) {
                resultArabic = one - two;
            } else if ((mainParts[2].equals("/")) && two != 0) {
                resultArabic = one / two;
            } else if (mainParts[2].equals("*")) {
                resultArabic = one * two;
            } else {
                inputOutputConsole.outputToConsole("Неверно введены исходные данные деление на 0");
                System.exit(0);
            }
            return String.valueOf(resultArabic);
        } else if (isRomeNumber(mainParts[0]) && isRomeNumber(mainParts[1])) {
            int one = romeToArabic(mainParts[0]);
            int two = romeToArabic(mainParts[1]);
            int resultRome = 0;
            if (mainParts[2].equals("+")) {
                resultRome = one + two;
            } else if (mainParts[2].equals("-")) {
                resultRome = one - two;
            } else if ((mainParts[2].equals("/")) && two != 0) {
                resultRome = one / two;
            } else if (mainParts[2].equals("*")) {
                resultRome = one * two;
            } else {
                inputOutputConsole.outputToConsole("Неверно введены исходные данные деление на 0");
                System.exit(0);
            }
            return arabicToRome(resultRome);
        } else {
            inputOutputConsole.outputToConsole("Неверно ввыдены данные программа прекращает свое действие");
            System.exit(0);
        }

        return "";

    }

}
