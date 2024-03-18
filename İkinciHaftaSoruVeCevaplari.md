### Temel Türler & Null Güvenliği

1. `val` ile `var` arasındaki fark nedir?
    val (value) değerler salt okunur değerlerdir ve ilk atamadan sonra başka bir değer ataması yapılamaz. Ancak değeri başka değişkenlere bağlı ise bağlı olduğu değişkenler değiştiğinde val'ın da değeri değişir. var (variable) ise değerleri değiştirilebilen değişkenlerdir.

2. Bir `var` değişkeni `val` gibi davranmasını nasıl sağlayabiliriz `val` kelimesini kullanmadan? Bunu neden yapmak isteriz? Örnek bir senaryo verin.
    Bir `var` değişkeninin `val` gibi davranmasını yani yeniden atama yapılmamasını sağlamak için setter fonksiyonunu private yaparız. Kotlin'de bir sınıf içinde tanımladığımız değişkenler aslında Java tarafında property'lere denk geldiği için ve varsayılan olarak private ile enkapsüle edilmiş olduğu için setter fonksiyonuna müdahale ederek onun hiç değiştirememesini sağlayabiliriz. Örneğin:

    ```kotlin
    class Cat() {
        var name: String = "Stray cat"

        var pawAmount: Int = 4
            private set

        fun setPawAmount(amount: Int) { // değişkeni bir fonksiyon yardımıyla daha güvenli bir şekilde değiştirmesini sağlayabiliriz.
            if(amount <4) {
                // hata ver
                println("Not enought paws, sorry!")
            } else {
                // kabul et
                pawAmount = amount
            }
        }
    }

    fun main() {
        val cat = Cat()

        cat.pawAmount = 3 // Değiştirmeye izin vermeyecek, hata verecektir.
        
        cat.setPawAmount(5) // Bu yöntemde değiştirmesine izin verebiliriz.
    }
    ```
 
3. "Değişmez" (Immutable) ve "Salt Okunur" (ReadOnly) kavramlarını açıklayın. `val` değişkenler neden aslında "değişmez" değil de "salt okunur" olarak açıklanmalıdır?
4. "Tip Çıkarımı" (Type inference) kavramını açıklayın. Hangi durumlarda tip belirtmek kesin olarak gereklidir?
5. Kotlin'de tüm değişkenlerin sınıf olarak bulunması, "ilkel tip" (primitive type) olmadıkları anlamına gelir mi? Arka planda neler oluyor?
6. "Tip Güvenliği" (Type Safety) kavramını açıklayın.
7. Bir değişkeni nullable yapmak için ne yapmalıyız?
8. "Null Güvenliği" (Null Safety) kavramını açıklayın.
9. Bir değişkene null değer atanır ve tip belirtilmezse Kotlin bu değişkeni nasıl yorumlar?
10. İlkel bir değişkenin nullable olması ile null değer alamaması arasında bellek yönetimi açısından nasıl farklar vardır?
11. Nullable bir değişkenin bir değere sahip olması ile null olması arasında bellek yönetimi açısından nasıl bir fark vardır? Null değer almış bir değişken bellekte yer kaplamaz diyebilir miyiz?
12. Nullable bir değişkenle çalışırken hangi operatörleri kullanırız? Bu operatörlerin kullanım farkları nelerdir? Hangisini ne zaman kullanmak daha anlamlıdır?

### Sayılar
- Kaç farklı tipte "number" sınıfı miras alan "alt sınıf" (child class) vardır? Bunların değer aralıkları neden önemlidir?
- Eğer bir değişkene tip belirtimi yapılmaz ve bir değer atanırsa, Kotlin tip çıkarımını nasıl yapar?
- Float değişken oluştururken `F` ve `f` harfleri varken, Long değişken oluştururken neden küçük `l` harfi yoktur?
- Tek duyarlıklı (Single precision) ve Çift duyarlıklı (Double precision) kavramlarını açıklayın.
- Double ve Float değişkenlerle çalışırken ondalık ayıracı olarak hangi işaretler kullanılır? Bu ayıraçların kullanımında nelere dikkat etmek gerekir?
- Double ve Float değişkenler ondalık kısımda kaç basamağa kadar işlem yaparlar? Bu sınırın üzerinde gelen ondalık bilgileri için nasıl davranırlar? Hangi durumlar için Float ve hangi durumlar için Double kullanılmalıdır?
- Ondalık(Decimal), Onaltılık (Hexadecimal) ve İkilik (Binary) değişkenleri Kotlin'de nasıl tanımlayabilirsiniz?
- Sekizlik (Octal) değişkenler Java'da nasıl tanımlanır? Kotlin'de Sekizlik değişken tanımlanabilir mi?
- "Geleneksel Notasyon" (Conventional Notation) gösterimi nasıl yapılır?
- Sayısal değişkenlerde alt çizgi (underscore) nasıl kullanılır? Kotlin bunu nasıl yorumlar?
- `==` ile neyi karşılaştırırız? `===` ile neyi karşılaştırırız?
- `===` operatörü ile karşılaştırma yaparken Byte değer aralığı neden önemlidir? Kotlin bu aralığa göre neden özel bir davranış sergiler?
- Sayısal değişkenlerde hangi matematiksel operatörler kullanılabilir?
- Sayısal değişkenlerde hangi karşılaştırma operatörleri kullanılabilir?
- Bit düzeyinde operatörler (Bitwise operators) nelerdir? Ne amaçla kullanılır? Kotlin'de bunları nasıl kullanabilirsiniz?
- Kotlin'de büyük sayılarla çalışırken hangi ek türlerden yararlanılır ve bu türlerin sınırları nelerdir?
- Double ve Float değişkenler kullanılırken "yuvarlama" davranışı nasıldır? Bu nasıl değiştirilebilir?

### İşaretsiz Sayılar
- "İşaretsiz" (Unsigned) değişkenler ne demektir? İşaretli olanlarla aralarındaki fark nedir?
- "İşaretsiz" değişkenler nasıl bir sınıf yapısında tutulurlar? Bu neden önemlidir?
- "İşaretsiz" değişkenlerin harf gösterimi nasıldır?
- "`val a1 = 42u` ve `val a2 = 0xFFFF_FFFF_FFFFu`" değişkenlerin tipleri ne olur? Neden?
- "İşaretsiz" "Long" harf gösterimi nasıl yapılır?
- "İşaretsiz" değişkenlerin kullanım amaçları nelerdir?
- "İşaretsiz" değişkenlerle yapılan matematiksel işlemlerde, özellikle büyük sayılarla çalışırken karşılaşılabilecek taşma (overflow) ve taşma olmaması (underflow) durumları için Kotlin nasıl bir yönetim sağlar?
- "İşaretsiz" değişkenlerin sınırlamaları nelerdir?
- "İşaretsiz" değişken türleri (UInt, ULong vs.) kullanırken, Java API'leri ile uyumluluk konusunda ne gibi sorunlar olabilir? Bunları çözmek için neler yapabilirsiniz?

### Tür Dönüşümü
- `is` ve `!is` operatörlerinin kullanımını açıklayın.
- "Akıllı Dönüşüm" (Smart Cast) ne demektir? Farklı kod örnekleri ile açıklayın. Bu özelliğin sınırlamaları nelerdir?
- "Güvenli & Güvensiz" operatörler nelerdir?
- Sayısal değişkenlerde örtük tip genişletme (implicit widening conversions) ne demektir? Kotlin'de bu neden yapılamaz?
- "`val b: Byte = 1` ile `val i: Int = b` ve son olarak `print(b == i)` gibi bir kod yazıldığında çıktı ne olur? Neden böyle bir çıktı aldığınızı açıklayın.
- "`val b: Byte = 1` ile `val i: Int = b.toInt()` ve son olarak `print(b == i)` gibi bir kod yazıldığında çıktı ne olur? Neden böyle bir çıktı aldığınızı açıklayın.
- Sayısal değişkenlerde açık dönüşüm (Explicit Type Conversion) yaparken hangi fonksiyonları kullanabilirsiniz?
- "`val result = 1L + 3`" // "Long + Int" gibi bir işlemin sonucunda "result" değişkeninin tipi ve değeri ne olur? Neden böyle olduğunu açıklayın.
- "`val result = Int.MAX_VALUE + Int.MAX_VALUE`" gibi bir işlemin sonucunda "result" değişkeninin tipi ve değeri ne olur? Neden böyle olduğunu açıklayın.
- "`val x = 5 / 2` `println(x == 2)`" gibi bir işlemin sonucu ve tipi nedir? Neden böyle olduğunu açıklayın.
- "`val x = 5L / 2` `println(x == 2L)`" gibi bir işlemin sonucu ve tipi nedir? Neden böyle olduğunu açıklayın.
- "`val x = 5 / 2.toDouble()` `println(x == 2.5)`" gibi bir işlemin sonucu ve tipi nedir? Neden böyle olduğunu açıklayın.
- Kotlin'de tür dönüşümü yapılırken, dönüşümün başarısız olması durumunda TypeCastException nasıl ele alınır ve bu tür hataların önüne geçmek için hangi önlemler alınabilir?