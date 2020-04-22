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

import com.appmanch.commons.lang.ArrayUtils;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nanda Gopalan
 * @since 1.0
 */
public class CompositeBuffer implements Buffer {

	private List<Buffer> buffers = new ArrayList<Buffer>();

	/**
	 * Create a new instance of Composite Buffer.
	 */
	public CompositeBuffer(Buffer... buffers) {

		if (ArrayUtils.isNotEmpty(buffers)) {

			for (int i = 0; i < buffers.length; i++) {
				this.buffers.add(buffers[i]);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getId()
	 */
	@Override
	public String getId() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getByte(int)
	 */
	@Override
	public byte getByte(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getChar(int)
	 */
	@Override
	public char getChar(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getBoolean(int)
	 */
	@Override
	public boolean getBoolean(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getShort(int)
	 */
	@Override
	public short getShort(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getInt(int)
	 */
	@Override
	public int getInt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getFloat(int)
	 */
	@Override
	public float getFloat(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getLong(int)
	 */
	@Override
	public long getLong(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getDouble(int)
	 */
	@Override
	public double getDouble(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getBytes(int, int)
	 */
	@Override
	public byte[] getBytes(int index, int length) {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readByte()
	 */
	@Override
	public byte readByte() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readChar()
	 */
	@Override
	public char readChar() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readBoolean()
	 */
	@Override
	public boolean readBoolean() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readShort()
	 */
	@Override
	public short readShort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readInt()
	 */
	@Override
	public int readInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readFloat()
	 */
	@Override
	public float readFloat() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readLong()
	 */
	@Override
	public long readLong() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readDouble()
	 */
	@Override
	public double readDouble() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readBytes(int)
	 */
	@Override
	public byte[] readBytes(int length) {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setByte(int, byte)
	 */
	@Override
	public void setByte(int index, byte value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setChar(int, char)
	 */
	@Override
	public void setChar(int index, char value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setBoolean(int, boolean)
	 */
	@Override
	public void setBoolean(int index, boolean value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setShort(int, short)
	 */
	@Override
	public void setShort(int index, short value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setInt(int, int)
	 */
	@Override
	public void setInt(int index, int value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setFloat(int, float)
	 */
	@Override
	public void setFloat(int index, float value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setLong(int, long)
	 */
	@Override
	public void setLong(int index, long value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setDouble(int, double)
	 */
	@Override
	public void setDouble(int index, double value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setBytes(int, byte[])
	 */
	@Override
	public void setBytes(int index, byte[] value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setString(int, java.lang.String)
	 */
	@Override
	public void setString(int index, String value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeByte(byte)
	 */
	@Override
	public void writeByte(byte value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeChar(char)
	 */
	@Override
	public void writeChar(char value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeBytes(byte[])
	 */
	@Override
	public void writeBytes(byte[] value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeBoolean(boolean)
	 */
	@Override
	public void writeBoolean(boolean value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeShort(short)
	 */
	@Override
	public void writeShort(short value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeInt(int)
	 */
	@Override
	public void writeInt(int value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeFloat(float)
	 */
	@Override
	public void writeFloat(float value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeLong(long)
	 */
	@Override
	public void writeLong(long value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeDouble(double)
	 */
	@Override
	public void writeDouble(double value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeString(java.lang.String)
	 */
	@Override
	public int writeString(String value) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#slice(int, int)
	 */
	@Override
	public Buffer slice(int index, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#sliceAndSeek(int)
	 */
	@Override
	public Buffer sliceAndSeek(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writableBytes()
	 */
	@Override
	public int writableBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readableBytes()
	 */
	@Override
	public int readableBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setReaderIndex(int)
	 */
	@Override
	public void setReaderIndex(int index) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setWriterIndex(int)
	 */
	@Override
	public void setWriterIndex(int index) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readerIndex()
	 */
	@Override
	public int readerIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writerIndex()
	 */
	@Override
	public int writerIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getCapacity()
	 */
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#getByteOrder()
	 */
	@Override
	public ByteOrder getByteOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#asByteBuffer()
	 */
	@Override
	public ByteBuffer asByteBuffer() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setByteOrder(java.nio.ByteOrder)
	 */
	@Override
	public void setByteOrder(ByteOrder byteOrder) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#setReadOnly(boolean)
	 */
	@Override
	public void setReadOnly(boolean readOnly) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#reset()
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#reset(boolean)
	 */
	@Override
	public void reset(boolean clearData) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#seekReaderIndex(int)
	 */
	@Override
	public void seekReaderIndex(int delta) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#seekWriterIndex(int)
	 */
	@Override
	public void seekWriterIndex(int delta) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#writeObject(java.io.Serializable)
	 */
	@Override
	public void writeObject(Serializable object) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#readObject()
	 */
	@Override
	public Serializable readObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
