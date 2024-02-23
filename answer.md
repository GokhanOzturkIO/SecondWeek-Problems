# 2. Hafta Ödevi - Kotlin

- Soruları cevaplamak için öncelikle bu repository'i kendi GitHub hesabınıza "Fork"layın.
- Daha sonra Forkladığınız kendi GitHub adresinizdeki repository'i yerel makinenize indirin.
- Kendi adınıza bir dal (branch) açın.
- Yeni bir metin dosyasına soruların cevaplarını yazın.
- Aşağıdaki algoritma sorusu için bir proje oluşturun ve çözümünü yapın.
- Yaptığınız tüm işlemleri olabildiğince atomik taahhütler (commits) halinde kaydedin ve mantıklı "İngilizce" taahhüt(commits) mesajları ekleyin.
- Tüm sorular ve algoritma projesi tamamlandığında taahhütleriniz(commits) arasındaki farkları incelemeye çalışın.
- Tüm işleminiz bittiğinde eklediğiniz tüm taahhütleri(commits) Forkladığınız GitHub'daki repository'e yükleyin (pushlayın).
- Kendi Forkladığınız GitHub'daki repository'de çözümleri gördükten sonra "[SecondWeek-Problems](https://github.com/GokhanOzturkIO/SecondWeek-Problems)" adresindeki orijinal repository'e "Pull Request" açın.
- Pull Request açtığınızı WhatsApp üzerindeki kanallardan duyurun.

- Diğer kullanıcılardan gelen dalları (branches) yerel makinenize indirmek için önce yereldeki projenizi güncelleyin (fetch) sonra ilgili dalları(branches) çekin (pull).
- Daha sonra diğer arkadaşlarınızın dallarına(branches) geçiş yaparak onların cevapları ile kendi verdiğiniz cevapları karşılaştırın.
- Daha iyisi olmak istiyorsanız, yeni öğrendiğiniz konularla ilgili bir Medium makalesi yazın ve makalenin bağlantısını cevapların en altına ekleyin.

###### **Sizler de derste anlatılanlar için ekstra soru eklemek istiyorsanız ve nasıl Pull Request göndereceğinizi öğrendiyseniz, bu dosyayı  güncelleyerek Pull Request atabilirsiniz.**
###### **Önemli not: bazı ifadeler -bilinçli olarak- hem türkçe hem ingilizce olarak yazılmıştır. Bazı ifadeler ise sadece ingilizce olarak bırakılmıştır. Lütfen bu konuda saçma dil milliyetçiliği yapmayınız. Neden böyle yaptığımızın sebeplerini yayınlarda anlatıyorum.**

---

### Temel Türler & Null Güvenliği

- `val` ile `var` arasındaki fark nedir?

Cevap : `val`, value kavramının kısatılmış hâlidir  ve read-only bir kavramdır. Başlangıçta bir değişken tanımladıktan sonra değişkene yeni bir atama yapamayız

`var`, variable kavramının kısaltılmış hâlidir. Bir atama yapıldıktan sonra değişkene farklı bir atama yapılabilir.

Not : val ve var arasında memoryde yer kaplama anlamındaki fark çok çok azdır. Akademik olarak bu fark çok çok az val'ın daha fazla yer kapladığı şekilde ifade edilir.(Val if ifade ettiği için) Pratikte ise var kullanımı daha az yer kaplar. Threading dediğimiz birden fazla iş ve çalışma kolunda var daha rahat bir kullanım sunar.

- Bir `var` değişkeni `val` gibi davranmasını nasıl sağlayabiliriz `val` kelimesini kullanmadan? Bunu neden yapmak isteriz? Örnek bir senaryo verin.
- "Değişmez" (Immutable) ve "Salt Okunur" (ReadOnly) kavramlarını açıklayın. `val` değişkenler neden aslında "değişmez" değil de "salt okunur" olarak açıklanmalıdır?

Cevap : Immutable kavramı "değişmez" demektir ve bir değişkene hiçbir şey tanımlanamaz. Read only ise ilk tanım yapılabilir fakat sonrasında değiştirme yapılmaz. Bu sebepten ötürü val read-only olarak tanımlanmalıdır. Çünkü val'da ilk değişken tanımlanır sonrasında değişmez.

- "Tip Çıkarımı" (Type inference) kavramını açıklayın. Hangi durumlarda tip belirtmek kesin olarak gereklidir?

Cevap : Type inference kavramı bir kodu yazarken o kodun hangi değişken türünü açıklamaya gerek olmaması durumudur. Örneğin var name = "ece" kullanımında Kotlin'de type inference olduğu için türünü String olarak belirtmemize gerek yoktur. Buna implict kullanım denir. var name: Strin = "ece" kullanımı ise explict bir kullanımdır. Ayrıca sayılarda type inference yapıldığında int sınırları içerisinde ise Integer,int'i aşarsa Long kullanılır.

- Kotlin'de tüm değişkenlerin sınıf olarak bulunması, "ilkel tip" (primitive type) olmadıkları anlamına gelir mi? Arka planda neler oluyor?

Cevap : Kotlin'de her şey class'dır. Fakat Kotlin'de olan optimizasyonlarla beraber sankş primitive'miş gibi davranır. Unutulmaması gereken bir husus da nullable yapılırsa bu değişkenin class olacağı

- "Tip Güvenliği" (Type Safety) kavramını açıklayın.

Cevap :Type Safety kavramı oluşturduğumuz bir değişkene başka türde bir değişken atayamama durumudur.
Örnek : `var a = 10` ifadesini yazdıktan sonra `a = "string"` yaparsak hata alırız.

Not : Double ve Integer toplamında da benzer bir durum bekleyebiliriz fakat bu şekilde yapıldığında herhangi bir hata alınmadı. Double sonucu verdi IDE. 
(Gemini aynı görüşte değil.) (ChatGPT bizimle aynı görüşte.)

- Bir değişkeni nullable yapmak için ne yapmalıyız?


Cevap : Nullable kavramı bir değişkenin null olabilmesi durumunda kullanılır. Bir değişkeni nullable yapmak için explict bir yaklaşım kullanmamız gerekir

Örneğin `var a = "Metin"` ifadesini nullable yapmak istiyorsak `var a : String? = "Metin"` şeklinde değişken türünün sonuna `?` koymamız gerekir.

- "Null Güvenliği" (Null Safety) kavramını açıklayın.

Cevap : Null Safety kavramı olası null değer alınması durumunda hata almamamak için kullanılan durumu ifade eder. Bunu yaparken örnek verecek olursak `var a:String = null` kullanılmasına izin verilmez. Soru işareti kullanılması gerekiyor. 

Exception hatası almamak için de `?.` veya `!!.` kullanmamız gerekiyor. `?.` kullanımını kullanırken yaptığımız iş kodda null varsa çalıştırma fakat hata da verme. `!!.` kullanımıda ise eğer null içeriyorsa excption hatası al ve uygulamayı çökert diyoruz.

- Bir değişkene null değer atanır ve tip belirtilmezse Kotlin bu değişkeni nasıl yorumlar?

Cevap : Nothing? dediğimiz bir değişken tipi olarak tanımlar.

- İlkel bir değişkenin nullable olması ile null değer alamaması arasında bellek yönetimi açısından nasıl farklar vardır?
- Nullable bir değişkenin bir değere sahip olması ile null olması arasında bellek yönetimi açısından nasıl bir fark vardır? Null değer almış bir değişken bellekte yer kaplamaz diyebilir miyiz?
- Nullable bir değişkenle çalışırken hangi operatörleri kullanırız? Bu operatörlerin kullanım farkları nelerdir? Hangisini ne zaman kullanmak daha anlamlıdır?

Cevap : `?.` veya `!!.` operatörlerini kullanabiliriz. `?.` kullanımını kullanırken yaptığımız iş kodda null varsa çalıştırma fakat hata da verme. `!!.` kullanımıda ise eğer null içeriyorsa excption hatası al ve uygulamayı çökert diyoruz.


### Sayılar
- Kaç farklı tipte "number" sınıfı miras alan "alt sınıf" (child class) vardır? Bunların değer aralıkları neden önemlidir?

Cevap : Number sınıfını miras alan byte,short,int,float olmak üzere 5 alt sınıf vardır. Bunların kapladıkları alan(bit sayısı) farklıdır ve duruma uygun belirtilmelidir.

- Eğer bir değişkene tip belirtimi yapılmaz ve bir değer atanırsa, Kotlin tip çıkarımını nasıl yapar?

Cevap : Integer aralığında ise integer,integer değer aralığını aşarsa Long yapar. Ondalıklı sayılarda ise otomatik olarak Double yapar.

- Float değişken oluştururken `F` ve `f` harfleri varken, Long değişken oluştururken neden küçük `l` harfi yoktur?

Cevap : Bazı fontlarda küçük L harfi 1(bir) sayısına benzediğinden olası karışıklıkların önüne geçmek için kullanılmaz

- Tek duyarlıklı (Single precision) ve Çift duyarlıklı (Double precision) kavramlarını açıklayın.
- Double ve Float değişkenlerle çalışırken ondalık ayıracı olarak hangi işaretler kullanılır? Bu ayıraçların kullanımında nelere dikkat etmek gerekir?

Cevap : .(nokta) ayıracını kullanmamız gerekiyor. Çünkü Uluslararası kabul gören ayıraç noktadır. Ancak Türkçe ve bazı dillerde "," belirtme ayıracı olduğundan bu göz ardı edilmemeli ve çeşitli hatalara hazırlıklı olmak gerekmektedir.

- Double ve Float değişkenler ondalık kısımda kaç basamağa kadar işlem yaparlar? Bu sınırın üzerinde gelen ondalık bilgileri için nasıl davranırlar? Hangi durumlar için Float ve hangi durumlar için Double kullanılmalıdır?

Cevap : Float yaklaşık 7, Double yaklaşık 16-17 basamağa kadar işlem yapar. Daha hassas işlemler için Double'ı tercih ederiz. Float 32, Double 64 bit bellek kullanır. Bu sebepten eğer hassas hesaplamalara ihtiyaç duymuyorsak Float kullanmak bellekte daha az yer kullandığından daha mantıklıdır.

- Ondalık(Decimal), Onaltılık (Hexadecimal) ve İkilik (Binary) değişkenleri Kotlin'de nasıl tanımlayabilirsiniz?

Cevap : Decimal zaten ondalıklı sayıyı ifade ettiğinden herhangi özel bir şey yapmamıza gerek yoktur. Hexadecimal için değişkenin başına `0x` eklenmelidir. Binary içinse `0b` eklenmesi gerekmektedir. Kotlin'de Type Inference olduğundan ötürü türü belirtmemize gerek yoktur fakat `Long` ve `Float` için tür belirtmemiz gerekmektedir. Çünkü Type inferince gereği tam sayılar `int` ondalıklı sayılar `double` şeklinde ifade edilir.

- Sekizlik (Octal) değişkenler Java'da nasıl tanımlanır? Kotlin'de Sekizlik değişken tanımlanabilir mi?

Cevap : Java'da octal sayıları tanımlamak için başına `0` eklememiz yeterlidir. Kotlin'de bir sayının başına 0 eklenmediğinden ötürü bu mümkün değildir. Ancak octal bir sayıyı kullanmanız gerekiyorsa bunun farklı şöyle bir yolu vardır:

Sayıyı önce `string` olarak tanımlıyoruz

`val octalString = "123" // Sekizlik sayı olarak düşünülen string`

`val decimalValue = octalString.toInt(8) // Sekizlikten ondalığa çevirme`

`println(decimalValue) // Çıktı: 83`

`toInt` fonksiyonu bir `radix` parametresi alır ve bu parametre sayesinde sekizlik sayıları işleyebilirsiniz.

Peki `radix` parametresi nedir : bir sayının tabanını belirlemek için kullanılır. Bir sayının tabanı, sayıyı temsil etmek için kullanılan basamak sayısını belirler.

Yukarıdaki örnekte parantez içerisinde kullandığımız sayı kaçlık sistemde çalışacağımızı ifade eder.

- "Geleneksel Notasyon" (Conventional Notation) gösterimi nasıl yapılır?
- Sayısal değişkenlerde alt çizgi (underscore) nasıl kullanılır? Kotlin bunu nasıl yorumlar?

Cevap : Underscore (_) genelde uzun basamaklı sayıların kaç basamaklı olduğunu daha rahat görmemizi sağlar. Örneğin 1000000 sayısını 1_000_000 şeklinde yazarsak daha kolay görmüş oluruz. Kotlin underscore'ları görmezden gelir yani sonuçd değişmez.

- `==` ile neyi karşılaştırırız? `===` ile neyi karşılaştırırız?

Cevap : `==` ile value yani değeri kıyaslarız. `===` ile değişkenin memorydeki adresini,bulunduğu konumu kıyaslarız.

- `===` operatörü ile karşılaştırma yaparken Byte değer aralığı neden önemlidir? Kotlin bu aralığa göre neden özel bir davranış sergiler?
- Sayısal değişkenlerde hangi matematiksel operatörler kullanılabilir?

Cevap : Toplama(+),Çıkarma(-),Çarpma(x),Bölme(/) ve mod(%) işlemleri kullanılabilir

- Sayısal değişkenlerde hangi karşılaştırma operatörleri kullanılabilir?

Cevap : >,< >=,<=,== ve != kullanılır

- Bit düzeyinde operatörler (Bitwise operators) nelerdir? Ne amaçla kullanılır? Kotlin'de bunları nasıl kullanabilirsiniz?

Cevap : &&(ve), ||(veya) vardır. İki değişkenin birbirine bağlı olduğu durumlarda kullanılır. Örneğin a değişkenin 10'dan büyük olduğu ve b değişkenin 3'den küçük olduğu durum.  

- Kotlin'de büyük sayılarla çalışırken hangi ek türlerden yararlanılır ve bu türlerin sınırları nelerdir?

Cevap : BigInteger ya da BigDecimal kullanılabilir. 

BigInteger: Sınırsız büyüklükte tamsayıları depolayabilir.

BigDecimal: Ondalık sayıları tam hassasiyetle temsil edebilir.

Dezavantajları daha fazla bellek kullanımı ve daha yavaş olmasıdır.

- Double ve Float değişkenler kullanılırken "yuvarlama" davranışı nasıldır? Bu nasıl değiştirilebilir?

Cevap : Kotlin'de varsayılan olan davranış küsüratlı kısmın atılmasıdır. Fakat bunu değiştirmenin metodları bulunmaktadır.

`roundTo(n): Ondalık basamakları belirli bir basamak sayısına kadar yuvarlar.`

`ceilToInt(): Ondalık sayıyı en yakın en büyük tam sayıya yuvarlar.`

`floorToInt(): Ondalık sayıyı en yakın en küçük tam sayıya yuvarlar.`

Bu fonksiyonlar sayesinde yuvarlama işlemleri yapılabilir.

### İşaretsiz Sayılar
- "İşaretsiz" (Unsigned) değişkenler ne demektir? İşaretli olanlarla aralarındaki fark nedir?

Cevap : Unsigned değişkenler mutlak değerce kullanılan değişkenlerdir. Örneğin `Byte` kavramı normalde -128 ile 127 arasındadır. Fakat Unsigned Byte kavramında 0 ile 255 arasında olur.

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

---

### ALGORİTMA SORUSU
Basit bir terminal (konsol) ekranı uygulaması yapacağız. Kullanıcıdan iki sayı alacak ve bu sayılar üzerinde işlem yapacak. Bu uygulamayı yazarken aşağıdaki kurallara dikkat ediniz:
- Kullanıcıyı bir selamlama ekranı ile karşılayın.
- Kullanıcıdan ilk sayıyı girmesini isteyin.
- Kullanıcıdan yapmak istediği matematiksel işlemin karakterini girmesini isteyin.
- Kullanıcıdan ikinci sayıyı isteyin.
- Kullanıcı ikinci sayıyı girdiğinde sonucu ekrana yazdırın ve devam etmek isteyip istemediğini sorun. Devam etmek isterse, karşılama mesajı olmadan 2. adımdan itibaren devam ettirin.

Uygulama yazılırken dikkat edilecek hususlar:
- İstisna Yönetimi (Exception Handling): olası yaşanabilecek problemleri önceden düşünün ve bunların neler olabileceğini ödevinize ekleyin.
- Bu istisnaları nasıl yönetebileceğinizi araştırın ve ek çözümler geliştirin.
- Yapabiliyorsanız kodunuzu fonksiyonlara bölerek, bu fonksiyonlar için testler yazmaya çalışın.
