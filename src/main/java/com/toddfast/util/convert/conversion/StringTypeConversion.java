package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Converts the value to a string. If the value is a byte or char array,
 * it is converted to a string via {@link toString()}.
 *
 */
public class StringTypeConversion implements TypeConverter.Conversion<String> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			String.class,
			String.class.getName(),
			TypeConverter.TYPE_STRING
		};
	}

	@Override
	public String convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value.getClass().isArray()) {
			// This is a byte array; we can convert it to a string
			if (value.getClass().getComponentType()==Byte.TYPE) {
				return new String((byte[])value);
			}
			else if (value.getClass().getComponentType()==Character.TYPE) {
				return new String((char[])value);
			} else {
				return null;
			}
		} else if (value instanceof String) {
			return (String)value;
		} else {
			return value.toString();
		}
	}
}
