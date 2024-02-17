- `val` ile `var` arasındaki fark nedir?

- `val` ve `var` arasındaki fark, değişkenin değiştirilebilirliğidir. `val` ile tanımlanan
  değişkenler değiştirilemezken, `var` ile tanımlanan değişkenler değiştirilebilir.*(Val read-only
  yani değeri okunabilir ama set edilemez.)
- 
- Bir `var` değişkeni `val` gibi davranmasını nasıl sağlayabiliriz `val` kelimesini kullanmadan?
  Bunu neden yapmak isteriz? Örnek bir senaryo verin.

 Bir var değişkeninin set fonksiyonunu private yaparak val gibi davranmasını sağlayabiliriz.
 var name =yunus
 private yunus

- "Değişmez" (Immutable) ve "Salt Okunur" (ReadOnly) kavramlarını açıklayın. `val` değişkenler neden
  
- aslında "değişmez" değil de "salt okunur" olarak açıklanmalıdır?
  Değişmez (Immutable), değerini istediğimiz kadar değiştiremedğimiz anlamına gelir. ReadOnly ise,
  değeri okunabilen ama set edilemeyen anlamına gelir

- "Tip Çıkarımı" (Type inference) kavramını açıklayın. Hangi durumlarda tip belirtmek kesin olarak
  gereklidir?
  Bir değişkeni oluştururken değer atamasını yaparsak, değişken tipini belirtmeye gerek yoktur.
  Ancak, değişkene değer ataması başlangıçta yapmacak isek tipini belirtmek gerekiyor
-
- Kotlin'de tüm değişkenlerin sınıf olarak bulunması, "ilkel tip" (primitive type) olmadıkları
  anlamına gelir mi? Arka planda neler oluyor?
  Kotlin'de class gibi gözüken değişken tipleri özel optimizasyonlarla byte code'a çevrilirken yine primitive olacak şekilde tanımlanırlar.
      ı
- "Tip Güvenliği" (Type Safety) kavramını açıklayın.
   Bir değerin null olabileceği durumları ele alır ve bu null değerlerin beklenmedik hatalara yol açmasını önler.

    Type Safety bir programlama dilinde oluşturduğumuz değişkenlerin tipinin yanlış belirtilmesini engelleyen bir özelliktir.

- Bir değişkeni nullable yapmak için ne yapmalıyız?
  
 "?" işareti, bu değişkenin null değer alabileceğini belirtir.
  var nullableString: String? = null

- "Null Güvenliği" (Null Safety) kavramını açıklayın.
    Null güvenliği, bir değişkenin null olabileceği durumları ele alır ve bu null değerlerin beklenmedik hatalara yol açmasını önler.
- Bir değişkene null değer atanır ve tip belirtilmezse Kotlin bu değişkeni nasıl yorumlar?
.
  Bir değerin null olabileceği durumları ele alır ve bu null değerlerin beklenmedik hatalara yol açmasını önler.
   nothing olarak ifade eder.
- İlkel bir değişkenin nullable olması ile null değer alamaması arasında bellek yönetimi açısından
  nasıl farklar vardır?
  
 null deger için bellek kulanımı artar,null olmayan gerçek degeri tutat


  Nullable Değişkenler Bellekte Ek Alan Kullanır,Nullable Değişkenler Referansları İçin Ek Kontrol Gerektir

- Nullable bir değişkenin bir değere sahip olması ile null olması arasında bellek yönetimi açısından
  nasıl bir fark vardır? Null değer almış bir değişken bellekte yer kaplamaz diyebilir miyiz?
- 
- Nullable bir değişkenle çalışırken hangi operatörleri kullanırız? Bu operatörlerin kullanım
  farkları nelerdir? Hangisini ne zaman kullanmak daha anlamlıdır?

