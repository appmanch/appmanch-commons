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

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * 
 * 
 * 
 * @author Nanda Gopalan
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractBuffer implements Buffer {

	protected int capacity;
	protected ByteOrder byteOrder;
	protected boolean bigEndian;
	protected boolean readonly = false;
	protected int readerIndex;
	protected int writerIndex;
	protected String id = null;
	private static final AtomicLong ID_COUNTER = new AtomicLong();

	protected AbstractBuffer(int capacity, ByteOrder byteOrder) {
		super();
		this.capacity = capacity;
		this.byteOrder = byteOrder;
		this.bigEndian = ByteOrder.BIG_ENDIAN.equals(byteOrder);
		this.id = "buffer-" + ID_COUNTER.incrementAndGet();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setChar(int, char)
	 */

	public void setChar(int index, char value) {
		setShort(index, (short) value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getChar(int)
	 */

	public char getChar(int index) {
		return (char) getShort(index);
	}

	

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ByteOrder getByteOrder() {
		return byteOrder == null ? ByteOrder.BIG_ENDIAN : byteOrder;
	}


	public void setByteOrder(ByteOrder byteOrder) {
		if (!byteOrder.equals(this.byteOrder)) {

			handleByteOrderChange(byteOrder);
			this.byteOrder = byteOrder;
			this.bigEndian = ByteOrder.BIG_ENDIAN.equals(byteOrder);
		}
	}

	public boolean isBigEndian() {
		return bigEndian;
	}


	public boolean isReadOnly() {
		return readonly;
	}


	public void setReadOnly(boolean readOnly) {
		this.readonly = readOnly;
	}

	protected abstract void handleByteOrderChange(ByteOrder newByteOrder);

	public byte readByte() {
		return getByte(readerIndex++);

	}


	public char readChar() {
		char c = getChar(readerIndex);
		readerIndex += TWO_BYTES;
		return c;
	}


	public boolean readBoolean() {
		return getBoolean(readerIndex++);
	}


	public short readShort() {
		short s = getShort(readerIndex);
		readerIndex += TWO_BYTES;
		return s;
	}


	public int readInt() {
		int i = getInt(readerIndex);
		readerIndex += FOUR_BYTES;

		return i;
	}


	public float readFloat() {
		float f = getFloat(readerIndex);
		readerIndex += FOUR_BYTES;
		return f;

	}


	public long readLong() {
		long l = getLong(readerIndex);
		readerIndex += EIGHT_BYTES;
		return l;
	}


	public double readDouble() {
		double d = getDouble(readerIndex);
		readerIndex += EIGHT_BYTES;
		return d;
	}


	public byte[] readBytes(int length) {

		byte[] bytes = new byte[length];
		int lastIndex;
		int index = 0;
		lastIndex = readerIndex;
		readerIndex += length;
		for (int i = lastIndex; i < lastIndex + length; i++) {
			bytes[index++] = getByte(i);
		}
		return bytes;
	}

	


	public void writeByte(byte value) {
		setByte(writerIndex++, value);
	}


	public void writeChar(char value) {
		setChar(writerIndex, value);
		writerIndex += TWO_BYTES;
	}


	public void writeBytes(byte[] value) {
		setBytes(writerIndex, value);
		writerIndex += value.length;
	}


	public void writeBoolean(boolean value) {
		setBoolean(writerIndex++, value);
	}


	public void writeShort(short value) {
		setShort(writerIndex, value);
		writerIndex += TWO_BYTES;
	}


	public void writeInt(int value) {
		setInt(writerIndex, value);
		writerIndex += FOUR_BYTES;
	}


	public void writeFloat(float value) {
		setFloat(writerIndex, value);
		writerIndex += FOUR_BYTES;
	}


	public void writeLong(long value) {
		setLong(writerIndex, value);
		writerIndex += EIGHT_BYTES;
	}



	public void writeDouble(double value) {
		setDouble(writerIndex, value);
		writerIndex += EIGHT_BYTES;
	}


	public int writeString(String value) {
		byte[] bytes;
		try {
			bytes = ByteUtils.getBytes((CharSequence) value);
			writeInt(bytes.length);
			writeBytes(bytes);
			return bytes.length + 4;
		} catch (CharacterCodingException e) {
			throw new RuntimeException(e);
		}
	}


	public int writableBytes() {
		return capacity - writerIndex;
	}



	public int readableBytes() {
		return writerIndex - readerIndex;
	}


	public void setString(int index, String value) {
		try {
			setBytes(index, ByteUtils.getBytes(value));
		} catch (CharacterCodingException e) {
			throw new RuntimeException(e);
		}
	}


	public void setReaderIndex(int index) {
		this.readerIndex = index;
	}


	public void setWriterIndex(int index) {

		this.writerIndex = index;

	}


	public int writerIndex() {
		return writerIndex;

	}


	public int readerIndex() {
		return readerIndex;
	}


	public void reset() {
		reset(false);
	}


	public void reset(boolean clearData) {
		readerIndex = 0;
		writerIndex = 0;
		if (clearData) {
			for (int i = 0; i < capacity; i++) {
				setByte(i, (byte) 0);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getId()
	 */

	public String getId() {
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	public int hashCode() {

		return id.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#seekReaderIndex(int)
	 */

	public void seekReaderIndex(int delta) {
		readerIndex += delta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#seekWriterIndex(int)
	 */

	public void seekWriterIndex(int delta) {
		writerIndex += delta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readObject()
	 */

	public Serializable readObject() {

		synchronized (this) {
			int length = readInt();
			try {
				return ByteUtils.deSerialize(readBytes(length));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeObject(java.io.Serializable)
	 */

	public void writeObject(Serializable object) {
		try {
			byte[] data = ByteUtils.serialize(object);
			synchronized (this) {
				writeInt(data.length);
				writeBytes(data);

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	public boolean equals(Object obj) {

		return obj != null && obj instanceof Buffer && ((Buffer) obj).getId().equals(this.id);
	}
}
