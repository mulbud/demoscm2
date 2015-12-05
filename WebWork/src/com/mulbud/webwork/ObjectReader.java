package com.mulbud.webwork;

import java.sql.ResultSet;

public interface ObjectReader<T> {
	T readFromResultSet(ResultSet rs) throws Exception;
}
