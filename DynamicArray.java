public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 8;
    private Object[] data;
    private int size;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Capacity cannot be negative");
        data = new Object[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    public void addLast(T element) {
        if (size == data.length) {
            resize(data.length == 0 ? DEFAULT_CAPACITY : data.length * 2);
        }
        data[size++] = element;
    }

    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null; // help GC
        // Optional: shrink when size < capacity/4
        if (size > 0 && size < data.length / 4) {
            resize(data.length / 2);
        }
        return true;
    }

    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(data[i])) return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return (T[]) result;
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}