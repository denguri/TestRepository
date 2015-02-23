package com.majstor.jovan.entity;

public enum ColorEnum {
	
	RED, 
	GREEN, 
	BLUE,
	NONE;
	
	public static ColorEnum getColor(int value)
	{
		for (ColorEnum c : ColorEnum.values())
		{
			if (value == c.ordinal())
			{
				return c;
			}
		}
		return NONE;
	}
}
