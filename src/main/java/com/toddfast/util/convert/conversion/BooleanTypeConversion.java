package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a boolean by parsing the value as a string
 *
 */
public class BooleanTypeConversion implements TypeConverter.Conversion<Boolean> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Boolean.class,
			Boolean.TYPE,
			Boolean.class.getName(),
			TypeConverter.TYPE_BOOLEAN
		};
	}

	@Override
	public Boolean convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof Boolean) {
			return (Boolean)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return Boolean.parseBoolean(v);
			}
		}
	}
}
