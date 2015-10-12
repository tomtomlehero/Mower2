package fr.mla.mower2.core.interpreter;

import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.util.exception.ConfigurationException;

import java.util.ArrayList;
import java.util.List;

public class Parser {


    private List<Expression> expressions = new ArrayList<>();

    public Parser(List<String> lines) {

        for (int i = 0; i < lines.size(); i++) {

            if (i == 0) {
                expressions.add(new GardenInitializationExpression(lines.get(i)));
            } else if ((i % 2) == 1) {
                expressions.add(new MowerInitialPositionExpression(lines.get(i), (i / 2) + 1));
            } else if ((i % 2) == 0) {
                expressions.add(new MowerInstructionsExpression(lines.get(i), i / 2));
            }

        }
    }


    public MowItNowConfiguration evaluate() throws ConfigurationException {

        Context context = new Context();

        for (Expression expression : expressions) {
            expression.interpret(context);
        }


        int mowerCount = expressions.size() / 2;
        if ((mowerCount > 0) && (expressions.size() % 2 == 0)) {
            throw new ConfigurationException(String.format("Mower #%d has nothing to do...", mowerCount));
        }

        return context.getOutput();

    }

}
