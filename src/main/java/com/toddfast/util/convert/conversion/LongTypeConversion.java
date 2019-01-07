package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a long by parsing the value as a string
 *
 */
public class LongTypeConversion implements TypeConverter.Conversion<Long> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Long.class,
			Long.TYPE,
			Long.class.getName(),
			TypeConverter.TYPE_LONG
		};
	}

	@Override
	public Long convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof Long) {
			return (Long)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return Long.parseLong(v);
			}
		}
	}
}
