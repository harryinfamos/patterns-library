package com.tek.test.cssdataLoader;

/**
 * Created by bs211w on 7/9/2014.
 */
public class CssColorSelectorData {

    private String colorSelectorWidth;
    private String colorSelectorHeight;
    private String colorSelectorBorderRadius;
    private String colorSelectorCursor;
	private String cssObjectName;

    public CssColorSelectorData(String cssObjectName,String colorSelectorWidth,String colorSelectorHeight, String colorSelectorBorderRadius, String colorSelectorCursor) {
        this.colorSelectorWidth = colorSelectorWidth;
        this.colorSelectorHeight = colorSelectorHeight;
        this.colorSelectorBorderRadius = colorSelectorBorderRadius;
        this.colorSelectorCursor = colorSelectorCursor;
        this.cssObjectName = cssObjectName;
    }


	public String getCssObjectName() {
        return cssObjectName;
    }
    
    public String getColorSelectorWidth() {
        return colorSelectorWidth;
    }
    
    public String getColorSelectorHeight() {
        return colorSelectorHeight;
    }
    
    public String getColorSelectorBorderRadius() {
        return colorSelectorBorderRadius;
    }
    
    public String getColorSelectorCursor() {
        return colorSelectorCursor;
    }
    
    
}
