<details open>
    <summary>Temel Türler & Null Güvenliği</summary>
        <details>
            <summary>
            val ile var arasındaki fark nedir?
            </summary>
            `val` keyword'ü read-only değişkenler tanımlamamıza, `var` keyword'ünü ise içeriğini değiştirmek istediğimiz değişkeni tanımlarken kullanırız.
        </details>
        <details>
            <summary>
            Bir `var` değişkeni `val` gibi davranmasını nasıl sağlayabiliriz `val` kelimesini kullanmadan? Bunu neden yapmak isteriz? Örnek bir senaryo verin.
            </summary>
            Bir `var` keyword'ü ile tanımlanan değişkenin, `val` keyword'ü ile tanımlanmış gibi davranmasını istiyorsak değişkenin set metodunu private olarak tanımlarız. Bunu da yapmak istememizdeki sebep de, projenin başka bir yerinde yani değişkenin bulunduğu class'ın dışında değişkenin değerini değiştirtmek istemememizdir.
            </br>
            Örneğin;

```kotlin
import java.time.LocalDate
import java.time.Period
class Human(){
    var birthDate: LocalDate = LocalDate.of(1998, 2, 4)
    var age: Int = Period.between(birthDate, LocalDate.now()).years
        get() = Period.between(birthDate, LocalDate.now()).years
        private set
}
fun main(){
    val human = Human()
    println(human.birthDate)
    println(human.age)
    // human.age = 22 //Human class'ının age propertysi `var` olmasına rağmen set metodunun erişim belirleyicisi private olduğu için direkt değiştiremiyoruz.
    human.birthDate = LocalDate.of(2002, 2, 4)
    println(human.birthDate)
    println(human.age)
}
```
</br>
        </details>
        <details>
            <summary>
            "Değişmez" (Immutable) ve "Salt Okunur" (ReadOnly) kavramlarını açıklayın. val değişkenler neden aslında "değişmez" değil de "salt okunur" olarak açıklanmalıdır?
            </summary>
            Immutable ifadesi bir değişkenin içerdiği değerin asla değiştirilemeyeceği anlamına gelirken, Read-Only ifadesi ise bir değişkenin set metodunun olmaması anlamına gelir ve get metodunun da döndürdüğü değeri vermesine denir.
            </br>
            Bunu bir örnekle açıklamaya çalışacak olursak;
            
```kotlin
import java.time.LocalDate
import java.time.Period
class Human(){
    var birthDate: LocalDate = LocalDate.of(1998, 2, 4)
    val age: Int
    	get() = calculateAge()
    	// private set // val property'nin setterı olamaz.
    
    fun calculateAge() = Period.between(birthDate, LocalDate.now()).years
}
fun main(){
    val human = Human()
    println(human.birthDate)
    println(human.age)
    human.birthDate = LocalDate.of(2002, 2, 4)
    println(human.birthDate)
    println(human.age)
}
```
   Yukarıdaki örneği inceleyecek olursak `val` keyword'ü ile tanımlanan age değişkeni belirli bir hesaplamanın sonucuna göre içerdiği değer değiştirilebilir. Bu sebeple `val` read-only'dir diyebilmekteyiz.
        </details>
        <details>
            <summary>
            "Tip Çıkarımı" (Type inference) kavramını açıklayın. Hangi durumlarda tip belirtmek kesin olarak gereklidir?
            </summary>
            Type inference kavramı, değişkene değer atanırken derleyici tarafından atanan değerin tipinin anlaşılmasıdır. Nullable bir değer ataması yapacağımız zaman bunu açıkça belirtmeliyiz.
        </details>
        <details>
            <summary>
            Kotlin'de tüm değişkenlerin sınıf olarak bulunması, "ilkel tip" (primitive type) olmadıkları anlamına gelir mi? Arka planda neler oluyor?
            </summary>
            Kotlin dilinde tüm değişkenler sınıf olarak bulunur doğru, ancak değişken nullable değil ise ve primitive tip karşılığı da var ise derleme esnasında yapılan optimizasyon sayesinde ürettiği byte code ile aynı kodun javada primitive tip ile yazılabilen kodun ürettiği byte code'una eş değerdir.
        </details>
        <details>
            <summary>
            "Tip Güvenliği" (Type Safety) kavramını açıklayın.
            </summary>
            Type Safety, program derlenirken değişken tiplerinin doğru aralıkta değer alıp almadığını kontrol eder.
            Örneğin;
            ```var str: String = null // str değişkenimiz nullable olmadığından dolayı programın derlenmesi esnasında type safety gereğince programcı hata alacaktır..``` 
            ```var num: Int = "str".toIntOrNull() // num değişkeni sadece `Number` kabul ettiği için bu örnekte de derlenme sırasında hata alırız.```
        </details>
        <details>
            <summary>
            Bir değişkeni nullable yapmak için ne yapmalıyız?
            </summary>
            Bir değişkeni nullable bir değişken olarak tanımlamak istiyorsak, tanımladığımız değişken tipinin yanına soru işareti (?) koyarız.
            Örneğin;
            ```var nonNullInt: Int = 5 // non-null değişken tanımı```
            ```var nullableInt: Int? = null // nullable değişken tanımı```
        </details>
        <details>
            <summary>
            "Null Güvenliği" (Null Safety) kavramını açıklayın.
            </summary>
            Nullable olarak tanımlanan değişkenin runtime esnasında uygulamanın/projenin çökmemesine sebebiyet vermemesi için null referans sorununun ele alındığı duruma Null Safety denir.
        </details>
        <details>
            <summary>
            Bir değişkene null değer atanır ve tip belirtilmezse Kotlin bu değişkeni nasıl yorumlar?
            </summary>
            Tip çıkarımı yapılamadığı için `Nothing?` olarak tipi belirlenir ve o değişkene bir daha `null` değer dışında atama yapılamayacağı için o değişken `null` olarak kalmaya devam eder.
        </details>
        <details>
            <summary>
            İlkel bir değişkenin nullable olması ile null değer alamaması arasında bellek yönetimi açısından nasıl farklar vardır?
            </summary>
            Nullable bir primitive değişken null bir değer tutabileceği için yani null olabilme ihtimali yüzünden bellekte daha fazla yer kaplar. Non-null değişkenler için ise bu yer ayrılmaz. Bu sebeple non-null değişken tipinin bellekte tutulmasının daha performanslı olduğu söylenebilir.
        </details>
        <details>
            <summary>
            Nullable bir değişkenin bir değere sahip olması ile null olması arasında bellek yönetimi açısından nasıl bir fark vardır? Null değer almış bir değişken bellekte yer kaplamaz diyebilir miyiz?
            </summary>
            Nullable değişkenler referans tipli oldukları için içerisinde bir değer barındırmasa bile adresleri belleğin stack kısmında tutulur. Değişkenin bir değeri olmadığı için belleğin heap kısmı boştur. Sonuç olarak nullable bir değişken içerisinde değer barındırsada barındırmasada bellekte yer kaplar. İçerisinde bir değer varsa daha fazla yer kaplar.
        </details>
        <details>
            <summary>
            Nullable bir değişkenle çalışırken hangi operatörleri kullanırız? Bu operatörlerin kullanım farkları nelerdir? Hangisini ne zaman kullanmak daha anlamlıdır?
            </summary>
            Üç farklı operatör kullanırız. Bunlar; `?.` (Safe Call Operator), `?:` (Elivs Operator) ve `!!` (Not-Null Assertion Operator) operatörleridir.
            `?.` (Safe Call Operator) : nullable bir değişkenin null olup olmadığını kontrol eder ve değişken null değilse işlem yapar. Bu, null referanslarını güvenli bir şekilde işlemek için kullanılır ve null olma durumunda hata almayı önler.
            `?:` (Elivs Operator) : null olabilen bir değişkenin null olması durumunda varsayılan bir değer döndürmek/atamak için kullanılır. Bu, değişkenin null olması durumunda bir varsayılan değeri kullanmanın kısa bir yolunu sağlar.
            `!!` (Not-Null Assertion Operator) : nullable değişkenin null olmadığına dair bir garanti verir. Bu operatörü kullanarak, bir nullable değişkenin değerini non-nullable olarak kabul ederiz ve eğer değişken null ise bir NullPointerException alırız.
        </details>
</details>
<details open>
    <summary>Sayılar</summary>
        <details>
            <summary>
            Kaç farklı tipte "number" sınıfı miras alan "alt sınıf" (child class) vardır? Bunların değer aralıkları neden önemlidir?
            </summary>
            Number sınıfını miras alan 6 adet child class vardır. Bunlar; `Byte`, `Short`, `Int`, `Long`, `Float` ve `Double` sınıflarıdır.
            Byte 8 bit yer kaplar. Değer aralığı ise -128'den +127'ye kadardır.</br>
            Short 16 bit yer kaplar. Değer aralığı ise -32768'den +32767'ye kadardır.</br>
            Int 32 bit yer kaplar. Değer aralığı ise -2,147,483,648'den +2,147,483,647'ye kadardır.</br>
            Long 64 bit yer kaplar. Değer aralığı ise -9,223,372,036,854,775,808'den +9,223,372,036,854,775,807'ye kadardır.</br>
            Float 32 bit yer kaplar. Değer aralığı ise 1.40129846432481700e-45F'den 3.40282346638528860e+38F'e kadardır.</br>
            Double 64 bit yer kaplar. Değer aralığı ise 4.94065645841246544e-324'den 1.79769313486231570e+308'e kadardır.
        </details>
        <details>
            <summary>
            Eğer bir değişkene tip belirtimi yapılmaz ve bir değer atanırsa, Kotlin tip çıkarımını nasıl yapar?
            </summary>
            Bir değişkene tip belirtimi yapılmadığında ve bir değer atanırsa, Kotlin derleyicisi, atanan değere bakarak uygun veri türünü çıkarır. Örneğin atanan değer bir sayı ise bunun hangi değer aralığında olduğuna göre derleyici değişkenin tipini belirler.
        </details>
        <details>
            <summary>
            Float değişken oluştururken F ve f harfleri varken, Long değişken oluştururken neden küçük l harfi yoktur?
            </summary>
            Bazı fontlarda küçük l harfi 1 sayısına benzediği için karmaşıklığı engellemek için alınan önlem olarak düşünülebilir.
        </details>
        <details>
            <summary>
            Tek duyarlıklı (Single precision) ve Çift duyarlıklı (Double precision) kavramlarını açıklayın.
            </summary>
            Tek duyarlıklı (Single Precision) ve Çift duyarlıklı (Double Precision), kayan noktalı sayıları temsil etme yöntemleridir. Tek duyarlıklı format, 32 bitlik bir bellek alanında depolanırken, çift duyarlıklı format 64 bitlik bir bellek alanında depolanır. Çift duyarlıklı format, daha büyük bir veri aralığına ve daha yüksek bir kesinliğe sahipken, tek duyarlıklı format daha küçük bir veri aralığı ve daha düşük bir kesinlik sunar. Bu nedenle, kullanılan uygulamanın gereksinimlerine ve bellek / performans dengesine bağlı olarak tercih edilirler.
        </details>
        <details>
            <summary>
            Double ve Float değişkenlerle çalışırken ondalık ayıracı olarak hangi işaretler kullanılır? Bu ayıraçların kullanımında nelere dikkat etmek gerekir?
            </summary>
            Bazı ülkelerde ondalık ayıraç olarak nokta işareti kullanılırken, bazılarında virgül kullanılır. Bu nedenle, uygulamanın kullanılacağı hedef kitlenin coğrafi konumuna bağlı olarak uygun ondalık ayıraçlarının kullanılması önemlidir. Kotlin'de, ondalık sayılar varsayılan olarak Double türüne atanır. Float türünde bir değer atanmak istenirse, sayının sonuna f veya F harfi eklenmelidir. Bu, derleyicinin sayının Float türü olduğunu anlamasını sağlar.
        </details>
        <details>
            <summary>
            Double ve Float değişkenler ondalık kısımda kaç basamağa kadar işlem yaparlar? Bu sınırın üzerinde gelen ondalık bilgileri için nasıl davranırlar? Hangi durumlar için Float ve hangi durumlar için Double kullanılmalıdır?
            </summary>
            Float: 32 bitlik bellek alanında depolanır. Yaklaşık olarak 6-7 basamağa kadar kesinlik sağlar. Daha küçük bir veri aralığı ve daha düşük bir kesinlik sunar. Bellek tasarrufu veya hız gereksinimi olan işlemlerde kullanılabilir.
            Double: 64 bitlik bellek alanında depolanır. Yaklaşık olarak 15 basamağa kadar kesinlik sağlar. Daha büyük bir veri aralığı ve daha yüksek bir kesinlik sunar. Bilimsel hesaplamalar finansal işlemler gibi yüksek kesinlik gerektiren alanlarda tercih edilir.
        </details>
        <details>
            <summary>
            Ondalık(Decimal), Onaltılık (Hexadecimal) ve İkilik (Binary) değişkenleri Kotlin'de nasıl tanımlayabilirsiniz?
            </summary>
            Ondalık sayılar, varsayılan olarak Kotlin'de tanımlanır. Örnek olarak:</br>
            val decimalNumber: Int = 42
            </br>---</br>
            Onaltılık sayıları tanımlamak için sayının başına 0x ön eki eklemeniz gerekir. Örnek olarak:</br>
            val hexadecimalNumber: Int = 0x2A
            </br>---</br>
            İkilik sayıları tanımlamak için sayının başına 0b ön eki eklemeniz gerekir. Örnek olarak:</br>
            val binaryNumber: Int = 0b101010
        </details>
        <details>
            <summary>
            Sekizlik (Octal) değişkenler Java'da nasıl tanımlanır? Kotlin'de Sekizlik değişken tanımlanabilir mi?
            </summary>
            Java'da sekizlik (octal) sayıları tanımlamak için sayının başına 0 ön eki eklemeniz gerekir. Ancak Kotlin'de bu doğrudan desteklenmez. Örneğin, Java'da sekizlik bir sayıyı tanımlamak için:</br>
            int octalNumber = 052; // Bu 42 ondalık sayısına karşılık gelir
        </details>
        <details>
            <summary>
            "Geleneksel Notasyon" (Conventional Notation) gösterimi nasıl yapılır?
            </summary>
            Geleneksel notasyonu aşağıdaki gibi basitçe oluştururken;
            val num1 = 0.42 // 0.42
            Bilimsel notasyonlu tanımlamayı aşağıdaki gibi tanımlarız;
            val num2 = 4.2*10e-2 // 0.42
            İkisininde çıktısı aynı. Bilimsel hesaplamaları projemizde kullanmayacaksak gelenksel tanımlamayı yapmak daha efektif olacaktır.
        </details>
        <details>
            <summary>
            Sayısal değişkenlerde alt çizgi (underscore) nasıl kullanılır? Kotlin bunu nasıl yorumlar?
            </summary>
            Kotlin'de sayısal değerlerde alt çizgi (underscore) kullanımı, sayıları daha okunabilir hale getirmek için kullanılan bir biçimlendirme tekniğidir. Bu, özellikle büyük sayılarla çalışırken veya sayıları gruplara bölerken faydalı olabilir. Sayıları daha kolay anlaşılabilir hale getirmek için alt çizgilerle binlik gruplara ayırabilirsiniz. Örneğin:</br>
            val population = 7_874_965_825</br>
            val pi = 3.141_592_653
        </details>
        <details>
            <summary>
            "==" ile neyi karşılaştırırız? "===" ile neyi karşılaştırırız?
            </summary>
            "==" operatörü ile iki değişkenin içerisinde barındığı değerin aynı olup olmadığını, "===" operatörü ile de iki değişkenin memory'de aynı adresi referans edip etmediğini kontrol ederiz.
        </details>
        <details>
            <summary>
            "===" operatörü ile karşılaştırma yaparken Byte değer aralığı neden önemlidir? Kotlin bu aralığa göre neden özel bir davranış sergiler?
            </summary>
            Kotlin Byte aralığı içerisindeki bir değeri tutan değişkenlerin adreslerini tek bir yer işaret edecek şekilde optimize eder. Bunun nedeni sık kullanılan sayıları tek bir yerde tutarak memory kullanımını azaltmayı amaçlar.
        </details>
        <details>
            <summary>
            Sayısal değişkenlerde hangi matematiksel operatörler kullanılabilir?
            </summary>
            Toplama operatörü (+) : Toplama işlemi yapar.</br>
            Çıkarma operatörü (-) : Çıkarma işlemi yapar.</br>
            Çarpma operatörü (*) : Çarpma işlemi yapar.</br>
            Bölme operatörü (/) : Bölme işlemi yapar.</br>
            Mod alma operatörü (%) : Birinci sayının ikinci sayıya bölümünden kalanı hesaplar.
        </details>
        <details>
            <summary>
            Sayısal değişkenlerde hangi karşılaştırma operatörleri kullanılabilir?
            </summary>
            Büyüktür (>): Sol tarafındaki değerin sağ tarafındakinden büyük olup olmadığını kontrol eder.</br>
            Büyük Eşittir (>=): Sol tarafındaki değerin sağ tarafındakine eşit veya büyük olup olmadığını kontrol eder.</br>
            Küçüktür (<): Sol tarafındaki değerin sağ tarafındakinden küçük olup olmadığını kontrol eder.</br>
            Küçük Eşittir (<=): Sol tarafındaki değerin sağ tarafındakine eşit veya küçük olup olmadığını kontrol eder.</br>
            Eşittir (==): İki değerin birbirine eşit olup olmadığını kontrol eder.</br>
            Eşit Değildir (!=): İki değerin birbirine eşit olmadığını kontrol eder.</br>
            Referans Eşittir (===) : İki değişkenin referans ettiği adresin aynı olup olmadığını kontrol eder.</br>
            Referans Eşit Değildir (!==) : İki değişkenin referans ettiği adresin aynı olmadığını kontrol eder.</br>
            is: Bir nesnenin belirli bir tipe ait olup olmadığını kontrol eder.</br>
            !is: Bir nesnenin belirli bir tipe ait olmadığını kontrol eder.
        </details>
        <details>
            <summary>
            Bit düzeyinde operatörler (Bitwise operators) nelerdir? Ne amaçla kullanılır? Kotlin'de bunları nasıl kullanabilirsiniz?
            </summary>
                AND (&): İki biti AND işlemine tabi tutar. İki bit de 1 ise sonuç 1 olur, aksi halde sonuç 0 olur.</br>
                OR (|): İki biti OR işlemine tabi tutar. En az bir bit 1 ise sonuç 1 olur, aksi halde sonuç 0 olur.</br>
                XOR (^): İki biti XOR işlemine tabi tutar. İki bit farklı ise sonuç 1 olur, aynı ise sonuç 0 olur.</br>
                NOT (~): Bir bitin tersini alır. Yani, 0 ise 1 yapar, 1 ise 0 yapar.</br>
                Left Shift (<<): Bir sayıyı belirtilen sayıda bit sola kaydırır.</br>
                Right Shift (>>): Bir sayıyı belirtilen sayıda bit sağa kaydırır.</br></br>
                val a = 0b1010 // 10</br>
                val b = 0b1100 // 12</br>
                val resultAnd = a and b // 8</br>
                val resultOr = a or b // 14</br>
                val resultXor = a xor b // 6</br>
                val resultNot = a.inv() // -11 (içerideki bit sayısına bağlı olarak tüm bitleri ters çevirir)</br>
                val leftShiftResult = a shl 2 // 40 (101000)</br>
                val rightShiftResult = b shr 1 // 6 (110)</br>
        </details>
        <details>
            <summary>
            Kotlin'de büyük sayılarla çalışırken hangi ek türlerden yararlanılır ve bu türlerin sınırları nelerdir?
            </summary>
            Kotlin'de büyük sayılarla çalışırken genellikle `BigInteger` ve `BigDecimal` gibi ek türlerden yararlanılır. Bu türler, standart veri türlerinin sınırlarını aşan büyük sayılarla çalışmak için kullanılır.</br>
            BigInteger, tam sayılar için kullanılır ve sınırsız büyüklükte tamsayı değerlerini temsil eder.</br>
            Örnek: val bigInt = BigInteger("1234567890123456789012345678901234567890")
            </br>---</br>
            BigDecimal, ondalık sayılar için kullanılır ve yüksek hassasiyete sahip hesaplamalar yapmak için kullanılır.</br>
            BigDecimal değerleri, sayısal ifadelerin sonuna "BD" veya "bd" ekleyerek oluşturulabilir.</br>
            Örnek: val bigDecimal = BigDecimal("1234567890.12345678901234567890BD")
        </details>
        <details>
            <summary>
            Double ve Float değişkenler kullanılırken "yuvarlama" davranışı nasıldır? Bu nasıl değiştirilebilir?
            </summary>
            Kotlin'de Double ve Float veri türlerindeki varsayılan yuvarlama davranışı IEEE 754 standartlarına uygundur. Ancak, farklı yuvarlama stratejileri gerektiren durumlarda, özel işlevler veya matematiksel kütüphaneler kullanılabilir. Örneğin, round(), ceil(), floor() gibi işlevler, sayıları belirli yuvarlama stratejilerine göre yuvarlar:</br>
            round(): En yakın tam sayıya yuvarlar.</br>
            ceil(): En yakın üst tam sayıya yuvarlar.</br>
            floor(): En yakın alt tam sayıya yuvarlar.</br>
            Bu işlevler, belirli yuvarlama stratejilerini uygulamak için kullanılabilir.
        </details>
</details>
<details open>
    <summary>
    İşaretsiz Sayılar
    </summary>
        <details>
            <summary>
            "İşaretsiz" (Unsigned) değişkenler ne demektir? İşaretli olanlarla aralarındaki fark nedir?
            </summary>
            İşaretsiz değişkenler, 0 veya pozitif sayıları barındırabilen değişken türleridir.
        </details>
        <details>
            <summary>
            "İşaretsiz" değişkenler nasıl bir sınıf yapısında tutulurlar? Bu neden önemlidir?
            </summary>
            İşaretsiz (unsigned) değişkenler, Kotlin'de "value class" olarak tanımlanır. Bu, değerlerinin bellekte primitive tipler gibi saklandığı anlamına gelir. Bu yapı, işaretsiz sayıların doğrudan bellek tarafından tutulmasını sağlar, bu da daha performanslı ve daha az bellek tüketen işlemler gerçekleştirmelerini sağlar. Bu, işaretsiz sayıların daha verimli bir şekilde kullanılmasını sağlar.
        </details>
        <details>
            <summary>
            "İşaretsiz" değişkenlerin harf gösterimi nasıldır?
            </summary>
            Bir "işaretsiz" değişken tanımlaması yapmak istiyorsak atadığımız değerin sonuna 'u' veya 'U' harfini koymalıyız. Örneğin;</br>
            val unsignedInt = 42u</br>
            val signedInt = 4
        </details>
        <details>
            <summary>
            "val a1 = 42u ve val a2 = 0xFFFF_FFFF_FFFFu" değişkenlerin tipleri ne olur? Neden?
            </summary>
            Tip çıkarımı(Type Inference)'na göre 42 Integer veri tipi aralığında olduğu ve sonunda `u` harfi olduğu için a1 değişkenin tipi UInt'dir.</br>
            Aynı şekilde tip çıkarımı(type inference)'na göre 0xFFFF_FFFF_FFFF sayısı Integer değer aralığını aşıp Long değer aralığına girdiği için ve sonunda `u` harfi olduğu için a2 değişkenin tipi ULong'dur.
        </details>
        <details>
            <summary>
            "İşaretsiz" "Long" harf gösterimi nasıl yapılır?
            </summary>
            "İşaretsiz" "Long" harf gösterimini `uL` veya `UL` harflerini kullanarak yaparız.
        </details>
        <details>
            <summary>
            "İşaretsiz" değişkenlerin kullanım amaçları nelerdir?
            </summary>
            İşaretsiz (unsigned) değişkenlerin kullanım amaçları:</br>
            Bellek Tasarrufu: İşaretsiz değişkenler, yalnızca pozitif değerleri temsil eder ve işaretli değişkenlere göre daha geniş bir pozitif aralığı kapsar. Bu durum, bellek kullanımını azaltır.</br>
            Veri Doğruluğu: Belirli durumlarda, bir değişkenin negatif olamayacağı veya belirli bir sınıra kadar olabileceği bilinir. İşaretsiz değişkenler, bu tür kısıtlamaları belirlemek ve veri doğruluğunu artırmak için kullanılabilir.
        </details>
        <details>
            <summary>
            "İşaretsiz" değişkenlerle yapılan matematiksel işlemlerde, özellikle büyük sayılarla çalışırken karşılaşılabilecek taşma (overflow) ve taşma olmaması (underflow) durumları için Kotlin nasıl bir yönetim sağlar?
            </summary>
            Kotlin, işaretsiz değişkenlerle yapılan matematiksel işlemlerde taşma (overflow) ve taşma olmaması (underflow) durumları için otomatik bir yönetim sağlamaz. Bu durum, programcıların bu tür durumları kontrol etmesi ve gerektiğinde uygun önlemleri alması gerektiğini gösterir. İşaretsiz değişkenlerin sınırlarını aşma riski bulunduğundan, büyük sayılarla çalışırken dikkatli olunmalı ve sonuçlar kontrol edilmelidir. Bu önlemler, beklenmedik sonuçları ve hatalı hesaplamaları önlemeye yardımcı olabilir.
        </details>
        <details>
            <summary>
            "İşaretsiz" değişkenlerin sınırlamaları nelerdir?
            </summary>
            UByte Min Value : 0 - UByte Max Value : 255</br>
            UShort Min Value : 0 - UShort Max Value : 65535</br>
            UInt Min Value : 0 - UInt Max Value : 4294967295</br>
            ULong Min Value : 0 - ULong Max Value : 18446744073709551615</br>
        </details>
        <details>
            <summary>
            "İşaretsiz" değişken türleri (UInt, ULong vs.) kullanırken, Java API'leri ile uyumluluk konusunda ne gibi sorunlar olabilir? Bunları çözmek için neler yapabilirsiniz?
            </summary>
            İşaretsiz (unsigned) değişken türleriyle (UInt, ULong vb.) Java API'leri arasında uyumluluk sorunları ortaya çıkabilir. Bu sorunların başlıca nedeni, Kotlin'deki işaretsiz değişkenlerin kullanımıyla Java'nın işaretli tamsayılarının kullanımı arasındaki farklılıklardır. Kotlin'deki işaretsiz değişkenler taşma (overflow) durumlarını otomatik olarak ele almadığından, büyük sayılarla yapılan işlemlerde Java API'leriyle uyumsuzluklar meydana gelebilir. Bu tür uyumluluk sorunlarını çözmek için uygun veri türlerinin seçilmesi, veri dönüşümlerinin yapılması ve dikkatli kodlama ve test süreci izlenmesi önemlidir. Bu yaklaşımlar, işaretsiz değişkenlerin Java API'leriyle uyumlu bir şekilde kullanılmasını sağlayabilir.
        </details>
</details>
<details open>
    <summary>
    Tür Dönüşümü
    </summary>
        <details>
            <summary>
            `is` ve `!is` operatörlerinin kullanımını açıklayın.
            </summary>
            `is` operatörü, bir nesnenin belirli bir türde olup olmadığını kontrol eder.  
            `!is` operatörü ise bir nesnenin belirli bir türde olmadığını kontrol eder.  
        </details>
        <details>
            <summary>
            "Akıllı Dönüşüm" (Smart Cast) ne demektir? Farklı kod örnekleri ile açıklayın. Bu özelliğin sınırlamaları nelerdir?
            </summary>
            Smart cast, bir değişkenin tipinin otomatik olarak dönüştürülmesidir. Örneğin aşağıdaki kodda if şartı sağlanırsa `any` değişkeninin bir String olduğu o if scope'u boyunca bilinecek ve String metotları kullanılabilir hale gelecektir.</br>
<code>
fun main() {
    val any: Any = "Hello"
    if (any is String){
        println(any.length)
    }
}
</code>
        </details>
        <details>
            <summary>
            "Güvenli & Güvensiz" operatörler nelerdir?
            </summary>
            Güvensiz Dönüşüm (`as` Operatörü): Bir nesneyi belirli bir tipe dönüştürmek için kullanılır. Ancak, dönüşüm başarısız olursa `ClassCastException` hatası alınır ve program çökebilir. Örnek:</br>
<code>
val x: String = y as String // Bu dönüşüm güvensizdir ve hata meydana gelirse program çökebilir.
</code>
</br>
            Güvenli Dönüşüm (`as?` Operatörü): Bir nesneyi belirli bir tipe güvenli bir şekilde dönüştürmek için kullanılır. Dönüşüm başarısız olursa, `null` değeri dönüşür ve programın çökmesi önlenir. Örnek:</br>
<code>
val x: String? = y as? String // Bu güvenli bir dönüşümdür, dönüşüm başarısız olursa x'e null atanır ve program çökmez.
</code>
        </details>
        <details>
            <summary>
            Sayısal değişkenlerde örtük tip genişletme (implicit widening conversions) ne demektir? Kotlin'de bu neden yapılamaz?
            </summary>
            Implicit widening conversions, değer aralığı daha küçük olan değişken tipinin, değer aralığı daha büyük olan değişken tipine dönüştürülmesine denir. Örneğin Byte tipinde olan bir değişkenin değerinin Short tipinde bir değişkene atanmasıdır. Bu Kotlin'de ancak explicit şekilde yani açık bir şekilde .toShort() gibi dönüştürme metotlarıyla gerçekleştirilebilir.
        </details>
        <details>
            <summary>
            `val b: Byte = 1` ile `val i: Int = b` ve son olarak `print(b == i)` gibi bir kod yazıldığında çıktı ne olur? Neden böyle bir çıktı aldığınızı açıklayın.
            </summary>
            Compile error alırız. Çünkü Kotlin programlama dilinde bir değişkenin tipine uygun şekilde değer ataması yapılmalıdır. Atanan değişken değeri açıkça `cast` edilmelidir. `b` değişkeninin değeri `i` değişkenine atanırken açık bir şekilde Int tipine dönüştürülseydi atanırken bir sorun yaşanmayacaktı. if içerisindeki değişken tiplerinin karşılaştırılabilmesi için aynı tipte olması gerektiğini düşünecek olursak aynı `cast` işlemi burada da yapılmalıydı.
        </details>
        <details>
            <summary>
            "val b: Byte = 1 ile val i: Int = b.toInt() ve son olarak print(b == i) gibi bir kod yazıldığında çıktı ne olur? Neden böyle bir çıktı aldığınızı açıklayın.
            </summary>
            Bir üstteki soruda cevabı vermiştik aslında. Ancak burada da belirtelim; if içerisinde karşılaştırılan sayı değerleri tutan değişken tiplerinin aynı olması gerekir.
        </details>
        <details>
            <summary>
            Sayısal değişkenlerde açık dönüşüm (Explicit Type Conversion) yaparken hangi fonksiyonları kullanabilirsiniz?
            </summary>
            Açık dönüşüm (explicit type conversion) için Kotlin'de kullanılan fonksiyonlar şunlardır:</br>
            
1. `toByte()`: Bir sayısal değeri `Byte` türüne dönüştürür.
2. `toShort()`: Bir sayısal değeri `Short` türüne dönüştürür.
3. `toInt()`: Bir sayısal değeri `Int` türüne dönüştürür.
4. `toLong()`: Bir sayısal değeri `Long` türüne dönüştürür.
5. `toFloat()`: Bir sayısal değeri `Float` türüne dönüştürür.
6. `toDouble()`: Bir sayısal değeri `Double` türüne dönüştürür.

Bu fonksiyonlar, belirtilen sayısal türler arasında açık bir dönüşüm yapmak için kullanılır ve Kotlin'in güvenli tür dönüşümü politikasını takip eder.
        </details>
</details>