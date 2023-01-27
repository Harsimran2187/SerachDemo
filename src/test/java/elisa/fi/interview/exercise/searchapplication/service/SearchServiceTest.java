package elisa.fi.interview.exercise.searchapplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    List<int[]> intlistobj = new ArrayList<>();
    SearchService searchService = new SearchService();

    @BeforeEach
    public void setup() {

        intlistobj.add(new int[]{4, -1, 1, 3});
        intlistobj.add(new int[]{1, 5, 3, 2, 0, 1, -3, -6, -4});
        intlistobj.add(new int[]{5, 1, 0, 4, 10, 6, -3, 2});
    }

    @Test
    void findMinPositiveValueUsingSortMethodTest() {

        intlistobj.forEach(x -> {
            int result = searchService.findMinPositiveValueUsingSortMethod(x);
            assertThat(result).isPositive();
            assertThat(result).isGreaterThan(0);
            assertThat(result).isNotIn(x);
        });
    }

    @Test
    void findMinPositiveValueUsingStreamAPITest() {

        intlistobj.forEach(x -> {
            int result = searchService.findMinPositiveValueUsingStreamAPI(x);
            assertThat(result).isPositive();
            assertThat(result).isGreaterThan(0);
            assertThat(result).isNotIn(x);
        });
    }

    @Test
    void findMinPositiveValueUsingBruteForceTest() {

        intlistobj.forEach(x -> {
            int result = 0;

                result = searchService.findMinPositiveValueUsingBruteForce(x);

            assertThat(result).isPositive();
            assertThat(result).isGreaterThan(0);
            assertThat(result).isNotIn(x);
        });
    }

    @Test
    void findMinPositiveValueUsingHashSetTest() {

        intlistobj.forEach(x -> {
            int result = 0;

                result = searchService.findMinPositiveValueUsingHashSet(x);

            assertThat(result).isPositive();
            assertThat(result).isGreaterThan(0);
            assertThat(result).isNotIn(x);
        });

    }

    @Test
    void findMinPositiveValueUsingMinHeapTest() {

        intlistobj.forEach(x -> {
            int result = 0;

                result = searchService.findMinPositiveValueUsingMinHeap(x);

            assertThat(result).isPositive();
            assertThat(result).isGreaterThan(0);
            assertThat(result).isNotIn(x);
        });


    }

}