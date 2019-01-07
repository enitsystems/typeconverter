package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a byte by parsing the value as a string
 *
 */
public class ByteTypeConversion implements TypeConverter.Conversion<Byte> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Byte.class,
			Byte.TYPE,
			Byte.class.getName(),
			TypeConverter.TYPE_BYTE
		};
	}

	@Override
	public Byte convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof Byte) {
			return (Byte)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return Byte.parseByte(v);
			}
		}
	}
}
