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
package com.appmanch.commons.io;

/**
 * Enumeration of {@link StorageUnit}.
 *
 * @author Nanda Gopalan
 * @version 1.0
 * @since 1.0
 */
public enum StorageUnit implements Comparable<StorageUnit> {

    /**
     * Definition for byte
     */
    BYTE(1, "byte", "B"),
    /**
     * Definition for kilobyte
     */
    KB(1024 * BYTE.size, "kilobyte", "KB"),
    /**
     * Definition for megabyte
     */
    MB(1024 * KB.size, "megabyte", "MB"),
    /**
     * Definition for gigabyte
     */
    GB(1024 * MB.size, "gigabyte", "GB"),
    /**
     * Definition for terrabyte
     */
    TB(1024 * GB.size, "terrabyte", "TB"),
    /**
     * Definition for petabyte
     */
    PB(1024 * TB.size, "petabyte", "PB"),
    /**
     * Definition for exabyte
     */
    EB(1024 * PB.size, "exabyte ", "EB"),
    /**
     * Definition for zettabyte
     */
    ZB(1024 * EB.size, "zettabyte", "ZB"),
    /**
     * Definition for yottabyte
     */
    YB(1024 * ZB.size, "yottabyte", "YB");

    
    /**
     * Size of the data unit
     */
    private long size;

    /**
     * Full name of the data unit.
     */
    private String name;

    /**
     * Short name of the data unit.
     */
    private String shortName;

    /**
     * Constructor for the Unit defn.
     *
     * @param size
     * @param name
     * @param shortName
     */
    StorageUnit(long size, String name, String shortName) {
        this.size = size;
        this.name = name;
        this.shortName = shortName;
    }

    /**
     * @return the size of the data unit
     */
    public long getSize() {
        return size;
    }

    /**
     * @return the full name of the data unit
     */
    public String getName() {
        return name;
    }

    /**
     * @return the shortName of the data unit
     */
    public String getShortName() {
        return shortName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return new StringBuffer().append(getSize()).append(shortName).toString();
    }

}
