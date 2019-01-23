package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a {@link java.sql.SqlDate} by parsing a value as a string of
 * form <code>yyyy-[m]m-[d]d</code>.
 *
 * @see	java.sql.Date#valueOf(String)
 */
public class SqlDateTypeConversion implements TypeConverter.Conversion<java.sql.Date> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			java.sql.Date.class,
			java.sql.Date.class.getName(),
			TypeConverter.TYPE_SQL_DATE
		};
	}

	@Override
	public java.sql.Date convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof java.sql.Date) {
			return (java.sql.Date)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				// Value must be in the "yyyy-mm-dd" format
				return java.sql.Date.valueOf(v);
			}
		}
	}
}
