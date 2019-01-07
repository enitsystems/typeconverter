package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a character by parsing the first character of the value
 * as a string
 *
 */
public class CharacterTypeConversion implements TypeConverter.Conversion<Character> {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Character.class,
			Character.TYPE,
			Character.class.getName(),
			TypeConverter.TYPE_CHAR,
			TypeConverter.TYPE_CHARACTER,
		};
	}

	@Override
	public Character convert(Object value) {
		if (value==null) {
			return null;
		}
		if (value instanceof Character) {
			return (Character)value;
		} else {
			String v=value.toString();
			if (v.trim().length()==0) {
				return null;
			}
			else {
				return new Character(v.charAt(0));
			}
		}
	}
}
