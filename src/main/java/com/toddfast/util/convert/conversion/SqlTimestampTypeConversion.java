package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a {@link java.sql.SqlTimestamp} by parsing a value as a string of
 * form <code>yyyy-[m]m-[d]d hh:mm:ss[.f...]</code>.
 *
 * @see	java.sql.Date#valueOf(String)
 */
public class SqlTimestampTypeConversion implements TypeConverter.Conversion<java.sql.Timestamp> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			java.sql.Timestamp.class,
			java.sql.Timestamp.class.getName(),
			TypeConverter.TYPE_SQL_TIMESTAMP
		};
	}

	@Override
	public java.sql.Timestamp convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof java.sql.Timestamp) {
			return (java.sql.Timestamp)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				// Value must be in the "yyyy-mm-dd hh:mm:ss.fffffffff"
				// format
				return java.sql.Timestamp.valueOf(v);
			}
		}
	}
}
