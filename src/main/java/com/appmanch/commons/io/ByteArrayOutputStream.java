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

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Nanda Gopalan
 * @since 1.0
 */
public class ByteArrayOutputStream extends OutputStream {

    byte[] data;
    private static int DEFAULT_SIZE = 1024;
    private static int DEFAILT_INCREMENT = 1024;
    private int size;
    private int increment;
    private int current = 0;
    private int remaining = 0;

    /**
     *
     */
    public ByteArrayOutputStream() {
        this(DEFAULT_SIZE, DEFAILT_INCREMENT);
    }

    /**
     * @param size
     */
    public ByteArrayOutputStream(int size) {
        this(size, DEFAILT_INCREMENT);
    }

    /**
     * @param size
     * @param increment
     */
    public ByteArrayOutputStream(int size, int increment) {
        this.size = size;
        this.increment = increment;
        this.data = new byte[this.size];
        this.remaining = size;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.io.OutputStream#write(int)
     */
    @Override
    public void write(int b) throws IOException {
        if (remaining - 1 == 0) {
            byte[] dataTmp = new byte[current + increment + 1];
            System.arraycopy(data, 0, dataTmp, 0, current);
            remaining = size - 1;
            this.data = dataTmp;
        }
        this.data[current++] = (byte) b;
    }

    /**
     *
     */
    public byte[] toByteArray() {
        byte[] val = new byte[current];
        System.arraycopy(data, 0, val, 0, current);
        return val;
    }

}
