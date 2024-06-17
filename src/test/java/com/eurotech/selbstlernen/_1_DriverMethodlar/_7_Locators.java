package com.eurotech.selbstlernen._1_DriverMethodlar;

public class _7_Locators {
    /*

    6 adet LOCATORS vardir

    1- By.id(“uniqueId”)

    - Web elementi tanimlamak icin ilk bakacagimiz locator id olabilir. Id genellikle uniquedir.
    - Unique locator’i tespit edilen web element kullanilmak icin, driver objesi ile LOCATE edilip,
      WebElement class’indan olusturulan objeye atanmalidir. yani direkt yazdirilamaz

    ***** driver.findElement() METHODU **********+
    WebElement amazonAramaKutusu = driver.findElement(By.locator (“uniqueLocatorDegeri”);
    - bir tane eleman döndürür
    - return Type'i WebElement'tir.
    - Driver, findElement( ) ile objeyi bulamazsa "NoSuchElementException" verir.
    - webElement bir obje oldugu icin direk yazdirilamaz, hazir method’lar kullanilarak manipule edilebilir.

    2- By.name(“uniqueName”) - az kullaniliyor

    -  WebElement’in HTML kodlarinda name attribute’u varsa ve unique ise locate etmek icin By.name( ) kullanilabilir.

    3- By.classname(“uniqueClassValue”)

    -!!!! class attribute’u genellikle benzer ozellikleri barindiran web elementleri gruplandirmak icin kullanilir.
    - Bu sebeple class attribute’u ile yapacagimiz locate islemleri genellikle 1 web element degil, birden fazla element döndürür.
    - bu elementleri store edebilmek icin bir web element degil, web elementlerden olusan bir list gereklidir.
    - NOT : class value’sunde bosluk (space) varsa By.classname ile locate islemlerinde sorunlar yasanabilir.

     *****driver.findElements(…..) methodu*******-

    - birden fazla element oldugu icin icin "driver.findElement" degil, bu kullaniliyor
    - Locator’a uygun tüm web elementlerini döndürür.
    - findElements( ) birden fazla web element döndürebileceği için dönen elementleri store etmek için bır list kullanılmalıdır
    - yani return type'i List<WebElement> ' tir
    - Locator’a uyan hicbir webelement olmasa da exception olusmaz, bos bir liste döndürür
    - List’teki tüm elementler web element oldugu için direk yazdırılamaz, bir for-each loop kullanılarak
      elementlere istenen işlemler yapılabilir

   4- By.tagname(“tagValue”) - kompleks bir sitede cok tercih edilmez.ayni olan cok oldugu icin bulmakcok cok zordur.
    - Bir web sayfasinda herhangi bir tagName’in unique olmasi nadiren karsilasilabilir bir durumdur. bir sürü ayi tagname vardir yani.
    - Tag ismi ile yapilan locate’ler unique bir elemente ulasmaktan daha cok sayfadaki tum link’leri bulmak gibi amaclarla kullanilabilir.
    - Birden fazla web element döndürecegi icin driver.findelements(..) ile kullanilmasi daha cok karsilasilan bir durumdur

   5- By.linkText(“linkYazisininTamami”)
   - sadece link olmasi gerekir kullanmak icin. yani tag'inin a olmasi lazim mesela.

   6- By.partialLinkText(“linkYazisininBirBolumu”

    - Sadece link’ler icin kullanilabilirler.
    - Her link uzerinde bulunan yazi kullanilarak locate yapmamizi saglar.
    - Link uzerinde bulunan yazi String data turunde oldugundan case sensite’dir.
    - By.linkText ( ) icin bosluklar da dikkate alinarak tum metin yazilmalidir.
    - Tum metnin yazilamamasi, yazinin kismi olarak kullanilmasi isteniyorsa By.partialLinkText ( ) kullanilmalidir


     */
}
