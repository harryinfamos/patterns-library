package com.tek.test.cssdataLoader;

/**
 * Created by bs211w on 7/9/2014.
 */
public class CssDropDownData {

    private String cssObjectName;
    private String fontFamily;
    private String fontSize;
    private String width;
    private String height;
    private String lineHeight;
    private String color;
    private String hoverColor;
    private String leftPadding;
    private String rightPadding;
    

    public CssDropDownData(String cssObjectName,String fontFamily, String fontSize, String width, String height, String lineHeight,String color,String hoverColor,String leftPadding,String rightPadding) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.width = width;
        this.height = height;
        this.lineHeight = lineHeight;
        this.cssObjectName = cssObjectName;
        this.color = color;
        this.hoverColor = hoverColor;
        this.leftPadding = leftPadding;
        this.rightPadding = rightPadding;
    }

    public String getCssObjectName() {
        return cssObjectName;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public String getFontSize() {
        return fontSize;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getLineHeight() {
        return lineHeight;
    }

	public String getColor() {
		return color;
	}

	public String getHoverColor() {
		return hoverColor;
	}

	public String getLeftPadding() {
		return leftPadding;
	}

	public String getRightPadding() {
		return rightPadding;
	}

}
