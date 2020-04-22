/*
 * Copyright 2020 appmanch-commons project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appmanch.commons.lang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ArrayUtils {

    /**
     * Check if the array is empty or null.
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(final Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Check if an arry has item
     *
     * @param array
     * @return
     */
    public static boolean isNotEmpty(final Object[] array) {
        return array != null && array.length > 0;
    }

    /**
     * Converts the array to a List <br>
     * If the input is empty/null returns a empty {@link List}
     *
     * @param array
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> List<T> toList(final T[] array) {
        List list = new ArrayList();
        if (isNotEmpty(array)) {
            for (Object obj : array) {
                list.add(obj);
            }
        }
        return list;
    }

    /**
     * Converts the array items to {@link Set}. Any duplicate values will be
     * removed as the underlying implementation uses {@link HashSet}.<br>
     * If the input is empty/null returns a empty {@link Set}
     *
     * @param array
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Set<T> toSet(final T[] array) {
        Set set = new HashSet();
        if (isNotEmpty(array)) {
            for (Object obj : array) {
                set.add(obj);
            }
        }
        return set;
    }

}
