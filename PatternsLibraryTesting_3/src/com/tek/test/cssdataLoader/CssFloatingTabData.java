package com.tek.test.cssdataLoader;

public class CssFloatingTabData {
	
	private String floatingTabBackgroundColor;
    private String floatingTabRadius;
    private String floatingTabCursor;
    private String floatingTabFontFamily;
	private String floatingTabTextAlign;
	private String cssObjectName;

    public CssFloatingTabData(String cssObjectName,String floatingTabBackgroundColor,String floatingTabRadius, String floatingTabCursor, String floatingTabFontFamily,String floatingTabTextAlign) {
        this.floatingTabBackgroundColor = floatingTabBackgroundColor;
        this.floatingTabRadius = floatingTabRadius;
        this.floatingTabCursor = floatingTabCursor;
        this.floatingTabFontFamily = floatingTabFontFamily;
        this.floatingTabTextAlign = floatingTabTextAlign;
        this.cssObjectName = cssObjectName;
    }


	public String getCssObjectName() {
        return cssObjectName;
    }
    
    public String getFloatingTabBackgroundColor() {
        return floatingTabBackgroundColor;
    }
    
    public String getFloatingTabRadius() {
        return floatingTabRadius;
    }
    
    public String getFloatingTabCursor() {
        return floatingTabCursor;
    }
    
    public String getFloatingTabFontFamily() {
        return floatingTabFontFamily;
    }
    
    public String getFloatingTabTextAlign() {
        return floatingTabTextAlign;
    }

}
