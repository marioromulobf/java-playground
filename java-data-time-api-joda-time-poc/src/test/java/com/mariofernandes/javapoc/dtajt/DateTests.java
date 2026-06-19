package com.mariofernandes.javapoc.dtajt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DateTests {
    @Test
    void testMonthJanuaryZeroBased() {
        Date date = new Date(2026, Calendar.JANUARY, 1);

        Assertions.assertEquals(Calendar.JANUARY, date.getMonth());
        Assertions.assertEquals(0, date.getMonth());
    }

    @Test
    void testMonthDecemberZeroBased() {
        Date date = new Date(2026, Calendar.DECEMBER, 1);

        Assertions.assertEquals(Calendar.DECEMBER, date.getMonth());
        Assertions.assertEquals(11, date.getMonth());
    }

    @Test
    void testMutableDate() {
        Date dateNow = new Date();
        Map<Date, String> map = Map.of(dateNow, "Date changed");
        Long timeStampBefore = dateNow.getTime();

        dateNow.setTime(timeStampBefore + 86400000); // increment one day

        Assertions.assertNotEquals(timeStampBefore, dateNow.getTime());
        Assertions.assertEquals(timeStampBefore + 86400000, dateNow.getTime());
        Assertions.assertEquals("Date changed", map.get(dateNow));
    }

    @Test
    void testTread() throws InterruptedException, RuntimeException {
        final Date sharedDate = new Date();
        final long timeStampBefore = sharedDate.getTime();

        List<Callable<Long>> tasks = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        tasks.add(() -> {
            sharedDate.setTime(sharedDate.getTime() + 1);
            return sharedDate.getTime();
        });
        tasks.add(() -> {
            sharedDate.setTime(sharedDate.getTime() + 1);
            return sharedDate.getTime();
        });

        List<Future<Long>> result = executor.invokeAll(tasks, 2, TimeUnit.SECONDS);
        Assumptions.assumeTrue(result.size() == 2);
        for (int i = 0; i < result.size(); i++) {
            try {
                Assertions.assertEquals(timeStampBefore + i + 1,  result.get(i).get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        Assertions.assertEquals(timeStampBefore + 2,  sharedDate.getTime());
    }

    @Test
    void test() {

    }
}
