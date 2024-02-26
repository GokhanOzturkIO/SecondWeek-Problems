# 1- Temel Türler & Null Güvenliği

## 1.1- `val` ile `var` arasındaki fark nedir?
val: Bir kere değer ataması yapıldıktan sonra değeri sadece okunabilir. Tekrardan değer ataması yapılamaz. Read only diye geçer. <p>
var: Değerine istenildiği kadar tekrardan atama yapılabilir. Re-assignable olarak geçer.

## 1.2- Bir `var` değişkeni `val` gibi davranmasını nasıl sağlayabiliriz `val` kelimesini kullanmadan? Bunu neden yapmak isteriz? Örnek bir senaryo verin.
Bir class içerisinde var olarak kullanılan değişkenin set method'unu private yaparak val'a benzetebiliriz. Bu şekilde class içerisinde değişkenin değeri değiştirilebilir fakat class dışından değeri okunabilirken değiştirilemez. Bunu tam olarak anlattığım şekilde dışarından sadece değerinin okunması fakat değiştirilmemesi için kullanabiliriz.

## 1.3- "Değişmez" (Immutable) ve "Salt Okunur" (ReadOnly) kavramlarını açıklayın. `val` değişkenler neden aslında "değişmez" değil de "salt okunur" olarak açıklanmalıdır?
Immutable: Değişkenin değerinin asla değişmemesi, değiştirilememesi anlamına gelir. <p>
ReadOnly: Değişkenin değerinin sadece okunabileceği anlamına gelir. <p>
val değişkenlerin get metodu override edilerek alınabilecek değer farklı değişkenlere bağlanabilir bu durumda val değişkenleri ReadOnly diye adlandırmak daha doğru olur.

## 1.4- "Tip Çıkarımı" (Type inference) kavramını açıklayın. Hangi durumlarda tip belirtmek kesin olarak gereklidir?
Type inference: Kullandığımız programlama dilinde veri tipini açık olarak belirtmediğimiz(explicit) durumlarda veri tipinin otomatik olarak belirlenmesidir. <p>
- Number tipindeki değişkenlerde virgülsüz bir sayı yazıyorsak otomatik olarak "Int" olarak algılanır fakat biz farklı tiplerde veri kaydetmek istiyorsak bu tipi açıkça belirtmek durumundayız. Aynı şekilde eğer virgüllü bir sayı yazıyorsak bu sayıyı "Double" tipinde algılar bu durumda da eğer float olarak bir değişken kullanmak istiyorsak bunu belirtmemiz gerekiyor. <p>
- Değişkenin değerini daha sonradan atayacaksak tipini belirtmemiz gerekir. <p>
- Bir değişkeni oluşturduğumuz class'ın parent'ının aynı seviyedeki child'ına daha sonradan eşitleyeceksek değişkenin tipini bu parent olarak göstermemiz gereklidir.

## 1.5- Kotlin'de tüm değişkenlerin sınıf olarak bulunması, "ilkel tip" (primitive type) olmadıkları anlamına gelir mi? Arka planda neler oluyor?
Kotlin'de primitive tipler doğrudan oluşturulamaz. Bu tiplerin class'ları primitive tiplerin wrapper class'ları olarak geçer ve bu tipleri özel optimizasyonlar ile sınıf olarak kullanmamızı sağlar.

## 1.6- "Tip Güvenliği" (Type Safety) kavramını açıklayın.
Bir değişkenin belirtilen tipten başka bir tipte değerle atanmasının engellenmesidir. Örnek vermek gerekirse başlangıçta "int" olarak belirtilen bir değişkene sonrasında "String" bir değer atanmaya çalışılırsa derleme zamanında hata alırsınız.

## 1.7- Bir değişkeni nullable yapmak için ne yapmalıyız?
Nullable yapmak istediğimiz değişkenin tipini explicit olarak belirtip tipinin sonuna "?" koymamız gereklidir. <p>
Örnek vermek gerekirse: <p>
val/var [variable_name]: [type]? = [value] <p>
```kotlin
val number: Int? = 10
val number2: Int? = null
```

## 1.8- "Null Güvenliği" (Null Safety) kavramını açıklayın.
Null gelebilme durumunu yazdığımız dilin dikkate alıp buna göre bizi önlem almaya zorlamasıdır. <p>
Null Safety'nin olmadığı dillerde NullPointerException hatasıyla sıkça karşılaşırız bu hata ile sıkça karşılaşmamızın sebebi dilin null'a özel önlemler almamasıdır. NullPointerException hatası Null olan bir değişkenle Null değilmiş gibi işlem yapmaya çalıştığımız zaman karşımıza çıkar. Tabi ki null safety olan dillerde bu hata alınabilir ama bu hatayı almak için null gelebilecek durumları göz ardı edip kod yazmamız gerekiyor fakat bu önerilen bir yazım tarzı değil.

## 1.9- Bir değişkene null değer atanır ve tip belirtilmezse Kotlin bu değişkeni nasıl yorumlar?
Kotlin bu değişkeni type inference ile Nothing? olarak belirler. Nothing type'ı genelde fonksiyonların dönüşlerinde sonuçların hata olarak yakalanması amacı ile kullanılır. "Nothing?" ifadesi ise sadece null olarak bir değer saklamak istiyorsak kullanabileceğimiz bir type olabilir.

## 1.10- İlkel bir değişkenin nullable olması ile null değer alamaması arasında bellek yönetimi açısından nasıl farklar vardır?
Bu duruma ilk başta şu şekilde yaklaşabiliriz: null değer alabilen değişken fazladan bir özelliğe sahip olduğu için bellek kullanımı daha fazla olur. <p>
Eğer daha detaylı incelersek kotlin'de oluşturulan nullable bir primitive type'ın byte Code'da karşılığı Java'nın integer class'ı olurken, kotlin'de primitive type'ın byte Code'da karşılığı doğrudan primitive type oluyor. <p> Bu durum bizi primitive type ve reference type farkını incelemeye itiyor: primitive type'lar doğrudan değeri saklarken, reference type'lar bellekte bir değere işaret eden bir referansı saklar. Bu nedenle, bellek kullanımı, erişim hızı ve davranış açısından iki tür arasında farklılıklar vardır. İlkel türler genelde daha hızlıdır çünkü doğrudan bellek adresinde depolanır ve işlenirler.

## 1.11- Nullable bir değişkenin bir değere sahip olması ile null olması arasında bellek yönetimi açısından nasıl bir fark vardır? Null değer almış bir değişken bellekte yer kaplamaz diyebilir miyiz?
Referans tipli değişkenler null ile atandığı zaman heap kısmında gösterdikleri bir şey olmadığı anlamına gelir fakat her iki durumda da stack kısmında bu referans için yer tutulur.

## 1.12- Nullable bir değişkenle çalışırken hangi operatörleri kullanırız? Bu operatörlerin kullanım farkları nelerdir? Hangisini ne zaman kullanmak daha anlamlıdır?
"?.", "!!" ve "?:" operatörlerini kullanabiliriz.
- "?." Safe call operator: Eğer ifademiz null değilse işlem yapar fakat null ise bu işlemi gerçekleştirmez.
- "!!" Not-null assertion operator: İfademizin null gelmeyeceğini garanti eder fakat kullanılması tavsiye edilmez. Null-safety özelliğine uygun olmayan durumlar yaratabilir.
- "?:" Elvis Operator: ifademiz null gelirse bu operatörden sonra yapılacak işleri yazabiliriz.

Safe call operatörü null gelmediği durumlarda kodumuzun olağan akışında çalışması için kullanılabilir. Elvis operatörü ile beraber kullanmak uygun olacaktır çünkü null geldiği durumda da farklı işlemler yaptırmak isteyebiliriz. <p>
Not-null assertion operatörü ise gelecek ifadenin null olmadığını garanti etmemiz gereken durumlarda kullanılabilir fakat kullanırken dikkat etmek gerekir çünkü bu şekilde garanti ettiğimiz değer eğer null gelirse NullPointerException ile karşılaşmamız mümkündür.
