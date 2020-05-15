package com.siit.homework.course11.ibm.streams.tutorial.exercise4;

public interface Translator {

    String translate(String input);

    enum Languages implements Translator {
        REVERSISH {
            @Override
            public String translate(String input) {
                return new StringBuilder(input).reverse().toString();
            }
        }

    }

}

