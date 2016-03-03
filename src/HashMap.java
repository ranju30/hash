public class HashMap<K, V> {
    private Entry<K, V>[] entries;
    private int entryCount = 0;
    private final int size = 16;

    public HashMap() {
        this.entries = new Entry[size];
    }

    public int hash(K k) {
        double hashCode = 0;
        String strValue = k.toString();
        for (int i = 0; i < strValue.length(); i++) {
            char eachChar = strValue.charAt(i);
            hashCode += Math.pow(((int) eachChar), i + 1);
        }
        return (int) hashCode % size;
    }

    public void put(K k, V v) {
        int index = hash(k);
        entries[index] = new Entry<K, V>(k, v);
        entryCount++;
    }

    public V get(K k) {
        int index = hash(k);
        return entries[index].getValue();
    }

    public boolean isEmpty() {
        return entryCount == 0;
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public V remove(K k) {
        int index = hash(k);
        if (entries[index] != null) {
            V value = entries[index].getValue();
            entries[index].removeValue();
            entryCount--;
            return value;
        }
        return null;
    }

    public void clear() {
        if (entryCount > 0) {
            for (int i = 0; i < size; i++) {
                if (entries[i] != null) {
                    entries[i].removeValue();
                    entryCount--;
                }
            }
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        if (entries[index] != null) {
            return entries[index].getKey() == key;
        }
        return false;

    }

    public boolean containsValue(V value) {
        int countOfValue = 0;
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].getValue() == value) {
                countOfValue++;
            }
        }
        return countOfValue > 0;

    }
}
