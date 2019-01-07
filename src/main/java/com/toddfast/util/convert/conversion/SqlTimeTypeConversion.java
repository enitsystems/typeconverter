package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a {@link SqlTime} by parsing a value as a string of
 * form <code>hh:mm:ss</code>.
 *
 * @see	java.sql.Date#valueOf(String)
 */
public class SqlTimeTypeConversion implements TypeConverter.Conversion<java.sql.Time> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			java.sql.Time.class,
			java.sql.Time.class.getName(),
			TypeConverter.TYPE_SQL_TIME
		};
	}

	@Override
	public java.sql.Time convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof java.sql.Time) {
			return (java.sql.Time)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				// Value must be in the "hh:mm:ss" format
				return java.sql.Time.valueOf(v);
			}
		}
	}
}
