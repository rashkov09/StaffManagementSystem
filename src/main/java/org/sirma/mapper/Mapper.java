package org.sirma.mapper;

public interface Mapper<T> {

	T mapFromString(String line);
	String mapToString(T object);

}
