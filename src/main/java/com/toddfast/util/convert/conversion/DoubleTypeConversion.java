package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a double by parsing the value as a string
 *
 */
public class DoubleTypeConversion implements TypeConverter.Conversion<Double> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Double.class,
			Double.TYPE,
			Double.class.getName(),
			TypeConverter.TYPE_DOUBLE
		};
	}

	@Override
	public Double convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof Double) {
			return (Double)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return Double.parseDouble(v);
			}
		}
	}
}
