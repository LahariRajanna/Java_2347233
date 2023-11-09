public class StringBuffer {
    public static void main(String[] args) {
        // Creating a MyStringBuffer
        MyStringBuffer stringBuffer = new MyStringBuffer("Hello");

        // 1. append()
        stringBuffer.append(" World");
        System.out.println("append(): " + stringBuffer);

        // 2. insert()
        stringBuffer.insert(5, " Java");
        System.out.println("insert(): " + stringBuffer);

        // 3. replace()
        stringBuffer.replace(6, 11, "Christ");
        System.out.println("replace(): " + stringBuffer);

        // 4. delete()
        stringBuffer.delete(0, 6);
        System.out.println("delete(): " + stringBuffer);

        // 5. charAt()
        char charAtResult = stringBuffer.charAt(2);
        System.out.println("charAt(): " + charAtResult);

        // 6. setCharAt()
        stringBuffer.setCharAt(0, 'X');
        System.out.println("setCharAt(): " + stringBuffer);

        // 7. length()
        int lengthResult = stringBuffer.length();
        System.out.println("length(): " + lengthResult);

        // 8. capacity()
        int capacityResult = stringBuffer.capacity();
        System.out.println("capacity(): " + capacityResult);

        // 9. ensureCapacity()
        stringBuffer.ensureCapacity(20);
        System.out.println("ensureCapacity(): " + stringBuffer);

        // 10. toString()
        String toStringResult = stringBuffer.toString();
        System.out.println("toString(): " + toStringResult);

        // 11. substring(int start)
        String substringResult1 = stringBuffer.substring(2);
        System.out.println("substring(int start): " + substringResult1);

        // 12. substring(int start, int end)
        String substringResult2 = stringBuffer.substring(2, 6);
        System.out.println("substring(int start, int end): " + substringResult2);
    }
}

class MyStringBuffer {
    private StringBuilder buffer;

    public MyStringBuffer(String initial) {
        this.buffer = new StringBuilder(initial);
    }

    public void append(String str) {
        buffer.append(str);
    }

    public void insert(int index, String str) {
        buffer.insert(index, str);
    }

    public void replace(int start, int end, String str) {
        buffer.replace(start, end, str);
    }

    public void delete(int start, int end) {
        buffer.delete(start, end);
    }

    public char charAt(int index) {
        return buffer.charAt(index);
    }

    public void setCharAt(int index, char ch) {
        buffer.setCharAt(index, ch);
    }

    public int length() {
        return buffer.length();
    }

    public int capacity() {
        return buffer.capacity();
    }

    public void ensureCapacity(int minCapacity) {
        buffer.ensureCapacity(minCapacity);
    }

    @Override
    public String toString() {
        return buffer.toString();
    }

    public String substring(int start) {
        return buffer.substring(start);
    }

    public String substring(int start, int end) {
        return buffer.substring(start, end);
    }
}