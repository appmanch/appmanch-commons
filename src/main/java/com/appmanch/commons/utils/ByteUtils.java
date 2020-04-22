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
package com.appmanch.commons.utils;

import com.appmanch.commons.io.IOUtils;

import java.io.*;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

public class ByteUtils {

    private ByteUtils() {

    }

    /**
     * Read 2 bytes from the specified index, and convert them to char treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN}
     *
     * @param array
     * @param index
     * @return
     */
    public static char getcharBE(final byte[] array, final int index) {

        return (char) getShortBE(array, index);
    }

    /**
     * Read 2 bytes from the specified index, and convert them to char treating
     * the bytes as {@link ByteOrder#LITTLE_ENDIAN}
     *
     * @param array
     * @param index
     * @return
     */
    public static char getcharLE(final byte[] array, final int index) {
        return (char) getShortLE(array, index);
    }

    /**
     * Read 2 bytes from the specified index, and convert them to char treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN} if the isBigEndian parameter is
     * true
     *
     * @param array
     * @param index
     * @return
     */
    public static char getChar(final byte[] array, final int index, final boolean isBigEndian) {
        if (isBigEndian) {
            return (char) getShortBE(array, index);
        } else {
            return (char) getShortLE(array, index);
        }

    }

    /**
     * Read 2 bytes from the specified index, and convert them to short treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN}
     *
     * @param array
     * @param index
     * @return
     */
    public static short getShortBE(final byte[] array, final int index) {
        return (short) (array[index] << 8 | array[index + 1] & 0xFF);
    }

    /**
     * Read 2 bytes from the specified index, and convert them to short treating
     * the bytes as {@link ByteOrder#LITTLE_ENDIAN}.
     *
     * @param array
     * @param index
     * @return
     */
    public static short getShortLE(final byte[] array, final int index) {
        return (short) (array[index] & 0xFF | array[index + 1] << 8);

    }

    /**
     * Read 2 bytes from the specified index, and convert them to short treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN} if the isBigEndian parameter is
     * true.
     *
     * @param array
     * @param index
     * @return
     */
    public static short getShort(final byte[] array, final int index, final boolean isBigEndian) {
        if (isBigEndian) {
            return getShortBE(array, index);
        } else {
            return getShortLE(array, index);
        }

    }

    /**
     * Read 4 bytes from the specified index, and convert them to int treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN}
     *
     * @param array
     * @param index
     * @return
     */

    public static int getIntBE(final byte[] array, final int index) {
        return (array[index] & 0xff) << 24 | (array[index + 1] & 0xff) << 16 | (array[index + 2] & 0xff) << 8
                | (array[index + 3] & 0xff) << 0;
    }

    /**
     * Read 4 bytes from the specified index, and convert them to int treating
     * the bytes as {@link ByteOrder#LITTLE_ENDIAN}.
     *
     * @param array
     * @param index
     * @return
     */

    public static int getIntLE(final byte[] array, final int index) {
        return (array[index] & 0xff) << 0 | (array[index + 1] & 0xff) << 8 | (array[index + 2] & 0xff) << 16
                | (array[index + 3] & 0xff) << 24;
    }

    /**
     * Read 4 bytes from the specified index, and convert them to int treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN} if the isBigEndian parameter is
     * true.
     *
     * @param array
     * @param index
     * @return
     */
    public static int getInt(final byte[] array, final int index, final boolean isBigEndian) {
        if (isBigEndian) {
            return getIntBE(array, index);
        } else {
            return getIntLE(array, index);
        }

    }

    /**
     * Read 4 bytes from the specified index, and convert them to float treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN}
     *
     * @param array
     * @param index
     * @return
     */

    public static float getFloatBE(final byte[] array, final int index) {
        return Float.intBitsToFloat(getIntBE(array, index));
    }

    /**
     * Read 4 bytes from the specified index, and convert them to float treating
     * the bytes as {@link ByteOrder#LITTLE_ENDIAN}.
     *
     * @param array
     * @param index
     * @return
     */

    public static float getFloatLE(final byte[] array, final int index) {
        return Float.intBitsToFloat(getIntLE(array, index));
    }

    /**
     * Read 4 bytes from the specified index, and convert them to float treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN} if the isBigEndian parameter is
     * true.
     *
     * @param array
     * @param index
     * @return
     */
    public static float getFloat(final byte[] array, final int index, final boolean isBigEndian) {
        if (isBigEndian) {
            return Float.intBitsToFloat(getIntBE(array, index));
        } else {
            return Float.intBitsToFloat(getIntLE(array, index));
        }

    }

    /**
     * Read 8 bytes from the specified index, and convert them to long treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN}
     *
     * @param array
     * @param index
     * @return
     */

    public static long getLongBE(final byte[] array, final int index) {
        return ((long) array[index] & 0xff) << 56 | ((long) array[index + 1] & 0xff) << 48
                | ((long) array[index + 2] & 0xff) << 40 | ((long) array[index + 3] & 0xff) << 32
                | ((long) array[index + 4] & 0xff) << 24 | ((long) array[index + 5] & 0xff) << 16
                | ((long) array[index + 6] & 0xff) << 8 | ((long) array[index + 7] & 0xff) << 0;
    }

    /**
     * Read 8 bytes from the specified index, and convert them to long treating
     * the bytes as {@link ByteOrder#LITTLE_ENDIAN}.
     *
     * @param array
     * @param index
     * @return
     */

    public static long getLongLE(final byte[] array, final int index) {
        return ((long) array[index] & 0xff) << 0 | ((long) array[index + 1] & 0xff) << 8
                | ((long) array[index + 2] & 0xff) << 16 | ((long) array[index + 3] & 0xff) << 24
                | ((long) array[index + 4] & 0xff) << 32 | ((long) array[index + 5] & 0xff) << 40
                | ((long) array[index + 6] & 0xff) << 48 | ((long) array[index + 7] & 0xff) << 56;
    }

    /**
     * Read 8 bytes from the specified index, and convert them to long treating
     * the bytes as {@link ByteOrder#BIG_ENDIAN} if the isBigEndian parameter is
     * true.
     *
     * @param array
     * @param index
     * @return
     */
    public static long getLong(final byte[] array, final int index, final boolean isBigEndian) {
        if (isBigEndian) {
            return getLongBE(array, index);
        } else {
            return getLongLE(array, index);
        }

    }

    /**
     * Read 8 bytes from the specified index, and convert them to double
     * treating the bytes as {@link ByteOrder#BIG_ENDIAN}
     *
     * @param array
     * @param index
     * @return
     */

    public static double getDoubleBE(final byte[] array, final int index) {
        return Double.longBitsToDouble(getLongBE(array, index));
    }

    /**
     * Read 8 bytes from the specified index, and convert them to double
     * treating the bytes as {@link ByteOrder#LITTLE_ENDIAN}.
     *
     * @param array
     * @param index
     * @return
     */

    public static double getDoubleLE(final byte[] array, final int index) {
        return Double.longBitsToDouble(getLongLE(array, index));
    }

    /**
     * Read 8 bytes from the specified index, and convert them to double
     * treating the bytes as {@link ByteOrder#BIG_ENDIAN} if the isBigEndian
     * parameter is true.
     *
     * @param array
     * @param index
     * @return
     */
    public static double getDouble(final byte[] array, final int index, final boolean isBigEndian) {
        if (isBigEndian) {
            return Double.longBitsToDouble(getLongBE(array, index));
        } else {
            return Double.longBitsToDouble(getLongLE(array, index));
        }

    }

    public static void setCharBE(final byte[] array, final int index, final char value) {
        setShortBE(array, index, (short) value);
    }

    public static void setCharLE(final byte[] array, final int index, final char value) {
        setShortLE(array, index, (short) value);

    }

    public static void setChar(final byte[] array, final int index, final char value, final boolean isBigEndian) {
        if (isBigEndian) {
            setShortBE(array, index, (short) value);
        } else {
            setShortLE(array, index, (short) value);
        }
    }

    public static void setShortBE(byte[] array, int index, short value) {
        array[index] = (byte) (value >>> 8);
        array[index + 1] = (byte) (value >>> 0);
    }

    public static void setShortLE(byte[] array, int index, short value) {
        array[index] = (byte) (value >>> 0);
        array[index + 1] = (byte) (value >>> 8);

    }

    public static void setShort(byte[] array, int index, short value, boolean isBigEndian) {
        if (isBigEndian) {
            setShortBE(array, index, value);
        } else {
            setShortLE(array, index, value);
        }
    }

    public static void setIntLE(byte[] array, int index, int value) {
        array[index] = (byte) (value >>> 0);
        array[index + 1] = (byte) (value >>> 8);
        array[index + 2] = (byte) (value >>> 16);
        array[index + 3] = (byte) (value >>> 24);
    }

    public static void setIntBE(byte[] array, int index, int value) {
        array[index] = (byte) (value >>> 24);
        array[index + 1] = (byte) (value >>> 16);
        array[index + 2] = (byte) (value >>> 8);
        array[index + 3] = (byte) (value >>> 0);
    }

    public static void setInt(byte[] array, int index, int value, boolean isBigEndian) {
        if (isBigEndian) {
            setIntBE(array, index, value);
        } else {
            setIntLE(array, index, value);

        }
    }

    public static void setFloatLE(byte[] array, int index, float value) {
        setIntLE(array, index, Float.floatToRawIntBits(value));
    }

    public static void setFloatBE(byte[] array, int index, float value) {
        setIntBE(array, index, Float.floatToRawIntBits(value));
    }

    public static void setFloat(byte[] array, int index, float value, boolean isBigEndian) {
        if (isBigEndian) {
            setIntBE(array, index, Float.floatToRawIntBits(value));
        } else {
            setIntLE(array, index, Float.floatToRawIntBits(value));

        }
    }

    public static void setLongBE(byte[] array, int index, long value) {
        array[index] = (byte) (value >>> 56);
        array[index + 1] = (byte) (value >>> 48);
        array[index + 2] = (byte) (value >>> 40);
        array[index + 3] = (byte) (value >>> 32);
        array[index + 4] = (byte) (value >>> 24);
        array[index + 5] = (byte) (value >>> 16);
        array[index + 6] = (byte) (value >>> 8);
        array[index + 7] = (byte) (value >>> 0);
    }

    public static void setLongLE(byte[] array, int index, long value) {
        array[index] = (byte) (value >>> 0);
        array[index + 1] = (byte) (value >>> 8);
        array[index + 2] = (byte) (value >>> 16);
        array[index + 3] = (byte) (value >>> 24);
        array[index + 4] = (byte) (value >>> 32);
        array[index + 5] = (byte) (value >>> 40);
        array[index + 6] = (byte) (value >>> 48);
        array[index + 7] = (byte) (value >>> 56);
    }

    public static void setLong(byte[] array, int index, long value, boolean isBigEndian) {
        if (isBigEndian) {
            setLongBE(array, index, value);
        } else {
            setLongLE(array, index, value);
        }
    }

    public static void setDoubleBE(byte[] array, int index, double value) {
        setLongBE(array, index, Double.doubleToRawLongBits(value));
    }

    public static void setDoubleLE(byte[] array, int index, double value) {
        setLongLE(array, index, Double.doubleToRawLongBits(value));
    }

    public static void setDouble(byte[] array, int index, double value, boolean isBigEndian) {
        if (isBigEndian) {
            setLongBE(array, index, Double.doubleToRawLongBits(value));
        } else {
            setLongLE(array, index, Double.doubleToRawLongBits(value));
        }
    }

    public static Serializable deSerialize(byte[] bytes) throws IOException, ClassNotFoundException {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);

            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Serializable) objectInputStream.readObject();
        } finally {
            IOUtils.close(objectInputStream, byteArrayInputStream);
        }

    }

    public static void serialize(byte[] bytes, int index, Serializable object)
            throws IOException, ClassNotFoundException {
        byte[] objectBytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(object);
            objectBytes = byteArrayOutputStream.toByteArray();
            System.arraycopy(objectBytes, 0, bytes, index, objectBytes.length);
        } finally {
            IOUtils.close(objectOutputStream, byteArrayOutputStream);
            objectBytes = null;
        }
    }

    public static byte[] serialize(final Serializable object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(object);
            return byteArrayOutputStream.toByteArray();
        } finally {
            IOUtils.close(objectOutputStream, byteArrayOutputStream);
        }
    }


    /**
     *
     * @param charSeq
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final CharSequence charSeq) throws CharacterCodingException {

        return getBytes(charSeq, Charset.defaultCharset());

    }

    /**
     *
     * @param charSeq
     * @param off
     * @param len
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final CharSequence charSeq, final int off, final int len)
            throws CharacterCodingException {
        return getBytes(charSeq, off, len, Charset.defaultCharset());
    }

    /**
     *
     * @param charSeq
     * @param charset
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final CharSequence charSeq, final Charset charset)
            throws CharacterCodingException {
        return getBytes(charSeq, 0, charSeq.length(), charset);
    }

    /**
     *
     * @param charSeq
     * @param off
     * @param len
     * @param charset
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final CharSequence charSeq, final int off, final int len, final Charset charset)
            throws CharacterCodingException {


        return charset.newEncoder().encode(CharBuffer.wrap(charSeq, off, off + len + 1)).array();
    }

    /**
     *
     * @param cbuf
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final char[] cbuf) throws CharacterCodingException {
        return getBytes(cbuf, Charset.defaultCharset());
    }

    /**
     *
     * @param cbuf
     * @param off
     * @param len
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final char[] cbuf, final int off, final int len)
            throws CharacterCodingException {
        return getBytes(cbuf, off, len, Charset.defaultCharset());
    }

    /**
     *
     * @param cbuf
     * @param charset
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final char[] cbuf, final Charset charset) throws CharacterCodingException {

        return getBytes(cbuf, 0, cbuf.length, charset);

    }

    /**
     *
     * @param cbuf
     * @param off
     * @param len
     * @param charset
     * @return
     * @throws CharacterCodingException
     */
    public static byte[] getBytes(final char[] cbuf, final int off, final int len, final Charset charset)
            throws CharacterCodingException {

        return charset.newEncoder().encode(CharBuffer.wrap(cbuf, off, len)).array();
    }


}
