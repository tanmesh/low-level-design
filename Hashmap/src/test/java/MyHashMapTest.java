import org.example.MyHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {
    private MyHashMap<Integer, String> hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new MyHashMap<>();
    }

    @Test
    public void testPutAndGet() {
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");

        Assertions.assertEquals("One", hashMap.get(1));
        Assertions.assertEquals("Two", hashMap.get(2));
        Assertions.assertEquals("Three", hashMap.get(3));
    }

    @Test
    public void testPutDuplicateKey() {
        hashMap.put(1, "One");
        hashMap.put(1, "New One");

        Assertions.assertEquals("New One", hashMap.get(1));
    }

    @Test
    public void testGetNonExistentKey() {
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

        Assertions.assertNull(hashMap.get(3));
    }

    @Test
    public void testGetWithCollision() {
        // Assuming keys hash to the same index due to collision
        hashMap.put(1, "One");
        hashMap.put(17, "Seventeen"); // Should collide with 1

        Assertions.assertEquals("One", hashMap.get(1));
        Assertions.assertEquals("Seventeen", hashMap.get(17));
    }
}
