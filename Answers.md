<details open>
    <summary>Temel Türler & Null Güvenliği</summary>
        <details>
            <summary>val ile var arasındaki fark nedir?</summary>
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
</details>
