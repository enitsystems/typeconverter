package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;
import java.math.BigDecimal;

/**
 * Convert to a {@link BigDecimal} by parsing the value as a string
 *
 */
public class BigDecimalTypeConversion implements TypeConverter.Conversion<BigDecimal> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			BigDecimal.class,
			BigDecimal.class.getName(),
			TypeConverter.TYPE_BIG_DECIMAL
		};
	}

	public BigDecimal convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof BigDecimal) {
			return (BigDecimal)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return new BigDecimal(v);
			}
		}
	}
}
