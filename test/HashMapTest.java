import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HashMapTest {

    @Test
    public void check_for_creating_hashMap_with_integer() throws Exception {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("ant", 10);
        hm.put("zebra", 75);
        int value = hm.get("zebra");
        assertEquals(value, 75);
    }

    @Test
    public void check_for_creating_hashMap_with_float() throws Exception {
        HashMap<String, Float> hm = new HashMap<String, Float>();
        hm.put("ant", (float) 1.1);
        hm.put("zebra", (float) 7.5);
        float value = hm.get("zebra");
        assertEquals(value, (float) 7.5);
    }

    @Test
    public void check_for_creating_hashMap_with_string() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("ant", "insect");
        hm.put("zebra", "animal");
        String value = hm.get("zebra");
        assertEquals(value, "animal");
    }

    @Test
    public void check_for_creating_hashMap_with_string_and_uppercase_key() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Zebra", "animal");
        String value = hm.get("Zebra");
        assertEquals(value, "animal");
    }

    @Test
    public void check_for_creating_hashMap_with_string_and_Spaced_key() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("jack and jil", "went up the hill, To fetch a pail of water.");
        hm.put("jack fell down", "broke his crown, And Jill came tumbling after.");
        String value = hm.get("jack fell down");
        assertEquals(value, "broke his crown, And Jill came tumbling after.");
    }

    @Test
    public void check_for_creating_hashMap_with_string_and_uppercase_key_if_key_name_is_same() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Zebra", "animal");
        hm.put("Zebra", "crossing");
        String value = hm.get("Zebra");
        assertEquals(value, "crossing");
    }

    @Test
    public void check_for_creating_hashMap_with_same_length_string_key() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Ace", "card");
        hm.put("Zebra", "crossing");
        String zebra = hm.get("Zebra");
        assertEquals(zebra, "crossing");
        String ant = hm.get("Ant");
        assertEquals("insect", ant);

    }

    @Test
    public void check_for_creating_hashMap_with_integer_as_key() throws Exception {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "insect");
        hm.put(5, "animal");
        hm.put(9, "crossing");
        String value = hm.get(9);
        assertEquals(value, "crossing");
    }

    @Test
    public void check_for_creating_hashMap_with_integer_as_key_withSame_value() throws Exception {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "insect");
        hm.put(51, "animal");
        hm.put(15, "crossing");
        String value = hm.get(51);
        assertEquals(value, "animal");
    }

    @Test
    public void test_hash_should_give_unique_code_for_a_specific_number() throws Exception {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        assertEquals(hm.hash(1),1);
        assertEquals(hm.hash(2),2);
        assertEquals(hm.hash(21),3);
        assertEquals(hm.hash(12),5);
    }

    @Test
    public void test_isEmpty_returns_true_if_a_map_isEmpty() throws Exception {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        assertTrue(hm.isEmpty());

    }

    @Test
    public void test_isEmpty_returns_false_if_a_map_is_not_Empty() throws Exception {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "insect");
        assertFalse(hm.isEmpty());

    }

    @Test
    public void test_Removes_the_mapping_for_the_specified_key_from_this_map_if_present() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Ace", "card");
        hm.put("Zebra", "crossing");
        String value = hm.remove("Ant");
        assertEquals(value,"insect");
        assertEquals(2,hm.getEntryCount());
    }

    @Test
    public void test_remove_function_gives_null_if_value_is_not_available() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Ace", "card");
        hm.put("Zebra", "crossing");
        Object value = hm.remove("1");
        assertEquals(value,null);
        assertEquals(3,hm.getEntryCount());
    }

    @Test
    public void test_clear_should_Removes_all_of_the_mappings_from_this_map() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Ace", "card");
        hm.put("Zebra", "crossing");
        hm.clear();
        assertEquals(0, hm.getEntryCount());
        assertTrue(hm.isEmpty());
        assertEquals(hm.get("Zebra"),null);
    }

    @Test
    public void test_Returns_true_if_this_map_contains_a_mapping_for_the_specified_key() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Ace", "card");
        hm.put("Zebra", "crossing");
        assertTrue(hm.containsKey("Ace"));
        assertFalse(hm.containsKey("in"));
    }

    @Test
    public void test_Returns_true_if_this_map_maps_one_or_more_keys_to_the_specified_value() throws Exception {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Ant", "insect");
        hm.put("Ace", "card");
        hm.put("Zebra", "crossing");
        assertTrue(hm.containsValue("card"));
        assertFalse(hm.containsValue("in"));
    }
}
