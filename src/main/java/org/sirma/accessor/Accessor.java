package org.sirma.accessor;

import java.io.IOException;
import java.util.List;

public interface Accessor {

	List<String> read();

	void write(List<String> lines) throws IOException;

}
