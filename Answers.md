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
Number tipindeki değişkenlerde virgülsüz bir sayı yazıyorsak otomatik olarak "Int" olarak algılanır fakat biz farklı tiplerde veri kaydetmek istiyorsak bu tipi açıkça belirtmek durumundayız. Aynı şekilde eğer virgüllü bir sayı yazıyorsak bu sayıyı "Double" tipinde algılar bu durumda da eğer float olarak bir değişken kullanmak istiyorsak bunu belirtmemiz gerekiyor. <p>
Değişkenin değerini daha sonradan atayacaksak tipini belirtmemiz gerekir. <p>
Bir değişkeni oluşturduğumuz class'ın parent'ının aynı seviyedeki child'ına daha sonradan eşitleyeceksek değişkenin tipini bu parent olarak göstermemiz gereklidir.
