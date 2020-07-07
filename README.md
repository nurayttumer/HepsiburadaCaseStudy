# HepsiburadaCaseStudy
Bu projede Hepsiburada tarafından verilen task oluşturulmuş olup senaryoların Page Object Model kullanılarak koşulması sağlanmıştır. </br></br>

## Proje Özellikleri </br>
* Webdriver ları projede eklenmiştir. Driver versiyon uyuşmazlığı durumunda aynı isim ile src/test/resources/ altında güncellenmelidir.

* Test sırasında hata ile karşılaşıldığı zamanda ekran görüntüsü kaydetmektedir. Ekran görüntüleri src/test/resources/failImages altında tutulmaktadır. Konsoldaki ekran görüntüsü adına göre hata alınan durum gözlemlenebilir.

* Annotasyonlar ve assertionlar için JUnit kütüphanesi kullanılmıştır.

* Proje Java dilinde Selenium frameworku ile geliştirilmiştir . 

## Hepsiburada Task İsterleri  </br>
** Kullanıcı hepsiburada.com sitesini ziyaret eder.  </br>
** Kullanıcı arama işlemi yapar (Örnek: “iphone” gibi popüler ve yorumu olan bir ürün)  </br>
** Kullanıcı arama sonucunda gelen ürün listesinden ürün seçer ve ürün detay sayfasına gider.  </br>
** Kullanıcı seçilen ürün için ürün detayda “Yorumlar” tabına gider.  </br>
** Kullanıcı gelen yorumlar içerisinde ilk yorumun “Evet” butonuna basar.  </br>
** Kullanıcı “Teşekkür Ederiz” yazısını görür.  </br>
** Kullanıcı eğer yorumlar tab’ında hiç yorum gelmiyorsa herhangi bir işlem yapmaz.  </br>
Notlar:   </br>
** Test yazılırken okunabilirlik, isimlendirmeler, kod tekrarı gibi standartlara dikkat edilmelidir.   </br>
** Testler herhangi bir platformda yazılabilir(Java-Selenium,Ruby-Capybara,Python-Robot Framework gibi  </br>
