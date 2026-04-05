package com.mariofernandes.javapoc.skiplists.v2;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
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

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({ Mode.Throughput, Mode.AverageTime })
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(1)
public class SkipListsMixedBenchmark {
    @Param({"1000", "10000", "100000"})
    int size;

    private SkipLists skipLists;
    private ConcurrentSkipListMap<Integer, Long> concurrentSkipListMap;

    @Setup
    public void setup() {
        skipLists = new SkipLists(16);
        concurrentSkipListMap = new ConcurrentSkipListMap<>();
    }

    @Benchmark
    @Threads(8)
    public void testMySkipListsMixed(Blackhole bh) {
        var key = ThreadLocalRandom.current().nextInt(size);
        skipLists.insert(key, key);
        bh.consume(skipLists.search(key));
    }

    @Benchmark
    @Threads(8)
    public void testConcurrentSkipListMixed(Blackhole bh) {
        var key = ThreadLocalRandom.current().nextInt(size);
        concurrentSkipListMap.put(key, (long) key);
        bh.consume(concurrentSkipListMap.get(key));
    }
}
