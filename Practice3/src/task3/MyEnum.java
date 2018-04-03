package task3;

import java.io.Serializable;

public abstract class MyEnum<E extends MyEnum<E>>
        implements Comparable<E>, Serializable {
    private final String name;
    private final int ordinal;

    protected MyEnum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public final String getName() {
        return name;
    }

    public final int getOrdinal() {
        return ordinal;
    }

    public final String toString() {
        return name;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final int compareTo(E o) {
        MyEnum<?> myEnum = o;
        return this.ordinal - myEnum.ordinal;
    }
}