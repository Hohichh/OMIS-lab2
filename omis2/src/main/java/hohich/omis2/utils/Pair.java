package hohich.omis2.utils;

public class Pair<T, U> {
    private final T first; // Первый объект
    private final U second; // Второй объект

    // Конструктор
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Геттер для первого объекта
    public T getFirst() {
        return first;
    }

    // Геттер для второго объекта
    public U getSecond() {
        return second;
    }

    // Переопределение метода toString() для удобного вывода
    @Override
    public String toString() {
        return first.toString() + " - " + second.toString();
    }

    // Переопределение equals() для сравнения двух пар
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    // Переопределение hashCode() для использования в коллекциях
    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}

