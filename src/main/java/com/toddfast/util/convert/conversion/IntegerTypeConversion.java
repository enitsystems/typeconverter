package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to an integer by parsing the value as a string
 *
 */
public class IntegerTypeConversion implements TypeConverter.Conversion<Integer> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Integer.class,
			Integer.TYPE,
			Integer.class.getName(),
			TypeConverter.TYPE_INT,
			TypeConverter.TYPE_INTEGER
		};
	}

	@Override
	public Integer convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof Integer) {
			return (Integer)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return Integer.parseInt(v);
			}
		}
	}
}
