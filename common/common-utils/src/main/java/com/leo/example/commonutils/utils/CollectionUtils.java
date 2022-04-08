package com.leo.example.commonutils.utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.leo.example.commonutils.staticdata.CodeItemVo;
import org.springframework.data.domain.Page;

public class CollectionUtils {
    private static final Set<Collector.Characteristics> FINISH;

    static {
        FINISH = EnumSet.of(Collector.Characteristics.IDENTITY_FINISH);
    }

    public CollectionUtils() {
    }

    public static boolean isEmpty(final Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(final Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Page<?> page) {
        return page == null || !page.hasContent();
    }

    public static <T> boolean contains(Collection<T> coll, T value) {
        return isEmpty(coll) ? false : coll.contains(value);
    }

    public static <T> List<T> asList(T... arr) {
        if (isEmpty(arr)) {
            return new ArrayList();
        } else {
            List<T> list = new ArrayList(arr.length);
            Object[] var5 = arr;
            int var4 = arr.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                T t = (T) var5[var3];
                if (t != null) {
                    list.add(t);
                }
            }

            return list;
        }
    }

    public static <K, V> V getMapByKey(Map<K, V> map, K key) {
        return isEmpty(map) ? null : map.get(key);
    }

    public static <T> Collection<T> merge(Collection<?>... arr) {
        if (isEmpty((Object[])arr)) {
            return null;
        } else if (arr.length == 1) {
            return (Collection<T>) arr[0];
        } else {
            List<Object> list = new ArrayList();
            Collection[] var5 = arr;
            int var4 = arr.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                Collection<?> coll = var5[var3];
                if (!isEmpty(coll)) {
                    list.addAll(coll);
                }
            }

            return (Collection<T>) list;
        }
    }

    public static <T> List<T> merge(List<?>... arr) {
        if (isEmpty((Object[])arr)) {
            return null;
        } else if (arr.length == 1) {
            return (List<T>) arr[0];
        } else {
            List<Object> list = new ArrayList();
            List[] var5 = arr;
            int var4 = arr.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                List<?> coll = var5[var3];
                if (!isEmpty((Collection)coll)) {
                    list.addAll(coll);
                }
            }

            return (List<T>) list;
        }
    }

    public static <T> T getFirst(List<T> list) {
        return isEmpty((Collection)list) ? null : list.get(0);
    }

    public static <T> void addArray(Collection<T> collection, T[] elements) {
        if (collection != null && !isEmpty(elements)) {
            Object[] var5 = elements;
            int var4 = elements.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                T t = (T) var5[var3];
                if (t != null) {
                    collection.add(t);
                }
            }

        }
    }

    public static <T> void addCollection(Collection<T> collection, Collection<T> elements) {
        if (collection != null && !isEmpty(elements)) {
            Iterator var3 = elements.iterator();

            while(var3.hasNext()) {
                T t = (T) var3.next();
                if (t != null) {
                    collection.add(t);
                }
            }

        }
    }

    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        return toMap(keyMapper, valueMapper, true);
    }

    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, boolean coverValue) {
        return toMap(HashMap::new, keyMapper, valueMapper, coverValue);
    }

    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toLinkedHashMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        return toMap(LinkedHashMap::new, keyMapper, valueMapper, true);
    }

    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toConcurrentMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        return toMap(ConcurrentHashMap::new, keyMapper, valueMapper, true);
    }

    private static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(Supplier<Map<K, U>> supplier, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, boolean coverValue) {
        BiConsumer<Map<K, U>, T> accumulator = (map, element) -> {
            if (coverValue) {
                map.put(keyMapper.apply(element), valueMapper.apply(element));
            } else {
                map.putIfAbsent(keyMapper.apply(element), valueMapper.apply(element));
            }

        };
        BinaryOperator<Map<K, U>> margeOperator = (k1, k2) -> {
            return k2;
        };
        return new CollectionUtils.CollectorImpl(supplier, accumulator, margeOperator);
    }

    public static <T> Collection<String> getCodes(Collection<T> coll, Function<T, String> fun) {
        if (isEmpty(coll)) {
            return null;
        } else {
            Collection<String> codes = new HashSet();
            getCodes(codes, coll, fun);
            return codes;
        }
    }

    public static <T> List<String> getCodesToList(Collection<T> coll, Function<T, String> fun) {
        if (isEmpty(coll)) {
            return null;
        } else {
            List<String> codes = new ArrayList();
            getCodes(codes, coll, fun);
            return codes;
        }
    }

    public static <T> void getCodes(Collection<String> codes, Collection<T> coll, Function<T, String> fun) {
        Iterator var4 = coll.iterator();

        while(var4.hasNext()) {
            T t = (T) var4.next();
            String c = (String)fun.apply(t);
            if (!StringUtils.isEmpty(c)) {
                codes.add(c);
            }
        }

    }

    public static <T> Collection<String> getCodes(T[] arr, Function<T, String> fun) {
        if (isEmpty(arr)) {
            return null;
        } else {
            Collection<String> codes = new HashSet();
            addCodes(codes, arr, fun);
            return codes;
        }
    }

    public static <T> void addCodes(Collection<String> codes, T[] arr, Function<T, String> fun) {
        if (!isEmpty(arr)) {
            Object[] var6 = arr;
            int var5 = arr.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                T t = (T) var6[var4];
                String c = (String)fun.apply(t);
                if (!StringUtils.isEmpty(c)) {
                    codes.add(c);
                }
            }

        }
    }

    public static <K, T> Map<K, T> toMap(Collection<T> coll, Function<T, K> keyFun) {
        return isEmpty(coll) ? null : (Map)coll.stream().collect(toMap(keyFun, (t) -> {
            return t;
        }));
    }

    public static int getSize(Collection<?> list) {
        return isEmpty(list) ? 0 : list.size();
    }

    public static int getSize(Object[] arr) {
        return isEmpty(arr) ? 0 : arr.length;
    }

    public static void main(String[] args) {
        List<CodeItemVo> list = new ArrayList();
        list.add(new CodeItemVo("111", "AAA"));
        list.add(new CodeItemVo("222", "BBB"));
        list.add(new CodeItemVo((String)null, (String)null));
        Map<String, String> map = (Map)list.stream().collect(toMap(CodeItemVo::getValue, CodeItemVo::getName));
        System.out.println(map);
        map = (Map)list.stream().collect(Collectors.toMap(CodeItemVo::getValue, CodeItemVo::getName));
        System.out.println(map);
    }

    private static class CollectorImpl<T, A, R> implements Collector<T, A, R> {
        private final Supplier<A> supplier;
        private final BiConsumer<A, T> accumulator;
        private final BinaryOperator<A> combiner;

        private CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner) {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.combiner = combiner;
        }

        public BiConsumer<A, T> accumulator() {
            return this.accumulator;
        }

        public Supplier<A> supplier() {
            return this.supplier;
        }

        public BinaryOperator<A> combiner() {
            return this.combiner;
        }

        public Function<A, R> finisher() {
            return (i) -> {
                return (R) i;
            };
        }

        public Set<Characteristics> characteristics() {
            return CollectionUtils.FINISH;
        }
    }
}
