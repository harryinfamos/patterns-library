package com.tek.test.cssdataLoader;

/**
 * Created by bs211w on 7/9/2014.
 */
public class CssDataBuilder {

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
    private String colorSelectorWidth;
    private String colorSelectorHeight;
    private String colorSelectorBorderRadius;
    private String colorSelectorCursor;
    private String accordianFontFamily;
    private String accordianFontSize;
    private String accordianBorderStyle;
    private String accordianPadding;
    private String carouselBackgroundColor;
    private String carouselBorderRaduis;
    private String carouselMargin;
    private String carouselPadding;
	private String carouselTextAlign;
	private String floatingTabBackgroundColor;
    private String floatingTabRadius;
    private String floatingTabCursor;
    private String floatingTabFontFamily;
	private String floatingTabTextAlign;

    public CssButtonData buildButton() {
        return new CssButtonData(cssObjectName,fontFamily, fontSize, width, height, lineHeight, color,hoverColor,leftPadding,rightPadding);
    }
    
    public CssDropDownData buildDropDown() {
        return new CssDropDownData(cssObjectName,fontFamily, fontSize, width, height, lineHeight, color,hoverColor,leftPadding,rightPadding);
    }
    
    public CssColorSelectorData colorSelectorBuild() {
        return new CssColorSelectorData(cssObjectName,colorSelectorWidth, colorSelectorHeight, colorSelectorBorderRadius, colorSelectorCursor);
    }
    
    public CssAccordionData accordianBuild() {
        return new CssAccordionData(cssObjectName,accordianFontFamily,accordianFontSize, accordianBorderStyle, accordianPadding);
    }
    
    public CssCarouselData carouselBuild() {
        return new CssCarouselData(cssObjectName,carouselBackgroundColor,carouselBorderRaduis,carouselMargin,carouselPadding,carouselTextAlign);
    }
    
    public CssFloatingTabData floatingTabBuild() {
        return new CssFloatingTabData(cssObjectName,floatingTabBackgroundColor,floatingTabRadius,floatingTabCursor,floatingTabFontFamily,floatingTabTextAlign);
    }


    public CssDataBuilder withObjectName(String cssObjectName) {
        this.cssObjectName = cssObjectName;
        return this;
    }

    public CssDataBuilder withFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    public CssDataBuilder withFontSize(String fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public CssDataBuilder withWidth(String width) {
        this.width = width;
        return this;
    }

    public CssDataBuilder withHeight(String height) {
        this.height = height;
        return this;
    }
       
    public CssDataBuilder withLineHeight(String lineHeight) {
        this.lineHeight = lineHeight;
        return this;
    }

    public CssDataBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public CssDataBuilder withHoverColor(String hoverColor) {
        this.hoverColor = hoverColor;
        return this;
    }

    public CssDataBuilder withLeftPadding(String leftPadding) {
        this.leftPadding = leftPadding;
        return this;
    }

    public CssDataBuilder withRightPadding(String rightPadding) {
        this.rightPadding = rightPadding;
        return this;
    }
    public CssDataBuilder withColorSelectorWidth(String colorSelectorWidth) {
        this.colorSelectorWidth = colorSelectorWidth;
        return this;
    }
    
    public CssDataBuilder withColorSelectorHeight(String colorSelectorHeight) {
        this.colorSelectorHeight = colorSelectorHeight;
        return this;
    }
    
    public CssDataBuilder withColorSelectorBorderRadius(String colorSelectorBorderRadius) {
        this.colorSelectorBorderRadius = colorSelectorBorderRadius;
        return this;
    }
    
    public CssDataBuilder withColorSelectorCursor(String colorSelectorCursor) {
        this.colorSelectorCursor = colorSelectorCursor;
        return this;
    }
    
    public CssDataBuilder withAccordianFontFamily(String accordianFontFamily) {
        this.accordianFontFamily = accordianFontFamily;
        return this;
    }
    
    public CssDataBuilder withAccordianFontSize(String accordianFontSize) {
        this.accordianFontSize = accordianFontSize;
        return this;
    }
    
    public CssDataBuilder withAccordianBorderStyle(String accordianBorderStyle) {
        this.accordianBorderStyle = accordianBorderStyle;
        return this;
    }
    
    public CssDataBuilder withAccordianPadding(String accordianPadding) {
        this.accordianPadding = accordianPadding;
        return this;
    }
    
    public CssDataBuilder withCarouselBackgroundColor(String carouselBackgroundColor) {
        this.carouselBackgroundColor = carouselBackgroundColor;
        return this;
    }
    
    public CssDataBuilder withCarouselBorderRaduis(String carouselBorderRaduis) {
        this.carouselBorderRaduis = carouselBorderRaduis;
        return this;
    }
    
    public CssDataBuilder withCarouselMargin(String carouselMargin) {
        this.carouselMargin = carouselMargin;
        return this;
    }
    
    public CssDataBuilder withCarouselPadding(String carouselPadding) {
        this.carouselPadding = carouselPadding;
        return this;
    }
    
    public CssDataBuilder withCarouselTextAlign(String carouselTextAlign) {
        this.carouselTextAlign = carouselTextAlign;
        return this;
    }
    
    public CssDataBuilder withFloatingTabBackgroundColor(String floatingTabBackgroundColor) {
        this.floatingTabBackgroundColor = floatingTabBackgroundColor;
        return this;
    }
    
    public CssDataBuilder withFloatingTabRadius(String floatingTabRadius) {
        this.floatingTabRadius = floatingTabRadius;
        return this;
    }
    
    public CssDataBuilder withFloatingTabCursor(String floatingTabCursor) {
        this.floatingTabCursor = floatingTabCursor;
        return this;
    }
    
    public CssDataBuilder withFloatingTabFontFamily(String floatingTabFontFamily) {
        this.floatingTabFontFamily = floatingTabFontFamily;
        return this;
    }
    
    public CssDataBuilder withFloatingTabTextAlign(String floatingTabTextAlign) {
        this.floatingTabTextAlign = floatingTabTextAlign;
        return this;
    }
    
    
}
