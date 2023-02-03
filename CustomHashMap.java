import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<K, V> {
    private class Entry<K, V> {
        private K key;
        private V value;

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
    }

    private int capacity = 16;
    private List<List<Entry<K, V>>> buckets;

    public CustomHashMap() {
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void put(K key, V value) {
        int index = key.hashCode() % capacity;
        List<Entry<K, V>> bucket = buckets.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = key.hashCode() % capacity;
        List<Entry<K, V>> bucket = buckets.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
