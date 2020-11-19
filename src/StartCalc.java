public class StartCalc {
    public static void main(String[] args) {
        InputOutputConsole inputOutputConsole = new InputOutputConsole();
        inputOutputConsole.outputToConsole("Консольный калькулятор");

        while (true) {
            CalcParser calcParser = new CalcParser();
            String text = inputOutputConsole.inputFromConsole();
            if (text.toLowerCase().equals("exit")) {
                break;
            }

            String result = calcParser.resultCalcMethod(text);

            inputOutputConsole.outputToConsole(result);

        }
    }
}
