package com.eurotech.selbstlernen._2_Xpath_CssSelector;

public class _2_Xpath {
    public static void main(String[] args) {
        /*
        Bir WebElement’i locate etmek icin kullanabilecegimiz en etkin yöntemdir

        WebElement webElement = driver.findElement(By.xpath("bulunan xpath"));

        Xpath de HTML kodu kullanir ancak farkli kombinasyonlar kullanabildigi icin dinamiktir ve
        her webelement icin mutlaka bir xpath bulunabilir.
        2 cesit Xpath yazilabilir
           1.Absolute xpath (mutlak)
           2.Relative xpath (bağıl) --- bizim daha cok kullanacagimiz bu

         !!! gorselin uzerine gelip, sag tus +  copy + xpath --- bize xpath verir ama saglikli degildir

         Bir web element’in 3 bileseni bulunur
         1- Tag : input
         2- Attributes : type, id, value, name, autocomplete, placeholder, class, dir, tabindex, aria-label
         3- Attribute Values : text, twotabsearchtextbox, field-keywords …..

         Relative Xpath bu 3 bilesenin belirlenen sekilde birlikte kullanilmasi ile olusur. Her
         Xpath ile unique bir sonuc elde edilemeyebilir ancak unique bir deger mutlaka  bulunur.
         //tagName[@attributeIsmi=‘attributeValue']
         örnek :   //input[@type=´text`]
         mesela yazinca 3 tane cikiyor ama bana ikincisi gerekli ise    (//input[@type=´text`])[2] seklinde yazilir


         ** Bu 3 bilesenin hepsinin kullanilmasina gerek yoktur.
         Hedef unique olarak webelement’i locate etmektir.
         Daha az bilesenle de unique degere ulasilabilen Xpath’ler de kullanilabilir

         driver.findElement(By.xpath("//input"));  --- sadece tag ismi ile
         driver.findElement(By.xpath("//*[@type'text']"));  --- tag ismi farketmeksizin
         driver.findElement(By.xpath("//input[@*'text']"));  --- attribute farketmeksizin
         driver.findElement(By.xpath("//input[@type]"));  --- attribute value farketmeksizin







         */

    }
}
