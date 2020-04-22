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

import com.appmanch.commons.io.StorageUnit;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * 
 * Factory and utility methods to create {@link Buffer}.
 * 
 * @author Nanda Gopalan
 * @version 1.0.1
 * @since 1.0.1
 * 
 */
public final class Buffers {
	/**
	 * Default Buffer Capacity.
	 */
	public static final int DEFAULT_CAPACITY = 4096;
	/**
	 * Default ByteOrder.
	 */
	public static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;

	/**
	 * Prevent External Instantiation
	 */
	private Buffers() {
	}

	/**
	 * Create a new in-memory buffer with {@link Buffers#DEFAULT_CAPACITY} . This
	 * buffer is backed by a byte array.
	 * 
	 * @return
	 */
	public static final Buffer newInMemory() {
		return newInMemory(DEFAULT_CAPACITY);
	}

	/**
	 * 
	 * Create a new in-memory buffer with specified capacity. This buffer is backed
	 * by a byte array.
	 * 
	 * @param capacity
	 * @return
	 */
	public static final Buffer newInMemory(int capacity) {
		return newInMemory(capacity, DEFAULT_BYTE_ORDER);
	}

	/**
	 * Create a new in-memory buffer with specified capacity and the
	 * {@link ByteOrder}. This buffer is backed by a byte array.
	 * 
	 * @param capacity
	 * @param byteOrder
	 * @return
	 */
	public static final Buffer newInMemory(int capacity, ByteOrder byteOrder) {
		return new InMemoryBuffer(capacity, byteOrder);
	}

	/**
	 * Create a new in-memory buffer with specified {@link ByteOrder} and a byte
	 * array. This buffer is backed by the specified byte array.<br>
	 * Any changes to the buffer will be visible to the byte array.
	 *
	 * 
	 * @param byteOrder
	 * @param array
	 * @return
	 */
	public static final Buffer newInMemory(ByteOrder byteOrder, byte[] array) {
		return new InMemoryBuffer(byteOrder, array);
	}

	/**
	 * Create a new in-memory buffer with specified {@link ByteOrder} and capacity
	 * specified in value and {@link StorageUnit}
	 * 
	 * @param value
	 * @param storageUnit
	 * @param byteOrder
	 * @return
	 */
	public static final Buffer newInMemory(int value, StorageUnit storageUnit, ByteOrder byteOrder) {
		if (storageUnit.getSize() * value > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Invalid capacity specified.");
		}

		return newInMemory((int) storageUnit.getSize() * value, byteOrder);
	}

	/**
	 * Create a new in-memory buffer with {@link Buffers#DEFAULT_BYTE_ORDER} and
	 * capacity specified in value and {@link StorageUnit}
	 * 
	 * @param value
	 * @param storageUnit
	 * @return
	 */
	public static final Buffer newInMemory(int value, StorageUnit storageUnit) {
		if (storageUnit.getSize() * value > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Invalid capacity specified.");
		}

		return newInMemory((int) storageUnit.getSize() * value);
	}

	public static final Buffer newNioBuffer() {
		return newNioBuffer(DEFAULT_CAPACITY);
	}

	public static final Buffer newNioBuffer(int capacity) {
		ByteBuffer buffer = ByteBuffer.allocate(capacity);
		return new NioBuffer(buffer);
	}

	public static final Buffer newNioBuffer(int capacity, ByteOrder byteOrder) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
		byteBuffer.order(byteOrder);
		return new NioBuffer(byteBuffer);
	}

	public static final Buffer newNioDirectBuffer() {
		return newNioDirectBuffer(DEFAULT_CAPACITY);
	}

	public static final Buffer newNioDirectBuffer(int capacity) {
		ByteBuffer buffer = ByteBuffer.allocateDirect(capacity);
		return new NioBuffer(buffer);
	}

	public static final Buffer newNioDirectBuffer(int capacity, ByteOrder byteOrder) {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(capacity);
		byteBuffer.order(byteOrder);
		return new NioBuffer(byteBuffer);
	}

	public static final Buffer newMemoryMappedFile(String fileName, long length) throws IOException {
		return newMemoryMappedFile(fileName, 0L, length);
	}

	public static final Buffer newMemoryMappedFile(String fileName, long start, long length) throws IOException {
		if (length - start > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("The Mapping region cannot be more then 4GB");
		}
		Path path = Paths.get(fileName);
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
		FileChannel channel = (FileChannel) Files.newByteChannel(path, READ, WRITE);
		ByteBuffer mappedBuffer = channel.map(MapMode.READ_WRITE, start, length);
		NioBuffer buffer = new NioBuffer(mappedBuffer);
		return buffer;
	}

}
