package com.designpattern.behavioural.interpreter;


interface Expression {
    int interpret();
}
class Number implements Expression {
    private final int number;

    Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
class Add implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    Add(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }


    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}
class Subtract implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    Subtract(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }


    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}

public class Calculator {
    public static void main(String[] args) {
        Expression expression = new Add(new Number(25), new Subtract(new Number(10), new Number(5)));
        System.out.println("Expression Result: " + expression.interpret());
    }
}
