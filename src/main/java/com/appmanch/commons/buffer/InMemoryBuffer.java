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

import com.appmanch.commons.utils.ByteUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class InMemoryBuffer extends AbstractBuffer {

	byte[] array = null;

	protected InMemoryBuffer(int capacity) {
		this(capacity, ByteOrder.BIG_ENDIAN);
	}

	protected InMemoryBuffer(int capacity, ByteOrder byteOrder) {

		this(byteOrder, new byte[capacity]);
	}

	protected InMemoryBuffer(ByteOrder byteOrder, byte[] array) {

		super(array.length, byteOrder);
		this.array = array;
	}

	public double getDouble(int index) {

		return ByteUtils.getDouble(array, index, isBigEndian());
	}

	public byte getByte(int index) {
		return array[index];
	}

	public boolean getBoolean(int index) {
		return array[index] == 0X1;
	}

	public short getShort(int index) {
		return ByteUtils.getShort(array, index, isBigEndian());
	}

	public int getInt(int index) {

		return ByteUtils.getInt(array, index, isBigEndian());
	}

	public float getFloat(int index) {

		return ByteUtils.getFloat(array, index, isBigEndian());
	}

	public long getLong(int index) {

		return ByteUtils.getLong(array, index, isBigEndian());
	}

	public double getdouble(int index) {
		return ByteUtils.getDouble(array, index, isBigEndian());
	}

	public byte[] getBytes(int index, int length) {
		byte[] value = new byte[length];

		System.arraycopy(array, index, value, 0, length);
		return value;
	}

	public void setByte(int index, byte value) {
		array[index] = value;
	}

	public void setBoolean(int index, boolean value) {
		array[index] = (byte) (value ? 0x1 : 0X0);
	}

	public void setShort(int index, short value) {
		ByteUtils.setShort(array, index, value, isBigEndian());
	}

	public void setInt(int index, int value) {
		ByteUtils.setInt(array, index, value, isBigEndian());
	}

	public void setFloat(int index, float value) {
		ByteUtils.setFloat(array, index, value, isBigEndian());
	}

	public void setLong(int index, long value) {
		ByteUtils.setLong(array, index, value, isBigEndian());
	}

	public void setDouble(int index, double value) {
		ByteUtils.setDouble(array, index, value, isBigEndian());
	}

	public void setBytes(int index, byte[] value) {
		System.arraycopy(value, 0, array, index, value.length);
	}

	public Buffer slice(int index, int length) {
		InMemoryBuffer buffer = new InMemoryBuffer(getByteOrder(), array);
		buffer.setReaderIndex(index);
		buffer.setWriterIndex(index);
		buffer.id = id;
		return buffer;
	}

	public Buffer sliceAndSeek(int length) {
		InMemoryBuffer buffer = new InMemoryBuffer(getByteOrder(), array);
		buffer.setReaderIndex(readerIndex);
		buffer.setWriterIndex(writerIndex);
		writerIndex += length;
		buffer.id = id;
		return buffer;
	}

	@Override
	protected void handleByteOrderChange(ByteOrder newByteOrder) {
		ByteBuffer.wrap(array).order(newByteOrder);
	}

	@Override
	public ByteBuffer asByteBuffer() {
		return ByteBuffer.wrap(array);
	}

	

}
