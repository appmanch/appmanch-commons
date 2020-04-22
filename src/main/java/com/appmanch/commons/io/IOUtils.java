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

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import static com.appmanch.commons.io.StorageUnit.KB;

/**
 * Utility class for IO Operations.
 *
 * @author Nanda Gopalan
 * @version 1.0
 * @since 1.0
 */
public final class IOUtils {

    /**
     * Default Buffer size used in the IO operations. Value of this is 4
     * {@link StorageUnit#KB}
     */
    protected static int DEFAULT_BUFFER_SIZE = 4 * (int) KB.getSize();
    /**
     * Read Write Mode
     */
    public static String READ_WRITE_MODE = "rw";
    /**
     * Read Only Mode
     */
    public static String READ_MODE = "r";
    /**
     * Write Only Mode
     */
    public static String WRITE_MODE = "r";

    /**
     * Close the {@link Closeable} and suppress any exception.
     *
     * @param closeable
     */
    public static void close(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception ex) {
                // LOGGER.error("Exception in closing the resource .. Proce",
                // ex);
            }
        }
    }

    /**
     * Close the array of {@link Closeable} in the order of their occurrence in
     * the parameter while suppressing any exception
     *
     * @param closeables
     * @see Closeable
     */
    public static void close(final Closeable... closeables) {

        for (Closeable closeable : closeables) {
            close(closeable);
            closeable = null;
        }

    }

    /**
     * Reads the input stream for entire length specified and returns the
     * bytes[] read<br>
     * This method does not close the inputstream
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] getBytes(final InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            transfer(inputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
            byteArrayOutputStream = null;
        }

    }

    /**
     * Reads the input stream for the length specified and returns the bytes[]
     * read
     *
     * @param inputStream
     * @param length
     * @return
     * @throws IOException
     */
    public static byte[] getBytes(final InputStream inputStream, final int length) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            transfer(inputStream, byteArrayOutputStream, length);
            return byteArrayOutputStream.toByteArray();

        } finally {
            byteArrayOutputStream = null;
        }

    }

    /**
     * Transfer from InputStream to OutputStream for the specified length<br>
     * This method does not close the streams. The calling method should take
     * care of closing the resources.
     *
     * @param inputStream
     * @param outputStream
     * @param length
     * @return
     * @throws IOException
     */
    public static long transfer(final InputStream inputStream, final OutputStream outputStream, final int length)
            throws IOException {
        long transferredBytes = 0;
        int remainingBytes = length;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

        try {
            for (int i = 0; (i != -1); ) {
                if (remainingBytes > DEFAULT_BUFFER_SIZE) {
                    i = inputStream.read(buffer);
                    transferredBytes += i;
                    outputStream.write(buffer, 0, i);
                } else {
                    int readBytes = inputStream.read(buffer, 0, length);
                    transferredBytes += readBytes;
                    outputStream.write(buffer, 0, readBytes);
                    break;
                }
                remainingBytes -= i;

            }

        } finally {
            buffer = null;
        }

        return transferredBytes;
    }

    /**
     * Transfer from InputStream to OutputStream for the entire length of the
     * input stream<br This method does not close the streams. The calling
     * method should take care of closing the resources.
     *
     * @param inputStream
     * @param outputStream
     * @return
     * @throws IOException
     */

    public static long transfer(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        long transferredBytes = 0;
        int i = -1;
        byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
        try {

            while ((i = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
                transferredBytes += i;
            }
            return transferredBytes;
        } finally {
            outputStream.flush();
            bytes = null;
        }

    }


}
