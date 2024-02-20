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
</details>
