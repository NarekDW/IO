package com.epam.courses.io.t01;

/**
 * Date: 28.01.2017
 * @author Karapetyan N.K
 */
public abstract class Const {
    /**
     * @param KEYWORDS  - это regex всех зарезервированных языком Java слов.
     * */
    public static final String KEYWORDS =
            "(abstract|continue|for|new|switch|" +
                    "assert|default|goto|package|synchronized|" +
                    "boolean|do|if|private|this|" +
                    "break|double|implements|protected|throw|" +
                    "byte|else|import|public|throws|" +
                    "case|enum|instanceof|return|transient|" +
                    "catch|extends|int|short|try|" +
                    "char|final|interface|static|void|" +
                    "class|finally|long|strictfp|volatile|" +
                    "const|float|native|super|while)[^\\w]";
}
