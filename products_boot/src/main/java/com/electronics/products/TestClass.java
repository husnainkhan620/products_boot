package com.electronics.products;

public class TestClass {

	public static void main(String[] args) {
	
		System.out.println("<div class='row'>");
		for(int i=0;i<30;i++)
		{
			System.out.println("<div class='sm-2'>"+i+"</div>");
				if(i!=0 & i%5 == 0){
					System.out.println("</div>");
					System.out.println("<div class='row'>");
					
				}
		}
		System.out.println("</div>");

	}

}
