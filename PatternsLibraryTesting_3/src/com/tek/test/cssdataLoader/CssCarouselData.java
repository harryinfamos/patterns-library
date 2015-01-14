package com.tek.test.cssdataLoader;

public class CssCarouselData {
	
	private String carouselBackgroundColor;
    private String carouselBorderRaduis;
    private String carouselMargin;
    private String carouselPadding;
	private String carouselTextAlign;
	private String cssObjectName;

    public CssCarouselData(String cssObjectName,String carouselBackgroundColor,String carouselBorderRaduis, String carouselMargin, String carouselPadding, String carouselTextAlign) {
    	this.carouselBackgroundColor = carouselBackgroundColor;
    	this.carouselBorderRaduis = carouselBorderRaduis;
        this.carouselMargin = carouselMargin;
        this.carouselPadding = carouselPadding;
        this.carouselTextAlign = carouselTextAlign;
        this.cssObjectName = cssObjectName;
    }


	public String getCssObjectName() {
        return cssObjectName;
    }
    
    public String getCarouselBackgroundColor() {
        return carouselBackgroundColor;
    }
    
    public String getCarouselBorderRaduis() {
        return carouselBorderRaduis;
    }
    
    public String getCarouselMargin() {
        return carouselMargin;
    }
    
    public String getCarouselPadding() {
        return carouselPadding;
    }
    
    public String getCarouselTextAlign() {
        return carouselTextAlign;
    }


}
