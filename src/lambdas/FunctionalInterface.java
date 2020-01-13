package lambdas;

/**
 * A functional interface is any interface which ONLY HAS ONE ABSTRACT METHOD WITHIN IT.
 * Only such Interfaces can be used for Lambda expressions
 *
 * This annotation will tell others that this is meant to be a Functional Interface and shouldn't be changed
 * Shows an error if changed.
 */
@java.lang.FunctionalInterface
public interface FunctionalInterface {
    int add(int a, int b);
}
