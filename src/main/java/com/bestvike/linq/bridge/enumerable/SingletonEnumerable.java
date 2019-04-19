package com.bestvike.linq.bridge.enumerable;

import com.bestvike.collections.generic.IList;
import com.bestvike.linq.IEnumerator;
import com.bestvike.linq.bridge.enumerator.SingletonEnumerator;
import com.bestvike.linq.exception.Errors;
import com.bestvike.linq.util.ArrayUtils;
import com.bestvike.linq.util.ListUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by 许崇雷 on 2019-04-10.
 */
public final class SingletonEnumerable<TSource> implements IList<TSource> {
    private final TSource element;

    public SingletonEnumerable(TSource element) {
        this.element = element;
    }

    @Override
    public IEnumerator<TSource> enumerator() {
        return new SingletonEnumerator<>(this.element);
    }

    @Override
    public TSource get(int index) {
        if (index == 0)
            return this.element;
        throw Errors.argumentOutOfRange("index");
    }

    @Override
    public Collection<TSource> getCollection() {
        return ArrayUtils.toCollection(new Object[]{this.element});
    }

    @Override
    public int _getCount() {
        return 1;
    }

    @Override
    public boolean _contains(TSource item) {
        return Objects.equals(item, this.element);
    }

    @Override
    public void _copyTo(Object[] array, int arrayIndex) {
        array[arrayIndex] = this.element;
    }

    @Override
    public TSource[] _toArray(Class<TSource> clazz) {
        return ArrayUtils.singleton(clazz, this.element);
    }

    @Override
    public Object[] _toArray() {
        return ArrayUtils.singleton(this.element);
    }

    @Override
    public List<TSource> _toList() {
        return ListUtils.singleton(this.element);
    }
}