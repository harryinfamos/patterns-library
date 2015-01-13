package com.tek.test.cssdataLoader;

/**
 * Created by bs211w on 7/9/2014.
 */
public class CssAccordionData {

    private String accordianFontFamily;
    private String accordianFontSize;
    private String accordianBorderStyle;
    private String accordianPadding;
    private String cssObjectName;

    public CssAccordionData(String cssObjectName,String fontFamily,String fontSize, String borderStyle, String padding) {
        this.accordianFontFamily = fontFamily;
        this.accordianFontSize = fontSize;
        this.accordianBorderStyle = borderStyle;
        this.accordianPadding = padding;
        this.cssObjectName = cssObjectName;
    }

    public String getCssObjectName() {
        return cssObjectName;
    }
    
    public String getFontFamily() {
        return accordianFontFamily;
    }
    
    public String getFontSize() {
        return accordianFontSize;
    }
    
    public String getBorderStyle() {
        return accordianBorderStyle;
    }
    
    public String getPadding() {
        return accordianPadding;
    }
    
    
}
