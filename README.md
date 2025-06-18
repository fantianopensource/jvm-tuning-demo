# JVM Tuning Learning Project

This project contains multiple examples for learning and practicing JVM tuning knowledge.

## Project Structure

```
src/main/java/com/jvm/demo/
├── gc/          # GC related examples
├── memory/      # Memory management examples
├── jit/         # JIT compilation optimization examples
├── classloader/ # Class loading mechanism examples
└── performance/ # Performance optimization examples
```

## Running Examples

### 1. Memory Leak Example (MemoryLeakDemo)

```bash
# Run memory leak example
mvn clean compile exec:java -Dexec.mainClass="com.jvm.demo.memory.MemoryLeakDemo"
```

This example demonstrates memory leak scenarios by continuously allocating memory until OutOfMemoryError occurs.

### 2. GC Example (GCExample)

```bash
# Run GC example
mvn clean compile exec:java -Dexec.mainClass="com.jvm.demo.gc.GCExample"
```

This example demonstrates garbage collection behavior by:
1. Allocating memory in chunks
2. Calling System.gc() to trigger garbage collection
3. Showing memory usage before and after GC

### 3. JIT Compilation Example (JITExample)

```bash
# Run JIT example
mvn clean compile exec:java -Dexec.mainClass="com.jvm.demo.jit.JITExample"
```

This example demonstrates JIT compilation effects by:
1. Running a simple hot method multiple times
2. Showing performance comparison before and after JIT compilation
3. Automatically detecting JIT compilation through performance improvement

The output will show:
- JVM version and vendor information
- Performance comparison before and after JIT compilation
- Performance improvement ratio
- Automatic verification of JIT compilation occurrence

### 4. Class Loader Example (ClassLoaderExample)

```bash
# Run class loader example
mvn clean compile exec:java -Dexec.mainClass="com.jvm.demo.classloader.ClassLoaderExample"
```

This example demonstrates the class loading mechanism by showing the class loader hierarchy.

### 5. Performance Example (PerformanceExample)

```bash
# Run performance optimization examples
mvn clean compile exec:java -Dexec.mainClass="com.jvm.demo.performance.PerformanceExample"
```

This example demonstrates several common performance optimization scenarios:
1. String concatenation vs StringBuilder performance comparison
2. ArrayList pre-allocation impact
3. Boxing/Unboxing overhead in Java
4. Loop optimization techniques

## Common JVM Parameters

### GC Related
- `-XX:+UseG1GC`: Use G1 Garbage Collector
- `-XX:+UseZGC`: Use ZGC Garbage Collector
- `-XX:+UseShenandoahGC`: Use Shenandoah Garbage Collector
- `-XX:+PrintGCDetails`: Print detailed GC information
- `-XX:+PrintGCDateStamps`: Print GC timestamps

### Memory Related
- `-Xms`: Initial heap size
- `-Xmx`: Maximum heap size
- `-XX:NewRatio`: Ratio between new and old generation
- `-XX:SurvivorRatio`: Ratio between Eden and Survivor spaces

### JIT Related
- `-XX:+PrintCompilation`: Print JIT compilation information
- `-XX:+UnlockDiagnosticVMOptions`: Unlock diagnostic options
- `-XX:+PrintInlining`: Print inlining information

### Class Loading Related
- `-verbose:class`: Print class loading information

## Performance Analysis Tools

1. JProfiler
   - Memory analysis
   - CPU analysis
   - Thread analysis

2. VisualVM
   - Memory monitoring
   - Thread monitoring
   - GC monitoring

3. JMC (Java Mission Control)
   - Performance analysis
   - Memory analysis
   - GC analysis

## Learning Recommendations

1. Start with the basics:
   - Understand JVM memory model
   - Learn GC algorithm principles
   - Master class loading mechanism

2. Hands-on practice:
   - Run example programs
   - Observe GC logs
   - Analyze memory usage

3. Performance optimization:
   - Use performance analysis tools
   - Identify performance bottlenecks
   - Optimize JVM parameters

4. Advanced learning:
   - Study characteristics of different GC algorithms
   - Learn JIT compilation optimization
   - Master performance tuning techniques 