package com.example.rahul.dragtest;

import android.view.View;

import java.util.List;

/**
 * Created by rahul on 11/6/15.
 */
public class DynamicGridUtils {

    /**
     * Delete item in <code>list</code> from position <code>indexFrom</code> and insert it to <code>indexTwo</code>
     *
     * @param list
     * @param indexFrom
     * @param indexTwo
     */
    public static void reorder(List list, int indexFrom, int indexTwo) {
        Object obj = list.remove(indexFrom);
        list.add(indexTwo, obj);
    }

    /**
     * Swap item in <code>list</code> at position <code>firstIndex</code> with item at position <code>secondIndex</code>
     *
     * @param list The list in which to swap the items.
     * @param firstIndex The position of the first item in the list.
     * @param secondIndex The position of the second item in the list.
     */
    public static void swap(List list, int firstIndex, int secondIndex) {
        Object firstObject = list.get(firstIndex);
        Object secondObject = list.get(secondIndex);
        list.set(firstIndex, secondObject);
        list.set(secondIndex, firstObject);
    }

    public static float getViewX(View view) {
        return Math.abs((view.getRight() - view.getLeft()) / 2);
    }

    public static float getViewY(View view) {
        return Math.abs((view.getBottom() - view.getTop()) / 2);
    }
}
