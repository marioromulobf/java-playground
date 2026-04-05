package com.mariofernandes.javapoc.skiplists.v2;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode({ Mode.Throughput, Mode.AverageTime })
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(1)
public class SkipListsSearchBenchmark {
    @Param({"1000", "10000", "100000"})
    int size;

    private SkipLists skipLists;
    private ConcurrentSkipListMap<Integer, Long> concurrentSkipListMap;

    @Setup(Level.Trial)
    public void setup() {
        skipLists = new SkipLists(16);
        concurrentSkipListMap = new ConcurrentSkipListMap<>();
        List<Integer> keys = IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(keys);
        for (int i : keys) {
            skipLists.insert(i, i);
            concurrentSkipListMap.put(i, (long) i);
        }
    }

    @Benchmark
    @Threads(8)
    public void testMySkipListsSearch(Blackhole bh) {
        var key = (int) (Math.pow(ThreadLocalRandom.current().nextDouble(), 2) * size);
        bh.consume(skipLists.search(key));
    }

    @Benchmark
    @Threads(8)
    public void testConcurrentSkipListSearch(Blackhole bh) {
        var key = (int) (Math.pow(ThreadLocalRandom.current().nextDouble(), 2) * size);
        bh.consume(concurrentSkipListMap.get(key));
    }
}
