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

# 2- Sayılar

## 2.1- Kaç farklı tipte "number" sınıfı miras alan "alt sınıf" (child class) vardır? Bunların değer aralıkları neden önemlidir?
Number parent class'ını miras alan 6 tane child class vardır, bunlar: "Byte", "Short", "Int", "Long", "Float", "Double" olarak adlandırılır. <p>
Bu değişkenlerin değer aralıları saklayacağımız veriler açısından ve bellek yönetimi açısından önemlidir. Değeri çok fazla olamayacak bir değişken için default olarak type inference ile atanan "Int" class'ını kullanmak bellek yönetimi açısından doğru değildir. Bunun yanında yine aynı şekilde atanacak "Int" tipinin değer aralığından daha büyük sayılar ile çalışacaksak "Int" ile çalışmaya devam edersek beklediğimiz sonuçları alamayız.

## 2.2- Eğer bir değişkene tip belirtimi yapılmaz ve bir değer atanırsa, Kotlin tip çıkarımını nasıl yapar?
Type inference: Kotlin derleyicisinin atamanın sağ tarafındaki değerlere bakarak değişkenin tipini belirlemesi işlemidir. <p>
Sayılar için bu durum şu şekide işler: Eğer sayı int aralığından küçük ise değişken Int olarak belirlenir. Eğer büyük ise Long olarak belirlenir. Virgüllü bir sayı ise Double olarak belirlenir.

## 2.3- Float değişken oluştururken `F` ve `f` harfleri varken, Long değişken oluştururken neden küçük `l` harfi yoktur?
Küçük "l" bazı fontlarda "1" ile benzediği için böyle bir kullanım yoktur.

## 2.4- Tek duyarlıklı (Single precision) ve Çift duyarlıklı (Double precision) kavramlarını açıklayın.
Sign bit: İşaret biti yani sayının pozitif ya da negatif olduğunu belirtir. <p>
Exponent bit: Üs biti olarak geçer sayının tam sayı kısmını temsil eder. <p>
Fraction bit: Kesir biti olarak geçer sayının virgüllü kısmını temsil eder. <p>
Single precision: 1 sign bit + 8 bit exponent + 23 bit fraction = 32 bitle ifade edilen virgüllü sayılardır. <p>
Double precision: 1 sign bit + 11 bit exponent + 52 bit fraction = 64 bitle ifade edilen virgüllü sayılardır.

## 2.5- Double ve Float değişkenlerle çalışırken ondalık ayıracı olarak hangi işaretler kullanılır? Bu ayıraçların kullanımında nelere dikkat etmek gerekir?
Programlama dillerinde genelde Double ve Float'da ondalık ayıracı olarak "." kullanır. Bu değişkenlerde yerelleştirme yaparken, kullanıcıdan veri alıp işlerken ya da veritabanından veri alırken farklı ayıraç kullanımlarına da dikkat etmek gerekiyor.

## 2.6- Double ve Float değişkenler ondalık kısımda kaç basamağa kadar işlem yaparlar? Bu sınırın üzerinde gelen ondalık bilgileri için nasıl davranırlar? Hangi durumlar için Float ve hangi durumlar için Double kullanılmalıdır?
Float ondalık kısımda yaklaşık olarak 6 basamağa kadar işlem yaparken Double yaklaşık 15 basamağa kadar işlem yapabilir. <p>
Bu değişkenlerin hesaplamaları IEEE 754 standartlarına göre yapıldığı için sınırları üstünde gelen işlemler için davranışları değişiklik gösterir bunun için bu [yazıyı](https://arshadsuraj.medium.com/java-floating-point-numbers-rounding-problem-solution-a07e019b9dd5) inceleyebilirsiniz. <p>
İşlem hassasiyetinin fazla olduğu işlemlerde Double, az olduğu işlemlerde ise Float kullanabiliriz.

## 2.7- Ondalık(Decimal), Onaltılık (Hexadecimal) ve İkilik (Binary) değişkenleri Kotlin'de nasıl tanımlayabilirsiniz?
```kotlin
val decimalNumber = 187 // Sayı farklı bir işlem yapılmadan yazılırsa dil tarafından Decimal olarak algılanır.
val hexadecimalNumber = 0xBB // "0x" ile başlanarak yazılan ifadeler Hexadecimal olarak algılanır.
val hexaDecimalNumber2 = 0Xbb //  Harf ifadeler küçük ya da olarak yazılabilir.
val bitNumber = 0b10111011 // "0x" ile başlanarak yazılan ifadeler binary olarak algılanır.
val bitNumber2 = 0B10111011 // "b" büyük ya da küçük yazılabilir.
```
Yukarıdaki değişkenlerin hepsi Decimal'de 187'ye karşılık gelmektedir.

## 2.8- Sekizlik (Octal) değişkenler Java'da nasıl tanımlanır? Kotlin'de Sekizlik değişken tanımlanabilir mi?
```java
Integer y = 0273; // Atanan değerin başına "0" eklenirse sayı Octal olarak algılanır.
```
Yukarıdaki değişkenin Decimal karşılığı 187'dir. <p>
Kotlin dilinde Octal değişken tanımlanamaz.

## 2.9- "Geleneksel Notasyon" (Conventional Notation) gösterimi nasıl yapılır?
Matematiksel ifadelerin geleneksel kurallara uygun gösterilmesidir.
Scientific notation'ın aksine anlaşılması daha kolaydır çünkü ilk ve ortaöğretimde aldığımız eğitimlerin tamamını Conventional Notation'a uygun alırız.

## 2.10- Sayısal değişkenlerde alt çizgi (underscore) nasıl kullanılır? Kotlin bunu nasıl yorumlar?
Sayısal değişkenlerin okunabilirliğini arttırmak için kullanılır. <p>
Derlendikten sonra altçizgiler yok sayılır. Bu çizgiler kod yazarken karışıklık yaşanmaması için rahatlıkla kullanılabilir.
```kotlin
val numberWithUnderscore = 123_456_789
```
