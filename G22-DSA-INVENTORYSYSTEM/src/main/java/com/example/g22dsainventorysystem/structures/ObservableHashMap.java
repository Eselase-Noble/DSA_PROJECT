package com.example.g22dsainventorysystem.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class ObservableHashMap<K, V> extends HashMap<K, V> {

    private OnEventListener<K, V> onEventListener;
    private Handler handler; // In case we want the callback methods get called on a different thread.

    public ObservableHashMap() {
        super();

    }

    public ObservableHashMap(int capacity) {
        super(capacity);
    }

    public ObservableHashMap(int capacity, float loadFactor) {
        super(capacity, loadFactor);
    }

    public ObservableHashMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    @Override
    public void clear() {
        super.clear();
      //  notifyClear();
    }

    @Override
    public V put(K key, V value) {
      //  notifyPut(key, value);
        return super.put(key, value);
    }

    @Override
    public V remove(Object key) {
        V v = super.remove(key);
      //  notifyRemove(key, v);
        return v;
    }

    public void setOnEventListener(OnEventListener<K, V> listener) {
        onEventListener = listener;
    }

    public void setOnEventListener(OnEventListener<K, V> listener, Handler handler) {
        this.handler = handler;
        setOnEventListener(listener);
    }

//    private void notifyClear() {
//
//        if (onEventListener != null) {
//            if (handler != null) {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        onEventListener.onClear(ObservableHashMap.this);
//                    }
//                });
//            } else {
//                onEventListener.onClear(this);
//            }
//        }
//
//    }

//    private void notifyPut(final K key, final V value) {
//
//        if (onEventListener != null) {
//            if (handler != null) {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        onEventListener.onPut(ObservableHashMap.this, key, value);
//                    }
//                });
//            } else {
//                onEventListener.onPut(this, key, value);
//            }
//        }
//
//    }

//    @SuppressWarnings("unchecked")
//    private void notifyRemove(final Object key, final V value) {
//
//        if (onEventListener != null) {
//            if (handler != null) {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        onEventListener.onRemove(ObservableHashMap.this, (K) key, value);
//                    }
//                });
//            } else {
//                onEventListener.onRemove(this, (K) key, value);
//            }
//        }
//
//    }

    /**
     * Interface definition for callbacks to be invoked when clear, put, and remove operations are
     * performed on an ObservableHashMap.
     */
    public interface OnEventListener<K, V> {

        void onClear(ObservableHashMap<K, V> map);
        void onPut(ObservableHashMap<K, V> map, K key, V value);
        void onRemove(ObservableHashMap<K, V> map, K key, V value);

    }

}
