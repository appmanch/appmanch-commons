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
package com.appmanch.commons.buffer;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Buffer interface for reading and writing data. This is inspire by the netty project.
 * 
 * This is similar to the {@link ByteBuffer} however it uses a separate
 * reader and writer index for ease of access. This eliminates the invocation of
 * calling the {@link ByteBuffer#rewind() &
 * {@link ByteBuffer#flip()}}
 * 
 * @author Nanda Gopalan
 * @since 1.0
 * @version 1.0
 */
public interface Buffer {

	public static final short FOUR_BYTES = 4;
	public static final short EIGHT_BYTES = 8;
	public static final short SIX_BYTES = 6;
	public static final short TWO_BYTES = 2;
	public static final short BYTE = 1;


	// Getter Methods.

	/**
	 * Get the id of the buffer.
	 * 
	 * @return {@link String}
	 */
	public String getId();

	/**
	 * Get the byte at the specified index
	 * 
	 * @param index
	 * @return byte
	 */
	public byte getByte(int index);

	/**
	 * Get the char at the specified index.
	 * 
	 * @param index
	 * @return char
	 */
	public char getChar(int index);

	/**
	 * Get a boolean at the specified index.
	 * 
	 * @param index
	 * @return
	 */
	public boolean getBoolean(int index);

	/**
	 * Get the next two bytes from the specified index by and return an short.
	 * 
	 * @param index
	 * @return
	 */
	public short getShort(int index);

	/**
	 * Get the next four bytes from the specified index and return an integer.
	 * 
	 * @param index
	 * @return
	 */
	public int getInt(int index);

	/**
	 * Get the next four bytes from the specified index and return a float.
	 * 
	 * @param index
	 * @return
	 */
	public float getFloat(int index);

	/**
	 * Get the next eight bytes from the specified index and return a long.
	 * 
	 * @param index
	 * @return
	 */
	public long getLong(int index);

	/**
	 * Get the next eight bytes from the specified index and return a double.
	 * 
	 * @param index
	 * @return
	 */
	public double getDouble(int index);

	/**
	 * Get the next bytes from the specified index and the length.
	 * 
	 * @param index
	 * @param length
	 * @return
	 */
	public byte[] getBytes(int index, int length);


	/**
	 * Reads a byte from the current reader index and increments it by 1
	 * 
	 * @return
	 */
	public byte readByte();

	/**
	 * Reads a char from the current reader index and increments it by 2
	 * 
	 * @return
	 */
	public char readChar();

	/**
	 * Reads a boolean from the current reader index and increments it by 1
	 * 
	 * @return
	 */
	public boolean readBoolean();

	/**
	 * Reads a Short from the current reader index and increments it by 2
	 * 
	 * @return
	 */
	public short readShort();

	/**
	 * Reads a Integer from the current reader index and increments it by 4
	 * 
	 * @return
	 */
	public int readInt();

	/**
	 * Reads a Float from the current reader index and increments it by 4
	 * 
	 * @return
	 */
	public float readFloat();

	/**
	 * Reads a Long from the current reader index and increments it by 8
	 * 
	 * @return
	 */
	public long readLong();

	/**
	 * Reads a Double from the current reader index and increments it by 8
	 * 
	 * @return
	 */
	public double readDouble();

	/**
	 * Reads a bytes from the current reader index for the specified length
	 * 
	 * @param length
	 * @return
	 */
	public byte[] readBytes(int length);


	/**
	 * Set a Byte at the given index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setByte(int index, byte value);

	/**
	 * Set the char value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setChar(int index, char value);

	/**
	 * Set the boolean value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setBoolean(int index, boolean value);

	/**
	 * Set the short value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setShort(int index, short value);

	/**
	 * Set the integer value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setInt(int index, int value);

	/**
	 * Set the float value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setFloat(int index, float value);

	/**
	 * Set the long value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setLong(int index, long value);

	/**
	 * Set the double value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setDouble(int index, double value);

	/**
	 * 
	 * Set the bytes in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setBytes(int index, byte[] value);

	/**
	 * Set the String value in the buffer at the specified index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setString(int index, String value);

	/**
	 * Write the bytes to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeByte(byte value);

	/**
	 * Write the char to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeChar(char value);

	/**
	 * Write the bytes to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeBytes(byte[] value);

	/**
	 * Write the boolean to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeBoolean(boolean value);

	/**
	 * Write the short to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeShort(short value);

	/**
	 * Write the integer to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeInt(int value);

	/**
	 * Write the float to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeFloat(float value);

	/**
	 * Write the long to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeLong(long value);

	/**
	 * Write the double to buffer from the current writer index
	 * 
	 * @param value
	 */
	public void writeDouble(double value);

	/**
	 * Write the String to buffer from the current writer index
	 * 
	 * @param value
	 * @return
	 */
	public int writeString(String value);

	/**
	 * Slice the current buffer from the specified index and length. The resultant
	 * buffer will have its own reader and writer index. Any changes to the
	 * resultant buffer will be result in the original buffer to change.
	 * 
	 * @param index
	 * @param length
	 * @return
	 */

	public Buffer slice(int index, int length);

	/**
	 * Slice the current buffer from the current writer index and length. The
	 * resultant buffer will have its own reader and writer index. Any changes to
	 * the resultant buffer will be result in the original buffer to change.
	 * 
	 * @param length
	 * @return
	 */

	public Buffer sliceAndSeek(int length);

	/**
	 * Return the current number of bytes that are writable.
	 * 
	 * @return
	 */
	public int writableBytes();

	/**
	 * Return the current number of bytes that are readable.
	 * 
	 * @return
	 */

	public int readableBytes();

	/**
	 * Set the reader index to a specified value.
	 * 
	 * @param index
	 */
	public void setReaderIndex(int index);

	/**
	 * Set the writer index to the specified value
	 * 
	 * @param index
	 */
	public void setWriterIndex(int index);

	/**
	 * Get the current reader index.
	 * 
	 * @return
	 */
	public int readerIndex();

	/**
	 * Get the current writer index.
	 * 
	 * @return
	 */
	public int writerIndex();

	/**
	 * Get the total capacity of the buffer.
	 * 
	 * @return
	 */
	public int getCapacity();

	/**
	 * Get the byte order used by the buffer.
	 * 
	 * @return
	 */
	public ByteOrder getByteOrder();

	/**
	 * Get the buffer as {@link ByteBuffer}
	 * 
	 * @return
	 */
	public ByteBuffer asByteBuffer();

	/**
	 * Set the {@link ByteOrder}. if the new value is different than old value and
	 * the buffer is not empty then all the bytes will be changed to the new byte
	 * order.
	 * 
	 * @param byteOrder
	 */
	public void setByteOrder(ByteOrder byteOrder);

	/**
	 * Check if the buffer is a readonly buffer.
	 * 
	 * @return
	 */
	public boolean isReadOnly();

	/**
	 * Make a buffer readonly.
	 * 
	 * @param readOnly
	 */
	public void setReadOnly(boolean readOnly);

	/**
	 * Reset the reader and writer index of a buffer
	 */
	public void reset();

	/**
	 * Reset the reader and writer index of a buffer and also clear the data based
	 * on the clearData Flag.
	 * 
	 * @param clearData
	 */
	public void reset(boolean clearData);

	/**
	 * Seek the reader index by adding the delta supplied.
	 * 
	 * @param delta
	 */
	public void seekReaderIndex(int delta);

	/**
	 * Seek the writer index by adding the delta supplied.
	 * 
	 * @param delta
	 */
	public void seekWriterIndex(int delta);

	/**
	 * Write an {@link Serializable} object.
	 * 
	 * @param object
	 */
	public void writeObject(Serializable object);

	/**
	 * Read a {@link Serializable} object.
	 * 
	 * @return
	 */
	public Serializable readObject();

}
