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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class NioBuffer extends AbstractBuffer {

	private ByteBuffer buffer = null;

	protected NioBuffer(ByteBuffer buffer) {
		super(buffer.remaining(), buffer.order());
		this.buffer = buffer;
	}

	public byte getByte(int index) {
		return buffer.get(index);
	}

	public boolean getBoolean(int index) {

		return buffer.get(index) == 1;
	}

	public short getShort(int index) {

		return buffer.getShort(index);
	}

	public int getInt(int index) {

		return buffer.getInt(index);
	}

	public float getFloat(int index) {

		return buffer.getFloat(index);
	}

	public long getLong(int index) {
		return buffer.getLong(index);
	}

	public double getDouble(int index) {
		return buffer.getDouble(index);
	}

	public byte[] getBytes(int index, int length) {
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = buffer.get(index + i);
		}
		return bytes;
	}

	public void setByte(int index, byte value) {
		if (!readonly) {
			buffer.put(index, value);
		}

	}

	public void setBoolean(int index, boolean value) {
		if (!readonly) {
			buffer.put(index, (byte) (value ? 1 : 0));
		}
	}

	public void setShort(int index, short value) {
		if (!readonly) {
			buffer.putShort(index, value);
		}
	}

	public void setInt(int index, int value) {
		if (!readonly) {
			buffer.putInt(index, value);
		}
	}

	public void setFloat(int index, float value) {
		if (!readonly) {
			buffer.putFloat(index, value);
		}
	}

	public void setLong(int index, long value) {
		if (!readonly) {
			buffer.putLong(index, value);
		}
	}

	public void setDouble(int index, double value) {
		if (!readonly) {
			buffer.putDouble(index, value);
		}
	}

	public void setBytes(int index, byte[] value) {
		if (!readonly) {
			for (int i = 0; i < value.length; i++) {
				buffer.put(index + i, value[i]);
			}
		}

	}

	public Buffer slice(int index, int length) {
		ByteBuffer buffer = this.buffer.duplicate();
		buffer.position(index).limit(index + length);
		NioBuffer slice = new NioBuffer(buffer.slice());
		slice.id = this.id;
		return slice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appmanch.commons.buffer.Buffer#sliceAndSeek(int, boolean)
	 */
	@Override
	public Buffer sliceAndSeek(int length) {
		ByteBuffer buffer = this.buffer.duplicate();
		buffer.position(writerIndex).limit(writerIndex + length);
		writerIndex += length;
		NioBuffer slice = new NioBuffer(buffer.slice());
		slice.id = this.id;
		return slice;
	}

	@Override
	protected void handleByteOrderChange(ByteOrder newByteOrder) {
		buffer.order(newByteOrder);
	}

	@Override
	public ByteBuffer asByteBuffer() {
		return buffer.duplicate();
	}

}
