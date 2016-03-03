public class Entry<K, V> {
    final K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void removeValue() {
        this.value = null;
    }
}
