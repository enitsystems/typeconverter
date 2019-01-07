package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a short by parsing the value as a string
 *
 */
public class ShortTypeConversion implements TypeConverter.Conversion<Short> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Short.class,
			Short.TYPE,
			Short.class.getName(),
			TypeConverter.TYPE_SHORT
		};
	}

	@Override
	public Short convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof Short) {
			return (Short)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return Short.parseShort(v);
			}
		}
	}
}
