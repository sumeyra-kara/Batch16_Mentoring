package com.eurotech.selbstlernen._3_Waits_Cookies_WebTables;

public class _1_Waits {
    /*
    Driver ile cihaz veya internet arasinda yasanan senkronizasyon sorunlarini çözmek icin driver’i
    belirli yontemler ile bekletmek(wait) gerekir.
    1 ) Java tabanli wait
    * Thread.sleep : Javadan gelir ve kodlari yazilan sure kadar bekletir.
    Sure dolduktan sonra alt satirdan isleme devam eder

    2 ) Selenium tabanli wait’ler
    * Implicitly Wait: Sayfadaki tüm öğeler için global bir zaman aşımıdır(timeout).
    * Explicitly Wait: Çoğunlukla belirli öğeler için belirli bir koşul(expected condition) için kullanılır

    Otomasyon yaparken sayfanin yüklenmesi ve webElementlerin bulunmasi icin gerekli süreyi implicitly wait ile ayarlariz
    - Implicitly wait, sayfanin yüklenmesi ve her bir web elementinin bulunmasi icin tanimlanan mac. bekleme süresidir.
    her islem icin sifirdan baslar ve max süre doluncaya kadar görevi tamamlamaya calisir.
    max süre icerisinde görev tamamlanamazsa exception cerip calismyai durdurur.
    - Testlerin büyük cogunlugunda implicitly wait süresi senkronizasyonu saglamak icin yeterli olur. Ancak özel bir görev icin
    implicitly wait'de tanimlanan max. bekleme süresinden daha fazla beklememiz gerekirse o göreve özgü tek seferlik bir wait olusturabiliriz


     */
}
